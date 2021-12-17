(ns year2021.day17.day17-part2
  (:require [ysera.test :refer [is is= is-not deftest]]
            [year2021.day17.day17-part1 :as part1]
            [clojure.pprint :refer [pprint]]
            [clojure.math.numeric-tower :as math]))

(def day17-example "target area: x=20..30, y=-10..-5")
(def day17-puzzle "target area: x=156..202, y=-110..-69")

(defn hits-target?
  {:test (fn []
           (let [test-target (part1/text->target day17-example)]
             (is (hits-target? [23 -10] test-target))
             (is (hits-target? [8 0] test-target))
             (is-not (hits-target? [5 10] test-target))
             (is-not (hits-target? [23 0] test-target))
             ))}
  [[x-speed y-speed] {y-min :y-min y-max :y-max x-min :x-min x-max :x-max}]
  (loop [x 0
         y 0
         x-speed x-speed
         y-speed y-speed
         ]
    (cond
      (and (part1/inside-range? x x-min x-max)
           (part1/inside-range? y y-min y-max))
      true

      (or (> x x-max)
          (< y y-min))
      false

      :else
      (recur (+ x x-speed)
             (+ y y-speed)
             (max 0 (dec x-speed))
             (dec y-speed)))))

(defn day17-part2
  {:test (fn []
           (is= (day17-part2 day17-example) 112)
           (is= (day17-part2 day17-puzzle) 3202))}
  [text]
  (let [{x-max :x-max y-min :y-min y-max :y-max :as target} (part1/text->target text)
        y-meh (max (math/abs y-min) (math/abs y-max))]
    (pprint target)
    (->> (for [x (range (* x-max 2))
               y (range (- y-meh) y-meh)
               :when (hits-target? [x y] target)]
           [x y])
         (count))))

(comment
  (time (day17-part2 day17-puzzle))
  ;"Elapsed time: 18.451098 msecs"
  ;=> 3202
  )