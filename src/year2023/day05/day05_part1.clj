(ns year2023.day05.day05-part1
  (:require [ysera.test :refer [is is= is-not deftest]]
            [year2023.day05.day05-data :refer [day05-example day05-puzzle]]
            [clojure.string :as str]))

(defn day05-part1
  {:test (fn []
           (is= (day05-part1 day05-example) 0))}
  [text]
  )


(comment
  (time (day05-part1 day05-puzzle))
  ;
  )
