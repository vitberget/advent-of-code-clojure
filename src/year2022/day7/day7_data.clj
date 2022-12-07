(ns year2022.day7.day7-data)

(def day7-example "$ cd /\n$ ls\ndir a\n14848514 b.txt\n8504156 c.dat\ndir d\n$ cd a\n$ ls\ndir e\n29116 f\n2557 g\n62596 h.lst\n$ cd e\n$ ls\n584 i\n$ cd ..\n$ cd ..\n$ cd d\n$ ls\n4060174 j\n8033020 d.log\n5626152 d.ext\n7214296 k")
;$ cd /
;$ ls
;dir a
;14848514 b.txt
;8504156 c.dat
;dir d
;$ cd a
;$ ls
;dir e
;29116 f
;2557 g
;62596 h.lst
;$ cd e
;$ ls
;584 i
;$ cd ..
;$ cd ..
;$ cd d
;$ ls
;4060174 j
;8033020 d.log
;5626152 d.ext
;7214296 k

(def day7-puzzle "$ cd /\n$ ls\ndir ddpgzpc\ndir mqjrd\ndir mrqjg\ndir rglgbsq\n298050 tjmjp.cqm\ndir wlqhpwqv\n$ cd ddpgzpc\n$ ls\n290515 cvrd.hcf\ndir mlm\n122034 rrtnthnt.zgs\n12680 tvnrl\n49534 vljqzqg\ndir zffbmlbd\n18557 zfhnw.jfd\n$ cd mlm\n$ ls\n102897 zfhnw.zpd\n$ cd ..\n$ cd zffbmlbd\n$ ls\ndir bqpwdh\ndir gqrlmdhs\n315267 mjm.dhc\n294364 mrqdw.npr\ndir szqz\n76621 tvnrl\n285948 vpdbrh\n155914 vwl.vsq\ndir zfhnw\n$ cd bqpwdh\n$ ls\ndir bhmw\n27669 dtzw\ndir lfhgjw\ndir pjqwq\n$ cd bhmw\n$ ls\n190433 zbcbr\n$ cd ..\n$ cd lfhgjw\n$ ls\ndir ndrcgmd\n$ cd ndrcgmd\n$ ls\n98160 mjm.dhc\n$ cd ..\n$ cd ..\n$ cd pjqwq\n$ ls\n50937 dtzw\n186171 mjm.dhc\n305433 mlm\n272969 mlm.rhf\n$ cd ..\n$ cd ..\n$ cd gqrlmdhs\n$ ls\ndir blc\n331077 dcchtmp\ndir mlm\n199021 rlzjl\n253162 vghhgvjq\ndir zfhnw\n$ cd blc\n$ ls\n53872 drjdcqw.szd\n115417 ggh.qsl\n65105 pjqwq\n$ cd ..\n$ cd mlm\n$ ls\ndir bqpwdh\n200734 gjhzr.ffz\n277561 lwnl.jsl\ndir sdjnlsf\ndir trqhm\n140014 tvnrl\n$ cd bqpwdh\n$ ls\ndir jzfgz\n$ cd jzfgz\n$ ls\n334790 dtzw\n$ cd ..\n$ cd ..\n$ cd sdjnlsf\n$ ls\n326446 mjm.dhc\ndir vpdbrh\n$ cd vpdbrh\n$ ls\n20883 bwjjdszc\n10518 dtzw\n64779 ppmwtlj.btf\n320555 rpf.tmw\n295126 vwl.vsq\n$ cd ..\n$ cd ..\n$ cd trqhm\n$ ls\n184138 rmnmsl\n$ cd ..\n$ cd ..\n$ cd zfhnw\n$ ls\ndir pjqwq\n$ cd pjqwq\n$ ls\ndir qjzscp\n$ cd qjzscp\n$ ls\n299311 tvnrl\n$ cd ..\n$ cd ..\n$ cd ..\n$ cd ..\n$ cd szqz\n$ ls\ndir bqpwdh\n107678 jmqq\n109752 vtmgq.bcz\n301721 zjdlztw\ndir zwvzzz\n$ cd bqpwdh\n$ ls\ndir mlm\n$ cd mlm\n$ ls\n178616 mlm.rnn\n$ cd ..\n$ cd ..\n$ cd zwvzzz\n$ ls\n135690 rrbv.ntn\n$ cd ..\n$ cd ..\n$ cd zfhnw\n$ ls\ndir dtgnbb\n55267 dtzw\n119612 mjm.dhc\n$ cd dtgnbb\n$ ls\n74360 zjq\n$ cd ..\n$ cd ..\n$ cd ..\n$ cd ..\n$ cd mqjrd\n$ ls\ndir ccnpn\n176761 rmnmsl\n$ cd ccnpn\n$ ls\n116424 pjqwq.ctj\n$ cd ..\n$ cd ..\n$ cd mrqjg\n$ ls\ndir bsphvqnh\n266338 lwfdlqzq.wmj\n287488 mjm.dhc\n211569 mlm.mbn\n231144 vpdbrh\n260476 vtqjh.wfj\n$ cd bsphvqnh\n$ ls\n101783 pscn.zdh\n$ cd ..\n$ cd ..\n$ cd rglgbsq\n$ ls\ndir bqpwdh\ndir fdmhnzw\ndir fgz\n213313 hbj.lgh\ndir lftcr\ndir pjqwq\n1614 rmnmsl\ndir rpz\ndir vpcq\ndir zfhnw\n$ cd bqpwdh\n$ ls\n35649 mjm.dhc\n53750 nqdlf.trh\n102195 vpdbrh.lbn\n$ cd ..\n$ cd fdmhnzw\n$ ls\n222384 dtzw\n$ cd ..\n$ cd fgz\n$ ls\ndir rzrsgst\ndir tqdghbj\n$ cd rzrsgst\n$ ls\n120970 dtzw\ndir zfhnw\n$ cd zfhnw\n$ ls\n154286 fmbzztww.hvt\n$ cd ..\n$ cd ..\n$ cd tqdghbj\n$ ls\n275314 rmblptm\n$ cd ..\n$ cd ..\n$ cd lftcr\n$ ls\n148378 cwjj.trb\n215545 zfhnw.fjl\n$ cd ..\n$ cd pjqwq\n$ ls\ndir bppdtc\ndir dnlzz\n$ cd bppdtc\n$ ls\n276258 zfhnw.rfn\n$ cd ..\n$ cd dnlzz\n$ ls\n286311 cjzm.nhs\n239107 ggdr.rgz\ndir zfhnw\n$ cd zfhnw\n$ ls\ndir rzht\n$ cd rzht\n$ ls\n100504 thj\n$ cd ..\n$ cd ..\n$ cd ..\n$ cd ..\n$ cd rpz\n$ ls\n182300 brsnhb\ndir pblmwf\n261712 rmnmsl\ndir zfhnw\n$ cd pblmwf\n$ ls\n121117 mlm.zdq\n$ cd ..\n$ cd zfhnw\n$ ls\n281353 gwbrctf\ndir hgpnj\ndir lvhwhz\ndir mlm\ndir pcfljzhm\ndir vpdbrh\n$ cd hgpnj\n$ ls\n103619 vwl.vsq\n$ cd ..\n$ cd lvhwhz\n$ ls\n236328 bqpwdh.qtn\ndir gjwth\n118100 jfcmcq\ndir lwsdfhg\n51327 mjm.dhc\n41403 mlm\ndir vpdbrh\n313830 zmwhlcsw\n$ cd gjwth\n$ ls\ndir bqpwdh\n128093 css\n290123 pjqwq.djg\n89091 whdwbssf.tss\n$ cd bqpwdh\n$ ls\n186274 rmnmsl\n$ cd ..\n$ cd ..\n$ cd lwsdfhg\n$ ls\n218938 mjm.dhc\n$ cd ..\n$ cd vpdbrh\n$ ls\n139398 lrrjnvr\n$ cd ..\n$ cd ..\n$ cd mlm\n$ ls\n278462 fdlb.jsr\n176936 tvnrl\n29208 vwl.vsq\n$ cd ..\n$ cd pcfljzhm\n$ ls\n295983 nnvq.lcg\n$ cd ..\n$ cd vpdbrh\n$ ls\n16998 lswwmjc.vmv\n52872 pmbzp.mmg\n$ cd ..\n$ cd ..\n$ cd ..\n$ cd vpcq\n$ ls\ndir tnrpllzj\n$ cd tnrpllzj\n$ ls\n226232 nqrjs.qds\n$ cd ..\n$ cd ..\n$ cd zfhnw\n$ ls\n188324 dtzw\n263511 lnwwh\n217287 lst.wvw\n178366 vzctflm\n$ cd ..\n$ cd ..\n$ cd wlqhpwqv\n$ ls\ndir bqpwdh\ndir ffw\ndir lpzgcrd\ndir lszdbd\n51178 mlm\ndir ntcpvg\ndir pjqwq\ndir pmpftw\ndir ppf\ndir vpdbrh\ndir zfhnw\n$ cd bqpwdh\n$ ls\n194389 dnqngfzh\n$ cd ..\n$ cd ffw\n$ ls\ndir mfqd\ndir npgnwwf\ndir tcvt\n$ cd mfqd\n$ ls\n214846 vwl.vsq\n$ cd ..\n$ cd npgnwwf\n$ ls\ndir ddqsmtsj\ndir gcq\ndir ldtpnr\n1802 vwl.vsq\n$ cd ddqsmtsj\n$ ls\n309790 rmnmsl\n$ cd ..\n$ cd gcq\n$ ls\n80203 lvqhwzfn\n$ cd ..\n$ cd ldtpnr\n$ ls\ndir spzj\n123522 tvnrl\n$ cd spzj\n$ ls\n139171 bpgpdzt.zzp\n$ cd ..\n$ cd ..\n$ cd ..\n$ cd tcvt\n$ ls\ndir jcvcjz\ndir qmtcr\ndir vpdbrh\n$ cd jcvcjz\n$ ls\n274564 hsv.wsr\n309010 vpdbrh\n$ cd ..\n$ cd qmtcr\n$ ls\ndir mfjd\ndir pmbdsb\n$ cd mfjd\n$ ls\n202111 vpdbrh\n$ cd ..\n$ cd pmbdsb\n$ ls\ndir brghd\n313440 chwzrz.bmf\n$ cd brghd\n$ ls\n216516 dtzw\n$ cd ..\n$ cd ..\n$ cd ..\n$ cd vpdbrh\n$ ls\n134552 sbs.bsn\n$ cd ..\n$ cd ..\n$ cd ..\n$ cd lpzgcrd\n$ ls\n244257 bqpwdh.hsz\n118275 flgfbstp.flp\ndir gcwg\ndir mlm\ndir nfj\n189443 rtwwbgfs.nvl\ndir trbwtdb\ndir vpdbrh\ndir ztwbpvbq\n$ cd gcwg\n$ ls\ndir bqpwdh\n304960 dtzw\n9496 pfpwtsp\ndir pjqwq\ndir vpdbrh\ndir vqp\n186883 vwl.vsq\n$ cd bqpwdh\n$ ls\n79064 fbjdqsn.cgp\n$ cd ..\n$ cd pjqwq\n$ ls\n106371 cplcj\n204740 mhdq.lhc\n313462 pjqwq.lsn\n249876 rmnmsl\n209574 vwl.vsq\n$ cd ..\n$ cd vpdbrh\n$ ls\n166549 mjm.dhc\n270734 rmnmsl\n$ cd ..\n$ cd vqp\n$ ls\ndir nbq\ndir nts\ndir rlbhdgm\ndir srvqpq\ndir zfhnw\n$ cd nbq\n$ ls\n63369 mjm.dhc\n314393 smd\n70181 tbwpwtt.ccj\n97954 vpdbrh.fmw\n$ cd ..\n$ cd nts\n$ ls\n11300 zfhnw.pnj\n$ cd ..\n$ cd rlbhdgm\n$ ls\ndir bzd\ndir hfhzj\n65400 mbrqjnp.wqz\ndir pztwz\n$ cd bzd\n$ ls\ndir bqpwdh\n168832 cdlg.zhp\ndir dtb\n22418 fttt.twt\ndir gmlgvnq\n101839 hnpjbjsc.whd\ndir pdmqn\n122491 smvjvw\ndir wmtdbrqm\n52142 zfhnw.gmt\n$ cd bqpwdh\n$ ls\ndir btb\n37220 gzj.mhf\ndir lwl\n112215 qcfqd.fwz\n210303 qlwgqnsp\ndir trpm\n$ cd btb\n$ ls\ndir rqftrtb\ndir vsb\n$ cd rqftrtb\n$ ls\ndir ndwphjw\ndir pjqwq\ndir zfhnw\n$ cd ndwphjw\n$ ls\n256159 lpprpwjq.srz\n$ cd ..\n$ cd pjqwq\n$ ls\ndir fpb\n$ cd fpb\n$ ls\n42692 pjqwq\n$ cd ..\n$ cd ..\n$ cd zfhnw\n$ ls\ndir bqpwdh\n$ cd bqpwdh\n$ ls\n17467 mshfwzv.ppr\n$ cd ..\n$ cd ..\n$ cd ..\n$ cd vsb\n$ ls\n278554 rmnmsl\n$ cd ..\n$ cd ..\n$ cd lwl\n$ ls\n28409 mjm.dhc\n$ cd ..\n$ cd trpm\n$ ls\ndir mlm\n$ cd mlm\n$ ls\n304742 dtzw\n108223 mjm.dhc\ndir mvh\n52532 nzc.vhj\ndir tdhrrhm\n$ cd mvh\n$ ls\n99770 cgfw.pgm\n$ cd ..\n$ cd tdhrrhm\n$ ls\n326653 lrmsnt.fdh\n157903 mlm\n$ cd ..\n$ cd ..\n$ cd ..\n$ cd ..\n$ cd dtb\n$ ls\n179072 vpdbrh\n3435 vpdbrh.hpv\n$ cd ..\n$ cd gmlgvnq\n$ ls\ndir rrjgswsd\n$ cd rrjgswsd\n$ ls\ndir zfhnw\n$ cd zfhnw\n$ ls\n278562 mvqbv\n$ cd ..\n$ cd ..\n$ cd ..\n$ cd pdmqn\n$ ls\n233744 pjqwq\n$ cd ..\n$ cd wmtdbrqm\n$ ls\ndir lngc\ndir wgpwcj\n225374 wphwht.nvn\n$ cd lngc\n$ ls\n4415 zfhnw\n$ cd ..\n$ cd wgpwcj\n$ ls\n165889 bqpwdh.ngg\n331254 dlpr\n97910 mzjlswr.spn\ndir rqhshd\n49222 vwl.vsq\n$ cd rqhshd\n$ ls\n145902 qwhr\n$ cd ..\n$ cd ..\n$ cd ..\n$ cd ..\n$ cd hfhzj\n$ ls\n92623 ldlpnvw\n146918 mjm.dhc\n$ cd ..\n$ cd pztwz\n$ ls\ndir jllmcfjf\n$ cd jllmcfjf\n$ ls\n245363 dtzw\n81345 mbh.vdq\n164199 ntwzgfr\n14466 rmnmsl\n$ cd ..\n$ cd ..\n$ cd ..\n$ cd srvqpq\n$ ls\n271019 zfhnw.rlc\n$ cd ..\n$ cd zfhnw\n$ ls\n104520 bqpwdh.qqv\n12312 lspg\n$ cd ..\n$ cd ..\n$ cd ..\n$ cd mlm\n$ ls\n259906 cbgmp\ndir rjshqvb\n$ cd rjshqvb\n$ ls\n309983 mlm.qmm\n$ cd ..\n$ cd ..\n$ cd nfj\n$ ls\n44759 mlm\n228634 njrrs.sjj\ndir rfmw\n$ cd rfmw\n$ ls\n273185 bcbjq.vlw\n$ cd ..\n$ cd ..\n$ cd trbwtdb\n$ ls\n307053 mjm.dhc\n301028 zzg\n$ cd ..\n$ cd vpdbrh\n$ ls\ndir bzdp\n169466 grnvt.mst\ndir pjqwq\n123590 vwl.vsq\n$ cd bzdp\n$ ls\n225941 trrzqz\n241249 vpdbrh.lsj\n$ cd ..\n$ cd pjqwq\n$ ls\ndir ddfpql\ndir fgbqzm\n329174 mjm.dhc\n6701 mlm.ffp\ndir phf\n$ cd ddfpql\n$ ls\n103799 lpbp.bpt\n$ cd ..\n$ cd fgbqzm\n$ ls\ndir spsz\n$ cd spsz\n$ ls\n34049 mfgph\n$ cd ..\n$ cd ..\n$ cd phf\n$ ls\n84883 qdj.hbt\n$ cd ..\n$ cd ..\n$ cd ..\n$ cd ztwbpvbq\n$ ls\n138429 bqpwdh.mlr\n151403 cqmbgfdh.gvh\n9087 ngm\n335933 sswtt\n318963 tvnrl\ndir wdhjpzp\n$ cd wdhjpzp\n$ ls\n119932 pjqwq\n$ cd ..\n$ cd ..\n$ cd ..\n$ cd lszdbd\n$ ls\ndir cpqpvbz\ndir hnl\ndir llprt\n$ cd cpqpvbz\n$ ls\ndir ltlcz\ndir wmpsvm\n$ cd ltlcz\n$ ls\n262150 zfhnw.zsg\n$ cd ..\n$ cd wmpsvm\n$ ls\ndir bqpwdh\n$ cd bqpwdh\n$ ls\n51488 pvhcb.qmw\n44038 zfhnw\n$ cd ..\n$ cd ..\n$ cd ..\n$ cd hnl\n$ ls\ndir pjqwq\n$ cd pjqwq\n$ ls\n170454 mhg.ddj\n$ cd ..\n$ cd ..\n$ cd llprt\n$ ls\n268114 bmvwwbdt.cqm\n207425 dtzw\n180660 mgqz\n297846 qbpcd\n112867 zdb\n$ cd ..\n$ cd ..\n$ cd ntcpvg\n$ ls\n74161 bqpwdh.gbr\n257792 vwl.vsq\n$ cd ..\n$ cd pjqwq\n$ ls\n279738 hwdgzvj\ndir jsdbnwrc\ndir pcjfjsgs\n11113 rqrtcq\n208212 tvnrl\ndir vllzsh\n$ cd jsdbnwrc\n$ ls\n11720 fvj\n$ cd ..\n$ cd pcjfjsgs\n$ ls\ndir bqpwdh\n195046 mjm.dhc\ndir ssq\ndir vpdbrh\n$ cd bqpwdh\n$ ls\n42769 dlrvsj\n159280 zfhnw\n239759 zqqcb\n$ cd ..\n$ cd ssq\n$ ls\n67639 bqpwdh.csb\n$ cd ..\n$ cd vpdbrh\n$ ls\ndir bqdpwrst\ndir qtj\n$ cd bqdpwrst\n$ ls\n57800 fndpnj.fgt\n132712 vpdbrh\n$ cd ..\n$ cd qtj\n$ ls\ndir szjtvcb\n$ cd szjtvcb\n$ ls\n93993 mgmqtdb.fzd\ndir stbczmlq\n$ cd stbczmlq\n$ ls\ndir nhq\n$ cd nhq\n$ ls\n27749 hqgngdt.tmq\n$ cd ..\n$ cd ..\n$ cd ..\n$ cd ..\n$ cd ..\n$ cd ..\n$ cd vllzsh\n$ ls\ndir nlwwrz\n237293 wlgbt\ndir zhmwl\n$ cd nlwwrz\n$ ls\n99990 bjv.szl\n$ cd ..\n$ cd zhmwl\n$ ls\ndir hbpps\ndir hfv\n$ cd hbpps\n$ ls\n7520 mlm.ltq\n$ cd ..\n$ cd hfv\n$ ls\ndir qpfrd\n$ cd qpfrd\n$ ls\ndir mlm\n$ cd mlm\n$ ls\n288919 qmtpwqn\n$ cd ..\n$ cd ..\n$ cd ..\n$ cd ..\n$ cd ..\n$ cd ..\n$ cd pmpftw\n$ ls\n118859 mlm\n103896 pjqwq\n128800 tvnrl\n$ cd ..\n$ cd ppf\n$ ls\ndir drszpqf\ndir fbs\n202594 gdpw.bds\ndir ldnrpg\n176398 mbbmmf.plr\ndir tfjnj\n$ cd drszpqf\n$ ls\ndir pjqwq\ndir qtblb\n191392 tvnrl\n$ cd pjqwq\n$ ls\ndir lrrlbgwh\ndir nfcc\ndir pqm\n$ cd lrrlbgwh\n$ ls\n182434 mjm.dhc\n238706 vpdbrh.lgz\n$ cd ..\n$ cd nfcc\n$ ls\n253846 vpdbrh\n268229 vwl.vsq\n$ cd ..\n$ cd pqm\n$ ls\n56573 vwl.vsq\n$ cd ..\n$ cd ..\n$ cd qtblb\n$ ls\n28941 zcm.dtw\n52282 zmhw.lhm\n$ cd ..\n$ cd ..\n$ cd fbs\n$ ls\ndir gpttw\n$ cd gpttw\n$ ls\ndir bqpwdh\n$ cd bqpwdh\n$ ls\n98780 wvzhlfht.rdd\n$ cd ..\n$ cd ..\n$ cd ..\n$ cd ldnrpg\n$ ls\n205523 bqpwdh.qlb\n54924 pcq.clf\n$ cd ..\n$ cd tfjnj\n$ ls\n237752 bqpwdh.bvf\ndir lwl\n295520 mjm.dhc\ndir qsgpsmzw\n278576 rmnmsl\ndir vljqlw\n225025 vwl.vsq\n100780 zgjhtrv\n$ cd lwl\n$ ls\n150713 dhrl\n$ cd ..\n$ cd qsgpsmzw\n$ ls\n265288 bqpwdh\n92636 ntgrlr\n182224 wdb\n$ cd ..\n$ cd vljqlw\n$ ls\ndir pcnd\ndir pjqwq\n317809 tvnrl\n$ cd pcnd\n$ ls\n8283 gmq\n195909 rmnmsl\n183891 tvnrl\n182837 vwl.vsq\n$ cd ..\n$ cd pjqwq\n$ ls\ndir vwp\n$ cd vwp\n$ ls\ndir crpztfmf\ndir fhrfrbqg\n$ cd crpztfmf\n$ ls\n257441 dpztgnd\n$ cd ..\n$ cd fhrfrbqg\n$ ls\n64573 mjm.dhc\n$ cd ..\n$ cd ..\n$ cd ..\n$ cd ..\n$ cd ..\n$ cd ..\n$ cd vpdbrh\n$ ls\n80449 mjm.dhc\n266777 qfjwb\ndir qzmz\n100029 tvnrl\n28910 zqnp\n$ cd qzmz\n$ ls\n9583 wsfwpznj\n$ cd ..\n$ cd ..\n$ cd zfhnw\n$ ls\ndir pmdsb\n106595 vwl.vsq\ndir zdv\n$ cd pmdsb\n$ ls\ndir bqpwdh\ndir pjqwq\n$ cd bqpwdh\n$ ls\ndir tstqlh\n143862 vpdbrh.thr\n$ cd tstqlh\n$ ls\n119310 tcmglrz.hzp\n$ cd ..\n$ cd ..\n$ cd pjqwq\n$ ls\n56885 rmnmsl\n$ cd ..\n$ cd ..\n$ cd zdv\n$ ls\n209148 nhcdqmd.hgh\ndir pjdhn\n119411 pjqwq.vrq\n154423 rmnmsl\n178813 vhbjqhhq.tbf\n$ cd pjdhn\n$ ls\ndir gnthzp\n116732 qhrz.ssb\ndir rvbw\n117225 svmpwv\n$ cd gnthzp\n$ ls\ndir bqpwdh\n$ cd bqpwdh\n$ ls\n312253 rmnmsl\n$ cd ..\n$ cd ..\n$ cd rvbw\n$ ls\ndir cjdhwbv\n268173 lsmmthf\n99445 vwl.vsq\n$ cd cjdhwbv\n$ ls\n302711 tbhb\n173182 tmj.frb")
;$ cd /
;$ ls
;dir ddpgzpc
;dir mqjrd
;dir mrqjg
;dir rglgbsq
;298050 tjmjp.cqm
;dir wlqhpwqv
;$ cd ddpgzpc
;$ ls
;290515 cvrd.hcf
;dir mlm
;122034 rrtnthnt.zgs
;12680 tvnrl
;49534 vljqzqg
;dir zffbmlbd
;18557 zfhnw.jfd
;$ cd mlm
;$ ls
;102897 zfhnw.zpd
;$ cd ..
;$ cd zffbmlbd
;$ ls
;dir bqpwdh
;dir gqrlmdhs
;315267 mjm.dhc
;294364 mrqdw.npr
;dir szqz
;76621 tvnrl
;285948 vpdbrh
;155914 vwl.vsq
;dir zfhnw
;$ cd bqpwdh
;$ ls
;dir bhmw
;27669 dtzw
;dir lfhgjw
;dir pjqwq
;$ cd bhmw
;$ ls
;190433 zbcbr
;$ cd ..
;$ cd lfhgjw
;$ ls
;dir ndrcgmd
;$ cd ndrcgmd
;$ ls
;98160 mjm.dhc
;$ cd ..
;$ cd ..
;$ cd pjqwq
;$ ls
;50937 dtzw
;186171 mjm.dhc
;305433 mlm
;272969 mlm.rhf
;$ cd ..
;$ cd ..
;$ cd gqrlmdhs
;$ ls
;dir blc
;331077 dcchtmp
;dir mlm
;199021 rlzjl
;253162 vghhgvjq
;dir zfhnw
;$ cd blc
;$ ls
;53872 drjdcqw.szd
;115417 ggh.qsl
;65105 pjqwq
;$ cd ..
;$ cd mlm
;$ ls
;dir bqpwdh
;200734 gjhzr.ffz
;277561 lwnl.jsl
;dir sdjnlsf
;dir trqhm
;140014 tvnrl
;$ cd bqpwdh
;$ ls
;dir jzfgz
;$ cd jzfgz
;$ ls
;334790 dtzw
;$ cd ..
;$ cd ..
;$ cd sdjnlsf
;$ ls
;326446 mjm.dhc
;dir vpdbrh
;$ cd vpdbrh
;$ ls
;20883 bwjjdszc
;10518 dtzw
;64779 ppmwtlj.btf
;320555 rpf.tmw
;295126 vwl.vsq
;$ cd ..
;$ cd ..
;$ cd trqhm
;$ ls
;184138 rmnmsl
;$ cd ..
;$ cd ..
;$ cd zfhnw
;$ ls
;dir pjqwq
;$ cd pjqwq
;$ ls
;dir qjzscp
;$ cd qjzscp
;$ ls
;299311 tvnrl
;$ cd ..
;$ cd ..
;$ cd ..
;$ cd ..
;$ cd szqz
;$ ls
;dir bqpwdh
;107678 jmqq
;109752 vtmgq.bcz
;301721 zjdlztw
;dir zwvzzz
;$ cd bqpwdh
;$ ls
;dir mlm
;$ cd mlm
;$ ls
;178616 mlm.rnn
;$ cd ..
;$ cd ..
;$ cd zwvzzz
;$ ls
;135690 rrbv.ntn
;$ cd ..
;$ cd ..
;$ cd zfhnw
;$ ls
;dir dtgnbb
;55267 dtzw
;119612 mjm.dhc
;$ cd dtgnbb
;$ ls
;74360 zjq
;$ cd ..
;$ cd ..
;$ cd ..
;$ cd ..
;$ cd mqjrd
;$ ls
;dir ccnpn
;176761 rmnmsl
;$ cd ccnpn
;$ ls
;116424 pjqwq.ctj
;$ cd ..
;$ cd ..
;$ cd mrqjg
;$ ls
;dir bsphvqnh
;266338 lwfdlqzq.wmj
;287488 mjm.dhc
;211569 mlm.mbn
;231144 vpdbrh
;260476 vtqjh.wfj
;$ cd bsphvqnh
;$ ls
;101783 pscn.zdh
;$ cd ..
;$ cd ..
;$ cd rglgbsq
;$ ls
;dir bqpwdh
;dir fdmhnzw
;dir fgz
;213313 hbj.lgh
;dir lftcr
;dir pjqwq
;1614 rmnmsl
;dir rpz
;dir vpcq
;dir zfhnw
;$ cd bqpwdh
;$ ls
;35649 mjm.dhc
;53750 nqdlf.trh
;102195 vpdbrh.lbn
;$ cd ..
;$ cd fdmhnzw
;$ ls
;222384 dtzw
;$ cd ..
;$ cd fgz
;$ ls
;dir rzrsgst
;dir tqdghbj
;$ cd rzrsgst
;$ ls
;120970 dtzw
;dir zfhnw
;$ cd zfhnw
;$ ls
;154286 fmbzztww.hvt
;$ cd ..
;$ cd ..
;$ cd tqdghbj
;$ ls
;275314 rmblptm
;$ cd ..
;$ cd ..
;$ cd lftcr
;$ ls
;148378 cwjj.trb
;215545 zfhnw.fjl
;$ cd ..
;$ cd pjqwq
;$ ls
;dir bppdtc
;dir dnlzz
;$ cd bppdtc
;$ ls
;276258 zfhnw.rfn
;$ cd ..
;$ cd dnlzz
;$ ls
;286311 cjzm.nhs
;239107 ggdr.rgz
;dir zfhnw
;$ cd zfhnw
;$ ls
;dir rzht
;$ cd rzht
;$ ls
;100504 thj
;$ cd ..
;$ cd ..
;$ cd ..
;$ cd ..
;$ cd rpz
;$ ls
;182300 brsnhb
;dir pblmwf
;261712 rmnmsl
;dir zfhnw
;$ cd pblmwf
;$ ls
;121117 mlm.zdq
;$ cd ..
;$ cd zfhnw
;$ ls
;281353 gwbrctf
;dir hgpnj
;dir lvhwhz
;dir mlm
;dir pcfljzhm
;dir vpdbrh
;$ cd hgpnj
;$ ls
;103619 vwl.vsq
;$ cd ..
;$ cd lvhwhz
;$ ls
;236328 bqpwdh.qtn
;dir gjwth
;118100 jfcmcq
;dir lwsdfhg
;51327 mjm.dhc
;41403 mlm
;dir vpdbrh
;313830 zmwhlcsw
;$ cd gjwth
;$ ls
;dir bqpwdh
;128093 css
;290123 pjqwq.djg
;89091 whdwbssf.tss
;$ cd bqpwdh
;$ ls
;186274 rmnmsl
;$ cd ..
;$ cd ..
;$ cd lwsdfhg
;$ ls
;218938 mjm.dhc
;$ cd ..
;$ cd vpdbrh
;$ ls
;139398 lrrjnvr
;$ cd ..
;$ cd ..
;$ cd mlm
;$ ls
;278462 fdlb.jsr
;176936 tvnrl
;29208 vwl.vsq
;$ cd ..
;$ cd pcfljzhm
;$ ls
;295983 nnvq.lcg
;$ cd ..
;$ cd vpdbrh
;$ ls
;16998 lswwmjc.vmv
;52872 pmbzp.mmg
;$ cd ..
;$ cd ..
;$ cd ..
;$ cd vpcq
;$ ls
;dir tnrpllzj
;$ cd tnrpllzj
;$ ls
;226232 nqrjs.qds
;$ cd ..
;$ cd ..
;$ cd zfhnw
;$ ls
;188324 dtzw
;263511 lnwwh
;217287 lst.wvw
;178366 vzctflm
;$ cd ..
;$ cd ..
;$ cd wlqhpwqv
;$ ls
;dir bqpwdh
;dir ffw
;dir lpzgcrd
;dir lszdbd
;51178 mlm
;dir ntcpvg
;dir pjqwq
;dir pmpftw
;dir ppf
;dir vpdbrh
;dir zfhnw
;$ cd bqpwdh
;$ ls
;194389 dnqngfzh
;$ cd ..
;$ cd ffw
;$ ls
;dir mfqd
;dir npgnwwf
;dir tcvt
;$ cd mfqd
;$ ls
;214846 vwl.vsq
;$ cd ..
;$ cd npgnwwf
;$ ls
;dir ddqsmtsj
;dir gcq
;dir ldtpnr
;1802 vwl.vsq
;$ cd ddqsmtsj
;$ ls
;309790 rmnmsl
;$ cd ..
;$ cd gcq
;$ ls
;80203 lvqhwzfn
;$ cd ..
;$ cd ldtpnr
;$ ls
;dir spzj
;123522 tvnrl
;$ cd spzj
;$ ls
;139171 bpgpdzt.zzp
;$ cd ..
;$ cd ..
;$ cd ..
;$ cd tcvt
;$ ls
;dir jcvcjz
;dir qmtcr
;dir vpdbrh
;$ cd jcvcjz
;$ ls
;274564 hsv.wsr
;309010 vpdbrh
;$ cd ..
;$ cd qmtcr
;$ ls
;dir mfjd
;dir pmbdsb
;$ cd mfjd
;$ ls
;202111 vpdbrh
;$ cd ..
;$ cd pmbdsb
;$ ls
;dir brghd
;313440 chwzrz.bmf
;$ cd brghd
;$ ls
;216516 dtzw
;$ cd ..
;$ cd ..
;$ cd ..
;$ cd vpdbrh
;$ ls
;134552 sbs.bsn
;$ cd ..
;$ cd ..
;$ cd ..
;$ cd lpzgcrd
;$ ls
;244257 bqpwdh.hsz
;118275 flgfbstp.flp
;dir gcwg
;dir mlm
;dir nfj
;189443 rtwwbgfs.nvl
;dir trbwtdb
;dir vpdbrh
;dir ztwbpvbq
;$ cd gcwg
;$ ls
;dir bqpwdh
;304960 dtzw
;9496 pfpwtsp
;dir pjqwq
;dir vpdbrh
;dir vqp
;186883 vwl.vsq
;$ cd bqpwdh
;$ ls
;79064 fbjdqsn.cgp
;$ cd ..
;$ cd pjqwq
;$ ls
;106371 cplcj
;204740 mhdq.lhc
;313462 pjqwq.lsn
;249876 rmnmsl
;209574 vwl.vsq
;$ cd ..
;$ cd vpdbrh
;$ ls
;166549 mjm.dhc
;270734 rmnmsl
;$ cd ..
;$ cd vqp
;$ ls
;dir nbq
;dir nts
;dir rlbhdgm
;dir srvqpq
;dir zfhnw
;$ cd nbq
;$ ls
;63369 mjm.dhc
;314393 smd
;70181 tbwpwtt.ccj
;97954 vpdbrh.fmw
;$ cd ..
;$ cd nts
;$ ls
;11300 zfhnw.pnj
;$ cd ..
;$ cd rlbhdgm
;$ ls
;dir bzd
;dir hfhzj
;65400 mbrqjnp.wqz
;dir pztwz
;$ cd bzd
;$ ls
;dir bqpwdh
;168832 cdlg.zhp
;dir dtb
;22418 fttt.twt
;dir gmlgvnq
;101839 hnpjbjsc.whd
;dir pdmqn
;122491 smvjvw
;dir wmtdbrqm
;52142 zfhnw.gmt
;$ cd bqpwdh
;$ ls
;dir btb
;37220 gzj.mhf
;dir lwl
;112215 qcfqd.fwz
;210303 qlwgqnsp
;dir trpm
;$ cd btb
;$ ls
;dir rqftrtb
;dir vsb
;$ cd rqftrtb
;$ ls
;dir ndwphjw
;dir pjqwq
;dir zfhnw
;$ cd ndwphjw
;$ ls
;256159 lpprpwjq.srz
;$ cd ..
;$ cd pjqwq
;$ ls
;dir fpb
;$ cd fpb
;$ ls
;42692 pjqwq
;$ cd ..
;$ cd ..
;$ cd zfhnw
;$ ls
;dir bqpwdh
;$ cd bqpwdh
;$ ls
;17467 mshfwzv.ppr
;$ cd ..
;$ cd ..
;$ cd ..
;$ cd vsb
;$ ls
;278554 rmnmsl
;$ cd ..
;$ cd ..
;$ cd lwl
;$ ls
;28409 mjm.dhc
;$ cd ..
;$ cd trpm
;$ ls
;dir mlm
;$ cd mlm
;$ ls
;304742 dtzw
;108223 mjm.dhc
;dir mvh
;52532 nzc.vhj
;dir tdhrrhm
;$ cd mvh
;$ ls
;99770 cgfw.pgm
;$ cd ..
;$ cd tdhrrhm
;$ ls
;326653 lrmsnt.fdh
;157903 mlm
;$ cd ..
;$ cd ..
;$ cd ..
;$ cd ..
;$ cd dtb
;$ ls
;179072 vpdbrh
;3435 vpdbrh.hpv
;$ cd ..
;$ cd gmlgvnq
;$ ls
;dir rrjgswsd
;$ cd rrjgswsd
;$ ls
;dir zfhnw
;$ cd zfhnw
;$ ls
;278562 mvqbv
;$ cd ..
;$ cd ..
;$ cd ..
;$ cd pdmqn
;$ ls
;233744 pjqwq
;$ cd ..
;$ cd wmtdbrqm
;$ ls
;dir lngc
;dir wgpwcj
;225374 wphwht.nvn
;$ cd lngc
;$ ls
;4415 zfhnw
;$ cd ..
;$ cd wgpwcj
;$ ls
;165889 bqpwdh.ngg
;331254 dlpr
;97910 mzjlswr.spn
;dir rqhshd
;49222 vwl.vsq
;$ cd rqhshd
;$ ls
;145902 qwhr
;$ cd ..
;$ cd ..
;$ cd ..
;$ cd ..
;$ cd hfhzj
;$ ls
;92623 ldlpnvw
;146918 mjm.dhc
;$ cd ..
;$ cd pztwz
;$ ls
;dir jllmcfjf
;$ cd jllmcfjf
;$ ls
;245363 dtzw
;81345 mbh.vdq
;164199 ntwzgfr
;14466 rmnmsl
;$ cd ..
;$ cd ..
;$ cd ..
;$ cd srvqpq
;$ ls
;271019 zfhnw.rlc
;$ cd ..
;$ cd zfhnw
;$ ls
;104520 bqpwdh.qqv
;12312 lspg
;$ cd ..
;$ cd ..
;$ cd ..
;$ cd mlm
;$ ls
;259906 cbgmp
;dir rjshqvb
;$ cd rjshqvb
;$ ls
;309983 mlm.qmm
;$ cd ..
;$ cd ..
;$ cd nfj
;$ ls
;44759 mlm
;228634 njrrs.sjj
;dir rfmw
;$ cd rfmw
;$ ls
;273185 bcbjq.vlw
;$ cd ..
;$ cd ..
;$ cd trbwtdb
;$ ls
;307053 mjm.dhc
;301028 zzg
;$ cd ..
;$ cd vpdbrh
;$ ls
;dir bzdp
;169466 grnvt.mst
;dir pjqwq
;123590 vwl.vsq
;$ cd bzdp
;$ ls
;225941 trrzqz
;241249 vpdbrh.lsj
;$ cd ..
;$ cd pjqwq
;$ ls
;dir ddfpql
;dir fgbqzm
;329174 mjm.dhc
;6701 mlm.ffp
;dir phf
;$ cd ddfpql
;$ ls
;103799 lpbp.bpt
;$ cd ..
;$ cd fgbqzm
;$ ls
;dir spsz
;$ cd spsz
;$ ls
;34049 mfgph
;$ cd ..
;$ cd ..
;$ cd phf
;$ ls
;84883 qdj.hbt
;$ cd ..
;$ cd ..
;$ cd ..
;$ cd ztwbpvbq
;$ ls
;138429 bqpwdh.mlr
;151403 cqmbgfdh.gvh
;9087 ngm
;335933 sswtt
;318963 tvnrl
;dir wdhjpzp
;$ cd wdhjpzp
;$ ls
;119932 pjqwq
;$ cd ..
;$ cd ..
;$ cd ..
;$ cd lszdbd
;$ ls
;dir cpqpvbz
;dir hnl
;dir llprt
;$ cd cpqpvbz
;$ ls
;dir ltlcz
;dir wmpsvm
;$ cd ltlcz
;$ ls
;262150 zfhnw.zsg
;$ cd ..
;$ cd wmpsvm
;$ ls
;dir bqpwdh
;$ cd bqpwdh
;$ ls
;51488 pvhcb.qmw
;44038 zfhnw
;$ cd ..
;$ cd ..
;$ cd ..
;$ cd hnl
;$ ls
;dir pjqwq
;$ cd pjqwq
;$ ls
;170454 mhg.ddj
;$ cd ..
;$ cd ..
;$ cd llprt
;$ ls
;268114 bmvwwbdt.cqm
;207425 dtzw
;180660 mgqz
;297846 qbpcd
;112867 zdb
;$ cd ..
;$ cd ..
;$ cd ntcpvg
;$ ls
;74161 bqpwdh.gbr
;257792 vwl.vsq
;$ cd ..
;$ cd pjqwq
;$ ls
;279738 hwdgzvj
;dir jsdbnwrc
;dir pcjfjsgs
;11113 rqrtcq
;208212 tvnrl
;dir vllzsh
;$ cd jsdbnwrc
;$ ls
;11720 fvj
;$ cd ..
;$ cd pcjfjsgs
;$ ls
;dir bqpwdh
;195046 mjm.dhc
;dir ssq
;dir vpdbrh
;$ cd bqpwdh
;$ ls
;42769 dlrvsj
;159280 zfhnw
;239759 zqqcb
;$ cd ..
;$ cd ssq
;$ ls
;67639 bqpwdh.csb
;$ cd ..
;$ cd vpdbrh
;$ ls
;dir bqdpwrst
;dir qtj
;$ cd bqdpwrst
;$ ls
;57800 fndpnj.fgt
;132712 vpdbrh
;$ cd ..
;$ cd qtj
;$ ls
;dir szjtvcb
;$ cd szjtvcb
;$ ls
;93993 mgmqtdb.fzd
;dir stbczmlq
;$ cd stbczmlq
;$ ls
;dir nhq
;$ cd nhq
;$ ls
;27749 hqgngdt.tmq
;$ cd ..
;$ cd ..
;$ cd ..
;$ cd ..
;$ cd ..
;$ cd ..
;$ cd vllzsh
;$ ls
;dir nlwwrz
;237293 wlgbt
;dir zhmwl
;$ cd nlwwrz
;$ ls
;99990 bjv.szl
;$ cd ..
;$ cd zhmwl
;$ ls
;dir hbpps
;dir hfv
;$ cd hbpps
;$ ls
;7520 mlm.ltq
;$ cd ..
;$ cd hfv
;$ ls
;dir qpfrd
;$ cd qpfrd
;$ ls
;dir mlm
;$ cd mlm
;$ ls
;288919 qmtpwqn
;$ cd ..
;$ cd ..
;$ cd ..
;$ cd ..
;$ cd ..
;$ cd ..
;$ cd pmpftw
;$ ls
;118859 mlm
;103896 pjqwq
;128800 tvnrl
;$ cd ..
;$ cd ppf
;$ ls
;dir drszpqf
;dir fbs
;202594 gdpw.bds
;dir ldnrpg
;176398 mbbmmf.plr
;dir tfjnj
;$ cd drszpqf
;$ ls
;dir pjqwq
;dir qtblb
;191392 tvnrl
;$ cd pjqwq
;$ ls
;dir lrrlbgwh
;dir nfcc
;dir pqm
;$ cd lrrlbgwh
;$ ls
;182434 mjm.dhc
;238706 vpdbrh.lgz
;$ cd ..
;$ cd nfcc
;$ ls
;253846 vpdbrh
;268229 vwl.vsq
;$ cd ..
;$ cd pqm
;$ ls
;56573 vwl.vsq
;$ cd ..
;$ cd ..
;$ cd qtblb
;$ ls
;28941 zcm.dtw
;52282 zmhw.lhm
;$ cd ..
;$ cd ..
;$ cd fbs
;$ ls
;dir gpttw
;$ cd gpttw
;$ ls
;dir bqpwdh
;$ cd bqpwdh
;$ ls
;98780 wvzhlfht.rdd
;$ cd ..
;$ cd ..
;$ cd ..
;$ cd ldnrpg
;$ ls
;205523 bqpwdh.qlb
;54924 pcq.clf
;$ cd ..
;$ cd tfjnj
;$ ls
;237752 bqpwdh.bvf
;dir lwl
;295520 mjm.dhc
;dir qsgpsmzw
;278576 rmnmsl
;dir vljqlw
;225025 vwl.vsq
;100780 zgjhtrv
;$ cd lwl
;$ ls
;150713 dhrl
;$ cd ..
;$ cd qsgpsmzw
;$ ls
;265288 bqpwdh
;92636 ntgrlr
;182224 wdb
;$ cd ..
;$ cd vljqlw
;$ ls
;dir pcnd
;dir pjqwq
;317809 tvnrl
;$ cd pcnd
;$ ls
;8283 gmq
;195909 rmnmsl
;183891 tvnrl
;182837 vwl.vsq
;$ cd ..
;$ cd pjqwq
;$ ls
;dir vwp
;$ cd vwp
;$ ls
;dir crpztfmf
;dir fhrfrbqg
;$ cd crpztfmf
;$ ls
;257441 dpztgnd
;$ cd ..
;$ cd fhrfrbqg
;$ ls
;64573 mjm.dhc
;$ cd ..
;$ cd ..
;$ cd ..
;$ cd ..
;$ cd ..
;$ cd ..
;$ cd vpdbrh
;$ ls
;80449 mjm.dhc
;266777 qfjwb
;dir qzmz
;100029 tvnrl
;28910 zqnp
;$ cd qzmz
;$ ls
;9583 wsfwpznj
;$ cd ..
;$ cd ..
;$ cd zfhnw
;$ ls
;dir pmdsb
;106595 vwl.vsq
;dir zdv
;$ cd pmdsb
;$ ls
;dir bqpwdh
;dir pjqwq
;$ cd bqpwdh
;$ ls
;dir tstqlh
;143862 vpdbrh.thr
;$ cd tstqlh
;$ ls
;119310 tcmglrz.hzp
;$ cd ..
;$ cd ..
;$ cd pjqwq
;$ ls
;56885 rmnmsl
;$ cd ..
;$ cd ..
;$ cd zdv
;$ ls
;209148 nhcdqmd.hgh
;dir pjdhn
;119411 pjqwq.vrq
;154423 rmnmsl
;178813 vhbjqhhq.tbf
;$ cd pjdhn
;$ ls
;dir gnthzp
;116732 qhrz.ssb
;dir rvbw
;117225 svmpwv
;$ cd gnthzp
;$ ls
;dir bqpwdh
;$ cd bqpwdh
;$ ls
;312253 rmnmsl
;$ cd ..
;$ cd ..
;$ cd rvbw
;$ ls
;dir cjdhwbv
;268173 lsmmthf
;99445 vwl.vsq
;$ cd cjdhwbv
;$ ls
;302711 tbhb
;173182 tmj.frb
