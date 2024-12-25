(ns year2024.day21.day21-part2
  (:require
    [utils.text :as ut]
    [year2024.day21.day21-data :refer [day21-example day21-puzzle]]
    [year2024.day21.day21-part1 :as part-1]
    [ysera.test :refer [is=]]))

(defn split-into-a-parts
  {:test (fn[] (is= (split-into-a-parts "<<A>>AvvA") ["<<A" ">>A" "vvA"]))}
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
   ; [\> \^] "^<A" ; best?
   [\> \^] "<^A" ; best?
   [\> \<] "<<A"
   [\> \>] "A"

   [\< \A] ">>^A"
   [\< \v] ">A"
   [\< \^] ">^A"
   [\< \<] "A"
   [\< \>] ">>A"

   ; [\v \A] ">^A" ; best?
   [\v \A] "^>A" ; best?
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
   ; [\A \v] "v<A" ; best?
   [\A \v] "<vA" ; best?
   [\A \^] "<A" 
   [\A \<] "v<<A" ; probably best
   [\A \>] "vA" })


(def calculate-complexity-part 
  (memoize 
    (fn [part robots]
      (if (zero? robots)
        (count part)
        (->> part
             (cons \A)
             (partition 2 1)
             (map short-pair-map)
             (map (fn [part] (calculate-complexity-part part (dec robots))))
             (reduce +))))))


(defn calculate-complexity 
  [movment robots]
  (->> movment
       (map (fn [part] (calculate-complexity-part part robots)))
       (reduce +)))

(defn inner-thingies
  [movement robots]
  (->> movement 
       (map (fn[movement] (calculate-complexity movement robots)))
       (reduce min)))

(defn day21-part2
  {:test (fn [] (is= (day21-part2 day21-example 2) 126384))}
  [text robots]
  (let [numberic-movements (->> text
                                (ut/text->lines)
                                (map (fn [line] [(part-1/numberic-part line) 
                                                 (as-> line $ 
                                                   (part-1/codes->paths $ part-1/numeric-coordinates)
                                                   (map split-into-a-parts $))])))]  
    (->> numberic-movements
         (map (fn [[n inner-movements]] [n (inner-thingies inner-movements robots)]))
         (map (fn [[n1 n2]] (* n1 n2)))
         (reduce +))))

(comment
  (time (day21-part2 day21-puzzle 2))
  ; "Elapsed time: 19.020317 msecs"
  ; 169137886514152
  )
