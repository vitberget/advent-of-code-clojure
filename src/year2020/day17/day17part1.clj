(ns year2020.day17.day17part1
  (:require [ysera.test :refer [is is= is-not deftest]]
            [clojure.string :as str]
            [clojure.set :as set]))

(defn string->state
  {:test (fn []
           (is= (string->state (str ".#.\n"
                                    "..#\n"
                                    "###"))
                #{{:x 1 :y 0 :z 0}
                  {:x 2 :y 1 :z 0}
                  {:x 0 :y 2 :z 0} {:x 1 :y 2 :z 0} {:x 2 :y 2 :z 0}}))}
  [string]

  (->> string
       (str/split-lines)
       (map-indexed (fn [y row] (->> row
                                     (map-indexed (fn [x char]
                                                    (when (= char \#)
                                                      {:x x :y y :z 0}))))))
       (flatten)
       (filter identity)
       (into #{})))

(defn state-level->string
  {:test (fn []
           (is= (state-level->string #{{:x 1 :y 0 :z 0}
                                       {:x 2 :y 1 :z 0}
                                       {:x 0 :y 2 :z 0} {:x 1 :y 2 :z 0} {:x 2 :y 2 :z 0}}
                                     0)
                (str ".#.\n"
                     "..#\n"
                     "###"))
           )}
  [state z]
  (let [min-x (->> state (map :x) (reduce min))
        max-x (->> state (map :x) (reduce max))
        min-y (->> state (map :y) (reduce min))
        max-y (->> state (map :y) (reduce max))

        x-range (range min-x (inc max-x))
        y-range (range min-y (inc max-y))]
    (->> y-range
         (map (fn [y] (->> x-range
                           (map (fn [x]
                                  (if (contains? state {:x x :y y :z z})
                                    \#
                                    \.)))
                           (str/join))))
         (str/join "\n"))))

(defn print-state
  [state]
  (let [min-z (->> state (map :z) (reduce min))
        max-z (->> state (map :z) (reduce max))
        z-range (range min-z (inc max-z))]
    (->> z-range
         (run! (fn [z]
                 (println "z =" z)
                 (println (state-level->string state z))
                 (println))))))



(defn surrounding-positions
  {:test (fn []
           (is= (count (surrounding-positions {:x 10 :y 10 :z 10}))
                (- (* 9 3) 1)))}
  [position]
  (->> (range -1 2)
       (map (fn [dz]
              (->> (range -1 2)
                   (map (fn [dy]
                          (->> (range -1 2)
                               (filter (fn [dx] (or (not= dx 0) (not= dy 0) (not= dz 0))))
                               (map (fn [dx]
                                      {:x (+ (:x position) dx)
                                       :y (+ (:y position) dy)
                                       :z (+ (:z position) dz)}))))))))
       (flatten)
       (into #{})))

(defn conway-rule
  ;- If a cube is active and exactly 2 or 3 of its neighbors are also active,
  ; the cube remains active. Otherwise, the cube becomes inactive.
  ;- If a cube is inactive but exactly 3 of its neighbors are active,
  ; the cube becomes active. Otherwise, the cube remains inactive.
  {:test (fn []
           (let [state #{{:x 1 :y 0 :z 0}
                         {:x 2 :y 1 :z 0}
                         {:x 0 :y 2 :z 0} {:x 1 :y 2 :z 0} {:x 2 :y 2 :z 0}}]
             ;(print-state state)
             (is= (conway-rule {:x 0 :y 1 :z -1} state) {:x 0 :y 1 :z -1})))}
  [position state]
  (let [surrounding (->> position
                         (surrounding-positions))

        surrounding-living (->> surrounding
                                (set/intersection state)
                                (count))
        active (contains? state position)]

    (when (or (= surrounding-living 3)
              (and active (= surrounding-living 2)))
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
    ;(println "con do" i)
    ;(print-state state)
    (if (= i times)
      state
        (recur (conway-step state) (inc i)))))

(defn score-state
  [state]
  (->> state
       (filter (fn[pos] (= 0 (:z pos))))
       (count)))

(defn day17part1
  [string]
  (-> string
      (string->state)
      (conway-do 6)
      (count)))

(comment
  (day17part1 (str ".#.\n"
                   "..#\n"
                   "###"))

  (let [puzzle "####...#\n......#.\n#..#.##.\n.#...#.#\n..###.#.\n##.###..\n.#...###\n.##....#"]
    (time (day17part1 puzzle)))
  ;"Elapsed time: 476.285226 msecs" (with print-state)
  ;"Elapsed time: 408.745401 msecs" (without print-state)
  ;=> 286
  )
