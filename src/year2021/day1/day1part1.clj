(ns year2021.day1.day1part1
  (:require [ysera.test :refer [is is= is-not deftest]]
            [year2021.day1.day1puzzle :refer [day1-puzzle day1-example]]
            [clojure.string :as str]))

(defn text->numbers
  [text]
  (->> text
       (str/split-lines)
       (map read-string)))

(defn day1-part1
  {:test (fn []
           (is= (day1-part1 day1-example) 7))}
  [text]
  (let [numbers (text->numbers text)]
    (loop [counter 0
           previous (first numbers)
           [current & numbers] (rest numbers)]

      (if (nil? current)
        counter
        (recur
          (if (> current previous) (inc counter) counter)
          current
          numbers)))))

(comment
  (time (day1-part1 day1-puzzle))
  ;"Elapsed time: 8.04287 msecs"
  ;=> 1387
  )