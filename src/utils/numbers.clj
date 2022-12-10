(ns utils.numbers
  (:require [ysera.test :refer [is is= is-not deftest]]))


(defn limit
  {:test (fn []
           (is= (limit 3 0 2) 2)
           (is= (limit -30 -2 2) -2)
           (is= (limit 1 0 2) 1))}
  [val lower-limit higher-limit]
  (cond
    (< val lower-limit)
    lower-limit

    (> val higher-limit)
    higher-limit

    :else val))
