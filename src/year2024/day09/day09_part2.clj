(ns year2024.day09.day09-part2
  (:require [ysera.test :refer [is is= is-not deftest]]
            [year2024.day09.day09-part1 :as part-1]
            [year2024.day09.day09-data :refer [day09-example day09-puzzle]]
            [clojure.string :as str]))

(defn day09-part2
  {:test (fn []
           (is= (day09-part2 day09-example) 0))}
  [text]
  )


(comment
  (time (day09-part2 day09-puzzle))
  ;
  )
