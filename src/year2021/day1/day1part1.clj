(ns year2021.day1.day1part1
  (:require [ysera.test :refer [is is= is-not deftest]]
            [year2021.day1.day1puzzle :refer [day1-puzzle]]
            [clojure.string :as str]))

(defn day1-part1
  {:test (fn[]
           (is= (day1-part1 "199\n200\n208\n210\n200\n207\n240\n269\n260\n263")
                7))}
  [text]
  (let [numbers (->> text
                    (str/split-lines)
                    (map read-string)
                    )]
    (loop [counter 0
           prevnum (first numbers)
           [num & numbers] (rest numbers)]

      (if (nil? num)
        counter
        (recur
          (if (> num prevnum)
            (inc counter)
            counter)
          num
          numbers)))))

(comment
  (time (day1-part1 day1-puzzle))
  ;"Elapsed time: 8.04287 msecs"
  ;=> 1387

  )