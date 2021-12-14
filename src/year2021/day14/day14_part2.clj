(ns year2021.day14.day14-part2
  (:require [ysera.test :refer [is is= is-not deftest]]
            [year2021.day14.day14-data :refer [day14-example day14-puzzle]]
            [year2021.day14.day14-part1 :as part1]
            [clojure.string :as string]
            [clojure.set :as set]))

(defn string->pair-map
  [long-string]
  (->> long-string
       (partition 2 1)
       (map #(apply str %))
       (frequencies)))

(defn do-step
  {:test (fn []
           (let [{rules :rules} (part1/text->template-and-insert-rules day14-example)
                 step-0 (string->pair-map "NNCB")
                 step-1 (string->pair-map "NCNBCHB")
                 step-2 (string->pair-map "NBCCNBBBCBHCB")
                 step-3 (string->pair-map "NBBBCNCCNBBNBNBBCHBHHBCHB")
                 step-4 (string->pair-map "NBBNBNBBCCNBCNCCNBBNBBNBBBNBBNBBCBHCBHHNHCBBCBHCB")]
             (is= (do-step step-0 rules) step-1)
             (is= (do-step step-1 rules) step-2)
             (is= (do-step step-2 rules) step-3)
             (is= (do-step step-3 rules) step-4)))}
  [incoming-pair-map rules]
  (reduce (fn [pair-map key]
            (if-let [letter (get rules key)]
              (let [count (get incoming-pair-map key)
                    w1 (str (first key) letter)
                    w2 (str letter (second key))]
                (-> pair-map
                    (update w1 (fn [v] (+ (or v 0) count)))
                    (update w2 (fn [v] (+ (or v 0) count)))))
              pair-map
              ))
          {}
          (keys incoming-pair-map)))

(defn count-map
  {:test (fn []
           (is= (count-map {"CH" 21, "HH" 32, "BH" 81, "BN" 735, "NH" 27, "NB" 796, "HB" 26, "BC" 120, "CN" 102, "CC" 60, "BB" 812, "CB" 115, "HN" 27, "HC" 76, "NC" 42})
                {\N 865 \B 1749 \C 298 \H 161}))}
  [two-map]
  (let [{first-letters  :first
         second-letters :second}
        (reduce (fn [one-map [[l1 l2] value]]
                  (-> one-map
                      (update-in [:first l1] (fn [v] (+ (or v 0) value)))
                      (update-in [:second l2] (fn [v] (+ (or v 0) value)))))
                {:first  {}
                 :second {}}
                two-map)
        letters (set/union (-> first-letters
                               (keys)
                               (into #{}))
                           (-> second-letters
                               (keys)
                               (into #{})))]
    (reduce (fn [one-map letter]
              (assoc one-map letter (max (get first-letters letter)
                                         (get second-letters letter))))
            {}
            letters)))

(defn day14-part2
  {:test (fn []
           ;part 1
           (is= (day14-part2 day14-example 10) 1588)
           ;part 2
           (is= (day14-part2 day14-example 40) 2188189693529))}
  [text rounds]
  (let [{template-string :template rules :rules} (part1/text->template-and-insert-rules text)
        pair-map (string->pair-map template-string)]
    (->> (reduce (fn [pair-map _]
                   (do-step pair-map rules))
                 pair-map
                 (range rounds))
         (count-map)
         (reduce (fn [[vmax vmin] [_ v]]
                   [(max vmax v) (min vmin v)])
                 [0 Long/MAX_VALUE])
         (apply -))))

(comment
  (time (day14-part2 day14-puzzle 40))
  ;"Elapsed time: 11.003098 msecs"
  ;=> 4704817645083
  )