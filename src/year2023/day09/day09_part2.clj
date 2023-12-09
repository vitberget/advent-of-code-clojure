(ns year2023.day09.day09-part2
  (:require
   [utils.numbers :refer [all-zeroes?]]
   [year2023.day09.day09-data :refer [day09-example day09-puzzle]]
   [year2023.day09.day09-part1 :as part-1]
   [ysera.test :refer [is=]]))

(defn previous-number 
  {:test (fn[]
           (is= (previous-number [0 3 6 9 12 15]) -3)
           (is= (previous-number [1 3 6 10 15 21]) 0)
           (is= (previous-number [10 13 16 21 30 45]) 5))} 
  [numbers]
  (loop [layers (list numbers)]
    (if (->> layers (first) (all-zeroes?))
      (->> layers
           (map first)
           (reduce (fn [a b] (- b a))))
      (let [layer (first layers)]
        (recur (conj layers (map - (drop 1 layer) layer)))))))

(defn day09-part2
  {:test (fn [] (is= (day09-part2 day09-example) 2))}
  [text]
  (->> text
       (part-1/text->report)
       (map previous-number)
       (apply +)))

(comment
  (time (day09-part2 day09-puzzle))
  ; (out) "Elapsed time: 5.649096 msecs"
  ; 973
  )
