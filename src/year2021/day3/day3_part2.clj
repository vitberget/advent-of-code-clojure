(ns year2021.day3.day3-part2
  (:require [ysera.test :refer [is is= is-not deftest]]
            [year2021.day3.day3-data :refer [day3-example day3-puzzle]]
            [year2021.day3.day3-part1 :as part1]
            [clojure.string :as str]))

(defn calc-life-support
  [lines]

  )

(defn day3-part2
  {:test (fn []
           (is= (day3-part2 day3-example) 230))}
  [text]
  (let [s1 (->> text
                (str/split-lines)
                (map str/reverse))
        ls (calc-life-support s1)
        ]
    s1

    ))


(comment
  (time (day3-part2 day3-puzzle))
  ;
  ;
  )