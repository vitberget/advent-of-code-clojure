(ns year2023.day06.day06-part2
  (:require
    [utils.text :refer [split-on text->lines]]
    [year2023.day06.day06-data :refer [day06-example day06-puzzle]]
    [year2023.day06.day06-part1 :as part-1]
    [ysera.test :refer [is=]]))

(defn line->numbers
  [line]
  (->> line
       (split-on #" +")
       (drop 1)
       (apply str)
       (read-string)))

(defn text->document
  {:test (fn[]
           (is= (text->document day06-example)
                {:time 71530
                 :distance 940200}))}
  [text]
  (let [step-1 (->> text
                    (text->lines)
                    (map line->numbers))]
    {:time (first step-1)
     :distance (second step-1)}))

(defn day06-part2
  {:test (fn []
           (is= (day06-part2 day06-example) 71503))}
  [text]
  (let [{time :time distance :distance} (text->document text)]
    (part-1/calculate-winners time distance)))

(comment
  (time (day06-part2 day06-puzzle))
  ; (out) "Elapsed time: 1251.331006 msecs"
  ; 24655068
  )
