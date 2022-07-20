(ns year2022.day14.day14-part2
  (:require [ysera.test :refer [is is= is-not deftest]]
            [year2022.day14.day14-data :refer [day14-example day14-puzzle]]
            [clojure.string :as str]))

(defn day14-part2
  {:test (fn []
           (is= (day14-part2 day14-example) 0))}
  [text]
  )


(comment
  (time (day14-part2 day14-puzzle))
  ;
  ;
  )
