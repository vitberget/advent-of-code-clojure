(ns utils.numbers
  (:require [clojure.string :as str]
            [ysera.test :refer [is is= is-not deftest]]))

(defn limit
  {:test (fn []
           (is= (limit 3 0 2) 2)
           (is= (limit -30 -2 2) -2)
           (is= (limit 1 0 2) 1))}
  [value lower-limit higher-limit]
  (cond
    (< value lower-limit) lower-limit
    (> value higher-limit) higher-limit
    :else value))

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

(defn enumerate 
  {:test (fn []
           (is= (enumerate [\a \b \c]) [[0 \a] [1 \b] [2 \c]]))}
  [lst]
  (->> lst
       (map-indexed (fn [idx item] [idx item]))))

(defn to-binary-string 
  {:test (fn []
           (is= (to-binary-string 2r1010) "1010")
           (is= (to-binary-string 2r1111010) "1111010"))}
  [n]
  (Integer/toString n 2))

(defn to-hex-string 
  {:test (fn []
           (is= (to-hex-string 16r1010) "1010")
           (is= (to-hex-string 16rABCD) "ABCD"))}
  [n]
  (-> n 
      (Integer/toString 16)
      (str/upper-case)))
