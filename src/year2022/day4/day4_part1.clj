(ns year2022.day4.day4-part1
  (:require
    [clojure.string :as str]
    [utils.text :as ut]
    [year2022.day4.day4-data :refer [day4-example day4-puzzle]]
    [ysera.test :refer [is=]]))

(defn line->ranges
  {:test (fn [] (is= (line->ranges "2-4,6-8") [2 4 6 8]))}
  [line]
  (as-> line $
        (str/split $ #"[,-]")
        (map read-string $)))

(defn a-inside-b?
  [a-low a-high b-low b-high]
  (and (>= a-low b-low)
       (<= a-high b-high)))

(defn range-overlap-completely?
  [[r1-low r1-high r2-low r2-high]]
  (or
    (a-inside-b? r1-low r1-high r2-low r2-high)
    (a-inside-b? r2-low r2-high r1-low r1-high)))

(defn day4-part1
  {:test (fn []
           (is= (day4-part1 day4-example) 2)
           (is= (day4-part1 day4-puzzle) 444))}
  [text]
  (->> text
       (ut/text->lines)
       (map line->ranges)
       (filter range-overlap-completely?)
       (count)))

(comment
  (time (day4-part1 day4-puzzle))
  ;"Elapsed time: 4.45308 msecs"
  ;=> 444
  )
