(ns day5.day5part1
  (:require [ysera.test :refer [is is= is-not]]
            [clojure.string :as str]))


(defn lower-half
  {:test (fn []
           (is= (lower-half [0 127]) [0 63])
           (is= (lower-half [32 63]) [32 47])

           (is= (lower-half [0 63]) [0 31])
           (is= (lower-half [32 47]) [32 39])

           (is= (lower-half [44 45]) [44 44])
           )}
  [the-list]
  (let [n1 (first the-list)
        n2 (second the-list)]
    [n1
     (int (+ n1 (/ (- n2 n1) 2)))]))

(defn upper-half
  {:test (fn []
           (is= (upper-half [0 127]) [64 127])
           (is= (upper-half [32 63]) [48 63])

           (is= (upper-half [0 63]) [32 63])
           (is= (upper-half [32 47]) [40 47])

           (is= (upper-half [44 45]) [45 45])
           )}
  [the-list]
  (let [n1 (first the-list)
        n2 (second the-list)]
    [(+ n1 1 (int (/ (- n2 n1) 2)))
     n2]))

(defn get-row
  {:test (fn []
           (is= (get-row "FBFBBFFRLR") 44)
           (is= (get-row "BFFFBBFRRR") 70)
           (is= (get-row "FFFBBBFRRR") 14)
           (is= (get-row "BBFFBBFRLL") 102)
           )}
  [string]
  (loop [range [0 127]
         string string]
    (if (= (first range) (second range))
      (first range)
      (recur (if (= \F (first string))
               (lower-half range)
               (upper-half range))
             (rest string)))))

(defn get-column
  {:test (fn []
           (is= (get-column "FBFBBFFRLR") 5)
           (is= (get-column "BFFFBBFRRR") 7)
           (is= (get-column "FFFBBBFRRR") 7)
           (is= (get-column "BBFFBBFRLL") 4)
           )}
  [string]
  (loop [range [0 7]
         string (take-last 3 string)]
    (if (= (first range) (second range))
      (first range)
      (recur (if (= \L (first string))
               (lower-half range)
               (upper-half range))
             (rest string)))))

(defn string->boarding-card
  {:test (fn []
           (is= (string->boarding-card "BFFFBBFRRR")
                {:row 70 :column 7 :seat 567})
           (is= (string->boarding-card "FFFBBBFRRR")
                {:row 14 :column 7 :seat 119})
           (is= (string->boarding-card "BBFFBBFRLL")
                {:row 102 :column 4 :seat 820})
           )
   }
  [string]
  (let [row (get-row string)
        column (get-column string)]
    {:row    row
     :column column
     :seat   (+ column (* row 8))}))


(defn day5part1
  [string]
  (->> (str/split string #"\n")
       (map string->boarding-card)
       (map :seat)
       (reduce max)
       ))

(defn day5part2
  [string]
  (let [seats (->> (str/split string #"\n")
                   (map string->boarding-card)
                   (map :seat)
                   (sort))]
    (loop [seat (first seats)
           seats (rest seats)]
      (let [next-seat (first seats)]
        (println seat next-seat)
        (if (= (+ seat 2) next-seat)
          (inc seat)
          (recur next-seat (rest seats)))))))

(comment
  (day5part1 "BFFFBBFRRR\nFFFBBBFRRR\nBBFFBBFRLL")







  )