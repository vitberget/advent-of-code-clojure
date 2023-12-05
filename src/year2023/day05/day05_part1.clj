(ns year2023.day05.day05-part1
  (:require
    [utils.text :refer [line->numbers line->words text->lines text->paragraphs]]
    [year2023.day05.day05-data :refer [day05-example day05-puzzle]]
    [ysera.test :refer [is=]]))

(defn do-paragraph 
  [paragraphs n]
  (->> (nth paragraphs n)
       (text->lines)
       (drop 1) 
       (map line->numbers)))

(defn text->almenac 
  {:test (fn[]
           (is= (text->almenac day05-example)
                {:seeds [79 14 55 13]
                 :seed-to-soil [[50 98 2] [52 50 48]]
                 :soil-to-fertilizer [[0 15 37] [37 52 2] [39 0 15]]
                 :fertilizer-to-water [[49 53 8] [0 11 42] [42 0 7] [57 7 4]]
                 :water-to-light [[88 18 7][18 25 70]]
                 :light-to-temperature [[45 77 23] [81 45 19] [68 64 13]]
                 :temperature-to-humidity [[0 69 1] [1 0 69]]
                 :humidity-to-location [[60 56 37] [56 93 4]]}))}
  [text]
  (let [paragraphs (text->paragraphs text) ]
    {:seeds (map read-string (-> paragraphs 
                                 (nth 0)
                                 (subs 7)
                                 (line->words)))
     :seed-to-soil (do-paragraph paragraphs 1)
     :soil-to-fertilizer (do-paragraph paragraphs 2)
     :fertilizer-to-water (do-paragraph paragraphs 3)
     :water-to-light (do-paragraph paragraphs 4)
     :light-to-temperature (do-paragraph paragraphs 5)
     :temperature-to-humidity (do-paragraph paragraphs 6)
     :humidity-to-location (do-paragraph paragraphs 7)}))

(defn do-translation 
  {:test (fn[]
           (is= (do-translation 79 [[50 98 2] [52 50 48]]) 81)
           (is= (do-translation 14 [[50 98 2] [52 50 48]]) 14)
           (is= (do-translation 55 [[50 98 2] [52 50 48]]) 57)
           (is= (do-translation 98 [[50 98 2] [52 50 48]]) 50)
           (is= (do-translation 99 [[50 98 2] [52 50 48]]) 51)
           (is= (do-translation 100 [[50 98 2] [52 50 48]]) 100)
           (is= (do-translation 13 [[50 98 2] [52 50 48]]) 13))}
  [number translations]
  (loop [[[dest source size] & translations] translations]
    (cond
      (nil? dest)
      number

      (and (>= number source)
           (< number (+ source size)))
      (-> number
          (- source)
          (+ dest))

      :else
      (recur translations))))

(defn do-entire-translation
  {:test (fn[]
           (let [almenac (text->almenac day05-example)]
             (is= (do-entire-translation 79 almenac) 82) 
             (is= (do-entire-translation 14 almenac) 43) 
             (is= (do-entire-translation 55 almenac) 86) 
             (is= (do-entire-translation 13 almenac) 35)))}
  [seed almenac]
  (-> seed
      (do-translation (:seed-to-soil almenac))
      (do-translation (:soil-to-fertilizer almenac))
      (do-translation (:fertilizer-to-water almenac))
      (do-translation (:water-to-light almenac))
      (do-translation (:light-to-temperature almenac))
      (do-translation (:temperature-to-humidity almenac))
      (do-translation (:humidity-to-location almenac))))

(defn day05-part1
  {:test (fn [] (is= (day05-part1 day05-example) 35))}
  [text]
  (let [almenac (text->almenac text)]
    (->> almenac
         (:seeds)
         (map (fn[seed] (do-entire-translation seed almenac)))
         (apply min))))

(comment
  (time (day05-part1 day05-puzzle))
  ; (out) "Elapsed time: 4.007443 msecs"
  ; 331445006
  )
