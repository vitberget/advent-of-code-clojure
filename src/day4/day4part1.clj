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


(comment
  (day4part1 "ecl:gry pid:860033327 eyr:2020 hcl:#fffffd\nbyr:1937 iyr:2017 cid:147 hgt:183cm\n\niyr:2013 ecl:amb cid:350 eyr:2023 pid:028048884\nhcl:#cfa07d byr:1929\n\nhcl:#ae17e1 iyr:2013\neyr:2024\necl:brn pid:760753108 byr:1931\nhgt:179cm\n\nhcl:#cfa07d eyr:2025 pid:166559648\niyr:2011 ecl:brn hgt:59in")


  )


