(ns year2022.day2.day2-part1
  (:require [clojure.string :as str]
            [year2022.day2.day2-data :refer [day2-example day2-puzzle]]
            [ysera.test :refer [is=]]))

(defn char->rps
  [string]
  (condp = string
    "A" :rock
    "B" :paper
    "C" :scissors

    "X" :rock
    "Y" :paper
    "Z" :scissors))

(defn line->rps
  {:test (fn []
           (is= (line->rps "A X") [:rock :rock]))}
  [line]
  (->> (str/split line #" ")
       (map char->rps)))

(def shape-score
  {:rock     1
   :paper    2
   :scissors 3})

(def game-score
  {:loss 0
   :even 3
   :win  6})

(defn win?
  [opponent you]
  (or
    (and (= you :rock)
         (= opponent :scissors))
    (and (= you :paper)
         (= opponent :rock))
    (and (= you :scissors)
         (= opponent :paper))))

(defn game-status
  [opponent you]
  (cond
    (= opponent you) :even
    (win? opponent you) :win
    :else :loss))

(defn score
  {:test (fn []
           (is= (score :rock :paper) 8)
           (is= (score :paper :rock) 1)
           (is= (score :scissors :scissors) 6))}
  [opponent you]
  (+ (shape-score you)
     (game-score (game-status opponent you))))

(defn day2-part1
  {:test (fn []
           (is= (day2-part1 day2-example) 15)
           (is= (day2-part1 day2-puzzle) 11475))}
  [text]
  (->> text
       (str/split-lines)
       (map line->rps)
       (map #(apply score %1))
       (reduce +)))

(comment
  (time (day2-part1 day2-puzzle))
  ;"Elapsed time: 5.161778 msecs"
  ;=> 11475
  )
