(ns year2024.day23.day23-part2
  (:require [ysera.test :refer [is=]]
            [year2024.day23.day23-part1 :as part-1]
            [year2024.day23.day23-data :refer [day23-example day23-puzzle]]
            [clojure.string :as str]
            [clojure.set :as set]))


(defn grow-it
  [network directional]
  (->> network
       (map (fn[computer] (get directional computer)))
       (apply set/intersection)
       (map (fn[p] (conj network p)))))

(defn grow-until-only-one
  [threes directional]
  (loop [working threes]
    (cond  
      (empty? working) "WTF"
      (= (count working) 1) working
      :else
      (recur (->> working
                  (mapcat (fn[w] (grow-it w directional)))
                  (into #{}))))))


(defn day23-part2
  {:test (fn [] (is= (day23-part2 day23-example) "co,de,ka,ta"))}
  [text]
  (let [directional (->> text
                         (part-1/text->connections)
                         (part-1/connections->directional))
        sets-of-three (->> directional
                           (keys)
                           (map (fn [t] [t (get directional t)]))
                           (mapcat (fn [[t computers]] (part-1/contains-links? t computers directional)))
                           (into #{}))]
    (->> (grow-until-only-one sets-of-three directional)
         (first)
         (sort)
         (str/join ","))))

(comment
  (time (day23-part2 day23-puzzle))
  ; (out) "Elapsed time: 4116.524642 msecs"
  ; "gt,ha,ir,jn,jq,kb,lr,lt,nl,oj,pp,qh,vy"
  )
