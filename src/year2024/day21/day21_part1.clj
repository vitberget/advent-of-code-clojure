(ns year2024.day21.day21-part1
  (:require [ysera.test :refer [is is= is-not deftest]]
            [year2024.day21.day21-data :refer [day21-example day21-puzzle]]
            [clojure.string :as str]))

(defn day21-part1
  {:test (fn []
           (is= (day21-part1 day21-example) 0))}
  [text]
  )


(comment
  (time (day21-part1 day21-puzzle))
  ;
  )
