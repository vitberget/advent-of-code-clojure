(ns year2024.day15.day15-part2
  (:require
   [year2024.day15.day15-data :refer [day15-example day15-example-part2 day15-puzzle]]
   [year2024.day15.day15-make-a-move-part2 :refer [make-a-move-part2]]
   [year2024.day15.day15-parse :as parse]
   [year2024.day15.day15-part1 :as part-1]
   [year2024.day15.day15-print-part2 :refer [print-the-map-part2]]
   [ysera.test :refer [is=]]))

(defn grow-coord
  [[x y]]
  [(* 2 x) y])

(defn grow-map 
  [{robot :robot walls :walls boxes :boxes}]
  {:robot (grow-coord robot)
   :boxes (->> boxes (map grow-coord) (into #{}))
   :walls (->> walls (map grow-coord) (into #{}))})

(defn get-final-map
  [the-map instructions debug]
  (let [instructions (map-indexed (fn [i v] [i v]) instructions)]
  (when debug (print-the-map-part2 the-map ["-" "Initual state"]))
  (reduce (fn[the-map instruction]
            (let [the-map (make-a-move-part2 the-map (second instruction))]
              (when debug (print-the-map-part2 the-map instruction))
              the-map))
          the-map 
          instructions)))

(defn day15-part2
  {:test (fn []
           (is= (day15-part2 day15-example) 9021)
           (is= (day15-part2 day15-puzzle) 1550677))}
  [text]
  (let [[the-map instructions] (parse/text->data text)
        the-map (grow-map the-map) 
        instructions (part-1/clean-instructions instructions)
        final-map (get-final-map the-map instructions false)]
      (part-1/the-map->score final-map)))

(comment
  (day15-part2 day15-example-part2)
  (time (day15-part2 day15-puzzle))
  ;
  ; (out) "Elapsed time: 83.96172 msecs"
  ; 1550677
  )
