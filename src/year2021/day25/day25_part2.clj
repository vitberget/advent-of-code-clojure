(ns year2021.day25.day25-part2
  (:require [ysera.test :refer [is is= is-not deftest]]
            [year2021.day25.day25-data :refer [day25-example day25-puzzle]]
            [clojure.string :as str]))

(defn day25-part2
  {:test (fn []
           (is= (day25-part2 day25-example) 0))}
  [text]
  )


(comment
  (time (day25-part2 day25-puzzle))
  ;
  ;
  )