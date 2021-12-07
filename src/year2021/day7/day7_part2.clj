(ns year2021.day7.day7-part2
  (:require [ysera.test :refer [is is= is-not deftest]]
            [year2021.day7.day7-data :refer [day7-example day7-puzzle]]
            [year2021.day7.day7-part1 :refer [text->freqs]]
            [clojure.math.numeric-tower :as math]))

(defn calc-fuel-one-sub
  "actually triangle number..."
  {:test (fn []
           (is= (calc-fuel-one-sub 16 5) 66)
           (is= (calc-fuel-one-sub 1 5) 10)
           (is= (calc-fuel-one-sub 2 5) 6)
           (is= (calc-fuel-one-sub 0 5) 15)
           (is= (calc-fuel-one-sub 4 5) 1)
           (is= (calc-fuel-one-sub 7 5) 3)
           (is= (calc-fuel-one-sub 14 5) 45))}
  [sub-depth depth]
  (let [d (math/abs (- sub-depth depth))]
    (/ (* d (inc d))
       2)))

(defn calc-fuel
  {:test (fn []
           (let [freqs (text->freqs "16,1,2,0,4,2,7,1,2,14")]
             (is= (calc-fuel freqs 2) 206)
             (is= (calc-fuel freqs 5) 168)))}
  [freqs depth]
  (->> freqs
       (map (fn [[d n]] (* n (calc-fuel-one-sub depth d))))
       (reduce +)))

(defn day7-part2
  {:test (fn []
           (is= (day7-part2 "16,1,2,0,4,2,7,1,2,14") 168))}
  [text]
  (let [freqs (text->freqs text)
        depths (keys freqs)
        min-depth (reduce min depths)
        max-depth (reduce max depths)
        check-these (range min-depth (inc max-depth))]
    (->> check-these
         (map (fn [d] (calc-fuel freqs d)))
         (reduce min))))

(comment
  (time (day7-part2 day7-puzzle))
  ;"Elapsed time: 181.433358 msecs"
  ;=> 98363777
  )