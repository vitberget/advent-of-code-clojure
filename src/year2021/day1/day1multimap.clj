(ns year2021.day1.day1multimap
  (:require [year2021.day1.day1part1 :refer [text->numbers]]
            [year2021.day1.day1puzzle :refer [day1-example day1-puzzle]]
            [ysera.test :refer [is=]]))

(defn day1-delta-solution
  {:test (fn []
           (is= (day1-delta-solution 1 day1-example) 7)
           (is= (day1-delta-solution 3 day1-example) 5)
           (is= (day1-delta-solution 1 day1-puzzle) 1387)
           (is= (day1-delta-solution 3 day1-puzzle) 1362))}
  [delta text]
  (let [numbers (text->numbers text)
        numbers2 (drop delta numbers)]
    (->> (map < numbers numbers2)
         (filter identity)
         (count))))