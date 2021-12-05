(ns year2021.day5.day5-part1
  (:require [ysera.test :refer [is is= is-not deftest]]
            [year2021.day5.day5-data :refer [day5-example day5-puzzle]]
            [clojure.string :as str]))

(defn line->line
  [line]
  (let [[p1 p2] (str/split line #" -> ")
        [x1 y1] (str/split p1 #",")
        [x2 y2] (str/split p2 #",")]
    {:x1 (read-string x1)
     :y1 (read-string y1)
     :x2 (read-string x2)
     :y2 (read-string y2)}))

(defn text->state
  [text]
  (->> text
       (str/split-lines)
       (map line->line)))

(defn get-direction
  [n1 n2]
  (cond
    (= n1 n2) 0
    (> n2 n1) 1
    (> n1 n2) -1))

(defn line->coverage
  {:test (fn []
           (is= (line->coverage {:x1 0, :y1 9, :x2 2, :y2 9})
                #{{:x 0 :y 9}
                  {:x 1 :y 9}
                  {:x 2 :y 9}}))}
  [{x1 :x1 y1 :y1 x2 :x2 y2 :y2}]
  (let [dx (get-direction x1 x2)
        dy (get-direction y1 y2)]
    (loop [x x1
           y y1
           coverage #{}]
      (let [coverage (conj coverage {:x x :y y})]
        (if (and (= x x2)
                 (= y y2))
          coverage
          (recur (+ x dx)
                 (+ y dy)
                 coverage))))))

(defn coverage->map
  {:test (fn []
           (is= (coverage->map #{{:x 0 :y 9}
                                 {:x 1 :y 9}
                                 {:x 2 :y 9}})
                {{:x 0 :y 9} 1
                 {:x 1 :y 9} 1
                 {:x 2 :y 9} 1}))}
  [coverage]
  (->> coverage
       (reduce
         (fn [the-map point]
           (update the-map
                   point
                   (fn [n] (inc (or n 0)))))
         {})))

(defn update-the-map
  {:test (fn []
           (is= (update-the-map {{:x 0 :y 9} 1
                                 {:x 1 :y 9} 1
                                 {:x 2 :y 9} 1}
                                {{:x 0 :y 9} 1
                                 {:x 1 :y 9} 1})
                {{:x 0 :y 9} 2
                 {:x 1 :y 9} 2
                 {:x 2 :y 9} 1}))}
  [map1 map2]
  (reduce
    (fn [map1 [point _]]
      (update map1 point
              (fn[n] (inc (or n 0)))))
    map1
    map2))

(defn day5-part1
  {:test (fn []
           (is= (day5-part1 day5-example) 5))}
  [text]
  (->> (text->state text)
       (filter (fn [{x1 :x1 y1 :y1 x2 :x2 y2 :y2}]
                 (or (= x1 x2)
                     (= y1 y2))))
       (map line->coverage)
       (map coverage->map)
       (reduce update-the-map)
       (vals)
       (filter (fn[n] (> n 1)))
       (count)))

(comment
  (time (day5-part1 day5-puzzle))
  ;"Elapsed time: 136.730561 msecs"
  ;=> 6572
  )
