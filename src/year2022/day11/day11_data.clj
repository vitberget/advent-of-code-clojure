(ns year2022.day11.day11-data)

(def day11-example "Monkey 0:\n  Starting items: 79, 98\n  Operation: new = old * 19\n  Test: divisible by 23\n    If true: throw to monkey 2\n    If false: throw to monkey 3\n\nMonkey 1:\n  Starting items: 54, 65, 75, 74\n  Operation: new = old + 6\n  Test: divisible by 19\n    If true: throw to monkey 2\n    If false: throw to monkey 0\n\nMonkey 2:\n  Starting items: 79, 60, 97\n  Operation: new = old * old\n  Test: divisible by 13\n    If true: throw to monkey 1\n    If false: throw to monkey 3\n\nMonkey 3:\n  Starting items: 74\n  Operation: new = old + 3\n  Test: divisible by 17\n    If true: throw to monkey 0\n    If false: throw to monkey 1")
;Monkey 0:
;  Starting items: 79, 98
;  Operation: new = old * 19
;  Test: divisible by 23
;    If true: throw to monkey 2
;    If false: throw to monkey 3
;
;Monkey 1:
;  Starting items: 54, 65, 75, 74
;  Operation: new = old + 6
;  Test: divisible by 19
;    If true: throw to monkey 2
;    If false: throw to monkey 0
;
;Monkey 2:
;  Starting items: 79, 60, 97
;  Operation: new = old * old
;  Test: divisible by 13
;    If true: throw to monkey 1
;    If false: throw to monkey 3
;
;Monkey 3:
;  Starting items: 74
;  Operation: new = old + 3
;  Test: divisible by 17
;    If true: throw to monkey 0
;    If false: throw to monkey 1

(def day11-puzzle "Monkey 0:\n  Starting items: 72, 97\n  Operation: new = old * 13\n  Test: divisible by 19\n    If true: throw to monkey 5\n    If false: throw to monkey 6\n\nMonkey 1:\n  Starting items: 55, 70, 90, 74, 95\n  Operation: new = old * old\n  Test: divisible by 7\n    If true: throw to monkey 5\n    If false: throw to monkey 0\n\nMonkey 2:\n  Starting items: 74, 97, 66, 57\n  Operation: new = old + 6\n  Test: divisible by 17\n    If true: throw to monkey 1\n    If false: throw to monkey 0\n\nMonkey 3:\n  Starting items: 86, 54, 53\n  Operation: new = old + 2\n  Test: divisible by 13\n    If true: throw to monkey 1\n    If false: throw to monkey 2\n\nMonkey 4:\n  Starting items: 50, 65, 78, 50, 62, 99\n  Operation: new = old + 3\n  Test: divisible by 11\n    If true: throw to monkey 3\n    If false: throw to monkey 7\n\nMonkey 5:\n  Starting items: 90\n  Operation: new = old + 4\n  Test: divisible by 2\n    If true: throw to monkey 4\n    If false: throw to monkey 6\n\nMonkey 6:\n  Starting items: 88, 92, 63, 94, 96, 82, 53, 53\n  Operation: new = old + 8\n  Test: divisible by 5\n    If true: throw to monkey 4\n    If false: throw to monkey 7\n\nMonkey 7:\n  Starting items: 70, 60, 71, 69, 77, 70, 98\n  Operation: new = old * 7\n  Test: divisible by 3\n    If true: throw to monkey 2\n    If false: throw to monkey 3")
;Monkey 0:
;  Starting items: 72, 97
;  Operation: new = old * 13
;  Test: divisible by 19
;    If true: throw to monkey 5
;    If false: throw to monkey 6
;
;Monkey 1:
;  Starting items: 55, 70, 90, 74, 95
;  Operation: new = old * old
;  Test: divisible by 7
;    If true: throw to monkey 5
;    If false: throw to monkey 0
;
;Monkey 2:
;  Starting items: 74, 97, 66, 57
;  Operation: new = old + 6
;  Test: divisible by 17
;    If true: throw to monkey 1
;    If false: throw to monkey 0
;
;Monkey 3:
;  Starting items: 86, 54, 53
;  Operation: new = old + 2
;  Test: divisible by 13
;    If true: throw to monkey 1
;    If false: throw to monkey 2
;
;Monkey 4:
;  Starting items: 50, 65, 78, 50, 62, 99
;  Operation: new = old + 3
;  Test: divisible by 11
;    If true: throw to monkey 3
;    If false: throw to monkey 7
;
;Monkey 5:
;  Starting items: 90
;  Operation: new = old + 4
;  Test: divisible by 2
;    If true: throw to monkey 4
;    If false: throw to monkey 6
;
;Monkey 6:
;  Starting items: 88, 92, 63, 94, 96, 82, 53, 53
;  Operation: new = old + 8
;  Test: divisible by 5
;    If true: throw to monkey 4
;    If false: throw to monkey 7
;
;Monkey 7:
;  Starting items: 70, 60, 71, 69, 77, 70, 98
;  Operation: new = old * 7
;  Test: divisible by 3
;    If true: throw to monkey 2
;    If false: throw to monkey 3