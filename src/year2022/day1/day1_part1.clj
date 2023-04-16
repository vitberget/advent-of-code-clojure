(ns year2022.day1.day1-part1
  (:require [utils.text :as ut]
            [year2022.day1.day1-data :refer [day1-example day1-puzzle]]
            [ysera.test :refer [is=]]))

(defn sum-numbers
  [numbers]
  (apply + numbers))

(defn day1-part1
  {:test (fn []
           (is= (day1-part1 day1-example) 24000)
           (is= (day1-part1 day1-puzzle) 73211))}
  [text]
  (->> text
       (ut/text->paragraphs)
       (map ut/text->numbers)
       (map sum-numbers)
       (apply max)))

(comment
  (time (day1-part1 day1-puzzle))
  ;"Elapsed time: 13.852631 msecs"
  ;=> 73211
  )
