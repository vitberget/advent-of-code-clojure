(ns year2020.day23.day23part1b
  (:require [ysera.test :refer [is is= is-not]]
            [ysera.collections :refer [index-of]]
            [clojure.string :as str]))

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
   :current (first numbers)
   })


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
                 move1 (numbers->state (list 3 8 9 1 2 5 4 6 7))
                 move2 (numbers->state (list 2 8 9 1 5 4 6 7 3))
                 move3 (numbers->state (list 5 4 6 7 8 9 1 3 2))
                 move4 (numbers->state (list 8 9 1 3 4 6 7 2 5))
                 move5 (numbers->state (list 4 6 7 9 1 3 2 5 8))
                 move6 (numbers->state (list 1 3 6 7 9 2 5 8 4))
                 move7 (numbers->state (list 9 3 6 7 2 5 8 4 1))
                 move8 (numbers->state (list 2 5 8 3 6 7 4 1 9))
                 move9 (numbers->state (list 6 7 4 1 5 8 3 9 2))
                 move10 (numbers->state (list 5 7 4 1 8 3 9 2 6))
                 final (numbers->state (list 8 3 7 4 1 9 2 6 5))]
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
  [{ring :ring current :current}]
  (let [n1 (ring current)
        n2 (ring n1)
        n3 (ring n2)
        n4 (ring n3)
        destination-cup (destination-cup current #{n1 n2 n3} (count ring))
        ring (merge ring
                    {current         n4
                     destination-cup n1
                     n3              (ring destination-cup)
                     })]
    {:ring    ring
     :current (ring current)}))



(defn move-cups-n-times
  {:test (fn []
           (is= (move-cups-n-times (numbers->state '(3 8 9 1 2 5 4 6 7)) 10)
                (numbers->state '(8 3 7 4 1 9 2 6 5))))}
  [cups times]
  (loop [i 0
         cups cups]
    (if (= i times)
      cups
      (recur (inc i) (move-cups cups)))))

(defn that-remove-one-thing
  {:test (fn []
           (is= (that-remove-one-thing (numbers->state '(8 3 7 4 1 9 2 6 5)))
                '(9 2 6 5 8 3 7 4)))}
  [{ring :ring}]
  (loop [result '()
         number 1]
    (let [target (ring number)]
      (if (= target 1)
        (reverse result)
        (recur (cons target result)
               target)))))

(defn day23part1
  {:test (fn []
           (is= (day23part1 "389125467" 10)
                "92658374")
           (is= (day23part1 "389125467" 100)
                "67384529"))}
  [string times]
  (->> (-> string
           (string->numbers)
           (numbers->state)
           (move-cups-n-times times)
           (that-remove-one-thing)
           )
       (reduce str)))

(comment
  (def puzzle "784235916")
  (time (day23part1 puzzle 100))
  ; "Elapsed time: 0.59605 msecs"
  ; => "53248976"
  )