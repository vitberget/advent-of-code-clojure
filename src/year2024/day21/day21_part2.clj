(ns year2024.day21.day21-part2
  (:require
    [utils.text :as ut]
    [year2024.day21.day21-data :refer [day21-example day21-puzzle]]
    [year2024.day21.day21-part1 :as part-1]
    [ysera.test :refer [is=]]))

; <vA <A A >>^A vA A <^A >A <v<A >>^A vA ^A <vA >^A <v<A >^A >A A vA ^A <v<A >A >^A A A vA <^A >A
; v   <  < A    >  > ^   A  <    A    >  A  v   A   <    ^   A  A >  A  <    v  A   A A >  ^   A

; v<<A >>^A <A >A vA <^A A >A <vA A A >^A
; <    A    ^  A  >  ^   ^ A  v   v v A

; <A ^A >^^A vvvA
; 0  2  9    A

; 029A

(defn split-into-a-parts
  {:test (fn[]
           (is= (split-into-a-parts "<<A>>AvvA") ["<<A" ">>A" "vvA"]))}
  [line]
  (->> line
       (ut/split-on #"A")
       (map (fn[p] (str p "A")))))

;     +---+---+
;     | ^ | A |
; +---+---+---+
; | < | v | > |
; +---+---+---+

(def short-pair-map 
  {[\> \A] "^A"
   [\> \v] "<A"
   [\> \^] "^<A" ; best?
   [\> \<] "<<A"
   [\> \>] "A"

   [\< \A] ">>^A"
   [\< \v] ">A"
   [\< \^] ">^A"
   [\< \<] "A"
   [\< \>] ">>A"

   [\v \A] ">^A" ; best?
   [\v \v] "A"
   [\v \^] "^A"
   [\v \<] "<A"
   [\v \>] ">A"

   [\^ \A] ">A"
   [\^ \v] "vA"
   [\^ \^] "A"
   [\^ \<] "v<A"
   [\^ \>] "v>A"

   [\A \A] "A"
   [\A \v] "v<A" ; best?
   [\A \^] "<A" 
   [\A \<] "v<<A" ; probably best
   [\A \>] "vA" })

(defn shortest-robot
  {:test (fn []
           (is= (shortest-robot "A") (list "A"))
           (is= (shortest-robot ">A") (list "vA" "^A"))
           (is= (shortest-robot ">>A") (list "vA" "A" "^A")))}
  [part]
  (let [part (str "A" part)]
    (->> part
         (partition 2 1)
         (map (fn[pair] (get short-pair-map pair))))))

(def shortest-robot-memoized (memoize shortest-robot))

(def calculate-complexity-on-numberic-part
  (fn [part robots]
    (if (zero? robots)
      (count part)
      (->> part 
           (shortest-robot-memoized)
           (map (fn[part] (calculate-complexity-on-numberic-part part (dec robots))))
           (reduce +)))))

(def inner-thingies (memoize (fn [inner-movements robots]
                               (->> inner-movements
                                    (map (fn [parts]
                                           (->> parts 
                                                (pmap (fn [part] (calculate-complexity-on-numberic-part part robots)))
                                                (reduce +))))
                                    (reduce min)))))

(defn day21-part2
  {:test (fn [] (is= (day21-part2 day21-example 2) 126384))}
  [text robots]
  (let [numberic-movements (->> text
                                (ut/text->lines)
                                (map (fn [line] [(part-1/numberic-part line) 
                                                 (as-> line $ 
                                                   ; (numberic-movements $)
                                                   (part-1/codes->paths $ part-1/numeric-coordinates)
                                                   (map split-into-a-parts $)
                                                   )])))]  
    (->> numberic-movements
         (pmap (fn [[n inner-movements]] [n (inner-thingies inner-movements robots)]))
         (map (fn [[n1 n2]] (* n1 n2)))
         (reduce +))))

(comment
  (time (day21-part2 day21-puzzle 2))
  ;
  )
