(ns year2023.day14.day14-part2
  (:require
    [utils.text :refer [text->lines]]
    [year2023.day14.day14-data :refer [day14-example day14-puzzle]]
    [ysera.test :refer [is=]]))

(defn get-stones [lines stone]
  (->> lines
       (map-indexed (fn [y line]
                      (->> line
                           (map-indexed (fn [x ch] (when (= stone ch) [x y])))
                           (filter identity))))
       (apply concat)
       (into #{})))

(defn peek-map 
  [{height :height width :width round-stones :round-stones square-stones :square-stones :as the-map}]
  (doseq [y (range 0 height)
          x (range 0 width)]
    (when (and (zero? x) (not (zero? y)))
      (println))
    (cond
      (contains? round-stones [x y]) (print \O)      
      (contains? square-stones [x y]) (print \#)      
      :else (print \.)))
  (println)
  the-map)

(defn do-part-cycle
  [{round-stones :round-stones :as the-map} 
   update-fn]
  (loop [round-stones round-stones]
    (let [new-round-stones (update-fn round-stones the-map)]
      (if (= new-round-stones round-stones)
        (assoc the-map :round-stones new-round-stones)
        (recur new-round-stones)))))

(defn cycle-north
  [round-stones
   {square-stones :square-stones}] 
  (->> round-stones
       (pmap (fn [[x y :as pos]]
               (if (zero? y)
                 pos
                 (let [new-pos [x (dec y)]]
                   (cond
                     (contains? round-stones new-pos) pos 
                     (contains? square-stones new-pos) pos 
                     :else new-pos)))))
       (into #{})))

(defn cycle-west
  [round-stones
   {square-stones :square-stones}] 
  (->> round-stones
       (pmap (fn [[x y :as pos]]
               (if (zero? x)
                 pos
                 (let [new-pos [(dec x) y]]
                   (cond
                     (contains? round-stones new-pos) pos 
                     (contains? square-stones new-pos) pos 
                     :else new-pos)))))
       (into #{})))

(defn cycle-south
  [round-stones
   {height :height square-stones :square-stones}] 
  (->> round-stones
       (pmap (fn [[x y :as pos]]
               (if (= height (inc y))
                 pos
                 (let [new-pos [x (inc y)]]
                   (cond
                     (contains? round-stones new-pos) pos 
                     (contains? square-stones new-pos) pos 
                     :else new-pos)))))
       (into #{})))

(defn cycle-east
  [round-stones
   {width :width square-stones :square-stones}] 
  (->> round-stones
       (pmap (fn [[x y :as pos]]
               (if (= width (inc x))
                 pos
                 (let [new-pos [(inc x) y]]
                   (cond
                     (contains? round-stones new-pos) pos 
                     (contains? square-stones new-pos) pos 
                     :else new-pos)))))
       (into #{})))

(def do-cycle 
  (memoize
    (fn[the-map]
      (-> the-map
          (do-part-cycle cycle-north)
          (do-part-cycle cycle-west)
          (do-part-cycle cycle-south)
          (do-part-cycle cycle-east)))))

(defn do-cycles-until-in-loop 
  [the-original-map]
  (loop [loopies {}
         the-map the-original-map]
    (let [new-map (do-cycle the-map)
          new-loopies (assoc loopies (:round-stones the-map) (:round-stones new-map))]
      (if (contains? loopies (:round-stones new-map))
        [new-loopies the-map]
        (recur new-loopies new-map)))))

(defn text->map
  [text]
  (let [lines (text->lines text)
        height (count lines)
        width (-> lines (first) (count))]
    {:height height
     :width width
     :round-stones (get-stones lines \O)
     :square-stones (get-stones lines \#)}))

(defn get-loop-size [loopies last-map]
  (let [last-step (:round-stones last-map)]
    (loop [next-step (get loopies last-step)
           steps 1]
      (if (= next-step last-step)
        steps
        (recur (get loopies next-step) (inc steps))))))

(defn score-map [{round-stones :round-stones height :height}]
  (->> round-stones
       (map (fn [[_ y]] (- height y)))
       (reduce +)))

(defn day14-part2
  {:test (fn []
           (is= (day14-part2 day14-example) 64))}
  [text]
  (let [[loopies last-map] (->> text
                                (text->map)
                                (do-cycles-until-in-loop))
        loop-size (get-loop-size loopies last-map)
        how-many-round-must-a-man-walk-down (as-> loopies $
                                              (count $)
                                              (- 1000000000 $)
                                              (mod $ loop-size)
                                              (+ $ 1))
        real-step (loop [roads how-many-round-must-a-man-walk-down
                         step (:round-stones last-map)]
                    (if (zero? roads)
                      step
                      (recur (dec roads)
                             (get loopies step)))) ]
    (score-map (assoc last-map :round-stones real-step))))

(comment
  (time (day14-part2 day14-puzzle))
  ;
  ; (out) "Elapsed time: 23817.209032 msecs"
  ; 106689
  )
