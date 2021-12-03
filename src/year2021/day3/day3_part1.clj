(ns year2021.day3.day3-part1
  (:require [ysera.test :refer [is is= is-not deftest]]
            [year2021.day3.day3-data :refer [day3-example day3-puzzle]]
            [clojure.string :as str]
            [clojure.math.numeric-tower :as math]))


(defn count-gamma-and-epsilon-inner
  [state index char]
  (-> state
      (update-in [index \1] (fn [n]
                              (if (= char \1)
                                (inc (or n 0))
                                (or n 0))))
      (update-in [index \0] (fn [n]
                              (if (= char \0)
                                (inc (or n 0))
                                (or n 0))))))

(defn count-gamma-and-epsilon
  {:test (fn []
           (is= (count-gamma-and-epsilon nil "00100") {4 {\1 0, \0 1}
                                                       3 {\1 0, \0 1}
                                                       2 {\1 1, \0 0}
                                                       1 {\1 0, \0 1}
                                                       0 {\1 0, \0 1}}))}

  [state line]
  (loop [index 0
         [char & line] (str/reverse line)
         state state]
    (if (nil? char)
      state
      (recur
        (inc index)
        line
        (count-gamma-and-epsilon-inner state index char)))))

(defn calculate-gamma-and-epsilon
  {:test (fn []
           (is= (calculate-gamma-and-epsilon {4 {\1 7, \0 5}
                                              3 {\1 5, \0 7}
                                              2 {\1 8, \0 4}
                                              1 {\1 7, \0 5}
                                              0 {\1 5, \0 7}})
                {:gamma   22
                 :epsilon 9})
           )}
  [gamma-epsilon-state]
  {:gamma (reduce (fn [a [k v]]
                    (if (> (get v \1) (get v \0))
                      (+ a (math/expt 2 k))
                      a))
                  0
                  gamma-epsilon-state
                  )
   :epsilon (reduce (fn [a [k v]]
                      (if (< (get v \1) (get v \0))
                        (+ a (math/expt 2 k))
                        a))
                    0
                    gamma-epsilon-state
                    )})

(defn day3-part1
  {:test (fn []
           (is= (day3-part1 day3-example) 198))}
  [text]
  (->> text
        (str/split-lines )
        (reduce count-gamma-and-epsilon {} )
        (calculate-gamma-and-epsilon )
        (vals )
        (reduce *)))


(comment
  (time (day3-part1 day3-puzzle))
  ;"Elapsed time: 18.867702 msecs"
  ;=> 3429254
  )
