(ns day15.day15part1
  (:require [ysera.test :refer [is is= is-not deftest]]
            [clojure.string :as str]))

(defn string->spoken-words
  {:test (fn []
           (is= (string->spoken-words "0,3,6")
                {:word-map {0 1, 3 2}
                 :number   6
                 :idx      3})
           (is= (string->spoken-words "0,3,6,0")
                {:word-map {0 1, 3 2, 6 3}
                 :number   0
                 :idx      4})
           (is= (string->spoken-words "0,3,6,0,4")
                {:word-map {3 2, 6 3, 0 4}
                 :number   4
                 :idx      5}))}
  [string]
  (let [numbers (->> (str/split string #",")
                     (map read-string))]
    {:number   (last numbers)
     :word-map (->> numbers
                    (drop-last)
                    (map-indexed (fn [i n] {n (inc i)}))
                    (reduce merge))
     :idx      (count numbers)}))



;0,3,6,0,3,3,0,4,0
(defn last-spoken
  {:test (fn []
           (is= (last-spoken (string->spoken-words "0,3,6"))
                (string->spoken-words "0,3,6,0"))
           (is= (last-spoken (string->spoken-words "0,3,6,0"))
                (string->spoken-words "0,3,6,0,3"))
           (is= (last-spoken (string->spoken-words "0,3,6,0,3"))
                (string->spoken-words "0,3,6,0,3,3")))}
  [{word-map :word-map number :number idx :idx :as state}]
  {:number   (if-let [number (get word-map number)]
               (- idx number)
               0)
   :word-map (merge word-map {number idx})
   :idx      (inc idx)})

(defn nth-spoken
  {:test (fn []
           (is= (nth-spoken "1,3,2" 2020) 1)
           (is= (nth-spoken "2,1,3" 2020) 10)
           (is= (nth-spoken "1,2,3" 2020) 27)
           (is= (nth-spoken "2,3,1" 2020) 78)
           (is= (nth-spoken "3,2,1" 2020) 438)
           (is= (nth-spoken "3,1,2" 2020) 1836)

           (comment (nth-spoken "1,3,2" 30000000) 2578)
           (comment (nth-spoken "2,1,3" 30000000) 3544142)
           (comment (nth-spoken "1,2,3" 30000000) 261214)
           (comment (nth-spoken "2,3,1" 30000000) 6895259)
           (comment (nth-spoken "3,2,1" 30000000) 18)
           (comment (nth-spoken "3,1,2" 30000000) 362))}
  [string wanted-index]
  (loop [{idx :idx number :number :as state} (string->spoken-words string)]
    (if (= wanted-index idx)
      number
      (recur (last-spoken state)))))

(comment
  (nth-spoken "14,8,16,0,1,17" 2020)                        ; 240
  (nth-spoken "14,8,16,0,1,17" 30000000)                    ; 505
  )