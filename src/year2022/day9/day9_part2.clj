(ns year2022.day9.day9-part2
  (:require [year2022.day9.day9-data :refer [day9-example day9-example-2 day9-puzzle]]
            [year2022.day9.day9-part1 :as part-1]
            [ysera.test :refer [is=]]))

(defn update-rope
  [head rope]
  (loop [new-rope (list head)
         prev head
         [cur & rope] (drop 1 rope)]
    (if (= (count new-rope) 10)
      (reverse new-rope)
      (let [new-pos (part-1/tail-follow-head prev cur)]
        (recur (conj new-rope new-pos)
               new-pos
               rope)))))

(defn rope-a-dope
  [state [direction speed]]
  (loop [{rope :rope :as state} state
         speed speed]
    (if (zero? speed)
      state
      (let [head (mapv + (first rope) (get part-1/directions direction))
            rope (update-rope head rope)]
        (recur (-> state
                   (update :tail-visitations conj (last rope))
                   (assoc :rope rope))
               (dec speed))))))

(defn day9-part2
  {:test (fn []
           (is= (day9-part2 day9-example) 1)
           (is= (day9-part2 day9-example-2) 36)
           (is= (day9-part2 day9-puzzle) 2793))}
  [text]
  (->> text
       (part-1/text->moves)
       (reduce rope-a-dope {:rope (repeat 10 [0 0]) :tail-visitations #{[0 0]}})
       (:tail-visitations)
       (count)))

(comment
  (time (day9-part2 day9-puzzle))
  ;"Elapsed time: 164.202752 msecs"
  ;=> 2793
  )
