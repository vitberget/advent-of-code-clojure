(ns year2024.day15.day15-part1
  (:require [ysera.test :refer [is is= is-not deftest]]
            [year2024.day15.day15-data :refer [day15-example day15-puzzle]]
            [clojure.string :as str]))

(defn day15-part1
  {:test (fn []
           (is= (day15-part1 day15-example) 0))}
  [text]
  )


(comment
  (time (day15-part1 day15-puzzle))
  ;
  )
