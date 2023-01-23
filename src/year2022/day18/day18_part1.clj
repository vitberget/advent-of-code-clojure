(ns year2022.day18.day18-part1
  (:require [utils.text :as ut]
            [year2022.day18.day18-data :refer [day18-example day18-puzzle]]
            [ysera.test :refer [is=]]))

(defn line->coords
  [line]
  (->> line
       (ut/split-on #",")
       (map read-string)))

(defn text->coords
  [text]
  (->> text
       (ut/text->lines)
       (map line->coords)
       (reduce conj #{})))

(def directions
  (list [1 0 0] [-1 0 0]
        [0 1 0] [0 -1 0]
        [0 0 1] [0 0 -1]))

(defn count-neighbours
  [coord coords]
  (->> directions
       (map (fn [dir] (mapv + dir coord)))
       (filter (fn [c] (contains? coords c)))
       (count)))

(defn day18-part1
  {:test (fn []
           (is= (day18-part1 day18-example) 64)
           (is= (day18-part1 day18-puzzle) 4314))}
  [text]
  (let [coords (text->coords text)]
    coords
    (->> coords
         (map #(count-neighbours % coords))
         (map #(- 6 %))
         (apply +))))

(comment
  (time (day18-part1 day18-puzzle))
  ;"Elapsed time: 50.165901 msecs"
  ;=> 4314
  )
