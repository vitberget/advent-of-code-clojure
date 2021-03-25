(ns year2020.day21.day21part2
  (:require [ysera.test :refer [is is= is-not]]
            [clojure.string :as str]
            [clojure.set :as set]
            [year2020.day21.common :refer [string->state example-text puzzle allergen-words]]))


(defn unique-allergens
  {:test (fn []
           (is= (unique-allergens [["dairy" #{"mxmxvkd"}]
                                   ["soy" #{"sqjhc" "fvjkl"}]
                                   ["fish" #{"sqjhc" "mxmxvkd"}]])
                {"dairy" "mxmxvkd"
                 "soy"   "fvjkl"
                 "fish"  "sqjhc"}))}
  [allergen-words]
  (loop [aw-map (->> allergen-words
                     (map (fn [[p1 p2]] {p1 p2}))
                     (reduce merge))]
    (let [mores (->> aw-map
                     (filter (fn [[_ val]] (> (count val) 1))))]
      (if (empty? mores)
        (->> aw-map
             (map (fn [[k v]] [k (first v)]))
             (into {}))
        (let [mores-keys (->> mores
                              (map first)
                              (into #{}))
              one-words (->> aw-map
                             (map second)
                             (filter (fn [s] (= 1 (count s))))
                             (apply set/union))
              new-ones (->> aw-map
                            (filter (fn [[k _]] (contains? mores-keys k)))
                            (map (fn [[key value]]
                                   [key (->> value
                                             (filter (fn [v]
                                                       (not (contains? one-words v)))))]))
                            (filter (fn [[_ value]] (= 1 (count value))))
                            (map (fn [[key value]] [key (into #{} value)]))
                            (into {}))]
          (recur (merge aw-map new-ones)))))))

(defn day21part2
  {:test (fn []
           (is= (day21part2 example-text)
                "mxmxvkd,sqjhc,fvjkl"))}
  [string]
  (->> string
       (string->state)
       (allergen-words)
       (unique-allergens)
       (sort (fn [[k1 _] [k2 _]] (.compareTo k1 k2)))
       (map second)
       (str/join ",")))

(comment
    (time (day21part2 puzzle))
  ;"Elapsed time: 2.72934 msecs"
  ;=> "spcqmzfg,rpf,dzqlq,pflk,bltrbvz,xbdh,spql,bltzkxx"
  )