(ns year2021.day2.day2-part2
  (:require [ysera.test :refer [is is= is-not deftest]]
            [year2021.day2.data-day2 :refer [day2-example day2-puzzle]]
            [clojure.string :as str]))

(defn day2-part2
  {:test (fn []
           (is= (day2-part2 day2-example) 900))}
  [text]
  (as-> text $
        (str/split-lines $)
        (map (fn [line] (str/split line #" ")) $)
        (map (fn [[word number]] [word (read-string number)]) $)
        (reduce
          (fn [state [word number]]
            (condp = word
              "down" (update state :aim + number)
              "up" (update state :aim - number)
              "forward" (-> state
                            (update :f + number)
                            (update :d + (* (:aim state) number)))))
          {:f 0 :d 0 :aim 0}
          $)
        (select-keys $ [:d :f])
        (vals $)
        (reduce * $)))

(comment
  (time (day2-part2 day2-puzzle))
  ;"Elapsed time: 3.477105 msecs"
  ;=> 1813664422
  )