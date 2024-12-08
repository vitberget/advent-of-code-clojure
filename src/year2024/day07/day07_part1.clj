(ns year2024.day07.day07-part1
  (:require [ysera.test :refer [is is= is-not deftest]]
            [year2024.day07.day07-data :refer [day07-example day07-puzzle]]
            [clojure.string :as str]
            [utils.text :as ut]
            [clojure.edn :as edn]
            [clojure.math.numeric-tower :as math]))

(defn line->equation
  [line]
  (let [[solution numbers] (ut/split-on #":" line)
        solution (->> solution
                      str/trim
                      (edn/read-string))
        numbers (->> numbers
                     (str/trim)
                     (ut/split-on #" ")
                     (map edn/read-string))]
    [solution numbers] ))

(defn do-the-math
  [numbers operator]
  (loop [[number & numbers] numbers
         result nil
         position 0]
    (cond
      (nil? number) result
      (nil? result) (recur numbers number 0) 
      :else (let [the-fn (if (zero? (bit-and operator (math/expt 2 position))) * +)]
              (recur numbers (the-fn result number) (inc position))))))

(defn solvable?
  {:test (fn[]
           (is (solvable? (line->equation "190: 10 19")))
           (is (solvable? (line->equation "3267: 81 40 27")))
           (is-not (solvable? (line->equation "83: 17 5")))
           (is-not (solvable? (line->equation "156: 15 6")))
           (is-not (solvable? (line->equation "7290: 6 8 6 15")))
           (is-not (solvable? (line->equation "161011: 16 10 13")))
           (is-not (solvable? (line->equation "192: 17 8 14")))
           (is-not (solvable? (line->equation "21037: 9 7 18 13")))
           (is (solvable? (line->equation "292: 11 6 16 20"))))}
  [[solution numbers]]
  (let [operators (math/expt 2 (dec (count numbers)))]
    (loop [operator 0]
      (if (>= operator operators)
        false 
        (or (= solution (do-the-math numbers operator))
            (recur (inc operator)))))))

(defn day07-part1
  {:test (fn [] (is= (day07-part1 day07-example) 3749))}
  [text]
  (->> text
       (ut/text->lines)
       (map line->equation)
       (filter solvable?)
       (map first)
       (reduce +)))

(comment
  (time (day07-part1 day07-puzzle))
  ; (out) "Elapsed time: 155.992943 msecs"
  ; 7579994664753
  )
