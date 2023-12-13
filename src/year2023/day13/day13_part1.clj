(ns year2023.day13.day13-part1
  (:require
    [utils.text :refer [text->lines text->paragraphs]]
    [year2023.day13.day13-data :refer [day13-example day13-puzzle]]
    [ysera.test :refer [is=]]))

(defn mirrors?
  [items pos]
  (->> (map = 
            (reverse (take pos items)) 
            (drop pos items))
       (reduce #(and %1 %2))))

(defn pattern->horizontal-score [pattern]
  (let [lines (text->lines pattern)
        line-count (count lines)]
    (loop [pos 1]
      (cond (= pos line-count) nil 
            (mirrors? lines pos) (* pos 100)
            :else (recur (inc pos))))))

(defn pattern->vertical-score [pattern]
  (let [lines (text->lines pattern)
        char-count (-> lines (first) (count))]
    (loop [pos 1]
      (cond (= pos char-count) 0 
            (reduce #(and %1 (mirrors? %2 pos)) true lines) pos
            :else (recur (inc pos))))))

(defn pattern->score 
  [pattern]
  (or (pattern->horizontal-score pattern)
      (pattern->vertical-score pattern)))

(defn day13-part1
  {:test (fn [] (is= (day13-part1 day13-example) 405))}
  [text]
  (->> text
       (text->paragraphs)
       (map pattern->score) 
       (apply +)))

(comment
  (time (day13-part1 day13-puzzle))
  ; (out) "Elapsed time: 2.952614 msecs"
  ; 43614
  )
