(ns year2021.day11.day11-part1
  (:require [ysera.test :refer [is is= is-not deftest]]
            [ysera.collections :refer [seq-contains?]]
            [year2021.day11.day11-data :refer [day11-example
                                               day11-example-step1
                                               day11-example-step2
                                               day11-puzzle]]
            [clojure.string :as str]))

(defn debug-a-map
  [the-map]
  (doseq [y (range 0 10)]
    (do
      (doseq [x (range 0 10)]
        (print (get the-map [x y]) " "))
      (println))))

(defn char->number
  [digit-char]
  (- (int digit-char)
     (int \0)))

(defn line->map
  [y line]
  (->> line
       (map-indexed (fn [x char]
                      {[x y] (char->number char)}))
       (reduce merge)))

(defn text->map
  [text]
  (->> text
       (str/split-lines)
       (map-indexed line->map)
       (reduce merge)))

(defn inc-all-vals
  [the-map]
  (->> the-map
       (keys)
       (reduce (fn [accumulator position]
                 (update accumulator position inc))
               the-map)))

(defn contains-10?
  {:test (fn []
           (is (contains-10? {:a 4 :b 10}))
           (is (contains-10? {:a 4 :b 12}))
           (is-not (contains-10? {:a 4 :b 6})))}
  [the-map]
  (->> the-map
       (vals)
       (filter #(> % 9))
       (seq)))

(def the-grid
  (for [x (range -1 2)
        y (range -1 2)]
    [x y]))

(defn increase-cell-n-surrounding
  [the-map [px py]]
  (let [the-map (reduce (fn [the-map [gx gy]]
                          (let [x (- px gx)
                                y (- py gy)
                                position [x y]]
                            (if (contains? the-map position)
                              (update the-map position inc)
                              the-map)))
                        the-map
                        the-grid)]
    (assoc the-map [px py] -100)))

(defn do-the-10s
  [the-map]
  (loop [[position & positions-with-10] (->> the-map
                                             (filter (fn [[_ value]] (> value 9)))
                                             (map first))
         the-map the-map]
    (if (nil? position)
      the-map
      (recur positions-with-10
             (increase-cell-n-surrounding the-map position)))))

(defn do-the-flash
  [the-map]
  (let [flash-points (->> the-map
                          (filter (fn [[_ value]] (< value 0)))
                          (map first))]
    {:flashes (count flash-points)
     :map     (reduce (fn [acc pos]
                        (assoc acc pos 0))
                      the-map
                      flash-points)}))

(defn do-one-round
  {:test (fn []
           (let [step0 {:flashes 0
                        :map     (text->map day11-example)}
                 step1 {:flashes 0
                        :map     (text->map day11-example-step1)}
                 step2-map (text->map day11-example-step2)

                 step2 {:flashes (->> step2-map
                                      (vals)
                                      (filter #(= % 0))
                                      (count))
                        :map     step2-map}]
             (is= (do-one-round step0) step1)
             (is= (do-one-round step1) step2)))}
  [{flashes :flashes the-map :map}]
  (loop [the-map (inc-all-vals the-map)]
    (if (contains-10? the-map)
      (recur (do-the-10s the-map))
      (let [{round-flashes :flashes the-map :map} (do-the-flash the-map)]
        {:flashes (+ flashes round-flashes)
         :map     the-map}))))

(defn do-n-rounds
  [state rounds]
  (loop [rounds rounds
         state state]
    (if (= rounds 0)
      state
      (recur (dec rounds)
             (do-one-round state)))))

(defn day11-part1
  {:test (fn []
           (is= (day11-part1 day11-example) 1656)
           (is= (day11-part1 day11-puzzle) 1688)
           )}
  [text]
  (let [state {:flashes 0
               :map     (text->map text)}]
    (:flashes (do-n-rounds state 100))))


(comment
  (time (day11-part1 day11-puzzle))
  ;"Elapsed time: 26.282938 msecs"
  ;=> 1688
  )
