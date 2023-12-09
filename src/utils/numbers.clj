(ns utils.numbers
  (:require [ysera.test :refer [is is= is-not deftest]]))


(defn limit
  {:test (fn []
           (is= (limit 3 0 2) 2)
           (is= (limit -30 -2 2) -2)
           (is= (limit 1 0 2) 1))}
  [val lower-limit higher-limit]
  (cond
    (< val lower-limit)
    lower-limit

    (> val higher-limit)
    higher-limit

    :else val))

(defn manhattan-distance
  {:test (fn []
           (is= (manhattan-distance [1 0] [0 0]) 1)
           (is= (manhattan-distance [10 0] [0 10]) 20))}
  [pos-1 pos-2]
  (->> (mapv - pos-1 pos-2)
       (map abs)
       (reduce +)))

(defn inc-nil-is-zero
  {:test (fn []
           (is= (inc-nil-is-zero nil) 1)
           (is= (inc-nil-is-zero 0) 1)
           (is= (inc-nil-is-zero 1) 2)
           (is= (inc-nil-is-zero 11) 12))}
  [val]
  (inc (or val 0)))

(defn all-zeroes?
  {:test (fn [] 
           (is (all-zeroes? [0 0 0 0]))
           (is-not (all-zeroes? [0 1 2 3]))
           (is-not (all-zeroes? [3 0 0 0])))}
  [numbers]
  (loop [[number & numbers] numbers]
    (cond
      (nil? number) true
      (not (zero? number)) false
      :else (recur numbers))))
