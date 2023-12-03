(ns year2023.day03.day03-part1
  (:require
    [utils.text :refer [char->number digit? text->lines]]
    [year2023.day03.day03-data :refer [day03-example day03-puzzle]]
    [ysera.test :refer [is=]]))

(defn line->schematic [y line]
  (->> line
       (map-indexed (fn [x ch]
                      (when (not= ch \.)
                        (if (digit? ch)
                          {[x y] (char->number ch)}
                          {[x y] ch})))) (apply merge)))

(defn text->schematic [text]
  (->> text
       (text->lines)
       (map-indexed line->schematic)
       (apply merge)))

(defn schematic->numbers [schematic]
  (let [locations (->> schematic
                       (filter (fn [[_ v]] (number? v)))
                       (sort (fn [[[x1 y1] _] [[x2 y2] _]]
                               (if (= y1 y2)
                                 (compare x1 x2)
                                 (compare y1 y2)))))]
    (loop [[location & locations] locations
           result []
           current-number nil
           prev-location nil]
      (if (nil? location)
        (if current-number 
          (conj result current-number) 
          (result))
        (let [[[lx ly] lv] location]
          (if-let [[[px py] _] prev-location]
            (if (and (= py ly)
                     (= px (dec lx)))
              (recur locations
                     result
                     (-> current-number
                         (update :number (fn[n](+ (* 10 n) lv)))
                         (update :positions conj [lx ly]))
                     location) 
              (recur locations
                     (conj result current-number)
                     {:number lv :positions [[lx ly]]}
                     location)) 
            (recur locations
                   result
                   {:number lv :positions [[lx ly]]}
                   location)))))))

(defn schematic->symbols [schematic] 
  (->> schematic
       (filter (fn [[_ v]] (not (number? v))))
       (into {})))

(defn surrounding-positions [[x y]]
  (for [dx [-1 0 1]
        dy [-1 0 1]
        :when (or (not= dx 0)(not= dy 0)) ]
    [(+ x dx) (+ y dy)]))

(defn adjacent-symbol? [number symbols]
  (let [all-surrounding-positions(->> number
                                      (:positions)
                                      (map surrounding-positions)
                                      (apply concat))]
    (loop [[position & positions] all-surrounding-positions]
      (cond
        (nil? position)
        false

        (get symbols position)
        true
        
        :else
        (recur positions)))))

(defn day03-part1
  {:test (fn []
           (is= (day03-part1 day03-example) 4361))}
  [text]
  (let [schematic (text->schematic text)
        numbers (schematic->numbers schematic)
        symbols (schematic->symbols schematic)]
    (->> numbers
         (filter (fn[number] (adjacent-symbol? number symbols)))
         (map :number)
         (reduce +))))


(comment
  (time (day03-part1 day03-puzzle))
  ; (out) "Elapsed time: 19.034306 msecs"
  ; 520019
  )
