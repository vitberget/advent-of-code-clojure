(ns year2022.day15.day15-part1
  (:require [clojure.set :as set]
            [utils.text :as ut]
            [year2022.day15.day15-data :refer [day15-example day15-puzzle]]
            [ysera.test :refer [is=]]))

(defn line->sensor-beacon
  {:test (fn []
           (is= (line->sensor-beacon "Sensor at x=2, y=18: closest beacon is at x=-2, y=15")
                {:sensor [2 18]
                 :beacon [-2 15]}))}
  [line]
  (let [[sx sy bx by] (->> line
                           (re-matcher #"Sensor at x=(\-?\d+), y=(\-?\d+): closest beacon is at x=(\-?\d+), y=(\-?\d+)")
                           (re-find)
                           (drop 1)
                           (map read-string))]
    {:sensor [sx sy]
     :beacon [bx by]}))

(defn add-to-row
  [row-set {sensor :sensor beacon :beacon} target-row]
  (let [manhattan (->> (mapv - sensor beacon)
                       (map abs)
                       (reduce +))
        vertical (abs (- (second sensor) target-row))
        x (first sensor)]
    (loop [row-set row-set
           horizontal 0]
      (cond (> (+ vertical horizontal) manhattan)
            row-set

            (zero? horizontal)
            (recur (conj row-set [x target-row])
                   (inc horizontal))

            :else
            (recur (conj row-set [(- x horizontal) target-row] [(+ x horizontal) target-row])
                   (inc horizontal))))))

(defn day15-part1
  {:test (fn []
           (is= (day15-part1 day15-example 10) 26))}
  [text target-row]
  (let [sensors-beacons (->> text
                             (ut/text->lines)
                             (map line->sensor-beacon))]
    (as-> sensors-beacons $
          (reduce (fn [row-set sensor-beacon]
                    (add-to-row row-set sensor-beacon target-row))
                  #{} $)
          (set/difference $ (->> sensors-beacons
                                 (map :beacon)
                                 (into #{})))
          (count $))))

(comment
  (time (day15-part1 day15-puzzle 2000000))
  ;"Elapsed time: 11549.338869 msecs"
  ;=> 5511201
  )
