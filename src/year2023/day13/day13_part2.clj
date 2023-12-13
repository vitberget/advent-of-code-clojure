(ns year2023.day13.day13-part2
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

(defn pattern->horizontal-mirror-pos [pattern]
  (let [lines (text->lines pattern)
        line-count (count lines)]
    (loop [pos 1]
      (cond (= pos line-count) nil 
            (mirrors? lines pos) pos
            :else (recur (inc pos))))))

(defn differences-in-line 
  [line-a line-b]
  (->> (map = line-a line-b)
       (remove identity) 
       (count)))

(defn differences-in-horizontal 
  [items pos]
  (->> (map differences-in-line 
            (reverse (take pos items)) 
            (drop pos items))
       (apply +)))

(defn pattern->horizontal-score [pattern]
  (let [lines (text->lines pattern)
        line-count (count lines)
        mirror-pos (pattern->horizontal-mirror-pos pattern)]
    (loop [pos 1]
      (cond 
        (>= pos line-count) nil
        (= pos mirror-pos) (recur (inc pos))
        (= 1 (differences-in-horizontal lines pos)) (* 100 pos) 
        :else (recur (inc pos))))))

(defn pattern->vertical-mirror-pos 
  [pattern]
  (let [lines (text->lines pattern)
        char-count (-> lines (first) (count))]
    (loop [pos 1]
      (cond (= pos char-count) nil 
            (reduce #(and %1 (mirrors? %2 pos)) true lines) pos
            :else (recur (inc pos))))))

(defn differences-in-vertical [lines pos]
  (->> lines
       (map (fn [line][(reverse (take pos line))(drop pos line)]))
       (map (fn [[line-a line-b]] (differences-in-line line-a line-b)))
       (apply +)))

(defn pattern->vertical-score [pattern]
  (let [lines (text->lines pattern)
        char-count (-> lines (first) (count))
        mirror-pos (pattern->vertical-mirror-pos pattern)]
    (loop [pos 1]
      (cond
        (>= pos char-count) -1 
        (= pos mirror-pos) (recur (inc pos)) 
        (= 1 (differences-in-vertical lines pos)) pos
        :else (recur (inc pos))))))

(defn pattern->score 
  [pattern]
  (or (pattern->horizontal-score pattern)
      (pattern->vertical-score pattern)))

(defn day13-part2
  {:test (fn []
           (is= (day13-part2 day13-example) 400)
           (is= (day13-part2 day13-puzzle) 36771))}
  [text]
  (->> text
       (text->paragraphs)
       (map pattern->score) 
       (apply +)))

(comment
  (time (day13-part2 day13-puzzle))
  ; (out) "Elapsed time: 18.854914 msecs"
  ; 36771
  )
