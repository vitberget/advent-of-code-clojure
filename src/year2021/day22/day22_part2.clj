(ns year2021.day22.day22-part2
  (:require [ysera.test :refer [is is= is-not deftest]]
            [year2021.day22.day22-data :refer [day22-example-3 day22-puzzle]]
            [year2021.day20.day20-part1 :as part1]))

(defn day22-part2
  {:test (fn []
           (is= (day22-part2 day22-example-3) 2758514936282235))}
  [text]
  )


(comment
  (time (day22-part2 day22-puzzle))
  ;
  ;
  )