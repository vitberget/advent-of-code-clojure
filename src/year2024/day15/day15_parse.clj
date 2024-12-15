(ns year2024.day15.day15-parse 
  (:require
   [utils.text :as ut]
   [year2024.day15.day15-data :refer [day15-example-smaller]]))

(defn map-text->the-map
  [text]
  (->> text
       (ut/text->lines)
       (map-indexed (fn [y line]
                     (->> line
                          (map-indexed (fn [x ch] [ch [x y]])))))
       (apply concat)
       (reduce (fn [the-map [ch pos]] 
                 (update the-map ch (fn [positions] (conj (or positions #{}) pos))))
               {})))

(defn text->data
  [text]
  (let [[the-map instructions] (ut/text->paragraphs text)
        the-map (map-text->the-map the-map)
        the-map {:robot (-> the-map
                            (get \@)
                            (first))
                 :walls (get the-map \#)
                 :boxes (get the-map \O)} ]
    [the-map instructions]))

(comment 
  (text->data day15-example-smaller)
  )

