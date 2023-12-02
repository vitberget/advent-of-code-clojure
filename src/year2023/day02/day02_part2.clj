(ns year2023.day02.day02-part2
  (:require
    [utils.text :refer [text->lines]]
    [year2023.day02.day02-data :refer [day02-example day02-puzzle]]
    [ysera.test :refer [is=]]
    [year2023.day02.day02-part1 :as part-1]))

(defn biggest-pick 
  [{red-1 :red blue-1 :blue green-1 :green}
   {red-2 :red blue-2 :blue green-2 :green}]
  {:red (max (or red-1 0) (or red-2 0))
   :blue (max (or blue-1 0) (or blue-2 0))
   :green (max (or green-1 0) (or green-2 0))})

(defn game->biggest-pick 
  {:test (fn[] (is= (game->biggest-pick (part-1/line->game "Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green"))
                    {:red 4 :green 2 :blue 6}))}
  [game]
  (->> game
       (:picks)       
       (reduce biggest-pick)))

(defn- power-pick [pick]
  (->> pick
       (vals)
       (apply *)))

(defn day02-part2
  {:test (fn []
           (is= (day02-part2 day02-example) 2286))} 
  [text]
  (->> text
       (text->lines)
       (map part-1/line->game)
       (map game->biggest-pick)
       (map power-pick)
       (apply +)))

(comment
  (time (day02-part2 day02-puzzle))
  ; (out) "Elapsed time: 5.772383 msecs"
  ; 71036
  )
