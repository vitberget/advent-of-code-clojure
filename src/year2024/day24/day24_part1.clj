(ns year2024.day24.day24-part1
  (:require [ysera.test :refer [is=]]
            [year2024.day24.day24-data :refer [day24-example-1 day24-example-2 day24-puzzle]]
            [clojure.string :as str]
            [utils.text :as ut]
            [clojure.edn :as edn]))

(defn text->inputs-and-gates 
  [text]
  (let [[input gates] (ut/text->paragraphs text)]
    {:input (->> input
                 (ut/text->lines)
                 (map (fn [line] (ut/split-on #": " line) ))
                 (map (fn [[k n]] [k (edn/read-string n)]))
                 (reduce (fn[the-map [k n]] (assoc the-map k n))
                         {}))

     :gates (->> gates
                 (ut/text->lines)
                 ; x00 AND y00 -> z00
                 (map (fn [line] (re-matches #"(.+) (.+) (.+) -> (.+)" line)))
                 (mapv (fn [items] {:left (nth items 1)
                                    :operator (nth items 2)
                                    :right (nth items 3)
                                    :target (nth items 4)})))}))

(defn run-it 
  [{input :input gates :gates}]
  (loop [input input
         [{left :left operator :operator right :right target :target :as gate} & gates] gates]
    (if (nil? gate)
      input
      (let [left (get input left)
            right (get input right)]
        (if (or (nil? left) (nil? right))
          (recur input (concat gates (list gate)))
          (recur (assoc input target (condp = operator
                                       "AND" (bit-and left right)
                                       "OR" (bit-or left right) 
                                       "XOR" (bit-xor left right)))
                 gates))))))

(defn empty-str->thing 
  [text replacement]
  (if (empty? text)
    replacement
    text))

(defn only-z-keys 
  [inputs]
  (->> inputs
       (filter (fn [[k _]] (str/starts-with? k "z")))
       (map (fn [[k n]] [(-> k 
                             (subs 1)
                             (ut/strip-leading "0")
                             (empty-str->thing "0")
                             (edn/read-string)) n])  )
       (sort (fn [[a _] [b _]] (> a b)))))

(defn to-number [inputs]
  (loop [[[idx bit] & inputs] inputs
         number 0]
    (if (nil? bit)
      number
      (recur inputs
             (-> number
                 (bit-shift-left 1)
                 (bit-or bit))))))

(defn day24-part1
  {:test (fn []
           (is= (day24-part1 day24-example-1) 4)
           (is= (day24-part1 day24-example-2) 2024))}
  [text]
  (->> text
       (text->inputs-and-gates)
       (run-it)
       (only-z-keys)
       (to-number)))

(comment
  (time (day24-part1 day24-puzzle))
  ; "Elapsed time: 42.955347 msecs"
  ; 52956035802096
  )
