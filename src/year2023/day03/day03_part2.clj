(ns year2023.day03.day03-part2
  (:require [ysera.test :refer [is is= is-not deftest]]
            [year2023.day03.day03-part1 :as part-1]
            [year2023.day03.day03-data :refer [day03-example day03-puzzle]]
            [clojure.string :as str]))

(defn day03-part2
  {:test (fn []
           (is= (day03-part2 day03-example) 0))}
  [text]
  )


(comment
  (time (day03-part2 day03-puzzle))
  ;
  )
