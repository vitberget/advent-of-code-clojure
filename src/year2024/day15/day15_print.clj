(ns year2024.day15.day15-print 
  (:require
    [utils.colors :as colors]))

(defn print-the-map
  [{robot :robot walls :walls boxes :boxes} instruction]
  (let [[width height] (reduce (fn [wh pos] (mapv max wh pos)) walls)]
    (println (colors/goto 0 0) colors/green "Move" instruction "    " width ":" height)
    (doseq [y (range 0 (inc height))
            x (range 0 (inc width))]
      (let [pos [x y]]
        (cond
          (= robot pos) (print (str colors/light-red "@"))
          (contains? walls pos) (print (str colors/light-green  "#"))
          (contains? boxes pos) (print (str colors/white "O"))
          :else (print (str colors/dark-gray ".")))
        (when (= x width) (println) )))
    (println colors/reset)))
