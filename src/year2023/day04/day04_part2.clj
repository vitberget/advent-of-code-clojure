(ns year2023.day04.day04-part2
  (:require [ysera.test :refer [is is= is-not deftest]]
            [year2023.day04.day04-part1 :as part-1]
            [year2023.day04.day04-data :refer [day04-example day04-puzzle]]
            [clojure.string :as str]))

(defn day04-part2
  {:test (fn []
           (is= (day04-part2 day04-example) 0))}
  [text]
  )


(comment
  (time (day04-part2 day04-puzzle))
  ;
  )
