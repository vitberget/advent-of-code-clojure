(ns year2021.day13.day13-part2
  (:require [ysera.test :refer [is is= is-not deftest]]
            [year2021.day13.day13-data :refer [day13-example day13-puzzle]]
            [year2021.day13.day13-part1 :as part1]))

(defn render-dots
  [dots]
  (let [max-x (->> dots
                   (map first)
                   (reduce max)
                   (inc))
        max-y (->> dots
                   (map second)
                   (reduce max)
                   (inc))]
    (doseq [y (range 0 max-y)]
      (doseq [x (range 0 max-x)]
        (print (if (contains? dots [x y])
                 \#
                 \ )))
      (println))))

(defn day13-part2
  [text]
  (as-> text $
        (part1/text->paper $)
        (reduce part1/fold-paper
                $
                (:folds $))
        (:dots $)
        (render-dots $)))

(comment
  (time (day13-part2 day13-example))
  (time (day13-part2 day13-puzzle))
  ;###  #  # #  # #### ####  ##  #  # ###
  ;#  # # #  #  # #       # #  # #  # #  #
  ;#  # ##   #### ###    #  #    #  # ###
  ;###  # #  #  # #     #   # ## #  # #  #
  ;# #  # #  #  # #    #    #  # #  # #  #
  ;#  # #  # #  # #    ####  ###  ##  ###

  ;RKHFZGUB

  ;"Elapsed time: 8.425496 msecs"
  ;=> nil
  )