(ns year2022.day5.day5-part1
  (:require [ysera.test :refer [is is= is-not deftest]]
            [year2022.day5.day5-data :refer [day5-example day5-puzzle]]
            [clojure.string :as str]))

(defn day5-part1
  {:test (fn []
           (is= (day5-part1 day5-example) 0))}
  [text]
  )


(comment
  (time (day5-part1 day5-puzzle))
  ;
  ;
  )
