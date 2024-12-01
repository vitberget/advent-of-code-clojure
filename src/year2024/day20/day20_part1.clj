(ns year2024.day20.day20-part1
  (:require [ysera.test :refer [is is= is-not deftest]]
            [year2024.day20.day20-data :refer [day20-example day20-puzzle]]
            [clojure.string :as str]))

(defn day20-part1
  {:test (fn []
           (is= (day20-part1 day20-example) 0))}
  [text]
  )


(comment
  (time (day20-part1 day20-puzzle))
  ;
  )
