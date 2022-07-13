(ns year2021.day18.day18-part1
  (:require [ysera.test :refer [is is= is-not deftest]]
            [year2021.day18.day18-data :refer [day18-example day18-puzzle]]
            [clojure.string :as str]))

(defn char->int-or-char
  [char]
  (if (Character/isDigit ^char char)
    (Character/getNumericValue ^char char)
    char))

(defn string->state
  {:test (fn []
           (is= (string->state "[1,2]")
                [\[ 1 2 \]])
           (is= (string->state "[[1,2],3]")
                [\[ \[ 1 2 \] 3 \]])
           )}
  [string]
  (->> string
       (map identity)
       (remove (fn [c] (= c \,)))
       (map char->int-or-char)))

; To explode a pair, the pair's left value is added to the first regular number
; to the left of the exploding pair (if any), and the pair's right value is
; added to the first regular number to the right of the exploding pair (if any).
; Exploding pairs will always consist of two regular numbers. Then, the entire
; exploding pair is replaced with the regular number 0.

(defn do-explode-right
  ([after d2]
   (do-explode-right after d2 \]))
  ([after d2 check-sign]
   (loop [result []
          [c & after] after]
     (cond
       (nil? c)
       result

       (and (empty? result)
            (= c check-sign))
       (recur
         (-> result
             (conj 0)
             (conj c))
         after)

       (number? c)
       (concat result
               (list (+ c d2))
               after)

       :else
       (recur (conj result c)
              after)))))

(defn do-explode-left
  [before d1]
  (-> before
      (reverse)
      (do-explode-right d1 \[)
      (reverse)))

(defn do-explode
  [before after]
  (let [[d1 d2 _ & after] after]
    (concat (do-explode-left before d1)
            (do-explode-right after d2))))

; If any pair is nested inside four pairs, the leftmost such pair explodes.

(defn explode
  {:test (fn []
           (is= (explode (string->state "[[1,2],3]"))
                (string->state "[[1,2],3]"))
           (is= (explode (string->state "[[[[[9,8],1],2],3],4]"))
                (string->state "[[[[0,9],2],3],4]"))
           (is= (explode (string->state "[7,[6,[5,[4,[3,2]]]]]"))
                (string->state "[7,[6,[5,[7,0]]]]"))
           (is= (explode (string->state "[[3,[2,[1,[7,3]]]],[6,[5,[4,[3,2]]]]]"))
                (string->state "[[3,[2,[8,0]]],[9,[5,[4,[3,2]]]]]"))
           )}
  [state]
  (loop [before []
         [c & after] state
         depth 0]
    (cond
      (nil? c)
      state

      (and (= \[ c) (< depth 4))
      (recur (conj before c)
             after
             (inc depth))

      (= \] c)
      (recur (conj before c)
             after
             (dec depth))

      (= \[ c)
      (do-explode before after)

      :else
      (recur (conj before c)
             after
             depth))))

; To split a regular number, replace it with a pair; the left element
; of the pair should be the regular number divided by two and rounded down,
; while the right element of the pair should be the regular number divided
; by two and rounded up. For example,
; 10 becomes [5,5],
; 11 becomes [5,6],
; 12 becomes [6,6], and so on.

(defn split-number
  {:test (fn []
           (is= (split-number 10) (string->state "[5,5]"))
           (is= (split-number 11) (string->state "[5,6]"))
           (is= (split-number 12) (string->state "[6,6]")))}
  [num]
  (let [n1 (-> num
               (/ 2)
               (int))
        n2 (if (odd? num)
             (inc n1)
             n1)]
    (list \[ n1 n2 \])))

(defn split
  {:test (fn []
           (is= (split (string->state "[[1,2],3]"))
                (string->state "[[1,2],3]"))
           (is= (split (list \[ \[ \[ \[ 0 7 \] 4 \] \[ 15 \[ 0 13 \] \] \] \[ 1 1 \] \]))
                (list \[ \[ \[ \[ 0 7 \] 4 \] \[ \[ 7 8 \] \[ 0 13 \] \] \] \[ 1 1 \] \]))
           (is= (split (list \[ \[ \[ \[ 0 7 \] 4 \] \[ \[ 7 8 \] \[ 0 13 \] \] \] \[ 1 1 \] \]))
                (string->state "[[[[0,7],4],[[7,8],[0,[6,7]]]],[1,1]]")))}
  [state]
  (loop [before []
         [c & after] state]
    (cond
      (nil? c)
      state

      (and (number? c) (> c 9))
      (concat before (split-number c) after)

      :else
      (recur (conj before c)
             after))))

(defn add-numbers
  {:test (fn []
           (is= (add-numbers (string->state "[[[[4,3],4],4],[7,[[8,4],9]]]")
                             (string->state "[1,1]"))
                (string->state "[[[[0,7],4],[[7,8],[6,0]]],[8,1]]"))
           (is= (add-numbers (string->state "[[[0,[4,5]],[0,0]],[[[4,5],[2,6]],[9,5]]]")
                             (string->state "[7,[[[3,7],[4,3]],[[6,3],[8,8]]]]"))
                (string->state "[[[[4,0],[5,4]],[[7,7],[6,0]]],[[8,[7,7]],[[7,9],[5,0]]]]"))
           )}
  [n1 n2]
  (loop [state (concat (list \[) n1 n2 (list \]))]
    (let [new-state (explode state)]
      (if (not= new-state state)
        (recur new-state)
        (let [new-state (split state)]
          (if (not= new-state state)
            (recur new-state)
            state))))))

(defn score-simplify
  [state]
  (loop [before []
         c0 (nth state 0)
         c1 (nth state 1)
         c2 (nth state 2)
         c3 (nth state 3)
         after (drop 4 state)]
    (if (and (= \[ c0)
             (number? c1)
             (number? c2)
             (= \] c3))
      (concat before [(+ (* 3 c1) (* 2 c2))] after)
      (recur (conj before c0)
             c1
             c2
             c3
             (first after)
             (rest after)))))

(defn score
  {:test (fn []
           (is= (score (string->state "[[1,2],[[3,4],5]]")) 143)
           (is= (score (string->state "[9,1]")) 29)
           (is= (score (string->state "[1,9]")) 21)
           )}
  [state]
  (loop [state state]
    (if (= 1 (count state))
      (first state)
      (recur (score-simplify state)))))

(defn day18-part1
  {:test (fn []
           (is= (day18-part1 day18-example) 3488)
           )}
  [text]
  (->> text
       (str/split-lines)
       (map string->state)
       (reduce add-numbers)
       (score)))

  (comment
    (time (day18-part1 day18-puzzle))
    ; "Elapsed time: 292.688577 msecs"
    ;=> 4184
    )
