(ns year2021.day8.day8-part2
  (:require [ysera.test :refer [is is= is-not deftest]]
            [year2021.day8.day8-data :refer [day8-example day8-puzzle]]
            [clojure.set :refer [subset?]]
            [clojure.string :as str]))

(defn first-in
  [collection filter-fn]
  (->> collection
       (filter filter-fn)
       (first)))

(defn first-not-in
  [collection remove-fn]
  (->> collection
       (remove remove-fn)
       (first)))

(def into-set (partial into #{}))

(defn parse-the-digits
  {:test (fn []
           (is= (parse-the-digits "acedgfb cdfbe gcdfa fbcad dab cefabd cdfgeb eafb cagedb ab")
                {(into-set "acedgfb") 8
                 (into-set "cdfbe")   5
                 (into-set "gcdfa")   2
                 (into-set "fbcad")   3
                 (into-set "dab")     7
                 (into-set "cefabd")  9
                 (into-set "cdfgeb")  6
                 (into-set "eafb")    4
                 (into-set "cagedb")  0
                 (into-set "ab")      1}))}
  [line]
  (let [sets (as-> line $
                   (str/trim $)
                   (str/split $ #"\s+")
                   (map into-set $))
        set-1 (first-in sets #(= 2 (count %)))
        set-4 (first-in sets #(= 4 (count %)))
        set-7 (first-in sets #(= 3 (count %)))
        set-8 (first-in sets #(= 7 (count %)))

        length-5 (->> sets (filter #(= 5 (count %))))
        length-6 (->> sets (filter #(= 6 (count %))))

        set-3 (first-in length-5 #(subset? set-1 %))

        set-6 (first-not-in length-6 #(subset? set-7 %))
        set-9 (first-in length-6 #(subset? set-3 %))
        set-0 (first-not-in length-6 #(or (= % set-6)
                                          (= % set-9)))

        upper-right (apply disj set-1 set-6)
        length-5 (->> length-5 (remove #(= % set-3)))

        set-2 (first-in length-5 #(subset? upper-right %))
        set-5 (first-not-in length-5 #(= % set-2))]
    {set-0 0 set-1 1 set-2 2 set-3 3 set-4 4 set-5 5 set-6 6 set-7 7 set-8 8 set-9 9}))

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
  (let [[digits-str numbers-str] (str/split line #" \| ")
        digits-sets (parse-the-digits digits-str)
        numbers-sets (as-> numbers-str $
                           (str/split $ #"\s+")
                           (map into-set $))]
    (->> numbers-sets
         (map (fn [s] (get digits-sets s)))
         (reduce (fn [accumulator digit-of-number] (+ (* accumulator 10)
                                                      digit-of-number))))))

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