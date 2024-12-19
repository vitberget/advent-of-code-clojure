(ns year2024.day19.day19-part1
  (:require [ysera.test :refer [is is= is-not]]
            [year2024.day19.day19-data :refer [day19-example day19-puzzle]]
            [clojure.string :as str]
            [utils.text :as ut]))

(defn text->towel-data
  [text]
  (let [[designs desired] (ut/text->paragraphs text)]
    {:available (->> designs
                     (ut/split-on #", " ))
     :desired (ut/text->lines desired)} ))

(defn possible-pattern?
  {:test (fn[]
           (let [{available :available} (text->towel-data day19-example)]
             (is (possible-pattern? available "brwrr"))
             (is (possible-pattern? available "bggr"))
             (is (possible-pattern? available "gbbr"))
             (is (possible-pattern? available "rrbgbr"))
             (is-not (possible-pattern? available "ubwu"))
             (is (possible-pattern? available "bwurrg"))
             (is (possible-pattern? available "brgr"))
             (is-not (possible-pattern? available "bbrgwb"))))}
  [available desired]
  (loop [test-items #{desired}]
    (cond
      (empty? test-items) false
      (contains? test-items "") true 

      :else 
      (recur (->> available
                                (mapcat (fn [pattern] (->> test-items
                                                           (filter (fn[item] (str/starts-with? item pattern)))
                                                           (map (fn[item] (subs item (count pattern)))))))
                                (into #{}))))))

(defn day19-part1
  {:test (fn []
           (is= (day19-part1 day19-example) 6))}
  [text]
  (let [{available :available desired :desired} (text->towel-data text)]
    (->> desired
         (filter (fn[desired] (possible-pattern? available desired)))
         (count))))

(comment
  (time (day19-part1 day19-puzzle))
  ; (out) "Elapsed time: 2785.911 msecs"
  ; 236
  )
