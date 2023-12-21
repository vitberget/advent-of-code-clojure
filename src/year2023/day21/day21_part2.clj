(ns year2023.day21.day21-part2
  (:require [ysera.test :refer [is is= is-not deftest]]
            [year2023.day21.day21-part1 :as part-1]
            [year2023.day21.day21-data :refer [day21-example day21-puzzle]]
            [clojure.string :as str]))

(defn day21-part2
  {:test (fn []
           (is= (day21-part2 day21-example 6) 16)
           (is= (day21-part2 day21-example 10) 50)
           (is= (day21-part2 day21-example 50) 1594)
           (is= (day21-part2 day21-example 100) 6536)
           (is= (day21-part2 day21-example 500) 167004)
           (is= (day21-part2 day21-example 1000) 668697)
           (is= (day21-part2 day21-example 5000) 16733044))}
  [text steps]
  (let [the-map (part-1/text->map text)]
  ))


(comment
  (time (day21-part2 day21-puzzle 26501365))
  ;
  )
