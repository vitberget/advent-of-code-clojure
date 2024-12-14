(ns year2024.day14.day14-part1
  (:require
   [clojure.edn :as edn]
   [utils.text :as ut]
   [year2024.day14.day14-data :refer [day14-example day14-puzzle]]
   [ysera.test :refer [is=]]))

(defn line->robot 
  [line]
  (let [[[px py] [vx vy]] (->> line
                               (ut/split-on #"\s")
                               (map (fn [part] (subs part 2)))
                               (map (fn [part] (->> part
                                                    (ut/split-on #",")
                                                    (map edn/read-string)))))]
    {:position [px py]
     :velocity [vx vy]}))

(defn move-robot 
  {:test (fn[]
           (is= (move-robot {:position [2 4] :velocity [2 -3]} [11 7] 1) {:position [4 1] :velocity [2 -3]})
           (is= (move-robot {:position [2 4] :velocity [2 -3]} [11 7] 2) {:position [6 5] :velocity [2 -3]})
           (is= (move-robot {:position [2 4] :velocity [2 -3]} [11 7] 5) {:position [1 3] :velocity [2 -3]}))}
  [{[vx vy] :velocity  :as robot} [width height] seconds]
  (-> robot
      (update-in [:position 0] + (* seconds vx))
      (update-in [:position 0] mod width)
      (update-in [:position 1] + (* seconds vy))
      (update-in [:position 1] mod height)))

(defn position->quadrant 
  {:test (fn[]
           (is= (position->quadrant [0 2] [11 7]) :quadrant-1)
           (is= (position->quadrant [5 2] [11 7]) nil)
           (is= (position->quadrant [6 0] [11 7]) :quadrant-2))}
  [[x y] [width height]]
  (let [middle-x (quot width 2)
        middly-y (quot height 2)]
    (cond 
      (or (= x middle-x) (= y middly-y)) nil
      (and (< x middle-x) (< y middly-y)) :quadrant-1
      (and (> x middle-x) (< y middly-y)) :quadrant-2
      (and (< x middle-x) (> y middly-y)) :quadrant-3
      (and (> x middle-x) (> y middly-y)) :quadrant-4)))

(defn day14-part1
  {:test (fn [] (is= (day14-part1 day14-example [11 7] 100) 12))}
  [text size seconds]
  (->> text
       (ut/text->lines)
       (map line->robot)
       (map (fn [robot] (move-robot robot size seconds)))
       (map :position)
       (map (fn [position] (position->quadrant position size)))
       (remove nil?)
       (frequencies)
       (vals)
       (reduce *)))

(comment
  (time (day14-part1 day14-puzzle [101 103] 100))
  ; (out) "Elapsed time: 3.289347 msecs"
  ; 226548000
  )
