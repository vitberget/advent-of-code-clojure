(ns year2022.day10.day10-part1
  (:require [utils.text :as ut]
            [year2022.day10.day10-data :refer [day10-example day10-puzzle]]
            [ysera.test :refer [is=]]))

(defn text->commands
  [text]
  (->> text
       (ut/text->lines)
       (map ut/line->words)))

(defn commands->cycle-scores
  [commands]
  (loop [[command & commands] commands
         cycles (list)
         score 1]
    (cond
      (nil? command)
      (reverse cycles)

      ; noop
      (= (count command) 1)
      (recur
        commands
        (conj cycles score)
        score)

      ; addx
      :else
      (let [mod (->> command
                     (second)
                     (read-string))
            new-score (+ score mod)]
        (recur
          commands
          (conj cycles score score)
          new-score)))))

(defn get-score
  [cycles positions]
  (->> positions
       (map (fn [pos] [pos (nth cycles (dec pos))]))
       (map #(apply * %))
       (apply +)))

(defn day10-part1
  {:test (fn []
           (is= (day10-part1 day10-example) 13140)
           (is= (day10-part1 day10-puzzle) 11960))}
  [text]
  (-> text
      (text->commands)
      (commands->cycle-scores)
      (get-score (list 20 60 100 140 180 220))
      ))


(comment
  (time (day10-part1 day10-puzzle))
  ;"Elapsed time: 0.64786 msecs"
  ;=> 11960
  )
