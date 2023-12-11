(ns year2023.day11.day11-part2
  (:require [ysera.test :refer [is=]]
            [year2023.day11.day11-part1 :as part-1]
            [year2023.day11.day11-data :refer [day11-example day11-puzzle]]))

(defn grow-galaxy 
  [{galaxies :galaxies empty-columns :empty-columns empty-rows :empty-rows factor :factor}]
  (->> galaxies
       (map (fn [[x y]] [(->> empty-columns 
                              (filter (fn [c] (< c x))) 
                              (count) 
                              (* factor)
                              (+ x)) 
                         (->> empty-rows 
                              (filter (fn [r] (< r y)))
                              (count) 
                              (* factor)
                              (+ y))]))))
(defn day11-part2
  {:test (fn []
           (is= (day11-part2 day11-example 10) 1030)
           (is= (day11-part2 day11-example 100) 8410))}
  [text spaces]
  (let [galaxies (part-1/text->galaxies text)
        width (->> galaxies (map first) (reduce max) (inc))
        height (->> galaxies (map second) (reduce max) (inc))
        empty-columns (part-1/find-empty-columns {:galaxies galaxies :width width})
        empty-rows (part-1/find-empty-rows {:galaxies galaxies :height height})
        grown-galaxies (grow-galaxy {:galaxies galaxies 
                                     :empty-columns empty-columns 
                                     :empty-rows empty-rows
                                     :factor (dec spaces)})]
      (loop [[galaxy & galaxies] grown-galaxies
             summary 0]
        (if (empty? galaxies)
          summary
          (recur galaxies
                 (+ summary (part-1/calculate-galaxies-distances galaxy galaxies)))))))

(comment
  (time (day11-part2 day11-puzzle 1000000))
  ; (out) "Elapsed time: 77.87378 msecs"
  ; 625243292686
  )
