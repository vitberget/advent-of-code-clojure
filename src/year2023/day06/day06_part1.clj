(ns year2023.day06.day06-part1
  (:require
    [utils.text :refer [split-on text->lines]]
    [year2023.day06.day06-data :refer [day06-example day06-puzzle]]
    [ysera.test :refer [is=]]))

(defn line->numbers
  [line]
  (->> line
       (split-on #" +")
       (drop 1)
       (map read-string)))

(defn text->document
  {:test (fn[]
           (is= (text->document day06-example)
                {:time [7 15 30]
                 :distance [9 40 200]}))}
  [text]
  (let [step-1 (->> text
                    (text->lines)
                    (map line->numbers))]
    {:time (first step-1)
     :distance (second step-1)}) )

(defn calculate-winners 
  {:test (fn[]
           (is= (calculate-winners 7 9) 4)
           (is= (calculate-winners 15 40) 8)
           (is= (calculate-winners 30 200) 9))}
  [time distance-to-beat]
  (->> (range 1 (inc time))
       (filter (fn [speed]
                 (let [time-left (- time speed)
                       distance (* speed time-left)]
                   (> distance distance-to-beat)))) 
       (count)))

(defn day06-part1
  {:test (fn []
           (is= (day06-part1 day06-example) 288))}
  [text]
  (let [{time :time distance :distance} (text->document text)]
    (->> (map calculate-winners time distance)
         (apply *))))

(comment
  (time (day06-part1 day06-puzzle))
  ; (out) "Elapsed time: 0.473989 msecs"
  ; 3317888
  )
