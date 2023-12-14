(ns year2023.day14.day14-part1
  (:require
   [utils.text :refer [text->rows]]
   [year2023.day14.day14-data :refer [day14-example day14-puzzle]]
   [ysera.test :refer [is=]]
   [clojure.string :as str]))

(defn tilt-level
  [line]
  (loop [line line]
    (let [new-line (str/replace line #"\.O" "O.")]
      (if (= line new-line)
        new-line
        (recur new-line)) )))

(defn score-row 
  [line]
  (->> line
       (reverse)
       (map-indexed (fn [idx ch] (if (= ch \O) (inc idx) 0)))
       (reduce +)))

(defn day14-part1
  {:test (fn [] (is= (day14-part1 day14-example) 136))}
  [text]
  (->> text
       (text->rows)
       (map tilt-level)
       (map score-row)
       (reduce +)))

(comment
  (time (day14-part1 day14-puzzle))
  ; (out) "Elapsed time: 11.943437 msecs"
  ; 108955
  )
