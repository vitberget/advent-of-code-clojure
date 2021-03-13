(ns year2020.day10.day10part2
  (:require [ysera.test :refer [is is= is-not]]
            [clojure.string :as str]))

(defn conj-max-plus-3
  {:test (fn []
           (is= (conj-max-plus-3 (list 1 3 2))
                (list 6 1 3 2)))}
  [numbers]
  (conj numbers
        (->> numbers
             (reduce max)
             (+ 3))))

(defn string->state
  [string]
  (->> string
       (str/split-lines)
       (map read-string)
       (conj-max-plus-3)
       (cons 0)
       (sort)))

(defn possible-3-jumps
  [number numbers]
  (loop [jump-set #{}
         [jump & numbers] numbers]
    (if (or (empty? numbers)
            (> (- jump number) 3))
      jump-set
      (recur (conj jump-set jump) numbers))))

(defn possible-jumps
  [numbers]
  (loop [jump-map {}
         [number & numbers] numbers]
    (if (empty? numbers)
      jump-map
      (recur (merge jump-map {number (possible-3-jumps number numbers)})
             numbers))))

(def count-possibilities-from
  (memoize
    (fn [num jump-map]
      (as-> (get jump-map num) $
            (if (empty? $)
              1
              (->> $
                   (map (fn [num] (count-possibilities-from num jump-map)))
                   (reduce +)))))))

(defn day10part2
  {:test (fn []
           (is= (day10part2 "16\n10\n15\n5\n1\n11\n7\n19\n6\n12\n4")
                8)
           (is= (day10part2 "28\n33\n18\n42\n31\n14\n46\n20\n48\n47\n24\n23\n49\n45\n19\n38\n39\n11\n1\n32\n25\n35\n8\n17\n7\n9\n4\n2\n34\n10\n3")
                19208))}
  [string]
  (->> string
       (string->state)
       (possible-jumps)
       (count-possibilities-from 0)))

(comment
  (let [puzzle "133\n157\n39\n74\n108\n136\n92\n55\n86\n46\n111\n58\n80\n115\n84\n67\n98\n30\n40\n61\n71\n114\n17\n9\n123\n142\n49\n158\n107\n139\n104\n132\n155\n96\n91\n15\n11\n23\n54\n6\n63\n126\n3\n10\n116\n87\n68\n72\n109\n62\n134\n103\n1\n16\n101\n117\n35\n120\n151\n102\n85\n145\n135\n79\n2\n147\n33\n41\n93\n52\n48\n64\n81\n29\n20\n110\n129\n43\n148\n36\n53\n26\n42\n156\n154\n77\n88\n73\n27\n34\n12\n146\n78\n47\n28\n97"]
    (time
      (day10part2 puzzle)))
  ; "Elapsed time: 0.70909 msecs"
  ;=> 6908379398144
  )