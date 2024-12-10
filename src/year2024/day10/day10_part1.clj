(ns year2024.day10.day10-part1
  (:require
   [utils.text :as ut]
   [year2024.day10.day10-data :refer [day10-example day10-puzzle]]
   [ysera.test :refer [is=]]))

(defn text->the-map
  "Takes the text and produces a map with the digit as key with the positions containing it as a set.
   Example: {0 #{[0 0] [13 45]}} "
  [text]
  (->> text
       (ut/text->lines)
       (map-indexed (fn [y line] [y line]))
       (reduce (fn [the-map [y line]]
                  (->> line
                       (map-indexed (fn [x ch] [x ch]))
                       (reduce (fn [the-map [x ch]]
                                (if (= ch \.)
                                  the-map
                                  (update the-map (ut/char->number ch) (fn [wee] (conj (or wee #{}) [x y])))) )
                               the-map))) 
               {})))

(defn find-up-steps 
  {:test (fn[]
           (is= (find-up-steps 1 #{[0 0]} (text->the-map  "0123\n1234\n8765\n9876")) #{[0 1] [1 0]})
           (is= (find-up-steps 2 #{[1 0][0 1]} (text->the-map  "0123\n1234\n8765\n9876")) #{[1 1] [2 0]}))}
  [current-step trails the-map]
  (let [current-step-positions (get the-map current-step)]
    (->> trails
         (map (fn [trail-pos]
                (->> (list [-1 0] [1 0] [0 -1] [0 1])
                     (map (fn[delta] (mapv - trail-pos delta)))
                     (filter (fn [position] (contains? current-step-positions position))))))
         (apply concat)
         (into #{}))))

(defn- count-trails 
  [trail-head the-map]
  (loop [current-step 1
         trails #{trail-head}]
    (cond
      (> current-step 9) (count trails)
      (empty? trails) 0
      :else (recur (inc current-step)
                   (find-up-steps current-step trails the-map)))))

(defn day10-part1
  {:test (fn []
           (is= (day10-part1 "0123\n1234\n8765\n9876") 1)
           (is= (day10-part1 day10-puzzle) 652)
           (is= (day10-part1 day10-example) 36))}
  [text]
  (let [the-map (text->the-map text)]
    (->> (get the-map 0)
         (pmap (fn[trail-head] (count-trails trail-head the-map)))
         (apply +))))

(comment
  (time (day10-part1 day10-puzzle))
  ; (out) "Elapsed time: 7.45236 msecs"
  ; 652
  )
