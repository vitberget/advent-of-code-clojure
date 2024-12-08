(ns year2024.day08.day08-part1
  (:require [ysera.test :refer [is=]]
            [year2024.day08.day08-data :refer [day08-example day08-puzzle]]
            [utils.text :as ut]
            [clojure.set :as set]))

(defn get-map-size
  [text]
  (let [lines (ut/text->lines text)]
    [(count (first lines)) (count lines)]))

(defn text->antennas
  [text]
  (->> text
       (ut/text->lines)
       (map-indexed (fn [y line] [y line]))
       (reduce (fn [antennas [y line]]
                  (->> line
                       (map-indexed (fn [x ch] [x ch]))
                       (reduce (fn [antennas [x ch]]
                                (if (= ch \.)
                                  antennas
                                  (update antennas ch (fn [wee] (conj (or wee #{}) [x y])))) )
                               antennas))) 
               {})))

(defn two-antennas->antinodes [[a1-x a1-y] [a2-x a2-y]]
  (let [dx (- a2-x a1-x)
        dy (- a2-y a1-y)]
    #{[(- a1-x dx) (- a1-y dy)]
      [(+ a2-x dx) (+ a2-y dy)]}))

(defn antennas->antinodes-partly [antenna antennas antinodes]
  (loop [[other-antenna & antennas] antennas
         antinodes antinodes]
    (if (nil? other-antenna)
      antinodes
      (recur antennas
             (set/union antinodes (two-antennas->antinodes antenna other-antenna))))))

(defn antennas->antinodes
  [antennas]
  (loop [[antenna & antennas] antennas
         antinodes #{}]
    (if (empty? antennas)
      antinodes
      (recur antennas
             (antennas->antinodes-partly antenna antennas antinodes)))))

(defn inside? 
  [[x y] [w h]]
  (and (>= x 0)
       (>= y 0)
       (< x w)
       (< y h)))

(defn day08-part1
  {:test (fn []
           (is= (day08-part1 day08-example) 14))}
  [text]
  (let [map-size (get-map-size text)
        antennas (text->antennas text)]
    (->> antennas
         (vals)
         (map antennas->antinodes)
         (apply set/union)
         (filter (fn[antinode] (inside? antinode map-size)))
         (count))))


(comment
  (time (day08-part1 day08-puzzle))
  ; (out) "Elapsed time: 1.720038 msecs"
  ; 318
  )
