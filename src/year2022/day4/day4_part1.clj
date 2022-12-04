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

(defn a-in-b?
  [a-l a-h b-l b-h]
  (and (>= a-l b-l)
       (<= a-h b-h)))

(defn range-overlap?
  [[r1-l r1-h r2-l r2-h]]
  (or
    (a-in-b? r1-l r1-h r2-l r2-h)
    (a-in-b? r2-l r2-h r1-l r1-h)))

(defn day4-part1
  {:test (fn []
           (is= (day4-part1 day4-example) 2)
           (is= (day4-part1 day4-puzzle) 444))}
  [text]
  (->> text
       (ut/text->lines)
       (map line->ranges)
       (filter range-overlap?)
       (count)))

(comment
  (time (day4-part1 day4-puzzle))
  ;"Elapsed time: 4.45308 msecs"
  ;=> 444
  )
