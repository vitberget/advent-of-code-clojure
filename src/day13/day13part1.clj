(ns day13.day13part1
  (:require [ysera.test :refer [is is= is-not]]
            [clojure.string :as str]))


(defn string->note
  {:test (fn []
           (is= (string->note (str "939\n"
                                   "7,13,x,x,59,x,31,19"))
                {:earliest 939
                 :busses   (list 7 13 59 31 19)})
           )}
  [string]
  (let [[earliest busses] (str/split string #"\n")]
    {:earliest (read-string earliest)
     :busses   (->> busses
                    (re-seq #"\d+")
                    (map read-string))}))

(defn minutes-past
  {:test (fn []
           (is= (minutes-past 939 59)
                5))}
  [earliest bus-id]
  (-> (/ earliest bus-id)
      (int)
      (inc)
      (* bus-id)
      (- earliest)))

(defn day13part1
  {:test (fn[]
           (is= (day13part1 (str "939\n"
                                "7,13,x,x,59,x,31,19"))
                (* 5 59)))}
  [string]
  (let [{earliest :earliest busses :busses} (string->note string)]
    (->> busses
         (map (fn[bid] [bid (minutes-past earliest bid)]))
         (sort (fn[a b] (< (second a) (second b))))
         (first)
         (reduce *))))










(comment

              )
  )