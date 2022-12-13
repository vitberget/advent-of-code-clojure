(ns year2022.day12.day12-part1
  (:require [utils.text :as ut]
            [year2022.day12.day12-data :refer [day12-example day12-puzzle]]
            [ysera.test :refer [is is-not is=]]))

(defn ok-step?
  {:test (fn []
           (is (ok-step? \m \m))
           (is (ok-step? \m \n))
           (is-not (ok-step? \m \o))
           (is-not (ok-step? \m nil))
           (is (ok-step? \m \a)))}
  [from to]
  (when (and to from)
    (let [from (if (= from \S) \a from)
          to (if (= to \E) \z to)
          from (int from)
          to (int to)]
      (<= to (inc from)))))

(defn line->map
  [y line]
  (->> line
       (map-indexed (fn [x letter] {[x y] letter}))
       (apply merge)))

(defn text->map
  [text]
  (->> text
       (ut/text->lines)
       (map-indexed line->map)
       (apply merge)))

(defn find-pos
  [the-map search-value]
  (->> the-map
       (filter (fn [[_ value]] (= search-value value)))
       (first)
       (first)))

(def directions (list [0 1] [0 -1] [1 0] [-1 0]))

(defn extend-route
  [the-map visited route]
  (let [last-pos (last route)]
    (->> directions
         (map #(mapv + % last-pos))
         (remove #(contains? visited %))
         (filter #(ok-step? (get the-map last-pos) (get the-map %)))
         (map #(conj route %)))))

(defn find-route
  [the-map start-pos end-pos]
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
                              (filter #(= (last %) end-pos))
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

(defn day12-part1
  {:test (fn []
           (is= (day12-part1 day12-example) 31)
           (is= (day12-part1 day12-puzzle) 468))}
  [text]
  (let [the-map (text->map text)
        start-pos (find-pos the-map \S)
        end-pos (find-pos the-map \E)]
    (->> (find-route the-map start-pos end-pos)
         (count)
         (dec))))

(comment
  (time (day12-part1 day12-puzzle))
  ;"Elapsed time: 296.572758 msecs"
  ;=> 468
  )
