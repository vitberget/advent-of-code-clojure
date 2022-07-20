(ns year2022.day4.day4-part1
  (:require [ysera.test :refer [is is= is-not deftest]]
            [year2022.day4.day4-data :refer [day4-example day4-puzzle]]
            [clojure.string :as str]))

(defn day4-part1
  {:test (fn []
           (is= (day4-part1 day4-example) 0))}
  [text]
  )


(comment
  (time (day4-part1 day4-puzzle))
  ;
  ;
  )
