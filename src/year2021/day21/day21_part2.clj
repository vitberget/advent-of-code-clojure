(ns year2021.day21.day21-part2
  (:require [ysera.test :refer [is is= is-not deftest]]
            [ysera.collections :refer [seq-contains?]]))

(def dice-roll-freqs
  (->> (for [d1 (range 1 4)
             d2 (range 1 4)
             d3 (range 1 4)]
         (+ d1 d2 d3))
       (frequencies)))

(def dice-roll-scores
  (keys dice-roll-freqs))

(defn update-pos
  [pos dice-score]
  (loop [pos (+ pos dice-score)]
    (if (> pos 10)
      (recur (- pos 10))
      pos)))

(defn update-pointing-to-nil
  [the-map [play dice-score :as origin]]
  (let [active-player (:active play)
        [pos score] (get play active-player)
        npos (update-pos pos dice-score)
        nscore (+ score npos)]
    (if (>= nscore 21)
      (assoc the-map origin 1)
      (let [play (-> play
                     (assoc active-player [npos nscore])
                     (assoc :active (if (not= active-player :p1)
                                      :p1
                                      :p2)))]
        (reduce (fn [the-map dscore]
                  (let [map-key [play dscore]]
                    (-> the-map
                        (update origin (fn [target-set] (conj (or target-set (list)) map-key)))
                        (update map-key identity))))
                the-map
                dice-roll-scores)))))

(defn map-plays
  [start-map]
  (loop [the-map start-map
         counter 0]
    (let [not-mapped (->> the-map
                          (filter (fn [[_ v]] (nil? v)))
                          (keys))]
      (if (empty? not-mapped)
        the-map
        (recur
          (reduce update-pointing-to-nil
                  the-map
                  (sort (fn [[_ v1] [_ v2]] (> v1 v2))
                        not-mapped))
          (inc counter))))))

(def count-wins
  (memoize (fn [played-map start-keys player]
             (->> start-keys
                  (map (fn [[{active :active} dice-roll-sum :as k]]
                         (let [target (get played-map k)]
                           (* (get dice-roll-freqs dice-roll-sum)
                              (if (number? target)
                                (if (= active player) target 0)
                                (count-wins played-map target player))))))
                  (reduce +')))))

(defn day21-part2
  {:test (fn []
           (is= (day21-part2 4 8) 444356092776315)          ; example
           (is= (day21-part2 7 10) 270005289024391)         ; puzzle
           )}
  [p1-pos p2-pos]
  (let [start-map (->> dice-roll-scores
                       (reduce (fn [the-map k] (assoc the-map [{:p1     [p1-pos 0]
                                                                :p2     [p2-pos 0]
                                                                :active :p1}
                                                               k]
                                                              nil))
                               {}))
        start-keys (keys start-map)
        played-map (map-plays start-map)]
    (max (count-wins played-map start-keys :p1)
         (count-wins played-map start-keys :p2))))

(comment
  (time (day21-part2 7 10))
  ;"Elapsed time: 2795.810499 msecs"
  ;=> 270005289024391
  )