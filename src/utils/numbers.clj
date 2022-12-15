(ns utils.numbers
  (:require [ysera.test :refer [is is= is-not deftest]]))


(defn limit
  {:test (fn []
           (is= (limit 3 0 2) 2)
           (is= (limit -30 -2 2) -2)
           (is= (limit 1 0 2) 1))}
  [val lower-limit higher-limit]
  (cond
    (< val lower-limit)
    lower-limit

    (> val higher-limit)
    higher-limit

    :else val))

(defn manhattan-distance
  {:test (fn []
           (is= (manhattan-distance [1 0] [0 0]) 1)
           (is= (manhattan-distance [10 0] [0 10]) 20))}
  [pos-1 pos-2]
  (->> (mapv - pos-1 pos-2)
       (map abs)
       (reduce +)))