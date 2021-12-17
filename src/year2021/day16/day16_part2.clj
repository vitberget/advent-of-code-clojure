(ns year2021.day16.day16-part2
  (:require [ysera.test :refer [is is= is-not deftest]]
            [year2021.day16.day16-data :refer [day16-example day16-puzzle]]
            [year2021.day16.day16-bits :refer [text->bits bits->number]]))

(defn bits->type
  [bits]
  (condp = (take 3 bits)
    [1 0 0] :literal-value
    :operator))

(defn bits->operator-type
  [bits]
  (condp = (take 3 bits)
    [0 0 0] :sum
    [0 0 1] :product
    [0 1 0] :minimum
    [0 1 1] :maximum
    ;[1 0 0] :literal-value
    [1 0 1] :greater-than
    [1 1 0] :less-than
    [1 1 1] :equal-to)
  )

(defn bits->packet-version-and-type
  {:test (fn []
           (is= (bits->packet-version-and-type (text->bits "8A004A801A8002F478"))
                {:version       4
                 :type          :operator
                 :operator-type :minimum
                 :size          6})
           (is= (bits->packet-version-and-type (text->bits "D2FE28"))
                {:version 6
                 :type    :literal-value
                 :size    6}))}
  [bits]
  (let [type-bits (->> bits
                       (drop 3)
                       (take 3))
        type (bits->type type-bits)
        packet {:version (->> bits
                              (take 3)
                              (bits->number))
                :type    type
                :size    6}]
    (merge packet
           (when (= :operator type)
             {:operator-type (bits->operator-type type-bits)}))))

(defn complete-literal-packet
  [packet bits]
  (loop [packet packet
         data-bits (list)
         bits bits]
    (let [not-last (= 1 (first bits))
          data-bits (concat data-bits (->> bits
                                           (drop 1)
                                           (take 4)))
          packet (update packet :size + 5)]
      (if not-last
        (recur packet
               data-bits
               (drop 5 bits))
        (assoc packet :value (bits->number data-bits))))))

(defn bits->packet
  {:test (fn []
           (is= (bits->packet (text->bits "D2FE28"))
                [{:version 6
                  :type    :literal-value
                  :value   2021
                  :size    (+ 3 3 5 5 5)}])
           (is= (bits->packet (text->bits "38006F45291200"))
                [{:version       1
                  :type          :operator
                  :operator-type :less-than
                  :packets       [{:version 6
                                   :type    :literal-value
                                   :value   10
                                   :size    11}
                                  {:version 2
                                   :type    :literal-value
                                   :value   20
                                   :size    16}]
                  :size          49}])
           (is= (bits->packet [0 1 0 1 0 0 0 0 0 0 1 1 0 0 1 0 0 0 0 0 1 0 0 0 1 1 0 0 0 0 0 1 1 0 0 0 0 0] 3)
                [{:version 2
                  :type    :literal-value
                  :value   1
                  :size    11}
                 {:version 4
                  :type    :literal-value
                  :value   2
                  :size    11}
                 {:version 1
                  :type    :literal-value
                  :value   3
                  :size    11}])
           (is= (bits->packet (text->bits "EE00D40C823060"))
                [{:version       7
                  :type          :operator
                  :operator-type :maximum
                  :size          51
                  :packets       [{:version 2
                                   :type    :literal-value
                                   :value   1
                                   :size    11}
                                  {:version 4
                                   :type    :literal-value
                                   :value   2
                                   :size    11}
                                  {:version 1
                                   :type    :literal-value
                                   :value   3
                                   :size    11}]}])
           (is= (bits->packet [1 1 0 1 0 0 0 1 1 1 1])
                [{:version 6
                  :type    :literal-value
                  :size    11
                  :value   15}]))}
  ([bits] (bits->packet bits Long/MAX_VALUE))
  ([bits max-packets]
   (loop [packets []
          packet nil
          bits bits]
     (cond
       (= :literal-value (:type packet))
       (let [packet (complete-literal-packet packet bits)]
         (recur (conj packets packet)
                nil
                (drop (- (:size packet) 6) bits)))

       (= :operator (:type packet))
       (if (= 0 (first bits))
         (let [bits (drop 1 bits)
               size (->> bits
                         (take 15)
                         (bits->number))
               bits (drop 15 bits)
               packet (-> packet
                          (update :size + 16 size)
                          (assoc :packets (bits->packet (take size bits))))
               bits (drop size bits)]
           (recur (conj packets packet)
                  nil
                  bits))
         (let [bits (drop 1 bits)
               nums (->> bits
                         (take 11)
                         (bits->number))
               bits (drop 11 bits)
               ipackets (bits->packet bits nums)
               size (->> ipackets
                         (map :size)
                         (reduce +))
               bits (drop size bits)
               packet (-> packet
                          (update :size + 12 size)
                          (assoc :packets ipackets))]
           (recur (conj packets packet)
                  nil
                  bits)))
       (< (count bits) 8)
       packets

       (= (count packets) max-packets)
       packets

       (nil? packet)
       (recur packets
              (bits->packet-version-and-type bits)
              (drop 6 bits))))))

(defn do-the-math
  [{packets       :packets
    value         :value
    operator-type :operator-type}]
  (let [values (map do-the-math packets)]
    (condp = operator-type
      nil value                                             ; literal-value
      :sum (apply + values)
      :product (apply * values)
      :minimum (apply min values)
      :maximum (apply max values)
      :greater-than (if (apply > values) 1 0)
      :less-than (if (apply < values) 1 0)
      :equal-to (if (apply = values) 1 0))))

(defn day16-part2
  {:test (fn []
           (is= (day16-part2 "C200B40A82") 3)               ; 1 + 2
           (is= (day16-part2 "04005AC33890") 54)            ; 6 * 9
           (is= (day16-part2 "880086C3E88112") 7)           ; min 7 8 9
           (is= (day16-part2 "CE00C43D881120") 9)           ; max 7 8 9
           (is= (day16-part2 "D8005AC2A8F0") 1)             ; 5 < 15
           (is= (day16-part2 "F600BC2D8F") 0)               ; 5 > 15
           (is= (day16-part2 "9C005AC2F8F0") 0)             ; 5 == 15
           (is= (day16-part2 "9C0141080250320F1802104A08") 1) ; 1 + 3 == 2 * 2
           )}
  [text]
  (->> text
       (text->bits)
       (bits->packet)
       (first)
       (do-the-math)))

(comment
  (time (day16-part2 day16-puzzle))
  ;"Elapsed time: 31.282986 msecs"
  ;=> 246761930504
  )