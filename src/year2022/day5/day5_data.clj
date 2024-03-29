(ns year2022.day5.day5-data)

(def day5-example "    [D]    \n[N] [C]    \n[Z] [M] [P]\n 1   2   3 \n\nmove 1 from 2 to 1\nmove 3 from 1 to 3\nmove 2 from 2 to 1\nmove 1 from 1 to 2")
;    [D]
;[N] [C]
;[Z] [M] [P]
; 1   2   3
;
;move 1 from 2 to 1
;move 3 from 1 to 3
;move 2 from 2 to 1
;move 1 from 1 to 2

(def day5-puzzle "        [H]     [W] [B]            \n    [D] [B]     [L] [G] [N]        \n[P] [J] [T]     [M] [R] [D]        \n[V] [F] [V]     [F] [Z] [B]     [C]\n[Z] [V] [S]     [G] [H] [C] [Q] [R]\n[W] [W] [L] [J] [B] [V] [P] [B] [Z]\n[D] [S] [M] [S] [Z] [W] [J] [T] [G]\n[T] [L] [Z] [R] [C] [Q] [V] [P] [H]\n 1   2   3   4   5   6   7   8   9 \n\nmove 3 from 2 to 9\nmove 1 from 1 to 6\nmove 6 from 6 to 7\nmove 13 from 7 to 6\nmove 2 from 4 to 5\nmove 1 from 4 to 3\nmove 5 from 9 to 8\nmove 1 from 8 to 5\nmove 3 from 1 to 6\nmove 2 from 1 to 8\nmove 1 from 2 to 1\nmove 1 from 9 to 3\nmove 2 from 9 to 8\nmove 2 from 5 to 9\nmove 4 from 5 to 4\nmove 10 from 8 to 4\nmove 5 from 6 to 2\nmove 5 from 5 to 9\nmove 7 from 3 to 7\nmove 1 from 9 to 8\nmove 1 from 1 to 9\nmove 1 from 7 to 3\nmove 3 from 8 to 9\nmove 8 from 6 to 7\nmove 3 from 9 to 4\nmove 3 from 2 to 6\nmove 6 from 6 to 3\nmove 10 from 7 to 9\nmove 1 from 7 to 5\nmove 1 from 5 to 7\nmove 2 from 3 to 6\nmove 8 from 4 to 2\nmove 7 from 4 to 3\nmove 5 from 2 to 3\nmove 2 from 4 to 6\nmove 6 from 2 to 8\nmove 14 from 9 to 1\nmove 6 from 3 to 2\nmove 7 from 3 to 7\nmove 4 from 2 to 3\nmove 1 from 6 to 5\nmove 3 from 6 to 5\nmove 2 from 2 to 4\nmove 3 from 1 to 2\nmove 2 from 4 to 1\nmove 3 from 5 to 6\nmove 1 from 9 to 6\nmove 1 from 2 to 6\nmove 7 from 7 to 4\nmove 5 from 8 to 1\nmove 11 from 3 to 5\nmove 2 from 2 to 5\nmove 8 from 5 to 1\nmove 4 from 7 to 2\nmove 2 from 6 to 8\nmove 3 from 2 to 4\nmove 1 from 8 to 3\nmove 1 from 3 to 2\nmove 11 from 1 to 8\nmove 4 from 6 to 5\nmove 1 from 4 to 1\nmove 2 from 6 to 4\nmove 14 from 1 to 9\nmove 1 from 1 to 6\nmove 1 from 1 to 9\nmove 10 from 4 to 3\nmove 3 from 3 to 2\nmove 8 from 8 to 9\nmove 1 from 4 to 5\nmove 8 from 5 to 8\nmove 10 from 9 to 5\nmove 5 from 3 to 2\nmove 1 from 3 to 7\nmove 1 from 2 to 5\nmove 6 from 2 to 3\nmove 7 from 3 to 5\nmove 1 from 6 to 9\nmove 2 from 5 to 9\nmove 4 from 2 to 9\nmove 1 from 2 to 1\nmove 1 from 1 to 5\nmove 1 from 7 to 4\nmove 17 from 9 to 1\nmove 4 from 1 to 5\nmove 9 from 5 to 8\nmove 21 from 8 to 6\nmove 1 from 4 to 6\nmove 3 from 5 to 1\nmove 10 from 1 to 5\nmove 12 from 5 to 3\nmove 3 from 3 to 6\nmove 5 from 5 to 7\nmove 5 from 5 to 9\nmove 5 from 7 to 5\nmove 2 from 5 to 7\nmove 1 from 8 to 5\nmove 1 from 7 to 3\nmove 3 from 1 to 7\nmove 11 from 6 to 5\nmove 1 from 7 to 3\nmove 5 from 9 to 7\nmove 8 from 3 to 6\nmove 4 from 9 to 6\nmove 3 from 1 to 6\nmove 1 from 9 to 5\nmove 6 from 5 to 1\nmove 1 from 1 to 6\nmove 3 from 1 to 3\nmove 2 from 1 to 2\nmove 19 from 6 to 1\nmove 2 from 5 to 9\nmove 5 from 3 to 1\nmove 1 from 5 to 6\nmove 5 from 6 to 7\nmove 3 from 7 to 9\nmove 6 from 5 to 9\nmove 1 from 5 to 6\nmove 4 from 6 to 9\nmove 2 from 2 to 1\nmove 1 from 3 to 2\nmove 1 from 2 to 7\nmove 7 from 7 to 6\nmove 21 from 1 to 3\nmove 2 from 7 to 8\nmove 7 from 3 to 2\nmove 2 from 7 to 9\nmove 8 from 3 to 8\nmove 4 from 3 to 1\nmove 6 from 1 to 9\nmove 7 from 2 to 9\nmove 1 from 3 to 6\nmove 1 from 8 to 7\nmove 1 from 1 to 6\nmove 12 from 6 to 9\nmove 1 from 3 to 6\nmove 1 from 7 to 5\nmove 1 from 1 to 9\nmove 1 from 5 to 9\nmove 39 from 9 to 4\nmove 3 from 9 to 6\nmove 1 from 9 to 6\nmove 7 from 8 to 4\nmove 1 from 9 to 8\nmove 44 from 4 to 1\nmove 1 from 6 to 3\nmove 28 from 1 to 8\nmove 15 from 8 to 1\nmove 1 from 3 to 2\nmove 11 from 1 to 5\nmove 1 from 4 to 7\nmove 1 from 4 to 5\nmove 16 from 1 to 6\nmove 1 from 2 to 6\nmove 12 from 8 to 2\nmove 1 from 7 to 4\nmove 3 from 2 to 4\nmove 7 from 2 to 4\nmove 4 from 1 to 6\nmove 10 from 5 to 6\nmove 1 from 1 to 5\nmove 3 from 5 to 9\nmove 3 from 8 to 7\nmove 1 from 2 to 3\nmove 1 from 2 to 4\nmove 3 from 7 to 4\nmove 30 from 6 to 8\nmove 1 from 3 to 7\nmove 20 from 8 to 4\nmove 1 from 7 to 3\nmove 1 from 9 to 8\nmove 25 from 4 to 6\nmove 1 from 3 to 5\nmove 8 from 8 to 5\nmove 3 from 8 to 4\nmove 2 from 9 to 5\nmove 2 from 5 to 2\nmove 21 from 6 to 4\nmove 2 from 2 to 6\nmove 28 from 4 to 5\nmove 1 from 8 to 6\nmove 5 from 4 to 8\nmove 3 from 6 to 7\nmove 15 from 5 to 2\nmove 3 from 7 to 6\nmove 1 from 4 to 3\nmove 17 from 5 to 1\nmove 1 from 3 to 4\nmove 1 from 4 to 8\nmove 4 from 2 to 4\nmove 4 from 4 to 1\nmove 5 from 6 to 8\nmove 11 from 8 to 3\nmove 4 from 6 to 7\nmove 5 from 3 to 2\nmove 4 from 3 to 1\nmove 25 from 1 to 7\nmove 3 from 6 to 7\nmove 8 from 2 to 3\nmove 11 from 7 to 2\nmove 2 from 2 to 7\nmove 16 from 2 to 6\nmove 1 from 2 to 8\nmove 1 from 7 to 6\nmove 1 from 5 to 2\nmove 16 from 6 to 2\nmove 3 from 5 to 7\nmove 6 from 2 to 8\nmove 1 from 5 to 4\nmove 1 from 4 to 3\nmove 4 from 8 to 9\nmove 4 from 3 to 9\nmove 2 from 6 to 2\nmove 6 from 2 to 4\nmove 1 from 9 to 7\nmove 1 from 2 to 8\nmove 7 from 3 to 6\nmove 4 from 2 to 6\nmove 2 from 9 to 5\nmove 1 from 2 to 4\nmove 6 from 6 to 9\nmove 2 from 5 to 1\nmove 1 from 1 to 4\nmove 1 from 9 to 4\nmove 2 from 7 to 6\nmove 1 from 2 to 5\nmove 1 from 5 to 9\nmove 4 from 8 to 1\nmove 7 from 9 to 8\nmove 3 from 1 to 7\nmove 1 from 8 to 3\nmove 4 from 9 to 6\nmove 6 from 8 to 1\nmove 6 from 1 to 2\nmove 1 from 1 to 9\nmove 1 from 1 to 7\nmove 21 from 7 to 5\nmove 11 from 5 to 3\nmove 1 from 9 to 5\nmove 1 from 2 to 8\nmove 5 from 7 to 5\nmove 10 from 3 to 9\nmove 1 from 8 to 5\nmove 8 from 4 to 2\nmove 1 from 3 to 4\nmove 2 from 7 to 3\nmove 5 from 5 to 3\nmove 5 from 9 to 8\nmove 10 from 6 to 2\nmove 1 from 6 to 4\nmove 1 from 9 to 4\nmove 4 from 9 to 3\nmove 19 from 2 to 5\nmove 2 from 4 to 5\nmove 11 from 5 to 1\nmove 15 from 5 to 2\nmove 4 from 8 to 1\nmove 12 from 1 to 5\nmove 1 from 8 to 1\nmove 1 from 4 to 8\nmove 3 from 1 to 3\nmove 8 from 5 to 4\nmove 7 from 3 to 9\nmove 4 from 3 to 5\nmove 4 from 4 to 1\nmove 3 from 9 to 3\nmove 2 from 4 to 1\nmove 4 from 3 to 8\nmove 4 from 2 to 3\nmove 1 from 9 to 5\nmove 4 from 8 to 6\nmove 2 from 4 to 3\nmove 1 from 4 to 5\nmove 5 from 3 to 4\nmove 3 from 3 to 6\nmove 5 from 1 to 6\nmove 2 from 4 to 6\nmove 1 from 9 to 2\nmove 7 from 6 to 3\nmove 1 from 8 to 9\nmove 2 from 1 to 4\nmove 2 from 4 to 7\nmove 4 from 6 to 4\nmove 5 from 3 to 7\nmove 1 from 7 to 2\nmove 3 from 6 to 7\nmove 1 from 4 to 5\nmove 4 from 2 to 6\nmove 3 from 6 to 9\nmove 1 from 6 to 5\nmove 1 from 9 to 2\nmove 5 from 9 to 3\nmove 11 from 5 to 1\nmove 3 from 7 to 8\nmove 2 from 8 to 9\nmove 4 from 5 to 1\nmove 10 from 2 to 7\nmove 5 from 3 to 7\nmove 1 from 9 to 3\nmove 6 from 1 to 7\nmove 22 from 7 to 9\nmove 3 from 2 to 4\nmove 4 from 5 to 3\nmove 1 from 8 to 4\nmove 5 from 4 to 7\nmove 19 from 9 to 8\nmove 2 from 1 to 5\nmove 2 from 4 to 5\nmove 2 from 4 to 9\nmove 4 from 9 to 2\nmove 4 from 7 to 3\nmove 5 from 7 to 5\nmove 7 from 3 to 7\nmove 2 from 8 to 4\nmove 3 from 4 to 7\nmove 12 from 8 to 1\nmove 4 from 3 to 7\nmove 1 from 3 to 6\nmove 1 from 6 to 1\nmove 1 from 5 to 9\nmove 3 from 9 to 3\nmove 2 from 2 to 4\nmove 3 from 8 to 3\nmove 2 from 4 to 7\nmove 7 from 5 to 1\nmove 2 from 8 to 3\nmove 8 from 7 to 9\nmove 2 from 9 to 7\nmove 3 from 9 to 5\nmove 11 from 1 to 2\nmove 5 from 3 to 8\nmove 16 from 1 to 5\nmove 1 from 9 to 8\nmove 3 from 3 to 2\nmove 6 from 2 to 6\nmove 6 from 7 to 4\nmove 2 from 5 to 2\nmove 6 from 4 to 9\nmove 11 from 5 to 7\nmove 2 from 6 to 5\nmove 9 from 5 to 1\nmove 2 from 8 to 5\nmove 13 from 7 to 4\nmove 6 from 1 to 5\nmove 10 from 2 to 9\nmove 1 from 4 to 5\nmove 4 from 6 to 9\nmove 3 from 2 to 4\nmove 2 from 8 to 2\nmove 15 from 4 to 5\nmove 1 from 2 to 8\nmove 1 from 2 to 3\nmove 2 from 8 to 7\nmove 3 from 7 to 1\nmove 1 from 7 to 8\nmove 3 from 5 to 9\nmove 1 from 7 to 1\nmove 21 from 5 to 2\nmove 3 from 9 to 1\nmove 5 from 1 to 4\nmove 1 from 3 to 4\nmove 1 from 8 to 5\nmove 1 from 8 to 9\nmove 1 from 5 to 3\nmove 5 from 2 to 5\nmove 5 from 5 to 3\nmove 7 from 9 to 2\nmove 3 from 3 to 6\nmove 2 from 1 to 4\nmove 1 from 3 to 4\nmove 2 from 3 to 2\nmove 25 from 2 to 1\nmove 11 from 9 to 2\nmove 9 from 2 to 8\nmove 4 from 9 to 5\nmove 6 from 4 to 3\nmove 3 from 3 to 5\nmove 9 from 8 to 2\nmove 3 from 4 to 3\nmove 1 from 9 to 4\nmove 4 from 3 to 8\nmove 2 from 8 to 1\nmove 3 from 5 to 9\nmove 2 from 8 to 1\nmove 4 from 2 to 9\nmove 6 from 9 to 4\nmove 1 from 9 to 2\nmove 1 from 6 to 4\nmove 3 from 4 to 3\nmove 2 from 3 to 9\nmove 3 from 1 to 9\nmove 2 from 2 to 7\nmove 2 from 7 to 2\nmove 2 from 3 to 2\nmove 5 from 9 to 7\nmove 2 from 7 to 2\nmove 28 from 1 to 7\nmove 1 from 1 to 9\nmove 10 from 2 to 5\nmove 1 from 9 to 5\nmove 14 from 7 to 1\nmove 6 from 1 to 6\nmove 12 from 7 to 9\nmove 6 from 1 to 5\nmove 1 from 3 to 8\nmove 4 from 7 to 1\nmove 4 from 4 to 8\nmove 4 from 6 to 1\nmove 1 from 2 to 8\nmove 1 from 2 to 1\nmove 1 from 6 to 1\nmove 5 from 9 to 8\nmove 16 from 5 to 7\nmove 2 from 7 to 1\nmove 6 from 8 to 1\nmove 2 from 9 to 4\nmove 2 from 1 to 3\nmove 1 from 6 to 8\nmove 2 from 5 to 3\nmove 3 from 5 to 7\nmove 4 from 8 to 7\nmove 4 from 9 to 8\nmove 6 from 8 to 6\nmove 10 from 7 to 8\nmove 1 from 9 to 1\nmove 11 from 7 to 6\nmove 2 from 3 to 9\nmove 1 from 3 to 4\nmove 4 from 1 to 2\nmove 3 from 2 to 3\nmove 1 from 9 to 1\nmove 3 from 4 to 2\nmove 9 from 6 to 4\nmove 2 from 3 to 5\nmove 8 from 4 to 9\nmove 4 from 1 to 8\nmove 3 from 8 to 2\nmove 2 from 2 to 6\nmove 1 from 7 to 2\nmove 11 from 6 to 5\nmove 7 from 8 to 6\nmove 7 from 5 to 8\nmove 5 from 8 to 5\nmove 1 from 2 to 5\nmove 3 from 5 to 7\nmove 8 from 5 to 6\nmove 2 from 4 to 5\nmove 1 from 7 to 9\nmove 2 from 3 to 8\nmove 3 from 8 to 5\nmove 13 from 6 to 2\nmove 2 from 8 to 5\nmove 5 from 1 to 9\nmove 3 from 6 to 4\nmove 5 from 5 to 8\nmove 1 from 5 to 4\nmove 4 from 1 to 4\nmove 1 from 7 to 2\nmove 12 from 9 to 7\nmove 2 from 9 to 1\nmove 3 from 8 to 3\nmove 1 from 5 to 4\nmove 3 from 8 to 9\nmove 2 from 4 to 7\nmove 4 from 9 to 5\nmove 5 from 4 to 9\nmove 3 from 9 to 2\nmove 1 from 9 to 4\nmove 1 from 9 to 3\nmove 12 from 7 to 4\nmove 1 from 4 to 8\nmove 1 from 8 to 1\nmove 1 from 5 to 4\nmove 2 from 3 to 5\nmove 11 from 2 to 3\nmove 4 from 5 to 7\nmove 7 from 7 to 2\nmove 1 from 1 to 9\nmove 1 from 8 to 3\nmove 1 from 9 to 1\nmove 2 from 1 to 5\nmove 2 from 5 to 4\nmove 1 from 8 to 1\nmove 2 from 5 to 8\nmove 5 from 1 to 9\nmove 11 from 3 to 9\nmove 1 from 3 to 6\nmove 1 from 6 to 3\nmove 3 from 3 to 6\nmove 3 from 2 to 6\nmove 13 from 9 to 7\nmove 2 from 6 to 1\nmove 8 from 4 to 9\nmove 7 from 4 to 2\nmove 2 from 8 to 6\nmove 1 from 1 to 9\nmove 5 from 2 to 1\nmove 2 from 1 to 3\nmove 10 from 2 to 8\nmove 3 from 9 to 3\nmove 1 from 7 to 4\nmove 6 from 7 to 5")
;        [H]     [W] [B]
;    [D] [B]     [L] [G] [N]
;[P] [J] [T]     [M] [R] [D]
;[V] [F] [V]     [F] [Z] [B]     [C]
;[Z] [V] [S]     [G] [H] [C] [Q] [R]
;[W] [W] [L] [J] [B] [V] [P] [B] [Z]
;[D] [S] [M] [S] [Z] [W] [J] [T] [G]
;[T] [L] [Z] [R] [C] [Q] [V] [P] [H]
; 1   2   3   4   5   6   7   8   9
;
;move 3 from 2 to 9
;move 1 from 1 to 6
;move 6 from 6 to 7
;move 13 from 7 to 6
;move 2 from 4 to 5
;move 1 from 4 to 3
;move 5 from 9 to 8
;move 1 from 8 to 5
;move 3 from 1 to 6
;move 2 from 1 to 8
;move 1 from 2 to 1
;move 1 from 9 to 3
;move 2 from 9 to 8
;move 2 from 5 to 9
;move 4 from 5 to 4
;move 10 from 8 to 4
;move 5 from 6 to 2
;move 5 from 5 to 9
;move 7 from 3 to 7
;move 1 from 9 to 8
;move 1 from 1 to 9
;move 1 from 7 to 3
;move 3 from 8 to 9
;move 8 from 6 to 7
;move 3 from 9 to 4
;move 3 from 2 to 6
;move 6 from 6 to 3
;move 10 from 7 to 9
;move 1 from 7 to 5
;move 1 from 5 to 7
;move 2 from 3 to 6
;move 8 from 4 to 2
;move 7 from 4 to 3
;move 5 from 2 to 3
;move 2 from 4 to 6
;move 6 from 2 to 8
;move 14 from 9 to 1
;move 6 from 3 to 2
;move 7 from 3 to 7
;move 4 from 2 to 3
;move 1 from 6 to 5
;move 3 from 6 to 5
;move 2 from 2 to 4
;move 3 from 1 to 2
;move 2 from 4 to 1
;move 3 from 5 to 6
;move 1 from 9 to 6
;move 1 from 2 to 6
;move 7 from 7 to 4
;move 5 from 8 to 1
;move 11 from 3 to 5
;move 2 from 2 to 5
;move 8 from 5 to 1
;move 4 from 7 to 2
;move 2 from 6 to 8
;move 3 from 2 to 4
;move 1 from 8 to 3
;move 1 from 3 to 2
;move 11 from 1 to 8
;move 4 from 6 to 5
;move 1 from 4 to 1
;move 2 from 6 to 4
;move 14 from 1 to 9
;move 1 from 1 to 6
;move 1 from 1 to 9
;move 10 from 4 to 3
;move 3 from 3 to 2
;move 8 from 8 to 9
;move 1 from 4 to 5
;move 8 from 5 to 8
;move 10 from 9 to 5
;move 5 from 3 to 2
;move 1 from 3 to 7
;move 1 from 2 to 5
;move 6 from 2 to 3
;move 7 from 3 to 5
;move 1 from 6 to 9
;move 2 from 5 to 9
;move 4 from 2 to 9
;move 1 from 2 to 1
;move 1 from 1 to 5
;move 1 from 7 to 4
;move 17 from 9 to 1
;move 4 from 1 to 5
;move 9 from 5 to 8
;move 21 from 8 to 6
;move 1 from 4 to 6
;move 3 from 5 to 1
;move 10 from 1 to 5
;move 12 from 5 to 3
;move 3 from 3 to 6
;move 5 from 5 to 7
;move 5 from 5 to 9
;move 5 from 7 to 5
;move 2 from 5 to 7
;move 1 from 8 to 5
;move 1 from 7 to 3
;move 3 from 1 to 7
;move 11 from 6 to 5
;move 1 from 7 to 3
;move 5 from 9 to 7
;move 8 from 3 to 6
;move 4 from 9 to 6
;move 3 from 1 to 6
;move 1 from 9 to 5
;move 6 from 5 to 1
;move 1 from 1 to 6
;move 3 from 1 to 3
;move 2 from 1 to 2
;move 19 from 6 to 1
;move 2 from 5 to 9
;move 5 from 3 to 1
;move 1 from 5 to 6
;move 5 from 6 to 7
;move 3 from 7 to 9
;move 6 from 5 to 9
;move 1 from 5 to 6
;move 4 from 6 to 9
;move 2 from 2 to 1
;move 1 from 3 to 2
;move 1 from 2 to 7
;move 7 from 7 to 6
;move 21 from 1 to 3
;move 2 from 7 to 8
;move 7 from 3 to 2
;move 2 from 7 to 9
;move 8 from 3 to 8
;move 4 from 3 to 1
;move 6 from 1 to 9
;move 7 from 2 to 9
;move 1 from 3 to 6
;move 1 from 8 to 7
;move 1 from 1 to 6
;move 12 from 6 to 9
;move 1 from 3 to 6
;move 1 from 7 to 5
;move 1 from 1 to 9
;move 1 from 5 to 9
;move 39 from 9 to 4
;move 3 from 9 to 6
;move 1 from 9 to 6
;move 7 from 8 to 4
;move 1 from 9 to 8
;move 44 from 4 to 1
;move 1 from 6 to 3
;move 28 from 1 to 8
;move 15 from 8 to 1
;move 1 from 3 to 2
;move 11 from 1 to 5
;move 1 from 4 to 7
;move 1 from 4 to 5
;move 16 from 1 to 6
;move 1 from 2 to 6
;move 12 from 8 to 2
;move 1 from 7 to 4
;move 3 from 2 to 4
;move 7 from 2 to 4
;move 4 from 1 to 6
;move 10 from 5 to 6
;move 1 from 1 to 5
;move 3 from 5 to 9
;move 3 from 8 to 7
;move 1 from 2 to 3
;move 1 from 2 to 4
;move 3 from 7 to 4
;move 30 from 6 to 8
;move 1 from 3 to 7
;move 20 from 8 to 4
;move 1 from 7 to 3
;move 1 from 9 to 8
;move 25 from 4 to 6
;move 1 from 3 to 5
;move 8 from 8 to 5
;move 3 from 8 to 4
;move 2 from 9 to 5
;move 2 from 5 to 2
;move 21 from 6 to 4
;move 2 from 2 to 6
;move 28 from 4 to 5
;move 1 from 8 to 6
;move 5 from 4 to 8
;move 3 from 6 to 7
;move 15 from 5 to 2
;move 3 from 7 to 6
;move 1 from 4 to 3
;move 17 from 5 to 1
;move 1 from 3 to 4
;move 1 from 4 to 8
;move 4 from 2 to 4
;move 4 from 4 to 1
;move 5 from 6 to 8
;move 11 from 8 to 3
;move 4 from 6 to 7
;move 5 from 3 to 2
;move 4 from 3 to 1
;move 25 from 1 to 7
;move 3 from 6 to 7
;move 8 from 2 to 3
;move 11 from 7 to 2
;move 2 from 2 to 7
;move 16 from 2 to 6
;move 1 from 2 to 8
;move 1 from 7 to 6
;move 1 from 5 to 2
;move 16 from 6 to 2
;move 3 from 5 to 7
;move 6 from 2 to 8
;move 1 from 5 to 4
;move 1 from 4 to 3
;move 4 from 8 to 9
;move 4 from 3 to 9
;move 2 from 6 to 2
;move 6 from 2 to 4
;move 1 from 9 to 7
;move 1 from 2 to 8
;move 7 from 3 to 6
;move 4 from 2 to 6
;move 2 from 9 to 5
;move 1 from 2 to 4
;move 6 from 6 to 9
;move 2 from 5 to 1
;move 1 from 1 to 4
;move 1 from 9 to 4
;move 2 from 7 to 6
;move 1 from 2 to 5
;move 1 from 5 to 9
;move 4 from 8 to 1
;move 7 from 9 to 8
;move 3 from 1 to 7
;move 1 from 8 to 3
;move 4 from 9 to 6
;move 6 from 8 to 1
;move 6 from 1 to 2
;move 1 from 1 to 9
;move 1 from 1 to 7
;move 21 from 7 to 5
;move 11 from 5 to 3
;move 1 from 9 to 5
;move 1 from 2 to 8
;move 5 from 7 to 5
;move 10 from 3 to 9
;move 1 from 8 to 5
;move 8 from 4 to 2
;move 1 from 3 to 4
;move 2 from 7 to 3
;move 5 from 5 to 3
;move 5 from 9 to 8
;move 10 from 6 to 2
;move 1 from 6 to 4
;move 1 from 9 to 4
;move 4 from 9 to 3
;move 19 from 2 to 5
;move 2 from 4 to 5
;move 11 from 5 to 1
;move 15 from 5 to 2
;move 4 from 8 to 1
;move 12 from 1 to 5
;move 1 from 8 to 1
;move 1 from 4 to 8
;move 3 from 1 to 3
;move 8 from 5 to 4
;move 7 from 3 to 9
;move 4 from 3 to 5
;move 4 from 4 to 1
;move 3 from 9 to 3
;move 2 from 4 to 1
;move 4 from 3 to 8
;move 4 from 2 to 3
;move 1 from 9 to 5
;move 4 from 8 to 6
;move 2 from 4 to 3
;move 1 from 4 to 5
;move 5 from 3 to 4
;move 3 from 3 to 6
;move 5 from 1 to 6
;move 2 from 4 to 6
;move 1 from 9 to 2
;move 7 from 6 to 3
;move 1 from 8 to 9
;move 2 from 1 to 4
;move 2 from 4 to 7
;move 4 from 6 to 4
;move 5 from 3 to 7
;move 1 from 7 to 2
;move 3 from 6 to 7
;move 1 from 4 to 5
;move 4 from 2 to 6
;move 3 from 6 to 9
;move 1 from 6 to 5
;move 1 from 9 to 2
;move 5 from 9 to 3
;move 11 from 5 to 1
;move 3 from 7 to 8
;move 2 from 8 to 9
;move 4 from 5 to 1
;move 10 from 2 to 7
;move 5 from 3 to 7
;move 1 from 9 to 3
;move 6 from 1 to 7
;move 22 from 7 to 9
;move 3 from 2 to 4
;move 4 from 5 to 3
;move 1 from 8 to 4
;move 5 from 4 to 7
;move 19 from 9 to 8
;move 2 from 1 to 5
;move 2 from 4 to 5
;move 2 from 4 to 9
;move 4 from 9 to 2
;move 4 from 7 to 3
;move 5 from 7 to 5
;move 7 from 3 to 7
;move 2 from 8 to 4
;move 3 from 4 to 7
;move 12 from 8 to 1
;move 4 from 3 to 7
;move 1 from 3 to 6
;move 1 from 6 to 1
;move 1 from 5 to 9
;move 3 from 9 to 3
;move 2 from 2 to 4
;move 3 from 8 to 3
;move 2 from 4 to 7
;move 7 from 5 to 1
;move 2 from 8 to 3
;move 8 from 7 to 9
;move 2 from 9 to 7
;move 3 from 9 to 5
;move 11 from 1 to 2
;move 5 from 3 to 8
;move 16 from 1 to 5
;move 1 from 9 to 8
;move 3 from 3 to 2
;move 6 from 2 to 6
;move 6 from 7 to 4
;move 2 from 5 to 2
;move 6 from 4 to 9
;move 11 from 5 to 7
;move 2 from 6 to 5
;move 9 from 5 to 1
;move 2 from 8 to 5
;move 13 from 7 to 4
;move 6 from 1 to 5
;move 10 from 2 to 9
;move 1 from 4 to 5
;move 4 from 6 to 9
;move 3 from 2 to 4
;move 2 from 8 to 2
;move 15 from 4 to 5
;move 1 from 2 to 8
;move 1 from 2 to 3
;move 2 from 8 to 7
;move 3 from 7 to 1
;move 1 from 7 to 8
;move 3 from 5 to 9
;move 1 from 7 to 1
;move 21 from 5 to 2
;move 3 from 9 to 1
;move 5 from 1 to 4
;move 1 from 3 to 4
;move 1 from 8 to 5
;move 1 from 8 to 9
;move 1 from 5 to 3
;move 5 from 2 to 5
;move 5 from 5 to 3
;move 7 from 9 to 2
;move 3 from 3 to 6
;move 2 from 1 to 4
;move 1 from 3 to 4
;move 2 from 3 to 2
;move 25 from 2 to 1
;move 11 from 9 to 2
;move 9 from 2 to 8
;move 4 from 9 to 5
;move 6 from 4 to 3
;move 3 from 3 to 5
;move 9 from 8 to 2
;move 3 from 4 to 3
;move 1 from 9 to 4
;move 4 from 3 to 8
;move 2 from 8 to 1
;move 3 from 5 to 9
;move 2 from 8 to 1
;move 4 from 2 to 9
;move 6 from 9 to 4
;move 1 from 9 to 2
;move 1 from 6 to 4
;move 3 from 4 to 3
;move 2 from 3 to 9
;move 3 from 1 to 9
;move 2 from 2 to 7
;move 2 from 7 to 2
;move 2 from 3 to 2
;move 5 from 9 to 7
;move 2 from 7 to 2
;move 28 from 1 to 7
;move 1 from 1 to 9
;move 10 from 2 to 5
;move 1 from 9 to 5
;move 14 from 7 to 1
;move 6 from 1 to 6
;move 12 from 7 to 9
;move 6 from 1 to 5
;move 1 from 3 to 8
;move 4 from 7 to 1
;move 4 from 4 to 8
;move 4 from 6 to 1
;move 1 from 2 to 8
;move 1 from 2 to 1
;move 1 from 6 to 1
;move 5 from 9 to 8
;move 16 from 5 to 7
;move 2 from 7 to 1
;move 6 from 8 to 1
;move 2 from 9 to 4
;move 2 from 1 to 3
;move 1 from 6 to 8
;move 2 from 5 to 3
;move 3 from 5 to 7
;move 4 from 8 to 7
;move 4 from 9 to 8
;move 6 from 8 to 6
;move 10 from 7 to 8
;move 1 from 9 to 1
;move 11 from 7 to 6
;move 2 from 3 to 9
;move 1 from 3 to 4
;move 4 from 1 to 2
;move 3 from 2 to 3
;move 1 from 9 to 1
;move 3 from 4 to 2
;move 9 from 6 to 4
;move 2 from 3 to 5
;move 8 from 4 to 9
;move 4 from 1 to 8
;move 3 from 8 to 2
;move 2 from 2 to 6
;move 1 from 7 to 2
;move 11 from 6 to 5
;move 7 from 8 to 6
;move 7 from 5 to 8
;move 5 from 8 to 5
;move 1 from 2 to 5
;move 3 from 5 to 7
;move 8 from 5 to 6
;move 2 from 4 to 5
;move 1 from 7 to 9
;move 2 from 3 to 8
;move 3 from 8 to 5
;move 13 from 6 to 2
;move 2 from 8 to 5
;move 5 from 1 to 9
;move 3 from 6 to 4
;move 5 from 5 to 8
;move 1 from 5 to 4
;move 4 from 1 to 4
;move 1 from 7 to 2
;move 12 from 9 to 7
;move 2 from 9 to 1
;move 3 from 8 to 3
;move 1 from 5 to 4
;move 3 from 8 to 9
;move 2 from 4 to 7
;move 4 from 9 to 5
;move 5 from 4 to 9
;move 3 from 9 to 2
;move 1 from 9 to 4
;move 1 from 9 to 3
;move 12 from 7 to 4
;move 1 from 4 to 8
;move 1 from 8 to 1
;move 1 from 5 to 4
;move 2 from 3 to 5
;move 11 from 2 to 3
;move 4 from 5 to 7
;move 7 from 7 to 2
;move 1 from 1 to 9
;move 1 from 8 to 3
;move 1 from 9 to 1
;move 2 from 1 to 5
;move 2 from 5 to 4
;move 1 from 8 to 1
;move 2 from 5 to 8
;move 5 from 1 to 9
;move 11 from 3 to 9
;move 1 from 3 to 6
;move 1 from 6 to 3
;move 3 from 3 to 6
;move 3 from 2 to 6
;move 13 from 9 to 7
;move 2 from 6 to 1
;move 8 from 4 to 9
;move 7 from 4 to 2
;move 2 from 8 to 6
;move 1 from 1 to 9
;move 5 from 2 to 1
;move 2 from 1 to 3
;move 10 from 2 to 8
;move 3 from 9 to 3
;move 1 from 7 to 4
;move 6 from 7 to 5
