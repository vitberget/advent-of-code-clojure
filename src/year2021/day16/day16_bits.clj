(ns year2021.day16.day16-bits
  (:require [ysera.test :refer [is is= is-not deftest]]
            [clojure.math.numeric-tower :as math]))

(defn char->bits
  [char]
  (condp = char
    \0 [0 0 0 0]
    \1 [0 0 0 1]
    \2 [0 0 1 0]
    \3 [0 0 1 1]
    \4 [0 1 0 0]
    \5 [0 1 0 1]
    \6 [0 1 1 0]
    \7 [0 1 1 1]
    \8 [1 0 0 0]
    \9 [1 0 0 1]
    \A [1 0 1 0]
    \B [1 0 1 1]
    \C [1 1 0 0]
    \D [1 1 0 1]
    \E [1 1 1 0]
    \F [1 1 1 1]))

(defn text->bits
  {:test (fn []
           (is= (text->bits "D2FE28")
                [1 1 0 1 0 0 1 0 1 1 1 1 1 1 1 0 0 0 1 0 1 0 0 0])
           (is= (text->bits "38006F45291200")
                [0 0 1 1 1 0 0 0 0 0 0 0 0 0 0 0 0 1 1 0 1 1 1 1 0 1 0 0 0 1 0 1 0 0 1 0 1 0 0 1 0 0 0 1 0 0 1 0 0 0 0 0 0 0 0 0])
           (is= (->> (text->bits "8A004A801A8002F478")
                     (take 3))
                [1 0 0])
           (is= (->> (text->bits "8A004A801A8002F478")
                     (drop 3)
                     (take 3))
                [0 1 0])
           (is= (text->bits "8A004A801A8002F478")
                [1 0 0 0 1 0 1 0 0 0 0 0 0 0 0 0 0 1 0 0 1 0 1 0 1 0 0 0 0 0 0 0 0 0 0 1 1 0 1 0 1 0 0 0 0 0 0 0 0 0 0 0 0 0 1 0 1 1 1 1 0 1 0 0 0 1 1 1 1 0 0 0])
           )}
  [text]
  (->> text
       (mapcat char->bits)
       (seq)))

(defn bits->number
  {:test (fn []
           (is= (bits->number [0 0 1]) 1)
           (is= (bits->number [1 1 0]) 6)
           (is= (bits->number [1 0 0]) 4)
           (is= (bits->number [1 1 0]) 6)
           (is= (bits->number [0 0 0 0 0 0 0 0 0 0 1 1 0 1 1]) 27))}
  [bits]
  (->> bits
       (reverse)
       (map-indexed (fn [i b]
                      (if (= b 1)
                        (math/expt 2 i)
                        0)))
       (reduce + 0)))
