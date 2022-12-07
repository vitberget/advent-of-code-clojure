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
         (map #(fn [v] [v (- total-size v)]))
         (filter (fn [[_ v]] (<= v max-size)))
         (sort (fn [[_ v1] [_ v2]] (> v1 v2)))
         (first)
         (first))))

(comment
  (time (day7-part2 day7-puzzle))
  ;"Elapsed time: 5.82564 msecs"
  ;=> 5025657
  )
