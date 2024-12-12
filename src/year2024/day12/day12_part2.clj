(ns year2024.day12.day12-part2
  (:require [ysera.test :refer [is=]]
            [year2024.day12.day12-part1 :as part-1]
            [year2024.day12.day12-data :refer [day12-example-1 
                                               day12-example-3
                                               day12-example-4
                                               day12-example-5
                                               day12-puzzle]]
            [clojure.set :as set]))

(def borders
  (list [:top [0 -1]]
        [:bottom [0 1]]
        [:left [-1 0]]
        [:right [1 0]]))

(defn get-sides-of-region 
  [positions]
  (->> positions
       (mapcat (fn [pos] (->> borders
                              (map (fn [[direction delta]] [direction (mapv + pos delta)]))
                              (filter (fn [[_ delta-pos]] (not (contains? positions delta-pos))))
                              (map (fn [[dir _]] [dir pos])))))))

(defn group-sides
  [sides]
  (reduce (fn [grouped-sides [dir pos]]
            (update grouped-sides dir (fn [positions] (-> positions
                                                          (or #{})
                                                          (conj pos)))))

          {} 
          sides))

(defn count-sides [[direction positions]]
  (let [[delta-1 delta-2] (condp = direction
                            :top [[-1 0] [1 0]]
                            :bottom [[-1 0] [1 0]]
                            :left [[0 -1] [0 1]]
                            :right [[0 -1] [0 1]])]
    (loop [sides 0
           current-positions #{}
           positions positions]
      (cond
        (and (empty? positions) (empty? current-positions))
        sides 

        (empty? positions)
        (inc sides)

        (empty? current-positions)
        (let [pos (first positions)]
          (recur sides
                 #{pos}
                 (disj positions pos)))

        :else
        (let [next-potentials-1 (->> current-positions
                                     (map (fn[pos] (mapv - pos delta-1)))
                                     (into #{})
                                     (set/intersection positions))
              next-potentials-2 (->> current-positions
                                     (map (fn[pos] (mapv - pos delta-2)))
                                     (into #{})
                                     (set/intersection positions))
              next-potentials (set/union next-potentials-1 next-potentials-2)
              next-current-positions (set/intersection next-potentials positions)]
          (if (empty? next-current-positions)
            (recur (inc sides) 
                   #{} 
                   positions)
            (recur sides 
                   (set/union next-current-positions current-positions)
                   (set/difference positions next-current-positions))))))))

(defn cost-of-region
  [region]
  (->> region
       (get-sides-of-region)
       (group-sides)
       (map count-sides)
       (apply +)
       (* (count region))))

(defn day12-part2
  {:test (fn []
           (is= (day12-part2 day12-example-1) 80)
           (is= (day12-part2 day12-example-4) 236)
           (is= (day12-part2 day12-example-5) 368)
           (is= (day12-part2 day12-example-3) 1206))}
  [text]
  (->> text
       (part-1/text->farm)
       (mapcat part-1/split-regions)
       (map cost-of-region)
       (reduce +)))

(comment
  (time (day12-part2 day12-puzzle))
  ; (out) "Elapsed time: 192.293846 msecs"
  ; 784982
  )
