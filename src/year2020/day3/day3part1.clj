(ns year2020.day3.day3part1
  (:require [ysera.test :refer [is is= is-not]]
            [clojure.string :as str]))

(defn day3
  {:test (fn []
           (is= (day3 "..##.......\n#...#...#..\n.#....#..#.\n..#.#...#.#\n.#...##..#.\n..#.##.....\n.#.#.#....#\n.#........#\n#.##...#...\n#...##....#\n.#..#...#.#"
                      3 1)
                7))}
  [forest delta-x delta-y]
  (let [forest (str/split-lines forest)
        forest-width (-> forest (first) (count))
        forest-height (count forest)]
    (loop [x 0
           y 0
           tree-hits 0]
      (let [r (nth forest y)
            c (nth r (mod x forest-width))
            tree-hits (+ tree-hits
                         (if (= c \#) 1 0))]
        (if (>= (inc y) forest-height)
          tree-hits
          (recur (+ x delta-x)
                 (+ y delta-y)
                 tree-hits))))))

(defn day3part2
  [forest list-of-deltas]
  (->> list-of-deltas
       (map (fn [delta-values] (apply day3 forest delta-values)))
       (reduce *)))

(comment
  (time
    (let [puzzle "..##.......\n#...#...#..\n.#....#..#.\n..#.#...#.#\n.#...##..#.\n..#.##.....\n.#.#.#....#\n.#........#\n#.##...#...\n#...##....#\n.#..#...#.#"]
      (day3 puzzle 3 1)))
  ;"Elapsed time: 0.482262 msecs"
  ;=> 7

  (time
    (let [puzzle "..##.......\n#...#...#..\n.#....#..#.\n..#.#...#.#\n.#...##..#.\n..#.##.....\n.#.#.#....#\n.#........#\n#.##...#...\n#...##....#\n.#..#...#.#"]
      (day3part2 puzzle
                 [[1 1]
                  [3 1]
                  [5 1]
                  [7 1]
                  [1 2]])))
  ;"Elapsed time: 2.708723 msecs"
  ;=> 336
  )