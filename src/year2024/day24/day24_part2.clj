(ns year2024.day24.day24-part2
  (:require
    [clojure.edn :as edn]
    [clojure.string :as str]
    [ysera.test :refer [is=]]
    [utils.text :as ut]
    [year2024.day24.day24-data :refer [day24-puzzle day24-example-4 day24-example-3 day24-example-3-fixed]]
    [year2024.day24.day24-part1 :as part-1]
    [utils.numbers :as un]))

(defn operator->styling 
  [operator]
  (condp = operator
    "AND" "[label=\"and\" style=filled fillcolor=lightblue]"
    "OR" "[label=\"or\" style=filled fillcolor=lightyellow]"
    "XOR" "[label=\"xor\" style=filled fillcolor=lightgreen]"
    ) 
  )

(defn gate->digraph
  [{left :left operator :operator right :right target :target :as gate}]
  (let [gate_name (str  operator "_" left  "_" right "_" target)]
  (str 
    "{ " left " " right "  } -> " gate_name " -> " target "\n"
    gate_name " " (operator->styling operator) "\n")))

(defn- same-rank-z 
  [gates]
  (str "{ rank = same;\n  "
       (->> gates
            (map :target)
            (filter (fn[s] (str/starts-with? s "z")))
            (sort)
            (str/join " -> "))
       " [style=invisible]\n  rankdir=LR\n}\n"))

(defn- same-rank-xy
  [gates]
  (str "{ rank = same;\n  "
       (->> gates
            (mapcat (fn[gate] (map gate [:left :right])))
            (filter (fn[s] (or (str/starts-with? s "x")
                               (str/starts-with? s "y"))))
            (into #{})
            (sort (fn [a b] (let [c1 (compare (subs a 1) (subs b 1))]
                              (if (zero? c1)
                                (compare (subs a 0 1) (subs b 0 1)) 
                                c1))))
            (str/join " -> "))
       " [style=invisible]\n  rankdir=LR\n}\n"))

(defn gates->digraph
  [gates]
  (str "digraph {\n"
       (str/join (map gate->digraph gates))
       (same-rank-z gates)
       (same-rank-xy gates)
       "}\n"))

(defn day24-part2
  {:test (fn []
           (is= (day24-part2 day24-example-3 2) "z00,z01,z02,z05"))}
  [text pairs]
  (let [input-and-gates (->> text
                             (part-1/text->inputs-and-gates))
        ran-input (part-1/run-it input-and-gates)]
    (->> (:gates input-and-gates)
         (gates->digraph)
         (spit "test.dot")
         )))
(comment
  (time (day24-part2 day24-puzzle 4))
  ; dot -Tpng test.dot > test.png
  ; Look for places where patterns break, make educated guesses...
  )
