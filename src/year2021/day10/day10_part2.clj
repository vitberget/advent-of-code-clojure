(ns year2021.day10.day10-part2
  (:require [ysera.test :refer [is is= is-not deftest]]
            [year2021.day10.day10-data :refer [day10-example day10-puzzle]]
            [clojure.string :as str]))

(defn day10-part2
  {:test (fn []
           (is= (day10-part2 day10-example) 0))}
  [text]
  )


(comment
  (time (day10-part2 day10-puzzle))
  ;
  ;
  )