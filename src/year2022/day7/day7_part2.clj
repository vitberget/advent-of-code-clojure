(ns year2022.day7.day7-part2
  (:require [year2022.day7.day7-data :refer [day7-example day7-puzzle]]
            [year2022.day7.day7-part1 :as part-1]
            [ysera.test :refer [is=]]))

(defn day7-part2
  {:test (fn []
           (is= (day7-part2 day7-example) 24933642)
           (is= (day7-part2 day7-puzzle) 5025657))}
  [text]
  (let [max-size (- 70000000 30000000)
        dirs (->> text
                  (part-1/text->dir-structure)
                  (part-1/dir-structure->dir-sized))
        total-size (get dirs ["/"])
        dir-sizes (-> dirs
                      (dissoc ["/"])
                      (vals))]
    (->> dir-sizes
         (filter (fn [v] (<= (- total-size v) max-size)))
         (apply min))))

(comment
  (time (day7-part2 day7-puzzle))
  ;"Elapsed time: 5.82564 msecs"
  ;=> 5025657
  )
