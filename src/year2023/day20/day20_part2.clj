(ns year2023.day20.day20-part2
  (:require [ysera.test :refer [is is= is-not deftest]]
            [year2023.day20.day20-part1 :as part-1]
            [year2023.day20.day20-data :refer [day20-example day20-puzzle]]
            [clojure.string :as str]))

(defn day20-part2
  {:test (fn []
           (is= (day20-part2 day20-example) 0))}
  [text]
  )


(comment
  (time (day20-part2 day20-puzzle))
  ;
  )
