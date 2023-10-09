(ns year2023.day07.day07-part1
  (:require [ysera.test :refer [is is= is-not deftest]]
            [year2023.day07.day07-data :refer [day07-example day07-puzzle]]
            [clojure.string :as str]))

(defn day07-part1
  {:test (fn []
           (is= (day07-part1 day07-example) 0))}
  [text]
  )


(comment
  (time (day07-part1 day07-puzzle))
  ;
  )
