(ns year2021.day19.day19-part1
  (:require [ysera.test :refer [is is= is-not deftest]]
            [year2021.day19.day19-data :refer [day19-example day19-puzzle]]
            [year2021.day19.day19-rotations :refer [rotations rotate-scanner]]
            [clojure.string :as str]))

(defn text->scanner
  [text]
  (->> text
       (str/split-lines)
       (drop 1)
       (map (fn [line]
              (->> (str/split line #",")
                   (map read-string)
                   (vec))))
       (into #{})))

(defn text->scanners
  [text]
  (->> (str/split text #"\n\n")
       (map text->scanner)))

(def diff-list
  (memoize (fn
             [scanner-a scanner-b pos]
             (let [list-a (->> scanner-a
                               (map #(nth % pos))
                               (distinct))
                   list-b (->> scanner-b
                               (map #(nth % pos))
                               (distinct))
                   ]
               (->> (for [n-a list-a
                          n-b list-b]
                      (- n-a n-b))
                    (distinct))))))


(def align-scanner-scanner-x
  (memoize
    (fn
      [scanner-a scanner-b x-diffs]
      (let [set-a (->> scanner-a
                       (map (fn [[x _ _]] x))
                       (into #{}))
            list-b (->> scanner-b
                        (map (fn [[x _ _]] x)))]
        (loop [aligned-xs (list)
               [xd & x-diffs] x-diffs]
          (if (nil? xd)
            aligned-xs
            (let [cnt (->> list-b
                           (map #(+ % xd))
                           (filter #(contains? set-a %))
                           (count))]
              (if (>= cnt 12)
                (recur (conj aligned-xs xd)
                       x-diffs)
                (recur aligned-xs
                       x-diffs)))))))))

(def align-scanner-scanner-xy
  (memoize
    (fn [scanner-a scanner-b x-diff y-diffs]
      (let [set-a (->> scanner-a
                       (map (fn [[x y _]] [x y]))
                       (into #{}))
            list-b (->> scanner-b
                        (map (fn [[x y _]] [(+ x x-diff) y])))]
        (loop [aligned-xys (list)
               [yd & y-diffs] y-diffs]
          (if (nil? yd)
            aligned-xys
            (let [cnt (->> list-b
                           (map (fn [[x y]] [x (+ y yd)]))
                           (filter #(contains? set-a %))
                           (count))]
              (if (>= cnt 12)
                (recur (conj aligned-xys [x-diff yd])
                       y-diffs)
                (recur aligned-xys
                       y-diffs)))))))))

(def align-scanner-scanner-xyz
  (memoize
    (fn [scanner-a scanner-b x-diff y-diff z-diffs]
      (let [set-a scanner-a
            list-b (->> scanner-b
                        (map (fn [[x y z]] [(+ x x-diff) (+ y y-diff) z])))]
        (loop [aligned-xyzs (list)
               [zd & z-diffs] z-diffs]
          (if (nil? zd)
            aligned-xyzs
            (let [cnt (->> list-b
                           (map (fn [[x y z]] [x y (+ z zd)]))
                           (filter #(contains? set-a %))
                           (count))]
              (if (>= cnt 12)
                (recur (conj aligned-xyzs [x-diff y-diff zd])
                       z-diffs)
                (recur aligned-xyzs
                       z-diffs)))))))))

(defn empty->nil
  [coll]
  (if (empty? coll) nil coll))

(defn align-scanner-scanner
  [scanner-a scanner-b]
  (let [x-diffs (diff-list scanner-a scanner-b 0)
        y-diffs (diff-list scanner-a scanner-b 1)
        z-diffs (diff-list scanner-a scanner-b 2)]
    (when-let [x-ses (->> (align-scanner-scanner-x scanner-a scanner-b x-diffs)
                          (empty->nil))]
      (when-let [xy-ses (->> (for [x x-ses] (align-scanner-scanner-xy scanner-a scanner-b x y-diffs))
                             (apply concat)
                             (empty->nil))]
        (let [xyz-ses (->> (for [[x y] xy-ses] (align-scanner-scanner-xyz scanner-a scanner-b x y z-diffs))
                           (apply concat)
                           (empty->nil))]
          (first xyz-ses))))))

(defn rotate-align-scanner-scanner
  [scanner-a scanner-b]
  (loop [[rotation & rotations] rotations]
    (if (nil? rotation)
      nil
      (let [rotated-scanner-b (rotate-scanner scanner-b rotation)]
        (if-let [[dx dy dz] (align-scanner-scanner scanner-a rotated-scanner-b)]
          (->> rotated-scanner-b
               (map (fn [[px py pz]] [(+ px dx) (+ py dy) (+ pz dz)]))
               (into #{}))
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
         unaligned (drop 1 scanners)
         [cur & other] (drop 1 scanners)]
    (cond
      (empty? unaligned)
      aligned-with-0

      (nil? cur)
      "wtf!!!"

      :else
      (if-let [aligned (align-scanner-inner cur aligned-with-0)]
        (let [unaligned (remove #(= % cur) unaligned)]
          (recur (conj aligned-with-0 aligned)
                 unaligned
                 unaligned))
        (recur aligned-with-0
               unaligned
               other)))))

(defn day19-part1
  {:test (fn []
           (is= (day19-part1 day19-example) 79))}
  [text]
  (->> text
       (text->scanners)
       (align-scanners)
       (mapcat #(into (list) %))
       (concat)
       (distinct)
       (count)))


(comment
  (time (day19-part1 day19-puzzle))
  ;"Elapsed time: 71448.52257 msecs"
  ;=> 462
  )
