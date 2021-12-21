(ns year2021.day21.day21-part1
  (:require [ysera.test :refer [is is= is-not deftest]]
            [year2021.day21.day21-data :refer [day21-example day21-puzzle]]))

(defn update-pos
  [pos dice-score]
  (loop [pos (+ pos dice-score)]
    (if (> pos 10)
      (recur (- pos 10))
      pos)))

(defn day21-part1
  {:test (fn []
           (is= (day21-part1 4 8) 739785)                   ; example
           (is= (day21-part1 7 10) 802452)                  ; puzzle
           )}
  [p1-pos p2-pos]
  (let [[score rolls] (loop [p1-pos p1-pos
                             p2-pos p2-pos
                             p1-score 0
                             p2-score 0
                             rolls 0
                             active-player :p1]
                        (cond
                          (>= p1-score 1000)
                          [p2-score rolls]

                          (>= p2-score 1000)
                          [p1-score rolls]

                          (= :p1 active-player)
                          (let [p1-pos (->> (range 3)
                                            (map #(+ rolls %))
                                            (map #(+ 1 (mod % 100)))
                                            (reduce +)
                                            (update-pos p1-pos))]
                            (recur p1-pos
                                   p2-pos
                                   (+ p1-score p1-pos)
                                   p2-score
                                   (+ rolls 3)
                                   :p2))

                          (= :p2 active-player)
                          (let [p2-pos (->> (range 3)
                                            (map #(+ rolls %))
                                            (map #(+ 1 (mod % 100)))
                                            (reduce +)
                                            (update-pos p2-pos))]
                            (recur p1-pos
                                   p2-pos
                                   p1-score
                                   (+ p2-score p2-pos)
                                   (+ rolls 3)
                                   :p1))))]
    (* score rolls)))

(comment
  (time (day21-part1 7 10))
  ;"Elapsed time: 0.995464 msecs"
  ;=> 802452
  )
