(ns year2022.day21.day21-part1
  (:require [clojure.string :as str]
            [utils.text :as ut]
            [year2022.day21.day21-data :refer [day21-example day21-puzzle]]
            [ysera.test :refer [is=]]))

(defn line->monkey
  {:test (fn []
           (is= (line->monkey "root: pppw + sjmn") {:root [:pppw "+" :sjmn]})
           (is= (line->monkey "dbpl: 5") {:dbpl 5}))}
  [line]
  (let [[k r] (ut/split-on #": " line)
        k (keyword k)
        r (->> (ut/line->words r)
               (map str/trim))]
    (if (= 1 (count r))
      {k (-> r (first) (read-string))}
      {k [(-> r (first) (keyword))
          (nth r 1)
          (-> r
              (nth 2)
              (keyword))]})))

(defn text->monkees
  [text]
  (->> text
       (ut/text->lines)
       (map line->monkey)
       (reduce merge)))

(defn math
  [[n1 op n2]]
  (condp = op
    "-" (- n1 n2)
    "+" (+ n1 n2)
    "*" (* n1 n2)
    "/" (/ n1 n2)))

(defn solve-monkees
  [monkees]
  (loop [idx 0
         monkees monkees
         down-the-hole-we-go (list :root)]
    (let [cur (first down-the-hole-we-go)
          instructions (get monkees cur)
          left (when (coll? instructions) (nth instructions 0))
          right (when (coll? instructions) (nth instructions 2))
          left-val (get monkees left)
          right-val (get monkees right)]
      (cond
        (nil? cur)
        (get monkees :root)

        (number? instructions)
        (recur (inc idx)
               monkees
               (drop 1 down-the-hole-we-go))

        (and (number? left)
             (number? right))
        (recur (inc idx)
               (assoc monkees cur (math instructions))
               (drop 1 down-the-hole-we-go))

        (and (keyword? left)
             (number? left-val))
        (recur (inc idx)
               (assoc monkees cur (concat [left-val] (drop 1 instructions)))
               down-the-hole-we-go)

        (and (keyword? right)
             (number? right-val))
        (recur (inc idx)
               (assoc monkees cur (concat (drop-last 1 instructions) [right-val]))
               down-the-hole-we-go)

        (keyword? left)
        (recur (inc idx)
               monkees
               (conj down-the-hole-we-go left))

        (keyword? right)
        (recur (inc idx)
               monkees
               (conj down-the-hole-we-go right))))))

(defn day21-part1
  {:test (fn []
           (is= (day21-part1 day21-example) 152)
           (is= (day21-part1 day21-puzzle) 331120084396440))}
  [text]
  (->> text
       (text->monkees)
       (solve-monkees)))


(comment
  (time (day21-part1 day21-puzzle))
  ;"Elapsed time: 25.028021 msecs"
  ;=> 331120084396440
  )
