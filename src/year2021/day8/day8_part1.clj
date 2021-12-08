(ns year2021.day8.day8-part1
  (:require [ysera.test :refer [is is= is-not deftest]]
            [year2021.day8.day8-data :refer [day8-example day8-puzzle]]
            [clojure.string :as str]))

(def segments-of-digits-1-4-7-8 #{2                         ; digit 1 has 2 segments
                                  4                         ; digit 4 has 4 segments
                                  3                         ; digit 7 has 3 segments
                                  7})                       ; digit 8 has 7 segments

(defn split-whitespace
  [line]
  (str/split line #"\s+"))

(defn day8-part1
  {:test (fn []
           (is= (day8-part1 day8-example) 26)
           (is= (day8-part1 day8-puzzle) 387))}
  [text]
  (->> text
       (str/split-lines)
       (map #(-> %
                 (str/split #" \| ")
                 (second)))
       (map str/trim)
       (mapcat split-whitespace)
       (filter #(contains?
                  segments-of-digits-1-4-7-8
                  (count %)))
       (count)))

(comment
  (time (day8-part1 day8-puzzle))
  ;"Elapsed time: 7.468041 msecs"
  ;=> 387
  )
