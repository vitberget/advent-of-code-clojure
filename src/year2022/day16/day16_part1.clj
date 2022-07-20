(ns year2022.day16.day16-part1
  (:require [ysera.test :refer [is is= is-not deftest]]
            [year2022.day16.day16-data :refer [day16-example day16-puzzle]]
            [clojure.string :as str]))

(defn day16-part1
  {:test (fn []
           (is= (day16-part1 day16-example) 0))}
  [text]
  )


(comment
  (time (day16-part1 day16-puzzle))
  ;
  ;
  )
