(ns year2024.day03.day03-part2
  (:require [ysera.test :refer [is=]]
            [year2024.day03.day03-data :refer [day03-puzzle]]))

(defn filter-do-dont 
  [items]
  (loop [[item & items] items
         add-it true
         result []]
      (cond 
        (nil? item) result
        (= (first item) "do()") (recur items true result)
        (= (first item) "don't()") (recur items false result)
        add-it (recur items add-it (conj result item))
        :else (recur items add-it result))))

(defn day03-part2
  {:test (fn []
           (is= (day03-part2 "day03-examplexmul(2,4)&mul[3,7]!^don't()_mul(5,5)+mul(32,64](mul(11,8)undo()?mul(8,5))") 48))}
  [text]
  (->> text
       (re-seq #"(mul\((\d+),(\d+)\))|(do\(\))|don't\(\)")
       (filter-do-dont)
       (map (fn[rs] (->> rs 
                         (drop 2)
                         (take 2)
                         (map read-string)
                         (apply *))))
       (apply +)))

(comment
  (time (day03-part2 day03-puzzle))
  ; (out) "Elapsed time: 1.659939 msecs"
  ; 56275602
  )
