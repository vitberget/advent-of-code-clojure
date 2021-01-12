(ns day1.part1
  (:require [ysera.test :refer [is is= is-not]]))

(defn number-and-list-adding-up-to-2020
  {:test (fn []
           (is= (number-and-list-adding-up-to-2020 1721 [299]) 299)
           (is= (number-and-list-adding-up-to-2020 1721 [10 299]) 299)
           (is= (number-and-list-adding-up-to-2020 1721 []) nil)
           (is= (number-and-list-adding-up-to-2020 1721 [99]) nil))}
  [num list]
  (loop [list list]
    (if (empty? list)
      nil
      (let [listnum (first list)]
        (if (= 2020 (+ num listnum))
          listnum
          (recur (rest list)))))))



(defn numbers-adding-up-to-2020
  {:test
   (fn []
     (is= (numbers-adding-up-to-2020 [1721 979 366 299 675 1456]) [1721 299])
     (is= (numbers-adding-up-to-2020 [979 366 299 675 1456 1721]) [299 1721]))}
  [numbers]
  (loop [num (first numbers)
         list (rest numbers)]
    (if-let [adds-up (number-and-list-adding-up-to-2020 num list)]
      [num adds-up]
      (recur (first list) (rest list)))))

(defn day1
  {:test (fn []
           (is= (day1 [1721 979 366 299 675 1456]) 514579))}
  [numbers]
  (reduce * (numbers-adding-up-to-2020 numbers)))

(comment
  (day1 [1721 979 366 299 675 1456])
    )



