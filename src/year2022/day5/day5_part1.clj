(ns year2022.day5.day5-part1
  (:require
    [utils.text :as ut]
    [ysera.test :refer [is is= is-not deftest]]
    [year2022.day5.day5-data :refer [day5-example day5-puzzle]]
    [clojure.string :as str]))

(defn text->stacks
  {:test (fn []
           (is= (text->stacks "    [D]    \n[N] [C]    \n[Z] [M] [P]\n 1   2   3 ")
                [(list \N \Z)
                 (list \D \C \M)
                 (list \P)]))}
  [text]
  (let [lines (ut/text->lines text)
        no-of-stacks (->> lines
                          (last)
                          (ut/split-on #" ")
                          (last)
                          (read-string))
        lines (drop-last lines)]
    (for [i (range no-of-stacks)]
      (let [x (inc (* i 4))]
        (->> lines
             (map #(nth % x))
             (filter #(not (= % \space))))))))

(defn text->moves
  {:test (fn []
           (is= (text->moves "move 1 from 2 to 1\nmove 3 from 1 to 3\nmove 2 from 2 to 1\nmove 1 from 1 to 2")
                [[1 2 1]
                 [3 1 3]
                 [2 2 1]
                 [1 1 2]]))}
  [text]
  (->> text
       (ut/text->lines)
       (map #(re-matches #".*([0-9]+).*([0-9]+).*([0-9]+).*" %))
       (map #(drop 1 %))
       (map #(map read-string %))))

(defn text->state
  {:test (fn []
           (is= (text->state day5-example)
                {:stacks [(list \N \Z)
                          (list \D \C \M)
                          (list \P)]
                 :moves  [[1 2 1]
                          [3 1 3]
                          [2 2 1]
                          [1 1 2]]}))}
  [text]
  (let [[stack-text moves-text] (ut/text->paragraphs text)]
    {:stacks (text->stacks stack-text)
     :moves  (text->moves moves-text)}))


(defn day5-part1
  {:test (fn []
           (is= (day5-part1 day5-example) "CMZ"))}
  [text]
  )

(comment
  (time (day5-part1 day5-puzzle))
  ;
  )
