(ns year2023.day19.day19-part1
  (:require
   [utils.text :refer [split-on text->lines text->paragraphs]]
   [year2023.day19.day19-data :refer [day19-example day19-puzzle]]
   [ysera.test :refer [is=]]
   [clojure.string :as str]))

(defn part->rule 
  [part]
  (if (str/includes? part ":")
    (let [[_ thing operator value target] (re-matches #"(\w+)([<>])(\d+):(.*)" part)]
      [(keyword thing) 
       (-> operator (symbol) (resolve)) 
       (read-string value) 
       (keyword target)])
    (keyword part)))

(defn line->rule 
  [line]
  (let [[_ the-name rules ] (re-matches #"([a-z]+)\{(.*)\}" line)
        rules (split-on #"," rules)]
    {(keyword the-name) (map part->rule rules)}))

(defn text->rules-and-ratings 
  [text]
  (let [[rules ratings] (text->paragraphs text)]
    {:ratings (->> ratings
                   (text->lines)
                   (map (fn [line] (str/replace line "=" " ")))
                   (map (fn [line] (str/replace line #"([a-z])" ":$1")))
                   (map read-string)) 
     :rules (->> rules
                 (text->lines)
                 (map line->rule)
                 (reduce merge))}))

(defn get-next-target 
  [rating rule]
  (loop [[part & rule] rule]
    (if (keyword? part)
      part
      (let [[thing operator value target] part]
        (if (operator (get rating thing) value)
          target
          (recur rule))))))

(defn acceptable-rating? 
  [rating rules]
  (loop [current-rule :in]
    (cond
      (= :A current-rule) true
      (= :R current-rule) false
      :else (recur (get-next-target rating (get rules current-rule))))))

(defn day19-part1
  {:test (fn [] 
           (is= (day19-part1 day19-example) 19114)
           (is= (day19-part1 day19-puzzle) 449531))}
  [text]
  (let [{rules :rules ratings :ratings} (text->rules-and-ratings text)]
    (->> ratings
         (filter (fn[rating] (acceptable-rating? rating rules)))
         (map vals)
         (flatten)
         (reduce +))))

(comment
  (time (day19-part1 day19-puzzle))
  ; (out) "Elapsed time: 3.429155 msecs"
  ; 449531
  )
