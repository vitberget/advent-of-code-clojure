(ns year2023.day16.day16-part2
  (:require [ysera.test :refer [is=]]
            [year2023.day16.day16-part1 :as part-1]
            [year2023.day16.day16-data :refer [day16-example day16-puzzle]]))

(defn get-start-positions
  [{height :height width :width}]
  (concat
    (for [x (range 0 width)]
      [:s [x -1]]) 
    (for [x (range 0 width)]
      [:n [x height]]) 
    (for [y (range 0 height)]
      [:e [-1 y]])
    (for [y (range 0 height)]
      [:w [width y]])))

(defn day16-part2
  {:test (fn [] (is= (day16-part2 day16-example) 51))}
  [text]
  (let [layout (part-1/text->layout text)]
    (->> layout
         (get-start-positions)
         (pmap (fn [start-position] (-> start-position
                                        (part-1/send-beam layout)
                                        (count)))) 
         (reduce max))))

(comment
  (time (day16-part2 day16-puzzle))
  ; (out) "Elapsed time: 901.132938 msecs"
  ; 8023
  )
