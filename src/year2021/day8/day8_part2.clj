(ns year2021.day8.day8-part2
  (:require [ysera.test :refer [is is= is-not deftest]]
            [year2021.day8.day8-data :refer [day8-example day8-puzzle]]
            [year2021.day8.day8-part1 :refer [split-whitespace]]
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
                 (into-set "cagedb")  0
                 (into-set "eafb")    4
                 (into-set "ab")      1}))}
  [line]
  (let [sets (->> line
                  (str/trim)
                  (split-whitespace)
                  (map into-set))
        set-1 (first-in sets #(= 2 (count %)))              ; digit 1 is the only one with 2 segments
        set-4 (first-in sets #(= 4 (count %)))              ; digit 4 is the only one with 4 segments
        set-7 (first-in sets #(= 3 (count %)))              ; digit 7 is the only one with 3 segments
        set-8 (first-in sets #(= 7 (count %)))              ; digit 8 is the only one with 7 segments

        segments-5 (->> sets (filter #(= 5 (count %))))     ; digits 2,3,5 have 5 segments
        segments-6 (->> sets (filter #(= 6 (count %))))     ; digits 0,6,9 have 6 segments

        set-3 (first-in segments-5 #(subset? set-1 %))      ; digit 3 is the only of 2,3,5 that have the digit 1 segments in it
        segments-5 (->> segments-5 (remove #(= % set-3)))   ; remove digit 3 from the 5 segment collection

        set-6 (first-not-in segments-6 #(subset? set-7 %))  ; digit 6 is the only of 0,6,9 to not have digit 7 segments in it
        set-9 (first-in segments-6 #(subset? set-3 %))      ; digit 9 is the only of 0,6,9 to have all digit 3 segments in it
        set-0 (first-not-in segments-6 #(or (= % set-6)     ; digit 0 is the "remainder" of 0,6,9
                                            (= % set-9)))

        upper-right (apply disj set-1 set-6)                ; to remove the lower right segment from digit 1, subtract digit 6 segments from it, leaving only upper right
        set-2 (first-in segments-5 #(subset? upper-right %)) ; digit 2 is the only of of 2,5 to have the upper right segment
        set-5 (first-not-in segments-5 #(= % set-2))]       ; digit 5 is the only one left of 2,5
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
        numbers-sets (->> numbers-str
                          (split-whitespace)
                          (map into-set))]
    (->> numbers-sets
         (map #(get digits-sets %))
         (reduce (fn [accumulator digit-of-number] (+ (* accumulator 10)
                                                      digit-of-number))))))

(defn day8-part2
  {:test (fn []
           (is= (day8-part2 day8-example) 61229)
           (is= (day8-part2 day8-puzzle) 986034))}
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