(ns year2021.day6.day6-part2
  (:require [ysera.test :refer [is is= is-not deftest]]
            [year2021.day6.day6-data :refer [day6-example day6-puzzle]]
            [clojure.string :as str]))

(defn text->state
  {:test (fn []
           (is= (text->state "3,4,3,1,2")
                {:0 0
                 :1 1
                 :2 1
                 :3 2
                 :4 1
                 :5 0
                 :6 0
                 :7 0
                 :8 0}))}
  [text]
  (let [numbers (as-> text $
                      (str/split $ #",")
                      (map read-string $))]
    (reduce (fn [the-map number]
              (update the-map
                      (keyword (str number))
                      inc))
            {:0 0 :1 0 :2 0 :3 0 :4 0 :5 0 :6 0 :7 0 :8 0}
            numbers)))

(defn one-day
  {:test (fn []
           (is= (one-day (text->state "3,4,3,1,2"))
                (text->state "2,3,2,0,1"))
           (is= (one-day (text->state "1,2,1,6,0,8"))
                (text->state "0,1,0,5,6,7,8")))}
  [state]
  {:0 (:1 state)
   :1 (:2 state)
   :2 (:3 state)
   :3 (:4 state)
   :4 (:5 state)
   :5 (:6 state)
   :6 (+ (:7 state) (:0 state))
   :7 (:8 state)
   :8 (:0 state)})

(defn day6-part2
  {:test (fn []
           (is= (day6-part2 day6-example) 26984457539))}
  [text]
  (->> (reduce (fn [a _] (one-day a))
               (text->state text)
               (range 256))
       (vals)
       (reduce +)))

(comment
  (time (day6-part2 day6-puzzle))
  ;"Elapsed time: 3.059869 msecs"
  ;=> 1592918715629
  )