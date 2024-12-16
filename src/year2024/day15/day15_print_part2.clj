(ns year2024.day15.day15-print-part2)

(defn print-the-map-part2
  [{robot :robot walls :walls boxes :boxes} [index instruction] ]
  (let [[width height] (reduce (fn [wh pos] (mapv max wh pos)) walls)]
    (print "\033[1;32m")
    (print "===\033[1;31m" instruction instruction instruction)
    (print "\033[1;32m ===" index "===")
    (println "\033[1;37m")
    (doseq [y (range 0 (+ height 1))
            x (range 0 (+ width 2))]
      (let [pos [x y]
            left-pos [(dec x) y]]
        (cond
          (= robot pos) (print "\033[1;31m@")

          (contains? walls pos) (print "\033[0;33m#")
          (contains? walls left-pos) (print "\033[0;33m#")

          (contains? boxes pos) (print "\033[1;37m[")
          (contains? boxes left-pos) (print "\033[1;37m]")

          :else (print "\033[0;37m."))
        (when (= x (inc width)) (println) )))
    (println "\033[0m ")))
