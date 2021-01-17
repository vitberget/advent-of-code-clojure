(ns year2020.day2.part1
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

(defn count-letters
  [string char]
  (->> string
       (filter (fn [c] (= c char)))
       (count)))

(defn valid-rule?
  {:test (fn []
           (is (valid-rule? "1-3 a: abcde"))
           (is-not (valid-rule? "1-3 b: cdefg"))
           (is (valid-rule? "2-9 c: ccccccccc"))
           )}

  [string]
  (let [rule (split-rule string)
        cnt (count-letters (:test rule) (:letter rule))]
    (and
      (<= cnt (:higher rule))
      (>= cnt (:lower rule)))))

(defn part1
  {:test (fn []
           (is= (part1 "1-3 a: abcde\n1-3 b: cdefg\n2-9 c: ccccccccc")
                2))}
  [question]
  (as-> question $
        (str/split $ #"\n")
        (filter valid-rule? $)
        (count $)))

(comment
  (part1 "1-3 a: abcde\n1-3 b: cdefg\n2-9 c: ccccccccc")
  )
