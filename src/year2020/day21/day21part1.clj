(ns year2020.day21.day21part1
  (:require [ysera.test :refer [is is= is-not]]
            [clojure.string :as str]
            [clojure.set :as set]))

(def example-text
  (str "mxmxvkd kfcds sqjhc nhms (contains dairy, fish)\n"
       "trh fvjkl sbzzf mxmxvkd (contains dairy)\n"
       "sqjhc fvjkl (contains soy)\n"
       "sqjhc mxmxvkd sbzzf (contains fish)"))

(defn line->state-part
  {:test (fn []
           (is= (line->state-part "mxmxvkd kfcds sqjhc nhms (contains dairy, fish)")
                [#{"mxmxvkd" "kfcds" "sqjhc" "nhms"} #{"dairy" "fish"}]))}
  [line]
  (let [[ingredients allergens] (str/split line #"\(contains ")]
    [(as-> ingredients $
           (str/split $ #"\s")
           (into #{} $))
     (as-> allergens $
           (str/replace $ "," "")
           (str/replace $ ")" "")
           (str/split $ #"\s")
           (into #{} $))]))


(defn string->state
  {:test (fn []
           (is= (string->state example-text)
                [[#{"mxmxvkd" "kfcds" "sqjhc" "nhms"} #{"dairy" "fish"}]
                 [#{"trh" "fvjkl" "sbzzf" "mxmxvkd"} #{"dairy"}]
                 [#{"sqjhc" "fvjkl"} #{"soy"}]
                 [#{"sqjhc" "mxmxvkd" "sbzzf"} #{"fish"}]]))}
  [string]
  (->> string
       (str/split-lines)
       (map line->state-part)))

(defn unpossible-allergens-ingredients
  {:test (fn []
           (is= (unpossible-allergens-ingredients (string->state example-text))
                #{"kfcds" "nhms" "sbzzf" "trh"}))}
  [state]
  (let [all-allergens (->> state
                           (map second)
                           (apply set/union))
        all-words (->> state
                       (map first)
                       (apply set/union))
        allergen-words (->> all-allergens
                            (map (fn [allergen]
                                   (->> state
                                        (filter (fn [ss] (-> ss
                                                             (second)
                                                             (contains? allergen))))
                                        (map first)
                                        (apply set/intersection))))
                            (apply set/union))]
    (->> all-words
         (filter (fn [w] (not (contains? allergen-words w))))
         (into #{}))
    ))

(defn score-this
  {:test (fn []
           (is= (score-this (string->state example-text) #{"kfcds" "nhms" "sbzzf" "trh"})
                5))}
  [state words]
  (->> state
       (map first)
       (map (fn [is] (set/intersection is words)))
       (map count)
       (reduce +)))

(defn day21part1
  {:test (fn []
           (is= (day21part1 example-text) 5))}
  [string]
  (let [state (string->state string)
        unpossible-allergens (unpossible-allergens-ingredients state)]
    (score-this state unpossible-allergens)))

(comment
  (let [puzzle "rzfcn jcpnmh sjxxzrd qpngxk vpchddj ccjjp klcl dk bltzkxx ttzd fkszg rhjbx cnnd shptr mhvtp zlcbnx tplp vgh bltrbvz qbrr bhgpk ffmgfz tgfcl kjfnqg rpf sncl jvjmd jgblz ngzp dvrhz zphlmnb spql crsp hqnnsm hvlc pxldx pflk rblzjb bclc dzqlq zll ndmz lgccp mpbsn lzxgf njdfc zjdkj mfnc rznmz nzhtc xbdh kqth plmpl bkqzk krh jsphx sbtz qlhqg pqhd cjf xrjzvh lgm szh nrbl dtvsk srhcd vgzjp mqmq szcgft rpjcjd bbgz ggqsr hgcb (contains fish, eggs)\nxbdh rpf zlcbnx mhvtp bxcgf jsphx dpls jrvxh zvtvzc bthckj vkjd tk mccpbg zdvcnx cjf bclc cmlh spcqmzfg lhslfpx kcmmj mkhbznt klcl bqcjvv qpngxk srhcd vrgk bmnqp sjxxzrd mkt mcgx ffgs cnnd zbhmgm nbrh ztv dzqlq bltzkxx nrbl dk bscmf jqrq fkszg sncl hgcb xrjzvh spql ggqsr pflk tfn jcpnmh (contains dairy, nuts, sesame)\npflk dpls jvjmd sbtz hlk rbxnc mkpc hrmdt mkhbznt pxldx bltrbvz krh fxsrc qpzcmf cqzqvj nhsx blvlch ffgs ghvj pqhd bltzkxx nbrh dzqlq lhslfpx rgnz njdfc rtxfsp vxmfmjjh fpc pmht cftgsk jqrq frnz spql dpmcrh bhgpk hvlc vgh rpf bvskjzc zpcscz hpdn plmpl xdjhhj dsbj bthckj lzxgf ljsmz kjfnqg rghrrt xhlkscn rhjbx lgm bbhvzz nrbl qlhqg cdhfzl ttzd zxftz xbdh mflngx gtgkt rpjcjd ztv (contains eggs, fish, peanuts)\nbscmf rmngx bchbc kqth pqhd bbhvzz njdfc bltzkxx bnnqz fkszg rhjbx shkkk shptr nbrh cjf bltrbvz xbdh spcqmzfg zdznn tfn bhgpk vkjd bsql zxftz jqrq pflk qtxgzpx fpc zphlmnb dzqlq rtjk vpchddj smktk sbtz hhppz rtxfsp qmbxq zgfl tprdg zll lgccp mhlv cnnd jsphx bthckj kcmmj hlk tgfcl jrvxh qfkgx spql dk qpngxk ljsmz (contains wheat, dairy, peanuts)\njpvrvr nbrh lvrp crsp xbdh shkkk jrvxh bqcjvv bvskjzc mpbsn pxldx bbgz txs rbxnc vrgk cnnd bltrbvz rghrrt lgm xrjzvh rznmz zpcscz srhcd hffzvrj spcqmzfg ngzp qpzcmf dsrxrt rpjcjd spql vdm lhslfpx bltzkxx pflk dpmcrh krh rrngl dpls tgfcl dzqlq xhlkscn ztrgb (contains wheat, sesame)\nbscmf dzqlq ggqsr czs bltrbvz bhgpk dk xrjzvh xbdh jgblz rtxfsp fzkxc cftgsk zdznn blvlch bltzkxx btpdk nqsdkrh ttzd spcqmzfg fpc qbrr kbzmtz sbtz mxpn bxxs dsrxrt pflk sncl hffzvrj mfqvks mfnc hzfd xdjhhj mhlv hpdn nrbl vdm zbhmgm qtxgzpx rtjk vpchddj vkjd lvrp spql zgfl mpbsn cjf ftkqfrv mccpbg qlv zvtvzc tprdg (contains shellfish, wheat)\nsmktk xcq fpfdkl hcnmld qpngxk bxcgf hzfd pflk frnz zdvcnx zdznn dsbj tplp lgccp vgzjp mpbsn qpzcmf bltzkxx pqhd txs spql ksbr vkjd vdjjl njdfc fpc qgkhxq ccjjp dfk bxxs vdm rtjk qtxgzpx bltrbvz rblzjb tpvb xbdh lgm hvlc mqmq djp rbxnc cqzqvj rghrrt pxldx hhppz rpf cxhplp srhcd gbsvjgg pmht cfl dtvsk bclc hgcb dzqlq rbprd fzkxc xzzl bthckj dvrhz mcgx tfn mxpn ftkqfrv rhjbx shptr ztv dk krh jqrq ztrgb mcvjsk bnkgs nbrh nrbl cftgsk zjdkj zbhmgm hflzrt qlhqg tprdg (contains wheat)\ntk sbtz fpfdkl bnnqz tprdg btpdk xbdh jvjmd szcgft rzfcn ndmz bqrpdxt vrgk dsrxrt kqth sncl czs cftgsk lgm hrmdt rgnz mhsr hcnmld bxxs crsp dpmcrh lvrp zpkl bclc ftkqfrv rlcv hzr njdfc ttzd zgfl bltrbvz tplp hgcb rtjk ztv blvlch mfnc ffmgfz zpcscz zxftz srhcd pxldx kcmmj dvrhz bbgz rpf zphlmnb pflk hqnnsm ljsmrl ngx bxcgf mfqvks spql djp zjdkj cdhfzl vpchddj spcqmzfg sjxxzrd qbrr xrjzvh hhgqp bltzkxx (contains sesame, nuts)\nczstl bclc bltrbvz jqrq ztv cxhplp mpbsn bchbc dpmcrh rpf rhjbx hpdn ttzd hvlc rmngx bqcjvv tfn rbprd bkqzk cfl vzfg mkt bltzkxx xzzl zdvcnx pflk ztrgb krsl dzqlq zvtvzc nqsdkrh kcmmj bsql mflngx hzfd qlhqg krh mfnc sncl btpdk cdhfzl ftkqfrv hflzrt tplp xrjzvh sbtz ljsmz spcqmzfg xcq hffzvrj qpngxk mxpn gbsvjgg plmpl spql cjf rgnz hlk lhslfpx mfqvks ljsmrl rzfcn kjfnqg rlcv ffgs bnkgs (contains nuts, peanuts)\nhzfd ccjjp frnz dsrxrt krsl bltzkxx txs krh hgcb vgzjp qpngxk rpf bvskjzc jvjmd qlv sncl sbtz jrvxh bsql crscm bscmf rbxnc hqff djp srhcd vdm nbrh dzqlq lgccp bnnqz btpdk jsphx tplp nrbl qfkgx zdvcnx qbrr cftgsk pflk rmngx rblzjb mpbsn xbdh shkkk ksbr spql zjdkj xrjzvh nqsdkrh hlk bltrbvz rpjcjd rznmz vkjd jcpnmh bqrpdxt zxftz nhsx (contains sesame, eggs)\nrbprd frnz jpvrvr sbtz hcnmld spql rhjbx jzcrblh zphlmnb lgccp szcgft dvrhz dsbj qlhqg gbsvjgg dzqlq bltzkxx shptr bsql qpzcmf bbhvzz csdbg hvlc zgfl qbrr djp qpngxk pmht dfk spcqmzfg cftgsk nhsx lhslfpx kjfnqg zpcscz pflk zpkl bqrpdxt xbdh cdhfzl bhgpk lgm pxldx bscmf ztv jsphx lzxgf bxcgf dtvsk kcmmj gtgkt cjf tpvb rpf mflngx cfl nbrh btpdk czstl fzkxc (contains shellfish, wheat)\nspql rtjk xdjhhj fkszg dtvsk qpzcmf spcqmzfg cmlh pxldx hlk mhlv ffgs tgfcl jcpnmh hrmdt pqhd rpf vrgk bnnqz bvskjzc dzqlq mflngx bltrbvz zvtvzc xbdh ttzd klcl kcmmj hflzrt nrbl bscmf jgblz lvrp hzr mccpbg dsrxrt hcnmld vdjjl bmnqp jsphx hffzvrj vxmfmjjh nbrh pflk vkjd ndmz (contains shellfish, peanuts)\nmqmq fxsrc shkkk pflk rghrrt klcl gbsvjgg rpf ffgs rrngl bscmf nrbl ttzd pqhd tk rzfcn sbtz krh cjf bltzkxx rmngx szcgft mcvjsk cftgsk vzfg mccpbg vgzjp bqcjvv xbdh vdm zdznn hvlc dvrhz zlcbnx mhlv ggqsr rbxnc cdhfzl spql tplp ztv djp fzkxc hzr dzqlq sncl bgvng kjfnqg tvndt hqff ghvj xrjzvh dsbj fpc jcpnmh dsrxrt mkpc szh rblzjb bchbc jpvrvr bclc hhgqp tfn cnnd vrgk xcq hlk sjxxzrd dk spcqmzfg ljsmrl bhgpk qpngxk lhslfpx ccjjp fpfdkl cxhplp tgfcl (contains wheat, nuts)\nbkqzk dzqlq rpjcjd spcqmzfg kcmmj ngzp hpdn bthckj shptr qmbxq spql xzzl bbgz zphlmnb vdjjl czs cxhplp fzkxc sjxxzrd smktk zlcbnx mfnc nrbl vdm qlv crsp qbrr mkt srhcd mxpn qpngxk xbdh dpls dvrhz xrjzvh bltzkxx csdbg bmnqp mqmq zvtvzc gtgkt bltrbvz szh hhppz bxcgf pflk dsbj klcl mkhbznt vgh lzxgf ljsmz rlcv btpdk pqhd qfkgx mkpc hrmdt ccjjp tplp (contains fish, wheat, nuts)\nszcgft dfk ksbr zpkl ffmgfz mhvtp dzqlq rpf hgcb rgnz pmht ccjjp nb zgfl kjfnqg bltzkxx qmbxq bxxs mhlv rmngx spcqmzfg vkjd spql rtjk bthckj tplp zll nqsdkrh cfl xhlkscn pflk bgvng gbsvjgg vzfg krh hpdn xbdh bclc ljsmz pxldx lzxgf fpfdkl kcmmj zphlmnb crscm btpdk jrvxh ndmz mpbsn jcpnmh (contains fish)\nplmpl crscm bltzkxx rbprd nzhtc mcgx xdjhhj lgccp vrgk zphlmnb czs lhslfpx nqsdkrh ghvj shptr spcqmzfg mhlv bltrbvz jcpnmh rpf kjfnqg spql vgh sjxxzrd qlhqg qtxgzpx fxsrc mhvtp qbrr njdfc zgfl dpmcrh vxmfmjjh nrbl dzqlq xcq krh lgm dsbj cnnd jsphx mkhbznt mkpc vpchddj mcvjsk rzfcn zvtvzc cqzqvj bthckj gtgkt mxpn hhppz rghrrt nb xbdh mhsr cxhplp ffgs dpls qgkhxq qlv qfkgx vxkkgd ttzd szcgft tplp jgblz (contains shellfish, dairy)\nzbhmgm bgvng jcpnmh btpdk ksbr rpf txs nhsx dfk qmbxq zll bltzkxx rbxnc qlv ggqsr kbzmtz hzr czstl nbrh dvrhz pflk srhcd zdvcnx spcqmzfg shkkk hvlc cqzqvj rlcv crsp bthckj ztrgb fzkxc xhlkscn rtxfsp rznmz bnkgs tgfcl blvlch cmlh bltrbvz hcnmld vdjjl jpvrvr qpngxk xdjhhj ffmgfz xrjzvh cdhfzl ngzp shptr gtgkt njdfc mqmq cxhplp spql vrgk rghrrt dsbj krsl bbhvzz rgnz vgh ffgs ghvj mhsr tplp sncl ngx dzqlq cftgsk mcvjsk bbgz bvskjzc qtxgzpx hhppz mkhbznt cnnd (contains nuts, dairy, wheat)\nbclc djp jgblz shptr smktk tpvb mflngx bltzkxx jpvrvr hcnmld krsl bbgz rblzjb tk dzqlq qfkgx lgm tgfcl spql vxmfmjjh kjfnqg hhppz hpdn bnnqz xbdh jcpnmh ghvj jrvxh zdvcnx pqhd hqnnsm bltrbvz mcvjsk krh qlhqg cftgsk rmngx kbzmtz hlk rzfcn bxcgf fkszg gtgkt bsql hzfd ndmz bqrpdxt mxpn nzhtc bscmf ffmgfz nhsx spcqmzfg shkkk pflk nb rhjbx qgkhxq rznmz ftkqfrv kqth vzfg hzr txs gbsvjgg rtjk rbprd ngx ljsmrl zlcbnx xhlkscn zpkl qbrr (contains fish, wheat)\nmflngx rpf rblzjb qpngxk vgh hpdn mkhbznt ljsmrl jqrq qlhqg cnnd spcqmzfg zlcbnx lzxgf jrvxh gtgkt mhvtp mhlv jvjmd rrngl bnkgs zgfl ljsmz spql bqrpdxt xbdh qpzcmf tprdg ghvj pxldx xhlkscn pflk jgblz ztv pmht nzhtc mkpc ztrgb ngx tplp tgfcl zpcscz lvrp dtvsk bltrbvz mkt xrjzvh mccpbg bxxs hflzrt zxftz tpvb nb bbgz bxcgf jcpnmh ffmgfz bltzkxx hhgqp (contains peanuts, shellfish)\nmhlv qpngxk vkjd bnkgs rghrrt mxpn vpchddj gtgkt jzcrblh dsrxrt jgblz xbdh bltzkxx vdm bbgz mcvjsk gbsvjgg spql fxsrc zpcscz tpvb nbrh mfqvks hvlc zlcbnx nzhtc dpmcrh dvrhz shkkk rpf pflk bqcjvv cqzqvj shptr smktk mkpc crsp nrbl zpkl fkszg rpjcjd dzqlq hcnmld hflzrt mhvtp qbrr zgfl dk xdjhhj pmht szh ttzd mqmq rgnz bbhvzz dpls ffmgfz btpdk jcpnmh bltrbvz vzfg vxmfmjjh dtvsk zll cnnd qtxgzpx ndmz sncl ngzp dfk vxkkgd bthckj czs czstl (contains eggs)\ntvndt rpf spql vzfg nbrh zpcscz hrmdt bltzkxx spcqmzfg qtxgzpx mcgx dsbj rpjcjd bnnqz hzr vdm dzqlq kbzmtz zpkl jgblz klcl bltrbvz rznmz rbprd ljsmz njdfc ghvj dk lvrp gtgkt nb xzzl mqmq bscmf jpvrvr krsl rlcv mhvtp bsql ztrgb fzkxc bbhvzz ztv sbtz xbdh bhgpk mccpbg plmpl bkqzk mkpc mhsr xdjhhj fkszg rrngl zbhmgm ftkqfrv (contains fish)\njgblz jsphx rlcv gbsvjgg dzqlq cmlh bqcjvv shkkk dtvsk klcl tplp bxxs qbrr rznmz spcqmzfg czstl zvtvzc rbxnc rpjcjd xbdh hgcb vgh qlhqg ffmgfz crsp ttzd tvndt gtgkt hlk mhvtp bmnqp rmngx mhsr vkjd kjfnqg ksbr zbhmgm mccpbg ztv bltrbvz kbzmtz rgnz bthckj rpf hflzrt qmbxq crscm kqth lgm pmht dsbj bnnqz blvlch spql pflk hzfd (contains sesame, fish)\nzphlmnb njdfc ggqsr bqrpdxt ftkqfrv zpkl lgccp ffgs smktk ccjjp spcqmzfg bkqzk hpdn rtjk xbdh sncl xcq zdznn hqff nhsx fpc jpvrvr cjf dfk hflzrt hlk pqhd mccpbg bltrbvz jzcrblh mhlv gtgkt xdjhhj rblzjb rghrrt zpcscz qbrr zvtvzc mkhbznt jvjmd ttzd mhvtp dsbj bltzkxx tgfcl ljsmrl kqth rbprd kcmmj hgcb blvlch pflk ffmgfz rmngx hzfd bbhvzz zgfl hqnnsm tvndt cqzqvj nqsdkrh spql tplp shptr krh tfn ztrgb crsp ghvj hzr rpf rhjbx kjfnqg (contains peanuts, dairy)\nblvlch mpbsn spcqmzfg smktk nbrh bchbc bxxs ghvj mfqvks qpzcmf pxldx ndmz qbrr qlv hffzvrj hrmdt ffgs nzhtc frnz vkjd csdbg kjfnqg rzfcn dtvsk jrvxh crsp rbprd krh qlhqg tprdg mkhbznt rhjbx tvndt jsphx nb shptr hzfd rpf dpmcrh mkt jgblz rghrrt zlcbnx bgvng hqnnsm pflk cdhfzl srhcd bltrbvz fpc zdvcnx xbdh dzqlq nrbl vrgk lhslfpx bmnqp bltzkxx hgcb dfk jpvrvr gbsvjgg czstl ffmgfz vzfg (contains wheat)\nbsql nzhtc tvndt dfk klcl zbhmgm cxhplp pflk vpchddj vdm tfn pxldx vzfg nhsx nqsdkrh ndmz gtgkt nrbl mqmq srhcd bqcjvv vkjd smktk qpzcmf tk cftgsk jrvxh hhgqp kbzmtz btpdk hrmdt bvskjzc qtxgzpx dvrhz crscm mhlv nb krh zpkl rrngl zlcbnx rpf dpls njdfc dzqlq bltrbvz spcqmzfg ftkqfrv xcq qbrr rbprd rzfcn dk ggqsr rlcv sbtz mcgx qmbxq spql fpfdkl hlk hflzrt xbdh fzkxc zll qgkhxq csdbg mhvtp shkkk szcgft (contains sesame, shellfish)\nbhgpk spql jzcrblh bltrbvz vxmfmjjh cnnd lgm spcqmzfg gtgkt pflk mpbsn dk vkjd vrgk bbgz tprdg bclc zvtvzc zpcscz rblzjb krh gbsvjgg bbhvzz qlhqg ksbr mqmq ccjjp bgvng hzr zlcbnx ndmz hqnnsm hrmdt lgccp blvlch rbxnc czs ljsmz qmbxq jvjmd zjdkj kbzmtz sncl nrbl rgnz bmnqp rrngl cfl rpf bxcgf nzhtc dvrhz tplp dzqlq dsrxrt jpvrvr ghvj hvlc vgh klcl zxftz bsql lvrp hzfd ttzd rghrrt qlv bnkgs rmngx dsbj xbdh pmht mkt xrjzvh hhppz shptr btpdk bqcjvv smktk ggqsr hgcb tk ljsmrl hflzrt tvndt bnnqz (contains shellfish, dairy)\ntxs bqrpdxt fxsrc xdjhhj bnnqz bltrbvz fpc hhppz qpngxk spcqmzfg rbprd qgkhxq jcpnmh szcgft rpf hflzrt csdbg qlv czstl gtgkt zxftz lhslfpx fkszg zpkl ffgs ngx djp ztrgb rmngx bltzkxx spql lgm mfqvks vrgk mflngx tvndt dzqlq jvjmd jpvrvr zgfl smktk mcvjsk bthckj rtjk mpbsn bscmf xbdh qlhqg (contains shellfish, wheat)\njsphx dpmcrh qmbxq jzcrblh bvskjzc zdvcnx fzkxc jrvxh xcq mkhbznt lgccp mkpc rpf dpls ngx dk bbgz gtgkt mccpbg qlhqg zpcscz csdbg sbtz vgh spql dzqlq ndmz jvjmd crscm hgcb qpngxk rbxnc qtxgzpx bhgpk zvtvzc szh djp mflngx vrgk jgblz njdfc hzfd nrbl bchbc sjxxzrd spcqmzfg vdm xbdh bltzkxx fkszg rblzjb rpjcjd hhppz cfl bthckj pmht cftgsk pxldx mcgx mfqvks bltrbvz xhlkscn hzr tfn (contains sesame, shellfish)\nvzfg bthckj blvlch rtjk bqrpdxt zvtvzc bvskjzc fpc zphlmnb nbrh zxftz xdjhhj csdbg cfl xbdh zdvcnx frnz zlcbnx mkhbznt xcq czs lzxgf mhsr spcqmzfg szcgft xhlkscn ggqsr tprdg cqzqvj qlv bsql mkpc qlhqg rpf bbhvzz dvrhz jzcrblh gtgkt mflngx bltrbvz nb bxxs klcl mqmq pqhd sncl ftkqfrv tfn hpdn qbrr spql ffmgfz bltzkxx dzqlq lhslfpx zbhmgm (contains eggs, fish)\nbbgz xdjhhj bclc vkjd szcgft rrngl mcgx sjxxzrd zpcscz rpjcjd jzcrblh tgfcl zjdkj hhppz dpls tvndt zlcbnx bqcjvv ngzp mhsr qpngxk mpbsn tfn ngx gbsvjgg lgm xcq xbdh cftgsk mkpc ztv njdfc rtjk bqrpdxt jqrq szh ttzd cqzqvj mhvtp dpmcrh qgkhxq klcl pflk spcqmzfg mflngx rmngx frnz cxhplp rzfcn lhslfpx hqnnsm hpdn hzfd hcnmld hffzvrj blvlch nrbl hgcb ztrgb mkt dzqlq fzkxc jgblz ffmgfz rhjbx vrgk xhlkscn rghrrt spql vgh vxmfmjjh jvjmd bltrbvz jcpnmh ggqsr qlv rlcv zdznn zll xzzl vxkkgd qmbxq hrmdt pxldx bkqzk rpf (contains eggs)\nnb dzqlq jvjmd bltrbvz sbtz hffzvrj lgm mfqvks vdm txs ffgs mqmq qpngxk hhgqp njdfc hrmdt mcgx qlv nrbl fkszg rzfcn bltzkxx dfk mhlv vgzjp spcqmzfg hqnnsm rpf tplp rpjcjd hhppz xbdh bbgz qgkhxq hflzrt blvlch mfnc bxxs hqff mxpn fzkxc cnnd nzhtc rghrrt kjfnqg qlhqg bbhvzz bnkgs tvndt bxcgf spql bmnqp hvlc xzzl (contains sesame, peanuts, eggs)\nksbr kjfnqg mpbsn qmbxq qbrr qgkhxq gtgkt mcvjsk btpdk mkt dzqlq ggqsr rgnz kbzmtz rpf bsql tk hhppz zjdkj bltrbvz jpvrvr tprdg vgh hzfd szh szcgft hflzrt hlk rrngl bbhvzz gbsvjgg kqth bhgpk vzfg ljsmz jcpnmh mflngx bmnqp dsbj mcgx dsrxrt klcl rblzjb xbdh rpjcjd bqrpdxt mkhbznt frnz krh smktk hgcb jrvxh spcqmzfg dtvsk qlhqg dvrhz fzkxc rlcv txs zpkl cfl zdznn xhlkscn lhslfpx vxmfmjjh nqsdkrh rghrrt bltzkxx qpzcmf jgblz ccjjp pflk bclc mqmq shkkk dk (contains dairy, nuts)\ntk bqcjvv pflk mxpn rgnz rmngx vdjjl fpc vrgk ljsmz mfqvks vgh ffgs nhsx bchbc rpf zll dtvsk nqsdkrh vkjd czstl dzqlq hqnnsm zdvcnx bltzkxx hcnmld spcqmzfg srhcd sncl hgcb ngx rzfcn jcpnmh mqmq nbrh bbgz dk mflngx bltrbvz crscm ndmz spql qfkgx bgvng zpkl jrvxh mfnc zphlmnb zbhmgm sjxxzrd dvrhz ffmgfz hrmdt fzkxc jqrq cnnd szh (contains nuts, shellfish)\nbchbc zphlmnb frnz fzkxc xbdh zpkl btpdk csdbg zbhmgm nrbl qpzcmf rtjk mxpn cqzqvj hhgqp zpcscz bgvng mpbsn shptr hzfd vdm fkszg lvrp lzxgf bltzkxx dpmcrh nzhtc kbzmtz vxkkgd hflzrt kqth gtgkt ggqsr rghrrt bclc mfqvks dtvsk bltrbvz vgh tprdg zvtvzc txs pxldx bbhvzz sncl mhvtp kjfnqg hcnmld krh hzr blvlch qfkgx spcqmzfg qtxgzpx bqrpdxt krsl rbxnc dzqlq rpf pflk fxsrc zlcbnx bxcgf zdznn jgblz (contains fish)"]
    (time (day21part1 puzzle)))
  ;"Elapsed time: 5.73496 msecs"
  ;=> 1930
  )