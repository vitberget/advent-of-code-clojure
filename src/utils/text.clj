(ns utils.text
  (:require [clojure.string :as str]
            [ysera.test :refer [is is= is-not deftest]]))

(defn text->paragraphs
  [text]
  (str/split text #"\n\n"))

(defn text->lines
  [text]
  (str/split-lines text))

(defn text->numbers
  [text]
  (->> text
       (str/split-lines)
       (map read-string)))

(defn line->words
  [line]
  (str/split line #" "))

(defn line->halves
  {:test (fn []
           (is= (line->halves "abc123") ["abc" "123"])
           )}
  [line]
  (let [len (-> line
                (count)
                (/ 2))]
    [(subs line 0 len) (subs line len)]))