(ns year2021.day10.day10-part2
  (:require [ysera.test :refer [is is= is-not deftest]]
            [year2021.day10.day10-data :refer [day10-example day10-puzzle]]
            [year2021.day10.day10-part1 :refer [left? matching?]]
            [clojure.string :as str]))

(defn char->opposite-char
  [char]
  (condp = char
    \( \)
    \[ \]
    \{ \}
    \< \>))

(defn line->completion
  {:test (fn []
           (is= (line->completion "{([(<{}[<>[]}>{[]{[(<()>") nil)
           (is= (line->completion "[[<[([]))<([[{}[[()]]]") nil)
           (is= (line->completion "[{[{({}]{}}([{[{{{}}([]") nil)
           (is= (line->completion "[<(<(<(<{}))><([]([]()") nil)
           (is= (line->completion "<{([([[(<>()){}]>(<<{{") nil)

           (is= (apply str (line->completion "[({(<(())[]>[[{[]{<()<>>")) "}}]])})]")
           (is= (apply str (line->completion "[(()[<>])]({[<{<<[]>>(")) ")}>]})")
           (is= (apply str (line->completion "(((({<>}<{<{<>}{[]{[]{}")) "}}>}>))))")
           (is= (apply str (line->completion "{<[[]]>}<{[{[{[]{()[[[]")) "]]}}]}]}>")
           (is= (apply str (line->completion "<{([{{}}[<[[[<>{}]]]>[]]")) "])}>"))}
  [line]
  (loop [[char & line] line
         stack (list)]
    (cond (nil? char)
          (map char->opposite-char stack)

          (left? char)
          (recur line (conj stack char))

          (matching? (first stack) char)
          (recur line (rest stack))

          :or-else nil)))

(defn score-char
  [char] (condp = char
           \) 1
           \] 2
           \} 3
           \> 4))

(defn score-completion
  {:test (fn []
           (let [help-fn (fn [txt] (->> (str/split txt #"")
                                        (map first)
                                        (into (list))
                                        (reverse)))]
             (is= (score-completion (help-fn "}}]])})]")) 288957)
             (is= (score-completion (help-fn ")}>]})")) 5566)
             (is= (score-completion (help-fn "}}>}>))))")) 1480781)
             (is= (score-completion (help-fn "]]}}]}]}>")) 995444)
             (is= (score-completion (help-fn "])}>")) 294)))}
  [completion]
  (reduce (fn [accumulator char]
            (+ (* accumulator 5)
               (score-char char)))
          0
          completion))

(defn middle-score
  {:test (fn []
           (is= (middle-score (list 288957 5566 1480781 995444 294))
                288957))}
  [numbers]
  (nth (sort numbers) (-> numbers
                          (count)
                          (/ 2))))

(defn day10-part2
  {:test (fn []
           (is= (day10-part2 day10-example) 288957)
           (is= (day10-part2 day10-puzzle) 2182912364))}
  [text]
  (->> text
       (str/split-lines)
       (map line->completion)
       (remove nil?)
       (map score-completion)
       (middle-score)))

(comment
  (time (day10-part2 day10-puzzle))
  ;"Elapsed time: 3.647391 msecs"
  ;=> 2182912364
  )