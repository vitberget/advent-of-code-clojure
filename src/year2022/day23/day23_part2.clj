(ns year2022.day23.day23-part2
  (:require [ysera.test :refer [is is= is-not deftest]]
            [year2022.day23.day23-data :refer [day23-example day23-puzzle]]
            [clojure.string :as str]))

(defn day23-part2
  {:test (fn []
           (is= (day23-part2 day23-example) 0))}
  [text]
  )


(comment
  (time (day23-part2 day23-puzzle))
  ;
  ;
  )
