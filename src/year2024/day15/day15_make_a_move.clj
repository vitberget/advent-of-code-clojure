(ns year2024.day15.day15-make-a-move
  (:require
    [ysera.test :refer [is=]]
    [year2024.day15.day15-data :refer [day15-example 
                                       day15-example-smaller
                                       day15-puzzle]]
    [year2024.day15.day15-parse :as parse]
    [clojure.set :as set]))

(def move-2
"########
#.@O.O.#
##..O..#
#...O..#
#.#.O..#
#...O..#
#......#
########")

(def move-3
"########
#..@OO.#
##..O..#
#...O..#
#.#.O..#
#...O..#
#......#
########")

(def move-4
"########
#...@OO#
##..O..#
#...O..#
#.#.O..#
#...O..#
#......#
########")

(defn get-robot-direction [instruction]
  (condp = instruction
    \^ [0 -1]
    \< [-1 0]
    \> [1 0]
    \v [0 1]))

(defn make-a-move
  {:test (fn [] 
           (let [example-small (first (parse/text->data day15-example-smaller))
                 move-2 (first (parse/text->data move-2))
                 move-3 (first (parse/text->data move-3))
                 move-4 (first (parse/text->data move-4))
                 ]
             (is= (make-a-move example-small \<) example-small)
             (is= (make-a-move example-small \^) move-2)
             (is= (make-a-move move-2 \>) move-3)
             (is= (make-a-move move-3 \>) move-4)
             (is= (make-a-move move-4 \>) move-4)))}
  [{robot :robot walls :walls boxes :boxes :as the-map} instruction]
  (let [robot-direction (get-robot-direction instruction)
        robot-moved (mapv + robot robot-direction)]
    (cond
      (contains? walls robot-moved)
      the-map 

      (not (contains? boxes robot-moved))
      (assoc the-map :robot robot-moved)

      :else
      (loop [prev-box-position robot]
        (let [next-box-position (mapv + prev-box-position robot-direction)]
          (cond 
            (contains? walls next-box-position)
            the-map

            (contains? boxes next-box-position)
            (recur next-box-position)

            :else ; the next position is space
            (-> the-map
                (assoc :robot robot-moved)
                (update :boxes (fn[boxes] (-> boxes
                                              (disj robot-moved)
                                              (conj next-box-position)))))))))))
