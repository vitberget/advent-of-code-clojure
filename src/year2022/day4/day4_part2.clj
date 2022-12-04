(ns year2022.day4.day4-part2
  (:require
    [utils.text :as ut]
    [year2022.day4.day4-data :refer [day4-example day4-puzzle]]
    [year2022.day4.day4-part1 :as part-1]
    [ysera.test :refer [is is-not is=]]))

(defn a-partial-overlaps-b?
  [a-low a-high b-low b-high]
  (and (<= a-low b-low)
       (<= a-high b-high)
       (>= a-high b-low)))

(defn a-overlaps-b?
  {:test (fn []
           (is (a-overlaps-b? 5 7 7 9))
           (is (a-overlaps-b? 2 8 3 7))
           (is (a-overlaps-b? 6 6 4 6))
           (is (a-overlaps-b? 5 7 7 9))
           (is-not (a-overlaps-b? 2 4 6 8))
           (is-not (a-overlaps-b? 2 3 4 5)))}
  [a-low a-high b-low b-high]
  (or (part-1/a-inside-b? a-low a-high b-low b-high)
      (part-1/a-inside-b? b-low b-high a-low a-high)
      (a-partial-overlaps-b? a-low a-high b-low b-high)
      (a-partial-overlaps-b? b-low b-high a-low a-high)))

(defn day4-part2
  {:test (fn []
           (is= (day4-part2 day4-example) 4)
           (is= (day4-part2 day4-puzzle) 801))}
  [text]
  (->> text
       (ut/text->lines)
       (map part-1/line->ranges)
       (filter #(apply a-overlaps-b? %))
       (count)))

(comment
  (time (day4-part2 day4-puzzle))
  ;"Elapsed time: 3.309198 msecs"
  ;=> 801
  )
