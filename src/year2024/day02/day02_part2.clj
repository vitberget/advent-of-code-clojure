(ns year2024.day02.day02-part2
  (:require [ysera.test :refer [is is= is-not deftest]]
            [year2024.day02.day02-data :refer [day02-example day02-puzzle]]
            [year2024.day02.day02-part1 :as p1]
            [clojure.string :as str]))

(defn safe? 
  {:test (fn []
           (is (safe? [ 7 6 4 2 1 ]))
           (is-not (safe? [ 1 2 7 8 9 ]))
           (is-not (safe? [ 9 7 6 2 1 ]))
           (is-not (safe? [ 1 3 2 4 5 ]))
           (is-not (safe? [ 8 6 4 4 1 ]))
           (is (safe? [ 1 3 6 7 9 ])))}
  [numbers]
  (let [differences (map - numbers (drop 1 numbers))]
    (and (p1/ok-diffs? differences) 
         (p1/same-direction? differences))))

(defn sorta-safe? 
  {:test (fn []
           (is (sorta-safe? [ 7 6 4 2 1 ]))
           (is-not (sorta-safe? [ 1 2 7 8 9 ]))
           (is-not (sorta-safe? [ 9 7 6 2 1 ]))
           (is (sorta-safe? [ 1 3 2 4 5 ]))
           (is (sorta-safe? [ 8 6 4 4 1 ]))
           (is (sorta-safe? [ 1 3 6 7 9 ])))}
  [numbers]
  (or (safe? numbers)
      (loop [prev []
             [n & numbers] numbers]
        (cond
          (nil? n) false 
          (safe? (concat prev numbers))  true
          :else (recur (conj prev n) numbers)))))

(defn line->numbers
  [line]
  (->> (str/split line #"\s")
       (map read-string)))

(defn day02-part2
  {:test (fn []
           (is= (day02-part2 day02-example) 4))}
  [text]
  (->> text
       (str/split-lines)
       (map line->numbers)
       (filter sorta-safe?)
       (count)))

(comment
  (time (day02-part2 day02-puzzle))
  ; (out) "Elapsed time: 12.910496 msecs"
  ; 413
  )
