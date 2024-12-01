(ns year2024.day25.day25-part1
  (:require [ysera.test :refer [is is= is-not deftest]]
            [year2024.day25.day25-data :refer [day25-example day25-puzzle]]
            [clojure.string :as str]))

(defn day25-part1
  {:test (fn []
           (is= (day25-part1 day25-example) 0))}
  [text]
  )


(comment
  (time (day25-part1 day25-puzzle))
  ;
  )
