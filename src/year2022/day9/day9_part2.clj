(ns year2022.day9.day9-part2
  (:require [ysera.test :refer [is is= is-not deftest]]
            [year2022.day9.day9-data :refer [day9-example day9-puzzle]]
            [clojure.string :as str]))

(defn day9-part2
  {:test (fn []
           (is= (day9-part2 day9-example) 0))}
  [text]
  )


(comment
  (time (day9-part2 day9-puzzle))
  ;
  ;
  )
