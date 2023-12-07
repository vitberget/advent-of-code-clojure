(ns year2023.day07.day07-part1
  (:require
    [utils.text :refer [char->number line->words text->lines]]
    [year2023.day07.day07-data :refer [day07-example day07-puzzle]]
    [ysera.test :refer [is=]]))

(defn card->value 
  [k]
  (condp = k
    \A 14
    \K 13
    \Q 12
    \J 11
    \T 10 
    (char->number k)))

(defn line->cards-n-bet
  [line]
  (let [[cards-line bet] (line->words line)
        cards (->> cards-line
                   (group-by identity)
                   (map (fn [[k v]] [(card->value k) (count v)]))
                   (sort (fn [[ak av] [bk bv]]
                           (if (= av bv)
                             (- bk ak)
                             (- bv av)))))
        hand (cond
               ; Five of a kind
               (= 1 (count cards))
               6

               ; Four of a kind
               (= 4 (-> cards (first) (second)))
               5

               ; Full house
               (and (= 3 (-> cards (first) (second)))
                    (= 2 (-> cards (second) (second))) )
               4

               ; Three of a kind
               (= 3 (-> cards (first) (second)))
               3

               ; Two pairs
               (and (= 2 (-> cards (first) (second)))
                    (= 2 (-> cards (second) (second))) )
               2

               ; One pair
               (= 2 (-> cards (first) (second)))
               1

               ; High card
               :else 
               0)
        bet (read-string bet)]
    [(map card->value cards-line) hand bet]))

(defn sort-cards-n-bet 
  [[cards-a hand-a _] [cards-b hand-b _]]
  (cond 
    (not= hand-a hand-b)
    (- hand-a hand-b) 

    (not= (nth cards-a 0) (nth cards-b 0))
    (- (nth cards-a 0) (nth cards-b 0))

    (not= (nth cards-a 1) (nth cards-b 1))
    (- (nth cards-a 1) (nth cards-b 1))

    (not= (nth cards-a 2) (nth cards-b 2))
    (- (nth cards-a 2) (nth cards-b 2))

    (not= (nth cards-a 3) (nth cards-b 3))
    (- (nth cards-a 3) (nth cards-b 3))

    :else
    (- (nth cards-a 4) (nth cards-b 4))))

(defn day07-part1
  {:test (fn []
           (is= (day07-part1 day07-example) 6440))}
  [text]
  (->> text
       (text->lines)
       (map line->cards-n-bet)
       (sort sort-cards-n-bet)
       (map-indexed (fn [idx [_ _ bet]] (* (inc idx) bet)))
       (apply +)))

(comment
  (time (day07-part1 day07-puzzle))
  ; (out) "Elapsed time: 12.097317 msecs"
  ; 253933213
  )
