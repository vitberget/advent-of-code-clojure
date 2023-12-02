(ns year2023.day01.day01-part2
  (:require
    [utils.text :refer [text->lines]]
    [year2023.day01.day01-data :refer [day01-example-2 day01-puzzle]]
    [year2023.day01.day01-part1 :as part-1]
    [ysera.test :refer [is=]]
    [clojure.string :as s]))

(defn- get-number 
  [line]
  (cond
    (s/starts-with? line "0") "0" 
    (s/starts-with? line "1") "1" 
    (s/starts-with? line "2") "2" 
    (s/starts-with? line "3") "3" 
    (s/starts-with? line "4") "4" 
    (s/starts-with? line "5") "5" 
    (s/starts-with? line "6") "6" 
    (s/starts-with? line "7") "7" 
    (s/starts-with? line "8") "8" 
    (s/starts-with? line "9") "9" 
    (s/starts-with? line "zero") "0" 
    (s/starts-with? line "one") "1" 
    (s/starts-with? line "two") "2" 
    (s/starts-with? line "three") "3" 
    (s/starts-with? line "four") "4" 
    (s/starts-with? line "five") "5" 
    (s/starts-with? line "six") "6" 
    (s/starts-with? line "seven") "7" 
    (s/starts-with? line "eight") "8" 
    (s/starts-with? line "nine") "9" 
    :else nil))

(defn words->digits
  {:test (fn []
           (is= (words->digits "two1nine") "219")
           (is= (words->digits "eightwothree") "823"))}
  [line]
  (loop [line line
         result ""]
    (if (empty? line)
      result
      (if-let [number (get-number line)]
        (recur (subs line 1) (str result number)) 
        (recur (subs line 1) result) ))))

(defn line->calibration
  {:test (fn []
           (is= (line->calibration "two1nine") 29)
           (is= (line->calibration "eightwothree") 83)
           (is= (line->calibration "abcone2threexyz") 13)
           (is= (line->calibration "xtwone3four") 24)
           (is= (line->calibration "4nineeightseven2") 42)
           (is= (line->calibration "zoneight234") 14)
           (is= (line->calibration "7pqrstsixteen") 76))}
  [line]
  (->> line
       (words->digits)
       (part-1/line->calibration)))

(defn day01-part2
  {:test (fn []
           (is= (day01-part2 day01-example-2) 281)
           (is= (day01-part2 day01-puzzle) 53389))}
  [text]
  (->> text
       (text->lines)
       (map line->calibration)
       (reduce +)))

(comment
  (time (day01-part2 day01-puzzle))
  ; (out) "Elapsed time: 19.294589 msecs"
  ; 53389
  )
