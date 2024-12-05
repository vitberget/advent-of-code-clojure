(ns year2024.day05.day05-part2
  (:require
   [utils.text :as ut]
   [year2024.day05.day05-data :refer [day05-example day05-puzzle]]
   [year2024.day05.day05-part1 :as part-1]
   [ysera.test :refer [is=]]))

(defn get-next-num
  {:test (fn[]
           (let [rules (->> day05-example
                            (ut/text->paragraphs)
                            (first)
                            (part-1/text->ordering-rules))]
             (is= (get-next-num [75 97 47 61 53] rules) 97)
             (is= (get-next-num [13 29 61] rules) 61)
             (is= (get-next-num [13 75 97 29 47] rules) 97)))}
  [numbers rules]
  (loop [[number & numbers] numbers]
    (if (->> numbers
             (map (fn [n] (get rules n)))
             (some (fn [righties] (contains? righties number))))
      (recur numbers)
      number)))

(defn sort-numbers
  {:test (fn[]
           (let [rules (->> day05-example
                            (ut/text->paragraphs)
                            (first)
                            (part-1/text->ordering-rules))]
             (is= (sort-numbers [75 97 47 61 53] rules) [97 75 47 61 53])
             (is= (sort-numbers [61 13 29] rules) [61 29 13])
             (is= (sort-numbers [97 13 75 29 47] rules) [97 75 47 29 13])))} 
  [numbers rules]
  (loop [numbers (into #{} numbers)
         result []]
    (if (empty? numbers)
      result
      (let [next-num (get-next-num numbers rules)]
        (recur (disj numbers next-num)
               (conj result next-num))))))

(defn day05-part2
  {:test (fn []
           (is= (day05-part2 day05-example) 123))}
  [text]
  (let [[ordering-rules updates] (ut/text->paragraphs text)
        ordering-rules (part-1/text->ordering-rules ordering-rules)
        updates (part-1/text->updates updates)]
    (->> updates
         (filter (fn[numbers] (not (part-1/right-order? numbers ordering-rules))))
         (map (fn[numbers] (sort-numbers numbers ordering-rules)))
         (map part-1/get-middle)
         (reduce +))))

(comment
  (time (day05-part2 day05-puzzle))
  ; (out) "Elapsed time: 8.135849 msecs"
  ; 4719
  )
