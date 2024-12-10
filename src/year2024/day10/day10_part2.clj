(ns year2024.day10.day10-part2
  (:require [ysera.test :refer [is=]]
            [year2024.day10.day10-part1 :as part-1]
            [year2024.day10.day10-data :refer [day10-example day10-puzzle]]))

(defn- extend-trails 
  {:test (fn[]
           (is= (extend-trails 1 (list (list [0 0])) (part-1/text->the-map  "0123\n1234\n8765\n9876")) 
                #{(list [0 1][0 0]) (list [1 0][0 0])}))}
  [current-step trails the-map]
  (->> trails
       (map (fn [trail]
              (let [steps (part-1/find-up-steps current-step #{(first trail)} the-map)]
                (->> steps
                     (map (fn[step] (conj trail step)))))))
       (apply concat)
       (into #{})))

(defn- calculate-rating 
  [trail-head the-map]
  (loop [current-step 1
         trails #{(list trail-head)}]
    (if (> current-step 9)
      (count trails)
      (recur (inc current-step)
             (extend-trails current-step trails the-map)))))

(defn day10-part2
  {:test (fn []
           (is= (day10-part2 day10-example) 81))}
  [text]
  (let [the-map (part-1/text->the-map text)]
    (->> (get the-map 0)
         (pmap (fn [trail-head] (calculate-rating trail-head the-map)))
         (apply +))))

(comment
  (time (day10-part2 day10-puzzle))
  ; (out) "Elapsed time: 10.417806 msecs"
  ; 1432
  )
