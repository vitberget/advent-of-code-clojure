(ns year2024.day15.day15-print)

(defn print-the-map
  [{robot :robot walls :walls boxes :boxes} instruction]
  (let [[width height] (reduce (fn [wh pos] (mapv max wh pos)) walls)]
  (println "Move" instruction "    " width ":" height)
    (doseq [y (range 0 (inc height))
            x (range 0 (inc width))]
      (let [pos [x y]]
        (cond
          (= robot pos) (print "@")
          (contains? walls pos) (print "#")
          (contains? boxes pos) (print "O")
          :else (print "."))
       (when (= x width) (println) )))))
