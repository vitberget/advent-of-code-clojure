(ns year2023.day24.day24-part2
  (:require [ysera.test :refer [is is= is-not deftest]]
            [year2023.day24.day24-part1 :as part-1]
            [year2023.day24.day24-data :refer [day24-example day24-puzzle]]
            [clojure.string :as str]))

(defn day24-part2
  {:test (fn []
           (is= (day24-part2 day24-example) 0))}
  [text]
  )


(comment
  (time (day24-part2 day24-puzzle))
  ;
  )
