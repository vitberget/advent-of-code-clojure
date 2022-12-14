(ns year2022.day14.day14-part1
  (:require [clojure.string :as str]
            [utils.numbers :as un]
            [utils.text :as ut]
            [year2022.day14.day14-data :refer [day14-example day14-puzzle]]
            [ysera.test :refer [is=]]))

(defn inner-scan->cave-system
  [cave-system [[start-x start-y] [end-x end-y]]]
  (let [dx (un/limit (- end-x start-x) -1 1)
        dy (un/limit (- end-y start-y) -1 1)]
    (loop [x start-x
           y start-y
           cave-system cave-system]
      (let [cave-system (assoc cave-system [x y] \#)]
        (if (and (= x end-x) (= y end-y))
          cave-system
          (recur (+ x dx)
                 (+ y dy)
                 cave-system))))))

(defn scan->cave-system
  [coordinates]
  (->> coordinates
       (partition 2 1)
       (reduce inner-scan->cave-system {})))

(defn line->cave-system
  [line]
  (->> (str/split line #" -> ")
       (map #(str/split % #","))
       (map #(map read-string %))
       (scan->cave-system)))

(defn text->cave-system
  [text]
  (->> text
       (ut/text->lines)
       (map line->cave-system)
       (reduce merge)))
(defn min-max-cavesystem
  [cave-system]
  (->> cave-system
       (keys)
       (reduce (fn [mm [x y]]
                 (-> mm
                     (update :min-x min x)
                     (update :min-y min y)
                     (update :max-x max x)
                     (update :max-y max y)))
               {:min-x Integer/MAX_VALUE
                :min-y Integer/MAX_VALUE
                :max-x Integer/MIN_VALUE
                :max-y Integer/MIN_VALUE})))

(defn print-cave-system
  [cave-system]
  (let [{min-x :min-x
         max-x :max-x
         max-y :max-y} (min-max-cavesystem cave-system)
        min-y 0]
    (doseq [y (range min-y (inc max-y))
            x (range min-x (inc max-x))]
      (when (and (= x min-x) (not= y 0)) (println))
      (print
        (if (and (= 500 x) (= 0 y))
          \+
          (get cave-system [x y] \.))))
    (println)
    (println)))

(defn drop-sand
  [cave-system max-y]
  (loop [[sx sy] [500 0]]
    (if (> sy max-y)
      nil
      (let [ty (inc sy)
            left (get cave-system [(dec sx) ty])
            middle (get cave-system [sx ty])
            right (get cave-system [(inc sx) ty])]
        (cond

          (and left middle right)
          (assoc cave-system [sx sy] \o)

          (and middle (not left))
          (recur [(dec sx) sy])

          (and middle (not right))
          (recur [(inc sx) sy])

          :else
          (recur [sx (inc sy)]))))))

(defn drop-all-sand
  [cave-system max-y]
  (loop [cave-system cave-system]
    ;(print-cave-system cave-system)
    (if-let [updated-cave-system (drop-sand cave-system max-y)]
      (recur updated-cave-system)
      cave-system)))

(defn day14-part1
  {:test (fn []
           (is= (day14-part1 day14-example) 24)
           (is= (day14-part1 day14-puzzle) 1078))}
  [text]
  (let [cave-system (text->cave-system text)
        {max-y :max-y} (min-max-cavesystem cave-system)]
    (->> (drop-all-sand cave-system max-y)
         (vals)
         (filter #(= % \o))
         (count))))

(comment
  (time (day14-part1 day14-puzzle))
  ;"Elapsed time: 127.506572 msecs"
  ;=> 1078
  )
