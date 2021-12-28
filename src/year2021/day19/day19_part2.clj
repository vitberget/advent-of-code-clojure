(ns year2021.day19.day19-part2
  (:require [ysera.test :refer [is is= is-not deftest]]
            [year2021.day19.day19-data :refer [day19-example day19-puzzle]]
            [year2021.day19.day19-rotations :refer [rotations rotate-scanner]]
            [year2021.day19.day19-part1 :as part1]
            [clojure.math.numeric-tower :as math]))

(defn rotate-align-scanner-scanner
  [scanner-a scanner-b]
  (loop [[rotation & rotations] rotations]
    (if (nil? rotation)
      nil
      (let [rotated-scanner-b (rotate-scanner scanner-b rotation)]
        (if-let [[dx dy dz] (part1/align-scanner-scanner scanner-a rotated-scanner-b)]
          {:scanner  (->> rotated-scanner-b
                          (map (fn [[px py pz]] [(+ px dx) (+ py dy) (+ pz dz)]))
                          (into #{}))
           :location [dx dy dz]}
          (recur rotations))))))

(defn align-scanner-inner [cur aligned-with-0]
  (loop [[scanner-a & aligned-with-0] aligned-with-0]
    (if (nil? scanner-a)
      nil
      (if-let [aligned (rotate-align-scanner-scanner scanner-a cur)]
        aligned
        (recur aligned-with-0)))))

(defn align-scanners
  [scanners]
  (loop [aligned-with-0 (take 1 scanners)
         aligned-locations (list [0 0 0])
         unaligned (drop 1 scanners)
         [cur & other] (drop 1 scanners)]
    (cond
      (empty? unaligned)
      aligned-locations

      (nil? cur)
      "wtf!!!"

      :else
      (if-let [{aligned :scanner location :location} (align-scanner-inner cur aligned-with-0)]
        (let [unaligned (remove #(= % cur) unaligned)]
          (recur (conj aligned-with-0 aligned)
                 (conj aligned-locations location)
                 unaligned
                 unaligned))
        (recur aligned-with-0
               aligned-locations
               unaligned
               other)))))

(defn into-manhattan-distances-inner
  [[x y z] locations]
  (for [[lx ly lz] locations]
    (math/abs (+ (- x lx)
                 (- y ly)
                 (- z lz)))))

(defn into-manhattan-distances
  [locations]
  (->> locations
       (map (fn [location]
              (into-manhattan-distances-inner location locations)))
       (flatten)))

(defn day19-part2
  {:test (fn []
           (is= (day19-part2 day19-example) 3621))}
  [text]
  (->> text
       (part1/text->scanners)
       (align-scanners)
       (into-manhattan-distances)
       (reduce max)))

(comment
  (time (day19-part2 day19-puzzle))
  ;"Elapsed time: 73692.466666 msecs"
  ;=> 12158
  )