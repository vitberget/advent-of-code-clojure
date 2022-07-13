(ns year2021.day18.day18-part2
  (:require [ysera.test :refer [is is= is-not deftest]]
            [year2021.day18.day18-part1 :refer [string->state add-numbers score]]
            [year2021.day18.day18-data :refer [day18-example-2 day18-puzzle]]
            [clojure.string :as str]))

(defn day18-part2
  {:test (fn []
           (is= (day18-part2 day18-example-2) 3993))}
  [text]
  (let [numbers (->> text
                     (str/split-lines)
                     (map string->state))]
    (->> (for [n1 numbers
               n2 numbers
               :when (not= n1 n2)]
           (score (add-numbers n1 n2)))
         (reduce max))))

  (comment
    (time (day18-part2 day18-puzzle))
    ;"Elapsed time: 3659.757043 msecs"
    ;=> 4731
    ;
    )