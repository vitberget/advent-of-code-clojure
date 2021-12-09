(ns year2021.day9.day9-part1
  (:require [ysera.test :refer [is is= is-not deftest]]
            [year2021.day9.day9-data :refer [day9-example day9-puzzle]]
            [clojure.string :as str]))

(defn lines->number-map
  [lines]
  (->> lines
       (map-indexed (fn [y line]
                      (->> line
                           (map-indexed (fn [x c]
                                          {[x y] (- (int c)
                                                    (int \0))})))))
       (flatten)
       (reduce merge)))

(def surrounding
  (list [-1 -1] [-1 0] [-1 1]
        [1 -1] [1 0] [1 1]
        [0 -1] [0 1]))

(defn low-point-or-nil
  [position number-map]
  (let [number (get number-map position)]
    (loop [[s & surrounding] surrounding]
      (if (nil? s)
        number
        (let [s-num (get number-map [(- (first position) (first s))
                                     (- (second position) (second s))])]
          (when (or (nil? s-num)
                    (< number s-num))
            (recur surrounding)))))))

(defn day9-part1
  {:test (fn []
           (is= (day9-part1 day9-example) 15)
           (is= (day9-part1 day9-puzzle) 526))}
  [text]
  (let [lines (str/split-lines text)
        width (count (first lines))
        height (count lines)
        number-map (lines->number-map lines)]
    (->> (for [x (range 0 width)
               y (range 0 height)]
           (low-point-or-nil [x y] number-map))
         (remove nil?)
         (map inc)
         (reduce +))))

(comment
  (time (day9-part1 day9-puzzle))
  ;"Elapsed time: 39.116195 msecs"
  ;=> 526
  )
