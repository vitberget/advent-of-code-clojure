(ns year2021.day13.day13-data)

(def day13-example "6,10\n0,14\n9,10\n0,3\n10,4\n4,11\n6,0\n6,12\n4,1\n0,13\n10,12\n3,4\n3,0\n8,4\n1,10\n2,14\n8,10\n9,0\n\nfold along y=7\nfold along x=5")
;6,10
;0,14
;9,10
;0,3
;10,4
;4,11
;6,0
;6,12
;4,1
;0,13
;10,12
;3,4
;3,0
;8,4
;1,10
;2,14
;8,10
;9,0
;
;fold along y=7
;fold along x=5

(def day13-puzzle "428,532\n925,404\n882,362\n44,836\n191,714\n412,36\n688,523\n522,842\n1054,359\n523,413\n388,638\n60,495\n758,148\n381,42\n1017,80\n279,696\n848,508\n922,638\n381,852\n887,822\n500,672\n969,526\n986,760\n102,187\n1232,303\n758,596\n412,820\n320,296\n935,715\n310,308\n129,422\n383,485\n919,786\n261,318\n745,863\n279,179\n628,266\n1185,798\n388,190\n790,788\n775,254\n771,491\n1034,513\n147,689\n1215,178\n1263,739\n949,228\n152,852\n536,444\n359,705\n946,780\n21,863\n395,864\n527,603\n167,856\n877,516\n1046,586\n1146,287\n651,604\n32,383\n75,800\n364,780\n306,470\n689,332\n310,362\n759,451\n70,198\n748,639\n937,795\n515,453\n1113,24\n873,819\n706,99\n1031,179\n60,88\n211,786\n1051,626\n518,490\n341,722\n413,598\n301,772\n238,38\n159,318\n1265,547\n572,803\n557,241\n947,250\n490,781\n1054,191\n1158,148\n388,358\n575,191\n961,826\n723,268\n314,402\n208,612\n433,348\n549,515\n361,814\n410,4\n618,324\n109,75\n1190,599\n207,864\n78,79\n1151,455\n701,362\n135,266\n1250,399\n1072,808\n616,298\n1163,653\n1200,19\n951,789\n518,404\n698,890\n1029,249\n820,781\n930,555\n92,479\n739,367\n623,677\n252,108\n372,612\n668,884\n842,880\n36,794\n395,30\n1305,742\n987,380\n1164,66\n922,582\n1019,512\n678,273\n187,389\n1136,479\n243,527\n209,476\n446,810\n1245,656\n1068,372\n341,526\n770,635\n92,150\n852,175\n619,473\n195,77\n229,464\n218,705\n887,110\n206,519\n684,333\n221,378\n31,217\n477,498\n967,448\n907,551\n947,306\n1072,114\n1153,71\n987,828\n472,504\n937,520\n952,656\n795,291\n795,697\n1120,14\n1019,382\n279,248\n1181,444\n699,833\n535,254\n629,424\n1176,508\n515,155\n1022,359\n253,123\n701,84\n498,72\n1228,834\n65,689\n470,847\n216,875\n836,756\n1279,229\n1221,703\n406,806\n699,285\n415,373\n154,448\n612,331\n632,173\n67,142\n492,172\n512,120\n1185,350\n537,28\n1079,9\n95,379\n231,254\n398,807\n219,816\n189,333\n386,301\n858,456\n361,142\n242,336\n1103,864\n1165,282\n957,794\n256,817\n743,584\n412,372\n261,211\n65,459\n13,789\n1190,410\n1124,61\n681,526\n31,677\n585,304\n679,155\n13,626\n594,120\n415,521\n951,105\n179,848\n895,231\n960,497\n1237,568\n77,374\n678,173\n1222,562\n565,863\n33,218\n1116,432\n559,110\n658,87\n947,25\n43,61\n937,732\n464,880\n969,78\n622,819\n406,634\n796,61\n736,387\n681,470\n641,341\n1144,820\n544,875\n626,701\n1215,640\n1218,479\n192,834\n1031,226\n437,819\n467,837\n570,134\n1260,795\n760,276\n259,864\n877,277\n135,42\n36,548\n31,789\n147,205\n840,847\n269,861\n509,612\n259,101\n1028,164\n423,784\n1020,873\n490,315\n492,378\n412,558\n375,491\n564,399\n324,606\n740,894\n594,806\n812,72\n102,707\n989,857\n460,550\n412,858\n457,24\n663,11\n184,159\n457,712\n616,477\n348,47\n239,455\n279,198\n385,705\n587,414\n1118,386\n929,747\n1235,416\n900,4\n786,623\n36,570\n281,700\n1034,717\n303,453\n50,795\n776,372\n572,333\n863,618\n622,607\n395,133\n1260,39\n937,645\n139,645\n798,679\n281,697\n428,362\n467,603\n604,263\n734,634\n551,451\n1102,58\n164,579\n1006,497\n616,701\n53,241\n872,427\n1302,726\n576,602\n324,288\n216,467\n45,547\n1049,766\n243,303\n53,721\n78,558\n13,618\n609,621\n1062,806\n305,68\n1136,191\n887,885\n157,71\n70,696\n244,442\n949,142\n47,739\n880,596\n45,697\n2,830\n744,758\n1196,187\n296,572\n179,400\n256,369\n912,646\n1290,47\n304,397\n160,306\n290,138\n443,633\n947,158\n43,462\n1094,331\n845,122\n867,633\n31,705\n324,746\n508,138\n607,646\n937,84\n735,255\n1200,875\n1192,276\n349,68\n408,91\n229,502\n229,397\n525,24\n793,561\n932,177\n647,11\n706,263\n50,487\n1225,547\n673,264\n1089,378\n773,756\n986,148\n242,558\n1290,847\n97,379\n731,106\n238,114\n875,78\n850,717\n67,480\n975,683\n95,672\n1089,617\n1171,645\n53,465\n1275,645\n895,663\n10,255\n160,484\n703,646\n1240,807\n1012,197\n523,553\n1290,582\n735,252\n865,583\n872,467\n646,56\n668,458\n13,520\n1009,772\n1034,316\n965,182\n726,817\n1308,87\n540,259\n735,642\n997,78\n92,253\n734,196\n221,635\n576,303\n77,520\n1031,198\n1059,551\n545,523\n447,618\n401,120\n378,401\n1081,877\n281,249\n169,185\n820,315\n681,368\n977,366\n10,395\n358,238\n415,231\n224,596\n517,561\n1267,432\n398,646\n438,467\n293,114\n1215,379\n1257,465\n612,779\n525,444\n25,526\n345,264\n1213,379\n534,596\n1208,806\n716,774\n944,87\n887,784\n957,346\n480,36\n1121,561\n184,774\n1279,189\n790,386\n443,338\n1218,639\n32,735\n1019,420\n562,422\n334,30\n33,80\n965,264\n1051,101\n1279,665\n1144,606\n535,192\n146,586\n1265,473\n33,814\n67,515\n801,282\n1228,333\n536,724\n252,786\n862,331\n694,535\n338,499\n129,472\n1068,336\n88,758\n962,424\n1170,733\n1250,358\n282,164\n698,779\n1230,248\n1150,858\n187,827\n537,583\n845,781\n810,0\n435,78\n20,586\n333,528\n313,301\n256,191\n455,43\n415,567\n1059,103\n462,60\n189,109\n1150,306\n559,603\n549,281\n856,794\n1039,100\n863,52\n944,417\n536,170\n499,479\n1000,308\n283,14\n515,697\n552,124\n1205,525\n333,857\n753,653\n152,596\n576,292\n1278,287\n485,295\n269,705\n1094,875\n241,99\n298,197\n977,857\n622,523\n351,827\n38,477\n848,732\n306,495\n587,142\n1111,851\n514,733\n1205,515\n587,773\n271,794\n1068,36\n706,631\n164,287\n189,785\n925,267\n70,421\n1104,563\n609,532\n539,627\n208,170\n775,702\n415,663\n835,46\n458,175\n310,586\n1113,450\n1183,800\n102,134\n216,147\n105,187\n1266,388\n1279,637\n715,161\n1205,826\n522,550\n783,458\n354,350\n576,784\n734,740\n1129,406\n1226,760\n935,198\n1140,520\n979,739\n845,113\n641,520\n740,50\n612,115\n1232,558\n987,66\n105,707\n378,347\n324,8\n944,872\n425,464\n682,875\n1215,222\n353,445\n853,712\n1205,379\n1059,247\n748,479\n420,191\n835,848\n525,870\n736,646\n261,576\n251,247\n751,110\n689,80\n139,291\n723,773\n758,124\n281,197\n927,409\n840,868\n537,866\n751,603\n271,485\n947,698\n1151,318\n688,819\n907,654\n109,819\n197,892\n35,645\n734,154\n790,60\n401,351\n313,520\n1138,222\n845,794\n433,98\n656,42\n1099,786\n1007,453\n851,77\n783,352\n328,107\n473,406\n885,654\n323,66\n167,38\n669,480\n567,584\n1308,830\n1228,113\n733,72\n1019,474\n2,298\n363,25\n575,703\n363,158\n137,100\n259,416\n242,50\n738,289\n1066,803\n1020,780\n331,439\n957,445\n743,663\n380,339\n371,61\n222,618\n468,432\n535,842\n1081,502\n226,362\n224,298\n291,535\n1195,871\n725,304\n734,751\n23,739\n535,397\n447,842\n448,331\n291,158\n1004,424\n977,264\n438,595\n89,15\n371,304\n616,193\n120,599\n1240,817\n281,362\n383,346\n388,582\n406,536\n1277,80\n145,52\n32,287\n1235,800\n912,87\n32,299\n893,792\n765,75\n962,343\n1019,333\n192,508\n330,311\n986,288\n559,336\n248,634\n157,80\n1071,455\n276,401\n594,658\n281,795\n470,420\n843,603\n313,78\n711,393\n1139,820\n124,759\n805,610\n85,347\n833,396\n1190,779\n93,366\n1173,100\n495,128\n162,154\n1073,123\n562,639\n291,561\n1151,576\n293,786\n585,590\n1307,738\n1123,827\n661,266\n514,161\n1066,386\n570,894\n725,142\n792,404\n259,478\n36,52\n251,240\n43,432\n190,462\n917,576\n244,4\n259,268\n1141,332\n855,291\n1004,47\n162,68\n502,820\n95,178\n1138,670\n266,326\n666,843\n1084,84\n1051,581\n1220,847\n1027,733\n1153,103\n437,75\n708,299\n1274,346\n264,586\n669,520\n890,191\n247,252\n798,215\n300,19\n166,606\n216,651\n385,267\n248,751\n986,606\n950,147\n468,880\n243,815\n1201,819\n423,110\n939,164\n761,505\n1215,515\n179,429\n1233,374\n551,443\n137,337\n1020,394\n1063,642\n1208,760\n972,499\n922,806\n497,103\n420,705\n92,639\n1081,430\n771,788\n654,225\n751,178\n375,179\n1265,697\n497,743\n331,455\n20,84\n70,817\n1192,450\n835,465\n415,788\n1285,449\n986,135\n699,609\n1222,786\n629,526\n291,512\n1133,172\n924,593\n5,742\n840,287\n893,123\n242,396\n846,462\n410,605\n88,562\n1215,626\n1036,523\n571,367\n1079,885\n425,465\n1158,852\n1218,641\n692,394\n1260,99\n515,291\n990,416\n276,130\n1161,284\n935,226\n843,505\n738,803\n1310,852\n3,738\n288,359\n783,291\n474,756\n689,590\n125,350\n269,259\n102,806\n82,60\n244,803\n977,630\n927,548\n1274,570\n1196,707\n698,563\n115,871\n279,403\n87,231\n1068,74\n652,746\n1057,95\n1282,417\n485,709\n1304,598\n1282,193\n95,515\n647,435\n433,277\n895,106\n70,807\n244,91\n646,838\n748,33\n587,827\n641,480\n1278,299\n1171,301\n1297,268\n50,347\n1089,169\n701,25\n211,338\n1243,379\n13,268\n348,424\n595,733\n616,596\n787,525\n120,779\n423,864\n634,532\n242,844\n873,75\n1267,730\n502,746\n281,173\n822,750\n402,108\n694,701\n206,666\n927,841\n341,816\n594,47\n1067,815\n118,892\n166,807\n95,626\n403,654\n454,100\n59,609\n895,788\n721,241\n676,532\n74,310\n333,485\n1029,84\n830,36\n599,501\n1218,749\n417,123\n1057,123\n694,193\n324,512\n179,494\n842,432\n979,439\n155,479\n1161,610\n187,515\n930,339\n1183,291\n393,318\n1290,532\n788,550\n785,291\n947,830\n1186,759\n867,556\n748,861\n460,177\n713,852\n358,572\n507,633\n1265,421\n631,155\n1243,414\n1222,108\n229,430\n715,285\n818,131\n\nfold along x=655\nfold along y=447\nfold along x=327\nfold along y=223\nfold along x=163\nfold along y=111\nfold along x=81\nfold along y=55\nfold along x=40\nfold along y=27\nfold along y=13\nfold along y=6")
;428,532
;925,404
;882,362
;44,836
;191,714
;412,36
;688,523
;522,842
;1054,359
;523,413
;388,638
;60,495
;758,148
;381,42
;1017,80
;279,696
;848,508
;922,638
;381,852
;887,822
;500,672
;969,526
;986,760
;102,187
;1232,303
;758,596
;412,820
;320,296
;935,715
;310,308
;129,422
;383,485
;919,786
;261,318
;745,863
;279,179
;628,266
;1185,798
;388,190
;790,788
;775,254
;771,491
;1034,513
;147,689
;1215,178
;1263,739
;949,228
;152,852
;536,444
;359,705
;946,780
;21,863
;395,864
;527,603
;167,856
;877,516
;1046,586
;1146,287
;651,604
;32,383
;75,800
;364,780
;306,470
;689,332
;310,362
;759,451
;70,198
;748,639
;937,795
;515,453
;1113,24
;873,819
;706,99
;1031,179
;60,88
;211,786
;1051,626
;518,490
;341,722
;413,598
;301,772
;238,38
;159,318
;1265,547
;572,803
;557,241
;947,250
;490,781
;1054,191
;1158,148
;388,358
;575,191
;961,826
;723,268
;314,402
;208,612
;433,348
;549,515
;361,814
;410,4
;618,324
;109,75
;1190,599
;207,864
;78,79
;1151,455
;701,362
;135,266
;1250,399
;1072,808
;616,298
;1163,653
;1200,19
;951,789
;518,404
;698,890
;1029,249
;820,781
;930,555
;92,479
;739,367
;623,677
;252,108
;372,612
;668,884
;842,880
;36,794
;395,30
;1305,742
;987,380
;1164,66
;922,582
;1019,512
;678,273
;187,389
;1136,479
;243,527
;209,476
;446,810
;1245,656
;1068,372
;341,526
;770,635
;92,150
;852,175
;619,473
;195,77
;229,464
;218,705
;887,110
;206,519
;684,333
;221,378
;31,217
;477,498
;967,448
;907,551
;947,306
;1072,114
;1153,71
;987,828
;472,504
;937,520
;952,656
;795,291
;795,697
;1120,14
;1019,382
;279,248
;1181,444
;699,833
;535,254
;629,424
;1176,508
;515,155
;1022,359
;253,123
;701,84
;498,72
;1228,834
;65,689
;470,847
;216,875
;836,756
;1279,229
;1221,703
;406,806
;699,285
;415,373
;154,448
;612,331
;632,173
;67,142
;492,172
;512,120
;1185,350
;537,28
;1079,9
;95,379
;231,254
;398,807
;219,816
;189,333
;386,301
;858,456
;361,142
;242,336
;1103,864
;1165,282
;957,794
;256,817
;743,584
;412,372
;261,211
;65,459
;13,789
;1190,410
;1124,61
;681,526
;31,677
;585,304
;679,155
;13,626
;594,120
;415,521
;951,105
;179,848
;895,231
;960,497
;1237,568
;77,374
;678,173
;1222,562
;565,863
;33,218
;1116,432
;559,110
;658,87
;947,25
;43,61
;937,732
;464,880
;969,78
;622,819
;406,634
;796,61
;736,387
;681,470
;641,341
;1144,820
;544,875
;626,701
;1215,640
;1218,479
;192,834
;1031,226
;437,819
;467,837
;570,134
;1260,795
;760,276
;259,864
;877,277
;135,42
;36,548
;31,789
;147,205
;840,847
;269,861
;509,612
;259,101
;1028,164
;423,784
;1020,873
;490,315
;492,378
;412,558
;375,491
;564,399
;324,606
;740,894
;594,806
;812,72
;102,707
;989,857
;460,550
;412,858
;457,24
;663,11
;184,159
;457,712
;616,477
;348,47
;239,455
;279,198
;385,705
;587,414
;1118,386
;929,747
;1235,416
;900,4
;786,623
;36,570
;281,700
;1034,717
;303,453
;50,795
;776,372
;572,333
;863,618
;622,607
;395,133
;1260,39
;937,645
;139,645
;798,679
;281,697
;428,362
;467,603
;604,263
;734,634
;551,451
;1102,58
;164,579
;1006,497
;616,701
;53,241
;872,427
;1302,726
;576,602
;324,288
;216,467
;45,547
;1049,766
;243,303
;53,721
;78,558
;13,618
;609,621
;1062,806
;305,68
;1136,191
;887,885
;157,71
;70,696
;244,442
;949,142
;47,739
;880,596
;45,697
;2,830
;744,758
;1196,187
;296,572
;179,400
;256,369
;912,646
;1290,47
;304,397
;160,306
;290,138
;443,633
;947,158
;43,462
;1094,331
;845,122
;867,633
;31,705
;324,746
;508,138
;607,646
;937,84
;735,255
;1200,875
;1192,276
;349,68
;408,91
;229,502
;229,397
;525,24
;793,561
;932,177
;647,11
;706,263
;50,487
;1225,547
;673,264
;1089,378
;773,756
;986,148
;242,558
;1290,847
;97,379
;731,106
;238,114
;875,78
;850,717
;67,480
;975,683
;95,672
;1089,617
;1171,645
;53,465
;1275,645
;895,663
;10,255
;160,484
;703,646
;1240,807
;1012,197
;523,553
;1290,582
;735,252
;865,583
;872,467
;646,56
;668,458
;13,520
;1009,772
;1034,316
;965,182
;726,817
;1308,87
;540,259
;735,642
;997,78
;92,253
;734,196
;221,635
;576,303
;77,520
;1031,198
;1059,551
;545,523
;447,618
;401,120
;378,401
;1081,877
;281,249
;169,185
;820,315
;681,368
;977,366
;10,395
;358,238
;415,231
;224,596
;517,561
;1267,432
;398,646
;438,467
;293,114
;1215,379
;1257,465
;612,779
;525,444
;25,526
;345,264
;1213,379
;534,596
;1208,806
;716,774
;944,87
;887,784
;957,346
;480,36
;1121,561
;184,774
;1279,189
;790,386
;443,338
;1218,639
;32,735
;1019,420
;562,422
;334,30
;33,80
;965,264
;1051,101
;1279,665
;1144,606
;535,192
;146,586
;1265,473
;33,814
;67,515
;801,282
;1228,333
;536,724
;252,786
;862,331
;694,535
;338,499
;129,472
;1068,336
;88,758
;962,424
;1170,733
;1250,358
;282,164
;698,779
;1230,248
;1150,858
;187,827
;537,583
;845,781
;810,0
;435,78
;20,586
;333,528
;313,301
;256,191
;455,43
;415,567
;1059,103
;462,60
;189,109
;1150,306
;559,603
;549,281
;856,794
;1039,100
;863,52
;944,417
;536,170
;499,479
;1000,308
;283,14
;515,697
;552,124
;1205,525
;333,857
;753,653
;152,596
;576,292
;1278,287
;485,295
;269,705
;1094,875
;241,99
;298,197
;977,857
;622,523
;351,827
;38,477
;848,732
;306,495
;587,142
;1111,851
;514,733
;1205,515
;587,773
;271,794
;1068,36
;706,631
;164,287
;189,785
;925,267
;70,421
;1104,563
;609,532
;539,627
;208,170
;775,702
;415,663
;835,46
;458,175
;310,586
;1113,450
;1183,800
;102,134
;216,147
;105,187
;1266,388
;1279,637
;715,161
;1205,826
;522,550
;783,458
;354,350
;576,784
;734,740
;1129,406
;1226,760
;935,198
;1140,520
;979,739
;845,113
;641,520
;740,50
;612,115
;1232,558
;987,66
;105,707
;378,347
;324,8
;944,872
;425,464
;682,875
;1215,222
;353,445
;853,712
;1205,379
;1059,247
;748,479
;420,191
;835,848
;525,870
;736,646
;261,576
;251,247
;751,110
;689,80
;139,291
;723,773
;758,124
;281,197
;927,409
;840,868
;537,866
;751,603
;271,485
;947,698
;1151,318
;688,819
;907,654
;109,819
;197,892
;35,645
;734,154
;790,60
;401,351
;313,520
;1138,222
;845,794
;433,98
;656,42
;1099,786
;1007,453
;851,77
;783,352
;328,107
;473,406
;885,654
;323,66
;167,38
;669,480
;567,584
;1308,830
;1228,113
;733,72
;1019,474
;2,298
;363,25
;575,703
;363,158
;137,100
;259,416
;242,50
;738,289
;1066,803
;1020,780
;331,439
;957,445
;743,663
;380,339
;371,61
;222,618
;468,432
;535,842
;1081,502
;226,362
;224,298
;291,535
;1195,871
;725,304
;734,751
;23,739
;535,397
;447,842
;448,331
;291,158
;1004,424
;977,264
;438,595
;89,15
;371,304
;616,193
;120,599
;1240,817
;281,362
;383,346
;388,582
;406,536
;1277,80
;145,52
;32,287
;1235,800
;912,87
;32,299
;893,792
;765,75
;962,343
;1019,333
;192,508
;330,311
;986,288
;559,336
;248,634
;157,80
;1071,455
;276,401
;594,658
;281,795
;470,420
;843,603
;313,78
;711,393
;1139,820
;124,759
;805,610
;85,347
;833,396
;1190,779
;93,366
;1173,100
;495,128
;162,154
;1073,123
;562,639
;291,561
;1151,576
;293,786
;585,590
;1307,738
;1123,827
;661,266
;514,161
;1066,386
;570,894
;725,142
;792,404
;259,478
;36,52
;251,240
;43,432
;190,462
;917,576
;244,4
;259,268
;1141,332
;855,291
;1004,47
;162,68
;502,820
;95,178
;1138,670
;266,326
;666,843
;1084,84
;1051,581
;1220,847
;1027,733
;1153,103
;437,75
;708,299
;1274,346
;264,586
;669,520
;890,191
;247,252
;798,215
;300,19
;166,606
;216,651
;385,267
;248,751
;986,606
;950,147
;468,880
;243,815
;1201,819
;423,110
;939,164
;761,505
;1215,515
;179,429
;1233,374
;551,443
;137,337
;1020,394
;1063,642
;1208,760
;972,499
;922,806
;497,103
;420,705
;92,639
;1081,430
;771,788
;654,225
;751,178
;375,179
;1265,697
;497,743
;331,455
;20,84
;70,817
;1192,450
;835,465
;415,788
;1285,449
;986,135
;699,609
;1222,786
;629,526
;291,512
;1133,172
;924,593
;5,742
;840,287
;893,123
;242,396
;846,462
;410,605
;88,562
;1215,626
;1036,523
;571,367
;1079,885
;425,465
;1158,852
;1218,641
;692,394
;1260,99
;515,291
;990,416
;276,130
;1161,284
;935,226
;843,505
;738,803
;1310,852
;3,738
;288,359
;783,291
;474,756
;689,590
;125,350
;269,259
;102,806
;82,60
;244,803
;977,630
;927,548
;1274,570
;1196,707
;698,563
;115,871
;279,403
;87,231
;1068,74
;652,746
;1057,95
;1282,417
;485,709
;1304,598
;1282,193
;95,515
;647,435
;433,277
;895,106
;70,807
;244,91
;646,838
;748,33
;587,827
;641,480
;1278,299
;1171,301
;1297,268
;50,347
;1089,169
;701,25
;211,338
;1243,379
;13,268
;348,424
;595,733
;616,596
;787,525
;120,779
;423,864
;634,532
;242,844
;873,75
;1267,730
;502,746
;281,173
;822,750
;402,108
;694,701
;206,666
;927,841
;341,816
;594,47
;1067,815
;118,892
;166,807
;95,626
;403,654
;454,100
;59,609
;895,788
;721,241
;676,532
;74,310
;333,485
;1029,84
;830,36
;599,501
;1218,749
;417,123
;1057,123
;694,193
;324,512
;179,494
;842,432
;979,439
;155,479
;1161,610
;187,515
;930,339
;1183,291
;393,318
;1290,532
;788,550
;785,291
;947,830
;1186,759
;867,556
;748,861
;460,177
;713,852
;358,572
;507,633
;1265,421
;631,155
;1243,414
;1222,108
;229,430
;715,285
;818,131
;
;fold along x=655
;fold along y=447
;fold along x=327
;fold along y=223
;fold along x=163
;fold along y=111
;fold along x=81
;fold along y=55
;fold along x=40
;fold along y=27
;fold along y=13
;fold along y=6