(ns year2021.day8.day8-part2
  (:require [ysera.test :refer [is is= is-not deftest]]
            [year2021.day8.day8-data :refer [day8-example day8-puzzle]]
            [clojure.set :refer [subset?]]
            [clojure.string :as str]))

(defn parse-the-digits
  {:test (fn []
           (is= (parse-the-digits "acedgfb cdfbe gcdfa fbcad dab cefabd cdfgeb eafb cagedb ab")
                {(into #{} "acedgfb") 8
                 (into #{} "cdfbe")   5
                 (into #{} "gcdfa")   2
                 (into #{} "fbcad")   3
                 (into #{} "dab")     7
                 (into #{} "cefabd")  9
                 (into #{} "cdfgeb")  6
                 (into #{} "eafb")    4
                 (into #{} "cagedb")  0
                 (into #{} "ab")      1}))}
  [line]
  (let [sets (as-> line $
                   (str/trim $)
                   (str/split $ #"\s+")
                   (map (fn [word] (into #{} word)) $))
        s1 (first (filter (fn [s] (= 2 (count s))) sets))
        s4 (first (filter (fn [s] (= 4 (count s))) sets))
        s7 (first (filter (fn [s] (= 3 (count s))) sets))
        s8 (first (filter (fn [s] (= 7 (count s))) sets))
        l5s (filter (fn [s] (= 5 (count s))) sets)
        l6s (filter (fn [s] (= 6 (count s))) sets)
        s3 (first (filter (fn [s] (subset? s1 s)) l5s))

        s6 (first (filter (fn [s] (not (subset? s7 s))) l6s))
        s9 (first (filter (fn [s] (subset? s3 s)) l6s))
        s0 (first (filter (fn [s] (not (or (= s s6) (= s s9)))) l6s))
        upper-right (apply disj s1 s6)

        l5s (filter (fn [s] (not (= s s3))) l5s)
        s2 (first (filter (fn [s] (subset? upper-right s)) l5s))
        s5 (first (filter (fn [s] (not (= s s2))) l5s))]
    {s1 1 s4 4 s7 7 s8 8 s3 3 s6 6 s9 9 s0 0 s2 2 s5 5}))

(defn calc-line
  {:test (fn []
           (is= (calc-line "acedgfb cdfbe gcdfa fbcad dab cefabd cdfgeb eafb cagedb ab | cdfeb fcadb cdfeb cdbaf") 5353)
           (is= (calc-line "be cfbegad cbdgef fgaecd cgeb fdcge agebfd fecdb fabcd edb | fdgacbe cefdb cefbgd gcbe") 8394)
           (is= (calc-line "edbfga begcd cbg gc gcadebf fbgde acbgfd abcde gfcbed gfec | fcgedb cgb dgebacf gc") 9781)
           (is= (calc-line "fgaebd cg bdaec gdafb agbcfd gdcbef bgcad gfac gcb cdgabef | cg cg fdcagb cbg") 1197)
           (is= (calc-line "fbegcd cbd adcefb dageb afcb bc aefdc ecdab fgdeca fcdbega | efabcd cedba gadfec cb") 9361)
           (is= (calc-line "aecbfdg fbg gf bafeg dbefa fcge gcbea fcaegb dgceab fcbdga | gecf egdcabf bgf bfgea") 4873)
           (is= (calc-line "fgeab ca afcebg bdacfeg cfaedg gcfdb baec bfadeg bafgc acf | gebdcfa ecba ca fadegcb") 8418)
           (is= (calc-line "dbcfg fgd bdegcaf fgec aegbdf ecdfab fbedc dacgb gdcebf gf | cefg dcbef fcge gbcadfe") 4548)
           (is= (calc-line "bdfegc cbegaf gecbf dfcage bdacg ed bedf ced adcbefg gebcd | ed bcgafe cdgba cbgef") 1625)
           (is= (calc-line "egadfb cdbfeg cegd fecab cgb gbdefca cg fgcdab egfdb bfceg | gbdfcae bgc cg cgb") 8717)
           (is= (calc-line "gcafb gcf dcaebfg ecagb gf abcdeg gaef cafbge fdbac fegbdc | fgae cfgab fg bagce") 4315))}
  [line]
  (let [[digitstr numstr] (str/split line #" \| ")
        digits (parse-the-digits digitstr)
        numsets (as-> numstr $
                      (str/split $ #"\s+")
                      (map (fn[s] (into #{} s)) $))]
    (->> numsets
          (map (fn [s] (get digits s)))
          (reduce (fn [a v] (+ (* a 10) v))))))

(defn day8-part2
  {:test (fn []
           (is= (day8-part2 day8-example) 61229))}
  [text]
  (->> text
        (str/split-lines)
        (map calc-line)
        (reduce +)))


(comment
  (time (day8-part2 day8-puzzle))
  ;"Elapsed time: 15.37999 msecs"
  ;=> 986034
  )