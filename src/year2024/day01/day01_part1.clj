(ns year2024.day01.day01-part1
  (:require [ysera.test :refer [is is= is-not deftest]]
            [year2024.day01.day01-data :refer [day01-example day01-puzzle]]
            [clojure.string :as str]))

(defn day01-part1
  {:test (fn []
           (is= (day01-part1 day01-example) 11))}
  [text]
  (let [{left :left right :right}
        (as-> text $
          (str/split-lines $)
          (map (fn [line] (->> (str/split line #"\s+") (map read-string))) $)
          (reduce (fn[acc [left right]]
                    (-> acc
                        (update :left conj left)
                        (update :right conj right))) 
                  {:left [] :right []}
                  $)
          (update $ :right sort)
          (update $ :left sort))]
    (->> (map - left right)
         (map abs)
         (reduce +))))

(comment
  (time (day01-part1 day01-puzzle)) 
  ; 2815556
  )
