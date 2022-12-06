(ns year2022.day6.day6-part1
  (:require [year2022.day6.day6-data :refer [day6-puzzle]]
            [ysera.test :refer [is=]]))

(defn day6-part1
  {:test (fn []
           (is= (day6-part1 "mjqjpqmgbljsphdztnvjfqwrcgsmlb") 7)
           (is= (day6-part1 "bvwbjplbgvbhsrlpgdmjqwftvncz") 5)
           (is= (day6-part1 "nppdvjthqldpwncqszvftbrmjlhg") 6)
           (is= (day6-part1 "nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg") 10)
           (is= (day6-part1 "zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw") 11)
           (is= (day6-part1 day6-puzzle) 1760))}
  [text]
  (->> text
       (partition 4 1)
       (map-indexed (fn [idx characters] [idx characters]))
       (filter (fn [[_ characters]] (= 4 (count (into #{} characters)))))
       (first)
       (first)
       (+ 4)))

(comment
  (time (day6-part1 day6-puzzle))
  ;"Elapsed time: 4.882642 msecs"
  ;=> 1760
  )
