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

(defn line->corrupt-char
  {:test (fn []
           (is= (line->corrupt-char "([<>]}") \})
           (is= (line->corrupt-char "{([(<{}[<>[]}>{[]{[(<()>") \})
           (is= (line->corrupt-char "[[<[([]))<([[{}[[()]]]") \))
           (is= (line->corrupt-char "[{[{({}]{}}([{[{{{}}([]") \])
           (is= (line->corrupt-char "[<(<(<(<{}))><([]([]()") \))
           (is= (line->corrupt-char "<{([([[(<>()){}]>(<<{{") \>)
           (is= (line->corrupt-char "[({(<(())[]>[[{[]{<()<>>") nil)
           (is= (line->corrupt-char "[(()[<>])]({[<{<<[]>>(") nil)
           (is= (line->corrupt-char "(((({<>}<{<{<>}{[]{[]{}") nil)
           (is= (line->corrupt-char "{<[[]]>}<{[{[{[]{()[[[]") nil)
           (is= (line->corrupt-char "<{([{{}}[<[[[<>{}]]]>[]]") nil))}
  [line]
  (loop [[char & line] line
         stack (list)]
    (cond (nil? char)
          nil

          (left? char)
          (recur line (conj stack char))

          (matching? (first stack) char)
          (recur line (rest stack))

          :or-else char)))

(defn score-char
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
       (map line->corrupt-char)
       (remove nil?)
       (map score-char)
       (reduce +)))

(comment
  (time (day10-part1 day10-puzzle))
  ;"Elapsed time: 3.420333 msecs"
  ;=> 316851
  )
