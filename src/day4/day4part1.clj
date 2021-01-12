(ns day4.day4part1
  (:require [ysera.test :refer [is is= is-not]]
            [clojure.string :as str]
            [clojure.set :as set]))


(defn string-kv->map
  {:test (fn []
           (is= (string-kv->map "a:b")
                {:a "b"}))}
  [string]
  (let [splt (str/split string #":")]
    {(keyword (first splt)) (second splt)}))

(defn passport-string->map
  {:test (fn []
           (is= (passport-string->map "hcl:#ae17e1")
                {:hcl "#ae17e1"})
           (is= (passport-string->map "hcl:#ae17e1 eyr:2020")
                {:hcl "#ae17e1" :eyr "2020"})
           (is= (passport-string->map "hcl:#ae17e1\neyr:2020")
                {:hcl "#ae17e1" :eyr "2020"}))}

  [string]
  (as-> string $
        (str/split $ #"\s+")
        (map string-kv->map $)
        (reduce merge $))

  )

(defn valid-passport?
  {:test (fn []
           (is (valid-passport? "ecl:gry pid:860033327 eyr:2020 hcl:#fffffd\nbyr:1937 iyr:2017 cid:147 hgt:183cm"))
           (is-not (valid-passport? "iyr:2013 ecl:amb cid:350 eyr:2023 pid:028048884\nhcl:#cfa07d byr:1929"))
           (is (valid-passport? "hcl:#ae17e1 iyr:2013\neyr:2024\necl:brn pid:760753108 byr:1931\nhgt:179cm"))
           (is-not (valid-passport? "hcl:#cfa07d eyr:2025 pid:166559648\niyr:2011 ecl:brn hgt:59in")))}
  [string]
  (let [passport (passport-string->map string)]
    (set/subset? #{:byr :iyr :eyr :hgt :hcl :ecl :pid}      ; not :cid
                 (set (keys passport)))))


(defn day4part1
  [string]
  (->> (str/split string #"\n\n")
       (filter valid-passport?)
       (count)))

(defn valid-byr?
  [passport]
  (when-let [byr (:byr passport)]
    (when (re-find #"^\d{4}$" byr)
      (let [byr (read-string byr)]
        (and (<= byr 2002)
             (>= byr 1920))))))

(defn valid-iyr?
  [passport]
  (when-let [iyr (:iyr passport)]
    (when (re-find #"^\d{4}$" iyr)
      (let [iyr (read-string iyr)]
        (and (<= iyr 2020)
             (>= iyr 2010))))))

(defn valid-eyr?
  [passport]
  (when-let [eyr (:eyr passport)]
    (when (re-find #"^\d{4}$" eyr)
      (let [eyr (read-string eyr)]
        (and (<= eyr 2030)
             (>= eyr 2020))))))

(defn valid-hgt?
  {:test (fn []
           (is (valid-hgt? {:hgt "60in"}))
           (is (valid-hgt? {:hgt "190cm"}))
           (is-not (valid-hgt? {:hgt "190in"}))
           (is-not (valid-hgt? {:hgt "60cm"}))
           (is-not (valid-hgt? {:hgt "190"}))
           (is-not (valid-hgt? {:hgt "190ab"}))
           )}
  [passport]
  (when-let [hgt (re-find #"^(\d+)(cm|in)$" (:hgt passport))]
    (let [number (read-string (nth hgt 1))
          unit (nth hgt 2)]
      (if (= "cm" unit)
        (and (>= number 150)
             (<= number 193))
        (and (>= number 59)
             (<= number 76))))))

(defn valid-hcl?
  {:test (fn []
           (is (valid-hcl? {:hcl "#123abc"}))
           (is-not (valid-hcl? {:hcl "#123ABC"}))
           (is-not (valid-hcl? {:hcl "blubb"}))
           (is-not (valid-hcl? {:hcl "123abc"}))
           )}
  [passport]
  (re-find #"^#[\da-f]{6}$" (:hcl passport)))

(defn valid-ecl?
  {:test (fn []
           (is (valid-ecl? {:ecl "amb"}))
           (is (valid-ecl? {:ecl "blu"}))
           (is-not (valid-ecl? {:ecl "noo"}))
           )}
  [passport]
  (contains? #{"amb" "blu" "brn" "gry" "grn" "hzl" "oth"}
             (:ecl passport)))

(defn valid-pid?
  {:test (fn []
           (is (valid-pid? {:pid "000000001"}))
           (is-not (valid-pid? {:pid "abcabcabc"}))
           (is-not (valid-pid? {:pid "0123456789"}))
           (is-not (valid-pid? {:pid "01234567"}))
           (is-not (valid-pid? {:pid "0123456a"}))
           )}
  [passport]
  (re-find #"^\d{9}$" (:pid passport)))

(defn valid-passport-part2?
  {:test (fn []
           (is-not (valid-passport-part2? "eyr:1972 cid:100\nhcl:#18171d ecl:amb hgt:170 pid:186cm iyr:2018 byr:1926"))
           (is-not (valid-passport-part2? "iyr:2019\nhcl:#602927 eyr:1967 hgt:170cm\necl:grn pid:012533040 byr:1946"))
           (is-not (valid-passport-part2? "hcl:dab227 iyr:2012\necl:brn hgt:182cm pid:021572410 eyr:2020 byr:1992 cid:277"))
           (is-not (valid-passport-part2? "hgt:59cm ecl:zzz\neyr:2038 hcl:74454a iyr:2023\npid:3556412378 byr:2007"))

           (is (valid-passport-part2? "pid:087499704 hgt:74in ecl:grn iyr:2012 eyr:2030 byr:1980\nhcl:#623a2f"))
           (is (valid-passport-part2? "eyr:2029 ecl:blu cid:129 byr:1989\niyr:2014 pid:896056539 hcl:#a97842 hgt:165cm"))
           (is (valid-passport-part2? "hcl:#888785\nhgt:164cm byr:2001 iyr:2015 cid:88\npid:545766238 ecl:hzl\neyr:2022"))
           (is (valid-passport-part2? "iyr:2010 hgt:158cm hcl:#b6652a ecl:blu byr:1944 eyr:2021 pid:093154719")))}
  [string]
  (let [passport (passport-string->map string)]
    (and passport
         (valid-byr? passport)
         (valid-iyr? passport)
         (valid-eyr? passport)
         (valid-hgt? passport)
         (valid-hcl? passport)
         (valid-ecl? passport)
         (valid-pid? passport)
         )))

(defn day4part2
  [string]
  (->> (str/split string #"\n\n")
       (filter valid-passport?)
       (filter valid-passport-part2?)
       (count)
       ))


(comment
  ;invalid
  (day4part2 "eyr:1972 cid:100\nhcl:#18171d ecl:amb hgt:170 pid:186cm iyr:2018 byr:1926\n\niyr:2019\nhcl:#602927 eyr:1967 hgt:170cm\necl:grn pid:012533040 byr:1946\n\nhcl:dab227 iyr:2012\necl:brn hgt:182cm pid:021572410 eyr:2020 byr:1992 cid:277\n\nhgt:59cm ecl:zzz\neyr:2038 hcl:74454a iyr:2023\npid:3556412378 byr:2007"
             )

  ;valid
  (day4part2 "pid:087499704 hgt:74in ecl:grn iyr:2012 eyr:2030 byr:1980\nhcl:#623a2f\n\neyr:2029 ecl:blu cid:129 byr:1989\niyr:2014 pid:896056539 hcl:#a97842 hgt:165cm\n\nhcl:#888785\nhgt:164cm byr:2001 iyr:2015 cid:88\npid:545766238 ecl:hzl\neyr:2022\n\niyr:2010 hgt:158cm hcl:#b6652a ecl:blu byr:1944 eyr:2021 pid:093154719"
             )
  )


