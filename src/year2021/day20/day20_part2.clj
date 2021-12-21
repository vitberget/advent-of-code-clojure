(ns year2021.day20.day20-part2
  (:require [ysera.test :refer [is is= is-not deftest]]
            [year2021.day20.day20-data :refer [day20-example day20-puzzle]]
            [clojure.pprint :refer [pprint]]
            [year2021.day20.day20-part1 :as part1]))

(defn enhance-image
  [algorithm image level]
  (let [points (reduce (fn [image _]
                         (->> image
                              (mapcat (fn [[px py]]
                                        (map (fn [[dx dy]]
                                               [(+ px dx) (+ py dy)])
                                             part1/nine-grid)))
                              (into #{})))
                       image
                       (range level))]
    (->> points
         (pmap (fn [point] (part1/enhance-point point image algorithm level)))
         (filter identity))))

(defn day20-part2
  {:test (fn []
           (is= (day20-part2 day20-example 2) 35))}
  [text level]
  (let [{algorithm :algorithm image :image} (part1/text->algorithm-and-image text)]
    (count (enhance-image algorithm image level))))

(comment
  (time (day20-part2 day20-example 50))
  ;"Elapsed time: 108142.452604 msecs"
  ;=> 3351
  (time (day20-part2 day20-puzzle 2))
  (time (day20-part2 day20-puzzle 50))
  ;"Elapsed time: 326839.089511 msecs"
  ;=> 19592
  )