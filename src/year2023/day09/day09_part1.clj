(ns year2023.day09.day09-part1
  (:require
    [utils.numbers :refer [all-zeroes?]]
    [utils.text :refer [line->words text->lines]]
    [year2023.day09.day09-data :refer [day09-example day09-puzzle]]
    [ysera.test :refer [is=]]))

(defn line->report
  [line]
  (->> line
       (line->words)
       (map read-string)))

(defn text->report
  [text]
  (->> text
       (text->lines)
       (map line->report)))

(defn next-number 
  {:test (fn[]
           (is= (next-number [0 3 6 9 12 15]) 18)
           (is= (next-number [1 3 6 10 15 21]) 28)
           (is= (next-number [10 13 16 21 30 45]) 68))} 
  [numbers]
  (loop [layers (list numbers)]
    (if (->> layers (first) (all-zeroes?))
      (->> layers
           (map last)
           (apply +))
      (let [layer (first layers)]
        (recur (conj layers (map - (drop 1 layer) layer)))))))


(defn day09-part1
  {:test (fn [] (is= (day09-part1 day09-example) 114))}
  [text]
  (->> text
       (text->report)
       (map next-number)
       (apply +)))

(comment
  (time (day09-part1 day09-puzzle))
  ; (out) "Elapsed time: 5.876067 msecs"
  ; 1479011877
  )
