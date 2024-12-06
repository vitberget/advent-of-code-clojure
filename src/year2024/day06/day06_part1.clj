(ns year2024.day06.day06-part1
  (:require [ysera.test :refer [is=]]
            [year2024.day06.day06-data :refer [day06-example day06-puzzle]]
            [utils.text :as ut]))

(defn line->map 
  [y line]
  (->> line
       (map-indexed (fn [x ch] [ch [x y]]))))

(defn text->map 
  [text]
  (->> text
       (ut/text->lines)
       (map-indexed line->map)
       (apply concat)
       (filter (fn [[ch _]] (not= ch \.)))
       (reduce (fn [the-map [ch pos]]
                 (update the-map ch (fn [positions] (-> positions
                                                        (or positions #{})
                                                        (conj pos)))))
               {})))

(defn get-size 
  [obstacles]
  (reduce  (fn [[ax ay] [x y]] [(max ax x) (max ay y)]) obstacles))


(defn outside?
  [[x y] [max-x max-y]]
  (or (< x 0)
      (< y 0)
      (> x max-x)
      (> y max-y)))

(defn turn-right
  [direction]
  (condp = direction
    [0 -1] [1 0]
    [1 0] [0 1]
    [0 1] [-1 0]
    [-1 0] [0 -1]))

(defn next-step
  [[x y] [dx dy :as direction] obstacles]
  (let [position [(+ x dx) (+ y dy)]]
    (if (contains? obstacles position)
      (let [[dx dy :as direction] (turn-right direction)]
        [[(+ x dx) (+ y dy)] direction])
      [position direction])))

(defn day06-part1
  {:test (fn []
           (is= (day06-part1 day06-example) 41))}
  [text]
  (let [the-map (text->map text)
        position (-> the-map
                     (get \^)
                     (first))
        obstacles (get the-map \#)
        map-size (get-size obstacles)]
    (loop [loopies 0 
           position position
           direction [0 -1]
           visited #{position}]
      (cond 
        (outside? position map-size) (dec (count visited))
        (> loopies 10000) -1
        :else (let [[position direction] (next-step position direction obstacles)]
                (recur (inc loopies) position direction (conj visited position)))))))


(comment
  (time (day06-part1 day06-puzzle))
  ; (out) "Elapsed time: 8.587838 msecs"
  ; 4890
  )
