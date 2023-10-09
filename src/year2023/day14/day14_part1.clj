(ns year2023.day14.day14-part1
  (:require [ysera.test :refer [is is= is-not deftest]]
            [year2023.day14.day14-data :refer [day14-example day14-puzzle]]
            [clojure.string :as str]))

(defn day14-part1
  {:test (fn []
           (is= (day14-part1 day14-example) 0))}
  [text]
  )


(comment
  (time (day14-part1 day14-puzzle))
  ;
  )
