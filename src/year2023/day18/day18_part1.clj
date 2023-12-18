(ns year2023.day18.day18-part1
  (:require
    [utils.text :refer [split-on text->lines]]
    [year2023.day18.day18-data :refer [day18-example day18-puzzle]]
    [ysera.test :refer [is=]]))

(defn dig-one 
  [[x y] [direction amount]]
  (->> (range 1 (inc amount))
       (map (fn [delta] (condp = direction
                          "U" [x (- y delta)] 
                          "D" [x (+ y delta)] 
                          "L" [(- x delta) y] 
                          "R" [(+ x delta) y])))))

(defn do-the-dig 
  [instructions]
  (loop [[instruction & instructions] instructions
         visited #{[0 0]}
         location [0 0]] 
    (if (nil? instruction)
      visited
      (let [new-locations (dig-one location instruction)]
        (recur instructions
               (apply conj visited new-locations)
               (last new-locations))))))

(defn text->instructions 
  [text]
  (->> text
       (text->lines)
       (map (fn [line] (split-on #" " line)))
       (map (fn [[direction amount]] [direction (read-string amount)]))))

(defn fill-perimiter-y [perimiter y min-x max-x]
    (loop [x min-x
           previous-was-wall false
           previous-was-wall-had-north false
           previous-was-wall-had-south false
           walls 0
           filler-count 0]
      (if (= x max-x)
        filler-count
        (let [is-wall (contains? perimiter [x y])
              is-wall-north (contains? perimiter [x (dec y)])
              is-wall-south (contains? perimiter [x (inc y)])
              new-x (inc x)]
          (cond
            (and is-wall 
                 previous-was-wall
                 (or (and previous-was-wall-had-south is-wall-south)
                     (and previous-was-wall-had-north is-wall-north)))
            (recur new-x 
                   false 
                   false
                   false
                   (inc walls) 
                   filler-count)

            (and is-wall previous-was-wall)
            (recur new-x 
                   true 
                   previous-was-wall-had-north
                   previous-was-wall-had-south
                   walls 
                   filler-count)

            is-wall
            (recur new-x 
                   true
                   is-wall-north
                   is-wall-south
                   (inc walls) 
                   filler-count)

            :else
            (recur new-x 
                   false 
                   false
                   false
                   walls 
                   (if (odd? walls)
                     (inc filler-count)
                     filler-count)))))))

(defn fill-perimiter 
  [tunnels]
  (let [min-x (->> tunnels (map first) (reduce min))
        max-x (->> tunnels (map first) (reduce max))
        min-y (->> tunnels (map second) (reduce min))
        max-y (->> tunnels (map second) (reduce max))]
    (->> (range min-y max-y)
         (pmap (fn [y] (fill-perimiter-y tunnels y min-x max-x)))
         (reduce +))))

(defn print-dig 
  [perimiter filler]
  (let [min-x (->> perimiter (map first) (reduce min))
        max-x (->> perimiter (map first) (reduce max))
        min-y (->> perimiter (map second) (reduce min))
        max-y (->> perimiter (map second) (reduce max))]
    (doseq [y (range min-y (inc max-y))
            x (range min-x (inc max-x))]
      (when (and (= min-x x) (not= min-y y))
        (println))
      (let [perimiter (contains? perimiter [x y])
            filler (contains? filler [x y])]
        (cond
          (and perimiter filler) (print "!")
          perimiter (print "#")
          filler (print ".")
          :else (print " "))))))

(defn day18-part1
  {:test (fn [] (is= (day18-part1 day18-example) 62))}
  [text]
  (let [instructions (text->instructions text) 
        perimiter (do-the-dig instructions)
        filler (fill-perimiter perimiter)]
    ; (print-dig perimiter filler)
    (+ (count perimiter)
       filler)))

(comment
  (time (day18-part1 day18-puzzle))
  ; (out) "Elapsed time: 48.543835 msecs"
  ; 42317
  )
