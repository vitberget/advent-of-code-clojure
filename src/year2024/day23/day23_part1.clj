(ns year2024.day23.day23-part1
  (:require
    [utils.text :as ut]
    [year2024.day23.day23-data :refer [day23-example day23-puzzle]]
    [ysera.test :refer [is=]]
    [clojure.string :as str]
    [clojure.set :as set]))

(defn text->connections
  [text]
  (->> text
       (ut/text->lines)
       (map (fn[line]  (->> line
                            (ut/split-on #"-"))))))

(defn connections->directional
  [connections]
  (reduce (fn [directional [computer-1 computer-2]]
            (-> directional
                (update computer-1 (fn [set-of-computer] (conj (or set-of-computer #{}) computer-2)))
                (update computer-2 (fn [set-of-computer] (conj (or set-of-computer #{}) computer-1)))))
          {}
          connections))

(defn contains-links? 
  [t computers directional]
  (loop [[computer & computers] computers
         threes (list)]
    (if (nil? computer)
      threes
    (let [other-computers (into #{} computers)
          how (set/intersection (get directional computer) other-computers)
          more-threes (->> how
                           (map (fn [other] #{t computer other})))]
        (recur computers (concat threes more-threes))))))

(defn day23-part1
  {:test (fn [] (is= (day23-part1 day23-example) 7))}
  [text]
  (let [directional (->> text
                         (text->connections)
                         (connections->directional))
        t-s (->> directional
                 (keys)
                 (filter (fn[computer] (str/starts-with? computer "t"))))]
    (->> t-s
         (map (fn [t] [t (get directional t)]))
         (mapcat (fn [[t computers]] (contains-links? t computers directional)))
         (into #{})
         (count))))

(comment
  (time (day23-part1 day23-puzzle))
  ; "Elapsed time: 16.6698 msecs"
  ; 1423
  )
