(ns year2022.day1.day1-part1
  (:require [ysera.test :refer [is is= is-not deftest]]
            [year2022.day1.day1-data :refer [day1-example day1-puzzle]]
            [clojure.string :as str]))

(defn day1-part1
  {:test (fn []
           (is= (day1-part1 day1-example) 0))}
  [text]
  )


(comment
  (time (day1-part1 day1-puzzle))
  ;
  ;
  )
