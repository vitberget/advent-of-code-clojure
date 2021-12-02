(ns year2021.day15.day15-part2
  (:require [ysera.test :refer [is is= is-not deftest]]
            [year2021.day15.day15-data :refer [day15-example day15-puzzle]]
            [clojure.string :as str]))

(defn day15-part2
  {:test (fn []
           (is= (day15-part2 day15-example) 0))}
  [text]
  )


(comment
  (time (day15-part2 day15-puzzle))
  ;
  ;
  )