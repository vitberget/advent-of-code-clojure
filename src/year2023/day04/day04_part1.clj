(ns year2023.day04.day04-part1
  (:require
    [utils.text :refer [split-on text->lines]]
    [year2023.day04.day04-data :refer [day04-example day04-puzzle]]
    [clojure.math.numeric-tower :refer [expt]]
    [ysera.test :refer [is=]]
    [clojure.string :as str]
    [clojure.set :as set]))

(defn line->numbers
  [text]
  (->> text
       (str/trim)
       (split-on #" +")
       (map read-string)
       (into #{})))

(defn line->cards 
  {:test (fn[]
           (is= (line->cards "Card 1: 41 48 83 86 17 | 83 86  6 31 17  9 48 53")
                {:winning #{41 48 83 86 17}
                 :player #{83 86 6 31 17 9 48 53}}))}
  [line]
  (let [[_ numbers] (split-on #":" line)
        [winning player] (split-on #"\|" numbers) ]
    {:winning (line->numbers winning) 
     :player (line->numbers player)}))

(defn score-cards 
  {:test (fn[]
           (is= (score-cards (line->cards "Card 1: 41 48 83 86 17 | 83 86  6 31 17  9 48 53")) 8) 
           (is= (score-cards (line->cards "Card 5: 87 83 26 28 32 | 88 30 70 12 93 22 82 36")) 0))}
  [{winning :winning player :player}]
  (let [cnt (count (set/intersection winning player))]
    (if (zero? cnt)
      0
      (expt 2 (dec cnt)))))

(defn day04-part1
  {:test (fn [] (is= (day04-part1 day04-example) 13))}
  [text]
  (->> text
       (text->lines)
       (map line->cards)
       (map score-cards)
       (apply +)))

(comment
  (time (day04-part1 day04-puzzle))
  ; (out) "Elapsed time: 11.918524 msecs"
  ; 20117
  )
