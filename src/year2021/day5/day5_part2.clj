(ns year2021.day5.day5-part2
  (:require [ysera.test :refer [is is= is-not deftest]]
            [year2021.day5.day5-data :refer [day5-example day5-puzzle]]
            [year2021.day5.day5-part1 :refer [text->state
                                              line->coverage
                                              coverage->map
                                              update-the-map]]))

(defn day5-part2
  {:test (fn []
           (is= (day5-part2 day5-example) 12))}
  [text]
  (->> (text->state text)
       (map line->coverage)
       (map coverage->map)
       (reduce update-the-map)
       (vals)
       (filter (fn[n] (> n 1)))
       (count)))

(comment
  (time (day5-part2 day5-puzzle))
  ;"Elapsed time: 249.182724 msecs"
  ;=> 21466
  )