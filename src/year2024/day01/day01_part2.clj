(ns year2024.day01.day01-part2
  (:require [ysera.test :refer [is is= is-not deftest]]
            [year2024.day01.day01-part1 :as part-1]
            [year2024.day01.day01-data :refer [day01-example day01-puzzle]]
            [clojure.string :as str]))

(defn day01-part2
  {:test (fn []
           (is= (day01-part2 day01-example) 0))}
  [text]
  )


(comment
  (time (day01-part2 day01-puzzle))
  ;
  )
