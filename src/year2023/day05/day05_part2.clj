(ns year2023.day05.day05-part2
  (:require [ysera.test :refer [is is= is-not deftest]]
            [year2023.day05.day05-part1 :as part-1]
            [year2023.day05.day05-data :refer [day05-example day05-puzzle]]
            [clojure.string :as str]))

(defn day05-part2
  {:test (fn []
           (is= (day05-part2 day05-example) 0))}
  [text]
  )


(comment
  (time (day05-part2 day05-puzzle))
  ;
  )
