(ns year2022.day1.day1-part1
  (:require [ysera.test :refer [is is= is-not deftest]]
            [year2022.day1.day1-data :refer [day1-example day1-puzzle]]
            [clojure.string :as str]))

(defn text->numbers
  [text]
  (->> text
       (str/split-lines)
       (map read-string)))

(defn sum-numbers
  [numbers]
  (apply + numbers))

(defn day1-part1
  {:test (fn []
           (is= (day1-part1 day1-example) 24000))}
  [text]
  (as-> text $
        (str/split $ #"\n\n")
        (map text->numbers $)
        (map sum-numbers $)
        (apply max $)))

(comment
  (time (day1-part1 day1-puzzle))
  ;"Elapsed time: 13.852631 msecs"
  ;=> 73211
  )
