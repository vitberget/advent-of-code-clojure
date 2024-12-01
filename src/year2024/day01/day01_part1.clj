(ns year2024.day01.day01-part1
  (:require [ysera.test :refer [is is= is-not deftest]]
            [year2024.day01.day01-data :refer [day01-example day01-puzzle]]
            [clojure.string :as str]))

(defn day01-part1
  {:test (fn []
           (is= (day01-part1 day01-example) 0))}
  [text]
  )


(comment
  (time (day01-part1 day01-puzzle))
  ;
  )
