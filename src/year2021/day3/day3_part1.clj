(ns year2021.day3.day3-part1
  (:require [ysera.test :refer [is is= is-not deftest]]
            [year2021.day3.day3-data :refer [day3-example day3-puzzle]]
            [clojure.string :as str]))

(defn day3-part1
  {:test (fn []
           (is= (day3-part1 day3-example) 0))}
  [text]
  )


(comment
  (time (day3-part1 day3-puzzle))
  ;
  ;
  )
