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
                        [[0 0] [0 1]]))
             ))}
  [path risk-map]
  (let [[x y] (last path)]
    (->> (list [-1 0] [1 0] [0 -1] [0 1])
         (map (fn [[dx dy]]
                [(- x dx) (- y dy)]))
         (filter #(contains? risk-map %1))
         (map #(conj path %1)))))

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
  [paths riskmap]
  (->> paths
       (mapcat #(path->paths % riskmap))))

(defn score-path
  {:test (fn []
           (let [risk-map (text->risk-map day15-example)]
             (is= (score-path [[0 0] [0 1]] risk-map) 1)))}
  [path risk-map]
  (->> path
       (drop 1)
       (map #(get risk-map %))
       (reduce + 0)))

(defn do-a-round
  [shortest-map paths risk-map]
  (loop [shortest-map shortest-map
         [new-path & new-paths] (paths->paths paths risk-map)
         paths (list)]
    (if (nil? new-path)
      [shortest-map paths]

      (let [path-score (score-path new-path risk-map)
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

(defn day15-part1
  {:test (fn []
           (is= (day15-part1 day15-example) 40))}
  [text]
  (let [risk-map (text->risk-map text)
        max-pos (reduce (fn [[mx my] [[x y] _]]
                          [(max mx x) (max my y)])
                        [0 0]
                        risk-map)]
    (loop [counter 0
           shortest-map {[0 0] 0}
           paths (list [[0 0]])]
      (cond (> counter 500)
            "counter"

            (empty? paths)
            (get shortest-map max-pos)

            :else
            (let [[shortest-map paths] (do-a-round shortest-map paths risk-map)]
              (recur
                (inc counter)
                shortest-map
                paths))))))

(comment
  (time (day15-part1 day15-puzzle))
  ;"Elapsed time: 4925.663232 msecs"
  ;=> 527
  )
