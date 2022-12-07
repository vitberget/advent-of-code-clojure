(ns year2022.day7.day7-part1
  (:require
    [clojure.string :as str]
    [utils.text :as ut]
    [year2022.day7.day7-data :refer [day7-example day7-puzzle]]
    [ysera.test :refer [is=]]))

(defn text->dir-structure
  {:test (fn []
           (is= (text->dir-structure day7-example)
                ;- / (dir)
                ;  - a (dir)
                ;    - e (dir)
                ;      - i (file, size=584)
                ;    - f (file, size=29116)
                ;    - g (file, size=2557)
                ;    - h.lst (file, size=62596)
                ;  - b.txt (file, size=14848514)
                ;  - c.dat (file, size=8504156)
                ;  - d (dir)
                ;    - j (file, size=4060174)
                ;    - d.log (file, size=8033020)
                ;    - d.ext (file, size=5626152)
                ;    - k (file, size=7214296)
                {"/" {"a"     {"e"     {"i" 584}
                               "f"     29116
                               "g"     2557
                               "h.lst" 62596}
                      "b.txt" 14848514
                      "c.dat" 8504156
                      "d"     {"j"     4060174
                               "d.log" 8033020
                               "d.ext" 5626152
                               "k"     7214296}}}))}
  [text]
  (let [lines (ut/text->lines text)]
    (loop [[current-line & lines] lines
           dir-structure {}
           cwd []]
      (cond
        (nil? current-line)
        dir-structure

        (= current-line "$ ls")
        (recur lines dir-structure cwd)

        (str/starts-with? current-line "$ cd ")
        (let [dir (-> current-line
                      (subs 5)
                      (str/trim))]
          (if (= dir "..")
            (recur lines
                   dir-structure
                   (vec (drop-last cwd)))
            (recur lines
                   dir-structure
                   (conj cwd dir))))

        :else
        (let [[info name] (str/split current-line #" " 2)]
          (if (= info "dir")
            (recur lines
                   (update-in dir-structure
                              (conj cwd name)
                              #(or % {}))
                   cwd)
            (recur lines
                   (assoc-in dir-structure
                             (conj cwd name)
                             (read-string info))
                   cwd)))))))

(defn size-of-dir
  {:test (fn []
           (is= (size-of-dir {"i" 584})
                584)
           (is= (size-of-dir {"e"     {"i" 584}
                              "f"     29116
                              "g"     2557
                              "h.lst" 62596})
                94853))}
  [dir]
  (->> dir
       (map (fn [[_ v]]
              (if (map? v)
                (size-of-dir v)
                v)))
       (reduce +)))

(defn new-cwd
  [cwd path]
  (cond
    (empty? cwd)
    path

    (= cwd "/")
    (str cwd path)

    :else
    (str cwd "/" path)))

(defn dir-structure->dir-sized-internal
  [dir-map dir-structure cwd]
  (reduce-kv
    (fn [dir-map key val]
      (if (map? val)
        (let [cwd (new-cwd cwd key)]
          (-> dir-map
              (dir-structure->dir-sized-internal val cwd)
              (assoc cwd (size-of-dir val))))
        dir-map))
    dir-map
    dir-structure))

(defn dir-structure->dir-sized
  {:test (fn []
           (is= (dir-structure->dir-sized {"a" {"e"     {"i" 584}
                                                "f"     29116
                                                "g"     2557
                                                "h.lst" 62596}})
                {"a/e" 584
                 "a"   94853})
           (is= (dir-structure->dir-sized (text->dir-structure day7-example))
                {"/a/e" 584
                 "/a"   94853
                 "/d"   24933642
                 "/"    48381165}))}
  [dir-structure]
  (dir-structure->dir-sized-internal {} dir-structure ""))

(defn day7-part1
  {:test (fn []
           (is= (day7-part1 day7-example) 95437)
           (is= (day7-part1 day7-puzzle) 1915606))}
  [text]
  (->> text
       (text->dir-structure)
       (dir-structure->dir-sized)
       (vals)
       (filter #(<= % 100000))
       (reduce +)))

(comment
  (time (day7-part1 day7-puzzle))
  ;"Elapsed time: 6.972852 msecs"
  ;=> 1915606
  )
