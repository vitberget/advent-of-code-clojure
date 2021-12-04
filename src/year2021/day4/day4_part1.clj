(ns year2021.day4.day4-part1
  (:require [ysera.test :refer [is is= is-not deftest]]
            [ysera.collections :refer [seq-contains?]]
            [year2021.day4.day4-data :refer [day4-example day4-puzzle]]
            [clojure.pprint :refer [pprint]]
            [clojure.string :as str]))

(defn line->numbers
  {:test (fn []
           (is= (line->numbers "1,2,3,4") (list 1 2 3 4))
           (is= (line->numbers "22 13 17 11  0") (list 22 13 17 11 0))
           (is= (line->numbers " 8  2 23  4 24") (list 8 2 23 4 24))
           (is= (line->numbers "5 6 7 8") (list 5 6 7 8)))}
  [line]
  (->> (str/split line #"[,\s]+")
       (filter not-empty)
       (map str/trim)
       (map read-string)))

(defn five-lines->board
  [lines]
  (->> lines
       (map-indexed (fn [y nums]
                      (->> nums
                           (map-indexed (fn [x n]
                                          {:x x :y y :n n})))))
       (flatten)))
(defn lines->board
  [lines]
  (->> lines
       (map line->numbers)
       (partition 5)
       (map five-lines->board)))

(defn text->state
  [text]
  (let [lines (->> text
                   (str/split-lines)
                   (filter not-empty))
        number-line (first lines)
        board-lines (rest lines)]
    {:numbers (line->numbers number-line)
     :boards  (lines->board board-lines)}))

(defn get-matching-cells
  [cells num key]
  (->> cells
       (filter (fn [cell] (= (key cell) num)))))

(defn get-winning-bingo-line-from-board
  [board numbers]
  (let [remaining-cells (->> board
                             (filter (fn [cell] (seq-contains? numbers (:n cell)))))
        oneway (->> (range 5)
                    (map (fn [i] (get-matching-cells remaining-cells i :y))))
        otherway (->> (range 5)
                      (map (fn [i] (get-matching-cells remaining-cells i :x))))

        bothway (->> (concat oneway otherway)
                     (filter not-empty)
                     (filter (fn [num] (= (count num) 5)))
                     (not-empty))
        ]
    (when bothway
      {:winning-line bothway
       :board        board
       :numbers      numbers})))

(defn get-winning-bingo-line-from-boards
  [boards numbers]
  (->> boards
       (map (fn [board] (get-winning-bingo-line-from-board board numbers)))
       (flatten)
       (filter not-empty)
       (not-empty)
       (merge)))

(defn winning-bingoline-and-last-number
  [state]
  (let [numbers (:numbers state)
        boards (:boards state)]
    (loop [drawn-numbers (take 4 numbers)
           [drawn & numbers-to-draw] (drop 4 numbers)]
      (let [drawn-numbers (conj drawn-numbers drawn)]
        (if-let [winning-bingo-line (get-winning-bingo-line-from-boards boards drawn-numbers)]
          (merge (first winning-bingo-line)
                 {:last-drawn drawn})
          (recur drawn-numbers numbers-to-draw))))))

(defn score-winner
  [{numbers :numbers last :last-drawn board :board}]
  (let [s1 (->> board
                (map :n)
                (filter (fn [n] (not (seq-contains? numbers n))))
                (reduce +))]
    (* last s1)))

(defn day4-part1
  {:test (fn []
           (is= (day4-part1 day4-example) 4512)
           (is= (day4-part1 day4-puzzle) 54275))}
  [text]
  (->> text
       (text->state)
       (winning-bingoline-and-last-number)
       (score-winner)))

(comment
  (time (day4-part1 day4-puzzle))
  ;"Elapsed time: 58.842809 msecs"
  ;=> 54275
  )
