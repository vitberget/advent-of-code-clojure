(ns year2021.day10.day10-part2
  (:require [ysera.test :refer [is is= is-not deftest]]
            [year2021.day10.day10-data :refer [day10-example day10-puzzle]]
            [year2021.day10.day10-part1 :refer [left? matching?]]
            [clojure.string :as str]))

(defn turn-around
  [char]
  (condp = char
    \( \)
    \[ \]
    \{ \}
    \< \>))

(defn complete-string
  {:test (fn []
           (is= (complete-string "{([(<{}[<>[]}>{[]{[(<()>") nil)
           (is= (complete-string "[[<[([]))<([[{}[[()]]]") nil)
           (is= (complete-string "[{[{({}]{}}([{[{{{}}([]") nil)
           (is= (complete-string "[<(<(<(<{}))><([]([]()") nil)
           (is= (complete-string "<{([([[(<>()){}]>(<<{{") nil)

           (is= (apply str (complete-string "[({(<(())[]>[[{[]{<()<>>")) "}}]])})]")
           (is= (apply str (complete-string "[(()[<>])]({[<{<<[]>>(")) ")}>]})")
           (is= (apply str (complete-string "(((({<>}<{<{<>}{[]{[]{}")) "}}>}>))))")
           (is= (apply str (complete-string "{<[[]]>}<{[{[{[]{()[[[]")) "]]}}]}]}>")
           (is= (apply str (complete-string "<{([{{}}[<[[[<>{}]]]>[]]")) "])}>"))}
  [line]
  (loop [[char & line] line
         stack (list)]
    (let [top (first stack)]
      (cond (nil? char)
            (map turn-around stack)

            (left? char)
            (recur line (conj stack char))

            (matching? top char)
            (recur line (rest stack))

            :wrong-char nil))))

(defn score
  {:test (fn []
           (let [sfn (fn [txt] (->> (str/split txt #"")
                                    (map first)
                                    (into (list))
                                    (reverse)))]
             (is= (score (sfn "}}]])})]")) 288957)
             (is= (score (sfn ")}>]})")) 5566)
             (is= (score (sfn "}}>}>))))")) 1480781)
             (is= (score (sfn "]]}}]}]}>")) 995444)
             (is= (score (sfn "])}>")) 294)))}
  [completion]
  (reduce (fn [a v]
            (+ (* a 5)
               (condp = v
                 \) 1
                 \] 2
                 \} 3
                 \> 4)))
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
       (map complete-string)
       (remove nil?)
       (map score)
       (middle-score)))

(comment
  (time (day10-part2 day10-puzzle))
  ;"Elapsed time: 3.647391 msecs"
  ;=>
  )