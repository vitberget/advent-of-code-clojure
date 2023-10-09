(ns year2023.day11.day11-part2
  (:require [ysera.test :refer [is is= is-not deftest]]
            [year2023.day11.day11-part1 :as part-1]
            [year2023.day11.day11-data :refer [day11-example day11-puzzle]]
            [clojure.string :as str]))

(defn day11-part2
  {:test (fn []
           (is= (day11-part2 day11-example) 0))}
  [text]
  )


(comment
  (time (day11-part2 day11-puzzle))
  ;
  )
