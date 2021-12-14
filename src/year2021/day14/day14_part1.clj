(ns year2021.day14.day14-part1
  (:require [ysera.test :refer [is is= is-not deftest]]
            [year2021.day14.day14-data :refer [day14-example day14-puzzle]]
            [clojure.string :as str]))

(defn text->template-and-insert-rules
  [text]
  (->> text
       (str/split-lines)
       (reduce (fn [tair line]
                 (cond
                   (str/blank? line)
                   tair

                   (str/includes? line " -> ")
                   (let [[two one] (str/split line #" -> ")]
                     (update tair :rules conj {two one}))

                   :else
                   (assoc tair :template line)))
               {:template nil
                :rules    {}})))

(defn do-step
  {:test (fn []
           (let [{rules :rules} (text->template-and-insert-rules day14-example)]
             ;Template:     NNCB
             ;After step 1: NCNBCHB
             (is= (do-step "NNCB" rules) "NCNBCHB")
             ;After step 2: NBCCNBBBCBHCB
             (is= (do-step "NCNBCHB" rules) "NBCCNBBBCBHCB")))}
  [template rules]
  (reduce (fn [acc [l1 l2]]
            (if-let [letter (get rules (str l1 l2))]
              (str acc letter l2)
              (str acc l2)))
          (first template)
          (partition 2 1 template)))

(defn calc-min-max
  [min-max]
  (- (:max min-max) (:min min-max)))

(defn day14-part1
  {:test (fn []
           (is= (day14-part1 day14-example) 1588))}
  [text]
  (let [{rules :rules template :template} (text->template-and-insert-rules text)
        final-string (reduce (fn [template _]
                               (do-step template rules))
                             template
                             (range 10))]
    (->> final-string
         (frequencies)
         (reduce (fn [max-min [_ v]]
                   (-> max-min
                       (update :min min v)
                       (update :max max v)))
                 {:min Long/MAX_VALUE
                  :max 0})
         (calc-min-max))))

(comment
  (time (day14-part1 day14-puzzle))
  ;"Elapsed time: 234.362717 msecs"
  ;=> 4517
  )
