(ns year2024.day04.day04-part2
  (:require [ysera.test :refer [is=]]
            [year2024.day04.day04-part1 :as part-1]
            [year2024.day04.day04-data :refer [day04-example day04-puzzle]]))

(defn delta 
  [[px py] [dx dy]]
  [(- px dx) (- py dy)])

(defn x-mas? 
  [a-pos positions]
  (let [corner-1 (delta a-pos [-1 -1])
        corner-2 (delta a-pos [1 1])
        corner-3 (delta a-pos [1 -1])
        corner-4 (delta a-pos [-1 1])
        m-positions (get positions \M)
        s-positions (get positions \S)]
    (or 
      (and (contains? m-positions corner-1)
           (contains? s-positions corner-2)
           (contains? m-positions corner-3)
           (contains? s-positions corner-4))

      (and (contains? m-positions corner-1)
           (contains? s-positions corner-2)
           (contains? s-positions corner-3)
           (contains? m-positions corner-4))

      (and (contains? s-positions corner-1)
           (contains? m-positions corner-2)
           (contains? m-positions corner-3)
           (contains? s-positions corner-4))

      (and (contains? s-positions corner-1)
           (contains? m-positions corner-2)
           (contains? s-positions corner-3)
           (contains? m-positions corner-4)))))

(defn day04-part2
  {:test (fn []
           (is= (day04-part2 day04-example) 9))}
  [text]
  (let [positions (part-1/text->positions text)]
    (->> (get positions \A)
         (filter (fn [x-pos] (x-mas? x-pos positions)))
         (count))))

(comment
  (time (day04-part2 day04-puzzle))
  ; (out) "Elapsed time: 19.373034 msecs"
  ; 1992
  )
