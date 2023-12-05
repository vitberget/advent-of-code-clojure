(ns year2023.day05.day05-part2
  (:require [ysera.test :refer [is is= is-not deftest]]
            [year2023.day05.day05-part1 :as part-1]
            [year2023.day05.day05-data :refer [day05-example day05-puzzle]]))

(defn- do-seed-range [start size almenac]
  (loop [seed start
         least nil]
    (if (>= seed (+ start size))
      least
      (let [location (part-1/do-entire-translation seed almenac)]
        (recur
          (inc seed)
          (if (nil? least)
            location
            (min location least))) ))))

(defn day05-part2
  {:test (fn []
           (is= (day05-part2 day05-example) 46))}
  [text]
  (let [almenac (part-1/text->almenac text)]
    (->> almenac
         (:seeds)
         (partition 2 2)
         (pmap (fn [[start size]] (do-seed-range start size almenac)))
         (apply min))))

(comment
  (time (day05-part2 day05-puzzle))
  ; Probably works, really slow, did it in Rust instead 
  ; https://github.com/vitberget/aoc-rust/blob/master/src/bin/year2023_day05/part_2.rs
  )
