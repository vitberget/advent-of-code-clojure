(ns year2021.day8.day8-part1
  (:require [ysera.test :refer [is is= is-not deftest]]
            [year2021.day8.day8-data :refer [day8-example day8-puzzle]]
            [clojure.string :as str]))

(defn day8-part1
  {:test (fn []
           (is= (day8-part1 day8-example) 26))}
  [text]
  (as-> text $
        (str/split-lines $)
        (map (fn [line] (second (str/split line #" \| "))) $)
        (map str/trim $)
        (mapcat (fn [line] (str/split line #"\s+")) $)
        (filter (fn [word] (let [c (count word)]
                             (or (= c 2) ; 1
                                 (= c 4) ; 4
                                 (= c 3) ; 7
                                 (= c 7)))) ; 8
                $)
        (count $)))

(comment
  (time (day8-part1 day8-puzzle))
  ;"Elapsed time: 7.468041 msecs"
  ;=> 387
  )
