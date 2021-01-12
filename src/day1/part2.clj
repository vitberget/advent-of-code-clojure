(ns day1.part2)
;--- Part Two ---
;
;The Elves in accounting are thankful for your help; one of them even offers
; you a starfish coin they had left over from a past vacation. They offer you a
; second one if you can find three numbers in your expense report that meet the same criteria.
;Using the above example again, the three entries that sum to 2020 are 979, 366, and 675.
; Multiplying them together produces the answer, 241861950.


(defn number-number-list [num1 num2 list]
  (loop [list list]
    (if (empty? list)
      nil
      (let [listnum (first list)]
        (if (= 2020 (+ num1 num2 listnum))
          listnum
          (recur (rest list)))))))

(defn number-list
  [num list]
  (loop [list list]
    (if (empty? list)
      nil
      (let [listnum (first list)
            restlist (rest list)]
        (if-let [nn (number-number-list num listnum restlist)]
          [num listnum nn]
          (recur restlist))))))

(defn lister
  [list]
  (loop [list list]
    (if (empty? list)
      nil
      (let [numlist (first list)
            restlist (rest list)]
        (if-let [nnn (number-list numlist restlist)]
          nnn
          (recur restlist))))))


(defn part2
  [list]
  (reduce * (lister list)))

(comment
  (lister [979 366 675])
  (lister [1 1 979 366 675])
  (part2 [1 1 979 366 675])
  )