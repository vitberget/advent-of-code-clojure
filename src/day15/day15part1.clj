(ns day15.day15part1
  (:require [ysera.test :refer [is is= is-not deftest]]
            [clojure.string :as str]))

(defn string->spoken-words
  {:test (fn []
           (is= (string->spoken-words "0,3,6")
                (list 6 3 0)))}
  [string]
  (->> (str/split string #",")
       (map read-string)
       (reverse)))

(defn last-spoken
  {:test (fn []
           (is= (last-spoken (list 6 3 0)) 0)
           (is= (last-spoken (list 0 6 3 0)) 3)
           (is= (last-spoken (list 0 6 3 0 1 2 3)) 3))}

  [[match & list]]
  (loop [idx 1
         [num & list] list]
    (condp = num
      nil 0
      match idx
      (recur (inc idx) list))))

(defn nth-spoken
  {:test (fn []
           (is= (nth-spoken "1,3,2" 2020) 1)
           (is= (nth-spoken "2,1,3" 2020) 10)
           (is= (nth-spoken "1,2,3" 2020) 27)
           (is= (nth-spoken "2,3,1" 2020) 78)
           (is= (nth-spoken "3,2,1" 2020) 438)
           (is= (nth-spoken "3,1,2" 2020) 1836))}
  [string number]
  (loop [spoken-words (string->spoken-words string)]
    (if (= (count spoken-words) number)
      (first spoken-words)
      (recur (conj spoken-words (last-spoken spoken-words))))))


(comment
  (nth-spoken "14,8,16,0,1,17" 2020) ; 240
  )