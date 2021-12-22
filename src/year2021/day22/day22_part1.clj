(ns year2021.day22.day22-part1
  (:require [ysera.test :refer [is is= is-not deftest]]
            [year2021.day22.day22-data :refer [day22-example-1 day22-example-2 day22-puzzle]]
            [clojure.string :as str]
            [clojure.pprint :as pp]
            [clojure.set :as set]))

(defn line->step
  {:test
   (fn []
     (is= (line->step "on x=-10..12,y=11..13,z=-100..120")
          {:operator :on
           :x        [-10 12]
           :y        [11 13]
           :z        [-100 120]}))}
  [line]
  (let [[_ op x1 x2 y1 y2 z1 z2] (->> line
                                      (re-seq #"([onf]+) x=(\-?[0-9]+)\.\.(\-?[0-9]+),y=(\-?[0-9]+)\.\.(\-?[0-9]+),z=(\-?[0-9]+)\.\.(\-?[0-9]+)")
                                      (first))]
    {:operator (keyword op)
     :x        [(read-string x1) (read-string x2)]
     :y        [(read-string y1) (read-string y2)]
     :z        [(read-string z1) (read-string z2)]}))

(defn text->steps
  [text]
  (->> text
       (str/split-lines)
       (map line->step)))

(defn step-inside-50?
  [{[x1 x2] :x [y1 y2] :y [z1 z2] :z}]
  (and (or (< x1 50)
           (> x2 -50))
       (or (< y1 50)
           (> y2 -50))
       (or (< z1 50)
           (> z2 -50))))

(defn add-set-to-step
  [{[x1 x2] :x [y1 y2] :y [z1 z2] :z :as step}]
  (assoc step :set
              (->> (for [x (range (max x1 -50) (inc (min x2 50)))
                         y (range (max y1 -50) (inc (min y2 50)))
                         z (range (max z1 -50) (inc (min z2 50)))]
                     [x y z])
                   (into #{}))))

(defn day22-part1
  {:test (fn []
           (is= (day22-part1 day22-example-1) 39)
           (is= (day22-part1 day22-example-2) 590784)
           )}
  [text]
  (->> text
       (text->steps)
       (filter step-inside-50?)
       (map add-set-to-step)
       (reduce (fn [the-set {operator :operator cur-set :set}]
                 (if (= :on operator)
                   (set/union the-set cur-set)
                   (set/difference the-set cur-set)))
               #{})
       (count)))

(comment
  (time (day22-part1 day22-puzzle))
  ;"Elapsed time: 1096.597691 msecs"
  ;=> 607573
  )
