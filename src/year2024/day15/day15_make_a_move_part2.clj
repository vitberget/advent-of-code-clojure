(ns year2024.day15.day15-make-a-move-part2
  (:require [clojure.set :as set]))


(defn move-horizonally
  [{robot :robot walls :walls boxes :boxes :as the-map} delta-1 delta-2 wall-delta]
  (cond
    (contains? walls (mapv + robot wall-delta)) the-map     

    (contains? boxes (mapv + robot wall-delta)) 
    (loop [test-pos robot
           remove-positions #{}
           add-positions #{}]
      (let [testing (mapv + test-pos wall-delta)]
        (cond
          (contains? walls testing) 
          the-map

          (contains? boxes testing) 
          (recur (mapv + test-pos delta-2)
                 (conj remove-positions testing)
                 (conj add-positions (mapv + testing delta-1)))

          :else 
          (-> the-map
              (assoc :robot (if (empty? remove-positions)
                              robot
                              (mapv + robot delta-1)))
              (update :boxes set/difference remove-positions)
              (update :boxes set/union add-positions)
              (update :boxes disj (mapv + robot delta-1))))))

    :else
    (update the-map :robot (fn [robot] (mapv + robot delta-1)))))

(defn move-left [the-map] (move-horizonally the-map [-1 0] [-2 0] [-2 0]))
(defn move-right [the-map] (move-horizonally the-map [1 0] [2 0] [1 0]))


(defn get-walls-or-boxes
  [test-positions delta robot things]
  (->> test-positions
       (map (fn[[px py :as pos]]
              (if (= robot pos)
                (list [(dec px) py] 
                      pos)
                (list [(dec px) py] 
                      pos 
                      [(inc px) py]))))
       (apply concat)
       (map (fn[pos] (mapv + pos delta)))
       (into #{})
       (set/intersection things)))

(defn hits-wall? 
  [test-positions delta {robot :robot walls :walls}]
  (let [walls (get-walls-or-boxes test-positions delta robot walls)
        hits (not-empty walls)]
    hits))

(defn- get-next-row 
  [test-positions delta {robot :robot boxes :boxes}]
  (get-walls-or-boxes test-positions delta robot boxes))

(defn move-vertically 
  [{robot :robot walls :walls boxes :boxes :as the-map} delta]
  (cond
    (contains? walls (mapv + robot delta))
    the-map
    (contains? walls (mapv + robot delta [-1 0]))
    the-map

    (or (contains? boxes (mapv + robot delta))
        (contains? boxes (mapv + robot delta [-1 0])))
    (loop [loopie 0
           test-positions #{robot}
           remove-positions #{}
           add-positions #{}]
      (cond 
        (> loopie 90)
        "loopie"

        (hits-wall? test-positions delta the-map)
          the-map

        (empty? test-positions)
          (-> the-map
              (update :robot (fn[robot] (mapv + robot delta)))
              (update :boxes set/difference remove-positions)
              (update :boxes set/union add-positions))

        :else
          (let [next-row (get-next-row test-positions delta the-map)
                add-row (->> next-row
                             (map (fn [pos] (mapv + pos delta)))
                             (into #{}))]
            (recur (inc loopie)
                   next-row
                   (set/union remove-positions test-positions)
                   (set/union add-positions add-row)))))
    :else
    (update the-map :robot (fn [robot] (mapv + robot delta)))))

(defn move-up [the-map] (move-vertically the-map [0 -1]))
(defn move-down [the-map] (move-vertically the-map [0 1]))

(defn make-a-move-part2
  [the-map instruction]
  (condp = instruction
    \< (move-left the-map)
    \> (move-right the-map)
    \v (move-down the-map)
    \^ (move-up the-map)))
