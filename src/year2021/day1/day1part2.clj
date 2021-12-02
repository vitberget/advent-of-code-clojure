(ns year2021.day1.day1part2
  (:require [ysera.test :refer [is is= is-not deftest]]
            [year2021.day1.day1puzzle :refer [day1-puzzle day1-example]]
            [year2021.day1.day1part1 :refer [text->numbers]]))

(defn day1-part2
  {:test (fn []
           (is= (day1-part2 day1-example) 5))}
  [text]
  (let [numbers (text->numbers text)]
    (loop [counter 0
           [previous & prevnums] (take 3 numbers)
           [current & numbers] (drop 3 numbers)]
      (if (nil? current)
        counter
        (recur
          (if (> current previous) (inc counter) counter)
          (concat prevnums [current])
          numbers)))))

(comment
  (time (day1-part2 day1-puzzle))
  ;"Elapsed time: 8.785697 msecs"
  ;=> 1362
  )