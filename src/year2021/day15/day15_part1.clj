(ns year2021.day15.day15-part1
  (:require [ysera.test :refer [is is= is-not deftest]]
            [year2021.day15.day15-data :refer [day15-example day15-puzzle]]
            [clojure.string :as str]))

(defn char->number
  [digit-char]
  (- (int digit-char)
     (int \0)))

(defn line->risk-map
  [y line]
  (->> line
       (map-indexed (fn [x char]
                      {[x y] (char->number char)}))
       (reduce merge)))

(defn text->risk-map
  [text]
  (->> text
       (str/split-lines)
       (map-indexed line->risk-map)
       (reduce merge)))

(defn path->paths
  {:test (fn []
           (let [risk-map (text->risk-map day15-example)]
             (is= (path->paths [[0 0]] risk-map)
                  (list [[0 0] [1 0]]
                        [[0 0] [0 1]]))))}
  [path risk-map]
  (let [[x y :as lpos] (last path)]
    (->> (list [-1 0] [1 0] [0 -1] [0 1])
         (map (fn [[dx dy]]
                [(- x dx) (- y dy)]))
         (filter #(contains? risk-map %1))
         (map (fn[pos] [lpos pos])))))

(defn paths->paths
  {:test (fn []
           (let [risk-map (text->risk-map day15-example)]
             (is= (paths->paths (list [[0 0]]) risk-map)
                  (list [[0 0] [1 0]]
                        [[0 0] [0 1]]))
             (is= (paths->paths (list [[0 0]] [[2 2]]) risk-map)
                  (list [[0 0] [1 0]]
                        [[0 0] [0 1]]
                        [[2 2] [3 2]]
                        [[2 2] [1 2]]
                        [[2 2] [2 3]]
                        [[2 2] [2 1]]))))}
  [paths risk-map]
  (->> paths
       (pmap #(path->paths % risk-map))
       (apply concat)))

(defn score-path
  {:test (fn []
           (let [risk-map (text->risk-map day15-example)]
             (is= (score-path [[0 0] [0 1]] risk-map) 1)))}
  [path risk-map]
  (->> path
       (drop 1)
       (map #(get risk-map %))
       (reduce + 0)))

(defn score-path-with-shortest
  [path risk-map shortest-map]
  (let [[p n] (take-last 2 path)]
    (+ (get shortest-map p)
       (get risk-map n))))

(defn do-a-round
  [shortest-map paths risk-map]
  (loop [shortest-map shortest-map
         [new-path & new-paths] (paths->paths paths risk-map)
         paths (list)]
    (if (nil? new-path)
      [shortest-map paths]

      (let [path-score (score-path-with-shortest new-path risk-map shortest-map)
            test-pos (last new-path)
            test-val (get shortest-map test-pos)]
        (if (or (nil? test-val)
                (< path-score test-val))
          (recur
            (assoc shortest-map test-pos path-score)
            new-paths
            (conj paths new-path))
          (recur
            shortest-map
            new-paths
            paths))))))

(defn do-risk-map
  [risk-map max-pos]
  (loop [counter 0
         shortest-map {[0 0] 0}
         paths (list [[0 0]])]
    (when (and (not= 0 counter) (= 0 (mod counter 25)))
      (println "counter" counter (count paths))
      )
    (cond (> counter (+ 500 500 500))
          "counter"

          (empty? paths)
          (get shortest-map max-pos)

          :else
          (let [[shortest-map paths] (do-a-round shortest-map paths risk-map)]
            (recur
              (inc counter)
              shortest-map
              paths)))))

(defn day15-part1
  {:test (fn []
           (is= (day15-part1 day15-example) 40))}
  [text]
  (let [risk-map (text->risk-map text)
        max-pos (reduce (fn [[mx my] [[x y] _]]
                          [(max mx x) (max my y)])
                        [0 0]
                        risk-map)]
    (do-risk-map risk-map max-pos)))

(comment
  (time (day15-part1 day15-puzzle))
  ;"Elapsed time: 415.067808 msecs"
  ;=> 527
  )
