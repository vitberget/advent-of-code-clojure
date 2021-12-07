(ns year2021.day7.day7-part1
  (:require [ysera.test :refer [is is= is-not deftest]]
            [year2021.day7.day7-data :refer [day7-example day7-puzzle]]
            [clojure.math.numeric-tower :as math]
            [clojure.string :as str]))

(defn text->freqs
  [text]
  (as-> text $
        (str/split $ #",")
        (map read-string $)
        (frequencies $)))

(defn calc-fuel
  {:test (fn []
           (let [freqs (text->freqs "16,1,2,0,4,2,7,1,2,14")]
             (is= (calc-fuel freqs 2) 37)
             (is= (calc-fuel freqs 1) 41)
             (is= (calc-fuel freqs 3) 39)
             (is= (calc-fuel freqs 10) 71)))}
  [freqs depth]
  (->> freqs
       (map (fn [[d n]] (* n (math/abs (- depth d)))))
       (reduce +))
  )

(defn day7-part1
  {:test (fn []
           (is= (day7-part1 "16,1,2,0,4,2,7,1,2,14") 37))}
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
  (time (day7-part1 day7-puzzle))
  ;"Elapsed time: 192.394419 msecs"
  ;=> 347011
  ;
  )
