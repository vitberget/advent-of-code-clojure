(ns year2024.day17.day17-part1
  (:require [ysera.test :refer [is is= is-not deftest]]
            [year2024.day17.day17-data :refer [day17-example day17-puzzle]]
            [clojure.string :as str]))

(defn day17-part1
  {:test (fn []
           (is= (day17-part1 day17-example) 0))}
  [text]
  )


(comment
  (time (day17-part1 day17-puzzle))
  ;
  )
