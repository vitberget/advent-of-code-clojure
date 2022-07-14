(ns year2021.day23.day23-part1
  (:require [ysera.test :refer [is is= is-not deftest]]
            [year2021.day23.day23-data :refer [day23-example day23-puzzle]]
            [clojure.string :as str]))

(def target-x {:A 3
               :B 5
               :C 7
               :D 9})

(defn text->state
  {:test (fn []
           (is= (text->state day23-example)
                {:A      #{[3 2] [9 2]}
                 :B      #{[3 1] [7 1]}
                 :C      #{[5 1] [7 2]}
                 :D      #{[5 2] [9 1]}
                 :energy 0}))}
  [text]
  (-> (->> text
           (str/split-lines)
           (drop 2)
           (take 2)
           (map (fn [line]
                  (->> line
                       (filter (fn [c] (contains? #{\A \B \C \D} c))))))
           (map-indexed (fn [y line] (let [y (inc y)]
                                       (->> line
                                            (map-indexed (fn [x c]
                                                           (let [x (-> x (* 2) (+ 3))]
                                                             [(keyword (str c)) x y])))))))
           (apply concat)
           (reduce (fn [acc [c x y]]
                     (update acc c (fn [e]
                                     (if (nil? e)
                                       #{[x y]}
                                       (conj e [x y])))))
                   {}))
      (assoc :energy 0)))

(defn day23-part1
  {:test (fn []
           (is= (day23-part1 day23-example) 12521))}
  [text]
  )


(comment
  (time (day23-part1 day23-puzzle))
  ;
  ;
  )
