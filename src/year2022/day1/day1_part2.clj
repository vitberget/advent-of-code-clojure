(ns year2022.day1.day1-part2
  (:require [utils.text :as ut]
            [year2022.day1.day1-data :refer [day1-example day1-puzzle]]
            [year2022.day1.day1-part1 :as part-1]
            [ysera.test :refer [is=]]))

(defn day1-part2
  {:test (fn []
           (is= (day1-part2 day1-example) 45000)
           (is= (day1-part2 day1-puzzle) 213958))}
  [text]
  (->> text
       (ut/text->paragraphs)
       (map ut/text->numbers)
       (map part-1/sum-numbers)
       (sort >)
       (take 3)
       (part-1/sum-numbers)))

(comment
  (time (day1-part2 day1-puzzle))
  ;"Elapsed time: 4.765943 msecs"
  ;=> 213958
  )
