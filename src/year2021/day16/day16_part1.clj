(ns year2021.day16.day16-part1
  (:require [ysera.test :refer [is is= is-not deftest]]
            [year2021.day16.day16-data :refer [day16-example day16-puzzle]]
            [year2021.day16.day16-bits :refer [text->bits bits->number]]))

(defn bits->type
  [bits]
  (condp = (take 3 bits)
    [1 0 0] :literal-value
    :operator))

(defn bits->packet-version-and-type
  {:test (fn []
           (is= (bits->packet-version-and-type (text->bits "8A004A801A8002F478"))
                {:version 4
                 :type    :operator
                 :size    6})
           (is= (bits->packet-version-and-type (text->bits "D2FE28"))
                {:version 6
                 :type    :literal-value
                 :size    6}))}
  [bits]
  {:version (->> bits
                 (take 3)
                 (bits->number))
   :type    (->> bits
                 (drop 3)
                 (take 3)
                 (bits->type))
   :size    6})

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
                [{:version 1
                  :type    :operator
                  :packets [{:version 6
                             :type    :literal-value
                             :value   10
                             :size    11}
                            {:version 2
                             :type    :literal-value
                             :value   20
                             :size    16}]
                  :size    49}])
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
                [{:version 7
                  :type    :operator
                  :size    51
                  :packets [{:version 2
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
                          (assoc :packets ipackets))
               ]
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

(defn count-versions
  [packets]
  (reduce (fn [total {type :type version :version packets :packets}]
            (if (= type :literal-value)
              (+ total version)
              (+ total version (count-versions packets))))
          0
          packets))

(defn day16-part1
  {:test (fn []
           (is= (day16-part1 "8A004A801A8002F478") 16)
           (is= (day16-part1 "620080001611562C8802118E34") 12)
           (is= (day16-part1 "C0015000016115A2E0802F182340") 23)
           (is= (day16-part1 "A0016C880162017C3686B18A3D4780") 31))}
  [text]
  (->> text
       (text->bits)
       (bits->packet)
       (count-versions)))


(comment
  (time (day16-part1 day16-puzzle))
  ;"Elapsed time: 32.357011 msecs"
  ;=> 1038
  ;
  )
