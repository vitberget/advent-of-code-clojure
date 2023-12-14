(ns year2023.day14.day14-part2
  (:require [ysera.test :refer [is is= is-not deftest]]
            [year2023.day14.day14-part1 :as part-1]
            [year2023.day14.day14-data :refer [day14-example day14-puzzle]]
            [clojure.string :as str]))

(defn day14-part2
  {:test (fn []
           (is= (day14-part2 day14-example) 64))}
  [text]
  )


(comment
  (time (day14-part2 day14-puzzle))
  ;
  )
