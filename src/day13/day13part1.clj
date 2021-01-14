(ns day13.day13part1
  (:require [ysera.test :refer [is is= is-not]]
            [clojure.string :as str]))


(defn string->note
  {:test (fn []
           (is= (string->note (str "939\n"
                                   "7,13,x,x,59,x,31,19"))
                {:earliest 939
                 :busses   (list 7 13 0 0 59 0 31 19)}))}
  [string]
  (let [[earliest busses] (str/split string #"\n")]
    {:earliest (read-string earliest)
     :busses   (->> busses
                    (re-seq #"[\dx]+")
                    (map (fn [bus-id-or-x] (if (= bus-id-or-x "x") "0" bus-id-or-x)))
                    (map read-string))}))

(defn minutes-past
  {:test (fn []
           (is= (minutes-past 939 59) 5)
           (is= (minutes-past 0 7) 0)
           (is= (minutes-past 7 7) 0))}
  [earliest bus-id]
  (-> (/ earliest bus-id)
      (int)
      (inc)
      (* bus-id)
      (- earliest)
      (mod bus-id)))

(defn day13part1
  {:test (fn []
           (is= (day13part1 (str "939\n"
                                 "7,13,x,x,59,x,31,19"))
                (* 5 59)))}
  [string]
  (let [{earliest :earliest busses :busses} (string->note string)]
    (->> busses
         (filter (fn [bus-id] (not (= 0 bus-id))))
         (map (fn [bus-id] [bus-id (minutes-past earliest bus-id)]))
         (sort (fn [[_ bus-id-a] [_ bus-id-b]] (< bus-id-a bus-id-b)))
         (first)
         (reduce *))))

(defn bus-remainders
  [timestamp bus-list]
  (->> bus-list
       (map (fn [[note-idx bus-id]]
              [note-idx bus-id (mod (+ timestamp note-idx) bus-id)]))))

(defn index-busses
  [string]
  (->> (string->note string)
       (:busses)
       (map-indexed (fn [note-id bus-id] [note-id bus-id]))
       (filter (fn [[_ bus-id]] (> bus-id 0)))
       (sort (fn [[_ bus-id-a] [_ bus-id-b]] (> bus-id-a bus-id-b)))))

(defn day13part2
  {:test (fn []
           (is= (day13part2 (str "939\n" "7,13,x,x,59,x,31,19")) 1068781)
           (is= (day13part2 (str "123\n" "17,x,13,19")) 3417)
           (is= (day13part2 (str "123\n" "67,7,59,61")) 754018)
           (is= (day13part2 (str "123\n" "67,x,7,59,61")) 779210)
           (is= (day13part2 (str "123\n" "67,7,x,59,61")) 1261476)
           (is= (day13part2 (str "123\n" "1789,37,47,1889")) 1202161486))}
  [string]
  (let [indexed-busses (index-busses string)
        [largest-bus-id-idx largest-bus-id] (first indexed-busses)]
    (loop [timestamp (- largest-bus-id largest-bus-id-idx)]
      (let [busses-with-remainder (bus-remainders timestamp indexed-busses)]
        (if (= 0 (->> busses-with-remainder
                      (map last)
                      (reduce +)))
          timestamp
          (recur (+ timestamp
                    (->> busses-with-remainder
                         (filter (fn [[_ _ remainder]] (= remainder 0)))
                         (map second)
                         (reduce *)))))))))

(comment
  (def my-note "1006726\n23,x,x,x,x,x,x,x,x,x,x,x,x,41,x,x,x,x,x,x,x,x,x,647,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,13,19,x,x,x,x,x,x,x,x,x,29,x,557,x,x,x,x,x,37,x,x,x,x,x,x,x,x,x,x,17"
    )
  (index-busses my-note)
  (day13part1 my-note)                                      ; 3882
  (day13part2 my-note)                                      ; 867295486378319
  )
