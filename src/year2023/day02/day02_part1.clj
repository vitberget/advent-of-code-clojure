(ns year2023.day02.day02-part1
  (:require
    [clojure.string :as str]
    [utils.text :refer [split-on text->lines]]
    [year2023.day02.day02-data :refer [day02-example day02-puzzle]]
    [ysera.test :refer [is= is is-not]]))

(defn pick->map 
  {:test (fn [] (is= (pick->map "3 blue, 4 red") {:blue 3 :red 4}))}
  [pick]
  (->> pick
       (split-on #",")
       (map str/trim) 
       (map (fn[part] (split-on #" " part)))
       (map (fn [[amount color]] {(keyword color) (read-string amount)}))
       (apply merge)))

(defn line->game 
  {:test (fn[]
           (is= (line->game "Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green")
                {:id 1
                 :picks [{:blue 3 :red 4}
                         {:red 1 :green 2 :blue 6}
                         {:green 2}]}))}
  [line]
  (let [[game picks] (str/split line #":" )]
    {:id (->> game
              (split-on #" ")
              (second)
              (read-string))
     :picks (->> picks
                 (split-on #";")
                 (map pick->map))}))

(defn possible-pick? 
  {:test (fn[]
           (is (possible-pick? {:red 5}))
           (is-not (possible-pick? {:red 15})))}
  [game]
  (and (<= (get game :red 0) 12)
       (<= (get game :green 0) 13)
       (<= (get game :blue 0) 14)))

(defn possible-picks? [games]
  {:test (fn[]
           (is (possible-picks? [{:red 5}]))
           (is (possible-picks? [{:red 5} {:blue 5}]))
           (is-not (possible-picks? [{:red 15}]))
           (is-not (possible-picks? [{:red 15}{:blue 18}]))
           (is-not (possible-picks? [{:red 15}{:blue 18}{:red 20}])))}
  (loop [[game & games] games]
    (cond
      (nil? game)
      true

      (possible-pick? game)
      (recur games)

      :else
      false)))

(defn day02-part1
  {:test (fn [] 
           (is= (day02-part1 day02-example) 8)
           (is= (day02-part1 day02-puzzle) 2204))}
  [text]
  (->> text
       (text->lines)
       (map line->game)
       (filter (fn [game] (possible-picks? (:picks game))))
       (map :id)
       (apply +)))

(comment
  (time (day02-part1 day02-puzzle))
  ; (out) "Elapsed time: 7.545165 msecs"
  ; 2204
  )
