(ns year2021.day4.day4-part2
  (:require [ysera.test :refer [is is= is-not deftest]]
            [year2021.day4.day4-data :refer [day4-example day4-puzzle]]
            [clojure.string :as str]))

(defn day4-part2
  {:test (fn []
           (is= (day4-part2 day4-example) 0))}
  [text]
  )


(comment
  (time (day4-part2 day4-puzzle))
  ;
  ;
  )