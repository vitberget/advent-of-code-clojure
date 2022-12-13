(ns year2022.day12.day12-part2
  (:require [year2022.day12.day12-data :refer [day12-example day12-puzzle]]
            [year2022.day12.day12-part1 :as part-1]
            [ysera.test :refer [is=]]))

(defn extend-route
  [the-map visited route]
  (let [last-pos (last route)]
    (->> part-1/directions
         (map #(mapv + % last-pos))
         (remove #(contains? visited %))
         (filter #(part-1/ok-step? (get the-map %) (get the-map last-pos)))
         (map #(conj route %)))))

(defn find-route
  [the-map start-pos a-posses]
  (loop [idx 0
         routes (list [start-pos])
         visited #{start-pos}]
    (let [routes (->> routes
                      (mapcat #(extend-route the-map visited %))
                      (reduce (fn [{vis :vis :as state} route]
                                (let [last-pos (last route)]
                                  (if (contains? vis last-pos)
                                    state
                                    (-> state
                                        (update :vis conj last-pos)
                                        (update :routes conj route)))))
                              {:vis    #{}
                               :routes (list)})
                      (:routes))
          complete-route (->> routes
                              (filter #(contains? a-posses (last %)))
                              (first))]
      (cond
        complete-route
        complete-route

        :else
        (recur (inc idx)
               routes
               (reduce (fn [visited route]
                         (conj visited (last route)))
                       visited
                       routes))))))

(defn get-a-posses
  [the-map]
  (->> the-map
       (filter (fn [[_ val]] (or (= val \a)
                                 (= val \S))))
       (map first)
       (into #{})))

(defn day12-part2
  {:test (fn []
           (is= (day12-part2 day12-example) 29))}
  [text]
  (let [the-map (part-1/text->map text)
        end-pos (part-1/find-pos the-map \E)
        a-posses (get-a-posses the-map)]
    (->> (find-route the-map end-pos a-posses)
         (count)
         (dec))))

(comment
  (time (day12-part2 day12-puzzle))
  ;"Elapsed time: 156.266748 msecs"
  ;=> 459
  )
