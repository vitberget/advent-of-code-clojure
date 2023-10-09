(ns year2023.day13.day13-part2
  (:require [ysera.test :refer [is is= is-not deftest]]
            [year2023.day13.day13-part1 :as part-1]
            [year2023.day13.day13-data :refer [day13-example day13-puzzle]]
            [clojure.string :as str]))

(defn day13-part2
  {:test (fn []
           (is= (day13-part2 day13-example) 0))}
  [text]
  )


(comment
  (time (day13-part2 day13-puzzle))
  ;
  )
