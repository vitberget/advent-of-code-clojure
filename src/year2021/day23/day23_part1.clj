(ns year2021.day23.day23-part1
  (:require [ysera.test :refer [is is= is-not deftest]]
            [year2021.day23.day23-data :refer [day23-example day23-puzzle]]
            [clojure.string :as str]
            [clojure.set :as set]))

(def target-x {:A 2
               :B 4
               :C 6
               :D 8})

(def valid-post-line-0-x
  (set/difference (->> (range 11)
                       (into #{}))
                  (->> target-x
                       (vals)
                       (into #{}))))

(def valid-post-line-0-pos
  (->> valid-post-line-0-x
       (map (fn [x] [x 0]))
       (into #{})))

(defn complete?
  {:test (fn []
           (is-not (complete? {:A #{[2 2] [8 2]}
                               :B #{[2 1] [6 1]}
                               :C #{[4 1] [6 2]}
                               :D #{[4 2] [8 1]}}))
           (is (complete? {:A #{[2 2] [2 1]}
                           :B #{[4 1] [4 2]}
                           :C #{[6 1] [6 2]}
                           :D #{[8 2] [8 1]}})))}
  [state]
  (->> state
       (map (fn [[c posses]]
              (let [tx (get target-x c)]
                (and (contains? posses [tx 1])
                     (contains? posses [tx 2])))))
       (reduce (fn [a b] (and a b)))))

(defn text->state
  {:test (fn []
           (is= (text->state day23-example)
                {:A #{[2 2] [8 2]}
                 :B #{[2 1] [6 1]}
                 :C #{[4 1] [6 2]}
                 :D #{[4 2] [8 1]}}))}
  [text]
  (->> text
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
               {})))

(defn possible-moves
  {:test (fn []
           (is= (possible-moves :A [2 2] {})
                #{})
           (is= (possible-moves :A [2 1] {:A #{[2 2] [2 1]}})
                #{})
           (is= (possible-moves :A [0 0] {:C #{[6 2]}
                                          :D #{[8 2]}})
                #{[2 2]})
           (is= (possible-moves :A [0 0] {:C #{[2 2]}
                                          :D #{[8 2]}})
                #{})
           (is= (possible-moves :A [0 0] {:A #{[2 2]}
                                          :C #{[6 2]}
                                          :D #{[8 2]}})
                #{[2 1]})
           (is= (possible-moves :A [0 0] {:A #{[2 2]}
                                          :C #{[2 1]}
                                          :D #{[8 2]}})
                #{})
           (is= (possible-moves :A [2 1] {})
                valid-post-line-0-pos)
           (is= (possible-moves :A [2 1] {:C #{[3 0]}})
                #{[0 0] [1 0]})
           (is= (possible-moves :A [2 1] {:C #{[3 0] [0 0]}})
                #{[1 0]})
           (is= (possible-moves :A [8 1] {:C #{[10 0] [7 0]}})
                #{[9 0]})

           (is= (possible-moves :B [2 2] {})
                valid-post-line-0-pos)
           (is= (possible-moves :B [2 2] {:C #{[3 0]}})
                #{[0 0] [1 0]})
           (is= (possible-moves :B [2 2] {:C #{[3 0] [0 0]}})
                #{[1 0]})
           (is= (possible-moves :B [8 2] {:C #{[10 0] [7 0]}})
                #{[9 0]})

           (is= (possible-moves :B [2 2] {:A #{[2 1]}})
                #{})
           (is= (possible-moves :B [2 2] {:A #{[2 1]}
                                          :C #{[3 0]}})
                #{})
           (is= (possible-moves :B [2 2] {:A #{[2 1]}
                                          :C #{[3 0] [0 0]}})
                #{})
           (is= (possible-moves :B [8 2] {:A #{[8 1]}
                                          :C #{[10 0] [7 0]}})
                #{})
           )}
  [type [x y] state]
  (let [tx (get target-x type)
        all-vals (as-> state $
                       (vals $)
                       (apply set/union $))
        line-0-vals (->> all-vals
                         (filter (fn [[_ y]] (= y 0)))
                         (into #{}))
        type-vals (get state type)
        not-type-vals (as-> state $
                            (dissoc $ type)
                            (vals $)
                            (apply set/union $))]
    (println {:all-vals      all-vals
              :type-vals     type-vals
              :not-type-vals not-type-vals
              :line-0-vals   line-0-vals})
    (cond
      (and (= x tx)
           (= y 2))
      #{}

      (and (= x tx)
           (= y 1)
           (contains? type-vals [tx 2]))
      #{}

      (and (= y 0)
           (not (contains? all-vals [tx 2]))
           (not (contains? all-vals [tx 1])))
      #{[tx 2]}

      (and (= y 0)
           (contains? type-vals [tx 2])
           (not (contains? all-vals [tx 1])))
      #{[tx 1]}

      (or (= y 1)
          (and (= y 2)
               (not (contains? all-vals [x 1]))))
      (->> valid-post-line-0-pos
           (remove (fn [pos]
                     (contains? line-0-vals pos)))
           (remove (fn [[tx _]]
                     (->> line-0-vals
                          (filter (fn [[px _]]
                                    (or (< x px tx)
                                        (> x px tx))
                                    ))
                          (not-empty))))
           (into #{}))

      :else
      #{})))

(defn day23-part1
  {:test (fn []
           ;(is= (day23-part1 day23-example) 12521)
           )}
  [text]
  )


(comment
  (time (day23-part1 day23-puzzle))
  ;
  ;
  )
