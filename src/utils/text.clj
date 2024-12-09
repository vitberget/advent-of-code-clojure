(ns utils.text
  (:require [clojure.string :as str]
            [ysera.test :refer [is is= is-not]]))

(defn text->paragraphs
  [text]
  (str/split text #"\n\n"))

(defn text->lines
  [text]
  (str/split-lines text))

(defn text->rows
  {:test (fn []
           (is= (text->rows "123") ["1" "2" "3"])
           (is= (text->rows "123\nABC") ["1A" "2B" "3C"])
           (is= (text->rows "123\nABC\n456") ["1A4" "2B5" "3C6"]))}
  [text]
  (let [lines (text->lines text)]
    (->> (partition (count lines) (apply interleave lines))
         (map (fn [chrs] (apply str chrs))))))

(defn text->numbers
  [text]
  (->> text
       (str/split-lines)
       (map read-string)))

(defn line->words
  [line]
  (str/split line #" +"))

(defn line->halves
  {:test (fn [] (is= (line->halves "abc123") ["abc" "123"]))}
  [line]
  (let [len (-> line
                (count)
                (/ 2))]
    [(subs line 0 len) (subs line len)]))

(defn split-on
  [regex text]
  (str/split text regex))

(defn has-content
  {:test (fn []
           (is-not (has-content nil))
           (is-not (has-content ""))
           (is-not (has-content "  "))
           (is (has-content "abc"))
           (is (has-content " abc  ")))}
  [string]
  (when string
    (->> string
         (.trim)
         (.isEmpty)
         (not))))

(defn char->number
  [char]
  (- (int char) (int \0)))


(defn digit? [c] 
  (and (>= 0 (compare \0 c)) 
       (>= 0 (compare c \9))))

(defn lowercase-char->hex-number
  {:test (fn []
           (is= (lowercase-char->hex-number \0) 0)
           (is= (lowercase-char->hex-number \3) 3)
           (is= (lowercase-char->hex-number \9) 9)
           (is= (lowercase-char->hex-number \a) 10)
           (is= (lowercase-char->hex-number \f) 15))}
  [ch]
  (if (digit? ch)
    (char->number ch) 
    (+ 10 (- (int ch) (int \a)))))

(defn line->numbers
  {:test (fn[] 
           (is= (line->numbers "1 2 3") [1 2 3])
           (is= (line->numbers "1   2   3") [1 2 3]))}
  [line]
  (->> line
       (split-on #" +")
       (map read-string)))

(defn line->digits
  {:test (fn[] 
           (is= (line->digits "123") [1 2 3])
           (is= (line->digits "1299") [1 2 9 9]))}
  [line]
  (->> line
       (map char->number)))

(defn reverse-str
  {:test (fn[]
           (is= (reverse-str "ABC") "CBA"))}
  [text]
  (->> text
       (reverse)
       (apply str)))
