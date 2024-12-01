(ns year2024.day06.day06-part1
  (:require [ysera.test :refer [is is= is-not deftest]]
            [year2024.day06.day06-data :refer [day06-example day06-puzzle]]
            [clojure.string :as str]))

(defn day06-part1
  {:test (fn []
           (is= (day06-part1 day06-example) 0))}
  [text]
  )


(comment
  (time (day06-part1 day06-puzzle))
  ;
  )
