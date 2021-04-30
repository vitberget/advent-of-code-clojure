(ns year2020.day24.day24part2
  (:require [ysera.test :refer [is is= is-not deftest]]
            [year2020.day24.day24example :refer [example-part1]]
            [clojure.string :as str]
            [clojure.set :as set]))

(defn line->instructions
  {:test (fn []
           (is= (line->instructions "esew") [:e :se :w]))}
  [line]
  (as-> line $
        (str/replace $ "e" "e,")
        (str/replace $ "w" "w,")
        (str/split $ #",")
        (map keyword $)))


(defn new-x [instruction x y]
  (condp = instruction
    :e (inc x)
    :w (dec x)

    :nw (if (odd? y) (dec x) x)
    :sw (if (odd? y) (dec x) x)

    :ne (if (odd? y) x (inc x))
    :se (if (odd? y) x (inc x))

    x))

(defn new-y [instruction y]
  (condp = instruction
    :nw (dec y)
    :ne (dec y)

    :sw (inc y)
    :se (inc y)

    y))

(defn follow-instruction
  [[x y] instruction]
  [(new-x instruction x y)
   (new-y instruction y)])

(defn get-surrounding
  [position]
  (->> [:e :w :ne :nw :se :sw]
       (map (fn [direction]
              (follow-instruction position direction)))
       (into #{})))

(defn instructions->position
  [instructions]
  (reduce follow-instruction [0 0] instructions))

(defn string->black-positions
  [string]
  (->> string
       (str/split-lines)
       (map line->instructions)
       (map instructions->position)
       (frequencies)
       (filter (fn [[_ v]] (odd? v)))
       (map first)
       (into #{})))

(defn black-pos-or-nil
  [position blacks]
  (let [surrounding-blacks (->> position
                                (get-surrounding)
                                (filter (fn [sp] (contains? blacks sp)))
                                (count))]
    (if (contains? blacks position)
      (when (or (= surrounding-blacks 1)
                (= surrounding-blacks 2))
        position)
      (when (= surrounding-blacks 2)
        position))))

(defn conway-do
  [blacks]
  (let [test-positions (->> blacks
                            (map get-surrounding)
                            (reduce set/union)
                            (set/union blacks))]
    (->> test-positions
         (map (fn [pos] (black-pos-or-nil pos blacks)))
         (filter identity)
         (into #{}))))

(defn conway-ish
  {:test (fn []
           (let [start-state (string->black-positions example-part1)]
             (is= (conway-ish 1 start-state) 15)
             (is= (conway-ish 2 start-state) 12)
             (is= (conway-ish 3 start-state) 25)
             ))}
  [rounds blacks]
  (loop [rounds rounds
         blacks blacks]
    (if (zero? rounds)
      (count blacks)
      (recur (dec rounds)
             (conway-do blacks)))))

(defn day24part2
  {:test (fn []
           (is= (day24part2 example-part1)
                2208))}
  [string]
  (->> string
       (string->black-positions)
       (conway-ish 100)))

(comment
  (let [puzzle "seweswweswnwseeeesenwneseeseee\nwwswwwnewnenwsweneswwwwwseww\neneneeesweeneneeeswnene\nnenwswwsenenwnwnenenenenwnesenwnenenenenene\neneeenwneseneeseseseswsewswseswsenwe\neeneneenenwneseneesweneene\nwwwwnenenwwwwwswsww\nwnwnwenwnwnwnwnenwwwnwnwnwseswnwnenw\nsewsweswnwnweswswnwswe\nswenwnwnenwnwnweneeswsenwswneswneswsew\nseswsweseswneswswneswnwsenwswsenwswsesenw\nswsenesewswnenwnewseswseenwnweseseseew\nsenwseswseswnwswswswseseeseseseswswesw\neeeeneeenweneeeeneesweenewwne\nsewnwnwnwnwnwnwnwswnwwnenwnwnwnwnwnwnwe\nswenenwneenwwnwwenwwnwwenwseswswnwe\nseswseseeseswnwswswse\nnenenenwswnenenenenene\nwnwseswwwnwwswwswswseswnewwswseww\nseeswwnenewwnwswsenewwswwwswswsww\nwnesewnwwnwnenwwewsewnwneeseseswwnw\nnesewsesesesesesewsweseseseseewnwsw\nswswswsewseeswswswswswneswswwsewsesenesw\nnesewswwwswswwwwswswwsewnwswnesew\nseseesweswnweeswseenwnenweenwwe\nswswnweswnwswswswseswseswswswsesesww\nnwenenwsenenwnwnenenwneneneneneneneswnesw\neenwewnwsesweesesenwnewnwnwsenesw\nwswswswneseseseswse\nnwnwnwnwnwenwnwnwwnwsenwnwnenwnwnenew\nswsesesewseeseseseseneeseenwesesesese\nneseneswsenewsesenwwwswswsenweswnee\nswswnwwswsweswswswwswswwwneswwswsw\nswswswnewwswswnesweswwswwswnwwwww\nneeesewnwnenweswswnwswsenenenwsenwsene\nnwnwswnwswenwwwnwwenweenwwnwnww\nneswswnwswsenwwswswsweswseswsw\nneweeneneseeweeeseeeneswnweene\nswenwneswsewswneswwnwswnwswswswswswwe\nnenwswneswnenwsenwnenwsew\nnwnwnwnenwnwswwnwnwnwneswsenenwnenenwnwnw\nwseswsewnewseswswnweseseneswswnenenwse\nneeeeeswneneneneneneeneeswnwnwneee\neneswneenwnenwsewswseeeenwseseew\nswswswsewseeswenwseenwseswswswseswnwswse\nseseeseewseseeseswsesenenwseseseeenee\nneswswswswswswnwwswswwswswsewswnesww\nwsenenwneneneswnwnwnenenenwnenwnenenwnw\nwnwsenesenwwswsewsweenwwwwwswsw\nswnwneseswseswnwswsewseswswseswswsweeswsw\nseswswswnwneswswwnwswseswnwseswswswenesw\nnwnwnwnwnwsenwnwnwwenwnw\nnweeeeeeeeeeeswseenewsewne\nneneneneseneeesenewwnwenewneneswne\nnwwnwnwnwnwnwnwwwwsenwewnw\nnwswnenenwneneseneneseenwnwnwnenwne\nseneneneneeeenwsenenwsweeneeenenene\nwnwwnwwnwswwswwnwnwnenwwwnwnwne\nswwenewswwweewswswwswnwswswnwsw\nnewneswsenenwsenenwswesenwnwnwnenwnenese\nneneswneweneneneeneneeeeeneesenw\nseweseswsewsenwesenenwsese\nnewewseneesweswseneswnenewwsenwe\nnesenwsewnwnwseswnwswsenenwewwnwsene\nnwnewwsenewwnesewwse\nswswesweneneneswenwswnenenesenewnee\nswnwseenwnewneneseewne\nnwwwnwnwenwnwwnwnwnwnw\neseseneswneseswsesenwwwsewnesesesee\nnenwnwnwnwnwnwnwnwnwnenenwnwnesewsenesw\nnenenenenenwneneswswnenenwwnwneneneenw\nseswseswneewneswwseseswseseswswseswswse\nwsewneseeseseseseneswsesesenesese\nsweswswwswswswswswswswwneesweeww\nneswswnwswswswswwswswsweseeswswswewsw\nnwneenesenwswenenesenwswnenenewsenene\neweeeeeneeseesenwesweeeeee\nwseeenwnweeswnesweeneeenenwseee\nesenwseseesenwwseeeeeeeseesee\nwwwnewwwswwsewwwewnewwwnwwse\nswswseswseswsenwswswnwseswseswesenwese\nsenwseseseseenwseeseseseseeseswsesese\nwewnewwswnwwnewnwswswseewwsww\nwswswswswswwswswnwweeswwwwwww\neeenweewenesweeeeeseee\nswwswesewswsenewwneswwwswwneeww\nnwnwnenenwseneseenenwnenwnenwnenwswnenw\nswwswsweeswwswwswwswneswwwnesesesw\nnwneswneneneneneenwneneswnenenenenwnenw\nnwwwswsewesenwwsweneswnenwseswwsw\nsesesesewseneseseseseseesewsewsesesene\nnenwneeswswswsewswnwnwwswneswsenew\nsenenwnwswnwswesewswnwnwnwnweenwneneswse\nesewweeeeesenwneeseesweeeene\nnewwseseeseeseseseseseenwewsesese\nseneseeeswweeesewneseseewseene\nswseeseseeseswsewnweneswnwenesewnwse\neweneeewesenwneeneenewenesesw\nwswnwneseswswnenenenwenenenewneneenw\nseeneswsesewseseswnesenwseswswnwsesese\nseewesewewsenewneneneswsenwesese\nsenwnwnwsewnwnwnwswnewnwnwenwnenenwswnwnw\nswnwnwnenwwwsenwnenwnwnwnwenwwesewnwnw\nseswswneswswswswswswwswneseswswwswswswsw\nneseneswnenwwnenenwnwwnesenwnenwnenene\nnwseseswswwswsewseswenwnwweeswesese\nseneswswswseenweewswnewswwswnwswswne\nsesenwswneeenwswseswswneewnenwneswe\newewwwwwswwnwswwwnwewwww\nswnenewesewwwswwsewwnwswwnwnene\nwswnwsenwnwswenwnwenwnweswwwneee\nweenewswswewnwnweesewnwsweswwsw\neeseeeseeeweeeseneeee\nwnwenwnwnwenwnwnwnwnwswweneneswswnee\nseseseswsewnwsewseeesenwseseswesese\nweweesweeneeneeseeeweeseee\nswseneesweenwneswnenwneewwwswswsw\nnesewwenesenenwneneeneneneese\nesesenewnwnweseseweeeeeeeswsw\nnwswwwneswswseeswswnwswswnewsenwswesw\nweeeseeseseseesesewnesenweeese\nsewsesewnesesesesewneseeenesenwesese\nswsesesenesenwsesewseseswseswseseswswse\nneswswswwswswswswwswswswswswsw\nnwnwnwnwnwnenwnwnwnwsenwnewnenw\nseneneenwnwnwneswnwnwnenwnwnwnwnwnwnenw\nswnweeeeeeeesew\nneseswwnweeeeswseeseeeseeeswene\neeneeeseeneeseeeeewneeenwsw\nsenwswseesesesesweeenwseee\nwwwwswwwsewswswswnewwswneswwsew\neseeneseeseswwseeweeeeneeee\nwwnewwwwwwswwswwwewwwnewsew\nsewwneeeeeesweeswenesesweneee\nnenwnwenwnwswnwnwwswnww\nswswseneswswesesenwsesewseswsesesesesenw\nseeseseenwweseseseneeseeeeseese\nnewnenwseswwnwwwwnw\nswwnewewwwwwwwwsewwwnwwwnw\nswwnwnwnwswenwnwneenw\nwnwnwswnenwnwweswweseswwswwewsw\nnwenwnwnenwswewswnwnwenwnwnwwnwnenw\nesewseseseeeeneseseeeewsenesw\nswwwswwnwwnwwweswswsewwswwnesw\nsenwswnenwnwneenwswnwnwneenwnwnwnenwnww\nwwnwwwwwwnewewwwwwsenwswsww\nnwnwnwnwnwsewnwnwnwnwnw\nswnweseswseseswenwwseneseneswnweswswsw\nenenenewseseneseeeneneeneenenwnwne\nneneneewwenesenenenenwneneneneneene\nneeeneeeneneweeeneee\nneseeswswswnwswwswswwswswnwswwswswsw\nwwwnenewwnweseseswsenewnwnwnwwse\nswwwwsewswswswswswswswwsweneswsw\nseneseeseswsesesesesewseseseswsenw\nnwwwwnwnwwnwsenwwwwww\nwwwwwswnewewseneseswnewswwseewnw\nneswnweeswneewwneeeeeneneenenese\nneneeneewewsesewnwseeene\nseneneneenwnwnwnwnenwnwnenwnwnenwnwswwe\nwswswwwseswneswwswwsw\nnenwnwesewneneewwwseswwsw\nwnewnwwwwwnwnwewwwwswewseww\nseeeeseenwsenweswsesesesenwseseee\nnenwwsenenwnwnenwnenwnenenesenwnwnwnwnw\nwwnwsewwswnewwswewwwwwwsww\nseseseeeeseesenwseseseseseese\nnweseseseswenesesesesewseseseseseneese\nnwswswswwswsweswwsweswswswswswneswsw\nwwwsewwwsewwwwwnwwenewnww\nnwwnwwwwnwwsesenenwnwwwnwnwwwnw\nnewnewsewswneenesenenenenenwnesenwe\nwnwswswnwwenwnweenwnwewnw\nnewnenesweneseenenenee\nnesweneneneneseewneweeweewswee\nwwwwswwwwwwwewww\nnwnwsweswwnwnewnwnwnwnenwswwnwneswnw\nesenesewswswswswswseswseseswswsw\nnwnenenwwnesenenesweneswnenenenesenene\nswwewnwwnewwwweswnwsewwnwnenw\nswwwneseweseswwswneneswneneseswswnesw\nnenwwneneneswnenenenenwnenenenesenw\nswswswswseswswnwswseswswsw\nswswswsweseswswswwswswswswneswswwsww\nneseswseswseswswneneswswsewwswneswswsw\nswwswwswwwswnwwwwwwswesww\nswswsesewnwswswswseseseswswswne\nnwseswswswswswseswseswse\nsesewwsesewseesenesenwwseseesesesee\nswnwwswswswsweswswwswswswswswswsw\nnwnenenwnwnwsenenwwnwsenwseewnwesenww\nwwswnwwwwenwwwwwnwsenewewwne\nwsenesenwwnesenesenww\neeeeeswnwseseeeseneswenwsewswsee\nswwwewwwewwswwwswnw\neeneswnweeswseeenwseeswnwweseee\nnenwnwswneenenenwwnenwswneneneneneeenwsw\nseseseswneesewwsenwseseesese\nnewnenenenwneseneenewnenenenesenenenenw\nnenwswweseeswsenwsenwsewneswseneswnw\neeneewsenweeeneesewee\nnwwnwwsewnwwwwwnwnenwsenweww\nneneneswnewnenwneneswnenenenenenenwnesene\nseseeseseswseesesenwseseswswsesenwsww\nseeswnenwswwnenesenenwnwnwnenenenenene\nwneneneswnenenwnwwee\nnewswwwwsewnwseswneenwwseewnewne\nswswwwwswneeswwweseswnew\nswnwseeseeewesweneeswenwswwwne\neweseeeeeeeeeenweseeeeenw\nwwnwwsenewwwwwwnwnewseswswwsew\nneeseseeeesesesesesesesenwsewsesew\nnwnenwnenenenenwnwnenenenenenwenenesesw\nsenenenwnenenenenenewneneneene\nsenwseswwseswswseseneswswswswsenwseee\nnenwwnesenenwseswsenewnenwswnenese\nnenwnwnwsenwnwnwwwnwnwwwwnwwnw\nseseeswsenwneeeesewwsenesenenwsewse\neeseeesenwseesweeewenwsesesee\neswnwnwwsenwnwnwwnwwne\nswswsesenwswseswswswesw\nnwwnwwnwnwnwnwnwnwse\nnewsesenwnwsewsenenewwse\nswnwnwwsenwnwnenenwnwnenwnw\nswswwnewewwsesenewnwseswswswswswsw\neeeneseeeseseeseeeweseese\nneneneneneneseswenweseneweenewnwene\nnwnwwnwnwnwnwnwnwwnwnwnwnwnwesenwnenw\nsenenenewswseeenwswesweeneene\nnwnwnwenwnwnwnewsenwnwnenwsenenenwnwwnw\nnwswswswseswswnwswswseswesenwswswswseseswsw\nsenwwnesenwswseseswseseswenwswesesee\nweeseeeeseenee\nnwnenwnwswnwnwnwnweswnenwswsee\nwwwnewwwnwewneswneswnwswwsenwnww\nwseswneeseseswenwsesenwnenewse\nseneenwswnewneneeeeneeeneneneenenwne\nsweneweeseeeseeeneewseee\neswseseenwsesesesewseenenwswnwseeswse\nswneswwnwwwwwwseswwswwswswwsene\nsesenesewswsesenesesesesesesesesesesese\nweneweswewseseeeeneeseeenee\nseeseeseenesweseesweeeeswneenwe\nweseewnweeeswseseeeswswnewsenene\nnenesenenenwnwnenesenenenwnenwwnwnwnenesew\nnwweeeeeeeeeeseeseee\nneswnenenenwnenenenwnwnwnwnenwne\nneneenweeeswwseeswswenweweswnenw\nwnwnwnwswewnwwwnewwnewnwwsenwnw\nseeswseseswnewnwsesesesesesesesenewnwse\nwnewsewewwwnwnwweeswwwnwswnw\nseeseeseeeeeeeeeeenwweneew\neeeeseenwsweesenwnweeesenwswee\nswwswnwseswswswswswswsweneswswswswswsw\nnwnenwwnwwnwenwnwnwsenwnwnwnwwnwnww\nswnewneneenewnenwswnwsenewnwneesee\nwwwwwsewwwwnwnewnwwnenwseswnw\nswsewweweswwwswnwwewwnewwwe\nwnwenwswswwwwwwwwwwswewwne\nnenenenenenenenenenenesesenenwnenwwnenwe\nnwnenwenwenwwnwsenwnwnwwsenwnwnwwnwnw\nseswnwnenwenwseswwenesenewneswnwnwnene\nenenenwswnwnwnwnenenesenwnwsenwwnwnwnw\nswsewwsewseenwnwnewnwwwnwnwnewse\nseseswnwswswswswwseswne\nnwwnwsewnwnwnwnwnwnwnwnwnwenwnwswnwnwe\nswnenenesesenenenenwnenenewnesewneenene\nseswsewswseseswseswswswnewneseswseswse\nnwsewsenwnwnwwnwnwwswnewnenwwsewwwnw\nseeeeseneswnwneenenwnenwneesenwe\nwwneeenewseeesesesesweeesesese\nswwswswsewseswswneneewneeswnwsesewe\nnwneswswswsweswseswswswswseswswswnewswsw\nnwnwwsenwwnwnwnwnwwwwnwnwenwsenwww\nneenwswnwneenwnwwnwnenwnwswnwswnwnwe\nnwswnwnwnwwnwswnwnwnwnwswneewnwnwnwnwenw\nswswneseswseeeeeeseseneseesenwsewe\nneseesesesewseweeweeneswseeeene\nswseeswsesewswswseseeswseswnwsenwswnese\nswwswwswsewswwswnwswseswwnenwswsww\nnwneewnwnwnwnwwnwnwnwnwseswwnenwnwnwse\nnwnwenenwnwnwnwwwenenewneswe\neseeneeneneeseneweenweneeewsw\nwswswswsewswswnewweswnewwwswwwsw\nnewnenenwenenenenwnene\nswwnwwswwwswwwenwwwewwwswwsw\nneneeneneswwneneenenwseneeneneneeenwne\nnewnwswsweswseseswnwnwswswswseseswnee\neneeneeneweneneneswnweneesenenene\nsweeeswnwneeneneenweeeneesw\nneswsenwesesesesweseseweseseeeese\nnwseswnwnwswneneenwnwnwwwnenesenenwnenw\nsweeeeseeneesweseesenwneesweee\nwwswneesewnwseseeeeweswesewsww\nsesweswswseeswswsenwswswswwseswneswsesww\nswneneneeseneenewnew\nsesewsesenwnwesesesewseeeseswsesesese\nswseswseswswewswnenwswneenwnwneswne\nneneneneneneneneswenenenenwsw\nweswwnwwwnwwswswnwnwewweeenwnw\nwnwwwwwnwwswwnwnwsewnwwnwwwewe\nnwwswwswnwneswsewseeswseseswnewnenwnesw\nnwnwnweswsenwsenwswnesenwwnwsenwswee\nnwwneseswswweseswseswswnenewseswswnww\neeesweneenwneeeneneswesewneswneene\nweeneswswewseeeeeeenwneee\nnwnwnwenwnwnwnwwwnwsewsewwwnenwnw\nneenenwwneneeswseneswnewnene\nenwnwnwnwnwnwnwnwnwenwsenwnwwswnwnwnwnwnw\nwnwswseseneseseseswsesesewsenweeseew\nswnweswnesenesewseneseseseenweeseew\nnwseeeseseeseesesenwswneseseweseesw\nwwwswwswneswwwwweww\nseswwenwseneewneeneeswneneeswnwnew\nnwswseswwwneswswswswwnwseswswesweswsw\nsewswwwwswswsenwsenewwwwwwnwsww\nnenenenenenwswnenenenenenenene\nseseneseseesenwswsewseswswseseseswseseese\nswwnesewnwseneswnenesweeeneswewne\nnwnwnwwwnwwnwwnwnwswewenwnwnwnwnw\nnwnwnwswwnwwsesenwnwwnwsenwenweneswnwnw\nseswseeswnwseseswseswseswseseswseseswnw\nswswsweswswsenewneswswsenwwswswswswe\nsweswswswwwswswwnewwswnewswswnesw\nweseseswswseseswsese\nwnwwnwwwwwwwewwnwnw\nneseeeseeswnwwnesee\nnenesewswnesenenenwwnwnenweseeswwenw\nseseseneswwsewnwweeeewnesesesesese\nseswnewnwsenwswseseswsenwseesesesesesesese\nneneneswnenwnwnesenenenenwnenesenesenenene\nswneswswnewsenesweswseswwseswswswswsesw\nnwnwneswsweeeneeneeeneneesenwnenene\nsenwnwswnwnweswwnwsenwswnwnesenwswwee\neneseswenwneseswneesenwwneeweewwsw\nseewswswswenwnwwwnwnwnwwnwnwwnwne\neneenwnewswnwnewsewseneeswnwenesww\nnenesenenenenwnesesenesewnenwnenwwnenese\neenesewsweeeweseweeeseneseee\nweneeseesenesesesesesesesewesesee\nswswwswwwswwwswnwswwnesweswwneswwsw\nneswneseneneewnenenwsenwnenewneneenew\nneseeswsweswwseeneenenewwnenwene\neeeneeneeeeweeeeee\nnwenwwwwnwwwwwwwnw\nnwswnwnwnwnwwnwnwnwnwsenwsewenwnwnwnw\nswseneneneswnenenwnenenwneneswnenenenee\nnenwnenwsenwnwnwwnwnenwnene\neeneeeeneeeeeeenesw\nesweeeweseeeneneeenwseeswnwswswne\nnenenenwnesenwnenenwnenenenenene\nswnwewswwswnwswwswswnesweswswswwse\nwenwneneenesweeneneeeeseneenenwe\nnwnewnwnwenwswswnwnenwsenwee\nwswnwesenwwswswewneswwweweswwnenw\nseweswneeswneswneneeneneneneenewnesee\nnenwnwnewneeneeeesweneneswneneswne\nnenwenenenenenesweneneneeenenewee\nnesenwneneneneneneseneswnwnenenenwnewse\nwnwwsesewsewwswwneswneswwnewswww\nnwnwsenenwnwnwnwnwwwenenwwwwswwww\nneeseeeseseeseeseeesw\nneneneswnwneneseneswwneseeneewne\nnwswsewwswswewwwwwwwwwnwswsw\nswswseseneseesenesenwswsesesesese\neenwwseswwwswsweeswswswswswswsese\neswneswswswswswnewwswswswweswenwe\nnwseseswseswswseseseseseswnwseseneswsesw\nswseeswenwseeeeseseneseseeeesenee\nseeseswwwsesewseseseseseeeenwesee\nseswswseseseseseseseeswenwswswswnwsesenese\nnwnwwnwsenwwnwnwnwwnwnwnw\nnenwnwswnwnweswnwnwenenwneeneswnwnenw\nneenewneneneneeneenenwewnesenenene\nswswwwnwwnenwswsesewsewww\nnwnwnwwneeswswnwesenwnwsewnwwenwnwsww\nwsewwwnenwsewwwsewwnewnwwsww\nneeneneesweswneeewsweneneenenwenee\nnwnewneeneneeseswesewenwneswneewe\nwswwnewswswswswneswswswwwswsw\nnwwwneneswsenewnwneeeswsweneswenwe\nwswswswwswnenewewswswswwnwswseswsewsw\nnewwnwnwnwnenwnweswnenwnenwnwsenenene\nnenwnenenenenenenwwnweneswnenenwsesenew\nsesenwnewnwnwnwswsweswnwswwwwsewsee\nwnwnwsenwnwnwnwnwenenwseeswnenwswnwsesw\nnwnwwnwnwnenwsenwnwswnwenwswnwwenwnw\neeeeseseseeeeeweseneweesee\neswesewenweneeneeseseeseeeee\nenenewnenenenenesweswnewnesenenenenenene\nswnweeenwnenwnwewneswnewwswwenw\nsweswseeesweeeeneeseeeeeneesenw\nwnwnwswnwnenwnwnwnwnwneswnweswnwnenenw\nswswswswswswwswwnwswsweswswewswwsw\nnwenwnewwnwswwnwnwesenwsesenewnwnwnw\nwwswwwwwwwwsenw\nswwnwsewwnewwnwswnwnewwnwnwnwne\neeeesenweeenenenenweeeeswe\nenesweswswewswswseswnwswnw\neswseswnwsenwsewesenenewwwseesenwse\nsesewwnewwnewwwewwwnwswnwwww\nnenenewnenenenenesenenenenenenenene\nnenwnenenwnenwnewnwnenesenenwneswnwnwswne\nseseeswnwnwseswsesewseeseseesewesenw\nswsenewsewswseneseseeeeseswnweenwse\neswwnwwwewwswne\nsewseneewswswseswwseeseswewseswnw\nwswwwwwsewwwwwwwwwnwsenew\nwnwnenenwswwwwewswsewwwesenwe\nwweewnwnwsesenwwewnwwwwwsww\nneenwneneeswnwnwneseenesene\nnenwsenewnwnenwneswnenenwenwwne\nneeseneenwneseenwseenewneswneenesew\nnwnwnewnwnwwneswenwnwnwwnwsenwsenwwnw\nneneweneseneewwswwnwnwsenwnewnenesene\nnwnwnwnwnwnwnwnwnwwswenewnwnwnwenwnesw\nweseeneeneeeeseeesesenwnwswswese\nsenenesewnenenwnenenenewnenenenene\nwnwsenwnwwsenwnewwnwenwwwnwnwnww\nenwnwnwnwnwsweswnwsenwnwwneneswwnwe\neswnenenwneneweneneeneenenenenwswe\nnesesewseswseseeseswsesenesesesesenese\nswnwneswnenenwswesweeesweewnweenwsw\nswnwnwswswswwseneewwneewswwswswsw\newnwswnenwwwswnwsenwnwnwnwwwwwnewnw\nseseseseseeeesenw\nnwnwwnwswwenwwnwnwnwnwswnwnwnwenwnwnw\nnenwnenenenesenwnwswnwneneswnwenenwneese\nwnwwwwswwewewwwwswnewwwsww\nnwswsewswwswneswswnewswwswseswnwww\nneenewneneneswenwwnewnwnwnenwsesenw\nseseesesesesesesesesweswwsenwsesesese\nnwewnwswneseseseewsesenwseseseeseese\newneeeeeeesweewenewse\nwnwwwwwwwwnwnwwsenenwwwwenw\nwseswswswswwnenenwwewenwswnew\nnenwsenenwnwnwnwnwwnwnwnw\nwneeneenenenwsesewnewwsenenwswswsw\neeeeenweeswewsweeeeeenwee\nwenwseswseswswnwswswswswneswseswseee\nnenenwnwwenwnwnwnwnwnwnwnw\nwsewwwnwnewwwwwwwwsewwww\nwwwwswnwwswwswewenwswwwwnwswwse\nseneswwwwewnewwwwswwswwswwwe\nnesewswneswswnwwwsewwwwswswwnesw\nswewseswnwnwswweseeswwswnwnweswsw\nnwnwnwenwnwswwsenewswnwnwnwnweenwnwsw\nswenwswswseswswswswswswswswwswseseese\nnwseswnwneswwswwnweeswewnwnwwwew\nnwseswwnwenwewwnwnwswwnwnwnwnwseww\nenweneeeeeeeenwsweesweew\nnesenenwnwwwnwwswnwnwnwwnwwse\nweneeeseseneeenweeeneneenwewe\nsenwnwnwnwswneneswnwnwnewnwsenwwnesee\nnwneseneswnenenwnwnwwnw\nwnwnwwswnwnwnwnwesewnwnwswnwnwwnwnenwe\nnwswwswswwseewsweseswneeneseesew\nenwwnwwswwswenwwsweenwnwewnwse\nseewwwswnwwswwwwswswewwswswwnw\nnenwnenwneenwsenenewnwwnenwnwnenwnw\nswswseseswswswneswswswswswswsesweswsenwsene\nneneneswswneneseneweswnenwseswseswwsw\nwwweneswwwwwswsenew\nswswswnwseswswswswswswswsw\nnwnenesenenwnenwnwnwnw\neeesenwseeswseeeenwneswseeenwsenew\nseeeeseseeswsesenweeeewsewsese\nswseneswswseneswnwswswseseswseseswwsewsesw\nnwswnenenwneenwsenwswnwnenenwnwnwsenenwsw\nnwseseeeenwswswnwswese\nnweneneenenwsenenenenese\nwswswswwwwewwwneswwesewneswwswnw\nnwsenwwnenwnenwsenewnwnwnesenenenwnwne\nnenwswnwenwseswnenwwnwnwnwnwwenwnenenw\nwseswweswenenwswwswseneewwwnew\nseeswseseesewenenwswewe\nswswwswswsenenwneswseswswswswswswswswsw\nwnwsewsenenenwnwsewnwwenenwswnwnwsenw\nseneeseeneswsesenweseswweeswsenwswe\nnenenenwnwneenewesesenenenenewsenenene\neneeneeeeeeeeseenew"]
    (time (day24part2 puzzle)))
  ;"Elapsed time: 4100.903443 msecs"
  ;=> 3837
  )