(ns year2024.day13.day13-part1
  (:require [ysera.test :refer [is=]]
            [year2024.day13.day13-data :refer [day13-example day13-puzzle]]
            [utils.text :as ut]
            [clojure.edn :as edn]))

(defn line->button-or-prize [text drop-amount]
  (->> text
       (ut/split-on #": ")
       (second)
       (ut/split-on #", ")
       (mapv (fn[word] (->> word
                            (drop drop-amount)
                            (apply str)
                            (edn/read-string))))))

(defn paragraph->machine [paragraph]
  (let [[button-a-line button-b-line prize-line] (ut/text->lines paragraph) ]
    {:button-a (line->button-or-prize button-a-line 1)
     :button-b (line->button-or-prize button-b-line 1)
     :prize (line->button-or-prize prize-line 2)}))

(defn text->arcade
  [text]
  (->> text
       (ut/text->paragraphs)
       (map paragraph->machine)))

(defn machine->cheapest-win 
  {:test (fn []
           (let [machines (text->arcade day13-example)]
             (is= (machine->cheapest-win (nth machines 0)) [80 40]) 
             (is= (machine->cheapest-win (nth machines 1)) nil) 
             (is= (machine->cheapest-win (nth machines 2)) [38 86]) 
             (is= (machine->cheapest-win (nth machines 3)) nil)))}
  [{[ax ay] :button-a [bx by] :button-b [px py] :prize}]
  (let [m (/ (- (* ax py) (* ay px))
             (- (* ax by) (* ay bx)))]
    (when (integer? m)
      (let [n (/ (- px (* m bx))
                 ax)]
        (when (integer? n)
          [n m])))))

(defn day13-part1
  {:test (fn []
           (is= (day13-part1 day13-example) 480))}
  [text]
  (->> text
       (text->arcade)
       (map machine->cheapest-win)
       (filter identity)
       (map (fn [[a b]] (+ (* 3 a) b)))
       (reduce +)))

(comment
  (time (day13-part1 day13-puzzle))
  ; (out) "Elapsed time: 5.350573 msecs"
  ; 26599
  )
