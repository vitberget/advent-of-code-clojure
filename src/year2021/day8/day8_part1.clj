(ns year2021.day8.day8-part1
  (:require [ysera.test :refer [is is= is-not deftest]]
            [year2021.day8.day8-data :refer [day8-example day8-puzzle]]
            [clojure.string :as str]))

(defn day8-part1
  {:test (fn []
           (is= (day8-part1 day8-example) 0))}
  [text]
  )


(comment
  (time (day8-part1 day8-puzzle))
  ;
  ;
  )
