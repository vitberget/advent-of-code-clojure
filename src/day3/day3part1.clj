(ns day3.day3part1
  (:require [ysera.test :refer [is is= is-not]]
            [clojure.string :as str]))







(defn day3
  {:test (fn []
           (is= (day3 "..##.......\n#...#...#..\n.#....#..#.\n..#.#...#.#\n.#...##..#.\n..#.##.....\n.#.#.#....#\n.#........#\n#.##...#...\n#...##....#\n.#..#...#.#"
                      3 1)
                7))}
  [forest right down]
  (let [forest (str/split forest #"\n")
        forest-width (-> forest (first) (count))
        forest-height (count forest)]
    (loop [x 0
           y 0
           cnt 0]
      (let [r (nth forest y)
            c (nth r (mod x forest-width))
            hit-tree (= c \#)
            hit-tree-cnt (+ cnt (if hit-tree 1 0))]
        (if (= (inc y) forest-height)
          hit-tree-cnt
          (recur
            (+ x right)
            (+ y down)
            hit-tree-cnt))))))


(defn day3part2
  [forest list-steps]

  (->> list-steps
       (map (fn [s] (apply day3 forest s)))
       (reduce *)
       ))

(comment

  (day3 "..##.......\n#...#...#..\n.#....#..#.\n..#.#...#.#\n.#...##..#.\n..#.##.....\n.#.#.#....#\n.#........#\n#.##...#...\n#...##....#\n.#..#...#.#"
        3 1)

  (day3part2 "..##.......\n#...#...#..\n.#....#..#.\n..#.#...#.#\n.#...##..#.\n..#.##.....\n.#.#.#....#\n.#........#\n#.##...#...\n#...##....#\n.#..#...#.#"
             [[1 1]
              [3 1]
              [5 1]
              [7 1]
              [1 2]])
  )