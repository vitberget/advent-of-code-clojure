(ns year2021.day6.day6-part1
  (:require [ysera.test :refer [is is= is-not deftest]]
            [year2021.day6.day6-data :refer [day6-example day6-puzzle]]
            [clojure.string :as str]))

(defn text->numbers
  {:test (fn []
           (is= (text->numbers "3,4,3,1,2") (list 3 4 3 1 2)))}
  [text]
  (as-> text $
        (str/split $ #",")
        (map read-string $)))

(defn one-day
  {:test (fn []
           (is= (one-day (text->numbers "3,4,3,1,2"))
                (text->numbers "2,3,2,0,1"))
           (is= (one-day (text->numbers "1,2,1,6,0,8"))
                (text->numbers "0,1,0,5,6,7,8")))}
  [numbers]
  (loop [[n & numbers] numbers
         new-numbers []
         new-lanterns []]
    (if (nil? n)
      (concat new-numbers new-lanterns)
      (if (= 0 n)
        (recur numbers
               (conj new-numbers 6)
               (conj new-lanterns 8))
        (recur numbers
               (conj new-numbers (dec n))
               new-lanterns)))))

(defn day6-part1
  {:test (fn []
           (is= (day6-part1 day6-example) 5934))}
  [text]
  (let [numbers (->> text
                     (text->numbers))]
    (->> (reduce (fn [a _] (one-day a))
                 numbers
                 (range 80))
         (count))))

(comment
  (time (day6-part1 day6-puzzle))
  ;"Elapsed time: 238.759058 msecs"
  ;=> 350917
  )
