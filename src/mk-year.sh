#!/bin/sh

year=2023

mkdir "year$year" 2>/dev/null || true
cd "year$year"

for day in $(seq -f "%02g" 1 25); do
  echo $day
  mkdir "day$day" 2>/dev/null

cat > "day${day}/day${day}_data.clj" << EOF
(ns year${year}.day${day}.day${day}-data)

(def day${day}-example "")

(def day${day}-puzzle "")
EOF

cat > "day${day}/day${day}_part1.clj" << EOF
(ns year${year}.day${day}.day${day}-part1
  (:require [ysera.test :refer [is is= is-not deftest]]
            [year${year}.day${day}.day${day}-data :refer [day${day}-example day${day}-puzzle]]
            [clojure.string :as str]))

(defn day${day}-part1
  {:test (fn []
           (is= (day${day}-part1 day${day}-example) 0))}
  [text]
  )


(comment
  (time (day${day}-part1 day${day}-puzzle))
  ;
  )
EOF

cat > "day${day}/day${day}_part2.clj" << EOF
(ns year${year}.day${day}.day${day}-part2
  (:require [ysera.test :refer [is is= is-not deftest]]
            [year${year}.day${day}.day${day}-part1 :as part-1]
            [year${year}.day${day}.day${day}-data :refer [day${day}-example day${day}-puzzle]]
            [clojure.string :as str]))

(defn day${day}-part2
  {:test (fn []
           (is= (day${day}-part2 day${day}-example) 0))}
  [text]
  )


(comment
  (time (day${day}-part2 day${day}-puzzle))
  ;
  )
EOF

done
