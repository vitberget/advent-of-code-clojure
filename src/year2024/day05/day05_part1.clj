(ns year2024.day05.day05-part1
  (:require
   [clojure.edn :as edn]
   [utils.text :as ut]
   [year2024.day05.day05-data :refer [day05-example day05-puzzle]]
   [ysera.test :refer [is= is is-not]]))

(defn text->ordering-rules 
  [text]
  (->> text
       (ut/text->lines)
       (map (fn[line] (->> line 
                           (ut/split-on #"\|")
                           (map edn/read-string))))
       (reduce (fn [ordering-rules [left right]]
                 (update ordering-rules left (fn[rule] (conj (or rule #{}) right))))
               {})))

(defn text->updates
  [text]
  (->> text
       (ut/text->lines)
       (map (fn [line] (->> line 
                            (ut/split-on #"\,")
                            (map edn/read-string))))))

(defn right-order? 
  {:test (fn[]
           (let [rules (->> day05-example
                            (ut/text->paragraphs)
                            (first)
                            (text->ordering-rules))]
             (is (right-order? [75,47,61,53,29] rules))
             (is (right-order? [97,61,53,29,13] rules))
             (is (right-order? [75,29,13] rules))
             (is-not (right-order? [75,97,47,61,53] rules))
             (is-not (right-order? [61,13,29] rules))
             (is-not (right-order? [97,13,75,29,47] rules))))}
  [numbers rules]
  (loop [[test-num & numbers] numbers]
    (or 
      (nil? test-num)
      (and 
        (->> numbers
             (map (fn[n] (get rules n)))
             (some (fn[lefties] (contains? lefties test-num)))
             (not))
        (recur numbers)))))

(defn get-middle
  {:test (fn[]
           (is= (get-middle [1 2 3]) 2)
           (is= (get-middle [10 20 30 40 50]) 30))}
  [numbers]
  (nth numbers (/ (count numbers) 2)))

(defn day05-part1
  {:test (fn []
           (is= (day05-part1 day05-example) 143))}
  [text]
  (let [[ordering-rules updates] (ut/text->paragraphs text)
        ordering-rules (text->ordering-rules ordering-rules)
        updates (text->updates updates)]
    (->> updates
         (filter (fn[numbers] (right-order? numbers ordering-rules)))
         (map get-middle)
         (reduce +))))

(comment
  (time (day05-part1 day05-puzzle))
  ; (out) "Elapsed time: 4.810834 msecs"
  ; 5964
  )
