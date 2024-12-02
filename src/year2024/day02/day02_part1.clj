(ns year2024.day02.day02-part1
  (:require [ysera.test :refer [is is= is-not deftest]]
            [year2024.day02.day02-data :refer [day02-example day02-puzzle]]
            [clojure.string :as str]))

(defn ok-diffs?
  [numbers]
  (loop [[n & numbers] numbers]
    (cond
      (nil? n) true
      (zero? n) false
      (> (abs n) 3) false
      :else (recur numbers))))

(defn same-direction?
  [numbers]
  (let [signs (map pos? numbers)]
    (loop [[s1 & signs] signs]
      (let [s2 (first signs)]
        (cond
          (nil? s2) true
          (not= s1 s2) false
          :else (recur signs))))))

(defn safe? 
  {:test (fn []
           (is (safe? "7 6 4 2 1"))
           (is-not (safe? "1 2 7 8 9"))
           (is-not (safe? "9 7 6 2 1"))
           (is-not (safe? "1 3 2 4 5"))
           (is-not (safe? "8 6 4 4 1"))
           (is (safe? "1 3 6 7 9")))}
  [line]
  (let [numbers (->> (str/split line #"\s")
                     (map read-string))
        differences (map - numbers (drop 1 numbers))]
    (and (ok-diffs? differences) 
         (same-direction? differences))))

(defn day02-part1
  {:test (fn []
           (is= (day02-part1 day02-example) 2))}
  [text]
  (->> text
       (str/split-lines)
       (filter safe?)
       (count)))

(comment
  (time (day02-part1 day02-puzzle))
  ; (out) "Elapsed time: 9.958939 msecs"
  ; 356
  )
