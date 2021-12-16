(ns year2021.day15.day15-part2
  (:require [ysera.test :refer [is is= is-not deftest]]
            [year2021.day15.day15-data :refer [day15-example
                                               day15-example-expanded
                                               day15-puzzle]]
            [year2021.day15.day15-part1 :as part1]))

(defn get-max-pos
  [risk-map]
  (reduce (fn [[mx my] [[x y] _]]
            [(max mx x) (max my y)])
          [0 0]
          risk-map))

(defn expand-number
  [val x y]
  (loop [val (+ val x y)]
    (if (> val 9)
      (recur (- val 9))
      val)))

(defn expand
  {:test (fn []
           (let [before (part1/text->risk-map day15-example)
                 expanded (expand before (get-max-pos before))
                 facit (part1/text->risk-map day15-example-expanded)]
             (is= (count expanded)
                  (count facit))
             (is= expanded facit)))}

  ([original-risk-map max-pos]
   (reduce (fn [risk-map [x y]]
             (expand original-risk-map risk-map x y max-pos))
           original-risk-map
           (for [x (range 5)
                 y (range 5)
                 :when (not= 0 x y)]
             [x y])))

  ([original-risk-map risk-map x y [mx my]]
   (let [dx (* x (inc mx))
         dy (* y (inc my))]
     (reduce (fn [risk-map [[px py] v]]
               (assoc
                 risk-map
                 [(+ px dx) (+ py dy)]
                 (expand-number v x y)))
             risk-map
             original-risk-map))))

(defn day15-part2
  {:test (fn []
           (is= (day15-part2 day15-example) 315))}
  [text]
  (let [risk-map (part1/text->risk-map text)
        risk-map (expand risk-map (get-max-pos risk-map))
        max-pos (get-max-pos risk-map)]
    (-> risk-map
        (part1/do-risk-map max-pos))))



(comment
  (time (day15-part2 day15-puzzle))
  ;"Elapsed time: 43379.166463 msecs"
  ;=> 2887
  (time (day15-part2 day15-example))
  )