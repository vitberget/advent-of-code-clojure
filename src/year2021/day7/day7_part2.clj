(ns year2021.day7.day7-part2
  (:require [ysera.test :refer [is is= is-not deftest]]
            [year2021.day7.day7-data :refer [day7-example day7-puzzle]]
            [clojure.string :as str]))

(defn day7-part2
  {:test (fn []
           (is= (day7-part2 day7-example) 0))}
  [text]
  )


(comment
  (time (day7-part2 day7-puzzle))
  ;
  ;
  )