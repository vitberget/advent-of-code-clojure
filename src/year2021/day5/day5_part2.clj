(ns year2021.day5.day5-part2
  (:require [ysera.test :refer [is is= is-not deftest]]
            [year2021.day5.day5-data :refer [day5-example day5-puzzle]]
            [clojure.string :as str]))

(defn day5-part2
  {:test (fn []
           (is= (day5-part2 day5-example) 0))}
  [text]
  )


(comment
  (time (day5-part2 day5-puzzle))
  ;
  ;
  )