(ns year2021.day6.day6-part1
  (:require [ysera.test :refer [is is= is-not deftest]]
            [year2021.day6.day6-data :refer [day6-example day6-puzzle]]
            [clojure.string :as str]))

(defn day6-part1
  {:test (fn []
           (is= (day6-part1 day6-example) 0))}
  [text]
  )


(comment
  (time (day6-part1 day6-puzzle))
  ;
  ;
  )
