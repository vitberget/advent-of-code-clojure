(ns year2023.day03.day03-part2
  (:require [clojure.set :as set]
            [year2023.day03.day03-data :refer [day03-example day03-puzzle]]
            [year2023.day03.day03-part1 :as part-1]
            [ysera.test :refer [is=]]))

(defn surrounding-numbers [sym numbers]
  (let [ss (->> sym
                (part-1/surrounding-positions)
                (into #{}))]
    (->> numbers
         (filter (fn [number]
                   (not-empty (set/intersection ss (:surrounding number))))))))

(defn numbers-with-all-surrounding [number]
  (assoc number :surrounding
         (->> number
              (:positions)
              (into #{}))))

(defn day03-part2
  {:test (fn []
           (is= (day03-part2 day03-example) 467835))}
  [text]
  (let [schematic (part-1/text->schematic text)
        numbers (->> schematic
                     (part-1/schematic->numbers)
                     (map numbers-with-all-surrounding))
        symbols (part-1/schematic->symbols schematic)]
    (->> symbols
         (keys)
         (map (fn[sym](surrounding-numbers sym numbers)))
         (filter (fn [numbers] (= (count numbers) 2)))
         (map (fn[numbers] (map :number numbers)))
         (map (fn[numbers] (apply * numbers)))
         (apply +))))

(comment
  (time (day03-part2 day03-puzzle))
  ; (out) "Elapsed time: 448.308409 msecs"
  ; 75519888
  )
