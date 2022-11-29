(ns year2021.day3.day3-part2
  (:require [ysera.test :refer [is is= is-not deftest]]
            [year2021.day3.day3-data :refer [day3-example day3-puzzle]]
            [clojure.string :as str]))

(defn count-chars
  [chars test-char]
  (->> chars
       (filter (fn [c] (= c test-char)))
       (count)))

(defn count-ones-zeroes
  {:test (fn []
           (is= (count-ones-zeroes ["10" "10" "01"] 0)
                {\1 2 \0 1}))}
  [lines index]
  (let [chars (map (fn [line] (nth line index))
                   lines)]
    {\1 (count-chars chars \1)
     \0 (count-chars chars \0)}))

(defn more-zeros?
  [lines index]
  (let [{ones \1 zeroes \0} (count-ones-zeroes lines index)]
    (> zeroes ones)))

(defn nth-char-is
  [line lines index char-1 char-2]
  (= (nth line index)
     (if (more-zeros? lines index)
       char-1
       char-2)))

(defn calc-stuff
  [lines char-1 char-2]
  (loop [index 0
         lines lines]
    (if (= (count lines) 1)
      (first lines)
      (recur (inc index)
             (->> lines
                  (filter (fn [line] (nth-char-is line lines index char-1 char-2))))))))

(defn calc-oxygen [lines] (calc-stuff lines \0 \1))
(defn calc-co2-scrubber [lines] (calc-stuff lines \1 \0))
(defn parse-binary-string [bs] (Integer/parseInt bs 2))

(defn day3-part2
  {:test (fn []
           (is= (day3-part2 day3-example) 230)
           (is= (day3-part2 day3-puzzle) 5410338))}
  [text]
  (let [lines (->> text (str/split-lines))
        oxygen (-> lines
                   (calc-oxygen)
                   (parse-binary-string))
        co2-scrubber (-> lines
                         (calc-co2-scrubber)
                         (parse-binary-string))]
    (* oxygen co2-scrubber)))

(comment
  (time (day3-part2 day3-puzzle))
  ;"Elapsed time: 10.666236 msecs"
  ;=> 5410338
  )