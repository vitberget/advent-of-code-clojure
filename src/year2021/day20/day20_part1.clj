(ns year2021.day20.day20-part1
  (:require [ysera.test :refer [is is= is-not deftest]]
            [year2021.day20.day20-data :refer [day20-example day20-puzzle]]
            [clojure.pprint :refer [pprint]]
            [clojure.string :as str]
            [clojure.set :as set]))

(defn print-image
  [image]
  (let [{min-x :min-x max-x :max-x min-y :min-y max-y :max-y}
        (reduce (fn [result [x y]]
                  (-> result
                      (update :min-x min x)
                      (update :min-y min y)
                      (update :max-x max x)
                      (update :max-y max y)))
                {:min-x Long/MAX_VALUE
                 :max-x 0
                 :min-y Long/MAX_VALUE
                 :max-y 0}
                image)]
    (println "---- image")
    (doseq [y (range min-y (inc max-y))]
      (doseq [x (range min-x (inc max-x))]
        (print (if (contains? image [x y])
                 \#
                 \.)))
      (println))
    (println)))

(defn pixel->binary
  [pixel-char]
  (if (= pixel-char \#)
    1
    0))

(defn text->algorithm-and-image
  [text]
  (let [[algorithm-text images-text] (str/split text #"\n\n")]
    {:algorithm (->> algorithm-text
                     (str/split-lines)
                     (apply str)
                     (map pixel->binary))
     :image     (->> images-text
                     (str/split-lines)
                     (map-indexed (fn [y line]
                                    (->> line
                                         (map-indexed (fn [x char]
                                                        (when (= char \#)
                                                          #{[x y]}))))))
                     (flatten)
                     (apply set/union))}))

(def nine-grid
  (for [y (range -1 2)
        x (range -1 2)]
    [x y]))

(defn against-original-image
  [[px py] image algorithm]
  (let [grid-val (->> nine-grid
                      (map (fn [[dx dy]] [(+ px dx) (+ py dy)]))
                      (reduce (fn [a point]
                                (->> a
                                     (* 2)
                                     (+ (if (contains? image point) 1 0))))
                              0))
        result (= 1 (nth algorithm grid-val))]
    result))

(def enhance-point
  (memoize
    (fn [[px py :as point] image algorithm level]
      (if (= level 1)
        (against-original-image point image algorithm)
        (let [level (dec level)
              grid-val (->> nine-grid
                            (map (fn [[dx dy]] [(+ px dx) (+ py dy)]))
                            (reduce (fn [a point]
                                      (->> a
                                           (* 2)
                                           (+ (if (enhance-point point image algorithm level) 1 0))))
                                    0))]
          (= 1 (nth algorithm grid-val)))))))

(defn enhance-image
  [algorithm image]
  (let [points (->> image
                    (mapcat (fn [[px py]]
                              (map (fn [[dx dy]]
                                     [(+ px dx) (+ py dy)])
                                   nine-grid)))
                    (mapcat (fn [[px py]]
                              (map (fn [[dx dy]]
                                     [(+ px dx) (+ py dy)])
                                   nine-grid)))
                    (into #{}))]
    (->> points
         (filter (fn [point] (enhance-point point image algorithm 2)))
         (into #{}))))

(defn day20-part1
  {:test (fn []
           (is= (day20-part1 day20-example) 35))}
  [text]
  (let [{algorithm :algorithm image :image} (text->algorithm-and-image text)]
    (count (enhance-image algorithm image))))

(comment
  (time (day20-part1 day20-puzzle))
  ;"Elapsed time: 2716.416286 msecs"
  ;=> 5583
  )
