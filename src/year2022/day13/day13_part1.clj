(ns year2022.day13.day13-part1
  (:require [utils.text :as ut]
            [year2022.day13.day13-data :refer [day13-example day13-puzzle]]
            [ysera.test :refer [is is-not is=]]))

(defn compare-things
  [a b]
  (cond
    (and (nil? a) b)
    -1

    (and a (nil? b))
    1

    (and (nil? a) (nil? b))
    0

    (and (number? a) (number? b))
    (compare a b)

    (and (number? a) (seqable? b))
    (compare-things [a] b)

    (and (seqable? a) (number? b))
    (compare-things a [b])

    (and (seqable? a) (seqable? b))
    (loop [[ia & a] a
           [ib & b] b]
      (if (and (nil? ia) (nil? ib))
        0
        (let [res (compare-things ia ib)]
          (if (zero? res)
            (recur a b)
            res))))))

(defn right-order?
  {:test (fn []
           (is (right-order? "[1,1,3,1,1]\n[1,1,5,1,1]"))
           (is (right-order? "[[1],[2,3,4]]\n[[1],4]"))
           (is-not (right-order? "[9]\n[[8,7,6]]"))
           (is (right-order? "[[4,4],4,4]\n[[4,4],4,4,4]"))
           (is-not (right-order? "[7,7,7,7]\n[7,7,7]"))
           (is (right-order? "[]\n[3]"))
           (is-not (right-order? "[[[]]]\n[[]]"))
           (is-not (right-order? "[1,[2,[3,[4,[5,6,7]]]],8,9]\n[1,[2,[3,[4,[5,6,0]]]],8,9]")))}
  [paragraph]
  (let [[a b] (ut/text->lines paragraph)
        a (read-string a)
        b (read-string b)]
    (neg? (compare-things a b))))

(defn day13-part1
  {:test (fn []
           (is= (day13-part1 day13-example) 13)
           (is= (day13-part1 day13-puzzle) 5843))}
  [text]
  (->> text
       (ut/text->paragraphs)
       (map right-order?)
       (map-indexed (fn [i v] [(inc i) v]))
       (filter (fn [[_ v]] v))
       (map first)
       (reduce +)))

(comment
  (time (day13-part1 day13-puzzle))
  ;"Elapsed time: 26.051062 msecs"
  ;=> 5843
  )
