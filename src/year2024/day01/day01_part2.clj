(ns year2024.day01.day01-part2
  (:require [ysera.test :refer [is is= is-not deftest]]
            [year2024.day01.day01-data :refer [day01-example day01-puzzle]]
            [clojure.string :as str]))

(defn count-num 
  [n lst]
  (->> lst
       (filter (fn [ln] (= n ln)))
       (count)))

(defn day01-part2
  {:test (fn []
           (is= (day01-part2 day01-example) 31))}
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
                  $))]
    (->> left
         (map (fn[n] (* n (count-num n right))))
         (reduce +))))

(comment
  (time (day01-part2 day01-puzzle))  
  ; 23927637
  )
