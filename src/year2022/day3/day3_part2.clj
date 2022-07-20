(ns year2022.day3.day3-part2
  (:require [ysera.test :refer [is is= is-not deftest]]
            [year2022.day3.day3-data :refer [day3-example day3-puzzle]]
            [clojure.string :as str]))

(defn day3-part2
  {:test (fn []
           (is= (day3-part2 day3-example) 0))}
  [text]
  )


(comment
  (time (day3-part2 day3-puzzle))
  ;
  ;
  )
