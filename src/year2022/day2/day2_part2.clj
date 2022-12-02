(ns year2022.day2.day2-part2
  (:require [ysera.test :refer [is is= is-not deftest]]
            [year2022.day2.day2-part1 :as part1]
            [year2022.day2.day2-data :refer [day2-example day2-puzzle]]
            [clojure.string :as str]))

(def select-loss
  {:rock :scissors
   :paper :rock
   :scissors :paper})

(def select-win
  {:rock :paper
   :paper :scissors
   :scissors :rock})

(defn select-you
  [[opponent desire]]
  [opponent (condp = desire
    :rock (select-loss opponent)
    :paper opponent
    :scissors (select-win opponent))])

(defn day2-part2
  {:test (fn []
           (is= (day2-part2 day2-example) 12))}
  [text]
  (->> text
       (str/split-lines)
       (map part1/line->rps)
       (map select-you)
       (map (fn [p] (apply part1/score p)))
       (reduce +)))

(comment
  (time (day2-part2 day2-puzzle))
  ;"Elapsed time: 4.993111 msecs"
  ;=> 16862
  )
