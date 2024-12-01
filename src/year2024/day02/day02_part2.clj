(ns year2024.day02.day02-part2
  (:require [ysera.test :refer [is is= is-not deftest]]
            [year2024.day02.day02-part1 :as part-1]
            [year2024.day02.day02-data :refer [day02-example day02-puzzle]]
            [clojure.string :as str]))

(defn day02-part2
  {:test (fn []
           (is= (day02-part2 day02-example) 0))}
  [text]
  )


(comment
  (time (day02-part2 day02-puzzle))
  ;
  )
