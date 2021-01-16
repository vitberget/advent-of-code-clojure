(ns day12.day12part2
  (:require [ysera.test :refer [is is= is-not]]
            [clojure.string :as str]))

(defn abs [n] (if (neg? n) (- n) n))

(defn west [state num] (update-in state [:wp :x] - num))
(defn east [state num] (update-in state [:wp :x] + num))
(defn north [state num] (update-in state [:wp :y] - num))
(defn south [state num] (update-in state [:wp :y] + num))

(defn forward
  [state num]
  (-> state
      (update-in [:ship :x] + (* num (get-in state [:wp :x])))
      (update-in [:ship :y] + (* num (get-in state [:wp :y])))))

(defn turn
  [state num update-fn]
  (loop [state state
         num num]
    (if (zero? num)
      state
      (recur (update state :wp update-fn)
             (- num 90)))))

(defn right
  [state num]
  (turn state num
        (fn [wp] {:x (- (:y wp))
                  :y (:x wp)})))

(defn left
  [state num]
  (turn state num
        (fn [wp] {:x (:y wp)
                  :y (- (:x wp))})))

(defn do-cmd
  [state line]
  (let [cmd (first line)
        number (read-string (subs line 1))]
    (condp = cmd
      \N (north state number)
      \S (south state number)
      \E (east state number)
      \W (west state number)
      \F (forward state number)
      \L (left state number)
      \R (right state number))))

(defn manhattan-distance
  [state]
  (->> state
       (:ship)
       (vals)
       (map abs)
       (reduce +)))

(defn day12part2
  {:test (fn []
           (is= (day12part2 "F10\nN3\nF7\nR90\nF11")
                286))}
  [string]
  (loop [state (-> {:wp   {:x 0 :y 0}
                    :ship {:x 0 :y 0}}
                   (east 10)
                   (north 1))
         [line & lines] (->> string
                             (str/split-lines))]
    (if (nil? line)
      (manhattan-distance state)
      (recur (do-cmd state line)
             lines))))

(comment
  (def puzzle "W2\nF23\nS1\nW3\nL180\nW3\nR90\nN4\nF17\nS4\nW4\nR90\nW4\nE1\nN4\nF5\nN2\nR90\nF43\nN5\nL90\nF12\nS4\nW1\nS3\nW2\nN4\nF76\nS1\nW4\nW2\nF20\nN4\nF81\nW4\nN3\nR180\nW2\nN4\nW3\nF16\nN4\nL180\nF1\nW3\nF34\nW3\nS3\nF92\nL90\nS2\nL90\nE5\nN2\nF85\nW3\nR90\nW2\nF88\nN2\nL90\nW1\nN4\nL90\nE5\nN3\nL90\nF8\nE1\nL90\nN3\nF3\nF61\nS5\nR90\nW2\nF84\nW1\nL90\nE1\nS3\nW5\nF89\nE3\nF67\nE2\nE5\nF29\nN5\nW4\nF53\nN2\nE5\nF73\nW4\nL90\nS2\nR180\nN3\nR90\nF27\nN2\nF41\nL270\nW5\nF3\nN5\nF81\nR90\nN2\nW5\nN2\nR90\nS1\nR180\nS3\nL90\nE2\nF38\nS1\nE3\nS5\nF44\nN1\nF26\nE1\nS2\nF25\nE1\nS2\nF33\nS4\nR90\nN2\nW2\nF9\nR90\nF64\nW1\nS3\nE5\nR180\nN2\nL90\nS4\nE4\nL90\nS2\nF50\nS3\nR90\nF8\nE2\nN1\nR90\nS5\nS1\nF100\nN3\nF97\nR180\nS3\nL180\nF45\nW5\nS1\nE5\nE3\nF26\nN4\nR90\nN4\nF50\nW5\nR90\nF58\nS4\nW3\nE1\nN3\nR90\nS4\nE2\nF26\nN4\nL90\nF60\nW4\nN1\nF10\nE5\nL180\nN4\nE1\nF15\nE3\nL270\nF23\nR90\nF61\nR90\nF25\nL90\nW2\nS3\nR180\nF44\nW5\nE1\nR90\nS2\nR270\nW2\nS1\nF13\nE5\nN2\nR270\nF68\nF99\nW1\nF31\nN5\nF89\nE5\nN4\nW5\nN2\nF59\nE3\nL180\nE3\nL90\nL180\nS5\nF27\nE1\nS3\nR180\nN5\nE4\nL180\nN2\nE3\nW1\nL180\nF23\nN4\nE1\nF87\nN1\nE3\nF45\nW5\nF17\nL90\nN1\nL90\nW3\nS2\nF62\nR180\nF8\nR90\nF19\nW1\nS2\nS5\nW4\nF40\nF52\nS3\nF6\nR90\nS5\nW3\nS5\nE3\nW3\nS1\nF11\nS2\nE4\nF3\nR90\nL270\nE1\nS1\nW4\nL180\nW2\nS4\nE2\nN3\nW3\nS2\nW4\nL90\nF24\nW3\nF58\nE5\nR90\nF73\nE4\nF92\nR90\nF62\nW4\nR90\nW2\nS3\nW2\nF75\nN4\nR180\nW5\nS5\nW1\nS2\nL90\nS1\nE5\nL180\nN3\nW3\nF77\nE2\nS5\nL90\nE5\nS4\nL90\nS4\nF32\nL90\nW3\nF92\nW3\nS4\nW1\nR90\nF6\nR180\nE4\nW2\nR90\nW4\nS2\nW5\nS2\nF79\nR90\nS4\nF50\nS4\nW3\nF87\nW5\nR90\nS2\nF23\nE1\nN1\nR90\nF24\nL90\nF29\nN1\nR90\nE5\nN5\nF79\nW3\nL90\nS4\nE5\nS1\nF36\nW2\nR90\nF36\nR270\nF82\nE4\nF82\nS3\nF94\nN2\nL180\nS2\nE1\nN3\nF54\nS3\nF11\nE2\nR90\nW2\nF39\nR90\nS2\nW2\nR90\nE4\nN2\nE5\nF59\nW3\nR90\nW3\nF78\nN4\nF97\nS4\nW1\nF48\nN2\nE2\nR180\nF6\nR90\nW4\nR90\nE5\nF19\nN2\nR180\nF50\nW3\nN5\nR90\nN1\nW4\nF68\nR90\nN2\nL90\nF83\nE3\nN4\nW2\nF48\nW3\nE3\nL180\nF73\nR90\nF81\nW1\nR90\nF25\nS3\nF23\nL270\nS4\nF76\nW3\nF73\nN2\nE5\nL90\nN3\nW3\nR270\nF37\nS5\nR90\nF46\nS4\nE4\nF92\nL90\nN1\nL180\nW3\nS5\nF27\nN1\nL180\nF91\nW4\nN3\nF11\nL180\nN1\nE3\nL90\nS2\nR90\nS2\nE3\nF55\nS4\nE2\nS2\nF3\nE3\nF58\nW4\nN4\nE5\nF2\nN1\nW3\nF86\nE5\nF60\nW3\nF9\nS4\nR180\nF44\nE4\nN1\nF74\nL270\nE4\nL270\nF52\nR180\nF70\nL180\nE1\nF68\nR90\nE5\nW4\nR90\nE4\nF27\nS2\nL90\nW5\nN5\nR90\nE2\nN5\nF15\nR180\nF72\nS5\nL90\nF31\nR90\nE4\nR270\nS3\nW3\nR270\nN1\nS3\nR90\nF80\nR90\nE2\nN5\nW2\nL90\nF40\nN1\nF14\nL90\nW2\nF9\nW4\nR90\nF88\nR180\nN1\nE5\nF96\nN1\nF4\nR90\nF56\nF14\nL90\nF8\nR180\nS2\nF75\nL90\nE5\nR90\nF81\nN1\nW3\nF46\nR270\nS2\nF15\nW3\nR180\nF27\nW3\nF53\nR90\nE5\nL90\nS3\nW1\nF62\nS5\nW2\nS5\nR90\nF82\nW2\nN4\nL270\nE1\nN5\nE2\nF52\nN1\nE2\nS2\nR180\nN1\nL90\nW2\nL90\nF78\nL90\nW1\nN4\nF81\nE1\nN4\nW2\nF86\nW1\nF30\nW5\nN4\nE3\nF42\nN2\nF5\nR90\nF60\nL90\nE5\nS4\nE5\nS3\nF70\nS3\nR90\nW5\nR90\nW2\nN3\nL180\nE3\nS2\nE3\nF82\nE2\nF5\nE4\nE1\nS1\nR180\nW4\nF1\nR180\nN4\nE1\nS3\nE3\nF59\nW3\nF73\nL90\nF74\nR90\nE1\nF54\nW3\nF54\nL90\nS4\nF100\nF56\nL90\nF26\nL180\nF50\nW3\nS2\nE3\nF87\nN2\nW5\nF50\nS2\nW5\nS1\nF46\nR90\nF89\nL90\nN4\nF53\nW1\nF56\nE4\nS5\nF68\nL90\nF22\nR90\nF73\nS5\nS5\nL90\nE4\nS2\nR270\nE3\nL90\nF20\nL90\nF84\nS1\nF29\nW2\nS4\nL90\nW4\nN1\nF65\nE5\nL90\nS3\nF38\nL90\nL90\nN5\nF50\nS1\nF16\nR90\nF12\nE2\nN3\nF49\nR90\nF4\nN1\nR90\nF80\nR180\nW2\nL90\nS5\nE1\nF93\nR90\nF32\nL180\nF44\nL90\nS4\nF42\nN2\nR90\nS1\nF56\nL180\nE2\nF90\nN1\nF3\nL90\nE1\nF91\nL90\nW4\nL90\nF10\nS3\nW5\nS3\nF87\n\n"
    )
  (day12part2 puzzle)                                       ; 42495
  )