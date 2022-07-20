(ns year2022.day2.day2-part1
  (:require [ysera.test :refer [is is= is-not deftest]]
            [year2022.day2.day2-data :refer [day2-example day2-puzzle]]
            [clojure.string :as str]))

(defn day2-part1
  {:test (fn []
           (is= (day2-part1 day2-example) 0))}
  [text]
  )


(comment
  (time (day2-part1 day2-puzzle))
  ;
  ;
  )
