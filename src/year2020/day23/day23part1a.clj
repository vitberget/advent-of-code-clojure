(ns year2020.day23.day23part1a
  (:require [ysera.test :refer [is is= is-not]]
            [ysera.collections :refer [index-of]]
            [clojure.string :as str]))

(defn string->cups
  {:test (fn []
           (is= (string->cups "389125467")
                '(3 8 9 1 2 5 4 6 7)))}
  [string]
  (->> string
       (map str)
       (map read-string)))

(defn destination-cup
  {:test (fn []
           (is= (destination-cup '(8 9 1) 3) 2)
           (is= (destination-cup '(8 9 1) 2) 7)
           (is= (destination-cup '(4 6 7) 5) 3)
           (is= (destination-cup '(6 7 9) 4) 3)
           (is= (destination-cup '(3 6 7) 1) 9)
           (is= (destination-cup '(7 4 1) 5) 3))}
  [three-cups cup]
  (loop [cup (dec cup)]
    (cond
      (< cup 1)
      (recur 9)

      (not (some #{cup} three-cups))
      cup

      :else
      (recur (dec cup)))))




; The crab selects a destination cup: the cup with a label equal to the current cup's label minus one.
; If this would select one of the cups that was just picked up, the crab will keep subtracting one
; until it finds a cup that wasn't just picked up. If at any point in this process the value goes
; below the lowest value on any cup's label, it wraps around to the highest value on any cup's label
; instead.

(defn move-cups
  {:test (fn []
           (let [; Moves från exempel del 1
                 move1 '(3 8 9 1 2 5 4 6 7)
                 move2 '(2 8 9 1 5 4 6 7 3)
                 move3 '(5 4 6 7 8 9 1 3 2)
                 move4 '(8 9 1 3 4 6 7 2 5)
                 move5 '(4 6 7 9 1 3 2 5 8)
                 move6 '(1 3 6 7 9 2 5 8 4)
                 move7 '(9 3 6 7 2 5 8 4 1)
                 move8 '(2 5 8 3 6 7 4 1 9)
                 move9 '(6 7 4 1 5 8 3 9 2)
                 move10 '(5 7 4 1 8 3 9 2 6)
                 final '(8 3 7 4 1 9 2 6 5)]
             (is= (move-cups move1) move2)
             (is= (move-cups move2) move3)
             (is= (move-cups move3) move4)
             (is= (move-cups move4) move5)
             (is= (move-cups move5) move6)
             (is= (move-cups move6) move7)
             (is= (move-cups move7) move8)
             (is= (move-cups move8) move9)
             (is= (move-cups move9) move10)
             (is= (move-cups move10) final)))}
  [cups]
  (let [dbl-cups (concat cups cups)

        three-cups (->> dbl-cups (drop 1) (take 3))
        destination-cup (destination-cup three-cups (first cups))]
    (loop [result '()
           [cup & rest] (->> dbl-cups
                             (filter (fn [c] (not (some #{c} three-cups)))))]

      (if (= cup destination-cup)
        (->> (concat result [cup] three-cups rest)
             (drop 1)
             (take 9))
        (recur (concat result [cup]) rest)))))

(defn move-cups-n-times
  {:test (fn []
           (is= (move-cups-n-times '(3 8 9 1 2 5 4 6 7) 10)
                '(8 3 7 4 1 9 2 6 5)))}
  [cups times]
  (loop [i 0
         cups cups]
    (if (= i times)
      cups
      (recur (inc i) (move-cups cups)))))


(defn that-remove-one-thing
  {:test (fn []
           (is= (that-remove-one-thing '(8 3 7 4 1 9 2 6 5))
                '(9 2 6 5 8 3 7 4)))}
  [numbers]
  (loop [part1 '()
         [n & part2] numbers]
    (if (= n 1)
      (concat part2 part1)
      (recur (concat part1 [n]) part2))))

(defn day23part1
  {:test (fn []
           (is= (day23part1 "389125467" 10)
                "92658374")
           (is= (day23part1 "389125467" 100)
                "67384529"))}
  [string times]
  (->> (-> string
           (string->cups)
           (move-cups-n-times times)
           (that-remove-one-thing))
       (reduce str)
       ))

(comment
  (def puzzle "784235916")
  (time (day23part1 puzzle 100))
  ;"Elapsed time: 3.539361 msecs"
  ;=> "53248976"

  )