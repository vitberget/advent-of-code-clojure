(ns year2022.day3.day3-part2
  (:require
    [clojure.set :as set]
    [utils.text :as ut]
    [year2022.day3.day3-data :refer [day3-example day3-puzzle]]
    [year2022.day3.day3-part1 :as part-1]
    [ysera.test :refer [is=]]))

(defn day3-part2
  {:test (fn []
           (is= (day3-part2 day3-example) 70)
           (is= (day3-part2 day3-puzzle) 2508))}
  [text]
    (->> text
         (ut/text->lines)
         (map #(into #{} %))
         (partition 3)
         (map #(apply set/intersection %))
         (map part-1/prioritize)
         (reduce +)))

  (comment
    (time (day3-part2 day3-puzzle))
    ;"Elapsed time: 1.614015 msecs"
    ;=> 2508
    )
