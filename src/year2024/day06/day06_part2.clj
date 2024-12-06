(ns year2024.day06.day06-part2
  (:require [ysera.test :refer [is=]]
            [year2024.day06.day06-part1 :as part-1]
            [year2024.day06.day06-data :refer [day06-example day06-puzzle]]))

(defn get-day-1
  [position obstacles map-size]
    (loop [loopies 0 
           position position
           direction [0 -1]
           visited #{position}]
      (cond 
        (part-1/outside? position map-size) visited
        (> loopies 10000) -1
        :else (let [[position direction] (part-1/next-step position direction obstacles)]
                (recur (inc loopies) 
                       position 
                       direction 
                       (conj visited position))))))

(defn next-step-or-turn
  [[x y :as position] [dx dy :as direction] obstacles]
  (let [new-position [(+ x dx) (+ y dy)]]
    (if (contains? obstacles new-position)
      [position (part-1/turn-right direction)]
      [new-position direction])))

(defn stuck-in-loop?
  [position visit obstacles map-size]
  (let [obstacles (conj obstacles visit)]
    (loop [loopies 0 
           position position
           direction [0 -1]
           visited-now #{}]
      (cond 
        (part-1/outside? position map-size) 
        false

        (contains? visited-now [position direction])
        true

        (> loopies 10000) -1
        :else (let [[new-position new-direction] (next-step-or-turn position direction obstacles)]
                (recur (inc loopies) 
                       new-position 
                       new-direction
                       (conj visited-now [position direction])))))))

(defn day06-part2
  {:test (fn []
           (is= (day06-part2 day06-example) 6))}
  [text]
  (let [the-map (part-1/text->map text)
        position (-> the-map
                     (get \^)
                     (first))
        obstacles (get the-map \#)
        map-size (part-1/get-size obstacles)
        visited (get-day-1 position obstacles map-size)
        visited (disj visited position)]
    (->> visited
         (pmap (fn [visit] (stuck-in-loop? position visit obstacles map-size)))
         (filter identity)
         (count))))

(comment
  (time (day06-part2 day06-puzzle))
  ; (out) "Elapsed time: 3408.207101 msecs"
  ; 1995
  )
