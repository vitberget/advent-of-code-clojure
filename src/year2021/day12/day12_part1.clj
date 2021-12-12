(ns year2021.day12.day12-part1
  (:require [ysera.test :refer [is is= is-not deftest]]
            [ysera.collections :refer [seq-contains?]]
            [year2021.day12.day12-data :refer [day12-example-1
                                               day12-example-2
                                               day12-example-3
                                               day12-puzzle]]
            [clojure.string :as str]
            [clojure.set :as set]))

(defn inner-update-cave-system
  [cave-system key-str value-str]
  (if (or (= key-str "end")
          (= value-str "start"))
    cave-system
    (update cave-system key-str
            (fn [value-set]
              (if value-set
                (conj value-set value-str)
                #{value-str})))))

(defn pair->cave-system
  [cave-system [v1 v2]]
  (-> cave-system
      (inner-update-cave-system v1 v2)
      (inner-update-cave-system v2 v1)))

(defn text->cave-system
  {:test (fn []
           (is= (text->cave-system day12-example-1)
                {"start" #{"A" "b"}
                 "c"     #{"A"}
                 "A"     #{"end" "b" "c"}
                 "b"     #{"A" "d" "end"}
                 "d"     #{"b"}}))}
  [text]
  (->> text
       (str/split-lines)
       (map #(str/split % #"-"))
       (reduce pair->cave-system
               {})))

(defn lower-case?
  [text]
  (every? (fn [^Character x] (Character/isLowerCase x)) text))

(defn path-contains-lowercase-cave?
  {:test (fn []
           (is (path-contains-lowercase-cave? ["start" "A" "b"] "b"))
           (is (path-contains-lowercase-cave? ["start" "A" "c" "b"] "b"))
           (is-not (path-contains-lowercase-cave? ["start" "A" "B"] "z"))
           (is-not (path-contains-lowercase-cave? ["start" "A" "B"] "A")))}
  [path cave]
  (and (lower-case? cave)
       (seq-contains? path cave)))

(defn cave-system->paths
  {:test (fn []
           (is= (cave-system->paths (text->cave-system day12-example-1))
                #{["start" "A" "b" "A" "c" "A" "end"]
                  ["start" "A" "b" "A" "end"]
                  ["start" "A" "b" "end"]
                  ["start" "A" "c" "A" "b" "A" "end"]
                  ["start" "A" "c" "A" "b" "end"]
                  ["start" "A" "c" "A" "end"]
                  ["start" "A" "end"]
                  ["start" "b" "A" "c" "A" "end"]
                  ["start" "b" "A" "end"]
                  ["start" "b" "end"]}))}
  ([cave-system]
   (cave-system->paths cave-system ["start"]))
  ([cave-system path]
   (loop [paths #{}
          path path
          [next-cave & rest-of-caves] (get cave-system (last path))]
     (cond
       (nil? next-cave)
       paths

       (= next-cave "end")
       (recur (conj paths (conj path "end"))
              path
              rest-of-caves)

       (path-contains-lowercase-cave? path next-cave)
       (recur paths
              path
              rest-of-caves)

       :else
       (recur (set/union paths (cave-system->paths cave-system (conj path next-cave)))
              path
              rest-of-caves)))))


(defn day12-part1
  {:test (fn []
           (is= (day12-part1 day12-example-1) 10)
           (is= (day12-part1 day12-example-2) 19)
           (is= (day12-part1 day12-example-3) 226)
           (is= (day12-part1 day12-puzzle) 4573))}
  [text]
  (-> text
      (text->cave-system)
      (cave-system->paths)
      (count)))


(comment
  (time (day12-part1 day12-puzzle))
  ;"Elapsed time: 35.06007 msecs"
  ;=> 4573
  )
