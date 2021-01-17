(ns year2020.day22.day22part1
  (:require [ysera.test :refer [is is= is-not]]
            [clojure.string :as str]))

(defn score-deck
  {:test (fn []
           (is= (score-deck (list 3 2 10 6 8 5 9 4 7 1))
                306))}
  [deck]
  (->> deck
       (reverse)
       (map-indexed (fn [i v] (* (inc i) v)))
       (reduce +)))

(defn split-list
  {:test (fn []
           (is= (split-list (list 9 2 6 3 1 5 8 4 7 10))
                (list (list 9 2 6 3 1)
                      (list 5 8 4 7 10))))}
  [list]
  (partition (-> list
                 (count)
                 (/ 2)
                 (int))
             list))

(defn string->decks
  {:test (fn []
           (is= (string->decks "Player 1:\n9\n2\n6\n3\n1\n\nPlayer 2:\n5\n8\n4\n7\n10")
                (list (list 9 2 6 3 1)
                      (list 5 8 4 7 10))))}
  [string]
  (->> (str/split string #"\n")
       (filter (fn [line] (re-find #"^\d+$" line)))
       (map read-string)
       (split-list)))

(defn play-decks
  {:test (fn []
           (is= (play-decks (string->decks "Player 1:\n9\n2\n6\n3\n1\n\nPlayer 2:\n5\n8\n4\n7\n10"))
                (list 3 2 10 6 8 5 9 4 7 1)))}
  [[deck1 deck2]]
  (loop [[card1 & deck1] deck1
         [card2 & deck2] deck2]
    (cond
      (nil? card1) (conj deck2 card2)
      (nil? card2) (conj deck1 card1)

      :else
      (if (> card1 card2)
        (recur (concat deck1 (list card1 card2)) deck2)
        (recur (concat deck2 (list card2 card1)) deck1)))))

(defn day22part1
  {:test (fn []
           (is= (day22part1 "Player 1:\n9\n2\n6\n3\n1\n\nPlayer 2:\n5\n8\n4\n7\n10")
                306))}
  [string]
  (->> string
       (string->decks)
       (play-decks)
       (score-deck)))


(comment
  (def puzzle-input "Player 1:\n47\n19\n22\n31\n24\n6\n10\n5\n1\n48\n46\n27\n8\n45\n16\n28\n33\n41\n42\n36\n50\n39\n30\n11\n17\n\nPlayer 2:\n4\n18\n21\n37\n34\n15\n35\n38\n20\n23\n9\n25\n32\n13\n26\n2\n12\n44\n14\n49\n3\n40\n7\n43\n29"
    )
  (day22part1 puzzle-input)
  )