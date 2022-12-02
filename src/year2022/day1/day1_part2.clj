(ns year2022.day1.day1-part2
  (:require [ysera.test :refer [is is= is-not deftest]]
            [year2022.day1.day1-part1 :as part-1]
            [year2022.day1.day1-data :refer [day1-example day1-puzzle]]
            [clojure.string :as str]))

(defn day1-part2
  {:test (fn []
           (is= (day1-part2 day1-example) 45000)
           (is= (day1-part2 day1-puzzle) 213958))}
  [text]
  (->> text
       (part-1/text->paragraphs)
       (map part-1/text->numbers)
       (map part-1/sum-numbers)
       (sort >)
       (take 3)
       (part-1/sum-numbers)))

(comment
  (time (day1-part2 day1-puzzle))
  ;"Elapsed time: 4.765943 msecs"
  ;=> 213958
  )
