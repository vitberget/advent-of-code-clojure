(ns year2023.day16.day16-part1
  (:require
    [utils.text :refer [text->lines]]
    [year2023.day16.day16-data :refer [day16-example day16-puzzle]]
    [ysera.test :refer [is=]]))

(def directions
  {:n [0 -1]
   :s [0 1]
   :w [-1 0]
   :e [1 0]})

(defn lines->items 
  [lines]
  (->> lines
       (map-indexed (fn [y line]
                      (->> line
                           (map-indexed (fn [x ch]
                                          (when-not (= ch \.)
                                            {[x y] ch})))
                           (filter identity)
                           (reduce merge))))
       (reduce merge)))

(defn text->layout 
  [text]
  (let [lines (text->lines text)
        height (->> lines (count))
        width (->> lines (first) (count))]
    {:height height
     :width width
     :items (lines->items lines)}))

(defn step-beam 
  [[direction [x y]]]
  (let [[dx dy] (get directions direction)]
    [direction [(+ x dx) (+ y dy)]]))

(defn beam-outside?
  [{height :height width :width} [_ [x y]]]
  (or (< x 0)
      (< y 0)
      (>= x width)
      (>= y height)))

(defn mirror-beam 
  [item [direction position]]
  (if (= item \\)
    (condp = direction ; \
      :n [:w position]
      :s [:e position]
      :w [:n position]
      :e [:s position])
    (condp = direction ; /
      :n [:e position]
      :s [:w position]
      :w [:s position]
      :e [:n position])))

(defn move-beams 
  [{items :items :as layout} energized beams]
  (loop [[beam & beams] beams
         new-beams (list)
         energized energized]
    (if (nil? beam)
      {:energized energized :beams new-beams} 
      (let [[direction position :as new-beam] (step-beam beam)]
        (if (beam-outside? layout new-beam)
          (recur beams new-beams energized) 
          (let [item (get items position)
                energized (conj energized position)]
            (cond 
              (and (= item \|)
                   (or (= direction :e) (= direction :w)))
              (recur beams (conj new-beams [:n position] [:s position]) energized)

              (and (= item \-)
                   (or (= direction :n) (= direction :s)))
              (recur beams (conj new-beams [:w position] [:e position]) energized)

              (or (= item \\) (= item \/))
              (recur beams (conj new-beams (mirror-beam item new-beam)) energized)

              :else
              (recur beams (conj new-beams new-beam) energized))))))))

(defn send-beam
  [start-position layout]
  (loop [iterations 0
         energized #{}
         done-beams #{}
         beams (list start-position)]
    (if (empty? beams)
      energized
      (let [{energized :energized beams :beams} (move-beams layout energized beams)
            beams (->> beams
                       (filter (fn [beam] (not (contains? done-beams beam)))))
            done-beams  (apply conj done-beams beams)]
        (recur 
          (inc iterations) 
          energized
          done-beams
          beams)))))

(defn day16-part1
  {:test (fn [] (is= (day16-part1 day16-example) 46))}
  [text]
  (->> text
       (text->layout)
       (send-beam [:e [-1 0]])
       (count)))

(comment
  (time (day16-part1 day16-puzzle))
  ; (out) "Elapsed time: 25.753472 msecs"
  ; 7632
  )
