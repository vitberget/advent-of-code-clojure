(ns year2024.day15.day15-part1
  (:require
   [year2024.day15.day15-parse :refer [text->data]]
   [year2024.day15.day15-print :refer [print-the-map]]
   [year2024.day15.day15-make-a-move :refer [make-a-move]]
   [year2024.day15.day15-data :refer [day15-example day15-example-smaller day15-puzzle]]
   [ysera.test :refer [is=]]))

(defn get-final-map
  [the-map instructions debug]
  (when debug (print-the-map the-map "Initual state"))
  (reduce (fn[the-map instruction]
            (let [the-map (make-a-move the-map instruction)]
              (when debug (print-the-map the-map instruction))
              the-map))
          the-map 
          instructions))

(defn the-map->score 
  [{boxes :boxes}]
  (->> boxes
       (map (fn [[x y]] (+ x (* 100 y))))
       (reduce +)))

(defn clean-instructions 
  [instructions]
  (->> instructions
       (filter (fn [ch] (or (= ch \<)
                            (= ch \>)
                            (= ch \v)
                            (= ch \^))))))

(defn day15-part1
  {:test (fn []
           (is= (day15-part1 day15-example) 10092)
           (is= (day15-part1 day15-example-smaller) 2028))}
  [text]
  (let [[the-map instructions] (text->data text)
        instructions (clean-instructions instructions)
        final-map (get-final-map the-map instructions true) ]
    (the-map->score final-map)))

(comment
  (time (day15-part1 day15-puzzle))
  ; (out) "Elapsed time: 28.203921 msecs"
  ; 1526018
  )
