(ns year2024.day04.day04-part1
  (:require [ysera.test :refer [is=]]
            [year2024.day04.day04-data :refer [day04-example day04-puzzle]]
            [clojure.string :as str]))

(defn line->positions 
  [acc [y line]]
  (let [letters (map-indexed (fn [idx letter] [[letter [idx y]]]) line)]
    (reduce (fn [acc [[letter position]]]
              (update acc letter conj position))
            acc
            letters)))

(defn text->positions
  [text]
  (let [lines (map-indexed (fn [idx item] [idx item]) (str/split-lines text))]
    (reduce 
      line->positions 
      {\X #{} \M #{} \A #{} \S #{}} 
      lines)))

(def directions
  (list [-1 -1] [-1 0] [-1 1]
        [0 -1] [0 1]
        [1 -1] [1 0] [1 1]))

(defn xmas-in-direction?
  [[px py] [dx dy] positions]
  (and (contains? (get positions \M) [(+ px dx) (+ py dy)] )
       (contains? (get positions \A) [(+ px (* 2 dx)) (+ py (* 2 dy))])
       (contains? (get positions \S) [(+ px (* 3 dx)) (+ py (* 3 dy))])))

(defn count-xmas 
  [x-pos positions]
  (->> directions
       (filter (fn [direction] (xmas-in-direction? x-pos direction positions)))
       (count)))

(defn day04-part1
  {:test (fn []
           (is= (day04-part1 day04-example) 18))}
  [text]
  (let [positions (text->positions text)]
    (->> (get positions \X)
         (map (fn [x-pos] (count-xmas x-pos positions)))
         (reduce +))))

(comment
  (time (day04-part1 day04-puzzle))
  ; (out) "Elapsed time: 28.98076 msecs"
  ; 2571
  )
