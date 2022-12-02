(ns utils.text
  (:require [clojure.string :as str]))

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