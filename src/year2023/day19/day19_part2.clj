(ns year2023.day19.day19-part2
  (:require
    [clojure.string :as str]
    [utils.text :refer [split-on text->lines text->paragraphs]]
    [year2023.day19.day19-data :refer [day19-example day19-puzzle]]
    [ysera.test :refer [is=]]))

(defn part->rule 
  [part]
  (if (str/includes? part ":")
    (let [[_ thing operator value target] (re-matches #"(\w+)([<>])(\d+):(.*)" part)]
      [(keyword thing) 
       operator
       (read-string value) 
       (keyword target)])
    (keyword part)))

(defn line->rule 
  [line]
  (let [[_ the-name rules ] (re-matches #"([a-z]+)\{(.*)\}" line)
        rules (split-on #"," rules)]
    {(keyword the-name) (map part->rule rules)}))
(defn text->rules
  [text]
  (let [[rules _] (text->paragraphs text)]
    (->> rules
         (text->lines)
         (map line->rule)
         (reduce merge))))

(defn extend-route [route rules]
  (->> (get rules (last route))
       (map (fn[part]
              (if (keyword? part)
                (conj route part)
                (let [[thing operator value target] part]
                  (conj route target)))))))

(defn routes-to-acceptance 
  [rules]
  (loop [accepted (list)
         current (list [:in])]
    (if (empty? current)
      accepted
      (let [{more-accepted true current false} 
            (->> current
                 (mapcat (fn [route] (extend-route route rules)))
                 (remove (fn [route] (= :R (last route))))
                 (group-by (fn [route] (= :A (last route)))))]
        (recur (concat accepted more-accepted)
               current)))))

(defn get-possible-values [route rules]
  (loop [[[from to] & route] (partition 2 1 route)
         possible-values {:x [1 4000] :m [1 4000] :a [1 4000] :s [1 4000]}]
    (let [rule (get rules from)
          part (->> rule
                    (filter (fn [part]
                              (if (= part to)
                                true
                                (when (not (keyword? part))
                                  (let [[thing operator value target] part]
                                    (= target to))))))
                    (first))
          possible-values (if (keyword? part)
                            possible-values
                            (let [[thing operator value target] part]
                              (update possible-values
                                      thing
                                      (fn [[low high]]
                                        (if (= operator ">")
                                          [(max low (inc value)) high]
                                          [low (min high (dec value))])))))]
      (if (= :A to)
        possible-values
        (recur route possible-values)))))


(defn day19-part2
  {:test (fn [] (is= (day19-part2 day19-example) 167409079868000))}
  [text]
  (let [rules  (text->rules text)
        possible-values (->> rules
                             (routes-to-acceptance)
                             (map (fn [route] (get-possible-values route rules)))
                             (distinct))
                ]
    possible-values
    ))
(comment
  ; Still work in progress
  (time (day19-part2 day19-puzzle))
  ;
  )
