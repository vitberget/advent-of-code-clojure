(ns year2022.day11.day11-part1
  (:require
    [utils.text :as ut]
    [ysera.test :refer [is is= is-not deftest]]
    [year2022.day11.day11-data :refer [day11-example day11-puzzle]]
    [clojure.string :as str]))

(defn words->operation
  [[v1 v2 v3]]
  [(if (= v1 "old") v1 (read-string v1))
   v2
   (if (= v3 "old") v3 (read-string v3))])

(defn last-word->number
  [words]
  (->> words
       (ut/line->words)
       (last)
       (read-string)))

(defn paragraph->state
  {:test (fn []
           (is= (paragraph->state "Monkey 0:\n  Starting items: 79, 98\n  Operation: new = old * 19\n  Test: divisible by 23\n    If true: throw to monkey 2\n    If false: throw to monkey 3")
                ;Monkey 0:
                ;  Starting items: 79, 98
                ;  Operation: new = old * 19
                ;  Test: divisible by 23
                ;    If true: throw to monkey 2
                ;    If false: throw to monkey 3
                {"0" {:items     [79 98]
                      :operation ["old" "*" 19]
                      :test      23
                      :if-true   "2"
                      :if-false  "3"
                      :inspected 0}}))}
  [paragraph]
  (let [lines (ut/text->lines paragraph)
        monkey-number (-> lines
                          (first)
                          (ut/line->words)
                          (second)
                          (str/replace ":" ""))
        items (->> lines
                   (second)
                   (ut/line->words)
                   (drop 4)
                   (map #(str/replace % "," ""))
                   (map read-string))
        operation (->> (nth lines 2)
                       (ut/line->words)
                       (drop 5)
                       (words->operation))
        test (->> (nth lines 3)
                  (last-word->number))
        if-true (->> (nth lines 4)
                     (ut/line->words)
                     (last))
        if-false (->> (nth lines 5)
                      (ut/line->words)
                      (last))]
    {monkey-number {:items     items
                    :operation operation
                    :test      test
                    :if-true   if-true
                    :if-false  if-false
                    :inspected 0}}))
(defn text->state
  [text]
  (->> text
       (ut/text->paragraphs)
       (map paragraph->state)
       (apply merge)))

(defn apply-operation
  [number [v1 v2 v3]]
  (let [v2 (condp = v2
             "*" *
             "/" /
             "-" -
             "+" +)]
    (-> (v2 (if (= v1 "old") number v1)
            (if (= v3 "old") number v3))
        (quot 3))))

(defn monkey-do
  [state monkey-id]
  (let [{operation :operation
         test      :test
         if-true   :if-true
         if-false  :if-false} (get state monkey-id)
        action-list-1 (->> (get-in state [monkey-id :items])
                           (map #(apply-operation % operation))
                           (map (fn [number] [number (mod number test)])))
        action-list (->> action-list-1
                         (map (fn [[number ihms]] [number (if (zero? ihms) if-true if-false)])))
        state (->> action-list
                   (reduce (fn [state [number receiver]]
                             (update-in state [receiver :items] conj number))
                           state))]
    (-> state
        (assoc-in [monkey-id :items] (list))
        (update-in [monkey-id :inspected] + (count action-list)))))

(defn monkees-do
  [state]
  (let [monkees (->> state
                     (keys)
                     (sort))]
    (reduce monkey-do
            state
            monkees)))

(defn monkees-do-throw-stuff
  [times state]
  (reduce (fn [state _] (monkees-do state))
          state
          (range times)))

(defn day11-part1
  {:test (fn []
           (is= (day11-part1 day11-example) 10605)
           (is= (day11-part1 day11-puzzle) 58056))}
  [text]
  (->> text
       (text->state)
       (monkees-do-throw-stuff 20)
       (vals)
       (map :inspected)
       (sort >)
       (take 2)
       (apply *)))

(comment
  (time (day11-part1 day11-puzzle))
  ;"Elapsed time: 5.686162 msecs"
  ;=> 58056
  )
