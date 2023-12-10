(ns year2023.day10.day10-part1
  (:require
    [utils.text :refer [text->lines]]
    [year2023.day10.day10-data :refer [day10-example-1 day10-example-2
                                       day10-puzzle]]
    [ysera.test :refer [is=]]
    [clojure.set :as set]))

(def char->pipe
  {\| #{:n :s}
   \- #{:w :e}
   \L #{:n :e}
   \J #{:n :w}
   \7 #{:s :w}
   \F #{:s :e}
   \. nil
   \S :start})

(defn text->grid
  [text]
  (->> text
       (text->lines)
       (map-indexed (fn [y line]
                      (->> line
                           (map-indexed (fn [x ch] {[x y] (char->pipe ch)})))))
       (apply concat)
       (apply merge)))

(defn get-start 
  [grid]
  (->> grid
       (filter (fn [[ _ pipe ]] (= pipe :start)))
       (first)
       (first)))

(defn get-next-steps
  [[sx sy :as start-location] grid]
  (let [start-data (get grid start-location)]
    (->> [[[(inc sx) sy] :e :w]
          [[(dec sx) sy] :w :e]
          [[sx (inc sy)] :s :n]
          [[sx (dec sy)] :n :s]]
         (filter (fn [[next-location local-match target-match]]
                   (let [next-location-data (get grid next-location)]
                   (and (or (= start-data :start)
                            (contains? start-data local-match))
                        (or (= next-location-data :start)
                            (contains? next-location-data target-match))))))
         (map (fn [[location & _]] location))
         (into #{}))))

(defn solve-distances 
  [start grid]
  (loop [step 0
         distances {start 0}
         next-steps #{start}]
    (if (empty? next-steps)
      distances
      (let [next-steps (->> next-steps
                            (map (fn[step] (get-next-steps step grid)))
                            (apply set/union))
            next-steps (set/difference next-steps (->> distances (keys) (into #{})))
            step (inc step) 
            distances (reduce (fn [distances location]
                                (assoc distances location step))
                              distances
                              next-steps)]
        (recur step
               distances
               next-steps)))))

(defn day10-part1
  {:test (fn []
           (is= (day10-part1 day10-example-1) 4)
           (is= (day10-part1 day10-example-2) 8))}
  [text]
  (let [grid (text->grid text)
        start (get-start grid)]
    (->> (solve-distances start grid)
         (vals)
         (reduce max))))

(comment
  (time (day10-part1 day10-puzzle))
  ; (out) "Elapsed time: 4166.956671 msecs"
  ; 6882
  )
