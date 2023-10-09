(ns year2023.day09.day09-part1
  (:require [ysera.test :refer [is is= is-not deftest]]
            [year2023.day09.day09-data :refer [day09-example day09-puzzle]]
            [clojure.string :as str]))

(defn day09-part1
  {:test (fn []
           (is= (day09-part1 day09-example) 0))}
  [text]
  )


(comment
  (time (day09-part1 day09-puzzle))
  ;
  )
