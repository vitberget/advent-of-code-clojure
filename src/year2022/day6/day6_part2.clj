(ns year2022.day6.day6-part2
  (:require [ysera.test :refer [is is= is-not deftest]]
            [year2022.day6.day6-data :refer [day6-example day6-puzzle]]
            [clojure.string :as str]))

(defn day6-part2
  {:test (fn []
           (is= (day6-part2 day6-example) 0))}
  [text]
  )


(comment
  (time (day6-part2 day6-puzzle))
  ;
  ;
  )