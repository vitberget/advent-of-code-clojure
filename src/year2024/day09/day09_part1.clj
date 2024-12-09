(ns year2024.day09.day09-part1
  (:require
    [utils.text :as ut]
    [year2024.day09.day09-data :refer [day09-puzzle]]
    [ysera.test :refer [is=]]))

(defn text->disk-map
  [text]
  (->> text
       (ut/line->digits)
       (map-indexed (fn [idx digit]
                      (if (even? idx)
                        {:type :files
                         :id-number (quot idx 2)
                         :size digit}
                        {:type :space
                         :size digit})))))

(defn add-numbers 
  {:test (fn[]
           (is= (add-numbers [1 2 3] 4 4)
                [1 2 3 4 4 4 4]))}
  [lst amount number]
  (loop [lst lst
         amount (dec amount)]
    (if (< amount 0)
    lst
    (recur (conj lst number)
           (dec amount)))))

(defn compact-files 
  {:test (fn[]
           (is= (compact-files (text->disk-map  "12345")) 
                (ut/line->digits "022111222"))
           (is= (compact-files (text->disk-map  "2333133121414131402"))
                (ut/line->digits "0099811188827773336446555566")))} 
  [disk-map]
  (loop [loopie 0 
         disk-map disk-map
         head {:type :space :size 0}
         tail {:type :space :size 0}
         result []]
    (cond 
      (and (= (:type head) :space)
           (nil? tail))
      result

      (and (nil? head)
           (= (:type tail) :files))
      (add-numbers result (:size tail) (:id-number tail))

      (= head {:type :space :size 0})
      (recur (inc loopie)
             (drop 1 disk-map)
             (first disk-map)
             tail
             result)

      (= (:type tail) :space)
      (recur (inc loopie)
             (drop-last disk-map)
             head
             (last disk-map)
             result)

      (= (:type head) :files)
      (recur (inc loopie)
             (drop 1 disk-map)
             (first disk-map)
             tail
             (add-numbers result (:size head) (:id-number head)))

      (and (= (:type head) :space)
           (<= (:size head) (:size tail)))
      (recur (inc loopie)
             (drop 1 disk-map)
             (first disk-map)
             (update tail :size - (:size head))
             (add-numbers result (:size head) (:id-number tail)))

      (and (= (:type head) :space)
           (> (:size head) (:size tail)))
      (recur (inc loopie)
             (drop-last 1 disk-map)
             (update head :size - (:size tail))
             (last disk-map)
             (add-numbers result (:size tail) (:id-number tail))))))

(defn calculate-checksum 
  [partition-data]
  (->> partition-data
       (map-indexed (fn [idx id-number] (* idx id-number)))
       (apply +)))

(defn day09-part1
  {:test (fn []
           (is= (day09-part1 "2333133121414131402") 1928))}
  [text]
  (->> text
       (text->disk-map)
       (compact-files)
       (calculate-checksum)))


(comment
  (time (day09-part1 day09-puzzle))
  ; (out) "Elapsed time: 5546.392343 msecs"
  ; 6291146824486
  )
