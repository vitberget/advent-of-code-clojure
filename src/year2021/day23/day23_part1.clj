(ns year2021.day23.day23-part1
  (:require [ysera.test :refer [is is= is-not deftest]]
            [year2021.day23.day23-data :refer [day23-example day23-puzzle]]
            [clojure.string :as str]
            [clojure.set :as set]))

(def target-x {:A 2
               :B 4
               :C 6
               :D 8})

(def valid-post-line-0
  (set/difference (->> (range 11)
                       (into #{}))
                  (->> target-x
                       (vals)
                       (into #{}))))

(defn complete?
  {:test (fn []
           (is-not (complete? {:A      #{[2 2] [8 2]}
                               :B      #{[2 1] [6 1]}
                               :C      #{[4 1] [6 2]}
                               :D      #{[4 2] [8 1]}
                               :energy 0}))
           (is (complete? {:A      #{[2 2] [2 1]}
                           :B      #{[4 1] [4 2]}
                           :C      #{[6 1] [6 2]}
                           :D      #{[8 2] [8 1]}
                           :energy 0})))}
  [state]
  (->> (dissoc state :energy)
       (map (fn [[c posses]]
              (let [tx (get target-x c)]
                (and (contains? posses [tx 1])
                     (contains? posses [tx 2])))))
       (reduce (fn [a b] (and a b)))))

(defn text->state
  {:test (fn []
           (is= (text->state day23-example)
                {:A      #{[2 2] [8 2]}
                 :B      #{[2 1] [6 1]}
                 :C      #{[4 1] [6 2]}
                 :D      #{[4 2] [8 1]}
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
                                                           (let [x (-> x (* 2) (+ 2))]
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
