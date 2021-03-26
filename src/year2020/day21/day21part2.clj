(ns year2020.day21.day21part2
  (:require [ysera.test :refer [is is= is-not]]
            [clojure.string :as str]
            [clojure.set :as set]
            [year2020.day21.common :refer [string->state example-text puzzle allergen-words]]))

(defn unique-allergens
  {:test (fn []
           (is= (unique-allergens {"dairy" #{"mxmxvkd"}
                                   "soy"   #{"sqjhc" "fvjkl"}
                                   "fish"  #{"sqjhc" "mxmxvkd"}})
                {"dairy" "mxmxvkd"
                 "soy"   "fvjkl"
                 "fish"  "sqjhc"}))}
  [allergen-words]
  (loop [allergen-words allergen-words]
    (let [mores (filter (fn [[_ val]] (> (count val) 1)) allergen-words)]
      (if (empty? mores)
        (->> allergen-words
             (map (fn [[k v]] [k (first v)]))
             (into {}))
        (let [mores-keys (->> mores
                              (map first)
                              (into #{}))
              one-words (->> allergen-words
                             (map second)
                             (filter (fn [s] (= 1 (count s))))
                             (apply set/union))
              new-ones (->> allergen-words
                            (filter (fn [[k _]] (contains? mores-keys k)))
                            (map (fn [[key value]] [key (set/difference value one-words)]))
                            (filter (fn [[_ value]] (= 1 (count value))))
                            (into {}))]
          (recur (merge allergen-words new-ones)))))))

(defn day21part2
  {:test (fn []
           (is= (day21part2 example-text)
                "mxmxvkd,sqjhc,fvjkl"))}
  [string]
  (->> string
       (string->state)
       (allergen-words)
       (unique-allergens)
       (into (sorted-map))
       (map second)
       (str/join ",")))

(comment
  (time (day21part2 puzzle))
  ;"Elapsed time: 2.72934 msecs"
  ;=> "spcqmzfg,rpf,dzqlq,pflk,bltrbvz,xbdh,spql,bltzkxx"
  )