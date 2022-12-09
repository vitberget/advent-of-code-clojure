(ns year2022.day9.day9-part1
  (:require [utils.text :as ut]
            [year2022.day9.day9-data :refer [day9-example day9-puzzle]]
            [ysera.test :refer [is is-not is=]]))

(defn line->move
  [line]
  (let [[direction speed] (ut/line->words line)]
    [(keyword direction) (read-string speed)]))

(defn text->moves
  [text]
  (->> text
       (ut/text->lines)
       (map line->move)))

(defn tail-touching-head?
  {:test (fn []
           (is (tail-touching-head? [0 0] [0 0]))
           (is (tail-touching-head? [0 0] [1 0]))
           (is (tail-touching-head? [5 5] [5 5]))
           (is (tail-touching-head? [0 0] [1 1]))
           (is (tail-touching-head? [2 2] [1 1]))
           (is-not (tail-touching-head? [2 0] [0 0]))
           (is-not (tail-touching-head? [2 0] [0 1])))}
  [head tail]
  (->> (map - head tail)
       (map abs)
       (map #(< % 2))
       (reduce #(and %1 %2))))

(defn tail-follow-head
  {:test (fn []
           (is= (tail-follow-head [0 0] [0 0]) [0 0])
           (is= (tail-follow-head [0 0] [0 2]) [0 1])
           (is= (tail-follow-head [0 0] [0 -2]) [0 -1])
           (is= (tail-follow-head [0 0] [2 0]) [1 0])
           (is= (tail-follow-head [0 0] [-2 0]) [-1 0])
           (is= (tail-follow-head [1 2] [0 0]) [1 1])
           (is= (tail-follow-head [2 1] [0 0]) [1 1])
           (is= (tail-follow-head [-6 8] [-4 6]) [-5 7]))}
  [head [tx ty :as tail]]
  (if (tail-touching-head? head tail)
    tail
    (let [[dx dy] (map - head tail)]
      (cond
        (zero? dx)
        [tx (+ ty (if (pos? dy) 1 -1))]

        (zero? dy)
        [(+ tx (if (pos? dx) 1 -1)) ty]

        (and (= 2 (abs dx))
             (= 2 (abs dx)))
        [(+ tx (if (pos? dx) 1 -1)) (+ ty (if (pos? dy) 1 -1))]

        (= 2 (abs dx))
        [(+ tx (if (pos? dx) 1 -1)) (+ ty dy)]

        (= 2 (abs dy))
        [(+ tx dx) (+ ty (if (pos? dy) 1 -1))]))))

(def directions
  {:R [0 1]
   :L [0 -1]
   :U [1 0]
   :D [-1 0]})

(defn rope-a-dope
  [state [direction speed]]
  (loop [{head :head tail :tail :as state} state
         speed speed]
    (if (zero? speed)
      state
      (let [head (mapv + head (get directions direction))
            tail (tail-follow-head head tail)]
        (recur (-> state
                   (update :tail-visitations conj tail)
                   (assoc :head head :tail tail))
               (dec speed))))))

(defn day9-part1
  {:test (fn []
           (is= (day9-part1 day9-example) 13)
           (is= (day9-part1 day9-puzzle) 6745))}
  [text]
  (->> text
       (text->moves)
       (reduce rope-a-dope {:head [0 0] :tail [0 0] :tail-visitations #{[0 0]}})
       (:tail-visitations)
       (count)))


(comment
  (time (day9-part1 day9-puzzle))
  ;"Elapsed time: 48.04134 msecs"
  ;=> 6745
  )
