(ns year2022.day15.day15-part2
  (:require [utils.numbers :as un]
            [utils.text :as ut]
            [year2022.day15.day15-data :refer [day15-example day15-puzzle]]
            [year2022.day15.day15-part1 :as part-1]
            [ysera.test :refer [is=]]))



(defn add-manhattan
  [{sensor :sensor beacon :beacon :as state}]
  (assoc state :manhattan (un/manhattan-distance sensor beacon)))

(defn text->sensors
  [text] (->> text
              (ut/text->lines)
              (map part-1/line->sensor-beacon)
              (map add-manhattan)))

(defn coord->frequency
  {:test (fn []
           (is= (coord->frequency 14 11) 56000011))}
  [x y]
  (+ (*' x 4000000) y))

(defn pos-inside-beacon?
  [pos {sensor :sensor beacon-manhattan :manhattan}]
  (let [md (un/manhattan-distance pos sensor)]
    (<= md beacon-manhattan)))

(defn move-below-of-once
  {:test (fn []
           (let [sensors (text->sensors day15-example)]
             (is= (reduce move-below-of-once
                          [14 11]
                          sensors)
                  [14 11])))}
  [[x y :as pos] {[sx sy] :sensor beacon-manhattan :manhattan :as wtf}]
  (if (pos-inside-beacon? pos wtf)
    [x (+ sy 1 (- beacon-manhattan (abs (- sx x))))]        ; (+ sx 1 (- beacon-manhattan (abs (- sy y))))
    pos))

(defn move-below-of
  {:test (fn []
           (let [sensors (text->sensors day15-example)]
             (is= (move-below-of [14 0] sensors) [14 11])))}
  [pos sensors]
  (loop [pos pos]
    (let [new-pos (reduce move-below-of-once
                          pos
                          sensors)]
      (if (= pos new-pos)
        pos
        (recur new-pos)))))

(defn find-pos
  [sensors upper-limit]
  (loop [x 0]
    (let [[px py] (move-below-of [x 0] sensors)]
      (cond
        (and (>= x upper-limit)
             (> py upper-limit))
        "no limit"

        (> py upper-limit)
        (recur (inc x))

        :else [x py]))))

(defn day15-part2
  {:test (fn []
           (is= (day15-part2 day15-example 20) 56000011))}  ;
  [text upper-limit]
  (let [sensors (text->sensors text)]
    (->> (find-pos sensors upper-limit)
         (apply coord->frequency))))

(comment
  (time (day15-part2 day15-puzzle 4000000))
  ;"Elapsed time: 1058203.749184 msecs"
  ;=> 11318723411840
  ;
  ; [2829680 3411840]
  )
