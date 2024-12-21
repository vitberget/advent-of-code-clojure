(ns year2024.day21.day21-part1
  (:require
    [clojure.edn :as edn]
    [clojure.set :as set]
    [utils.numbers :as un]
    [utils.text :as ut]
    [year2024.day21.day21-data :refer [day21-example day21-puzzle]]
    [ysera.test :refer [is=]]))

; +---+---+---+
; | 7 | 8 | 9 |
; +---+---+---+
; | 4 | 5 | 6 |
; +---+---+---+
; | 1 | 2 | 3 |
; +---+---+---+
;     | 0 | A |
;     +---+---+

(def numeric-coordinates 
  {\7 [0 0] \8 [1 0] \9 [2 0]
   \4 [0 1] \5 [1 1] \6 [2 1]
   \1 [0 2] \2 [1 2] \3 [2 2]
   :n [0 3] \0 [1 3] \A [2 3]})

;     +---+---+
;     | ^ | A |
; +---+---+---+
; | < | v | > |
; +---+---+---+

(def directional-coordinates
  {:n [0 0] \^ [1 0] \A [2 0]
   \< [0 1] \v [1 1] \> [2 1]})

(defn coords->paths 
  [[sx sy :as start] [ex ey :as end] prohibited]
  (let [dx (- ex sx)
        dy (- ey sy)
        dx-normal (un/limit dx -1 1)
        dy-normal (un/limit dy -1 1)]
    (cond  
      (= start end) #{}
      (and (zero? dy) (= (abs dx) 2)) #{ [start [(+ sx dx-normal) sy] end] }
      (and (zero? dy) (= (abs dx) 1)) #{ [start end] }

      (and (zero? dx) (= (abs dy) 3)) #{ [start [sx (+ sy dy-normal)] [sx (+ sy dy-normal dy-normal)] end] }
      (and (zero? dx) (= (abs dy) 2)) #{ [start [sx (+ sy dy-normal)] end] }
      (and (zero? dx) (= (abs dy) 1)) #{ [start end] }

      :else 
      (let [next-1 [(+ sx dx-normal) sy]
            next-2 [sx (+ sy dy-normal)]
            next-set-1 (if (= next-1 prohibited)
                         #{}
                         (coords->paths next-1 end prohibited))
            next-set-2 (if (= next-2 prohibited)
                         #{}
                         (coords->paths next-2 end prohibited))
            next-set-1 (->> next-set-1
                            (map (fn [lst] (cons start lst))) 
                            (into #{}))
            next-set-2 (->> next-set-2
                            (map (fn [lst] (cons start lst))) 
                            (into #{}))]
        (set/union next-set-1 next-set-2)) )))

(defn coords->chars
  [lst]
  (->> lst
       (partition 2 1)
       (map (fn [[start end]] (mapv - end start)))
       (map (fn [step] (condp = step
                         [1 0] \>
                         [-1 0] \<
                         [0 1] \v
                         [0 -1] \^)))
       (apply str)))

(defn keys->paths
  {:test (fn []
           (is= (keys->paths \7 \7 numeric-coordinates) #{})
           (is= (keys->paths \7 \9 numeric-coordinates) #{">>"})
           (is= (keys->paths \< \> directional-coordinates) #{">>"})
           (is= (keys->paths \9 \7 numeric-coordinates) #{"<<"})
           (is= (keys->paths \3 \9 numeric-coordinates) #{"^^"})
           (is= (keys->paths \7 \5 numeric-coordinates) #{"v>" ">v"})
           (is= (keys->paths \1 \0 numeric-coordinates) #{">v"}))}
  [start end coordinates]
  (->> (coords->paths (get coordinates start)
                      (get coordinates end)
                      (get coordinates :n))
       (map coords->chars)
       (into #{})))

(defn codes->paths
  [line coordinates]
  (let [parts (->> line
                   (cons \A)
                   (partition 2 1)
                   (map (fn [[start end]] 
                          (keys->paths start end coordinates))))]
    (loop [paths nil
           [part & parts] parts]
      (cond 
        (nil? part)
        paths

        (nil? paths)
        (recur (->> part 
                    (map (fn [p] (str p "A")))) 
               parts) 

        :else
        (recur (->> paths
                    (mapcat (fn [path] 
                              (if (empty? part) 
                                (list (str path "A"))

                                (->> part
                                     (map (fn[p] (str path p "A"))))
                                ))))
               parts)))))

(defn all-the-way
  [line]
  (->> (codes->paths line numeric-coordinates)
       (mapcat (fn[line] (codes->paths line directional-coordinates)))
       (mapcat (fn[line] (codes->paths line directional-coordinates)))
       (map (fn [line] (count line)))
       (apply min)))

(defn numberic-part
  {:test (fn []
           (is= (numberic-part "029A") 29)
           (is= (numberic-part "980A") 980)
           (is= (numberic-part "179A") 179)
           (is= (numberic-part "456A") 456)
           (is= (numberic-part "379A") 379))}
  [line]
  (-> line
      (subs 0 3)
      (ut/strip-leading "0")
      (edn/read-string)))

(defn day21-part1
  {:test (fn [] (is= (day21-part1 day21-example) 126384))}
  [text]
  (->> text
       (ut/text->lines)
       (pmap (fn[line] [(all-the-way line) (numberic-part line)]))
       (pmap (fn[items] (apply * items)))
       (reduce +)))

(comment
  (time (day21-part1 day21-puzzle))
  ; (out) "Elapsed time: 15835.766156 msecs"
  ; 138764
  )
