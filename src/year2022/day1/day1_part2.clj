(ns year2022.day1.day1-part2
  (:require [ysera.test :refer [is is= is-not deftest]]
            [year2022.day1.day1-part1 :refer [text->numbers sum-numbers]]
            [year2022.day1.day1-data :refer [day1-example day1-puzzle]]
            [clojure.string :as str]))

(defn day1-part2
  {:test (fn []
           (is= (day1-part2 day1-example) 45000))}
  [text]
  (as-> text $
        (str/split $ #"\n\n")
        (map text->numbers $)
        (map sum-numbers $)
        (sort > $)
        (take 3 $)
        (sum-numbers $)))


(comment
  (time (day1-part2 day1-puzzle))
  ;"Elapsed time: 4.765943 msecs"
  ;=> 213958
  )
