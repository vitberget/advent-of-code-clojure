(ns year2021.day9.day9-part2
  (:require [ysera.test :refer [is is= is-not deftest]]
            [year2021.day9.day9-data :refer [day9-example day9-puzzle]]
            [clojure.string :as str]
            [clojure.set :as set]))

(defn text->basin-map
  [text]
  (->> text
       (str/split-lines)
       (map-indexed (fn [y line]
                      (->> line
                           (map-indexed (fn [x cell-value]
                                          (when-not (= \9 cell-value)
                                            [x y]))))))
       (apply concat)
       (remove nil?)
       (reduce conj #{})))

(defn flowing-cells
  [[px py]]
  #{[(dec px) py]
    [(inc px) py]
    [px (dec py)]
    [px (inc py)]})

(defn get-basin
  {:test (fn []
           (is= (get-basin [0 0] (text->basin-map day9-example))
                #{[0 0] [0 1] [1 0]}))}
  [pos basin-map]
  (loop [basin #{pos}]
    (let [basin-result (->> basin
                            (reduce (fn [basic-acc cell]
                                      (-> cell
                                          (flowing-cells)
                                          (set/intersection basin-map)
                                          (set/union basic-acc)))
                                    #{})
                            (set/union basin))]
      (if (= basin-result basin)
        basin-result
        (recur basin-result)))))

(defn get-basins
  [basin-map]
  (loop [basins (list)
         basin-map basin-map]
    (if (empty? basin-map)
      basins
      (let [basin (get-basin (first basin-map) basin-map)]
        (recur (conj basins basin)
               (set/difference basin-map basin))))))

(defn day9-part2
  {:test (fn []
           (is= (day9-part2 day9-example) 1134))}
  [text]
  (->> text
       (text->basin-map)
       (get-basins)
       (map count)
       (sort #(> %1 %2))
       (take 3)
       (reduce *')))


(comment
  (time (day9-part2 day9-puzzle))
  ;"Elapsed time: 150.439557 msecs"
  ;=> 1123524
  )