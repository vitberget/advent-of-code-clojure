(ns year2021.day4.day4-part2
  (:require [ysera.test :refer [is is= is-not deftest]]
            [year2021.day4.day4-data :refer [day4-example day4-puzzle]]
            [year2021.day4.day4-part1 :refer [text->state
                                              winning-bingoline-and-last-number
                                              score-winner]]))

(defn day4-part2
  {:test (fn []
           (is= (day4-part2 day4-example) 1924))}
  [text]
  (let [state (text->state text)
        {numbers :numbers boards :boards} state]
    (->> boards
         (map (fn [board] {:numbers numbers
                           :boards  (list board)}))
         (map winning-bingoline-and-last-number)
         (reduce (fn [w1 w2]
                   (if (> (count (:numbers w1))
                          (count (:numbers w2)))
                     w1
                     w2)))
         (score-winner))))

(comment
  (time (day4-part2 day4-puzzle))
  ;"Elapsed time: 206.578017 msecs"
  ;=> 13158
  )