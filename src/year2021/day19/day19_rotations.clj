(ns year2021.day19.day19-rotations)


(def rotations
  (for [x (range 0 271 90)
        y (range 0 271 90)
        z (range 0 271 90)]
    [x y z]))


(def cos {0   1
          90  0
          180 -1
          270 0})

(def sin {0   0
          90  1
          180 0
          270 -1})


(defn rotate-scanner-inner
  [scanner [pitch roll yaw]]
  (let [cosa (cos yaw)
        sina (sin yaw)

        cosb (cos pitch)
        sinb (sin pitch)

        cosc (cos roll)
        sinc (sin roll)

        axx (* cosa cosb)
        axy (- (* cosa sinb sinc) (* sina cosc))
        axz (+ (* cosa sinb cosc) (* sina sinc))

        ayx (* sina cosb)
        ayy (+ (* sina sinb sinc) (* cosa cosc))
        ayz (- (* sina sinb cosc) (* cosa sinc))

        azx (- sinb)
        azy (* cosb sinc)
        azz (* cosb cosc)]
    (reduce
      (fn [scanner [x y z]]
        (conj scanner [(+ (* axx x) (* axy y) (* axz z))
                       (+ (* ayx x) (* ayy y) (* ayz z))
                       (+ (* azx x) (* azy y) (* azz z))]))
      #{}
      scanner)))

(def rotate-scanner (memoize rotate-scanner-inner))