(ns year2021.day9.day9-part1
  (:require [ysera.test :refer [is is= is-not deftest]]
            [year2021.day9.day9-data :refer [day9-example day9-puzzle]]
            [clojure.string :as str]))

(defn char->number
  [digit-char]
  (- (int digit-char)
     (int \0)))

(defn line->number-map
  [y line]
  (map-indexed (fn [x c]
                 {[x y] (char->number c)})
               line))

(defn lines->number-map
  [lines]
  (->> lines
       (map-indexed line->number-map)
       (flatten)
       (reduce merge)))

(def surrounding
  (for [x [-1 0 1]
        y [-1 0 1]
        :when (not= 0 x y)]
    [x y]))

(defn low-point-or-nil
  [[px py :as position] number-map]
  (let [number (get number-map position)]
    (loop [[[dx dy] & surrounding] surrounding]
      (if (nil? dx)
        number
        (let [surrounding-number (get number-map [(- px dx) (- py dy)])]
          (when (or (nil? surrounding-number)
                    (< number surrounding-number))
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
