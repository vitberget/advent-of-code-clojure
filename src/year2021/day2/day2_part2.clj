(ns year2021.day2.day2-part2
  (:require [ysera.test :refer [is is= is-not deftest]]
            [year2021.day2.data-day2 :refer [day2-example day2-puzzle]]
            [year2021.day2.day2-part1 :refer [text->actions]]))

(defn update-state [state [word number]]
  (condp = word
    "down" (update state :aim + number)
    "up" (update state :aim - number)
    "forward" (-> state
                  (update :f + number)
                  (update :d + (* (:aim state) number)))))

(defn day2-part2
  {:test (fn []
           (is= (day2-part2 day2-example) 900))}
  [text]
  (as-> text $
        (text->actions $)
        (reduce update-state {:f 0 :d 0 :aim 0} $)
        (select-keys $ [:d :f])
        (vals $)
        (reduce * $)))

(comment
  (time (day2-part2 day2-puzzle))
  ;"Elapsed time: 3.477105 msecs"
  ;=> 1813664422
  )