(ns year2023.day12.day12-part1
  (:require
    [utils.text :refer [line->words split-on text->lines]]
    [year2023.day12.day12-data :refer [day12-example day12-puzzle]]
    [ysera.test :refer [is=]]
    [clojure.math.numeric-tower :as math]))

(defn line->record 
  [line]
  (let [[springs groups] (line->words line)]
    [springs
     (->> groups 
          (split-on #",") 
          (map read-string))] ))

(defn replace-char [n unknowns]
  (if (->> unknowns
           (dec)
           (math/expt 2)
           (bit-and n)
           (zero?))
    \.
    \# ))

(defn replace-springs 
  {:test (fn []
           (is= (replace-springs "???.###" 0 3) (list \. \. \. \. \# \# \#))
           (is= (replace-springs "???.###" 7 3) (list \# \# \# \. \# \# \#)))}
  [springs weh unknowns]
  (loop [result (list)
         [spring & springs] springs
         unknowns unknowns]
    (cond
      (nil? spring)
      (reverse result)

      (= spring \?)
      (recur (cons (replace-char weh unknowns) result) 
             springs 
             (dec unknowns))

      :else
      (recur (cons spring result)
             springs
             unknowns))))

(defn count-groups [springs]
  (loop [[spring & springs] springs
         current 0
         result (list) ]
    (cond
      (nil? spring)
      (if (zero? current)
        (reverse result)
        (reverse (cons current result)))

      (= \. spring)
      (recur springs
             0
             (if (zero? current)
               result
               (cons current result)))

      (= \# spring)
      (recur springs
             (inc current)
             result))))

(defn possible-arrangment? 
  [[springs groups] n unknowns]
  (let [replaced (replace-springs springs n unknowns)]
    (if (= groups (count-groups replaced))
      1
      0)))

(defn record->arrangments 
  {:test (fn[]
           (is= (record->arrangments (line->record "???.### 1,1,3")) 1)
           (is= (record->arrangments (line->record ".??..??...?##. 1,1,3")) 4)
           (is= (record->arrangments (line->record "?#?#?#?#?#?#?#? 1,3,1,6")) 1)
           (is= (record->arrangments (line->record "????.#...#... 4,1,1")) 1)
           (is= (record->arrangments (line->record "????.######..#####. 1,6,5")) 4)
           (is= (record->arrangments (line->record "?###???????? 3,2,1")) 10))} 
  [[spring _ :as record]]
  (let [unknowns (->> spring
                      (filter (fn [c] (= c \?)))
                      (count))
        unknowns-power (if (zero? unknowns)
                         0
                         (math/expt 2 unknowns))
        rng (range 0 unknowns-power)]
    (->> (for [n rng] (possible-arrangment? record n unknowns))
         (apply +))))

(defn day12-part1
  {:test (fn [] (is= (day12-part1 day12-example) 21))}
  [text]
  (->> text
       (text->lines)
       (map line->record)
       (map record->arrangments)
       (apply +)))

(comment
  (time (day12-part1 day12-puzzle))
  ; (out) "Elapsed time: 20019.11688 msecs"
  ; 8022
  )
