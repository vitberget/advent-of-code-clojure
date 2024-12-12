(ns year2024.day12.day12-part1
  (:require [ysera.test :refer [is=]]
            [year2024.day12.day12-data :refer [day12-example-1 
                                               day12-example-2 
                                               day12-example-3 
                                               day12-puzzle]]
            [utils.text :as ut]
            [clojure.set :as set]))

(defn text->farm
  [text]
  (->> text
       (ut/text->lines)
       (map-indexed (fn [y line]
                      (map-indexed (fn [x ch] [ch [x y]]) line)))
       (apply concat)
       (reduce (fn [farm [ch pos]]
                 (-> farm
                     (update ch (fn [letter-set] (-> letter-set
                                                     (or #{})
                                                     (conj pos))))))
               {})))

(defn get-neighbouring-positions 
  {:test (fn[] (is= (get-neighbouring-positions [5 5]) (list [4 5] [6 5] [5 4] [5 6])))}
  [pos]
  (->> (list [-1 0] [1 0] [0 -1] [0 1])
       (map (fn [delta] (mapv + pos delta)))))

(defn split-regions 
  {:test (fn[] 
           (is= (split-regions [nil #{[1 0]}]) (list #{[1 0]} ))
           (is= (split-regions [nil #{[1 0] [1 1]}]) (list #{[1 0] [1 1]} ))
           ; (is= (split-regions [nil #{[1 0] [1 1] [5 5]}]) (list #{[5 5]} #{[1 0] [1 1]} ))
           (is= (split-regions [nil #{[1 0] [1 1] [1 2]}]) (list #{[1 0] [1 1] [1 2]} )))}
  [[_ positions]]
  (loop [loopie 0
         current-region #{}
         working-positions #{}
         positions positions
         regions (list)]
    (cond
      (> loopie 24532) "loopie"

      (and (empty? working-positions) (empty? positions))
      regions

      (empty? positions)
      (conj regions (set/union current-region working-positions))

      (empty? working-positions)
      (let [p (first positions)]
        (recur (inc loopie)
               #{} 
               #{p} 
               (disj positions p)
               (if (empty? current-region)
                 regions
                 (conj regions current-region))))

      :else 
      (if-let [next-working-positions (->> working-positions
                                           (mapcat get-neighbouring-positions)
                                           (into #{})
                                           (set/intersection positions)) ]
        (recur (inc loopie)
               (set/union current-region working-positions)
               next-working-positions
               (set/difference positions next-working-positions)
               regions)
        (recur (inc loopie)
               #{}
               #{}
               positions
               (conj regions (set/union current-region working-positions)))))))

(defn- cost-of-region [region]
  (->> region
       (map (fn [pos] (->> pos
                           (get-neighbouring-positions)
                           (into #{})
                           (set/intersection region)
                           (count))))
       (map (fn [neighbour-count] (- 4 neighbour-count)))
       (reduce +)
       (* (count region))))

(defn day12-part1
  {:test (fn []
           (is= (day12-part1 day12-example-1) 140)
           (is= (day12-part1 day12-example-2) 772)
           (is= (day12-part1 day12-example-3) 1930))}
  [text]
    (->> text
         (text->farm)
         (mapcat split-regions)
         (map cost-of-region)
         (reduce +)))

(comment
  (time (day12-part1 day12-puzzle))
  ; (out) "Elapsed time: 130.101024 msecs"
  ; 1319878
  )
