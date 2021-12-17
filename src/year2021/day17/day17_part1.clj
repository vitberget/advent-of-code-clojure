(ns year2021.day17.day17-part1
  (:require [ysera.test :refer [is is= is-not deftest]]
            [clojure.pprint :refer [pprint]]
            [clojure.math.numeric-tower :as math]))

(def day17-example "target area: x=20..30, y=-10..-5")
(def day17-puzzle "target area: x=156..202, y=-110..-69")

(defn text->target
  {:test (fn []
           (is= (text->target day17-example)
                {:x-min 20
                 :x-max 30
                 :y-min -10
                 :y-max -5}))}
  [text]
  (let [numbers (->> text
                     (re-matches #"target area: x=([0-9\-]+)..([0-9\-]+), y=([0-9\-]+)..([0-9\-]+)")
                     (drop 1)
                     (map read-string))
        x-numbers (take 2 numbers)
        y-numbers (drop 2 numbers)]
    {:x-min (apply min x-numbers)
     :x-max (apply max x-numbers)
     :y-min (apply min y-numbers)
     :y-max (apply max y-numbers)}))

(defn inside-range?
  [n n-min n-max]
  (<= n-min n n-max))

(defn y-speed-ok?
  [y-speed y-min y-max]
  (loop [y-pos 0
         y-speed y-speed]
    (cond
      (< y-pos y-min)
      false

      (inside-range? y-pos y-min y-max)
      true

      :else
      (recur (+ y-pos y-speed)
             (dec y-speed)))))

(defn find-y-speed
  [{y-min :y-min y-max :y-max}]
  (loop [y-speed (math/abs y-min)]
    (if (y-speed-ok? y-speed y-min y-max)
      y-speed
      (recur (dec y-speed)))))

(defn find-max-y
  [y-speed]
  (reduce + y-speed (range (max y-speed))))

(defn day17-part1
  {:test (fn []
           (is= (day17-part1 day17-example) 45)
           (is= (day17-part1 day17-puzzle) 5995))}
  [text]
  (let [target (text->target text)
        y-speed (find-y-speed target)]
    (find-max-y y-speed)))

(comment
  (time (day17-part1 day17-puzzle))
  ;"Elapsed time: 1.137415 msecs"
  ;=> 5995
  )
