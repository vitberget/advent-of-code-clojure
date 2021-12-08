(ns year2021.day8.day8-part1
  (:require [ysera.test :refer [is is= is-not deftest]]
            [year2021.day8.day8-data :refer [day8-example day8-puzzle]]
            [clojure.string :as str]))

(defn day8-part1
  {:test (fn []
           (is= (day8-part1 day8-example) 26))}
  [text]
  (->> text
       (str/split-lines)
       (map (fn [line] (second (str/split line #" \| "))))
       (map str/trim)
       (mapcat (fn [line] (str/split line #"\s+")))
       (filter (fn [word] (contains?
                            #{2 4 3 7}                      ; lenth of digit 1 4 7 8
                            (count word))))
       (count)))

(comment
  (time (day8-part1 day8-puzzle))
  ;"Elapsed time: 7.468041 msecs"
  ;=> 387
  )
