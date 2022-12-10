(ns year2022.day10.day10-data)

(def day10-example "addx 15\naddx -11\naddx 6\naddx -3\naddx 5\naddx -1\naddx -8\naddx 13\naddx 4\nnoop\naddx -1\naddx 5\naddx -1\naddx 5\naddx -1\naddx 5\naddx -1\naddx 5\naddx -1\naddx -35\naddx 1\naddx 24\naddx -19\naddx 1\naddx 16\naddx -11\nnoop\nnoop\naddx 21\naddx -15\nnoop\nnoop\naddx -3\naddx 9\naddx 1\naddx -3\naddx 8\naddx 1\naddx 5\nnoop\nnoop\nnoop\nnoop\nnoop\naddx -36\nnoop\naddx 1\naddx 7\nnoop\nnoop\nnoop\naddx 2\naddx 6\nnoop\nnoop\nnoop\nnoop\nnoop\naddx 1\nnoop\nnoop\naddx 7\naddx 1\nnoop\naddx -13\naddx 13\naddx 7\nnoop\naddx 1\naddx -33\nnoop\nnoop\nnoop\naddx 2\nnoop\nnoop\nnoop\naddx 8\nnoop\naddx -1\naddx 2\naddx 1\nnoop\naddx 17\naddx -9\naddx 1\naddx 1\naddx -3\naddx 11\nnoop\nnoop\naddx 1\nnoop\naddx 1\nnoop\nnoop\naddx -13\naddx -19\naddx 1\naddx 3\naddx 26\naddx -30\naddx 12\naddx -1\naddx 3\naddx 1\nnoop\nnoop\nnoop\naddx -9\naddx 18\naddx 1\naddx 2\nnoop\nnoop\naddx 9\nnoop\nnoop\nnoop\naddx -1\naddx 2\naddx -37\naddx 1\naddx 3\nnoop\naddx 15\naddx -21\naddx 22\naddx -6\naddx 1\nnoop\naddx 2\naddx 1\nnoop\naddx -10\nnoop\nnoop\naddx 20\naddx 1\naddx 2\naddx 2\naddx -6\naddx -11\nnoop\nnoop\nnoop")
;addx 15
;addx -11
;addx 6
;addx -3
;addx 5
;addx -1
;addx -8
;addx 13
;addx 4
;noop
;addx -1
;addx 5
;addx -1
;addx 5
;addx -1
;addx 5
;addx -1
;addx 5
;addx -1
;addx -35
;addx 1
;addx 24
;addx -19
;addx 1
;addx 16
;addx -11
;noop
;noop
;addx 21
;addx -15
;noop
;noop
;addx -3
;addx 9
;addx 1
;addx -3
;addx 8
;addx 1
;addx 5
;noop
;noop
;noop
;noop
;noop
;addx -36
;noop
;addx 1
;addx 7
;noop
;noop
;noop
;addx 2
;addx 6
;noop
;noop
;noop
;noop
;noop
;addx 1
;noop
;noop
;addx 7
;addx 1
;noop
;addx -13
;addx 13
;addx 7
;noop
;addx 1
;addx -33
;noop
;noop
;noop
;addx 2
;noop
;noop
;noop
;addx 8
;noop
;addx -1
;addx 2
;addx 1
;noop
;addx 17
;addx -9
;addx 1
;addx 1
;addx -3
;addx 11
;noop
;noop
;addx 1
;noop
;addx 1
;noop
;noop
;addx -13
;addx -19
;addx 1
;addx 3
;addx 26
;addx -30
;addx 12
;addx -1
;addx 3
;addx 1
;noop
;noop
;noop
;addx -9
;addx 18
;addx 1
;addx 2
;noop
;noop
;addx 9
;noop
;noop
;noop
;addx -1
;addx 2
;addx -37
;addx 1
;addx 3
;noop
;addx 15
;addx -21
;addx 22
;addx -6
;addx 1
;noop
;addx 2
;addx 1
;noop
;addx -10
;noop
;noop
;addx 20
;addx 1
;addx 2
;addx 2
;addx -6
;addx -11
;noop
;noop
;noop

(def day10-puzzle "addx 1\nnoop\nnoop\nnoop\naddx 5\naddx 5\nnoop\nnoop\naddx 9\naddx -5\naddx 1\naddx 4\nnoop\nnoop\nnoop\naddx 6\naddx -1\nnoop\naddx 5\naddx -2\naddx 7\nnoop\naddx 3\naddx -2\naddx -38\nnoop\nnoop\naddx 32\naddx -22\nnoop\naddx 2\naddx 3\nnoop\naddx 2\naddx -2\naddx 7\naddx -2\nnoop\naddx 3\naddx 2\naddx 5\naddx 2\naddx -5\naddx 10\nnoop\naddx 3\nnoop\naddx -38\naddx 1\naddx 27\nnoop\naddx -20\nnoop\naddx 2\naddx 27\nnoop\naddx -22\nnoop\nnoop\nnoop\nnoop\naddx 3\naddx 5\naddx 2\naddx -11\naddx 16\naddx -2\naddx -17\naddx 24\nnoop\nnoop\naddx 1\naddx -38\naddx 15\naddx 10\naddx -15\nnoop\naddx 2\naddx 26\nnoop\naddx -21\naddx 19\naddx -33\naddx 19\nnoop\naddx -6\naddx 9\naddx 3\naddx 4\naddx -21\naddx 4\naddx 20\nnoop\naddx 3\naddx -38\naddx 28\naddx -21\naddx 9\naddx -8\naddx 2\naddx 5\naddx 2\naddx -9\naddx 14\naddx -2\naddx -5\naddx 12\naddx 3\naddx -2\naddx 2\naddx 7\nnoop\nnoop\naddx -27\naddx 28\naddx -36\nnoop\naddx 1\naddx 5\naddx -1\nnoop\naddx 6\naddx -1\naddx 5\naddx 5\nnoop\nnoop\naddx -2\naddx 20\naddx -10\naddx -3\naddx 1\naddx 3\naddx 2\naddx 4\naddx 3\nnoop\naddx -30\nnoop")
;addx 1
;noop
;noop
;noop
;addx 5
;addx 5
;noop
;noop
;addx 9
;addx -5
;addx 1
;addx 4
;noop
;noop
;noop
;addx 6
;addx -1
;noop
;addx 5
;addx -2
;addx 7
;noop
;addx 3
;addx -2
;addx -38
;noop
;noop
;addx 32
;addx -22
;noop
;addx 2
;addx 3
;noop
;addx 2
;addx -2
;addx 7
;addx -2
;noop
;addx 3
;addx 2
;addx 5
;addx 2
;addx -5
;addx 10
;noop
;addx 3
;noop
;addx -38
;addx 1
;addx 27
;noop
;addx -20
;noop
;addx 2
;addx 27
;noop
;addx -22
;noop
;noop
;noop
;noop
;addx 3
;addx 5
;addx 2
;addx -11
;addx 16
;addx -2
;addx -17
;addx 24
;noop
;noop
;addx 1
;addx -38
;addx 15
;addx 10
;addx -15
;noop
;addx 2
;addx 26
;noop
;addx -21
;addx 19
;addx -33
;addx 19
;noop
;addx -6
;addx 9
;addx 3
;addx 4
;addx -21
;addx 4
;addx 20
;noop
;addx 3
;addx -38
;addx 28
;addx -21
;addx 9
;addx -8
;addx 2
;addx 5
;addx 2
;addx -9
;addx 14
;addx -2
;addx -5
;addx 12
;addx 3
;addx -2
;addx 2
;addx 7
;noop
;noop
;addx -27
;addx 28
;addx -36
;noop
;addx 1
;addx 5
;addx -1
;noop
;addx 6
;addx -1
;addx 5
;addx 5
;noop
;noop
;addx -2
;addx 20
;addx -10
;addx -3
;addx 1
;addx 3
;addx 2
;addx 4
;addx 3
;noop
;addx -30
;noop