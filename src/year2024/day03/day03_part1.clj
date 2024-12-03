(ns year2024.day03.day03-part1
  (:require [ysera.test :refer [is=]]
            [year2024.day03.day03-data :refer [day03-puzzle]]))

(defn day03-part1
  {:test (fn []
           (is= (day03-part1 "xmul(2,4)%&mul[3,7]!@^do_not_mul(5,5)+mul(32,64]then(mul(11,8)mul(8,5))") 161))}
  [text]
  (->> text
       (re-seq #"(mul\((\d+),(\d+)\))")
       (map (fn[rs] (->> rs 
                         (drop 2)
                         (map read-string)
                         (apply *))))
       (apply +)))

(comment
  (time (day03-part1 day03-puzzle))
  ; (out) "Elapsed time: 2.632318 msecs"
  ; 174960292
  )
