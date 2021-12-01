(ns year2021.day1.day1part2
  (:require [ysera.test :refer [is is= is-not deftest]]
            [year2021.day1.day1puzzle :refer [day1-puzzle]]
            [clojure.string :as str]))

(defn day1-part2
  {:test (fn []
           (is= (day1-part2 "199\n200\n208\n210\n200\n207\n240\n269\n260\n263")
                5))}
  [text]
  (let [numbers (->> text
                     (str/split-lines)
                     (map read-string))]
    (loop [counter 0

           prevnum-1 (nth numbers 0)
           prevnum-2 (nth numbers 1)
           prevnum-3 (nth numbers 2)

           [num & numbers] (drop 3 numbers)]

      (if (nil? num)
        counter
        (recur
          (if (> (+ num prevnum-2 prevnum-3)
                 (+ prevnum-1 prevnum-2 prevnum-3))
            (inc counter)
            counter)

          prevnum-2
          prevnum-3
          num

          numbers)))))

(comment
  (time (day1-part2 day1-puzzle))
  ;"Elapsed time: 8.785697 msecs"
  ;=> 1362
  )