(ns year2021.day23.day23-part1
  (:require [ysera.test :refer [is is= is-not deftest]]
            [year2021.day23.day23-data :refer [day23-example day23-puzzle]]
            [clojure.string :as str]))

(defn day23-part1
  {:test (fn []
           (is= (day23-part1 day23-example) 0))}
  [text]
  )


(comment
  (time (day23-part1 day23-puzzle))
  ;
  ;
  )
