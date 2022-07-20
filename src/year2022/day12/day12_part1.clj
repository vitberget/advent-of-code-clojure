(ns year2022.day12.day12-part1
  (:require [ysera.test :refer [is is= is-not deftest]]
            [year2022.day12.day12-data :refer [day12-example day12-puzzle]]
            [clojure.string :as str]))

(defn day12-part1
  {:test (fn []
           (is= (day12-part1 day12-example) 0))}
  [text]
  )


(comment
  (time (day12-part1 day12-puzzle))
  ;
  ;
  )
