(ns year2023.day07.day07-part2
  (:require
    [utils.text :refer [char->number line->words text->lines]]
    [year2023.day07.day07-data :refer [day07-example day07-puzzle]]
    [year2023.day07.day07-part1 :as part-1]
    [ysera.test :refer [is=]]))

(defn card->value 
  [k]
  (condp = k
    \A 14
    \K 13
    \Q 12
    \J 1
    \T 10 
    (char->number k)))

(defn line->cards-n-bet
  [line]
  (let [[cards-line bet] (line->words line)
        cards (->> cards-line
                   (group-by identity)
                   (map (fn [[k v]] (let [value (card->value k)]
                                      [value (if (= 1 value) 0 (count v))])))
                   (sort (fn [[ak av] [bk bv]]
                           (if (= av bv)
                             (- bk ak)
                             (- bv av)))))
        cards-line (map card->value cards-line)
        jacks (->> cards-line
                   (filter (fn [v] (= v 1)))
                   (count))
        hand (cond
               ; Five of a kind
               (= 5 (+ jacks (-> cards (first) (second))))
               6

               ; Four of a kind
               (= 4 (+ jacks (-> cards (first) (second))))
               5

               ; Full house
               (and (= 3 (+ jacks (-> cards (first) (second))))
                    (= 2 (-> cards (second) (second))) )
               4

               ; Three of a kind
               (= 3 (+ jacks (-> cards (first) (second))))
               3

               ; Two pairs
               (and (= 2 (+ jacks (-> cards (first) (second))))
                    (= 2 (-> cards (second) (second))) )
               2

               ; One pair
               (= 2 (+ jacks (-> cards (first) (second))))
               1

               ; High card
               :else 
               0)
        bet (read-string bet)]
    [cards-line hand bet]))
(defn day07-part2
  {:test (fn []
           (is= (day07-part2 day07-example) 5905))}
  [text]
  (->> text
       (text->lines)
       (map line->cards-n-bet)
       (sort part-1/sort-cards-n-bet)
       (map-indexed (fn [idx [_ _ bet]] (* (inc idx) bet)))
       (apply +)))


(comment
  (time (day07-part2 day07-puzzle))
  ; (out) "Elapsed time: 14.051241 msecs"
  ; 253473930
  )
