(ns year2021.day11.day11-part2
  (:require [ysera.test :refer [is is= is-not deftest]]
            [year2021.day11.day11-data :refer [day11-example day11-puzzle]]
            [year2021.day11.day11-part1 :as part1]
            [clojure.string :as str]))

(defn day11-part2
  {:test (fn []
           (is= (day11-part2 day11-example) 195)
           (is= (day11-part2 day11-puzzle) 403))}
  [text]
  (loop [step 0
         the-map (part1/text->map text)]
    (let [step (inc step)
          round-result (part1/do-one-round {:flashes 0 :map the-map})]
      (if (= 100 (:flashes round-result))
        step
        (recur
          step
          (:map round-result))))))


(comment
  (time (day11-part2 day11-puzzle))
  ;"Elapsed time: 61.841964 msecs"
  ;=> 403
  )