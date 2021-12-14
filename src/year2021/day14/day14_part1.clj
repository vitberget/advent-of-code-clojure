(ns year2021.day14.day14-part1
  (:require [ysera.test :refer [is is= is-not deftest]]
            [year2021.day14.day14-data :refer [day14-example day14-puzzle]]
            [clojure.string :as str]))

(defn line->template-and-insert-rules
  [result line]
  (cond
    (str/blank? line)
    result

    (str/includes? line " -> ")
    (update result :rules conj (str/split line #" -> "))

    :else
    (assoc result :template line)))

(defn text->template-and-insert-rules
  [text]
  (->> text
       (str/split-lines)
       (reduce line->template-and-insert-rules
               {:template nil
                :rules    {}})))

(defn map-pair [acc [l1 l2] rules]
  (if-let [letter (get rules (str l1 l2))]
    (str acc letter l2)
    (str acc l2)))

(defn do-step
  {:test (fn []
           (let [{rules :rules} (text->template-and-insert-rules day14-example)]
             ;Template:     NNCB
             ;After step 1: NCNBCHB
             (is= (do-step "NNCB" rules) "NCNBCHB")
             ;After step 2: NBCCNBBBCBHCB
             (is= (do-step "NCNBCHB" rules) "NBCCNBBBCBHCB")))}
  [template rules]
  (reduce #(map-pair %1 %2 rules)
          (first template)
          (partition 2 1 template)))

(defn calc-min-max
  [min-max]
  (- (:max min-max)
     (:min min-max)))

(defn max-min
  [max-min [_ v]]
  (-> max-min
      (update :min min v)
      (update :max max v)))

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
         (reduce max-min
                 {:min Long/MAX_VALUE
                  :max 0})
         (calc-min-max))))

(comment
  (time (day14-part1 day14-puzzle))
  ;"Elapsed time: 234.362717 msecs"
  ;=> 4517
  )
