(ns year2023.day18.day18-part2
  (:require
    [utils.text :refer [lowercase-char->hex-number split-on text->lines]]
    [year2023.day18.day18-data :refer [day18-example day18-puzzle]]
    [ysera.test :refer [is=]]))

(defn digit->direction
  [digit]
  (condp = digit 
    \0 "R"
    \1 "D"
    \2 "L"
    \3 "U"))

(defn part->instruction 
  {:test (fn[]
           (is= (part->instruction "(#70c710)") ["R" 461937])
           (is= (part->instruction "(#0dc571)") ["D" 56407])
           (is= (part->instruction "(#caa173)") ["U" 829975]))} 
  [part]
  (let [hexadecimal (->> part (drop 2) (take 6))]
    [(-> hexadecimal (last) (digit->direction)) 
     (->> hexadecimal
          (take 5)
          (map lowercase-char->hex-number)
          (reduce (fn [a n] (+ (* a 16) n))))]))

(defn text->instructions 
  [text]
  (->> text
       (text->lines)
       (map (fn [line] (split-on #" " line)))
       (map last)
       (map part->instruction)))

(defn next-point 
  [[x y] [direction amount]]
  (condp = direction 
    "U" [x (- y amount)] 
    "D" [x (+ y amount)] 
    "L" [(- x amount) y] 
    "R" [(+ x amount) y]))

(defn instructions->points 
  [instructions]
  (loop [[instruction & instructions] instructions
         points (list)
         current [0 0]]
    (if (nil? instruction)
      points
      (let [np (next-point current instruction)]
        (recur instructions
               (conj points np)
               np)))))

(defn- points->perimiter 
  [points]
  (loop [[point & points] points
         current-point (last points)
         perimieter 0]
    (if (nil? point) 
      perimieter
      (recur points
             point
             (+ perimieter
                (abs (- (second point) (second current-point)))
                (abs (- (first point) (first current-point))))))))

(defn- points->inner-area 
  [points]
  (let [points (->> (conj points (last points))
                    (partition 2 1))]
    (loop [[[[p1x p1y] [p2x p2y]] & points] points
           a 0
           b 0]
      (if (nil? p1x)
        (/ (abs (- b a)) 2) 
        (recur points
               (+ a (* p1x p2y))
               (+ b (* p1y p2x)))))))

(defn day18-part2
  {:test (fn [] 
           (is= (day18-part2 day18-example) 952408144115)
           (is= (day18-part2 day18-puzzle) 83605563360288))}
  [text]
  (let [points (->> text
                    (text->instructions) 
                    (instructions->points))]
    (+ (points->inner-area points) 
       (/ (points->perimiter points) 2) 
       1)))

(comment
  (time (day18-part2 day18-puzzle))
  ; (out) "Elapsed time: 3.329778 msecs"
  ; 83605563360288
  )
