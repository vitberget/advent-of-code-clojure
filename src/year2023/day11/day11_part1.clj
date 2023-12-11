(ns year2023.day11.day11-part1
  (:require
   [utils.numbers :refer [manhattan-distance]]
   [utils.text :refer [text->lines]]
   [year2023.day11.day11-data :refer [day11-example day11-example-grown
                                      day11-puzzle]]
   [ysera.test :refer [is=]]))

(defn line->galaxies 
  [y line]
  (->> line
       (map-indexed (fn [x ch] (when (= ch \#) [x y])))
       (filter identity)))

(defn text->galaxies
  [text]
  (->> text
       (text->lines)
       (map-indexed line->galaxies)
       (apply concat)))

(defn find-empty-columns 
  [{galaxies :galaxies width :width}]
  (->> (range 0 width)
       (filter (fn [col-x] (->> galaxies
                                (filter (fn [[x _]] (= col-x x)))
                                (empty?))))))

(defn find-empty-rows 
  [{galaxies :galaxies height :height}]
  (->> (range 0 height)
       (filter (fn [col-y] (->> galaxies
                                (filter (fn [[_ y]] (= col-y y)))
                                (empty?))))))

(defn grow-galaxy 
  {:test (fn[] 
           (let [galaxies (text->galaxies day11-example)
                 grown-galaxies (text->galaxies day11-example-grown)
                 width (->> galaxies (map first) (reduce max) (inc))
                 height (->> galaxies (map second) (reduce max) (inc))
                 empty-columns (find-empty-columns {:galaxies galaxies :width width})
                 empty-rows (find-empty-rows {:galaxies galaxies :height height}) ]
             (is= (grow-galaxy {:galaxies galaxies :empty-columns empty-columns :empty-rows empty-rows})
                  grown-galaxies)))}
  [{galaxies :galaxies empty-columns :empty-columns empty-rows :empty-rows}]
  (->> galaxies
       (map (fn [[x y]] [(->> empty-columns (filter (fn [c] (< c x))) (count) (+ x)) 
                         (->> empty-rows (filter (fn [r] (< r y))) (count) (+ y))]))))

(defn calculate-galaxies-distances [galaxy galaxies]
  (->> galaxies
       (map (fn [galaxy-b] (manhattan-distance galaxy galaxy-b)))
       (apply +)))

(defn day11-part1
  {:test (fn [] (is= (day11-part1 day11-example) 374))}
  [text]
  (let [galaxies (text->galaxies text)
        width (->> galaxies (map first) (reduce max) (inc))
        height (->> galaxies (map second) (reduce max) (inc))
        empty-columns (find-empty-columns {:galaxies galaxies :width width})
        empty-rows (find-empty-rows {:galaxies galaxies :height height})
        grown-galaxies (grow-galaxy {:galaxies galaxies :empty-columns empty-columns :empty-rows empty-rows})]
      (loop [[galaxy & galaxies] grown-galaxies
             summary 0]
        (if (empty? galaxies)
          summary
          (recur galaxies
                 (+ summary (calculate-galaxies-distances galaxy galaxies)))))))

(comment
  (time (day11-part1 day11-puzzle))
  ; (out) "Elapsed time: 122.041186 msecs"
  ; 9543156
  )
