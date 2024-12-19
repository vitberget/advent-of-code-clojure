(ns year2024.day19.day19-part2
  (:require [ysera.test :refer [is is= is-not deftest]]
            [year2024.day19.day19-part1 :as part-1]
            [year2024.day19.day19-data :refer [day19-example day19-puzzle]]
            [clojure.string :as str]))

(def memo (memoize 
            (fn [patterns desired]
              (if (empty? desired) 
                1 
                (->> patterns
                     (filter (fn[pattern] (str/starts-with? desired pattern)))
                     (map (fn[pattern] (subs desired (count pattern))))
                     (map (fn[item] (memo patterns item)))
                     (reduce +))))))

(defn count-possible-patterns
  {:test (fn[]
           (let [{available :available} (part-1/text->towel-data day19-example)]
             (is= (count-possible-patterns available "brwrr") 2)
             (is= (count-possible-patterns available "bggr") 1)
             (is= (count-possible-patterns available "gbbr") 4)
             (is= (count-possible-patterns available "rrbgbr") 6)
             (is= (count-possible-patterns available "ubwu") 0)
             (is= (count-possible-patterns available "bwurrg") 1)
             (is= (count-possible-patterns available "brgr") 2)
             (is= (count-possible-patterns available "bbrgwb") 0)))}
  [available desired]
  (memo available desired))

(def memo-count 
  (memoize count-possible-patterns))

(defn day19-part2
  {:test (fn [] (is= (day19-part2 day19-example) 16))}
  [text]
  (let [{available :available desired :desired} (part-1/text->towel-data text)]
    (->> desired
         (map (fn[desired] (memo-count available desired)))
         (reduce +))))


(comment
  (time (day19-part2 day19-puzzle))
; (out) "Elapsed time: 4.196325 msecs"
; 643685981770598
  )
