(ns year2022.day22.day22-part1
  (:require [ysera.test :refer [is is= is-not deftest]]
            [year2022.day22.day22-data :refer [day22-example day22-puzzle]]
            [clojure.string :as str]))

(defn day22-part1
  {:test (fn []
           (is= (day22-part1 day22-example) 0))}
  [text]
  )


(comment
  (time (day22-part1 day22-puzzle))
  ;
  ;
  )
