(ns year2023.day01.day01-part1
  (:require
   [utils.text :refer [digit? text->lines]]
   [year2023.day01.day01-data :refer [day01-example day01-puzzle]]
   [ysera.test :refer [is=]]))

(defn line->calibration
  {:test (fn []
            (is= (line->calibration "1abc2") 12)     
            (is= (line->calibration "pqr3stu8vwx") 38)     
            (is= (line->calibration "a1b2c3d4e5f") 15)     
            (is= (line->calibration "treb7uchet") 77))}
  [line]
  (let [digits (filter digit? line)
        number (str (first digits) (last digits))]
    (read-string number)))

(defn day01-part1
  {:test (fn []
           (is= (day01-part1 day01-example) 142)
           (is= (day01-part1 day01-puzzle) 54338))}
  [text]
    (->> text
         (text->lines)
         (map line->calibration)
         (reduce +)))


(comment
  (time (day01-part1 day01-puzzle))
  ; "Elapsed time: 3.830023 msecs"
  ; 54338
  )
