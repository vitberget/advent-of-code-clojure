(ns year2022.day11.day11-part2
  (:require [year2022.day11.day11-data :refer [day11-example day11-puzzle]]
            [year2022.day11.day11-part1 :as part-1]
            [ysera.test :refer [is=]]))

(defn apply-operation
  [number [v1 v2 v3] common-test]
  (let [v2 (condp = v2
             "*" *
             "/" /
             "-" -
             "+" +)]
    (-> (v2 (if (= v1 "old") number v1)
            (if (= v3 "old") number v3))
        (mod common-test))))

(defn monkey-do
  [state monkey-id common-test]
  (let [{operation :operation
         test      :test
         if-true   :if-true
         if-false  :if-false} (get state monkey-id)
        action-list (->> (get-in state [monkey-id :items])
                         (map #(apply-operation % operation common-test))
                         (map (fn [number] [number (mod number test)]))
                         (map (fn [[number ihms]] [number (if (zero? ihms) if-true if-false)])))
        state (->> action-list
                   (reduce (fn [state [number receiver]]
                             (update-in state [receiver :items] conj number))
                           state))]
    (-> state
        (assoc-in [monkey-id :items] (list))
        (update-in [monkey-id :inspected] + (count action-list)))))

(defn monkees-do
  [state common-test]
  (let [monkees (->> state
                     (keys)
                     (sort))]
    (reduce (fn [state monkey-id] (monkey-do state monkey-id common-test))
            state
            monkees)))

(defn monkees-do-throw-stuff
  [times common-test state]
  (reduce (fn [state _]
            (monkees-do state common-test))
          state
          (range times)))

(defn day11-part2
  {:test (fn []
           (is= (day11-part2 day11-example) 2713310158))}
  [text]
  (let [state (part-1/text->state text)
        common-test (->> state
                         (map second)
                         (map :test)
                         (apply *))]
    (->> state
         (monkees-do-throw-stuff 10000 common-test)
         (vals)
         (map :inspected)
         (sort >)
         (take 2)
         (apply *))))

(comment
  (time (day11-part2 day11-puzzle))
  ;"Elapsed time: 896.928831 msecs"
  ;=> 15048718170
  )
