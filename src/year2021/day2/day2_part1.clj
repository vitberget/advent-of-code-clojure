(ns year2021.day2.day2-part1
  (:require [ysera.test :refer [is is= is-not deftest]]
            [year2021.day2.data-day2 :refer [day2-example day2-puzzle]]
            [clojure.string :as str]))

(defn day2-part1
  {:test (fn []
           (is= (day2-part1 day2-example) 150))}
  [text]
  (->> text
       (str/split-lines)
       (map (fn [line] (str/split line #" ")))
       (map (fn [[word number]] [word (read-string number)]))
       (reduce
         (fn [state [word number]]
           (condp = word
             "down" (update state :d + number)
             "up" (update state :d - number)
             "forward" (update state :f + number)))
         {:f 0 :d 0})
       (vals)
       (reduce *)))

(comment
  (time (day2-part1 day2-puzzle))
  ;"Elapsed time: 2.331658 msecs"
  ;=> 1962940
  )
