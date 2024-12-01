(ns year2024.day16.day16-part2
  (:require [ysera.test :refer [is is= is-not deftest]]
            [year2024.day16.day16-part1 :as part-1]
            [year2024.day16.day16-data :refer [day16-example day16-puzzle]]
            [clojure.string :as str]))

(defn day16-part2
  {:test (fn []
           (is= (day16-part2 day16-example) 0))}
  [text]
  )


(comment
  (time (day16-part2 day16-puzzle))
  ;
  )
