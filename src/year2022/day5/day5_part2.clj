(ns year2022.day5.day5-part2
  (:require [year2022.day5.day5-data :refer [day5-example day5-puzzle]]
            [year2022.day5.day5-part1 :as part-1]
            [ysera.test :refer [is=]]))

(defn move-stacks
  [stacks [size from to]]
  (let [from (dec from)
        to (dec to)]
    (-> stacks
        (update to #(concat (take size (nth stacks from)) %))
        (update from #(drop size %)))))

(defn day5-part2
  {:test (fn []
           (is= (day5-part2 day5-example) "MCD")
           (is= (day5-part2 day5-puzzle) "QRQFHFWCL"))}
  [text]
  (let [{stacks :stacks moves :moves} (part-1/text->state text)]
    (->> moves
         (reduce move-stacks stacks)
         (map first)
         (apply str))))

(comment
  (time (day5-part2 day5-puzzle))
  ;"Elapsed time: 14.721993 msecs"
  ;=> "QRQFHFWCL"
  )
