(ns year2022.day3.day3-part1
  (:require
    [clojure.set :as set]
    [utils.text :as ut]
    [year2022.day3.day3-data :refer [day3-example day3-puzzle]]
    [ysera.test :refer [is=]]))

(defn in-both-compartments
  {:test (fn []
           (is= (in-both-compartments "vJrwpWtwJgWr" "hcsFMMfFFhFp") #{\p})
           (is= (in-both-compartments "jqHRNqRjqzjGDLGL" "rsFMfFZSrLrFZsSL") #{\L}))}
  [comp-1 comp-2]
  (set/intersection (into #{} comp-1)
                    (into #{} comp-2)))

(defn prioritize
  {:test (fn []
           (is= (prioritize #{\a}) 1)
           (is= (prioritize #{\A}) 27)
           (is= (prioritize #{\p}) 16)
           (is= (prioritize #{\L}) 38))}
  [set-of-letters]
  (let [letter (-> set-of-letters
                   (first))
        delta (if (Character/isUpperCase ^char letter)
                (- (int \A) 27)
                (- (int \a) 1))]
    (- (int letter) delta)))

(defn day3-part1
  {:test (fn []
           (is= (day3-part1 day3-example) 157)
           (is= (day3-part1 day3-puzzle) 7691))}
  [text]
  (->> text
       (ut/text->lines)
       (map ut/line->halves)
       (map #(apply in-both-compartments %))
       (map prioritize)
       (reduce +)))

(comment
  (time (day3-part1 day3-puzzle))
  ;"Elapsed time: 3.089623 msecs"
  ;=> 7691
  )
