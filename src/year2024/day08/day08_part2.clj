(ns year2024.day08.day08-part2
  (:require
   [clojure.set :as set]
   [year2024.day08.day08-data :refer [day08-example day08-example-2 day08-puzzle]]
   [year2024.day08.day08-part1 :as part-1]
   [ysera.test :refer [is=]]))

(defn do-the-antinodes [pos [dx dy] op map-size]
  (loop [antinodes #{pos}
         [x y] pos]
    (let [pos [(op x dx) (op y dy)]]
    (if (part-1/inside? pos map-size)
      (recur (conj antinodes pos) pos) 
      antinodes))))

(defn two-antennas->antinodes [[a1-x a1-y :as a1] [a2-x a2-y :as a2] map-size]
  (let [delta [(- a2-x a1-x) (- a2-y a1-y)]]
    (set/union (do-the-antinodes a1 delta - map-size)
               (do-the-antinodes a2 delta + map-size))))

(defn antennas->antinodes-partly [antenna antennas antinodes map-size]
  (loop [[other-antenna & antennas] antennas
         antinodes antinodes]
    (if (nil? other-antenna)
      antinodes
      (recur antennas
             (set/union antinodes (two-antennas->antinodes antenna other-antenna map-size))))))

(defn antennas->antinodes
  [antennas map-size]
  (loop [[antenna & antennas] antennas
         antinodes #{}]
    (if (empty? antennas)
      antinodes
      (recur antennas
             (antennas->antinodes-partly antenna antennas antinodes map-size)))))

(defn day08-part2
  {:test (fn []
           (is= (day08-part2 day08-example) 34)
           (is= (day08-part2 day08-example-2) 9))}
  [text]
  (let [map-size (part-1/get-map-size text)
        antennas (part-1/text->antennas text)]
    (->> antennas
         (vals)
         (map (fn [antennas](antennas->antinodes antennas map-size)))
         (apply set/union)
         (count))))

(comment
  (time (day08-part2 day08-puzzle))
  ; (out) "Elapsed time: 3.502367 msecs"
  ; 1126
  )
