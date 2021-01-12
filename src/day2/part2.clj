(ns day2.part2
  (:require [ysera.test :refer [is is= is-not]]
            [clojure.string :as str]))



(defn split-rule
  {:test (fn []
           (is= (split-rule "1-3 a: abcde")
                {:lower 1 :higher 3 :letter \a :test "abcde"}))}
  [string]
  (let [refi (->> string
                  (re-find #"(\d+)-(\d+)\s+(.+):\s+(.+)")
                  (rest))]
    {:lower  (read-string (nth refi 0))
     :higher (read-string (nth refi 1))
     :letter (first (nth refi 2))
     :test   (nth refi 3)}))


(defn same-letter?
  [c1 c2]
  (if (= c1 c2)
    true
    false))


(defn valid-rule?
  {:test (fn []
           (is (valid-rule? "1-3 a: abcde"))
           (is-not (valid-rule? "1-3 b: cdefg"))
           (is-not (valid-rule? "2-9 c: ccccccccc"))
           )}

  [string]
  (let [rule (split-rule string)
        l1 (nth (:test rule) (dec (:lower rule)))
        l2 (nth (:test rule) (dec (:higher rule)))
        b1 (same-letter? (:letter rule) l1)
        b2 (same-letter? (:letter rule) l2)
        ]
    (not (= b1 b2))))

(defn part1
  {:test (fn []
           (is= (part1 "1-3 a: abcde\n1-3 b: cdefg\n2-9 c: ccccccccc")
                1))}
  [question]
  (as-> question $
        (str/split $ #"\n")
        (filter valid-rule? $)
        (count $)))

(comment
  (part1 "1-3 a: abcde\n1-3 b: cdefg\n2-9 c: ccccccccc")

  )
