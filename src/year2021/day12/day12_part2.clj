(ns year2021.day12.day12-part2
  (:require [ysera.test :refer [is is= is-not deftest]]
            [year2021.day12.day12-data :refer [day12-example-1
                                               day12-example-2
                                               day12-example-3
                                               day12-puzzle]]
            [year2021.day12.day12-part1 :as part1]
            [clojure.set :as set]))

(defn path-is-ok-lowercase-cave?
  {:test (fn []
           (is (path-is-ok-lowercase-cave? ["begin" "a"] "a"))
           (is (path-is-ok-lowercase-cave? ["begin" "a" "b"] "a"))
           (is (path-is-ok-lowercase-cave? ["start" "b" "d"] "b"))
           (is (path-is-ok-lowercase-cave? ["begin" "a" "Z" "Y" "b"] "a"))
           (is (path-is-ok-lowercase-cave? ["begin" "b" "b"] "a"))
           (is-not (path-is-ok-lowercase-cave? ["begin" "b" "b"] "b"))
           (is-not (path-is-ok-lowercase-cave? ["begin" "b" "b" "a"] "a")))}
  [path cave]
  (let [freq-vals (as-> path $
                        (conj $ cave)
                        (filter part1/lower-case? $)
                        (frequencies $)
                        (vals $)
                        (sort > $))
        [num1 num2] freq-vals]
    (and (not (> num1 2))
         (or (nil? num2)
             (= 1 num2)))))

(defn cave-system->paths
  {:test (fn []
           (is= (cave-system->paths (part1/text->cave-system day12-example-1))
                #{["start" "A" "b" "A" "b" "A" "c" "A" "end"]
                  ["start" "A" "b" "A" "b" "A" "end"]
                  ["start" "A" "b" "A" "b" "end"]
                  ["start" "A" "b" "A" "c" "A" "b" "A" "end"]
                  ["start" "A" "b" "A" "c" "A" "b" "end"]
                  ["start" "A" "b" "A" "c" "A" "c" "A" "end"]
                  ["start" "A" "b" "A" "c" "A" "end"]
                  ["start" "A" "b" "A" "end"]
                  ["start" "A" "b" "d" "b" "A" "c" "A" "end"]
                  ["start" "A" "b" "d" "b" "A" "end"]
                  ["start" "A" "b" "d" "b" "end"]
                  ["start" "A" "b" "end"]
                  ["start" "A" "c" "A" "b" "A" "b" "A" "end"]
                  ["start" "A" "c" "A" "b" "A" "b" "end"]
                  ["start" "A" "c" "A" "b" "A" "c" "A" "end"]
                  ["start" "A" "c" "A" "b" "A" "end"]
                  ["start" "A" "c" "A" "b" "d" "b" "A" "end"]
                  ["start" "A" "c" "A" "b" "d" "b" "end"]
                  ["start" "A" "c" "A" "b" "end"]
                  ["start" "A" "c" "A" "c" "A" "b" "A" "end"]
                  ["start" "A" "c" "A" "c" "A" "b" "end"]
                  ["start" "A" "c" "A" "c" "A" "end"]
                  ["start" "A" "c" "A" "end"]
                  ["start" "A" "end"]
                  ["start" "b" "A" "b" "A" "c" "A" "end"]
                  ["start" "b" "A" "b" "A" "end"]
                  ["start" "b" "A" "b" "end"]
                  ["start" "b" "A" "c" "A" "b" "A" "end"]
                  ["start" "b" "A" "c" "A" "b" "end"]
                  ["start" "b" "A" "c" "A" "c" "A" "end"]
                  ["start" "b" "A" "c" "A" "end"]
                  ["start" "b" "A" "end"]
                  ["start" "b" "d" "b" "A" "c" "A" "end"]
                  ["start" "b" "d" "b" "A" "end"]
                  ["start" "b" "d" "b" "end"]
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

       (and (part1/lower-case? next-cave)
            (not (path-is-ok-lowercase-cave? path next-cave)))

       (recur paths
              path
              rest-of-caves)


       :else
       (recur (set/union paths (cave-system->paths cave-system (conj path next-cave)))
              path
              rest-of-caves)))))


(defn day12-part2
  {:test (fn []
           (is= (day12-part2 day12-example-1) 36)
           (is= (day12-part2 day12-example-2) 103)
           (is= (day12-part2 day12-example-3) 3509)
           (is= (day12-part2 day12-puzzle) 4573)
           )}
  [text]
  (-> text
      (part1/text->cave-system)
      (cave-system->paths)
      (count)))

(comment
  (time (day12-part2 day12-puzzle))
  ;"Elapsed time: 5165.099621 msecs"
  ;=> 117509
  )