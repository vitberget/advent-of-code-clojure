(ns year2023.day08.day08-part2
  (:require [ysera.test :refer [is is= is-not deftest]]
            [year2023.day08.day08-part1 :as part-1]
            [year2023.day08.day08-data :refer [day08-example day08-puzzle]]
            [clojure.string :as str]))

; Solved it in Rust instead...

(defn day08-part2
  {:test (fn []
           (is= (day08-part2 day08-example) 0))}
  [text]
  )


(comment
  (time (day08-part2 day08-puzzle))
  ;
  )
