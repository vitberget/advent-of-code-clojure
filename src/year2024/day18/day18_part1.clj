(ns year2024.day18.day18-part1
  (:require [ysera.test :refer [is is= is-not deftest]]
            [year2024.day18.day18-data :refer [day18-example day18-puzzle]]
            [clojure.string :as str]))

(defn day18-part1
  {:test (fn []
           (is= (day18-part1 day18-example) 0))}
  [text]
  )


(comment
  (time (day18-part1 day18-puzzle))
  ;
  )
