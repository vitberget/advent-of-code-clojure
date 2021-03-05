(ns year2020.day17.day17part2
  (:require [ysera.test :refer [is is= is-not deftest]]
            [clojure.string :as str]
            [clojure.set :as set]))

(defn string->state
  {:test (fn []
           (is= (string->state (str ".#.\n"
                                    "..#\n"
                                    "###"))
                #{{:x 1 :y 0 :z 0 :w 0}
                  {:x 2 :y 1 :z 0 :w 0}
                  {:x 0 :y 2 :z 0 :w 0} {:x 1 :y 2 :z 0 :w 0} {:x 2 :y 2 :z 0 :w 0}}))}
  [string]

  (->> string
       (str/split-lines)
       (map-indexed (fn [y row] (->> row
                                     (map-indexed (fn [x char]
                                                    (when (= char \#)
                                                      {:x x :y y :z 0 :w 0}))))))
       (flatten)
       (filter identity)
       (into #{})))

(defn range-from-state
  [state key]
  (let [vals (map key state)]
    (range (reduce min vals)
           (inc (reduce max vals)))))

(defn state-level->string
  {:test (fn []
           (is= (state-level->string #{{:x 1 :y 0 :z 0 :w 0}
                                       {:x 2 :y 1 :z 0 :w 0}
                                       {:x 0 :y 2 :z 0 :w 0} {:x 1 :y 2 :z 0 :w 0} {:x 2 :y 2 :z 0 :w 0}}
                                     0 0)
                (str ".#.\n"
                     "..#\n"
                     "###"))
           )}
  [state z w]
  (->> (for [y (range-from-state state :y)]
         (->> (for [x (range-from-state state :x)]
                (if (contains? state {:x x :y y :z z :w w}) \# \.))
              (str/join)))
       (str/join "\n")))

(defn print-state
  [state]
  (doseq [w (range-from-state state :w)
          z (range-from-state state :z)]
    (println "w=" w "z=" z)
    (println (state-level->string state z w))
    (println)))

(defn surrounding-positions
  {:test (fn []
           (is= (count (surrounding-positions {:x 10 :y 10 :z 10 :w 10}))
                80))}
  [position]
  (into #{}
        (for [dx (range -1 2)
              dy (range -1 2)
              dz (range -1 2)
              dw (range -1 2)
              :when (not= [dx dy dz dw] [0 0 0 0])]
          {:x (+ (:x position) dx)
           :y (+ (:y position) dy)
           :z (+ (:z position) dz)
           :w (+ (:w position) dw)})))

(defn conway-rule
  ;- If a cube is active and exactly 2 or 3 of its neighbors are also active,
  ; the cube remains active. Otherwise, the cube becomes inactive.
  ;- If a cube is inactive but exactly 3 of its neighbors are active,
  ; the cube becomes active. Otherwise, the cube remains inactive.
  [position state]
  (let [surrounding-living (->> position
                                (surrounding-positions)
                                (set/intersection state)
                                (count))]
    (when (or (= surrounding-living 3)
              (and (= surrounding-living 2) (contains? state position)))
      position)))

(defn conway-step
  [state]
  (->> state
       (map surrounding-positions)
       (cons state)
       (apply set/union)
       (map (fn [position] (conway-rule position state)))
       (filter identity)
       (into #{})))

(defn conway-do
  [state times]
  (loop [state state
         i 0]
    ;(println "Conway game" i)
    ;(print-state state)
    (if (= i times)
      state
      (recur (conway-step state) (inc i)))))

(defn day17part2
  [string num]
  (-> string
      (string->state)
      (conway-do num)
      (count)))

(comment
  (day17part2 (str ".#.\n"
                   "..#\n"
                   "###") 6)

  (let [puzzle "####...#\n......#.\n#..#.##.\n.#...#.#\n..###.#.\n##.###..\n.#...###\n.##....#"]
    (time (day17part2 puzzle 6)))
  ;"Elapsed time: 4897.618168 msecs"
  ;=> 960
  )
