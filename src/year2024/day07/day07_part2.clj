(ns year2024.day07.day07-part2
  (:require
   [clojure.math.numeric-tower :as math]
   [utils.text :as ut]
   [year2024.day07.day07-data :refer [day07-example day07-puzzle]]
   [year2024.day07.day07-part1 :as part-1]
   [ysera.test :refer [is= is is-not]]
   [clojure.edn :as edn]))

(defn the-concat
  [num1 num2]
  (edn/read-string (str num1 num2)))

(defn do-the-math
  [numbers operator]
  (loop [[number & numbers] numbers
         result nil
         operator operator]
    (cond
      (nil? number) result
      (nil? result) (recur numbers number operator) 
      :else (let [the-fn (condp = (mod operator 3)
                           0 *
                           1 +
                           2 the-concat)]
              (recur numbers (the-fn result number) (quot operator 3))))))

(defn solvable?
  {:test (fn[]
           (is (solvable? (part-1/line->equation "190: 10 19")))
           (is (solvable? (part-1/line->equation "3267: 81 40 27")))
           (is-not (solvable? (part-1/line->equation "83: 17 5")))
           (is (solvable? (part-1/line->equation "156: 15 6")))
           (is (solvable? (part-1/line->equation "7290: 6 8 6 15")))
           (is-not (solvable? (part-1/line->equation "161011: 16 10 13")))
           (is (solvable? (part-1/line->equation "192: 17 8 14")))
           (is-not (solvable? (part-1/line->equation "21037: 9 7 18 13")))
           (is (solvable? (part-1/line->equation "292: 11 6 16 20"))))}
  [[solution numbers]]
  (let [operators (math/expt 3 (dec (count numbers)))]
    (loop [operator 0]
      (if (>= operator operators)
        false 
        (or (= solution (do-the-math numbers operator))
            (recur (inc operator)))))))

(defn day07-part2
  {:test (fn [] (is= (day07-part2 day07-example) 11387))}
  [text]
  (->> text
       (ut/text->lines)
       (map part-1/line->equation)
       (filter solvable?)
       (map first)
       (reduce +)))

(comment
  (time (day07-part2 day07-puzzle))
  ; (out) "Elapsed time: 14477.585764 msecs"
  ; 438027111276610
  )
