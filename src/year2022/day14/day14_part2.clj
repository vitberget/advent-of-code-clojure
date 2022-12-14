(ns year2022.day14.day14-part2
  (:require [year2022.day14.day14-data :refer [day14-example day14-puzzle]]
            [year2022.day14.day14-part1 :as part-1]
            [ysera.test :refer [is=]]))

(defn drop-sand
  [cave-system max-y]
  (loop [idx 0
         [sx sy] [500 0]]
    (let [ty (inc sy)
          bottom (> ty (inc max-y))
          left (or bottom (get cave-system [(dec sx) ty]))
          middle (or bottom (get cave-system [sx ty]))
          right (or bottom (get cave-system [(inc sx) ty]))]
      (cond
        (and left middle right (= sx 500) (= sy 0))
        nil

        (and left middle right)
        (assoc cave-system [sx sy] \o)

        (and middle (not left))
        (recur (inc idx) [(dec sx) sy])

        (and middle (not right))
        (recur (inc idx) [(inc sx) sy])

        :else
        (recur (inc idx) [sx (inc sy)])))))

(defn drop-all-sand
  [cave-system max-y]
  (loop [cave-system cave-system]
    ;(println idx)
    ;(part-1/print-cave-system cave-system)
    (if-let [updated-cave-system (drop-sand cave-system max-y)]
      (recur updated-cave-system)
      cave-system)))

(defn day14-part2
  {:test (fn []
           (is= (day14-part2 day14-example) 93)
           (is= (day14-part2 day14-puzzle) 30157))}
  [text]
  (let [cave-system (part-1/text->cave-system text)
        {max-y :max-y} (part-1/min-max-cavesystem cave-system)]
    (->> (drop-all-sand cave-system max-y)
         (vals)
         (filter #(= % \o))
         (count)
         (inc))))

(comment
  (time (day14-part2 day14-puzzle))
  ;"Elapsed time: 4814.201081 msecs"
  ;=> 30157
  )
