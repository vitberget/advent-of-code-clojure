(ns year2021.day10.day10-part1
  (:require [ysera.test :refer [is is= is-not deftest]]
            [year2021.day10.day10-data :refer [day10-example day10-puzzle]]
            [clojure.string :as str]))

(defn left?
  [char]
  (or (= \( char)
      (= \[ char)
      (= \{ char)
      (= \< char)))

(defn matching?
  [left right]
  (or (and (= left \() (= right \)))
      (and (= left \[) (= right \]))
      (and (= left \{) (= right \}))
      (and (= left \<) (= right \>))))

(defn corrupt-char
  {:test (fn []
           (is= (corrupt-char "([<>]}") \})
           (is= (corrupt-char "{([(<{}[<>[]}>{[]{[(<()>") \})
           (is= (corrupt-char "[[<[([]))<([[{}[[()]]]") \))
           (is= (corrupt-char "[{[{({}]{}}([{[{{{}}([]") \])
           (is= (corrupt-char "[<(<(<(<{}))><([]([]()") \))
           (is= (corrupt-char "<{([([[(<>()){}]>(<<{{") \>)
           (is= (corrupt-char "[({(<(())[]>[[{[]{<()<>>") nil)
           (is= (corrupt-char "[(()[<>])]({[<{<<[]>>(") nil)
           (is= (corrupt-char "(((({<>}<{<{<>}{[]{[]{}") nil)
           (is= (corrupt-char "{<[[]]>}<{[{[{[]{()[[[]") nil)
           (is= (corrupt-char "<{([{{}}[<[[[<>{}]]]>[]]") nil))}
  [line]
  (loop [[char & line] line
         stack (list)]
    (let [top (first stack)]
      (cond (nil? char)
            nil

            (left? char)
            (recur line (conj stack char))

            (matching? top char)
            (recur line (rest stack))

            :wrong-char char))))

(defn score
  [char]
  (condp = char
    \) 3
    \] 57
    \} 1197
    \> 25137))

(defn day10-part1
  {:test (fn []
           (is= (day10-part1 day10-example) 26397)
           (is= (day10-part1 day10-puzzle) 316851))}
  [text]
  (->> text
       (str/split-lines)
       (map corrupt-char)
       (remove nil?)
       (map score)
       (reduce +)))

(comment
  (time (day10-part1 day10-puzzle))
  ;"Elapsed time: 3.420333 msecs"
  ;=> 316851
  )
