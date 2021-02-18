(ns year2020.day23.day23part1b
  (:require [year2020.day23.map-common :refer [string->numbers
                                               numbers->state
                                               move-cups-n-times]]
            [ysera.test :refer [is is= is-not]]))

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