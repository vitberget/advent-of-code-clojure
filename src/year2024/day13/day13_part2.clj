(ns year2024.day13.day13-part2
  (:require [year2024.day13.day13-part1 :as part-1]
            [year2024.day13.day13-data :refer [day13-puzzle]]))

(defn add-huge-numbers-to-prize
  [machine]
  (-> machine
      (update-in [:prize 0] + 10000000000000)
      (update-in [:prize 1] + 10000000000000)))

(defn day13-part2
  ; No good test provided
  [text]
  (->> text
       (part-1/text->arcade)
       (map add-huge-numbers-to-prize)
       (map part-1/machine->cheapest-win)
       (part-1/machines->score)))

(comment
  (time (day13-part2 day13-puzzle))
  ; (out) "Elapsed time: 3.959654 msecs"
  ; 106228669504887
  )
