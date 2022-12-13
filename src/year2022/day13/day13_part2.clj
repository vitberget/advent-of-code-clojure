(ns year2022.day13.day13-part2
  (:require [clojure.string :as str]
            [utils.text :as ut]
            [year2022.day13.day13-data :refer [day13-example day13-puzzle]]
            [year2022.day13.day13-part1 :as part-1]
            [ysera.test :refer [is=]]))

(defn day13-part2
  {:test (fn []
           (is= (day13-part2 day13-example) 140)
           (is= (day13-part2 day13-puzzle) 26289))}
  [text]
  (->> text
       (ut/text->lines)
       (remove str/blank?)
       (cons "[[2]]")
       (cons "[[6]]")
       (map read-string)
       (sort part-1/compare-things)
       (map-indexed (fn [i v] [(inc i) v]))
       (filter (fn [[_ v]]
                 (or (= v [[2]])
                     (= v [[6]]))))
       (map first)
       (reduce *)))


(comment
  (time (day13-part2 day13-puzzle))
  ;"Elapsed time: 27.278917 msecs"
  ;=> 26289
  )
