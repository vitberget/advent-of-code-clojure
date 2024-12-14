(ns year2024.day14.day14-part2
  (:require
    [utils.text :as ut]
    [year2024.day14.day14-data :refer [day14-puzzle]]
    [year2024.day14.day14-part1 :as part-1]))

(defn robots->positions
  [robots]
  (->> robots
       (map :position)
       (into #{})))

(defn maybe-tree? 
  "a number of positions in a row?"
  [robots]
  (let [positions (robots->positions robots)]
    (->> positions
         (filter (fn [[px py]]
                   (and (contains? positions [(+ px 1) py])
                        (contains? positions [(+ px 2) py])
                        (contains? positions [(+ px 3) py])
                        (contains? positions [(+ px 4) py])
                        (contains? positions [(+ px 5) py]))))
         (seq))))

(defn- print-robots 
  [robots [width height]]
  (let [positions (robots->positions robots)]
    (doseq [y (range 0 height)
            x (range 0 width)]
      (if (contains? positions [x y])
        (print "#")
        (print ".")) 
      (when (= x (dec width))(println)))))

(defn day14-part2
  [text size]
  (loop [robots (->> text
                     (ut/text->lines)
                     (map part-1/line->robot))
         current-second 0]
    (when (<= current-second (* 103 101))
      (when (maybe-tree? robots)
        (println "current-second" current-second)
        (print-robots robots size))
      (recur (->> robots
                  (map (fn[robot] (part-1/move-robot robot size 1)))) 
             (inc current-second)))))

(comment
  (day14-part2 day14-puzzle [101 103])
  ; Manually inspect output
  ; 7735
  )
