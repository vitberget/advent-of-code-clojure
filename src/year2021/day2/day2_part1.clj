(ns year2021.day2.day2-part1
  (:require [clojure.string :as str]
            [year2021.day2.data-day2 :refer [day2-example day2-puzzle]]
            [ysera.test :refer [is=]]))

(defn text->actions
  [text]
  (->> text
       (str/split-lines)
       (map (fn [line] (str/split line #" ")))
       (map (fn [[word number]] [word (read-string number)]))))

(defn update-state
  [state [word number]]
  (condp = word
    "down" (update state :depth + number)
    "up" (update state :depth - number)
    "forward" (update state :horizontal + number)))

(defn day2-part1
  {:test (fn []
           (is= (day2-part1 day2-example) 150))}
  [text]
  (->> text
       (text->actions)
       (reduce update-state {:horizontal 0 :depth 0})
       (vals)
       (reduce *)))

(comment
  (time (day2-part1 day2-puzzle))
  ;"Elapsed time: 2.331658 msecs"
  ;=> 1962940
  )
