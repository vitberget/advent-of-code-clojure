(ns year2020.day23.day23part2
  (:require [year2020.day23.map-common :refer [string->numbers
                                               numbers->state
                                               move-cups-n-times]]
            [ysera.test :refer [is is= is-not]]))

(defn take-two-after-one
  {:test (fn []
           (is= (take-two-after-one (numbers->state '(8 3 7 4 1 9 2 6 5)))
                #{9 2}))}
  [{ring :ring}]
  (let [n1 (ring 1)
        n2 (ring n1)]
    #{n1 n2}))

(defn day23part2
  {:test (fn []
           (is= (day23part2 "389125467" 10000000)
                (* 934001 159792)))}
  [string times]
  (as-> string $
        (string->numbers $)
        (concat $ (range 10 1000001))
        (numbers->state $)
        (move-cups-n-times $ times)
        (take-two-after-one $)
        (reduce * $)))

(comment
  (def puzzle "784235916")
  (time (day23part2 puzzle 10000000))
  ;"Elapsed time: 27412.697933 msecs"
  ;=> 418819514477
  )