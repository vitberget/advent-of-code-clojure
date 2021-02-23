(ns year2020.day22.day22part2
  (:require [ysera.test :refer [is is= is-not]]
            [clojure.string :as str]))

(defn debug-println
  [& args]
  ;(apply println args)
  )

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

(defn both-players-remaining-under-card-value?
  [card1 deck1 card2 deck2]
  (and (< card1 (count deck1))
       (< card2 (count deck2))))

(defn this-round-played-aleady?
  [rounds-played this-round]
  (contains? rounds-played this-round))

(def game-index (atom 0))

(defn play-decks
  {:test (fn []
           (is= (play-decks (string->decks "Player 1:\n9\n2\n6\n3\n1\n\nPlayer 2:\n5\n8\n4\n7\n10"))
                {:winner :player2
                 :deck   (list 7 5 6 2 4 1 10 8 9 3)}))}
  [[deck1 deck2]]
  (let [game-id (swap! game-index inc)]
    (loop [[card1 & rest1 :as deck1] deck1
           [card2 & rest2 :as deck2] deck2
           rounds-played #{}]
      (let [this-round [deck1 deck2]
            round-id (inc (count rounds-played))]
        (debug-println "round" round-id "game" game-id)
        (debug-println "p1 deck" deck1)
        (debug-println "p2 deck" deck2)
        (debug-println "p1 plays" card1)
        (debug-println "p2 plays" card2)
        (cond
          ;------
          (empty? deck1)
          (do (debug-println "p1 wins round" round-id "game" game-id "(p2 empty)")
              {:winner :player2
               :deck   (conj rest2 card2)})
          (empty? deck2)
          (do (debug-println "p2 wins round" round-id "game" game-id "(p1 empty)")
              {:winner :player1
               :deck   (conj rest1 card1)})

          ;------
          (this-round-played-aleady? rounds-played this-round)
          (do (debug-println "p1 wins round" round-id "game" game-id "(deck played)")
              {:winner :player1 :deck nil})

          ;------
          (both-players-remaining-under-card-value? card1 deck1 card2 deck2)
          (do (debug-println "Playing sub-game")
              (if (= :player1 (:winner (play-decks [(take card1 rest1) (take card2 rest2)])))
                (do (debug-println "p1 wins round" round-id "game" game-id "(won sub-game)")
                    (recur
                      (concat rest1 (list card1 card2))
                      rest2
                      (conj rounds-played this-round)))
                (do (debug-println "p2 wins round" round-id "game" game-id "(won sub-game)")
                    (recur
                      rest1
                      (concat rest2 (list card2 card1))
                      (conj rounds-played this-round)))))

          ;-------
          :else
          (if (> card1 card2)
            (do (debug-println "p1 wins round" round-id "game" game-id "(higher card)")
                (recur
                  (concat rest1 (list card1 card2))
                  rest2
                  (conj rounds-played this-round)))
            (do (debug-println "p1 wins round" round-id "game" game-id "(higher card)")
                (recur
                  rest1
                  (concat rest2 (list card2 card1))
                  (conj rounds-played this-round)))))))))

(defn day22part2
  {:test (fn []
           (is= (day22part2 "Player 1:\n9\n2\n6\n3\n1\n\nPlayer 2:\n5\n8\n4\n7\n10")
                291))}
  [string]
  (->> string
       (string->decks)
       (play-decks)
       (:deck)
       (score-deck)))


(comment
  (time
    (let [example "Player 1:\n9\n2\n6\n3\n1\n\nPlayer 2:\n5\n8\n4\n7\n10"]
      (reset! game-index 0)
      (day22part2 example)))

  (let [puzzle-input "Player 1:\n47\n19\n22\n31\n24\n6\n10\n5\n1\n48\n46\n27\n8\n45\n16\n28\n33\n41\n42\n36\n50\n39\n30\n11\n17\n\nPlayer 2:\n4\n18\n21\n37\n34\n15\n35\n38\n20\n23\n9\n25\n32\n13\n26\n2\n12\n44\n14\n49\n3\n40\n7\n43\n29"]
    (reset! game-index 0)
    (time (day22part2 puzzle-input)))
  ;"Elapsed time: 11056.322212 msecs"
  ;=> 31657
  )