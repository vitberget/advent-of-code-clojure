(ns year2022.day8.day8-part2
  (:require [year2022.day8.day8-data :refer [day8-example day8-puzzle]]
            [year2022.day8.day8-part1 :as part-1]
            [ysera.test :refer [is=]]))

(defn scenic-line
  [forest origin direction]
  (let [origin-height (get forest origin)]
    (loop [position origin
           view 0]
      (let [position (mapv + position direction)
            test-height (get forest position)]
        (cond (nil? test-height)
              view

              (>= test-height origin-height)
              (inc view)

              :else
              (recur position (inc view)))))))

(defn scenic-score
  {:test (fn []
           (let [forest (part-1/text->forest day8-example)]
             (is= (scenic-score forest [2 1]) 4)
             (is= (scenic-score forest [2 3]) 8)))}
  [forest position]
  (->> part-1/directions
       (map #(scenic-line forest position %))
       (apply *)))

(defn day8-part2
  {:test (fn []
           (is= (day8-part2 day8-example) 8)
           (is= (day8-part2 day8-puzzle) 474606))}
  [text]
  (let [forest (part-1/text->forest text)]
    (->> forest
         (keys)
         (map #(scenic-score forest %))
         (reduce max))))

(comment
  (time (day8-part2 day8-puzzle))
  ;"Elapsed time: 100.159501 msecs"
  ;=> 474606
  )
