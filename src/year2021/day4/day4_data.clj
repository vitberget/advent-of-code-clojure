(ns year2021.day4.day4-data)

(def day4-example "7,4,9,5,11,17,23,2,0,14,21,24,10,16,13,6,15,25,12,22,18,20,8,19,3,26,1\n\n22 13 17 11  0\n 8  2 23  4 24\n21  9 14 16  7\n 6 10  3 18  5\n 1 12 20 15 19\n\n 3 15  0  2 22\n 9 18 13 17  5\n19  8  7 25 23\n20 11 10 24  4\n14 21 16 12  6\n\n14 21 17 24  4\n10 16 15  9 19\n18  8 23 26 20\n22 11 13  6  5\n 2  0 12  3  7")
;7,4,9,5,11,17,23,2,0,14,21,24,10,16,13,6,15,25,12,22,18,20,8,19,3,26,1
;
;22 13 17 11  0
; 8  2 23  4 24
;21  9 14 16  7
; 6 10  3 18  5
; 1 12 20 15 19
;
; 3 15  0  2 22
; 9 18 13 17  5
;19  8  7 25 23
;20 11 10 24  4
;14 21 16 12  6
;
;14 21 17 24  4
;10 16 15  9 19
;18  8 23 26 20
;22 11 13  6  5
; 2  0 12  3  7
(def day4-puzzle "30,35,8,2,39,37,72,7,81,41,25,46,56,18,89,70,0,15,84,75,88,67,42,44,94,71,79,65,58,52,96,83,54,29,14,95,66,61,97,68,57,90,55,32,17,47,20,98,1,69,63,62,31,86,77,85,87,93,26,40,24,19,48,76,73,49,34,45,82,22,80,78,23,6,59,91,64,43,21,51,13,3,53,99,4,28,33,74,12,9,36,50,60,11,27,10,5,16,92,38\n\n94 97 41 22 48\n21 47 72 23 26\n12 81 86 24 91\n71 78 90 59 54\n92 63 68 65  1\n\n75 62 66 74 37\n14 79 35 96 30\n33 25 29 57  6\n60 93 17 55 53\n65 16 59 40 27\n\n26 60 95 24 78\n55 12 22 68 43\n67 48 85 66 36\n29 80 52  3 56\n11 59 41 15 18\n\n65 44 99 82 13\n14 62 46 61 84\n 4 38  7 29  0\n36 40 27 20 12\n31 18 15 42 55\n\n90 77 52 24 56\n58 82 19 74 87\n97 93 25 91 95\n40 83 99  9 46\n61 94 96 57 41\n\n40 28 30 81 64\n71 82 10 44 72\n98 31  3 90 67\n 5 47 61 22 59\n85  0 68 57 14\n\n69 97 61 75 34\n 2 12 45 15 63\n71 66 85 39 64\n78 50  0 96 41\n52  3 82 43 74\n\n14 92 59 71 24\n40  8 41 19 83\n 7 65 21 51  6\n55 49  2 97 36\n37 86 56 32 33\n\n68 95 17 24 82\n 6 70 45  8 23\n52 59 55  4 31\n62  2 46 64 36\n43 42 93 44 90\n\n55 58 88 48 12\n81  8 28  3 26\n96 44 80 22 97\n21 57 74 53 72\n90 77 13 56 37\n\n69 49 48 37 41\n84  9 24 18 30\n70 61 86 25  0\n74 50  1 33 87\n97 46 72 60 80\n\n92 66 39 59 43\n25 41 34 26 35\n 3 18 90 52 60\n83 29 24 93 28\n72  2 50 17 71\n\n61 83 19 90 66\n 3 57 69 39 85\n 4  7 60 71 37\n64 75 58 67 17\n41 89  6 31 72\n\n88 28 89  9 48\n70 45  6 72 85\n 7 39 26 58 44\n98 16 33 86 76\n21 99 82  1 81\n\n50 20 44 11  1\n53 73 33 86 95\n41 21 68 42 28\n26 90 39 94 51\n 3 77  2  0 55\n\n97 19 80 48 18\n78 92 99 10 23\n16 55 33 26 58\n25 30 62 17 54\n60 22 69 21 68\n\n 6 47 50 19 24\n60 95  8 90 38\n20 59 73  3 57\n14 87 93 35 29\n97 85 49 12 79\n\n14 77 64  0 40\n45 70  3  5 81\n97 73 11 67 33\n93 24 23 79  2\n17 10 54 35 51\n\n30  3 57 41 18\n59 21 74 83 86\n12 85 82 67 48\n72 77 49 93 55\n66 76 43 34 91\n\n88 19 38 24 51\n60 43 67  1 55\n42 47 79 45 73\n53 25  8 77 15\n34 61 76 70 74\n\n 7 91 17 69 57\n 0 24 16 21 53\n70 13 46 39 56\n32 81 48 15 22\n41 58 26 45 14\n\n52 77 31 89 93\n34 87 21 64 71\n41 38  9 39 30\n97  1 83 20 61\n62  5 27 88 99\n\n74 87 89 29 44\n54 49 36 62 77\n53 72 59 70 15\n27 47  1 84 19\n55 78 56 52 66\n\n64 29 67 44 82\n84 38  3 59 72\n88 53 45 62 21\n93 12 16 15 52\n97 98 54  9  6\n\n93  4 37 44 86\n95  5 13 92 23\n 2 55 39 52 89\n32 35 51 99 47\n42 74 56 67 59\n\n93 37  3 16 35\n42 75 18 72 95\n48 23 91 81 66\n54 49 62 67 36\n56 69 58 50 14\n\n91 58 41 81 18\n86 17 67  2 23\n 4 75 78 66 43\n26 94 77 39 88\n92  5 38 29 56\n\n78 60 23 42 31\n98 55 37 53 82\n41 87 12 69 73\n84  8 96 13 45\n16 59 40 67 77\n\n83 64 43 12 93\n25 88 49 51 21\n97 41 92 68  1\n86 98 47 75 38\n11 63 70 31 19\n\n 7 35 93 29 94\n12 41 30 46 96\n22 78  3 50 38\n13 18 53 81 71\n76 69 16 67 56\n\n60 44  8 12 57\n31 11 79 28 27\n98 94 17 88 99\n 3 93 84 83 96\n90 56 40 15  0\n\n13 96 27 41 48\n64  6 52 58  3\n17 15 50 89 10\n49 12 26 82  0\n83 95 30 32 21\n\n98 44 68 91 12\n66 45  8 24  2\n 3 15  9 99 20\n59 37 97 33 79\n85 73  5 39 32\n\n21 11  2 17 67\n97 78 32 73 34\n51 89 38 20 53\n35 76 31 62 66\n 3 79 88  4 10\n\n40 14 63 55 21\n62 87 67 72 82\n93 79 31 98 64\n80 13 47 25 66\n76 65 26 96  5\n\n12  3 33 49 23\n91 97 35 99 27\n73 44 79 26 48\n90 65 78 64 34\n 4 32  5 19 40\n\n36 77  2 85 46\n16 67 63 49 51\n27 90 62 88 72\n 8 12 95 83 34\n47 74 11 30 48\n\n60 84 55 19 47\n97 18 44 52 88\n50  0 29 36 58\n77 65 21 49 40\n87 39 89 31 27\n\n44 57 78 25  3\n59 70  2 11 96\n63 94 23 50 92\n55 85 88 52 14\n40  4 75 90  6\n\n43 72 12  6 92\n98 26  4 22  3\n54 89 19 58  8\n97 17 49 71 57\n48 29 60 86 56\n\n17 74 31 40 45\n24 32 64 13 80\n 5 43  3 23  7\n86 97 93 78 55\n95 68 21 99 12\n\n93 12 24  3 80\n54 71 95 64 68\n75 22  9 85 38\n62 77 28 48 19\n36 47 30 40  7\n\n11 95 28  2 32\n64 91 90 24 37\n44 31  4 43 68\n 9  8 52 72 74\n25 63 13 18 54\n\n17 61 46  3 63\n14 37 25 95 48\n40 60 74 91 56\n42 67 81 10 43\n51 16 72 87 52\n\n29 92 47 15 31\n32 34 61 48 63\n78 26 22 36 73\n30 76 95 97 12\n74 67 77 86 64\n\n45 22 20 77 61\n41 15 46 82 25\n65 44 63 40 39\n57 36 19 66 10\n13 75 83 26 47\n\n72 83 19 92 41\n42 75 38 88 24\n58 34 22 48 76\n70 86 17 53 26\n 7 33 52 59 85\n\n13 98 64  0 78\n21 23 75  9 67\n70 71  1 33 96\n42 53 38 55 80\n72 95  7 51 49\n\n 8 64 15 28 77\n69 86 97 50 88\n31 29 16 22 81\n72 39 11 67 85\n51 61  5 91 18\n\n19 63 76 58  7\n 8 67 46 53 50\n99 87 95 91 56\n30 88 89 11 83\n39 62 68 28 40\n\n38 21  1 81 46\n41  6  9 86 40\n79 29 90 55 84\n68 63 93 27 70\n65 33  4 75 98\n\n44 72 66 58  5\n53 13 91  2 93\n92 11 71 83 75\n85 50 29 77 73\n31 10 45 36 98\n\n63 85 15 12  0\n27 29 97 42 45\n33 82 40 28 64\n51 22 47 94  2\n91 57 73 87 14\n\n75 98 31 26 57\n71 18 77 17 16\n22 72 54 44 81\n53 35 12  6 30\n67  1 46  7 39\n\n51 16 61 91 18\n13  9 57 30 40\n53 76 23 81 45\n80 41 11 98  8\n35  4 58 54 20\n\n87 74 46 16 49\n 2 31 68 35 75\n60 89 45 11 50\n73 44 32 61 34\n85  5 10 43 42\n\n69 53 13 46 81\n49 58 51 25 67\n22 19 45  6 30\n83 32  9 61 91\n55 11 34 42 50\n\n68 71 96 31 11\n98 84 57 48  6\n 0 99 62 74 76\n 1 37 54 72 16\n91 81 75 24 40\n\n49 14 42 88 79\n 9 63 51 34 78\n 5 27 57 81 40\n60 64 45 92 50\n52 20 59 44 97\n\n63 72 98 90 57\n56 76 92 77  9\n41 21 93 23 39\n 3 28 74  8 65\n15 42 59  7 46\n\n28 75 84  6  8\n99 69 56 62 72\n78 45 50 42 92\n73 59 61 27 33\n 0 24  4 44 18\n\n23  5 88  2 71\n35 41 45 51 14\n53 83 95 66 84\n70 92 76 96 90\n 1 37 17 74 50\n\n 7 65  5 39 95\n80 18 66 69 32\n93 79  6 37 55\n 1  0 47 73  3\n23 40  2 44 61\n\n48 53 25 76 52\n35 83 97 99 33\n22 86  1 55 73\n82 43 40 50 87\n18  3 51 75 81\n\n25 62 69 24 64\n61 41 39 44 30\n93 52 33 26 28\n82  8 50 36 75\n68 48 94  1 85\n\n72 67  3 54 80\n24 14 46 27 92\n26 25 56 49 61\n19 84  0  6  9\n91  1 39  4 78\n\n74 14 20 58 83\n99 89 60 31 93\n13  3 77 62 94\n10 82 85 32 49\n65 79  9 29 50\n\n98  6 94 60 68\n74 38 64 10 18\n23 20 95 33 90\n67 28 17 12 65\n19 40 61 47 22\n\n48 69 14 93 53\n75 55 96 51 87\n52 82 72 56 17\n84 44 70 83 34\n97 37 85 92 59\n\n31 92 13 90 43\n81 51 58 52 83\n76 15 18 87 98\n10 37 94 93 26\n55 44 48 67 29\n\n50 86 33  5 61\n59 46 42 80 77\n82 30  6 19 87\n41 57 78 60 49\n26 18 55 15 25\n\n73  7 14 51 58\n55 22 11 30 67\n69 32 93 83 42\n59 60 40 63  1\n 9 12 48 47 43\n\n61 50  3  5 66\n39 73 53 38 89\n37 34 80 95 74\n64 16 44 54 48\n46 79 69 24 13\n\n76 66 15 33 96\n62  9  3 74 72\n77 75 80 56 31\n 1 43 52 87 44\n23 51  7 53 30\n\n51 73 93 15 19\n91 90 61 96 13\n39 48 54 66  6\n16 25 47 10 81\n36 29 55 46 72\n\n44 93 12 94 53\n14 22 92 23 78\n71 47 39  5 54\n49 86 48 65 84\n61  7 67 36  3\n\n92 45 59 10 82\n76 30  8 86 38\n88 36  3 55 96\n41 24 64 87 42\n35  7 16 54  0\n\n18 82  8  9 77\n 5 91 61 21 83\n59 13 15 67 29\n36 48 88 90 17\n68 12 25 23 22\n\n97 79 74 44 76\n47 23 25 37 16\n98 42 29 26 62\n91 36  7 20 50\n87 12 21 92 77\n\n65 24 33 50 54\n36 59 89 29  3\n15 25 39 95 83\n66 62 58 47 41\n21 37 64 93 69\n\n91 60 47 93 54\n69 70 66 85 74\n61  5  9 37 40\n51 99 42 82 26\n84 30 19 11 75\n\n83  2 27 92 46\n75 43 69 65 31\n76 70 34 97 95\n 1  6 49 66 82\n91 55 98 80 54\n\n10  2 59 74 24\n92 73 88  7 82\n11 30 98 45 97\n28 14 67 47 63\n23 22 55 48 89\n\n 8 90 50  4  0\n86 16 18 28 13\n76 37 31 46 38\n51 54 21 14 27\n59 23 49 97  1\n\n 6 80 36 74 96\n99 27 73 18 64\n84 79 95 24  0\n38  4 15 91 42\n29 87 48 35 32\n\n 4  3 73 77 29\n65 64 96 31 40\n 9 59 45  2  8\n88  0 87 70 89\n17 79 54 61 24\n\n51 69 66 98 39\n27 30 57 35 46\n75 19 31 44 84\n58 25 78  8 86\n24 83 33 34 22\n\n20 59 63 33 56\n78 47 37 48 86\n11 66 83 97 89\n27 55 52 94 26\n70 45  1 18 13\n\n41 14 64 31 19\n85 76 52 34 57\n37  7 77  0 66\n93 11  3 12 74\n67  9 63  1 88\n\n12 58 86 72 96\n80 75 99 40 98\n82 29  2 53 60\n88 46 57 83  8\n13 77 69 38 30\n\n68 90 26 31 60\n87 62 88 50 94\n43 14 67 65 41\n21  8 66 13 12\n17 83 38 72 97\n\n 8 65 30 22 87\n50 19 73 83 96\n33 49 20 36 17\n 9  4 11 56 60\n42 75 62 57 68\n\n 4 28 15 16 60\n86 22 66 18 52\n27 51 61  8 26\n33  1 50 73 48\n11 70 17 76 82\n\n37 63 25 62 59\n73 47 91 35 70\n81 17 76 94 75\n71 36 92 57 44\n82 40  4 97  1\n\n 9 24 53 97 20\n11 89 90 86 96\n99 61 49 66 93\n68 22 26  7 88\n57 70 12 63 34\n\n52 72 93 55 74\n27  2 98  8  4\n77 36 63 59 54\n43 69 79 85 84\n64 76 19 80 21\n\n98 80 54 45 26\n47 71 35 38 21\n67 13 28 65 31\n41 17 82 22  9\n12 10 91 39 34\n\n 0 79 49 14 44\n93 69 46 19 54\n63 89 60 95 20\n47 24 33 16  6\n35 27 61 29 28\n\n57 40 49 31  1\n74 61 21 85 26\n95 83 69  8 29\n34 25 17 82 92\n78 14 53 65 87\n\n18 97 74 79 15\n78 57 41 44 64\n48 21  2 59 96\n30 73 34 86 16\n39 37 98 76 63")
;30,35,8,2,39,37,72,7,81,41,25,46,56,18,89,70,0,15,84,75,88,67,42,44,94,71,79,65,58,52,96,83,54,29,14,95,66,61,97,68,57,90,55,32,17,47,20,98,1,69,63,62,31,86,77,85,87,93,26,40,24,19,48,76,73,49,34,45,82,22,80,78,23,6,59,91,64,43,21,51,13,3,53,99,4,28,33,74,12,9,36,50,60,11,27,10,5,16,92,38
;
;94 97 41 22 48
;21 47 72 23 26
;12 81 86 24 91
;71 78 90 59 54
;92 63 68 65  1
;
;75 62 66 74 37
;14 79 35 96 30
;33 25 29 57  6
;60 93 17 55 53
;65 16 59 40 27
;
;26 60 95 24 78
;55 12 22 68 43
;67 48 85 66 36
;29 80 52  3 56
;11 59 41 15 18
;
;65 44 99 82 13
;14 62 46 61 84
; 4 38  7 29  0
;36 40 27 20 12
;31 18 15 42 55
;
;90 77 52 24 56
;58 82 19 74 87
;97 93 25 91 95
;40 83 99  9 46
;61 94 96 57 41
;
;40 28 30 81 64
;71 82 10 44 72
;98 31  3 90 67
; 5 47 61 22 59
;85  0 68 57 14
;
;69 97 61 75 34
; 2 12 45 15 63
;71 66 85 39 64
;78 50  0 96 41
;52  3 82 43 74
;
;14 92 59 71 24
;40  8 41 19 83
; 7 65 21 51  6
;55 49  2 97 36
;37 86 56 32 33
;
;68 95 17 24 82
; 6 70 45  8 23
;52 59 55  4 31
;62  2 46 64 36
;43 42 93 44 90
;
;55 58 88 48 12
;81  8 28  3 26
;96 44 80 22 97
;21 57 74 53 72
;90 77 13 56 37
;
;69 49 48 37 41
;84  9 24 18 30
;70 61 86 25  0
;74 50  1 33 87
;97 46 72 60 80
;
;92 66 39 59 43
;25 41 34 26 35
; 3 18 90 52 60
;83 29 24 93 28
;72  2 50 17 71
;
;61 83 19 90 66
; 3 57 69 39 85
; 4  7 60 71 37
;64 75 58 67 17
;41 89  6 31 72
;
;88 28 89  9 48
;70 45  6 72 85
; 7 39 26 58 44
;98 16 33 86 76
;21 99 82  1 81
;
;50 20 44 11  1
;53 73 33 86 95
;41 21 68 42 28
;26 90 39 94 51
; 3 77  2  0 55
;
;97 19 80 48 18
;78 92 99 10 23
;16 55 33 26 58
;25 30 62 17 54
;60 22 69 21 68
;
; 6 47 50 19 24
;60 95  8 90 38
;20 59 73  3 57
;14 87 93 35 29
;97 85 49 12 79
;
;14 77 64  0 40
;45 70  3  5 81
;97 73 11 67 33
;93 24 23 79  2
;17 10 54 35 51
;
;30  3 57 41 18
;59 21 74 83 86
;12 85 82 67 48
;72 77 49 93 55
;66 76 43 34 91
;
;88 19 38 24 51
;60 43 67  1 55
;42 47 79 45 73
;53 25  8 77 15
;34 61 76 70 74
;
; 7 91 17 69 57
; 0 24 16 21 53
;70 13 46 39 56
;32 81 48 15 22
;41 58 26 45 14
;
;52 77 31 89 93
;34 87 21 64 71
;41 38  9 39 30
;97  1 83 20 61
;62  5 27 88 99
;
;74 87 89 29 44
;54 49 36 62 77
;53 72 59 70 15
;27 47  1 84 19
;55 78 56 52 66
;
;64 29 67 44 82
;84 38  3 59 72
;88 53 45 62 21
;93 12 16 15 52
;97 98 54  9  6
;
;93  4 37 44 86
;95  5 13 92 23
; 2 55 39 52 89
;32 35 51 99 47
;42 74 56 67 59
;
;93 37  3 16 35
;42 75 18 72 95
;48 23 91 81 66
;54 49 62 67 36
;56 69 58 50 14
;
;91 58 41 81 18
;86 17 67  2 23
; 4 75 78 66 43
;26 94 77 39 88
;92  5 38 29 56
;
;78 60 23 42 31
;98 55 37 53 82
;41 87 12 69 73
;84  8 96 13 45
;16 59 40 67 77
;
;83 64 43 12 93
;25 88 49 51 21
;97 41 92 68  1
;86 98 47 75 38
;11 63 70 31 19
;
; 7 35 93 29 94
;12 41 30 46 96
;22 78  3 50 38
;13 18 53 81 71
;76 69 16 67 56
;
;60 44  8 12 57
;31 11 79 28 27
;98 94 17 88 99
; 3 93 84 83 96
;90 56 40 15  0
;
;13 96 27 41 48
;64  6 52 58  3
;17 15 50 89 10
;49 12 26 82  0
;83 95 30 32 21
;
;98 44 68 91 12
;66 45  8 24  2
; 3 15  9 99 20
;59 37 97 33 79
;85 73  5 39 32
;
;21 11  2 17 67
;97 78 32 73 34
;51 89 38 20 53
;35 76 31 62 66
; 3 79 88  4 10
;
;40 14 63 55 21
;62 87 67 72 82
;93 79 31 98 64
;80 13 47 25 66
;76 65 26 96  5
;
;12  3 33 49 23
;91 97 35 99 27
;73 44 79 26 48
;90 65 78 64 34
; 4 32  5 19 40
;
;36 77  2 85 46
;16 67 63 49 51
;27 90 62 88 72
; 8 12 95 83 34
;47 74 11 30 48
;
;60 84 55 19 47
;97 18 44 52 88
;50  0 29 36 58
;77 65 21 49 40
;87 39 89 31 27
;
;44 57 78 25  3
;59 70  2 11 96
;63 94 23 50 92
;55 85 88 52 14
;40  4 75 90  6
;
;43 72 12  6 92
;98 26  4 22  3
;54 89 19 58  8
;97 17 49 71 57
;48 29 60 86 56
;
;17 74 31 40 45
;24 32 64 13 80
; 5 43  3 23  7
;86 97 93 78 55
;95 68 21 99 12
;
;93 12 24  3 80
;54 71 95 64 68
;75 22  9 85 38
;62 77 28 48 19
;36 47 30 40  7
;
;11 95 28  2 32
;64 91 90 24 37
;44 31  4 43 68
; 9  8 52 72 74
;25 63 13 18 54
;
;17 61 46  3 63
;14 37 25 95 48
;40 60 74 91 56
;42 67 81 10 43
;51 16 72 87 52
;
;29 92 47 15 31
;32 34 61 48 63
;78 26 22 36 73
;30 76 95 97 12
;74 67 77 86 64
;
;45 22 20 77 61
;41 15 46 82 25
;65 44 63 40 39
;57 36 19 66 10
;13 75 83 26 47
;
;72 83 19 92 41
;42 75 38 88 24
;58 34 22 48 76
;70 86 17 53 26
; 7 33 52 59 85
;
;13 98 64  0 78
;21 23 75  9 67
;70 71  1 33 96
;42 53 38 55 80
;72 95  7 51 49
;
; 8 64 15 28 77
;69 86 97 50 88
;31 29 16 22 81
;72 39 11 67 85
;51 61  5 91 18
;
;19 63 76 58  7
; 8 67 46 53 50
;99 87 95 91 56
;30 88 89 11 83
;39 62 68 28 40
;
;38 21  1 81 46
;41  6  9 86 40
;79 29 90 55 84
;68 63 93 27 70
;65 33  4 75 98
;
;44 72 66 58  5
;53 13 91  2 93
;92 11 71 83 75
;85 50 29 77 73
;31 10 45 36 98
;
;63 85 15 12  0
;27 29 97 42 45
;33 82 40 28 64
;51 22 47 94  2
;91 57 73 87 14
;
;75 98 31 26 57
;71 18 77 17 16
;22 72 54 44 81
;53 35 12  6 30
;67  1 46  7 39
;
;51 16 61 91 18
;13  9 57 30 40
;53 76 23 81 45
;80 41 11 98  8
;35  4 58 54 20
;
;87 74 46 16 49
; 2 31 68 35 75
;60 89 45 11 50
;73 44 32 61 34
;85  5 10 43 42
;
;69 53 13 46 81
;49 58 51 25 67
;22 19 45  6 30
;83 32  9 61 91
;55 11 34 42 50
;
;68 71 96 31 11
;98 84 57 48  6
; 0 99 62 74 76
; 1 37 54 72 16
;91 81 75 24 40
;
;49 14 42 88 79
; 9 63 51 34 78
; 5 27 57 81 40
;60 64 45 92 50
;52 20 59 44 97
;
;63 72 98 90 57
;56 76 92 77  9
;41 21 93 23 39
; 3 28 74  8 65
;15 42 59  7 46
;
;28 75 84  6  8
;99 69 56 62 72
;78 45 50 42 92
;73 59 61 27 33
; 0 24  4 44 18
;
;23  5 88  2 71
;35 41 45 51 14
;53 83 95 66 84
;70 92 76 96 90
; 1 37 17 74 50
;
; 7 65  5 39 95
;80 18 66 69 32
;93 79  6 37 55
; 1  0 47 73  3
;23 40  2 44 61
;
;48 53 25 76 52
;35 83 97 99 33
;22 86  1 55 73
;82 43 40 50 87
;18  3 51 75 81
;
;25 62 69 24 64
;61 41 39 44 30
;93 52 33 26 28
;82  8 50 36 75
;68 48 94  1 85
;
;72 67  3 54 80
;24 14 46 27 92
;26 25 56 49 61
;19 84  0  6  9
;91  1 39  4 78
;
;74 14 20 58 83
;99 89 60 31 93
;13  3 77 62 94
;10 82 85 32 49
;65 79  9 29 50
;
;98  6 94 60 68
;74 38 64 10 18
;23 20 95 33 90
;67 28 17 12 65
;19 40 61 47 22
;
;48 69 14 93 53
;75 55 96 51 87
;52 82 72 56 17
;84 44 70 83 34
;97 37 85 92 59
;
;31 92 13 90 43
;81 51 58 52 83
;76 15 18 87 98
;10 37 94 93 26
;55 44 48 67 29
;
;50 86 33  5 61
;59 46 42 80 77
;82 30  6 19 87
;41 57 78 60 49
;26 18 55 15 25
;
;73  7 14 51 58
;55 22 11 30 67
;69 32 93 83 42
;59 60 40 63  1
; 9 12 48 47 43
;
;61 50  3  5 66
;39 73 53 38 89
;37 34 80 95 74
;64 16 44 54 48
;46 79 69 24 13
;
;76 66 15 33 96
;62  9  3 74 72
;77 75 80 56 31
; 1 43 52 87 44
;23 51  7 53 30
;
;51 73 93 15 19
;91 90 61 96 13
;39 48 54 66  6
;16 25 47 10 81
;36 29 55 46 72
;
;44 93 12 94 53
;14 22 92 23 78
;71 47 39  5 54
;49 86 48 65 84
;61  7 67 36  3
;
;92 45 59 10 82
;76 30  8 86 38
;88 36  3 55 96
;41 24 64 87 42
;35  7 16 54  0
;
;18 82  8  9 77
; 5 91 61 21 83
;59 13 15 67 29
;36 48 88 90 17
;68 12 25 23 22
;
;97 79 74 44 76
;47 23 25 37 16
;98 42 29 26 62
;91 36  7 20 50
;87 12 21 92 77
;
;65 24 33 50 54
;36 59 89 29  3
;15 25 39 95 83
;66 62 58 47 41
;21 37 64 93 69
;
;91 60 47 93 54
;69 70 66 85 74
;61  5  9 37 40
;51 99 42 82 26
;84 30 19 11 75
;
;83  2 27 92 46
;75 43 69 65 31
;76 70 34 97 95
; 1  6 49 66 82
;91 55 98 80 54
;
;10  2 59 74 24
;92 73 88  7 82
;11 30 98 45 97
;28 14 67 47 63
;23 22 55 48 89
;
; 8 90 50  4  0
;86 16 18 28 13
;76 37 31 46 38
;51 54 21 14 27
;59 23 49 97  1
;
; 6 80 36 74 96
;99 27 73 18 64
;84 79 95 24  0
;38  4 15 91 42
;29 87 48 35 32
;
; 4  3 73 77 29
;65 64 96 31 40
; 9 59 45  2  8
;88  0 87 70 89
;17 79 54 61 24
;
;51 69 66 98 39
;27 30 57 35 46
;75 19 31 44 84
;58 25 78  8 86
;24 83 33 34 22
;
;20 59 63 33 56
;78 47 37 48 86
;11 66 83 97 89
;27 55 52 94 26
;70 45  1 18 13
;
;41 14 64 31 19
;85 76 52 34 57
;37  7 77  0 66
;93 11  3 12 74
;67  9 63  1 88
;
;12 58 86 72 96
;80 75 99 40 98
;82 29  2 53 60
;88 46 57 83  8
;13 77 69 38 30
;
;68 90 26 31 60
;87 62 88 50 94
;43 14 67 65 41
;21  8 66 13 12
;17 83 38 72 97
;
; 8 65 30 22 87
;50 19 73 83 96
;33 49 20 36 17
; 9  4 11 56 60
;42 75 62 57 68
;
; 4 28 15 16 60
;86 22 66 18 52
;27 51 61  8 26
;33  1 50 73 48
;11 70 17 76 82
;
;37 63 25 62 59
;73 47 91 35 70
;81 17 76 94 75
;71 36 92 57 44
;82 40  4 97  1
;
; 9 24 53 97 20
;11 89 90 86 96
;99 61 49 66 93
;68 22 26  7 88
;57 70 12 63 34
;
;52 72 93 55 74
;27  2 98  8  4
;77 36 63 59 54
;43 69 79 85 84
;64 76 19 80 21
;
;98 80 54 45 26
;47 71 35 38 21
;67 13 28 65 31
;41 17 82 22  9
;12 10 91 39 34
;
; 0 79 49 14 44
;93 69 46 19 54
;63 89 60 95 20
;47 24 33 16  6
;35 27 61 29 28
;
;57 40 49 31  1
;74 61 21 85 26
;95 83 69  8 29
;34 25 17 82 92
;78 14 53 65 87
;
;18 97 74 79 15
;78 57 41 44 64
;48 21  2 59 96
;30 73 34 86 16
;39 37 98 76 63