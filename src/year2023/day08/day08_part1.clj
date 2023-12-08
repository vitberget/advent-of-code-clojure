(ns year2023.day08.day08-part1
  (:require
    [utils.text :refer [text->lines]]
    [year2023.day08.day08-data :refer [day08-example-1 day08-example-2
                                       day08-puzzle]]
    [ysera.test :refer [is=]]))

(defn line->network
  {:test (fn[] (is= (line->network "AAA = (BBB, CCC)") {:AAA [:BBB :CCC]} ))}
  [line]
  (let [matcher (re-matcher #"(\w{3}).*(\w{3}).*(\w{3})" line)
        [_ here left right] (re-find matcher)] 
    {(keyword here) [(keyword left) (keyword right)]}))

(defn text->map
  [text]
  (let [[instructions _ & network] (text->lines text)]
    {:instructions instructions
     :network (->> network
                   (map line->network)
                   (apply merge))}))

(defn get-instruction 
  {:test (fn[]
           (is= (get-instruction "RL" 0) \R)
           (is= (get-instruction "RL" 1) \L)
           (is= (get-instruction "RL" 2) \R))}
  [instruction step]
  (as-> step $
      (mod $ (count instruction))
      (nth instruction $)))

(defn walk-map
  [{instructions :instructions network :network}]
    (loop [current-location :AAA
           step 0]
      (if (= current-location :ZZZ)
        step
       
        (recur (if (= \L (get-instruction instructions step)) 
                 (get-in network [current-location 0])
                 (get-in network [current-location 1]))
               (inc step)))))

(defn day08-part1
  {:test (fn []
           (is= (day08-part1 day08-example-1) 2)
           (is= (day08-part1 day08-example-2) 6))}
  [text]
  (->> text
       (text->map)
       (walk-map)))

(comment
  (time (day08-part1 day08-puzzle))
  ; (out) "Elapsed time: 18.50981 msecs"
  ; 20221
  )
