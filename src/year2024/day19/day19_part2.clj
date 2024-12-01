(ns year2024.day19.day19-part2
  (:require [ysera.test :refer [is is= is-not deftest]]
            [year2024.day19.day19-part1 :as part-1]
            [year2024.day19.day19-data :refer [day19-example day19-puzzle]]
            [clojure.string :as str]))

(defn day19-part2
  {:test (fn []
           (is= (day19-part2 day19-example) 0))}
  [text]
  )


(comment
  (time (day19-part2 day19-puzzle))
  ;
  )
