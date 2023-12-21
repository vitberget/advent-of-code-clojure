(ns year2023.day21.day21-part1
  (:require
    [utils.text :refer [text->lines]]
    [year2023.day21.day21-data :refer [day21-example day21-puzzle]]
    [ysera.test :refer [is=]]
    [clojure.set :as set]))

(defn text->map 
  [text]
  (let [lines (text->lines text)
        all-map (->> lines
                     (map-indexed (fn [y line]
                                    (->> line
                                         (map-indexed (fn [x ch] {[x y] ch}))
                                         (reduce merge))))
                     (reduce merge))]
    {:height (count lines)
     :width (-> lines (first) (count))
     :start (->> all-map
                 (filter (fn [[_ ch]] (= ch \S)))
                 (first)
                 (first))
     :stones (->> all-map
                  (filter (fn [[_ ch]] (= ch \#)))
                  (map first)
                  (into #{}))}))

(defn extend-step 
  [[x y] {width :width height :height stones :stones}]
  (let [width (dec width)
        height (dec height)]
    (->> [[-1 0] [1 0] [0 -1] [0 1]]
         (map (fn [[dx dy]] [(+ x dx) (+ y dy)]))
         (filter (fn [[fx _]] (<= 0 fx width)))
         (filter (fn [[_ fy]] (<= 0 fy height)))
         (remove (fn [pos] (contains? stones pos)))
         (into #{}))))

(defn get-visited 
  [{start :start :as the-map} steps]
  (loop [steps steps
         visited #{start}]
    (if (zero? steps)
      visited
      (recur (dec steps)
             (->> visited
                  (map (fn[pos] (extend-step pos the-map)))
                  (reduce set/union))))))

(defn day21-part1
  {:test (fn []
           (is= (day21-part1 day21-example 6) 16)
           (is= (day21-part1 day21-puzzle 64) 3737))}
  [text steps]
  (let [the-map (text->map text)]
    (->> (get-visited the-map steps)
         (count))))

(comment
  (time (day21-part1 day21-puzzle 64))
  ; (out) "Elapsed time: 217.527369 msecs"
  ; 3737
  )
