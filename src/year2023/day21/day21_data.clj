(ns year2023.day21.day21-data)

(def day21-example 
  "...........
.....###.#.
.###.##..#.
..#.#...#..
....#.#....
.##..S####.
.##..#...#.
.......##..
.##.#.####.
.##..##.##.
...........")

(def day21-puzzle 
  "...................................................................................................................................
...#..................#..........#.....#.........#.....#..........................#...#.#......#.....##.............#...........#..
..................................#...........#.....#..#....................#.#......#......#.............##..............#.#....#.
.....#......#............#.......#.....................#........................#.........#................#.........#.............
..#.............#....#...#..............#...#..#.......#...................#..#...........#.#.#.............#....#.................
...................#........#.....#..#.....#.....#...#..........................#..........#.............#..#..#...................
..........#.#.............#.............#.......#......#..........##.........###...#.#....#..#.............#.#.........#.#.........
..#.#..#............#......#................#.....#...........#.................................##.......................#..#...#..
..........#.....#.....#.........#.........##.........................#...................#......#..............................#...
...#..#..#...................#.#...#..........#................#...#....................#..#..............#........#...............
.....#...#...#..............##..........##.#.#........................#...............#....................#.........#...#.........
.#.#.#................##.......................#.............#...........................#.................#.#.....................
..#.......#..............#.............#..#....................#.......#..........#.........#..#.....##.#..................#..#.#..
...#........#.....#..#.#....#.........#.#...............##.##.......................#.....##............#.................#........
.........................#............#..#..............#.#.#.#......#....................#....#.#......#..#..................##...
............#.....#..#...#..#.............#..............#...#.#......#.............#.......##..#........#.#............#..#.......
.................##..............#........#........................#.................#...................#......##.............#...
......#.........##...............#.#.....#.............#.#.............#................#....#.#.#....#......#.........#...........
.#..............#............#........................#...#............#....#.#..................................#.......##.#...#..
..#.........#.........#.##.#......................#...#..#.....#............................#.#....##......#....#....#.........#...
..#.#.....#....#...##.....###..........................##...............#....#....................#....##...#.#....................
...............#...............#...#..#.........#..........#..........#........#...........#...#.........#..#....#..#...#..#.......
.............#..#........#.#............................#..#.#.........#...........................##..............#............#..
........###....................................#.....................#........................#.#........#.........#...............
..#...........#...###...##......#..#..........................#...#.#......#........#.................................#............
........#..........................#.............#..#......#..........#.....#...................................##.##..........#...
................#......#.#......#..#........#..........#.....##.#.#....................#........#....#.##......#..##...............
..#.............#..#............##........#.#.....#...................#.............#...#.........#..............#...#......#....#.
..............#...#.......................................#...#......#......#........#............#...........#........#...#.......
...#..........#.#...........................#.........#..#......#.........#......#..##..................#..........................
.......#..#.................##.........................##............#........#....#...............#.............#...............#.
.....#.....#........#...#..#.#...........#.....#........#.#..........#...#..###...........#..........#................#.......#....
........#............#...................#.....#......#..#.....................###..#...#...................................#....#.
.........#.........#............................#.#.................#..#.#......#.....#..##............#..............#.....#...#..
........................#.......................#...............#.#.......#.........#........#...........###............#..........
.#...........#............#.........#.......#.##.......#.......................#..#........#...................#...................
......................##.#..........................#.##.#...................#.......#...##.#..#....................#...#.......#..
..#...#...#............#.................#.........##.....#...#.........##........#.....#.....##..............#.......#.#.....#....
..#...##....#..................#...#..................#...........#...#.....#.................##...................#............#..
..........#..#....#........................#......#..........#......#..###..........##..#....................#...#.#.#.............
............#.##..#................#......#.#.#......#......#........#.......#.......#..........#.................#......#.....#...
........#........#..........#.....#......##..................#....#...............##......#.#..#..............#..#.....#...........
...........#...#..##.........#...#......#........#.....#.............#....................#..#..#......................#..#.#..#...
........###........................#...........#.....#.#....#......#....#....#...##................#.............#.......#.........
......#..#.#....................##.#...#.........#.#....#.......#...##....#..........#......#.....#..............##....##........#.
..#.....................#..#.#......................#.............##...##............#......#...........#.........#................
.....#........#....................................#...##.................#.....#.......#.......##.................#...#......#....
.....###......................#........#..........#....#..........#.#.......................#..#.#........#.............#..........
.#....#...#.............#...................................#...#........#............#...........#....#.#..#................#.....
.......#....................###..#........#................................##.....#...................#.#..................#.......
.....#...................................#.#..............#.......#............#......##..##...........#....#....................#.
..#...................#...........#..................#...#.##............#.........#..........#..#.....#...#.#..#............#.....
.........#................#.#.#.............#.#..##....#.......#...................#.......#.#..........##....#....................
.................#...#...........#............#......#........................#.....#.......#......#.......#....#.#................
...#..#.........#.#.....#.......##............#..............##.........#.#...##.#.......#.........................................
...............................#........##.........#.....#.............#.#..#...#..#........................#......................
.............#........#...#.........#.........#.#..#.#........................#.....#..............#.............#...........##....
................#..#.........##..#.#...........#...#..#.......#......#....#.............#.........#.........#.....#..............#.
...................#...#...##..................#..........................#...##.........#......#.....#.........#..................
.......................#..#.....#..................#..........#......#...............................#...#..........##.#...........
.................#....#......#.........#...#............#.#.....#....#......#............................................#.........
....................#................#.................#........#........#.............#.....#....##.#....#....#.......#...........
.........#....#..#......#................#....................#...#........#..#.........#.......#.........#.#.....#..#.....#.......
............#.#.........#....#..#.......#.................................#....#....#..................#..#.#........#......#......
......#....................#............#.#.....#....#..............#..............##.....#..........#.........#...................
.................................................................S.................................................................
..................#.#........#...............#....................#..............##...#..#...............#....#...#......#...#.....
........#........#....#.#..........#................#..#..#..##.................#..#.....#....#....................................
..............#.#.................#.....................#.................#.....#.........................#...#..#.................
.........##......#...#....#....#....#.......#.#.....#..............#.......#....................#......#............#..............
............####.##.............................................#..#.........#....#......#..........#.......#......................
..........##...#............#.....#..#.#..#..........#..............##.......#...............#.#....................#..#...........
...............###...............#..#.........###....#....#.....#...................#...#.....#....#...#...#........##..........#..
............#..#..............#.....#.....#.....#.................#........#........#..#.....#.......#.........#...................
..#..............#..........................#.....#....#....##.##..#..#......#.....#......................#.....#...............#..
..##..#.....................#.##...........#.#...#.......#.#.#.................#...#..#.#.........##.....##..####.#.........#......
..#................#..........#.................#...#.....#..........#....##..##..#..#................#......#.....#...............
.#...................#..............#......#................#.....##...#.......#...................#..............#.............#..
.......................#..................#.#.....#.#........#..#.#.....#...#....#.......##............#..#....#................#..
...#...#..........#...........#................#.....#........#....##.............................##.....#......................#..
..........#..........#.....##....#....#....#..#.........#.........#...#..................#....#..#.........................#....#..
...................................#.#............##.#.....#..........##...#...#...................#....#...................#......
.....##...................#..............#...#..................#.####..............#.......#..##.#........#.......................
....#...#....#.........#...#............###..#....#...............#........................#.#...#....................##..#..#.....
...........#.#.........#......#...#....#......##...#....##..#........#.........#.....#......#.........................##.#...#...#.
.........................................#.....#......#...#....#..#......#..............................................##.........
.....##..#.................#...#.........#...#....#.#.##.....................#......#...#................#...........#.......#.....
...#.#.....#..###..................#.....#..#..#....#.......................#.#....##..........#..#...#............................
.#...........#.............#....#...#..#....................................#.......................#..#..........#...........#....
................#...........##...#.##...................#..#...##...............................#.##...........................#.#.
...........###....#............#.....................#......#...........................#.........##...............................
........#.#..#.#...............#.#..........#...........#...................#.......#.............#..................#.............
.#........#............................................###......#.#..........#..............#................#............#....#...
.............................................#.#...#..#.#....#...............#...#..............#......................#...........
.#.#......#..#....##.................##......##..........#.#..#.........#.....#...............##..............................#..#.
...#.#........#.......................#..........#.....#.##...........#................###..........................#.........#....
.........#...........#.................................#.....###....#....#......#.........#.#..............#...#.#.....#...#.......
........#.#...#.......#.....#................#..#.#.............#.......................................#.#.....##...#.##....#.....
...##.............#..#.#........................................................###..................#.#..#...#.................#..
.................##........##..............#.........####......#........#......#......#.....#..............#..#.....#.....#..#.#.#.
.#.#......................................#...........................#..#.........#.##.................#..........#...........#...
.#.........#..#.#......#.......#.............................#....#.........#..#...#...............#......#...#...#............#.#.
.....#.....##......#..###.#..#................................#....#.....#....................................#..#..........#......
....................##............................##.............................#......#................#.........................
...#..............#...#...#......#.#.................#..#..............##.................................................#........
...#.#.......#..............#..#..............#.#...#.........#............#.........#..............##......#...........#.....#....
.#....#..#...#...#......#.................................##...#...#...#...........................#.##.......#....#....#.....#....
.#.#.##.........#...#.......#....#...#........#....#..............#.........................#..##.....#...#....#...#...#........#..
...........#...#.#.........#..#...#.#............##..........#.........#....................#......#..................#....##......
.........#........#.#...#...##......................#.........##....#.##.#................#................#......#....##..........
............#.#............#........#..............##.#.....#.........##.#.....................##...#......#.....#.....#.#....#....
...##...........##...#..................#..........#.......#....#..##..#...#...............##.................#....................
.....#.....#.......................#.##.........................#........#....................#...........##...#.#.#..........##...
..#.#..........#......#..#.#.#....#........#...............#........#.....#.#.........#....#.#...............#................#....
.............................#....###.....#..........#...#..........#.................#...........................##...#.#....#....
.................#....##.#.##...#...#....#..........................#.#...#...................................#.#...#........#...#.
.....#.....................#........##........................#....#.....................#.....#...........#......#..#.#.....#.....
.....#...............#....................#.#.............#...#.......#............#..#.......#..#...#..................#...#.#....
...##.##....#....#..........#..#.....#.....#.##....................#..#.#............#...................#.................#.......
.....#..............#......#...#..#.....#.................#.......#.......................................#........................
..#.................#.#.........##............#................#...............#..........#..........#.#...#.......#....##....#.##.
.........#...................#............#...#..#............#...#...........#.##.....#...#.................#.............##......
.......#.............#.............................###.......#.....................................##...#..............##......#...
..............##.................#......#...................................#.##.......................#....#.......#.#..........#.
.##.........#...##..###........#.#...#..#.......#...#..............................#.....##.............#..#...........#.....#...#.
.#.........#.#...........#.............#......#.........#...................##..................#.#....#..#..........#......#......
........##......#..#..................................#...........................#.#....................##.............#..........
...#..#.....#......#....#...#................#.....#..............................#........................#........#....#.........
...#......#........#..#.......................#.....#...................#............#.......##..................#..#....#..###....
........#.....#..............#...#.#..#..#.......#.#.....#.........................#........#.......#....##......#.............#.#.
...................................................................................................................................")
