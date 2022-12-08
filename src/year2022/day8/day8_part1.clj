(ns year2022.day8.day8-part1
  (:require
    [utils.text :as ut]
    [year2022.day8.day8-data :refer [day8-example day8-puzzle]]
    [ysera.test :refer [is is-not is=]]))

(defn line->forest
  [[y line]]
  (->> line
       (map-indexed (fn [x char]
                      {[x y] (ut/char->number char)}))
       (apply merge)))

(defn text->forest
  [text]
  (->> text
       (ut/text->lines)
       (map-indexed (fn [y line] [y line]))
       (map line->forest)
       (apply merge)))

(def directions
  (list [-1 0]
        [1 0]
        [0 -1]
        [0 1]))

(defn translate-position
  [[x y] distance [dx dy]]
  [(+ x (* distance dx))
   (+ y (* distance dy))])

(defn visible?
  {:test (fn []
           (let [forest (text->forest day8-example)]
             (is (visible? forest [0 0]))
             (is (visible? forest [1 1]))
             (is-not (visible? forest [2 2]))))}
  [forest test-position]
  (let [height (get forest test-position)]
    (loop [distance 1
           directions directions]
      (when-not (empty? directions)
        (let [translated (->> directions
                              (map (fn [direction]
                                     (let [translated (translate-position test-position distance direction)]
                                       [direction translated (get forest translated)]))))]
          (or (->> translated
                   (map #(nth % 2))
                   (filter nil?)
                   (empty?)
                   (not))
              (recur (inc distance)
                     (->> translated
                          (filter #(< (nth % 2) height))
                          (map first)))))))))

(defn day8-part1
  {:test (fn []
           (is= (day8-part1 day8-example) 21)
           (is= (day8-part1 day8-puzzle) 1782))}
  [text]
  (let [forest (text->forest text)]
    (->> forest
         (keys)
         (filter #(visible? forest %))
         (count))))

(comment
  (time (day8-part1 day8-puzzle))
  ;"Elapsed time: 132.514796 msecs"
  ;=> 1782
  )
