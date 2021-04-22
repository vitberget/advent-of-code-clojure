(ns year2020.day14.day14part1
  (:require [ysera.test :refer [is is= is-not deftest]]
            [clojure.string :as str]))

(defn line-matching-digit->indices
  [line desired-digit]
  (->> line
       (reverse)
       (map-indexed (fn [i c] [i c]))
       (filter (fn [[_ c]] (= c desired-digit)))
       (map first)))

(defn indices->number
  [indices]
  (->> indices
       (map (fn [num] (long (Math/pow 2 num))))
       (reduce +)))

(defn line-matching-digit->number
  [line desired-digit]
  (->> (line-matching-digit->indices line desired-digit)
       (indices->number)))

(defn calculate-memory
  [string]
  (loop [memory {}
         mask-ones 0
         mask-zeros 0
         [line & lines] (str/split-lines string)]
    (cond
      (nil? line) memory

      (str/starts-with? line "mask =")
      (let [[_ mask-string] (re-find #"mask = ([01X]+)" line)]
        (recur memory
               (line-matching-digit->number mask-string \1)
               (bit-xor Long/MAX_VALUE (line-matching-digit->number mask-string \0))
               lines))

      :else
      (let [[mempos number] (->> line
                                 (re-find #"^mem\[(\d+)\] = (\d+)")
                                 (rest)
                                 (map read-string))]
        (recur (assoc memory mempos (->> number
                                         (bit-and mask-zeros)
                                         (bit-or mask-ones)))
               mask-ones
               mask-zeros
               lines)))))

(defn day14part1
  {:test (fn []
           (is= (day14part1 "mask = XXXXXXXXXXXXXXXXXXXXXXXXXXXXX1XXXX0X\nmem[8] = 11\nmem[7] = 101\nmem[8] = 0")
                165))}
  [string]
  (->> (calculate-memory string)
       (vals)
       (reduce +')))

(comment
  (let [puzzle "mask = X00000000000110011100XXX011110111011\nmem[41579] = 225076\nmem[14806] = 26208185\nmem[47659] = 176531392\nmem[27723] = 186971157\nmem[35129] = 3483636\nmem[27142] = 4246\nmask = 01101X10101011000101X1X0XXX101111110\nmem[16685] = 392461\nmem[65343] = 13662482\nmem[53292] = 736\nmem[6830] = 382342975\nmem[12777] = 19983424\nmem[19592] = 679514970\nmem[8776] = 122013\nmask = 011X110100011100111001X1000XX011001X\nmem[29076] = 305532\nmem[30139] = 135337\nmask = 0100X00X1010110X0X010010010001000001\nmem[32307] = 2921\nmem[29478] = 15201\nmask = 1X101101001111111XX1XX1X00X100111X11\nmem[35018] = 63654376\nmem[13977] = 22331\nmem[7078] = 27879686\nmem[36409] = 1248\nmem[29098] = 1049\nmask = 010X0001001X111011001011X000X100X010\nmem[37355] = 3525\nmem[37012] = 16715\nmem[2023] = 7212969\nmem[31805] = 455891\nmem[34394] = 411403104\nmem[5056] = 14954425\nmem[55325] = 17658\nmask = 01101XX01010X100010XXX011110111X0010\nmem[60619] = 889\nmem[65362] = 145345\nmem[53540] = 2298570\nmem[62434] = 542\nmem[12457] = 1279\nmem[5456] = 4090\nmask = 01001X01100010101111X000X01X0X01X001\nmem[27104] = 3012\nmem[9008] = 75\nmem[31688] = 60\nmask = XX01X00000XX110011100X0X010110XX1100\nmem[25251] = 7374\nmem[63139] = 27875755\nmem[42967] = 8204614\nmem[61987] = 396\nmem[30866] = 691\nmask = 1001000X00X0110X1110001000100101XX00\nmem[40705] = 21726765\nmem[7454] = 22726\nmem[46834] = 68819\nmem[7078] = 643555271\nmem[48619] = 34299689\nmem[42749] = 27406055\nmem[32511] = 54957378\nmask = 0X0110010011X1X0110000001010000100X0\nmem[5752] = 957\nmem[58252] = 463561556\nmask = 0X1X1X010011110X111001X00001000XX0X0\nmem[63353] = 14516\nmem[15823] = 2060\nmem[30126] = 102554\nmem[30621] = 17543629\nmem[35116] = 76250\nmem[10236] = 11446819\nmem[16660] = 2541872\nmask = 1X01X00000101100X1X01111100101100000\nmem[48609] = 312842\nmem[2909] = 17774\nmem[19872] = 5613\nmem[9985] = 6539455\nmem[63287] = 312743\nmem[40351] = 16889429\nmask = 0111001001111110XXXX0XXXX11100010011\nmem[61065] = 14018\nmem[1689] = 301351825\nmem[31135] = 568\nmask = X10000100010X000111001X0X0010010X00X\nmem[29969] = 7096617\nmem[19809] = 862281685\nmem[30350] = 1871\nmem[31001] = 93711152\nmem[13233] = 33263717\nmem[42482] = 579908\nmask = 01X10X0X00X11100110100011X0X0X0X001X\nmem[41248] = 7946615\nmem[1829] = 1576\nmem[907] = 21637953\nmem[3566] = 2883\nmem[29687] = 19408\nmem[15657] = 972\nmask = 010100X10001110010X110X01X0111X01010\nmem[53292] = 609\nmem[55550] = 8115727\nmem[834] = 617\nmem[53708] = 498838597\nmem[39044] = 309\nmem[17842] = 5862\nmask = 0100X00010X011X01110X0XX0110000X1101\nmem[32511] = 50674184\nmem[41256] = 996258\nmem[47199] = 1837\nmask = 1101001XXX1X111X10X00X000X011101X101\nmem[9292] = 623250\nmem[45902] = 258279925\nmem[20440] = 172992884\nmem[31688] = 65210\nmem[2288] = 66034927\nmask = 01100101X110X01X11X01100001000X11001\nmem[58893] = 2144468\nmem[5048] = 750616856\nmask = 010110X1001111001100XX0011100101X0X0\nmem[9150] = 4201416\nmem[33664] = 15504\nmem[7218] = 18606957\nmask = 01X1100X0X00110011X0101101111X0X1111\nmem[8003] = 1403\nmem[64683] = 16052434\nmem[17299] = 43327\nmem[13505] = 961\nmem[48609] = 709578\nmem[11582] = 855\nmem[42822] = 3983\nmask = 01101001X01X11X011XX0111110110000101\nmem[30603] = 24703071\nmem[3805] = 775231\nmem[30098] = 230279\nmem[46351] = 5983\nmem[6689] = 3542\nmem[26816] = 121693\nmask = 1X00X0101010010011X1XX0110110011X0X1\nmem[16838] = 192956313\nmem[60531] = 24171693\nmem[22819] = 38459\nmem[26453] = 6160088\nmask = 1X010X000000110X1110100001X0100100X0\nmem[43837] = 22192131\nmem[10090] = 21946\nmask = 01X111000X011100111XX100001100100000\nmem[4306] = 56171106\nmem[50905] = 3399\nmem[36168] = 121097\nmask = 1X010000XXX111001X100X100100X0X001X1\nmem[31394] = 121478\nmem[4906] = 139929\nmem[36356] = 1924\nmask = 1010X010001011X011X011XX11011110X111\nmem[11864] = 29928714\nmem[30866] = 45934\nmem[19873] = 370711\nmask = 0101100000X10110111110X0XXX1XX110X01\nmem[51120] = 65808488\nmem[22318] = 10244125\nmem[26453] = 13126923\nmem[64961] = 3880\nmask = X01011X1001111X1X11XX100010X00111100\nmem[62778] = 126882\nmem[59733] = 1267462\nmem[13740] = 435\nmem[3400] = 8477\nmem[4133] = 116701\nmem[30619] = 231703\nmask = 01000X011010101011110X1000110XX0110X\nmem[45164] = 25402465\nmem[9309] = 77050566\nmem[29909] = 706\nmem[27758] = 1319\nmem[6150] = 106196666\nmask = 01X11X0X00X111001110X1XX0001X001001X\nmem[14255] = 13708852\nmem[513] = 3790644\nmem[28804] = 395377671\nmem[57953] = 72417\nmem[28725] = 1201\nmem[11750] = 233\nmask = X10100X100111110110X00001X1011010X11\nmem[49595] = 24812\nmem[64152] = 9382\nmem[12122] = 2319571\nmem[42088] = 482\nmask = 1X000XX010100100111100X001110X1000XX\nmem[13636] = 524153304\nmem[36450] = 352968\nmem[6260] = 4407821\nmask = 0111000X000101X01XX100X1X1001110X010\nmem[7218] = 94415\nmem[29864] = 5120026\nmem[53070] = 6612\nmem[36573] = 8326010\nmem[1987] = 5992534\nmem[9798] = 11713\nmask = 110000X01010X100111100X01011000XX10X\nmem[26267] = 61334\nmem[29687] = 520585578\nmem[11781] = 66211489\nmask = X001X000000111001110X011001X1X100011\nmem[2023] = 805\nmem[7673] = 1711\nmem[9374] = 7545\nmem[45925] = 33575\nmask = 010X000X10101X000011XXX00X1000000000\nmem[30922] = 12722836\nmem[61189] = 510395\nmem[26267] = 38479500\nmask = X0101X0100X11X1110X11110000000X01011\nmem[55014] = 27563943\nmem[46994] = 497673195\nmem[43529] = 80791407\nmem[65052] = 454391739\nmem[30577] = 304\nmask = 0X01000110011X00X10110111100X0X10010\nmem[45248] = 7792707\nmem[6927] = 12193\nmem[60386] = 3927747\nmem[39315] = 4161237\nmask = X001X01000X01100111010101X111X1X0010\nmem[15099] = 17870434\nmem[60] = 32347\nmem[6193] = 412046876\nmem[61561] = 142217182\nmem[25826] = 2073043\nmem[61322] = 14525\nmask = X1X100X0X11111X01XX000000101000X1X01\nmem[4794] = 233038\nmem[29193] = 23211308\nmem[26267] = 10247786\nmem[44728] = 384574\nmem[57840] = 471\nmem[23517] = 507429935\nmem[8408] = 251968\nmask = X1000X010010110X11X100101X1X1101X100\nmem[14979] = 52721\nmem[14121] = 12422\nmem[65343] = 653\nmem[513] = 23189896\nmask = 1101X0X0010X110010100111101000X00XX0\nmem[21511] = 30489818\nmem[63139] = 13245573\nmem[64852] = 762\nmask = XX01100000011100111X11X00100110X0111\nmem[59229] = 47739\nmem[49595] = 31185\nmem[9374] = 11755159\nmem[42415] = 206175\nmask = X1X010X01010X10001X1010100X1X1X10X10\nmem[65383] = 54664\nmem[17412] = 6631\nmem[55994] = 373011\nmem[53672] = 26530655\nmem[7974] = 1007816675\nmask = 1100X010X01X1000111001X100011011000X\nmem[4896] = 38031019\nmem[754] = 2287\nmem[30181] = 50259322\nmask = 1X010XX00XX111001X10X110100X10000100\nmem[32551] = 7983378\nmem[7438] = 31324924\nmask = 0101X0000010X100111000X0X1X110X01110\nmem[25209] = 48369038\nmem[50393] = 576369\nmem[40859] = 3812\nmem[56386] = 569373625\nmem[63105] = 8734731\nmask = 10101XX0001011X01110XX001X010110XX0X\nmem[34042] = 19350728\nmem[32063] = 255940784\nmem[33476] = 53404\nmem[35243] = 209057823\nmem[4983] = 377086\nmem[4794] = 16200733\nmask = 01X01000101X110001010X11X01X00000101\nmem[19467] = 14126078\nmem[29699] = 830\nmask = 010110X000X1X110111XX1001111X0X10XX1\nmem[43026] = 13471405\nmem[4984] = 1882\nmem[18947] = 15001421\nmask = XX011001X0XXXX001X1101X0000100001010\nmem[55787] = 737\nmem[1563] = 2538\nmem[59758] = 28003877\nmask = 100X000X000X110X1X101100001011X1X011\nmem[25696] = 172112\nmem[12279] = 113288\nmem[24031] = 37612590\nmask = 11XX00X00010110011100101X11010100111\nmem[46130] = 1530\nmem[12542] = 795\nmask = 110X00011X01111001X00X1100100010XX10\nmem[27592] = 128275\nmem[27809] = 132195912\nmem[24738] = 199737\nmem[19162] = 15356\nmask = 010001010X10X10X1111000010001101X000\nmem[8268] = 377409380\nmem[10236] = 540166\nmem[38723] = 139937\nmem[60530] = 7895799\nmem[21813] = 6275543\nmem[8917] = 50534988\nmem[50461] = 251351\nmask = 0110X1011XX01X1011X0X1010X11X000X000\nmem[37937] = 2706\nmem[53672] = 23428\nmem[16637] = 43775004\nmem[13789] = 23884648\nmask = 1X0X00X0001011001110000101X1X1X0X0X1\nmem[55787] = 960988\nmem[29687] = 510439\nmem[63862] = 122580\nmem[30126] = 1488\nmem[44826] = 3558\nmask = XX00001010X011001X110X0X11XX10000X00\nmem[5760] = 209762\nmem[27142] = 2968\nmem[19789] = 269\nmem[634] = 9949\nmask = 01X0X00010101100X1X101XX01110X0X011X\nmem[24659] = 304\nmem[28725] = 7064540\nmem[23533] = 396592131\nmem[42715] = 129702313\nmask = 1X0X0000X0X0110011101X10011X1110000X\nmem[31688] = 698304069\nmem[28880] = 1648\nmem[1915] = 1894\nmem[50253] = 3317783\nmask = 0101X00100X1110011XX00X00X00X00XX010\nmem[7930] = 49938921\nmem[45686] = 376\nmem[44994] = 394081142\nmem[25475] = 1655\nmem[11478] = 704\nmem[34150] = 4147579\nmask = X10X00X0011X11001X100100011100000011\nmem[13838] = 9047\nmem[64712] = 7762\nmem[63477] = 6690357\nmem[38863] = 7288\nmask = 01000000101011000X11011XX111000X01X1\nmem[20533] = 10736847\nmem[40924] = 430217452\nmem[64360] = 2426851\nmem[58115] = 12071761\nmem[30126] = 26562102\nmem[6672] = 154543\nmem[4382] = 10121\nmask = 01X110X00X1X11101X10X110011100X00011\nmem[20472] = 194\nmem[35111] = 708430742\nmem[2674] = 44\nmem[39452] = 614\nmem[19219] = 110991746\nmask = 01X10X010001X1001XX1X00000X00X000110\nmem[38888] = 996404203\nmem[13988] = 2030\nmem[29687] = 833197\nmask = X0010000X00X11X001X000X001011XX1X001\nmem[19041] = 26558\nmem[57953] = 30524\nmem[58714] = 3716054\nmem[12930] = 83910\nmask = 1101100X0X111X001X10XX1101011X100000\nmem[45686] = 3647\nmem[33541] = 36310663\nmem[17979] = 6056054\nmem[10534] = 16345\nmem[47111] = 232953370\nmem[25533] = 27557895\nmem[58098] = 1560064\nmask = 100X0000X0X011XX11X001000101111X0000\nmem[26199] = 246090059\nmem[18199] = 88594470\nmem[29909] = 16759\nmem[64360] = 634531\nmask = 0101XXX10011110XX1100011000X001101X0\nmem[16673] = 22927535\nmem[12390] = 62487\nmem[60131] = 719\nmem[20196] = 175993\nmem[34150] = 25943355\nmem[9914] = 48537509\nmem[41065] = 46726\nmask = 0101000100X11100XX01000X101001000000\nmem[61353] = 192\nmem[30126] = 122504373\nmem[43978] = 112475\nmem[54606] = 262832639\nmask = 110000X01XX0010X1111011010XX01110100\nmem[38654] = 5670\nmem[19246] = 3500\nmem[3280] = 780682\nmem[25841] = 3675082\nmem[10090] = 939\nmem[30577] = 19385\nmask = 1101X000001X11XX1110010101101X101X01\nmem[30181] = 467224373\nmem[64712] = 19540\nmem[9150] = 110790020\nmem[58763] = 649\nmem[61987] = 31515335\nmem[36168] = 40664\nmask = 011001X1X10010X01X1X0X010100X101X1X1\nmem[50341] = 249123925\nmem[57809] = 1245764\nmem[1000] = 6880\nmem[62447] = 9704635\nmem[57040] = 22401\nmem[36847] = 1403\nmask = 1XX0X01000101XX0111001X00101110XX101\nmem[44459] = 1909253\nmem[28804] = 13248\nmask = 11000000X010X1001110111XX0100X101000\nmem[44826] = 1584\nmem[8549] = 20390300\nmem[8024] = 83478929\nmem[26411] = 1612730\nmem[27809] = 3340355\nmask = 0101100X00X111X0111XX100X010000100X1\nmem[43026] = 246196988\nmem[3889] = 148865\nmem[43538] = 168294874\nmem[37181] = 2452\nmem[13074] = 203182\nmask = 100100100101110011X0XX10X101101XX100\nmem[47655] = 2283\nmem[43365] = 51654102\nmem[20448] = 1899\nmem[46501] = 866\nmem[39220] = 8179259\nmask = 01100101111X11XX1X00X100000X0110XX00\nmem[4063] = 25905\nmem[56197] = 7616\nmem[22101] = 96196611\nmask = XX011100X001110X1110XX000X1010000010\nmem[38766] = 317650050\nmem[275] = 1077\nmem[47272] = 3545\nmem[17513] = 428\nmem[31209] = 10901538\nmem[60020] = 8191405\nmask = 100X0000X0001100X110XXX00001110X000X\nmem[3889] = 240406519\nmem[58283] = 105792011\nmem[2023] = 11451400\nmem[42056] = 500252\nmask = 0101100100X11X00110100X001001X0000X0\nmem[51566] = 18992\nmem[2207] = 9397005\nmem[16208] = 18748\nmem[11287] = 117402894\nmem[10310] = 16126\nmem[63935] = 59804\nmask = X1X00X01101011X011XX1001011X10110X01\nmem[17412] = 292\nmem[55917] = 290254\nmem[36766] = 38849561\nmem[39220] = 401237793\nmask = 011001011X1011X01X100001000110010X00\nmem[41854] = 1014518\nmem[16822] = 16372\nmem[36517] = 6130231\nmem[37271] = 406796637\nmask = 0X01000X000111X0111X011001X000000X11\nmem[58255] = 95641\nmem[98] = 61432470\nmask = 0100000100101XX01111100100X11X011101\nmem[9985] = 1592325\nmem[11478] = 2271665\nmem[3757] = 41068007\nmem[61585] = 70572\nmem[17154] = 335361\nmem[60531] = 41930933\nmask = 1001X00000X011011110X0100X000X010010\nmem[64462] = 29767556\nmem[24738] = 210929\nmem[50899] = 1287\nmask = 000XX000000111100100X10001X10010100X\nmem[6334] = 287\nmem[34777] = 1860550\nmask = 110X001000101X001110X111010X0X1X0X01\nmem[12157] = 6178\nmem[40351] = 59493\nmem[30619] = 34292339\nmem[13636] = 1290347\nmask = X100000XX01011X0111X100101000X10X1X1\nmem[60731] = 9983015\nmem[9985] = 18414272\nmem[56154] = 62268050\nmem[40924] = 15580622\nmask = 01010001XX011100110110100X00XX010000\nmem[24823] = 113683\nmem[33142] = 14761835\nmem[33664] = 26275\nmem[7822] = 5148968\nmem[39411] = 1216069\nmem[27779] = 102128\nmem[36065] = 10811\nmask = 11X00010XX10100011X00001X11X0X1X10X1\nmem[34192] = 592942932\nmem[61987] = 27192613\nmem[63760] = 8016\nmask = 010XX00110X01X101111100X0X100X100001\nmem[14125] = 363398\nmem[9080] = 113944\nmem[29909] = 14606451\nmem[52829] = 102953\nmask = 0101XX01001111X0110X0010XX0001011110\nmem[8212] = 2171\nmem[60531] = 439001\nmem[11151] = 8267\nmem[634] = 51725\nmem[38040] = 6915656\nmask = XX01001X011X1X001000011100100X000101\nmem[18184] = 34766\nmem[53526] = 38417257\nmem[28494] = 114210018\nmem[102] = 3422103\nmask = X100000010101100X1110XXX01110000X1X1\nmem[7454] = 3185\nmem[45157] = 3488\nmem[62822] = 3659366\nmask = 1110100X1010110001X1X11X1001X0X1001X\nmem[58002] = 236109549\nmem[3536] = 11719\nmem[40939] = 550805420\nmem[34751] = 538\nmem[51410] = 19066\nmem[11996] = 29329688\nmask = 01010XX00001111011X00110010X0010X111\nmem[64654] = 1185760\nmem[56361] = 13297936\nmem[102] = 3966\nmem[18335] = 470391\nmem[1905] = 25790\nmask = X10X000110XX1110X11001000X00101001X0\nmem[55089] = 17943368\nmem[40456] = 501700825\nmem[47927] = 513748\nmem[13838] = 385\n\n"]
    (time (day14part1 puzzle)))
  ;"Elapsed time: 17.223457 msecs"
  ;=> 9967721333886
  )