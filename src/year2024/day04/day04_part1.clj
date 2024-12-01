(ns year2024.day04.day04-part1
  (:require [ysera.test :refer [is is= is-not deftest]]
            [year2024.day04.day04-data :refer [day04-example day04-puzzle]]
            [clojure.string :as str]))

(defn day04-part1
  {:test (fn []
           (is= (day04-part1 day04-example) 0))}
  [text]
  )


(comment
  (time (day04-part1 day04-puzzle))
  ;
  )
