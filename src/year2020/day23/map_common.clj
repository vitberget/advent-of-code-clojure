(ns year2020.day23.map-common
  (:require [ysera.test :refer [is is= is-not]]))

(defn numbers->state
  {:test (fn []
           (is= (numbers->state (list 3 8 9 1 2 5 4 6 7))
                {:ring    {3 8, 8 9, 9 1, 1 2, 2 5, 5 4, 4 6, 6 7, 7 3}
                 :current 3}))}
  [numbers]
  {:ring    (->> (map (fn [n1 n2] [n1 n2])
                      (cons (last numbers) (drop-last numbers))
                      numbers)
                 (into {}))
   :current (first numbers)})

(defn string->numbers
  [string]
  (->> string
       (map str)
       (map read-string)))

(defn destination-cup
  "The crab selects a destination cup: the cup with a label equal to the current cup's label minus one.
   If this would select one of the cups that was just picked up, the crab will keep subtracting one
   until it finds a cup that wasn't just picked up. If at any point in this process the value goes
   below the lowest value on any cup's label, it wraps around to the highest value on any cup's label
   instead."
  {:test (fn []
           (is= (destination-cup 3 #{8 9 1} 9) 2)
           (is= (destination-cup 2 #{8 9 1} 9) 7)
           (is= (destination-cup 5 #{4 6 7} 9) 3)
           (is= (destination-cup 4 #{6 7 9} 9) 3)
           (is= (destination-cup 1 #{3 6 7} 9) 9)
           (is= (destination-cup 5 #{7 4 1} 9) 3))}
  [current three ring-size]
  (loop [cup (dec current)]
    (cond
      (< cup 1)
      (recur ring-size)

      (contains? three cup)
      (recur (dec cup))

      :else cup)))

(defn move-cups
  {:test (fn []
           (let [; Moves från exempel del 1
                 move-1 (numbers->state (list 3 8 9 1 2 5 4 6 7))
                 move-2 (numbers->state (list 2 8 9 1 5 4 6 7 3))
                 move-3 (numbers->state (list 5 4 6 7 8 9 1 3 2))
                 move-4 (numbers->state (list 8 9 1 3 4 6 7 2 5))
                 move-5 (numbers->state (list 4 6 7 9 1 3 2 5 8))
                 move-6 (numbers->state (list 1 3 6 7 9 2 5 8 4))
                 move-7 (numbers->state (list 9 3 6 7 2 5 8 4 1))
                 move-8 (numbers->state (list 2 5 8 3 6 7 4 1 9))
                 move-9 (numbers->state (list 6 7 4 1 5 8 3 9 2))
                 move-10 (numbers->state (list 5 7 4 1 8 3 9 2 6))
                 final (numbers->state (list 8 3 7 4 1 9 2 6 5))]
             (is= (move-cups move-1) move-2)
             (is= (move-cups move-2) move-3)
             (is= (move-cups move-3) move-4)
             (is= (move-cups move-4) move-5)
             (is= (move-cups move-5) move-6)
             (is= (move-cups move-6) move-7)
             (is= (move-cups move-7) move-8)
             (is= (move-cups move-8) move-9)
             (is= (move-cups move-9) move-10)
             (is= (move-cups move-10) final)))}
  [{ring :ring current :current}]
  (let [cw1 (ring current)
        cw2 (ring cw1)
        cw3 (ring cw2)
        cw-of-three (ring cw3)
        destination-cup (destination-cup current #{cw1 cw2 cw3} (count ring))]
    {:ring    (assoc ring current cw-of-three
                          destination-cup cw1
                          cw3 (ring destination-cup))
     :current cw-of-three}))

(defn move-cups-n-times
  {:test (fn []
           (is= (move-cups-n-times (numbers->state '(3 8 9 1 2 5 4 6 7)) 10)
                (numbers->state '(8 3 7 4 1 9 2 6 5))))}
  [cups times]
  (reduce
    (fn [cups _] (move-cups cups))
    cups
    (range 0 times)))
