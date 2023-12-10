(ns year2023.day10.day10-part2
  (:require
    [year2023.day10.day10-part1 :as part-1]
    [year2023.day10.day10-data :refer [day10-example-3 day10-example-4
                                       day10-example-5 day10-puzzle]]
    [ysera.test :refer [is=]]))

(defn get-start-pipes
  [[sx sy] grid]
  (->> [[[(inc sx) sy] :e :w]
        [[(dec sx) sy] :w :e]
        [[sx (inc sy)] :s :n]
        [[sx (dec sy)] :n :s]]
       (filter (fn [[next-location _ target-match]]
                 (let [next-location-data (get grid next-location)]
                   (contains? next-location-data target-match))))
       (map (fn [[_ local-match _]] local-match))
       (into #{})))

(defn remap-line 
  [y the-loop grid width]
  (->> 
    (for [x (range 0 width)]
      (let [location [x y]]
        (if (contains? the-loop location)
          (get grid location)
          :dot)))
    (remove (fn [item] (= item #{:e :w})))))

(defn- solve-line [y the-loop grid width]
  (loop [[item & line] (remap-line y the-loop grid width)
         prev-item nil
         pipes 0
         enclosed 0]
    (cond
      (nil? item)
      enclosed

      (= item #{:n :s})
      (recur line nil (inc pipes) enclosed)

      (and (= item :dot)
           (odd? pipes))
      (recur line nil pipes (inc enclosed))

      (= item :dot)
      (recur line nil pipes enclosed)

      (nil? prev-item)
      (recur line item pipes enclosed)
     
      (and (= prev-item #{:n :e}) (= item #{:s :w}))
      (recur line nil (inc pipes) enclosed)

      (and (= prev-item #{:s :e}) (= item #{:n :w}))
      (recur line nil (inc pipes) enclosed)

      :else
      (recur line nil pipes enclosed))))

(defn day10-part2
  {:test (fn []
           (is= (day10-part2 day10-example-3) 4)
           (is= (day10-part2 day10-example-4) 8)
           (is= (day10-part2 day10-example-5) 10))}
  [text]
  (let [grid (part-1/text->grid text)
        start (part-1/get-start grid)
        start-pipes (get-start-pipes start grid)
        grid (assoc grid start start-pipes)
        the-loop (->> (part-1/solve-distances start grid)
                      (keys)
                      (into #{}))
        width (->> grid (keys) (map first) (reduce max) (inc))
        height (->> grid (keys) (map second) (reduce max) (inc))]
    (->> (range 0 height)
         (map (fn [y] (solve-line y the-loop grid width)))
         (concat)
         (apply +))))

(comment
  (time (day10-part2 day10-puzzle)) 
  ; (out) "Elapsed time: 4488.518013 msecs"
  ; 491
  )
