(ns year2020.day21.day21part1
  (:require [ysera.test :refer [is is= is-not]]
            [clojure.string :as str]
            [clojure.set :as set]
            [year2020.day21.common :refer [string->state example-text puzzle allergen-words]]))

(defn unpossible-allergens-ingredients
  {:test (fn []
           (is= (unpossible-allergens-ingredients (string->state example-text))
                #{"kfcds" "nhms" "sbzzf" "trh"}))}
  [state]
  (let [allergen-words (->> state
                            (allergen-words)
                            (map second)
                            (apply set/union))]
    (->> state
         (map first)
         (apply set/union)
         (filter (fn [w] (not (contains? allergen-words w))))
         (into #{}))))

(defn score-part1
  {:test (fn []
           (is= (score-part1 (string->state example-text) #{"kfcds" "nhms" "sbzzf" "trh"})
                5))}
  [state words]
  (->> state
       (map first)
       (map (fn [is] (set/intersection is words)))
       (map count)
       (reduce +)))

(defn day21part1
  {:test (fn []
           (is= (day21part1 example-text) 5))}
  [string]
  (let [state (string->state string)
        unpossible-allergens (unpossible-allergens-ingredients state)]
    (score-part1 state unpossible-allergens)))

(comment
  (time (day21part1 puzzle))
  ;"Elapsed time: 5.73496 msecs"
  ;=> 1930
  )