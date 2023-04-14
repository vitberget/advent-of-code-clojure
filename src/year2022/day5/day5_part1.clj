(ns year2022.day5.day5-part1
  (:require
    [clojure.string :as str]
    [utils.text :as ut]
    [year2022.day5.day5-data :refer [day5-example day5-puzzle]]
    [ysera.test :refer [is=]]))

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
    (into [] (for [i (range no-of-stacks)]
               (let [x (inc (* i 4))]
                 (->> lines
                      (map #(nth % x))
                      (filter #(not (= % \space)))))))))

(defn text->moves
  {:test (fn []
           (is= (text->moves "move 1 from 2 to 1\nmove 3 from 1 to 3\nmove 2 from 2 to 1\nmove 1 from 1 to 2")
                [[1 2 1]
                 [3 1 3]
                 [2 2 1]
                 [1 1 2]])
           (is= (text->moves "move 3 from 2 to 9\nmove 1 from 1 to 6\nmove 6 from 6 to 7\nmove 13 from 7 to 6")
                [[3 2 9]
                 [1 1 6]
                 [6 6 7]
                 [13 7 6]]))}
  [text]
  (->> text
       (ut/text->lines)
       (map #(str/split % #"\s+"))
       (map (fn [[_ n1 _ n2 _ n3]] [n1 n2 n3]))
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

(defn move-stacks
  {:test (fn []
           (let [step-1 [(list \N \Z)
                         (list \D \C \M)
                         (list \P)]
                 step-2 [(list \D \N \Z)
                         (list \C \M)
                         (list \P)]
                 step-3 [(list)
                         (list \C \M)
                         (list \Z \N \D \P)]]
             (is= (move-stacks step-1 [1 2 1]) step-2)
             (is= (move-stacks step-2 [3 1 3]) step-3)))}
  [stacks [size from to]]
  (let [from (dec from)
        to (dec to)]
    (loop [stacks stacks
           size size]
      (if (zero? size)
        stacks
        (recur
          (-> stacks
              (update to #(conj % (first (nth stacks from))))
              (update from #(drop 1 %)))
          (dec size))))))

(defn day5-part1
  {:test (fn []
           (is= (day5-part1 day5-example) "CMZ")
           (is= (day5-part1 day5-puzzle) "TLFGBZHCN"))}
  [text]
  (let [{stacks :stacks moves :moves} (text->state text)]
    (->> moves
         (reduce move-stacks stacks)
         (map first)
         (apply str))))

(comment
  (time (day5-part1 day5-puzzle))
  ;"Elapsed time: 23.613165 msecs"
  ;=> "TLFGBZHCN"
  )
