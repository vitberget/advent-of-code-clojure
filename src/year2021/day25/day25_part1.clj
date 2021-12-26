(ns year2021.day25.day25-part1
  (:require [ysera.test :refer [is is= is-not deftest]]
            [ysera.collections :refer [seq-contains?]]
            [year2021.day25.day25-data :as data]
            [clojure.string :as str]))

(defn text->map
  [text]
  (let [lines (str/split-lines text)]
    {:width    (->> lines
                    (first)
                    (count))
     :height   (count lines)
     :easties  (->> lines
                    (map-indexed (fn [y line]
                                   (->> line
                                        (map-indexed (fn [x c] (when (= c \>) [x y])))
                                        (remove nil?))))
                    (remove empty?)
                    (apply concat)
                    (into #{}))
     :southies (->> lines
                    (map-indexed (fn [y line]
                                   (->> line
                                        (map-indexed (fn [x c] (when (= c \v) [x y])))
                                        (remove nil?))))
                    (remove empty?)
                    (apply concat)
                    (into #{}))}))

(defn move-cucumbers
  {:test (fn []
           (let [step-0 (text->map data/day25-example-simple-step-0)
                 step-1 (text->map data/day25-example-simple-step-1)
                 step-2 (text->map data/day25-example-simple-step-2)
                 step-3 (text->map data/day25-example-simple-step-3)
                 step-4 (text->map data/day25-example-simple-step-4)
                 step-58 (text->map data/day25-example-step-58)]
             (is= (move-cucumbers step-0) step-1)
             (is= (move-cucumbers step-1) step-2)
             (is= (move-cucumbers step-2) step-3)
             (is= (move-cucumbers step-3) step-4)
             (is= (move-cucumbers step-58) step-58)))}
  [{width :width height :height easties :easties southies :southies :as map}]
  (let [easties (->> easties
                     (reduce (fn [new-easties [x y :as old-pos]]
                               (let [new-pos [(mod (inc x) width) y]]
                                 (if (or (contains? easties new-pos)
                                         (contains? southies new-pos))
                                   (conj new-easties old-pos)
                                   (conj new-easties new-pos))))
                             #{}))
        southies (->> southies
                      (reduce (fn [new-southies [x y :as old-pos]]
                                (let [new-pos [x (mod (inc y) height)]]
                                  (if (or (contains? easties new-pos)
                                          (contains? southies new-pos))
                                    (conj new-southies old-pos)
                                    (conj new-southies new-pos))))
                              #{}))]
    (-> map
        (assoc :easties easties)
        (assoc :southies southies))))

(defn count-moving-turns
  [map]
  (loop [turns 0
         map map]
    (let [turns (inc turns)
          new-map (move-cucumbers map)]
      (if (= map new-map)
        turns
        (recur turns
               new-map)))))

(defn day25-part1
  {:test (fn []
           (is= (day25-part1 data/day25-example-step-0) 58))}
  [text]
  (->> text
       (text->map)
       (count-moving-turns)))

(comment
  (time (day25-part1 data/day25-puzzle))
  ;"Elapsed time: 2986.691254 msecs"
  ;=> 474
  )
