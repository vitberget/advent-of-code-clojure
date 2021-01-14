(ns day13.day13part1
  (:require [ysera.test :refer [is is= is-not]]
            [clojure.string :as str]))


(defn string->note
  {:test (fn []
           (is= (string->note (str "939\n"
                                   "7,13,x,x,59,x,31,19"))
                {:earliest 939
                 :busses   (list 7 13 0 0 59 0 31 19)})
           )}
  [string]
  (let [[earliest busses] (str/split string #"\n")]
    {:earliest (read-string earliest)
     :busses   (->> busses
                    (re-seq #"[\dx]+")
                    (map (fn [it] (if (= it "x") "0" it)))
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
         (filter (fn [b] (not (= 0 b))))
         (map (fn [bid] [bid (minutes-past earliest bid)]))
         (sort (fn [[_ a] [_ b]] (< a b)))
         (first)
         (reduce *))))

(defn day13part2
  {:test (fn []
           (is= (day13part2 (str "939\n" "7,13,x,x,59,x,31,19")) 1068781)
           (is= (day13part2 (str "123\n" "17,x,13,19")) 3417)
           (is= (day13part2 (str "123\n" "67,7,59,61")) 754018)
           (is= (day13part2 (str "123\n" "67,x,7,59,61")) 779210)
           (is= (day13part2 (str "123\n" "67,7,x,59,61")) 1261476)
           (is= (day13part2 (str "123\n" "1789,37,47,1889")) 1202161486))}
  [string]
  )

(comment
  (def my-note "1006726\n23,x,x,x,x,x,x,x,x,x,x,x,x,41,x,x,x,x,x,x,x,x,x,647,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,13,19,x,x,x,x,x,x,x,x,x,29,x,557,x,x,x,x,x,37,x,x,x,x,x,x,x,x,x,x,17"
    )
  (day13part1 my-note)
  )
