(ns year2021.day12.day12-part2
  (:require [ysera.test :refer [is is= is-not deftest]]
            [year2021.day12.day12-data :refer [day12-example day12-puzzle]]
            [clojure.string :as str]))

(defn day12-part2
  {:test (fn []
           (is= (day12-part2 day12-example) 0))}
  [text]
  )


(comment
  (time (day12-part2 day12-puzzle))
  ;
  ;
  )