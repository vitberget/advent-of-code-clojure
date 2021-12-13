(ns year2021.day13.day13-part1
  (:require [ysera.test :refer [is is= is-not deftest]]
            [year2021.day13.day13-data :refer [day13-example day13-puzzle]]
            [clojure.string :as str]
            [clojure.set :as set]))

(defn text->paper
  {:test (fn []
           (is= (text->paper day13-example)
                {:dots  #{[6 10]
                          [0 14]
                          [9 10]
                          [0 3]
                          [10 4]
                          [4 11]
                          [6 0]
                          [6 12]
                          [4 1]
                          [0 13]
                          [10 12]
                          [3 4]
                          [3 0]
                          [8 4]
                          [1 10]
                          [2 14]
                          [8 10]
                          [9 0]}
                 :folds [[:y 7] [:x 5]]}))}
  [text]
  (reduce (fn [paper line]
            (cond
              (str/blank? line)
              paper

              (str/starts-with? line "fold along ")
              (let [[dir-str num-str] (as-> line $
                                            (subs $ (count "fold along "))
                                            (str/split $ #"="))]
                (update paper :folds conj [(keyword dir-str) (read-string num-str)]))

              :else
              (update paper :dots conj (as-> line $
                                             (str/split $ #",")
                                             (map read-string $)
                                             (vec $)))

              ))
          {:dots #{} :folds []}
          (str/split-lines text)))

(defn fold-number
  [number [_ fold]]
  (if (< number fold)
    number
    (- fold number (- fold))))

(defn fold-paper
  [{dots :dots :as paper}
   [f-direction f-number :as fold]]
  (let [fold-dots (->> dots
                       (filter (fn [[x y]]
                                 (> (if (= :x f-direction) x y)
                                    f-number)))
                       (into #{}))
        paper (assoc paper :dots (set/difference dots fold-dots))]
    (reduce (fn [paper [fx fy :as prepos]]
              (let [position (if (= :x f-direction)
                               [(fold-number fx fold) fy]
                               [fx (fold-number fy fold)])]
                (update paper :dots conj position)))
            paper
            fold-dots)))

(defn day13-part1
  {:test (fn []
           (is= (day13-part1 day13-example) 17)
           (is= (day13-part1 day13-puzzle) 802))}
  [text]
  (as-> text $
        (text->paper $)
        (reduce fold-paper
                $
                (take 1 (:folds $)))
        (:dots $)
        (count $)))

(comment
  (time (day13-part1 day13-puzzle))
  ;"Elapsed time: 24.106993 msecs"
  ;=> 802
  )
