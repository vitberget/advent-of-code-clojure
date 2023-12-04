(ns year2023.day04.day04-part2
  (:require
   [clojure.set :as set]
   [utils.text :refer [split-on text->lines]]
   [year2023.day04.day04-data :refer [day04-example day04-puzzle]]
   [year2023.day04.day04-part1 :as part-1]
   [ysera.test :refer [is=]]))

(defn line->cards 
  {:test (fn[]
           (is= (line->cards "Card 1: 41 48 83 86 17 | 83 86  6 31 17  9 48 53")
                {:card 1
                 :winning #{41 48 83 86 17}
                 :player #{83 86 6 31 17 9 48 53}}))}
  [line]
  (let [[card numbers] (split-on #":" line)
        [winning player] (split-on #"\|" numbers) ]
    {:card (-> card
               (subs 5)
               (read-string))
     :winning (part-1/line->numbers winning) 
     :player (part-1/line->numbers player)}))

(defn scratchcards 
  [{card :card winning :winning player :player}]
  (let [cnt (count (set/intersection winning player))]
    {:card card 
     :scratchcards (range (+ card 1) (+ card 1 cnt))}))

(defn do-the-scratchcards 
  [scratchcards]
  (loop [[card & scratchcards] scratchcards
         extra-card-count {}
         card-count 0]
    (if (nil? card)
      card-count 
      (let [this-card-count (+ 1 (get extra-card-count (:card card) 0))]
        (recur scratchcards
               (reduce (fn[extra-card-count card-number]
                         (update extra-card-count card-number 
                                 (fn[v] (+ (or v 0) this-card-count))))
                       extra-card-count
                       (:scratchcards card))
                (+ card-count this-card-count))))))

(defn day04-part2
  {:test (fn [] (is= (day04-part2 day04-example) 30))}
  [text]
  (->> text
       (text->lines)
       (map line->cards)
       (map scratchcards)
       (do-the-scratchcards)))

(comment
  (time (day04-part2 day04-puzzle))
  ; (out) "Elapsed time: 9.284972 msecs"
  ; 13768818
  )
