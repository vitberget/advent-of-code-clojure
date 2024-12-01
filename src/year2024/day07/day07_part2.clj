(ns year2024.day07.day07-part2
  (:require [ysera.test :refer [is is= is-not deftest]]
            [year2024.day07.day07-part1 :as part-1]
            [year2024.day07.day07-data :refer [day07-example day07-puzzle]]
            [clojure.string :as str]))

(defn day07-part2
  {:test (fn []
           (is= (day07-part2 day07-example) 0))}
  [text]
  )


(comment
  (time (day07-part2 day07-puzzle))
  ;
  )
