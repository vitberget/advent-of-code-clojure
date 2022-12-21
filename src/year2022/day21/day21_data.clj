(ns year2022.day21.day21-data)

(def day21-example "root: pppw + sjmn\ndbpl: 5\ncczh: sllz + lgvd\nzczc: 2\nptdq: humn - dvpt\ndvpt: 3\nlfqf: 4\nhumn: 5\nljgn: 2\nsjmn: drzm * dbpl\nsllz: 4\npppw: cczh / lfqf\nlgvd: ljgn * ptdq\ndrzm: hmdt - zczc\nhmdt: 32")
;root: pppw + sjmn
;dbpl: 5
;cczh: sllz + lgvd
;zczc: 2
;ptdq: humn - dvpt
;dvpt: 3
;lfqf: 4
;humn: 5
;ljgn: 2
;sjmn: drzm * dbpl
;sllz: 4
;pppw: cczh / lfqf
;lgvd: ljgn * ptdq
;drzm: hmdt - zczc
;hmdt: 32

(def day21-puzzle "sbdn: bctf + msbv\nnfdd: jnlb * bbjn\nsbmt: zzcd * vpbd\ndvpb: 12\nhrqh: 20\nqdsq: 19\ndmhs: qjst / psrt\nmwbf: 2\nfhmh: 4\nfnnt: 5\nctmw: 9\nshtl: rhmb * gmhp\nqrnh: gwnm * ssml\ngcnm: tjjh / wwwr\nnncw: wbzd * sfcw\nqgfs: dzbv + wdrc\nqpff: 3\nwggh: 7\ncdsl: qvnp / wlsd\nwpnr: 4\nmqqt: 6\ndnlg: njzj * cjsv\nwvwh: tjzt + hwqg\nzmrd: 9\ntqfd: 2\njzzg: mrdl * gcqg\nnmdj: hsht + bttm\nhfhj: 18\nqqqf: mngf + nshb\nvtvm: wzjs + qdvf\nblsj: 3\njnfz: 1\nsfgz: nwjm - qbmd\nmlbw: 2\njnjb: 14\nrnbh: fhdc / mnzr\nzwrp: zhpw * ftfm\njhnt: 2\nhlmd: 9\njnbb: jcmn + gmtf\npmhz: prqw - gdhc\nwhht: 2\njgpd: 3\ntchz: 5\nmcvd: 11\nbmwn: 2\nqwst: 5\nbfjs: rgfv - hlpf\ntwwb: 2\ndpjf: mqgc * tjfg\nwbzd: 7\nslml: 3\nftvq: 3\njqcs: bqgr * fztn\nrjwc: hzwm + ffdv\njvqm: 3\njnhr: zbnf * hnpq\nbmzm: 5\nqljm: zjnn * stcb\nfsvt: 2\nmttn: gzgb + jgfs\ngswz: qvqg * dbvp\nnwwj: 2\nfhfs: tdwr + qrnh\nwcfq: 6\ngfgv: qmtj + gchq\nvsgm: jwdd * rfrd\nhzwm: 2\nsrqm: thrf * rddb\ncftz: swvg + sshh\nvvtp: 2\nstsg: ztwz * spvr\ngjvw: wjtv * brvp\nblmg: 3\ndclj: 17\ncqlb: slmz + bdmh\nmjhq: nqnq * sjdh\nhfqb: 4\ndnzv: 6\nrfjn: 2\nbcfm: gfrl * nmdp\nbzwm: 4\nrdtl: hfhc * ljlg\nnzwz: chgr - cmdw\nqbpq: lnns + sgzf\nlbnm: sqbw - mpfn\nzpmf: 2\nqmvs: 2\ntrpv: hcbg - wzqv\nzhnp: mfqm + svgg\nbrvp: 7\nlhds: frvr + gpdw\nmnrp: 2\ndmmg: 2\nbvjv: sgrn + dtmf\nppsj: 10\nrlfj: nmwn * pgrc\njtvr: 9\nwdlh: 6\nhzhr: 2\nmbvt: gdwj + mvff\nsjcg: wcjj * pshs\nlnbw: dtdg * bzcg\nrbtz: msmb * nswp\ndjtg: lrww * rldc\nrpjv: cnhs * wqmt\nlwrl: 2\ncvdf: 13\njztf: 2\nfmnq: wqqp + znnj\nvhtm: lvln / nfms\ngmrl: mwdm * dtvd\nqgzz: 9\ndprf: hglc + fctd\nmsqd: 6\nchvq: 2\nztgn: 4\ngppd: 2\ngwrw: lnrh + jcfr\nrjft: 4\nrvdg: 2\nzhqp: 7\ntrjl: 5\nsnlj: 6\ntvdp: svps + bdmp\ncdqj: gspr * lpbn\nzrjs: 3\ngrcg: 13\nzcnf: 2\nbqtw: qwjg + mmrq\nvpjc: svcq + htng\nwjqc: 2\nfwsg: 3\nvrqz: sjmc * lzzg\npdhv: 4\nmqgc: jtjf + wqvr\ngfrv: qbwn * plrq\nfrsq: 19\ntzps: 2\nbzft: 11\nglwr: jdfh + gbvs\ntrwg: ggsv * vcvg\nnqzw: zwdg * qsdt\ndhdh: qqlz * frhf\nsfpj: hjlh * jbfl\nldmr: 2\ndplv: 5\nfdsp: 12\nzjlj: 3\nstcb: 3\nzqlm: 6\njltr: tqvq + wplp\nsqng: mrpf + vnth\npgtz: vzgp * mlsg\nwlsd: 2\ncrzv: wfct + jjdf\nfcqm: zccs * tdmg\nrlrr: glwr * gqwc\nnmwn: 13\nbzlp: ctnc * gzdt\ntfgq: 5\nmrlt: sbjm + pmnd\nvpbt: glss + mrqs\ncqfp: csrh + sjpf\ncmbl: 14\ndtll: zbcg / mpsb\nmrrc: nncw / sppr\njwlz: sdmd + pphp\nbbzz: 2\nmnjh: gbdp + wjmt\nswhv: pnsc * zpwv\nzffq: 2\nbpbq: 10\nrbpb: 2\nsdhg: zwfb * ccnc\nqlds: 3\nzlbn: svdf * ffpf\nqbmd: 2\njlnp: 3\nhffq: hrbc * lhdt\nnbsj: hpnj + zqlm\nbzjm: 5\nzbcq: tqcc * mwgs\nvhfw: 2\nmltq: 5\nhfrg: 4\nfgjs: zbdm * dgpc\nnshb: ndnl * tvvb\ngrvb: qwqc * jcrs\nwtdw: gldv + nhnf\nvvgf: chct + mszt\ncjmd: qncq + ddpb\nnhjn: sjcg / zpmf\ntdng: nzcm + vhfw\nzsrg: 2\nhbbc: 7\nmqhg: 5\nmwdm: dqfd + sntl\ncqgs: rvhg + mzvg\nhqhd: hhwb / cdrs\ngsfj: jnqq * tchz\npvlz: 5\nbnlh: 4\nhnbh: 9\nnfds: ddst + nlqn\nrdqq: phnj - vfbg\nmpfb: fqvv * jdch\nbhtv: bghm * vfzj\nmnlg: bcvt - hvfz\nhbsz: 1\nngmf: plfm * lpff\npprz: 13\nqbmm: 3\ntzmw: 2\nzcmc: 13\nrlrh: mmhs * zzbb\nfzpc: zshb * vvtq\nzqgr: 19\nwbjp: 4\nlcgw: cmjc * csgl\nnvvg: tjnj * gddz\nzqvn: htdp + zgcp\ndlfp: dtdq * npql\nndrd: dszg + wvwh\nsjpf: 1\ntqhn: pddt + fbhs\nwlwd: 2\npngv: qmqd * qsdf\nbzcm: zbdl * rzrr\nzmtv: 14\njgjj: rsdn + gfwv\nqgrs: vrqz * zsrg\nfnvb: 4\nzbcg: tzmf * wrrn\nfqmp: 2\nwzqf: 11\ngntq: gqbs * blbl\ntcfb: 5\nbtpd: gmrl - dbbq\nnmmj: gpzb * sfvr\nthwn: 2\ncplt: 2\ntwmh: znmm * cnzr\nsvzw: 1\nfqwr: 2\ncttl: bsnm + mqzt\nfdzp: 4\nqwwp: dzpr * bbzz\nspng: 2\nqmtj: bgfc * rtql\nlcrd: vtjb * mzvl\nlshc: jbtz * gctq\nzvdn: 3\nzhwb: fgvs - rjsp\nfvdd: nsqr - dqfq\ngplw: vdsw + mgcb\nwmlq: hrqr / zqpz\ndtdg: 4\nlnns: wdmv * gvqg\nmrsb: nnfh * qglg\nrjnt: 2\nfvgd: gbbc * zmsv\nvfbg: qnmp * hltz\nqjtm: 2\nzqhf: 5\nrddb: swqs * jljs\nzhss: 2\nvpbd: 4\nfflt: qbls / zwmh\nbsbl: dzvl + jbfv\nwqsb: pstv - fjtw\ndrrz: 2\nmssq: 4\nhhmn: 3\ntprf: znvf * zrlz\nbrrw: fwbm + qfpf\ntdmg: 2\nbwhn: 9\nnvzr: ffjs * pzmg\nssml: zmsj * svzh\nvzgp: ltwt + qjrv\nltnm: wcmp * svpd\nhrqr: rbzv * ndbg\nrfmv: 3\ndnsn: 2\nhptl: trsd + rgjz\ncnhs: pnqg * npjd\nfwpt: 2\ngjlm: 5\nttlm: 13\nvwgb: zqcs + pcwp\nvlpt: 5\nncds: 3\nwjdr: 3\ncsnr: 10\nffcj: 4\njllj: whlp * frnc\nzgfm: 3\ntnft: tqjf * sbhf\npbwb: 9\nbrqf: 4\nnjsm: gbdt + npsz\nqphz: hfdb * fzcc\nqcrr: 2\nfjvr: jffs + qjfh\nrpzr: 7\nlzdn: nmdq + lscd\nzcbq: fvgq + wgct\nsblg: 3\nbfgb: 9\nddpb: wlwd * lzvs\nvmnr: zstq * cfvn\njbfv: 3\npgrc: 17\ntzrr: 3\nsqph: vmbv + lmdd\nrgdb: trvj * rsgv\nrvmz: 7\njvgp: bmrf * nnvc\nvpdp: rpnq * jsfn\ntqgj: 3\nffbm: 2\nvnth: pmps * qghj\nnprf: 2\ndbwf: 2\nfcsw: 18\nmqql: 2\ntdmf: 7\nfhdc: jqph + czwd\nftpp: 2\nwzmg: qtnf * rwzb\ncswj: zdvw * gzsc\npnqf: 5\nhfnq: mhdd * fgvz\npdtw: 2\nswwr: 2\nfbmd: 3\ndbfn: 3\npnfh: 3\nfjbv: brhv + zshw\nwqbq: 3\nwngj: gsfj + rchc\njcdh: hsnd + tfmf\nqvtf: hgll + tvvv\nrjwf: bpnp * hdfn\nncfl: 19\nczwd: lbvt * wwnr\nbwns: wtjn * bplf\nzmwz: glnl + twmh\ndbqd: wddg / fbwr\njdfb: qdsq * cqsd\ndqcj: 2\nvlzz: lrgr * vbzl\npwft: rhnq * wcmw\npfgl: dpjf / qrcq\nwjms: 9\nwqrw: ngsh * zhnd\nmjwr: 5\ngshv: zfdl + pdbd\njgfs: zfgq * qsng\nrgnh: 5\nqqpp: smnq + mhvv\nplfm: 7\nzdwj: 2\nzqrh: 11\nthrf: qshf * dqjg\nnpnp: 3\njtfn: 17\nhjwg: 11\njlwt: 2\nzvpd: ltzz / mlbw\ndmcm: wzht + bgnr\nnlqn: lzdn * zgvg\nhgpm: vhvf * mppq\ncwwb: jfhl * gljq\nfhdz: 4\nnpsz: 10\npnqn: fbvn * gscc\ndrmg: 13\nctnc: 17\ncmdw: pllt * fhtf\nscqm: nbvw * zmcq\nrtbf: 5\nfgvs: lngz * mcjf\njqph: qnwt - bvqq\nsfzm: 4\nlrgr: 11\nqqrz: 3\ngpmm: jmhb * nfzg\ngscc: 5\nwqqp: rvhn * zjlj\npddt: 3\npsfp: 1\njdjn: rhpf + dbpv\nwjlc: 3\npdtr: rwqn + mjss\npmrr: fpgp / wqsb\nnpcq: 2\nhsds: 5\nvgws: 5\nqnbt: 4\nzjsm: 4\nzgws: 15\ndjmp: 18\nqdqj: 2\ngvbg: 4\njlpt: lqmq * bqvz\nmbhm: hzpb * mshr\nrcvc: 5\nfzcc: zqhf + pnvr\ntfsh: 20\nlwld: wtvs * vjgg\nscdj: 7\nspgv: tcdr + tfsb\nsmlg: jmbd * fgzz\npqpq: cfgt + mbvt\nllhz: vnjd * zcdd\npgcf: 4\ndfnb: 5\nqtsb: rlrh * qzjn\nhpwf: wzwt + bzqs\njrbz: njzz + sqhb\njngh: 6\njmhb: 5\ndhbc: qpqs + bbjs\npvww: 2\ngttq: 2\nphjs: bnfj + mqbr\nbrhl: fmdh * wnnc\nprqz: ptjp * nnfc\nhhfw: frvn * mrlt\nzlfh: 3\nmmps: 3\nmlgn: 2\npbwr: 7\ndzbv: lvnr * sdgt\ntttc: 4\nbszz: 2\nlppw: cjbq + fjpl\ndjcj: bdpp / tztt\ndtdq: 3\nfwwp: fhnv + fdsp\nmpnt: zppf + bjvs\nqnfz: 4\njmdp: 2\nsdlg: lmqq + fbvb\nqbhz: lqds + qdcn\nhmnn: 9\nwfbn: cvdf * pcdr\ntlqj: tdnj + zmfh\nvfzj: 7\nndnl: 2\nhqzz: bqdh + wbjp\njjld: wppj + fmzc\nndzz: 5\nlzdg: hjlw * bmgv\nnbrp: 2\nvjcw: gsbc + jfnh\ndsvn: 3\ngtzb: 2\nphhr: 3\npslv: szqs * wzvt\ndrvg: mvgh * pgqv\nvghb: 4\nvjrs: sldb + zntp\nfqhb: sqzs + fvcn\ncqjz: slwd + zzfb\ntnhh: zpzt * qzcz\npnbp: mmlj * fgjs\nttfs: mlfn + mvpv\nrzsm: 5\ntzmd: 7\nljmv: drbt * ntrq\nstvb: 2\ndtmf: mgqb * dqbg\ncnbc: 4\ngppt: schn + tcjp\nqdgr: 3\nfhhp: ccwf + pdtg\nfbhs: 19\ncbsl: 3\nsnct: 4\nvnjd: 3\nwstl: 3\nqsdt: gpgl + wlpz\ngljq: 2\nnlmg: bssw + hjzl\npjhh: 5\nshzw: ljmv / rtsv\ncvjr: 2\nwzjs: 3\nmmlj: 9\nhsvq: 2\ngqwc: czst * rstl\njljs: 3\nnpmn: zgws * nmfv\ndvwb: dfgb + bvjv\nwplp: tgtq * wqmw\nzntp: plcs * frsq\nzshb: tnwb + bsfq\nllmb: 3\ndjtf: qfwg + zdth\ntnjp: 4\nwzrw: tgwb * jzwj\ndgbf: mccf / fsft\nnbzq: 7\nqtjm: 2\ngzmb: 6\ntjvn: rcvc + sszv\nbsmz: 4\nvzmm: 5\nznnj: 5\nbrfb: dtzn * rcml\nbdpq: vrlt * bszz\nrfth: 3\nprqw: nlwm * zzqt\nfdfj: nvcj / mmps\njsfn: 5\nhcpl: tjtw * nrsf\nzqjc: lwls + mlzt\ncsrl: 2\nstnw: 11\ncprm: sjtc * zlcl\nhndt: wzmg * cqpl\nsrfr: 1\nzdvw: 5\nwqvr: pgmr * mllz\ndpns: mghl * mptl\nhrbc: lzqd + wzqf\nwwfq: 5\nhmcs: wzll + pctz\nwbzc: 4\nfjpl: 4\ncmcl: djvw / cfbm\nfzhr: 4\nsssj: 8\nzvmr: nrfs + vfsb\nrwtm: 4\nrbtv: 2\nmgsm: 2\nfqnr: qzqz * ncvs\nndbg: zdfz * hwqc\ngsln: 3\nrgdz: trmh * clhn\nglqw: pvlz * pnpv\ntzph: bdbp * hjsj\nplcl: tzrh / cpbm\ngpgh: 4\ndbrg: 3\nzrbb: cggm + tffw\njfqp: 4\nhtfp: vchh * ffmj\nggmn: nbsf * svbw\nvfqz: 7\nbdpp: dlfr + qtrc\nrwdw: ncfl * wjvz\nzfdl: zvpd * rfrp\nhcrr: 3\nhhdp: 3\nchnw: 4\njqhz: mqqt * hcgj\nmvzs: prcg - bbzc\nmngw: pfgl * nppq\nvrqn: fbqw * tncw\nwzqv: gcpl + lppw\nnmdc: 7\nbrsj: 3\nmmrq: jqtb / rssc\nqfcf: pnqn * fqwr\nnfbf: qchr + tlwf\ntbph: frmw + vgws\nqbld: 3\ngptr: cdvh * qbmm\ndqlt: 17\ngldv: 4\nrrhp: jhmc + sqnb\npbrh: qlpf + mrqp\nvsnl: svjl / qqrz\nmhdd: 3\nbjtt: chwq + tclj\nhsdn: hhhj / nszz\nlzzg: 2\nvqmb: 5\nghtc: 7\nvnzp: lbql + fnnq\nmngf: 2\nqbpp: ztnb * hpjc\nfmzv: 3\nvjgg: 3\npnsc: ccwj + fqhb\nhltq: wjwt + lcrp\nbtms: 3\nnvfs: dvwb * hbdc\nztlh: jpbg + fhfs\nsvzh: 2\npnvr: znbv * nsgq\nsfvr: brfb * mdcj\nqfwv: rrcr * vznb\nwwnz: njsm - zhss\nlfcg: grcg * rbsl\nqtds: shtl + hcml\nzstq: 4\ndjvm: hmgb * jntd\nzdjz: jghp + nvrs\nmggw: rbpb * gqcp\nbwjd: 18\nlcdw: brtp * jmdp\nshlg: qmhs * fqdd\nbszm: 3\nzpnz: 2\ntmwz: 3\nqvdw: 5\nsbtn: 2\nmvhq: rjwf - pbrh\njqjq: cqjz * bqtw\nnrsf: 6\nzgcp: 7\ncjsb: 5\ngmhp: 2\ndltw: ltvn * tvmn\nsdmd: lfql * grzs\nvbtj: vdtd * wzmd\ngzlc: tcht * jlnp\npllt: 3\npdcz: zlqv * fnph\nvbpd: wvjj * qmvs\nqhcm: ffbm * nwcw\nftfm: 3\nrlgc: vtzf / hfqb\npmnd: zvbv + zzfz\nnppq: 7\nnsnb: grhc + lbnm\nldjw: zpvj + llqd\nmlrh: ltzs * rbjs\nrtjv: nbzq * zvfn\ntrmh: qgsw + pmll\nhfhc: hlfm * gtrb\nfvwl: mzhl + fgjm\njjdf: ttlr / tnvf\ncrrt: 3\nlhcs: llhz - gmfq\njzcm: shpj * dzdj\nswqs: vlpt * jlrw\ngrwv: 2\njlrw: 5\nrwzb: 7\nzqcz: cjzz + rbqm\nzgzs: qsmn * jwdw\nzzcd: 2\nrjsj: fgqs + qtwf\npsbr: wsbl / hzhr\nhfth: mznc * jjld\nnqlz: srdv + hlsh\nwght: 17\nvnbv: 3\ntzbv: mrzv + pzzg\nbmlc: wjdr + hpqf\nqdcm: 3\ntfcj: lqsz * tlqj\nbvlt: gvth + hfvv\ngbdt: 3\nglnl: tzrr * bpnl\npzzg: 14\ngvzz: 6\nftqg: 5\nlvss: 2\njpms: 2\ndtwg: mcvl + nftw\nsqvr: nvjc / vqjr\nrbsl: 3\nfblg: 19\ntvpt: vbdt + lszc\nddfn: 15\nztnb: 5\nrhwr: lwlm + mmth\nlthm: 4\njhrc: pjdw + qphq\ndlbd: fwnq - jrcp\ndmrq: 4\nhhhj: 14\nzphb: rtbf * ssjb\nvvzh: jwch + qbpp\nfhth: lthm + tqgj\nfpgp: zzcc * rlds\nprcb: 2\ntmfq: rjqn / rjjg\nzbnf: cvzr + rlfj\nlgjz: 5\nflbd: tsgp * bzfh\ndrsf: 11\ntdnj: blfb * hhfw\ndsww: 8\nsfnr: cmrl * mnrp\nrgvs: 8\nvdsw: 8\ngzdt: 3\nhndr: 2\nsmnq: fmnq * thwn\ncltt: 2\nbccb: 10\nbjcz: hbnt + hclw\nsrbb: 17\nhqdw: 3\nntmq: mblh / mrbp\nfbcr: 6\nbjcj: 2\npzst: rzsm * fqsh\nqnhl: pvth + vmzc\nfbgm: lnld + mszv\nsqhb: snct * mldp\njcdn: 3\nqncq: 5\npcdr: 3\nhdbd: 3\nsrsm: 9\nmmdc: 3\npzfg: mzlc * dwtg\npchq: vsnl + bnnv\ncggm: 12\ndsnc: 2\nmghl: 5\ngtvn: vgdq + ftcm\nmrpf: jqbs * tpjh\nfplm: zpfz + mlvl\ngrrs: 2\ndzdj: 4\nztwz: nndq * chbr\nbzjw: 14\ndzjv: rbtv * tbfm\ntjfg: 2\nsdpp: hhwq / rhvj\nsbtd: 8\nbjmg: hjwg + dbwf\ndtcv: drmg * vttc\ntvnd: pjvb - cgjp\ndtfp: 5\nmgjt: 2\nsbgm: hjgv - wvzj\ndmcq: 2\nljlg: 2\nrcml: 5\njstr: 2\nlrrj: vlnv * fmcv\nmdqg: jrpq + sdhg\nqngb: zzpp * rqqs\nhbnt: 9\nsmjl: wvgs * drrz\nnszz: 2\nrfrd: 3\npdtn: gmcb + mqhg\nqqfr: 11\nhqpb: 7\nqcmm: 3\nqwqc: 2\nftbq: ttdn * hgwh\nvznw: mmsc + svcb\nnwjr: 13\nlrgw: 3\nmnzr: 6\nmshr: qgfs + vwgf\nrvhr: rdtl - pprz\ncsgl: 8\nmfvh: lhqm / bvwd\nfsjl: 3\ncvlc: jdzg / rgsm\nztth: flbd + pscz\nghdt: grvb * lsnw\nfqtj: 2\nvcwt: 3\nsvvq: 2\npjct: 2\nzvmv: 7\nsztg: pfjb + qgzz\nmvtz: 4\nbqvz: 2\nmjhs: 4\nghpc: 7\npsrt: 4\nwsdt: rqsz * gnnj\ngfqn: 4\ncdrs: 5\nrgcm: svvq * cfdm\nrsdn: zdns + cprm\nztjg: gjhn / tdpf\nvwmb: 2\nffjs: 2\nrvhg: 3\ngmtz: 3\nfght: 7\nlftq: jzcm / srnt\nrbfm: gplw * ddbg\nbplf: 11\nvbcg: 2\ngldh: 19\nhjjw: 2\ngnbn: 2\nqdll: dpns * gpgq\nfcmg: pjpm + rvqv\nvwvp: 4\nhpwp: wbfd * gbwn\ngchq: mdrr + ppsj\ndtcf: 2\ndrnn: gclt + tjvn\npnnj: 11\nlhgf: 3\nwdsh: vcwt + sqht\npnqg: rgbs + mlss\nntjf: 3\nhqdq: 12\nwqmt: rctz * dlcf\ngfrl: 2\nshbj: nzng + jdnr\njzpm: djlg / smpw\nqmhd: 12\ntdhl: 18\nrqsc: zhqp * mbfh\nmrqs: fjgs * bmwn\nddjm: sjjq * blsp\nljzj: hfnq + ldjw\nnjbm: 3\nbgnr: ptgf * pnnj\nwsnq: 7\nsgzh: 3\nnwsd: gjlm * ngmf\nhltz: hlss * vmqn\nplrq: qrth + bwnt\nlbql: nqjs * vrst\njcgc: 2\nfrlb: qvwd + rsdg\nrqll: 3\nhjrv: 5\npcwp: 4\nhwsh: 3\nzrrm: tjjt * znsz\nqspn: fplm * jwlz\nfmdh: 2\ngcqg: 2\nmlzt: 16\nrvqv: srbz * vdtj\ntvcj: qmmf * tvdp\nzdln: mwfv * rgdd\ntfsb: cfbj + rhjp\njtjf: ztlh + fsns\npssn: 13\ntdmn: zjvw + phwv\nwvvm: 7\nrmtw: 3\njwgm: jcdh * jbbv\nsqpm: dzdg + mvhq\nrblr: bjdp * sbfd\ntljb: 12\nnfwq: 3\nsmqh: 19\nbnfj: plcl + cbft\nvlfz: 3\nzbvh: ddlq + fdsj\njwdd: vmvt + srqm\nwrrn: 2\nslmz: 14\nmvsc: dsnc + fjbv\npwcm: 3\nbwvv: mvsc * jsrh\ngrng: 10\nmlww: 13\nqsjg: wvvm * nbrp\ngfjg: 8\nrmgw: rrrf + jgtl\npbvc: fzpc / srrm\nsfqz: lwhl + rwtm\ncmrl: 8\nvwrf: dwlm + ngff\nzrhq: 2\nncvs: 5\ntgwg: 11\nlmdd: 10\nvjzv: ztgn + bjmg\nshnr: 9\nsvdf: 3\nbbmw: 6\nwlnz: 4\nzpzt: 2\nnjng: 19\nrtqp: phzs + ptbs\nhrtn: 7\njpqg: zbcq + gzlc\nwdlv: wtqr * hccw\nvfjz: sslc + vrqn\njvmh: smjl + zqcz\nmdnd: gfgv * rhwr\nwzbm: 2\nbbqm: 2\nqfwg: lcvl * wdmn\npjdw: gqfb * wgzm\nlhfv: dbrg * mrlr\njqlf: 11\ngglz: 17\nqbls: nflw * jbnz\nzlqq: 3\nngll: vbqd * nqwn\nzmsv: gswz + qppd\nwjvz: 2\nqfwp: 2\njzwj: 5\ntncw: czmz + vmnr\npnpv: ppvz * drsf\nthcn: 3\ndgwv: 6\nlvln: cltt * phmh\nhqtc: nlmg + zbpn\ndwgd: 8\nmzjm: dbqd - gpls\nfjgs: llwq + qzcf\njtbm: flbl * bdpq\nmvcs: 5\ngbvs: hvhq * ndvr\ncpvm: pcvr * jwpz\nvfng: bwcs * scmr\nbzcg: fsjl * bwhn\nhttw: 11\nzbpn: jztf * rvmz\njcmc: qvfn + pmpv\ntcqr: 2\nppvz: 2\nqgqn: gwgc / mjhs\ndvbq: 4\nzmcq: fjcf - wbtq\nhzpb: qbld * vnlz\ntffw: vpbm / zbpq\nqmjw: 20\nqbwn: 3\nczmz: 5\nwjrw: 3\nnhgg: 3\nztpz: 2\nwvft: fqtj + fnnt\nhwhr: 3\njvbv: hhdp * vrzh\ntnth: 5\nqdqd: 2\nbpnl: 3\nvmlb: 17\ngmfg: 3\nzmnd: bnlh * jdgn\nddvh: nwjr + mcph\ntqdf: 14\nfdrb: vspr + flvh\nwrtr: 16\nzqcn: 2\nlbvt: 2\ntqjf: trzd + mtsj\nwcmw: sjpr + zdjz\nlbgz: 4\nzmfh: 7\nwlpz: 4\njrcp: 5\nhmpf: 2\nqqpt: 2\nrgsm: 6\nvzqj: nqlz + fbgm\nvzlw: 10\ngsjq: lrgw * ddhr\nnwcw: 5\nbghm: jrbz / wrhr\nrmms: rmgw * qvzl\nhgll: brfg - pnbp\nwmtn: 6\nnfht: 19\ndcpb: jstr * pthm\nwqbh: 4\nzrbq: 8\nnsjw: 5\ngpdw: 8\nrgph: nfnn + fhsp\nvjmm: 3\nnhjw: wbjt + dsll\nmzds: hppv * sptd\nmcrp: qsjg * jjqp\nqpjs: 2\nlbfm: tcqr + nwml\nwmfn: 2\npfsc: 2\nmpsb: 2\nbwtr: cmbl - cmqd\nspdn: 5\nhcln: 17\nggrr: 9\nrhvj: 2\njhqw: 3\nzhnd: svfc - tddv\nrznj: fwsg * rglh\nrrtp: 5\nvbfm: 7\ntnwb: njnf + fqjd\nwzll: 17\nhcbg: dhbc / bszm\nvlhv: 2\ncnmc: cvmb * ftqg\nvwvr: ddfn + bbpp\nrtql: 11\nswcd: 4\nmwqp: 8\nvwlj: hghh * qdqj\ngqmd: 1\nmgfj: gmqz * bmlc\nnnfh: pwft + cpvm\nvwgf: ffsq * bsmz\nhpqf: 9\nzzrg: bblp * jdlb\nzzqt: 2\nfqsh: 11\nccwj: qlsv + vsls\nwsph: 11\nsbfd: glpp + pcbd\nbzfh: 3\nhpjc: 10\npqlm: hwlg * ftmn\nsrgh: cfhl + dfht\nttdn: 3\nhnqw: fqtq * znnh\ntwdq: gssr / dgmh\nwdmv: cgzh * sbmt\nsrnt: 2\ncqwj: jhqw * dsvn\ngqbs: 4\njpcq: 9\ntzmf: jvzz + zqjc\nzwmv: dmrq * qcrr\nfztn: 2\nzshz: jzch * rqrz\njwdw: 4\nmdcj: 4\ntdfl: shnr * ptgb\nhlsh: vzmm * qtjm\nfvdr: 3\nbdmh: zlbn + tnhh\nhwvq: 2\nzqcs: 3\nwlbv: dnsn * pmrr\nnbsf: hcvc + jzzg\ndssl: bjcj * gmfg\nnfft: 5\npshs: 2\nnjhz: 3\nwwbj: 4\nwdfr: bhlz * mvzs\ngrrg: lfrw + hbdp\njzns: lmtg + gnvg\ndnmf: jdfb + qtgr\nsjpr: hqvt + qqzq\ncbqd: 2\nsfcw: hnbh + cmfn\nspvr: 2\ntcfd: btpd / jchs\npstv: tjjd * rmtw\nhvbd: dtfp * scsm\nzmwd: 8\nvmzc: dtcn + vhdl\ntztt: 2\nmccf: ntzd + mdnd\nngzf: 2\nvtsf: 3\ngpls: jfcp * nrrl\nzwvp: 12\nqpqs: bscl + mrgm\nthcb: 2\nsvfc: jzns + pqnz\njrtt: ccmr * gwrw\nzsdg: fshp / vvtp\ntnnl: vzrj * tggm\nbsfq: nhjn + zshz\nqchr: wjhn + qnsp\nnsjv: spvg * hqdw\nmfnf: 2\nccwf: tsjz + wjrt\ndgss: dwgd + cqlb\nnnfc: 2\ndtvb: 2\nrtvq: nvpp + lgzr\nhmgb: sbtd + pvww\nbzqs: czdz * vdnb\ngnml: vdcr * qmvc\nvlnv: tjvh + msqd\nmgqr: 2\ngfwv: sqbz * stvl\nwgtz: 7\nmpfj: 11\ntvvb: tdmn - ptbj\ntpjh: wrdf + vjrs\nhzbz: 1\nfvln: 4\nchbr: 5\nmjrr: 3\ntvmn: 2\njhfl: 8\nwzht: 4\nrgmv: crzv + pngw\npftv: mnlg - qbhz\nrtsv: 3\nnsgb: 2\nljcq: sfgz * vbfv\nqzqz: 7\nsjmc: lnpp + ftbq\nqnsp: 4\nvlmn: 4\nfjhf: qpjs * gjsb\nmbfh: 5\nmcph: 18\ngspr: hwvq + sfqz\nrvqz: cslr * ffcj\nngqn: rmtp + dtcf\npzmg: zsdg + gpvg\nvspr: 15\nprpg: qnfz * qmhn\nzzlc: 3\nzfgq: 11\nzjmm: 4\nrlvl: 2\nwtvs: 7\nrctz: 2\nlvvj: 2\nnpjd: wbln * zrjs\nwwwr: 3\npdfr: 5\nnjhb: 14\nwrsn: swhv + brrw\nvpbm: zqgr * cbsl\ngsdf: qqdp + lbrd\nbqgr: 8\nnzvs: mlrh + znth\nrnmn: 4\nwnnc: 12\ntvmq: lrfl * qlds\nnprm: fbjd + pmhw\nmvgh: 3\nshcr: vrvl * wwfq\ncfbj: 3\nhcvc: nbfv + bhhj\nvmzq: 10\nnmdq: 1\nlhll: 2\nwvjj: hndr + flbp\ngmqz: 7\nffnf: njhz * vzlw\ngzsc: tcfd - qdrr\ncwbp: 7\nqphq: hlcp + ngqj\nlwhb: hlgn * qtbw\nmvff: 8\nnhnf: gsjq - csgw\npqnc: 5\nfdfh: 4\njhlr: 13\nbcnt: thhj * ndwp\nwnbp: 2\nbbbb: hjfq - clss\nlwhl: 7\ntbfm: dzqg + mnvz\ncsrh: ftpp * nqmd\npdtg: gpjw * dmcq\nbclm: 5\ncbft: jqhz + ltrl\nltjq: rzpv * dmcm\nlngz: dnlr * dfnb\nmbhf: 2\nszfv: 4\nfmcv: 6\njzps: 4\nhjfq: dcmj + btfc\nzwth: zmnd - jfdv\nrlds: vjzr * hjjw\nbvqq: pdtn * mlww\nwshl: dzjv / gqsq\nzjtl: 4\nspvg: btms * zqrh\nmptl: 5\ndcjb: 5\nmzvg: 3\nnsgq: 2\nmjdm: ltcm * mgqr\nqrgc: 3\nmnvz: 19\nblfb: 2\ngnnj: wjfv * crtd\nsvrq: 2\nmrlr: gqmd + qljm\nfrhf: dcjb + nprf\nwdhh: 2\nqjbw: jhrc + qfzh\nsvps: lhfv * gvwd\nmcjz: 2\nnzqw: hvbl + glzp\ntmct: vhtm * hnqw\nphnj: qdll + nclb\ntdpf: sblg + tnjp\nqjlt: 2\nhclw: hqzz * jfqp\nbvnm: snvr - wmgj\ndnlr: 5\nrstl: 13\nptjp: hhmv / hdqb\nfvdl: frtq * fwpt\nnggh: 2\nbwcs: bccb * qnbt\nchgr: qpfz * jtgm\ngfqv: zgfm * bzcm\njwpz: hnzj + hmcs\nlqsz: frlg + fhth\npvth: ccph + hbfl\ntjnj: 9\nshpj: dhbz + wmrb\nfgpz: 9\nfrnc: 9\nsfhs: wjqc * bzjw\nnfms: 2\ndzvl: 10\ntsjz: 1\nsqfm: qqpp * jcgc\ndsll: 16\nlmpq: 4\nqhpl: 2\nzlnm: 4\ngvzc: bgtj + mcvd\ntlwf: qqpt * fdmz\nmfqm: rlgc + tjzj\nbpbw: 13\nszns: rmhb * mfpd\nhcgj: qjlw * qtds\nwbjj: 4\njsdj: 6\nwzwt: hndt + ptsh\ndrbt: 3\nflpt: 16\ntmzd: crnj + dqlt\nswzn: 15\nflbl: 6\nzlsd: 8\nstzw: nsrq + bdvb\nlndf: 3\nldsm: brsj * vgnj\nsshh: 10\nmwzb: 8\ngdrg: 13\nltwt: czht * vhrz\nwrhr: 2\nwnbw: dlqs + jvrp\nvzgg: jnbb + qdrj\nrwqn: 3\nfmzc: 4\nmjss: 3\ndszg: zzln + jtfn\nndvr: hdbd * qdgr\ntrsd: 5\nwjrt: 5\ngqjg: bvww * zcbq\nfgvz: 2\nvjqb: vlzz / csrl\nmddr: 1\nzzbb: fjqv - pvhf\nvhdf: smqh * qrgc\nbnvb: qwwp / ngzf\ncqpl: 2\nznts: nqcf - fcdp\ngdhc: 15\nhgpv: 3\ndjvw: nnfb + dtcv\nfrvn: 2\nvqjr: 2\nzjnn: 2\nzstj: 3\nvtzf: ptvt * jhlr\nbbzc: nqzw / qtzl\nffpf: 5\nghcq: htwh * mqpw\nzlms: 1\nzfrm: gglz * lfns\ntgwj: 2\njjpn: 5\nhccw: 3\nqlgr: 3\nsjjl: 7\nvwss: nvzr * gmtz\nrvhn: 2\nqjfh: 2\nsgsj: 3\nsslc: dmws + hgpm\njcfr: 3\njsld: 14\ngbwn: 14\nqqdp: rvzd * nwnr\nlhdt: 5\nrgnn: lzzn * jpms\nddlq: 6\nmqzt: swzn + cblh\ntnfg: 10\nclss: 2\nzrdl: 9\njzch: 4\nqjsz: 5\nrrcr: llmd + qjtm\ndlcf: qspn - bsln\nbttm: 4\nmzvl: 3\nqjgl: fhhp / fphm\nmfpp: 2\nszqs: 5\nplnm: hlmd + nslp\ngvqg: pzqt * sbgj\nglpp: lrnq * rqsc\njjdl: jdlz * zffq\nbdvb: 3\ntnwg: swcd * zcnf\ntnvf: 2\nsrdv: 3\nljbl: 4\nvlfq: zwmv + thcn\ncnll: 3\nhgwh: svzw + dgwv\nmszv: 19\nfwdq: bbqm * pgcf\nnqbg: 5\nmgqd: ctnd * gnqp\ngsbc: gtvn + whzg\nlcvl: 3\npmll: fcwz * tzbv\njjvn: zmwd + srfr\ngsnr: 10\nqfgt: 5\nwcpn: 2\nlpbn: 2\ntjzj: 5\njzwh: 1\nltvn: 5\nvphl: lgjz * tpts\ntgwn: wvlm * hqtc\ngltr: fjvr * qvdw\nqztw: czfw * gfrv\nmgmj: 6\nzvls: 2\nlnpp: bngp * sssj\nwvtj: ppcd * wllp\ncncv: 11\nvvtq: 2\nzsvh: jpcq * wcfq\njcmn: fjhf + cftz\nczmw: mpfj * bzft\njgtl: nfht + mvtz\njdnr: 2\nldtd: zwrp + wbfg\nvlvr: fgbd + hlnh\nrhnq: 7\ncgzh: 2\nzwbd: 17\nlfrw: 5\nwcmp: 2\nwmgj: tdng * tbph\ntfvm: rlvl * fdcj\ncwlj: rwdw + tvmq\nffmb: 11\nrvfv: rqll * sfwf\nwhlp: 2\ndcmj: 3\nvvrs: hrfp / gpvn\nmzhl: 1\nsqsz: wspv * jdjn\ndmlv: 3\nzwmt: rrtp + zqcn\nplsp: 4\ntclj: fvdr * jsrz\nqmhs: 2\nfgzz: fwdq - cdph\nvgnj: sglw + drnn\ntjtw: 2\npdbd: lhzc / vghb\nbmqb: 1\njnbd: 8\ngzlt: 3\nsnhr: 1\ngnpm: rznj / szzr\nltnd: zdwj * wgtz\njddv: zbms - zsvh\nnwml: qwwj * lhgf\ntddv: 11\npsdp: nbqf * mzhb\nfmrf: jtvr * hggs\npqqm: 4\nqbnm: 2\nfbvb: 4\njnlb: 6\ndflw: fvln + djgh\nvdcr: cqgd + ngmh\nlwls: mnww + wggh\nhwqc: 2\nvbdt: qfwv / whht\njdch: gnsr + qdqd\nhdqb: 3\nsbgj: 2\nqtbw: 2\nsrzs: 1\nsvbw: 5\nwtqr: hzbz + zbvh\ntqcc: ffnf + dvbq\ngvwd: 3\ngbsg: rcrb * hwhr\nnmms: nmmj + mvqv\nnqmd: fdrs * npcq\nnmdp: gcnm - zcmc\ncvmb: fblg + qmhd\nqmmf: 5\nsbvw: llfl + fvpl\nsbvq: mpfb + qtwg\nvhqv: 3\nsbdq: rpzr * wznw\ntlnc: rbtz / bmnt\ngntg: mlcg + stqm\nqzjn: 5\ncvzr: mzjm / lfqz\nsqht: rvdg * bpbw\nqwmp: hwsh + tttc\nhjsj: 3\nbcqm: cqfp * czmw\nmwgs: 2\nqcqp: qhnr / ddtt\nwwzg: dqlv / dlfp\nlrww: tlrn - wzrw\nwfwj: jhlp + jwhm\npvvr: 3\nblvg: 3\ndhhc: 3\nghdc: 2\njvmb: rvwz / fhdz\nlwws: vfss * wcpn\nfvpl: 1\nglmm: nvvg + mgqd\nbdmp: 4\nznnh: 3\ngddz: 4\njlcl: 5\nblsp: 2\nmnww: gpwj * lhcs\njwch: ltlj + sqvr\nwbfd: 2\nfdmz: 17\ngfrm: 6\nwsvq: 2\nbhfg: 2\ntcdr: dqcj * qlgr\ndqvg: nmms + dfnt\nstnz: 2\ndgsr: 17\nzsjl: qfcf / mvcs\nnwnb: mjdm + jnfz\ncrqr: gptr * jvqm\nsgrn: 14\nzlgp: 5\ncczp: 5\nqtnf: gwgv + lwhb\ngswv: jqpm + ppcq\nftmn: 2\ntcqh: hzhp + mgfj\ntfmf: nqjd * cfjn\nfczw: wnvf * wfnw\npthm: 3\nvlqv: 2\nmpfn: hbbj + tsqp\nhrfp: gnpm * zlwb\nptsh: mjdz + cfqt\npdvq: 8\nzqpz: 7\ngnvg: tfvm + wvft\ndqfd: tzps * nsnb\nvdtd: 7\nsfwf: bjhs + hsbb\ncslr: 3\nwcjj: rgnh * cntm\nsmwb: bmqb + mlsl\nzzpp: 5\nqldw: jbll * dgss\nmlsl: vfqz * cczp\ngcpl: dhdh * zvmv\ngmcb: 14\nwmbw: 2\nllqd: 6\ndbrj: 4\nqtwm: gmsb * jwnm\njghp: 5\ndgmh: 2\nbtfc: 16\nffsq: hvhc + psfp\nflvh: scqm - fmjb\nhqvt: bvzb * crrt\npwqg: 8\ndsgf: vhnw + dlbf\nszrr: wbjs + bcqm\ngsmn: lhds + jlpt\nvbqd: vvhj + rnth\nhmvl: vwvp + srdb\nzptt: 7\ngpvn: 4\ncdmw: bhfg * bnvb\nrhtf: rrth * szrr\nbrtp: hqdq + wfcn\nzdns: ljsl + wdlh\nqgsw: njhb * jgpd\nhjjs: 5\nmznc: 3\nndwp: bsvp + bzpb\ntltv: 7\nwbjs: djzc * mcjz\ngrzs: jvgp / pnqf\nbqnp: 2\nqtwg: mppd * trgw\nbsnm: prcb + vlmn\nmbwj: 5\njwht: 4\nnwjm: qhcm + htfp\nznth: nvfs / vtsf\ntdwr: jlmr * fdrb\nsjdh: zpww * cjrp\ngwgc: wdhh * sqfm\nthhj: 2\nqrvc: 2\nmrzv: 15\nnnvc: 10\nqwmt: wjrw * hltq\nczst: 2\nrjsp: gpgh * mdcm\nffmj: 3\nfvgq: zgqp / zlqq\nmtwt: 4\nlzzn: 3\nzdgr: sqng / qpjv\ngnhr: 13\nhgcv: 10\ndwtg: 5\nlgzr: 1\nfzff: wqbh * vjbg\nfhnv: qhgt + tprf\nwgzm: 7\ncdqg: 4\nztjb: 4\ntrvj: shdd + qcqp\nhhqq: nhqs + lcrd\nscsm: bhrv * zphb\nwnqb: ldzg + mddj\nwcmj: lrwj / vwrp\nnbvw: ncds * sffg\nmwwh: 2\nqrth: ghdt + bhtv\ncjrp: 2\ndsgs: 5\ngqsq: 2\nsnvz: vsgm - rdqq\nctlh: qrvc + lfhg\nqqzq: mbhf * mdqg\nhsbb: nmdj * sbtn\nzlwb: 4\npmps: 3\nvmbv: 3\nsvnm: vznw + tlnc\nmgqb: wsvq * fdfh\nvgfs: hfbv * ldtd\ntzrh: wdsh * blmg\nrwdz: 13\nhbdc: vtqq * rvqz\nhlpf: glws * nnlv\ngtqt: pbpn * frlb\nvfss: nmwz + cttl\nfnsb: qcmm * vwjf\nttlr: bzlp * fdll\njfnh: 4\ncgjp: jztd * mgjt\nhglc: 2\nrdsp: fmrf - tfgq\npdcd: 4\nfjqs: qdjw * mwbf\ncpbm: 3\nqsmn: dtll + dclt\ncrjc: 2\nbgfj: 3\nbjdp: 4\ntltm: czqz + stpz\nwfcn: 1\nbwnt: 18\nzmsj: zmrd + znts\nqjrv: 15\njfsr: 5\nmdcm: cncv * gvbg\nvcqw: hclz + drld\nflbp: 5\ncrnj: 6\nsngb: 5\nhfvv: sgsj * zzlc\ngnvh: 2\njvrp: 7\nhfbv: 3\nlshv: 4\ncjsv: qpff * wdsp\nphwv: 5\nphzs: 9\nhvhq: 4\nvzrj: swql + wqwm\nlfns: 4\nslwd: 1\nftbt: wsgm * dcqv\nsqwh: 5\npfcw: 2\nlfhg: 9\nmlcg: dmhs * qvsg\nnzng: njbm + jnjb\nsnvr: crqr * tdcr\ntqvq: tmct + fcmg\nlhlb: 4\nsqnb: jlwv * phbv\nbtmv: 2\nsdgt: 9\nmswg: zgjr - qlhw\nftmj: 2\nqghj: jnhr - mzds\nqtwf: vmlb * dprf\nzzln: 1\nnblb: 5\nzjll: 2\nlrzb: 2\nwvlm: 2\ngpgl: zlsd + fltn\njdfh: 1\ndzqg: szfv * ftsj\njvzz: sfpc * ggcc\nptgb: wtdw * ndzz\nwsbl: qprz - cvlc\ngnfn: qvtf / tddp\nwlnv: 2\nqmqd: 4\ncflm: 3\nvhvf: jjwh + tgwn\nrpnq: 2\nzpfz: dtwg * qztw\ndcpj: 2\nhcml: 3\nrjqg: rtvq * jhfl\nqzjw: wqbq * twwb\nwpzp: 17\nmddj: ffmb + hhnw\ndpjg: 5\nzpww: gfph + nzwz\nsrdb: 4\ncfvn: mbpf + bwvv\nvznb: 13\nghbf: qphz * bjtt\nngmh: vjcw / vhlz\nnqnq: 3\ndtzn: 2\nwppj: qjhb / qfwp\njbtz: fwqf + hsdn\nsjtc: 2\nqhgt: fqnr - grng\nbssw: dnzv * fswb\nrnjh: qsrh * hrqh\nqfpz: 5\nfwnj: djcj + rwwr\nzshw: 1\ngfnm: lvwn + jjvn\nlsnw: 8\nsgqn: 5\nbjhs: dlbd + snhr\nnmwz: sqwh * frsz\nsfpc: 3\nblbl: 2\nrgdd: ctmf - bcjz\nmfqs: wsdt + gdrg\nzpvj: 1\ntdlf: 4\ndhbz: 2\ndbpv: 10\nltzz: qtdn * hvgc\ndvmb: 8\npngw: gwzn - gnfn\nnlzm: 3\nmrbp: 2\nwvzd: 5\nwvqr: gsdf * gwml\nnbfq: 8\nnvgj: hspq * jtrm\nqqlz: 5\nmnqc: 18\nnrfs: ghdc + sgqn\nnzqp: cmld + trwg\nnvrs: 5\ncfgt: 4\nngff: 17\nhdfn: 5\nwbln: zjtl + dcpb\nwthh: 2\nnsrq: fvwl * zjll\njqlg: sgjw + qzjh\nzdth: vjzv - dpwr\nfhsp: 9\nsbhf: 2\nvhvp: tmzd + qqqf\nqnmr: mswg * sjjl\nfvhw: psdp + ngll\nvggg: 4\nwdqd: bmzm * lpts\nftbs: mggw / chvq\nshdd: nsbg / vdzs\nwqcl: sgnf * lvvj\nhtdp: 16\ndpwr: 4\nrhmb: 4\nrlwn: 2\nrwth: sfpj - vnzp\nfqtq: 2\nnnlv: pbwb + zsjl\nnljf: zscd * ffbr\nftcm: 6\npqnz: mddr + mtgg\nhtwh: 5\nzwmh: 2\nhumn: 120\nnsqr: jvmh / vjmm\ndjzc: wvhm * jzpm\nlhqm: gntg * rddr\njwhm: 1\nwjfv: 3\ndqbg: 3\nbsdn: 3\nhhwq: 14\nhvgc: 2\ngmsb: 2\npjpm: grrg * nsjw\nrhpf: nlzm + dltw\ntvvv: hpwp * stnw\nwdmn: 2\nsjsf: 2\njlwv: jsdj + vcdp\ntsgp: 2\nbgtj: 18\nvmbp: jjdl + qgrs\nzzpb: mfcc * rmwv\nqrgl: 5\nhtfq: 2\njdgn: wthh * ppqb\nwznw: 3\nfsns: lznd * fvhw\nwbjb: lcdz * rnmn\nsvpd: 3\nzznz: zbzf * sbrq\ndfgb: 15\ntcht: 5\nfdcj: 6\nnfzg: nfft + dvpb\njhmc: stnz * qqfr\nntrq: 7\nbbpp: 18\nvchh: 3\nbsgt: jqlf * blfg\nnvpp: 5\nnbfv: ltnd * vwmb\ndrld: hpph + rrgj\nvwsv: fdht * rblr\ntggm: 4\nrrth: 2\nmtsj: mfnf * bltd\nhbsd: 2\nwbfg: 16\nbvrg: pzzs + qbcm\nnqjd: rhzt + zmwz\nsbjm: jhnd * zhlh\nvjcr: 11\nggsv: 4\ngshr: 2\ngwml: 2\nzvfn: 5\nbctf: djtg * vwrf\nmwgj: 5\nvdtj: wwnz + bnvh\nrjpm: 2\nmlfn: 5\ngmtf: wgwc + frqd\njthh: tnth + bfhp\nqprz: wrsn / zwmt\npzzs: 9\ndjgh: hqrp * npnp\nzzcc: 3\nzwfb: 5\nblfg: 3\ndlqs: 7\nznmm: 5\ncjzz: zwvp * vvrs\npctz: mfqs + stzw\njzql: fmzv * vhqv\nlvzj: tqfd * nbsj\nmmhs: 3\nlngh: 18\njbnz: 3\ncmrz: 4\ntjvh: hbsd + wjwp\nbfnd: czmv * wpzp\nmvpv: 2\nwdtd: zpqq * rfcz\ngclt: 14\nlmwj: 1\nqfpf: ftmj * bvnm\nlnld: qmzq * drvg\nclhn: 2\ngpzb: cvjr * dbrj\npcbd: hfrg * wngj\nsqbw: rdsp * ftvq\nsqzs: 11\nnfnn: 4\ngnqp: 10\nsgjw: 3\nnfpz: 2\nbfhp: 1\ntbhm: 7\nrlbw: hlcm * tdfl\ngrhc: tzmd * hctq\nbsrr: 18\nnvjc: glmm + thcb\nltll: tvcj + mbhm\ndlbf: trgg + ggcv\nstvl: crjc + tfgr\nnclj: 19\ncjcv: 3\nhctq: 7\nflnz: 5\nzppf: plzw + wmlq\nzwdg: 4\ncmjc: 4\nmsmb: 2\njchs: 2\nfshp: jrhf * msjq\nbzwh: pnfh * dhhc\nsgnf: 4\nfhtf: 3\nscmr: btzq + hqhd\ngqfb: cjmd + tpjs\nchfr: gfqv / pjct\nqrnl: 3\nwvgs: gshv + psbr\nplnb: 2\nlhzc: sqpm * chnw\nnclb: vwsv + mrsb\ndght: 10\nffbr: vmfv * jltr\nqvwd: hmpf * wsgr\nvhnw: gldh * mqql\nzbdm: 3\nhhwb: humn - bwns\nwgct: gjvw * plnb\nmbpf: 1\nzhpw: 5\nqdvf: lqdg * rlwn\njhgm: 5\nwzhb: 3\nczdz: shbj * dsgs\nrjqn: vhdf - rgcl\nwgwc: gppt * phpn\nvjzr: tbtl / vrvd\nfgjm: zjth * qrnl\nmgcb: nzll + pccp\ngtmp: mjrr * ljcr\nmlsg: hfhj + qvqm\nmllz: rlrr + djvm\nhvfz: gtmp * tqdf\nffdv: 9\ndfnt: cflm * cnmc\nqnmp: ljzj * zlfh\nggcq: 2\nqglg: 2\nfjqv: slhc * hpmp\nglws: 7\nhlgn: jzps * dncl\nrvzd: 3\nsntl: hpwf / mgsm\ncfdm: rgph * gnvh\nwvzj: srzs + prpg\nnhqs: 16\nmrdl: wgsn / llln\nnftw: 5\ndgbp: 3\nmhvv: sbdq + stpt\nqsdf: 3\ndfht: hcln * cwlj\nwdsp: bclm + wqcl\nddtt: 4\nspqb: 8\nfmjb: pbvc * zvdn\nzbzf: vbpd + nldt\nhspq: gvzz * hmvl\njrpq: pfcw * dzrj\nbngp: 2\nrnvt: jgjj + dsbs\nlscd: bjcz * nfpz\nhhmv: vlfz * wnqb\nhcqr: lvss * vwpt\nthzg: sgnn * dmmg\nnscj: 4\nsjst: fdfj - jjpn\nfgbd: pslv * gghb\nhvbl: 5\nfrlg: 16\nqhnr: nzvs + wdfr\nbhbc: qwst * qfpz\nrsdg: bqqt + wsdw\nfvcj: 2\nnlsq: wdlv * nggh\nczqz: mnqc / nwwj\nrmhb: 9\nrqsz: 2\nbsln: cwwb * tfcj\nlnlt: 3\nptgf: 5\nmppq: hhqq * fpts\nqqjm: 6\nwjmt: wwcj * vqmb\nzqfd: 12\ntlbq: zqfd * jfsr\nmfcc: llbc * ltfq\njtrf: dqvj / nwbm\nhjlw: 3\nfjlh: vfng - zzrg\nljsl: 1\nfphm: 2\ncjbq: bhsg - ztth\nwjwt: phqg * mwqp\nrzrr: wzhb * blvg\ncpsg: 3\ndfqq: 19\nczht: 4\nqmvc: 5\nvbcw: blsj * qdcm\njfcp: 9\nlqmq: fhjg * hhmn\nljcr: lwld + hstg\ngmfq: 2\nqtdn: zwbd + gbsg\ndtvd: 2\nwwnr: jqjq - rwth\ngzhc: frzv * mrlw\nvsdh: 2\nwzmd: 6\ngngm: vplv - cpnq\nrssc: 2\nmvqv: tzph + mfvh\ngwgv: 5\ndjlg: rfth * fdlj\ntjpw: fgtb + shcr\njcvq: 5\nrqjq: 2\nnfsw: 2\nrwwr: qqrp + tzbf\nzgvg: 2\nstpz: 4\nrfcz: 3\nhvhc: jcdn * bwtr\nrddr: 2\nfhjg: 3\nfnph: 16\nmblh: dvmb + nlsq\ntrzd: nwsd * snvz\ncdph: 2\ntdjj: 5\nstqm: hjrv * pjhh\nsvjp: dfqq * sqpz\nhpmp: cpsg + nhqh\nctnd: 9\nswql: 16\ntgqv: 3\nvrpr: mngw + tqgh\ngjsb: 17\ntsqp: 2\nhbmr: pwbj * fzhr\nmppd: 2\nsbrq: 9\nvgdn: 5\ngpgq: qjsz * jpqg\njllt: jwgm + dvfm\ncpnq: 20\nvbzl: 2\nrvwz: dnmf * jnbd\ntjzt: 5\nsjrf: 3\nhsnd: lfcg + bcfm\nhpph: 2\nnlwm: vbtj - bsbl\ndzrj: wfbn + mtwt\ngtrg: 4\nfbjd: sfnr - qrgl\njnqq: 4\nbvzb: 5\ntbtl: mzgw * nhgg\njmbd: bbbb * zrpb\nzzfb: jhnt * mcwj\nsvcb: 18\nmrfp: llmb * ddsl\nrgfv: bwpn - ldsm\npfjb: 10\ntfvf: 4\nfjtw: 3\nbzpb: 7\nfgtb: qjbw * drjf\npddj: vbjq + zdln\nplcs: 3\nbscl: svjp + qtsb\ntqgh: gzhc + vfjz\nmlvl: qtwm * jvbv\ngpwj: 2\nbqqt: 2\nqzcf: dcpj * ngqn\nmzgw: ctmw + cbqd\nsbsv: 2\nlrfl: qfgt + qbnm\nddrd: 2\njtgm: 2\nllln: 2\nsgzf: fvdd * rcsd\nwspv: 4\nftcz: fmsz + qngb\nschn: 3\nlfqp: rjqg + wwbj\nfvwp: 2\nhphn: 1\ndcfn: 4\nwqdn: smlg / lshv\nrbqm: 1\nbtzq: pfwq * srrc\npjvb: czvm * rnjv\nhtrw: 5\nnvcj: lcgw + gfnm\ngqcp: wcmj + zgzs\nllmd: 12\nctlg: 3\ndfdc: httw * pdtr\nmtpw: wmbw + ggrr\nmrqp: rgvs * trjl\ntljh: 2\nsgnn: trpv + phcg\nqtrc: dtvb * bcnt\npprj: lvzj + vtvm\nwjhn: mmdc * wsph\nfpml: 5\nwfct: lrzb * zhnp\nnjzz: 2\nggcv: hrtn * lggz\nwsgr: 5\nptbj: 1\nprlr: rqjq * rvhr\nqzcz: 3\nsppr: rjpm + jlcl\ngctq: tzmw * zmtv\nvcvg: vzqj + nsjv\ngrgv: gzlt * htrw\npgmr: jhgm * gpmm\nnldt: lnlt * crhz\nsvsp: sghz * tljh\nnqwn: fdzp + slml\nfpnf: wjms * jllt\nqtvw: 3\njdlz: 16\nbltd: ghbf - vrpr\nlggz: 3\nwqmw: 12\nvhdl: ltjq + mcrp\ntzbf: wvqr + nscj\nvhrz: 2\nfgqs: vvtb * fczw\njjwh: 5\nsjjq: ntcg + qldw\ntlrn: mrfp - pzfg\nlfql: 8\nzjpm: zzpb + pgtz\nwqwm: wjlc * hqpb\nhggs: 8\ncqsd: 3\nfdlj: 19\nrqqs: 2\nqsrh: 2\nmcjf: nbpd * djsh\nnljc: 5\nnqcf: fnvn * zvzf\nrcwz: 3\nvgdq: 1\nzgqp: fwnj + rgmv\ncfqt: vlhv * fjlh\nbhlz: 3\ngzpt: sdlg + hphn\nwjtv: 17\nmqpw: 5\nfjns: 12\nbdbp: 4\nnjzj: sdpp * lwrl\nbdft: mtjz * tmwz\nbflh: 4\nzzfz: 1\nmrlw: gwrz + wdtd\ncqgd: tqhn * hssr\ndqjg: 3\nvtqq: 2\nldzg: shlg * rjnt\nbcnh: vgdn * wght\nvvtb: cwfh * gttq\njsrh: 2\ngrll: mttn - hcqr\nhqrp: 5\nbgqd: fnqf * nmdc\nhhnw: nppv * mpcg\nqpjv: 4\nbhrv: fsvt + sngb\nfrtq: 19\nntzd: plnm * nwnb\npqpm: 2\ndmws: rlbw + fpnf\nhjzl: pssn + mssq\nmszt: vpdp * zwth\nwwts: 5\nhtzb: gsln * zvls\npccp: 6\ncfhl: wnbw * tbhm\nqppd: mjwr * rhtf\nlvhb: hsvq + fhmh\ndwlm: vgfs - ddvh\nqvzl: 2\nccph: csnr * fght\nmwdg: sprd * spdn\nbhsg: mtjs + bwzd\nqvnp: cbbj * wqdn\nnnfb: rgdb - vlvr\nfdrs: 4\ngjhn: ghpc * llbf\nzbdl: 2\nrmlr: pdcd * qwmp\nvtjb: 5\njzvc: scdj * rjwc\nvwrp: 3\nppqb: wmfn * pdvq\ndrjf: 2\nmtjz: qnmr + dfjb\ndfjb: wgbr * bsgt\nrzpv: 3\ngdwj: 17\ncfjn: 2\nqrcq: 2\nlpts: 4\nvrst: 19\nhfdb: 2\nzlqv: 2\nhbdp: 2\ndzvd: hcrr * bvlt\ngzgb: gltr / nqff\nbmnt: 2\ntrgw: 10\nvdtp: 6\nnndq: 5\nzbpq: 3\nwrdf: sjsf * vjlh\nmldp: 3\nqbcm: pfsc * dclj\nqmhn: 2\njfdv: vphl + hbmr\nfvdt: 8\nqlpf: 5\nccmr: cqgs + lldc\ncmqd: 3\nvjgf: mrrc + rmlr\nmsjq: 2\nczfw: 3\nznbv: 13\nsnbd: 5\nqshf: 3\nlwlm: 1\nrhjp: 4\ndrcl: 5\njrhf: rgcm + dflw\njdlb: 6\ndgpc: 3\nttnp: 3\nfrsz: vggg + srsm\nfnqf: 2\nnqff: 5\nphmh: zvmr - zrdl\nmpgz: tgwg * fbbr\nqqwq: 10\nnrrl: 20\nswvg: 3\nvrhn: pzst / hjjs\nhpnj: lftq + cbbh\nlvwn: vrhn * gjfd\ngwzn: fvgd * tnft\nptzw: jggt + zznz\ncnzr: 5\ndlfr: drcl * dght\nptvt: 8\nllbf: pddj + glqw\ngghb: 9\ngnsr: 5\nsqpz: rtjv + grcz\ntbnc: dcfn * htzb\nfcwz: gnqz + mbwj\nccnc: pqnc * nblb\nwllp: 5\nbvww: 12\ngnqz: gshr * jwht\nbbjn: dbfn + lhlb\ndqfq: ttfs * fwwp\ncmld: ndrd * lndf\npcvr: 5\nhnzj: tltm * zmpt\nrdng: 16\nngqj: dmlv * bgfj\nmqbr: jddv + tcqh\nhstg: 16\nbvwd: 2\nbrhv: 5\nwfnw: 3\nfmsz: 17\nggvt: 1\ndzpr: lzdg + gsnr\nlzqd: qqjm * vdtp\nqdrr: rnjh * rtqp\nfrzv: wdgw + pqlm\nczvm: zfrm + dqvg\nwhzg: fjns + hcpl\nzhlh: 3\nrcrb: 2\nptbs: 10\nlnrh: 5\njsrz: nvgj + tvnd\nbrfg: qbpq * wlnv\nsvjl: rjft * hptl\nrjjg: 2\nfdll: 4\nhlnh: vlqv * ddjm\nglzp: 2\nbblp: bzwh * bfgb\nfbvn: 5\nltlj: tgqv * fmzt\nvqpg: 3\nmmth: 8\nctmf: plww * mwzb\nplzw: lmwj + jngh\njqbs: 2\nhwqg: gtzb + wbzc\nqzjh: gvzc * grwv\nltzs: 3\ndcqv: 2\nrpqj: 2\nzmpt: 2\ncdvh: 3\nqjhb: nclj * mfpp\nfrqd: 4\nlszc: zrbb * fzff\nlhtl: 3\ntpjs: 2\ntjjd: 3\nnslp: svsp + gntq\npvhf: 20\nqvqm: 4\ndjsh: fnvb + nfwq\nvrvd: 3\nmlss: ltll * flnz\nnswp: fjqs + qtvw\nqvqg: cwbp * wngm\npgqv: 2\nhtng: lvhb + cdqg\nrfrp: 12\nnwnr: 3\ngbbc: phhr + bpbq\nwqqd: 4\npmpv: cmrz + cnbc\nbdsr: cjsb + zrhq\nfqvv: 3\nznsz: wlbv + rdjg\npzqt: ttlm * qjlt\nlmtg: 10\njffs: sfhs + tdmf\nphpn: bsdn + dplv\njcrs: 4\ndclt: jcmc + jllj\njqtb: zdgr - phjs\ncrhz: 7\ntgwb: 5\nfswb: 5\nrnjv: 17\nvmqn: 3\nnjnf: 5\nbcvt: btmv * thzg\nllwq: tnnl / ztjb\nbwzd: rrhp + lngh\nsghz: 11\ntjjh: jthh * fcqm\njbbv: rhbj + nbfq\nrglh: tlns + zjsm\nwsdw: vwgb * ttnp\nrdjg: 15\nlcrp: 15\nppcq: tfvf * pfws\nfwmb: 6\nrwpf: dgsr * grrs\nvrlt: 3\nzvbv: 12\ndtcn: grgv * fgpz\nfrmw: 17\nfdht: 5\nnzll: 3\nnqjs: 3\ngpvg: wlvs * tfsh\njjqp: hmnn + fpml\nfqjd: 3\nrgbs: qwmt + csrt\nrrgj: gnhr * ztpz\njfwt: 8\nbgfc: 4\nggcc: 2\nbjvs: 18\njpbg: sbdn / zpnz\nmrgm: vjgf * blzt\nfzvq: hbbc + pngv\nntcg: bqnp * mnjh\nwvhm: cdsl - zbmn\ntpts: 3\nznvf: 6\nfnnq: smwb + jvmb\nvjbg: jrtt / mwwh\nltfq: 3\ndzdg: lhtl * nprm\nsqbz: 6\ncbbj: 2\nmdqr: 3\nvhlz: 5\nzbmn: 8\ngfph: 8\npfws: hfth - ddlg\nmjdz: rvfv + hfdj\nzgfs: 2\nsffg: 3\nsjhb: 5\nvmfv: 2\nzscd: 2\nmdrr: nfdd + snbd\nvrvl: sfzm + chfr\nhbbj: vqpg * sztg\nfvcn: jlwt * pcqg\nhjgv: jtrf * pqqm\ntlns: bwjd + zlms\nsldb: lfqp + jfwt\ngjfd: 2\nfwbm: gnml + dfdc\nhlcp: 2\nwwcj: 2\nphcg: vvgf - mjhq\njfhl: ggcq * jnnh\nvrzh: 2\nwbtq: 4\nqsng: 2\nzrpb: 2\nrcsd: 10\ngpjw: tljb + mwdg\ncfbm: 2\nwzvt: 5\npcqg: 3\nlqds: zjpm / qhpl\nlldc: 1\nqdcn: sbsv * qnhl\nmtjs: pdfr + vvzh\nqqrp: fwmb + hvbd\nnsbg: tlbq * ntmq\npphp: dsgf * vjcr\nmtgg: wmtn * nfsw\nqjst: bfnd * swwr\nmmsc: qnqh + ltnm\nlvnr: 7\njhlp: sjst + gfrm\nvbfv: 3\nddbg: 2\nzjth: 2\nqwwj: 7\nrhbj: pbwr + pwqg\nzpwv: dgjn + pvvr\nllbc: vbcg * gfqn\nwmrb: 9\nlpff: 7\nwbjt: 13\ndsbs: 12\njhlf: fzvq + zrbq\nfrvr: 5\nsptd: 10\nnppv: 2\nbmrf: szns + fqmp\nssjb: 5\nqfzh: tdjj * twdq\nrhzt: 5\nhbfl: 9\nhlss: bbmg * llbb\nwngm: cdqj / vsdh\nlrwj: rjsj * vnbv\nfmzt: 7\ngtrb: 2\nhsht: lnbw / wlnz\ndqlv: lshc + cmcl\ngbdp: 1\nvfsb: sjhb * bzjm\nhlcm: npmn + gswv\npwbj: 3\nzzcv: 3\njnvw: fvcj * vpbt\ncwfh: qjgl - vlfq\ngbst: 2\nfbwr: 3\nglss: rmms / gbst\nzhzz: nfbf * ctlh\njqpm: zrwt * nhjw\npscz: zrrm / pdtw\nlcdz: svrq * pmhz\nmbtq: bsrr + bhbc\ntgtq: lmpq * zjmm\nbqdh: 4\nzlzw: 8\nrbjs: rnbh - zhzz\nsrrm: 2\ndjrr: 3\nzpqq: mdqr + cqwj\njdzg: lwws * tdhl\nvplv: qgqn - fcsw\nprcg: zqvn * vjqb\ncsrt: bdft + srgh\nnzcm: 12\nsrbz: 2\nqvsg: 3\nwddg: cswj + ptzw\nfctd: 5\nqjlw: 2\nrldc: 2\nddlg: htfq * spqb\nhfdj: tgwj * wfwj\nddst: 13\ntcjp: 4\nrnth: vhvp * ljbl\nwnvf: 2\nnpql: 3\nqpfz: vmzq + tbnc\nqnwt: ljcq * njng\nzccs: 11\nmlcb: 4\nmpcg: hgcv + hbsz\nrqrz: 2\nrgjz: 1\nwdrc: 3\ndbvp: wstl * mpnt\nfwnq: 15\nhppv: wpnr + bcnh\nmsvs: 8\nvjlh: gppd * msvs\nrqcz: 7\ngrcz: 6\nhzhp: vwvr * pqpm\ngwnm: dgbp * cnll\nvwpt: lbgz + djrr\nsprd: 5\njntd: 18\nnhqh: 10\nvttc: npht - jqcs\nzrwt: 12\nbmgv: 11\nwjwp: 4\nqmzq: 3\ncntm: 3\nzvzf: ldmr * qmjw\nmwfv: 7\njtrm: wrqh + tjpw\nrsgv: 3\nvwjf: 2\nnbpd: 7\nzdfz: tnfg + jzwh\nngsh: 3\nqlsv: brhl - dssl\ntrgg: 12\nnwbm: 4\nqdjw: pdhv * zgfs\ntddp: 9\njwnm: bfjs - sgcd\nslhc: 13\nwtjn: 5\nbbjs: srbb * rdng\nmzlc: jzvc / shzw\nsvcq: 3\nlmqq: 4\nmcwj: 3\nvcdp: 13\nsszv: fvwp * rgnn\njztd: nljf + ztjg\nhnpq: 2\ncblh: nzqw + vcqw\nrrrf: ghtc * gfjg\nrmwv: wqrw + rwpf\nltcm: 3\nnmfv: 2\nwgbr: nfds + dzvd\ndbbq: lrrj + dnlg\nsgcd: jcvq * rnvt\nqdrj: mtpw * ctlg\npfwq: 7\nwgsn: rfjn * gngm\nvnlz: 3\ntdcr: wwzg - nzqp\nftsj: vwlj + nljc\nqtgr: rdfv + dwmg\ngwrz: mwgj * tmjz\nblzt: snlj + bdsr\nrzlh: 3\nstpt: wbjj * sbvw\nroot: gqjg + rpjv\nhlfm: 14\nsmpw: 3\nfbbr: 2\ntjjt: 2\nvbjq: mpgz + djmp\nppcd: 7\ntmjz: gnbn * jqlg\nrchc: hffq / wvzd\nhclz: plsp * vbcw\nnflw: nsgb * tltv\nfsft: ggvt + tcfb\nfbqw: zhwb * wwts\nzrlz: mltq * lhll\nphqg: 7\ngvth: 1\nfdsj: 2\nfjcf: fvdt + jhlf\nrgcl: 3\njlmr: mlgn + ftcz\nddsl: grll + rbfm\nbsvp: 4\njrws: 7\nrmtp: bzwm * qzjw\nfltn: fbcr + sqph\nlqdg: dsww + dpjg\nwlvs: 4\ntfgr: 4\nmcvl: spgv * ddrd\nbcjz: 3\nhjlh: fnsb * gtrg\nbqpn: fvdl + pchq\nczmv: 2\nqtzl: 2\nqlhw: sgzh * zlgp\nplww: 2\ndjnj: rwdz + nqbg\ndqvj: gzmb + prlr\nszzr: 3\nwsgm: 4\nddhr: 3\nlfqz: 2\nvcrv: bgqd / wnbp\nchct: vwss + dgbf\nbpnp: gsmn + bbmw\ndgjn: brqf + wrtr\nhwlg: vzgg / wsnq\nvdnb: 5\nhssr: 2\nsvgg: vbfm * tdlf\nfwqf: 3\ndncl: pwcm + bflh\nllfl: stvb * wqqd\nldhp: svnm + sbgm\nhghh: rzlh + wdqd\nlrnq: 3\nsrrc: pdcz + pqpq\nvsls: 8\nvvhj: tnwg + ldhp\njggt: wbjb / ftbt\nfqdd: 17\nzgjr: wzbm * mbtq\nbnnv: zzcv * rqcz\njbll: 3\nzcdd: 3\nbwpn: ftbs * cplt\nlzvs: 3\ncrtd: rcwz * fbmd\nfpts: 2\ndvfm: bvrg * rgdz\ncbbh: 1\nllbb: vcrv + mgmj\ngssr: jsld * hsds\njftw: prqz + fflt\njhnd: 2\nwdgw: cjcv * wshl\nfnvn: 5\nmsbv: stsg * bqpn\nchwq: pftv * lcdw\npmhw: 2\nbhhj: 3\njnnh: tvpt - jnvw\npbpn: 2\nlbrd: djtf + sjrf\nrdfv: 5\ncsgw: 2\nbnvh: flpt + jrws\ncmfn: vpjc * mlcb\nzbms: djnj * jzql\nmzhb: gtqt + ggmn\nqnqh: 5\ndwmg: zlzw * zlnm\nvmvt: sqsz * jftw\nqvfn: vmbp / zstj\nzjvw: 2\nwrqh: rfmv * cdmw\njbfl: jtbm + zptt\nsglw: sbvq * rpqj\nnpht: hgpv * lbfm\nlznd: 2\nzlcl: 11\nfcdp: qqwq * ntjf\nbbmg: 3\nmfpd: 5\nnbqf: 5\nphbv: 3\nqwjg: ghcq * tmfq\nvdzs: 2\nltrl: pprj + wvtj\nrbzv: gzpt - spng")
;sbdn: bctf + msbv
;nfdd: jnlb * bbjn
;sbmt: zzcd * vpbd
;dvpb: 12
;hrqh: 20
;qdsq: 19
;dmhs: qjst / psrt
;mwbf: 2
;fhmh: 4
;fnnt: 5
;ctmw: 9
;shtl: rhmb * gmhp
;qrnh: gwnm * ssml
;gcnm: tjjh / wwwr
;nncw: wbzd * sfcw
;qgfs: dzbv + wdrc
;qpff: 3
;wggh: 7
;cdsl: qvnp / wlsd
;wpnr: 4
;mqqt: 6
;dnlg: njzj * cjsv
;wvwh: tjzt + hwqg
;zmrd: 9
;tqfd: 2
;jzzg: mrdl * gcqg
;nmdj: hsht + bttm
;hfhj: 18
;qqqf: mngf + nshb
;vtvm: wzjs + qdvf
;blsj: 3
;jnfz: 1
;sfgz: nwjm - qbmd
;mlbw: 2
;jnjb: 14
;rnbh: fhdc / mnzr
;zwrp: zhpw * ftfm
;jhnt: 2
;hlmd: 9
;jnbb: jcmn + gmtf
;pmhz: prqw - gdhc
;whht: 2
;jgpd: 3
;tchz: 5
;mcvd: 11
;bmwn: 2
;qwst: 5
;bfjs: rgfv - hlpf
;twwb: 2
;dpjf: mqgc * tjfg
;wbzd: 7
;slml: 3
;ftvq: 3
;jqcs: bqgr * fztn
;rjwc: hzwm + ffdv
;jvqm: 3
;jnhr: zbnf * hnpq
;bmzm: 5
;qljm: zjnn * stcb
;fsvt: 2
;mttn: gzgb + jgfs
;gswz: qvqg * dbvp
;nwwj: 2
;fhfs: tdwr + qrnh
;wcfq: 6
;gfgv: qmtj + gchq
;vsgm: jwdd * rfrd
;hzwm: 2
;srqm: thrf * rddb
;cftz: swvg + sshh
;vvtp: 2
;stsg: ztwz * spvr
;gjvw: wjtv * brvp
;blmg: 3
;dclj: 17
;cqlb: slmz + bdmh
;mjhq: nqnq * sjdh
;hfqb: 4
;dnzv: 6
;rfjn: 2
;bcfm: gfrl * nmdp
;bzwm: 4
;rdtl: hfhc * ljlg
;nzwz: chgr - cmdw
;qbpq: lnns + sgzf
;lbnm: sqbw - mpfn
;zpmf: 2
;qmvs: 2
;trpv: hcbg - wzqv
;zhnp: mfqm + svgg
;brvp: 7
;lhds: frvr + gpdw
;mnrp: 2
;dmmg: 2
;bvjv: sgrn + dtmf
;ppsj: 10
;rlfj: nmwn * pgrc
;jtvr: 9
;wdlh: 6
;hzhr: 2
;mbvt: gdwj + mvff
;sjcg: wcjj * pshs
;lnbw: dtdg * bzcg
;rbtz: msmb * nswp
;djtg: lrww * rldc
;rpjv: cnhs * wqmt
;lwrl: 2
;cvdf: 13
;jztf: 2
;fmnq: wqqp + znnj
;vhtm: lvln / nfms
;gmrl: mwdm * dtvd
;qgzz: 9
;dprf: hglc + fctd
;msqd: 6
;chvq: 2
;ztgn: 4
;gppd: 2
;gwrw: lnrh + jcfr
;rjft: 4
;rvdg: 2
;zhqp: 7
;trjl: 5
;snlj: 6
;tvdp: svps + bdmp
;cdqj: gspr * lpbn
;zrjs: 3
;grcg: 13
;zcnf: 2
;bqtw: qwjg + mmrq
;vpjc: svcq + htng
;wjqc: 2
;fwsg: 3
;vrqz: sjmc * lzzg
;pdhv: 4
;mqgc: jtjf + wqvr
;gfrv: qbwn * plrq
;frsq: 19
;tzps: 2
;bzft: 11
;glwr: jdfh + gbvs
;trwg: ggsv * vcvg
;nqzw: zwdg * qsdt
;dhdh: qqlz * frhf
;sfpj: hjlh * jbfl
;ldmr: 2
;dplv: 5
;fdsp: 12
;zjlj: 3
;stcb: 3
;zqlm: 6
;jltr: tqvq + wplp
;sqng: mrpf + vnth
;pgtz: vzgp * mlsg
;wlsd: 2
;crzv: wfct + jjdf
;fcqm: zccs * tdmg
;rlrr: glwr * gqwc
;nmwn: 13
;bzlp: ctnc * gzdt
;tfgq: 5
;mrlt: sbjm + pmnd
;vpbt: glss + mrqs
;cqfp: csrh + sjpf
;cmbl: 14
;dtll: zbcg / mpsb
;mrrc: nncw / sppr
;jwlz: sdmd + pphp
;bbzz: 2
;mnjh: gbdp + wjmt
;swhv: pnsc * zpwv
;zffq: 2
;bpbq: 10
;rbpb: 2
;sdhg: zwfb * ccnc
;qlds: 3
;zlbn: svdf * ffpf
;qbmd: 2
;jlnp: 3
;hffq: hrbc * lhdt
;nbsj: hpnj + zqlm
;bzjm: 5
;zbcq: tqcc * mwgs
;vhfw: 2
;mltq: 5
;hfrg: 4
;fgjs: zbdm * dgpc
;nshb: ndnl * tvvb
;grvb: qwqc * jcrs
;wtdw: gldv + nhnf
;vvgf: chct + mszt
;cjmd: qncq + ddpb
;nhjn: sjcg / zpmf
;tdng: nzcm + vhfw
;zsrg: 2
;hbbc: 7
;mqhg: 5
;mwdm: dqfd + sntl
;cqgs: rvhg + mzvg
;hqhd: hhwb / cdrs
;gsfj: jnqq * tchz
;pvlz: 5
;bnlh: 4
;hnbh: 9
;nfds: ddst + nlqn
;rdqq: phnj - vfbg
;mpfb: fqvv * jdch
;bhtv: bghm * vfzj
;mnlg: bcvt - hvfz
;hbsz: 1
;ngmf: plfm * lpff
;pprz: 13
;qbmm: 3
;tzmw: 2
;zcmc: 13
;rlrh: mmhs * zzbb
;fzpc: zshb * vvtq
;zqgr: 19
;wbjp: 4
;lcgw: cmjc * csgl
;nvvg: tjnj * gddz
;zqvn: htdp + zgcp
;dlfp: dtdq * npql
;ndrd: dszg + wvwh
;sjpf: 1
;tqhn: pddt + fbhs
;wlwd: 2
;pngv: qmqd * qsdf
;bzcm: zbdl * rzrr
;zmtv: 14
;jgjj: rsdn + gfwv
;qgrs: vrqz * zsrg
;fnvb: 4
;zbcg: tzmf * wrrn
;fqmp: 2
;wzqf: 11
;gntq: gqbs * blbl
;tcfb: 5
;btpd: gmrl - dbbq
;nmmj: gpzb * sfvr
;thwn: 2
;cplt: 2
;twmh: znmm * cnzr
;svzw: 1
;fqwr: 2
;cttl: bsnm + mqzt
;fdzp: 4
;qwwp: dzpr * bbzz
;spng: 2
;qmtj: bgfc * rtql
;lcrd: vtjb * mzvl
;lshc: jbtz * gctq
;zvdn: 3
;zhwb: fgvs - rjsp
;fvdd: nsqr - dqfq
;gplw: vdsw + mgcb
;wmlq: hrqr / zqpz
;dtdg: 4
;lnns: wdmv * gvqg
;mrsb: nnfh * qglg
;rjnt: 2
;fvgd: gbbc * zmsv
;vfbg: qnmp * hltz
;qjtm: 2
;zqhf: 5
;rddb: swqs * jljs
;zhss: 2
;vpbd: 4
;fflt: qbls / zwmh
;bsbl: dzvl + jbfv
;wqsb: pstv - fjtw
;drrz: 2
;mssq: 4
;hhmn: 3
;tprf: znvf * zrlz
;brrw: fwbm + qfpf
;tdmg: 2
;bwhn: 9
;nvzr: ffjs * pzmg
;ssml: zmsj * svzh
;vzgp: ltwt + qjrv
;ltnm: wcmp * svpd
;hrqr: rbzv * ndbg
;rfmv: 3
;dnsn: 2
;hptl: trsd + rgjz
;cnhs: pnqg * npjd
;fwpt: 2
;gjlm: 5
;ttlm: 13
;vwgb: zqcs + pcwp
;vlpt: 5
;ncds: 3
;wjdr: 3
;csnr: 10
;ffcj: 4
;jllj: whlp * frnc
;zgfm: 3
;tnft: tqjf * sbhf
;pbwb: 9
;brqf: 4
;njsm: gbdt + npsz
;qphz: hfdb * fzcc
;qcrr: 2
;fjvr: jffs + qjfh
;rpzr: 7
;lzdn: nmdq + lscd
;zcbq: fvgq + wgct
;sblg: 3
;bfgb: 9
;ddpb: wlwd * lzvs
;vmnr: zstq * cfvn
;jbfv: 3
;pgrc: 17
;tzrr: 3
;sqph: vmbv + lmdd
;rgdb: trvj * rsgv
;rvmz: 7
;jvgp: bmrf * nnvc
;vpdp: rpnq * jsfn
;tqgj: 3
;ffbm: 2
;vnth: pmps * qghj
;nprf: 2
;dbwf: 2
;fcsw: 18
;mqql: 2
;tdmf: 7
;fhdc: jqph + czwd
;ftpp: 2
;wzmg: qtnf * rwzb
;cswj: zdvw * gzsc
;pnqf: 5
;hfnq: mhdd * fgvz
;pdtw: 2
;swwr: 2
;fbmd: 3
;dbfn: 3
;pnfh: 3
;fjbv: brhv + zshw
;wqbq: 3
;wngj: gsfj + rchc
;jcdh: hsnd + tfmf
;qvtf: hgll + tvvv
;rjwf: bpnp * hdfn
;ncfl: 19
;czwd: lbvt * wwnr
;bwns: wtjn * bplf
;zmwz: glnl + twmh
;dbqd: wddg / fbwr
;jdfb: qdsq * cqsd
;dqcj: 2
;vlzz: lrgr * vbzl
;pwft: rhnq * wcmw
;pfgl: dpjf / qrcq
;wjms: 9
;wqrw: ngsh * zhnd
;mjwr: 5
;gshv: zfdl + pdbd
;jgfs: zfgq * qsng
;rgnh: 5
;qqpp: smnq + mhvv
;plfm: 7
;zdwj: 2
;zqrh: 11
;thrf: qshf * dqjg
;npnp: 3
;jtfn: 17
;hjwg: 11
;jlwt: 2
;zvpd: ltzz / mlbw
;dmcm: wzht + bgnr
;nlqn: lzdn * zgvg
;hgpm: vhvf * mppq
;cwwb: jfhl * gljq
;fhdz: 4
;npsz: 10
;pnqn: fbvn * gscc
;drmg: 13
;ctnc: 17
;cmdw: pllt * fhtf
;scqm: nbvw * zmcq
;rtbf: 5
;fgvs: lngz * mcjf
;jqph: qnwt - bvqq
;sfzm: 4
;lrgr: 11
;qqrz: 3
;gpmm: jmhb * nfzg
;gscc: 5
;wqqp: rvhn * zjlj
;pddt: 3
;psfp: 1
;jdjn: rhpf + dbpv
;wjlc: 3
;pdtr: rwqn + mjss
;pmrr: fpgp / wqsb
;npcq: 2
;hsds: 5
;vgws: 5
;qnbt: 4
;zjsm: 4
;zgws: 15
;djmp: 18
;qdqj: 2
;gvbg: 4
;jlpt: lqmq * bqvz
;mbhm: hzpb * mshr
;rcvc: 5
;fzcc: zqhf + pnvr
;tfsh: 20
;lwld: wtvs * vjgg
;scdj: 7
;spgv: tcdr + tfsb
;smlg: jmbd * fgzz
;pqpq: cfgt + mbvt
;llhz: vnjd * zcdd
;pgcf: 4
;dfnb: 5
;qtsb: rlrh * qzjn
;hpwf: wzwt + bzqs
;jrbz: njzz + sqhb
;jngh: 6
;jmhb: 5
;dhbc: qpqs + bbjs
;pvww: 2
;gttq: 2
;phjs: bnfj + mqbr
;brhl: fmdh * wnnc
;prqz: ptjp * nnfc
;hhfw: frvn * mrlt
;zlfh: 3
;mmps: 3
;mlgn: 2
;pbwr: 7
;dzbv: lvnr * sdgt
;tttc: 4
;bszz: 2
;lppw: cjbq + fjpl
;djcj: bdpp / tztt
;dtdq: 3
;fwwp: fhnv + fdsp
;mpnt: zppf + bjvs
;qnfz: 4
;jmdp: 2
;sdlg: lmqq + fbvb
;qbhz: lqds + qdcn
;hmnn: 9
;wfbn: cvdf * pcdr
;tlqj: tdnj + zmfh
;vfzj: 7
;ndnl: 2
;hqzz: bqdh + wbjp
;jjld: wppj + fmzc
;ndzz: 5
;lzdg: hjlw * bmgv
;nbrp: 2
;vjcw: gsbc + jfnh
;dsvn: 3
;gtzb: 2
;phhr: 3
;pslv: szqs * wzvt
;drvg: mvgh * pgqv
;vghb: 4
;vjrs: sldb + zntp
;fqhb: sqzs + fvcn
;cqjz: slwd + zzfb
;tnhh: zpzt * qzcz
;pnbp: mmlj * fgjs
;ttfs: mlfn + mvpv
;rzsm: 5
;tzmd: 7
;ljmv: drbt * ntrq
;stvb: 2
;dtmf: mgqb * dqbg
;cnbc: 4
;gppt: schn + tcjp
;qdgr: 3
;fhhp: ccwf + pdtg
;fbhs: 19
;cbsl: 3
;snct: 4
;vnjd: 3
;wstl: 3
;qsdt: gpgl + wlpz
;gljq: 2
;nlmg: bssw + hjzl
;pjhh: 5
;shzw: ljmv / rtsv
;cvjr: 2
;wzjs: 3
;mmlj: 9
;hsvq: 2
;gqwc: czst * rstl
;jljs: 3
;npmn: zgws * nmfv
;dvwb: dfgb + bvjv
;wplp: tgtq * wqmw
;zntp: plcs * frsq
;zshb: tnwb + bsfq
;llmb: 3
;djtf: qfwg + zdth
;tnjp: 4
;wzrw: tgwb * jzwj
;dgbf: mccf / fsft
;nbzq: 7
;qtjm: 2
;gzmb: 6
;tjvn: rcvc + sszv
;bsmz: 4
;vzmm: 5
;znnj: 5
;brfb: dtzn * rcml
;bdpq: vrlt * bszz
;rfth: 3
;prqw: nlwm * zzqt
;fdfj: nvcj / mmps
;jsfn: 5
;hcpl: tjtw * nrsf
;zqjc: lwls + mlzt
;csrl: 2
;stnw: 11
;cprm: sjtc * zlcl
;hndt: wzmg * cqpl
;srfr: 1
;zdvw: 5
;wqvr: pgmr * mllz
;dpns: mghl * mptl
;hrbc: lzqd + wzqf
;wwfq: 5
;hmcs: wzll + pctz
;wbzc: 4
;fjpl: 4
;cmcl: djvw / cfbm
;fzhr: 4
;sssj: 8
;zvmr: nrfs + vfsb
;rwtm: 4
;rbtv: 2
;mgsm: 2
;fqnr: qzqz * ncvs
;ndbg: zdfz * hwqc
;gsln: 3
;rgdz: trmh * clhn
;glqw: pvlz * pnpv
;tzph: bdbp * hjsj
;plcl: tzrh / cpbm
;gpgh: 4
;dbrg: 3
;zrbb: cggm + tffw
;jfqp: 4
;htfp: vchh * ffmj
;ggmn: nbsf * svbw
;vfqz: 7
;bdpp: dlfr + qtrc
;rwdw: ncfl * wjvz
;zfdl: zvpd * rfrp
;hcrr: 3
;hhdp: 3
;chnw: 4
;jqhz: mqqt * hcgj
;mvzs: prcg - bbzc
;mngw: pfgl * nppq
;vrqn: fbqw * tncw
;wzqv: gcpl + lppw
;nmdc: 7
;brsj: 3
;mmrq: jqtb / rssc
;qfcf: pnqn * fqwr
;nfbf: qchr + tlwf
;tbph: frmw + vgws
;qbld: 3
;gptr: cdvh * qbmm
;dqlt: 17
;gldv: 4
;rrhp: jhmc + sqnb
;pbrh: qlpf + mrqp
;vsnl: svjl / qqrz
;mhdd: 3
;bjtt: chwq + tclj
;hsdn: hhhj / nszz
;lzzg: 2
;vqmb: 5
;ghtc: 7
;vnzp: lbql + fnnq
;mngf: 2
;qbpp: ztnb * hpjc
;fmzv: 3
;vjgg: 3
;pnsc: ccwj + fqhb
;hltq: wjwt + lcrp
;btms: 3
;nvfs: dvwb * hbdc
;ztlh: jpbg + fhfs
;svzh: 2
;pnvr: znbv * nsgq
;sfvr: brfb * mdcj
;qfwv: rrcr * vznb
;wwnz: njsm - zhss
;lfcg: grcg * rbsl
;qtds: shtl + hcml
;zstq: 4
;djvm: hmgb * jntd
;zdjz: jghp + nvrs
;mggw: rbpb * gqcp
;bwjd: 18
;lcdw: brtp * jmdp
;shlg: qmhs * fqdd
;bszm: 3
;zpnz: 2
;tmwz: 3
;qvdw: 5
;sbtn: 2
;mvhq: rjwf - pbrh
;jqjq: cqjz * bqtw
;nrsf: 6
;zgcp: 7
;cjsb: 5
;gmhp: 2
;dltw: ltvn * tvmn
;sdmd: lfql * grzs
;vbtj: vdtd * wzmd
;gzlc: tcht * jlnp
;pllt: 3
;pdcz: zlqv * fnph
;vbpd: wvjj * qmvs
;qhcm: ffbm * nwcw
;ftfm: 3
;rlgc: vtzf / hfqb
;pmnd: zvbv + zzfz
;nppq: 7
;nsnb: grhc + lbnm
;ldjw: zpvj + llqd
;mlrh: ltzs * rbjs
;rtjv: nbzq * zvfn
;trmh: qgsw + pmll
;hfhc: hlfm * gtrb
;fvwl: mzhl + fgjm
;jjdf: ttlr / tnvf
;crrt: 3
;lhcs: llhz - gmfq
;jzcm: shpj * dzdj
;swqs: vlpt * jlrw
;grwv: 2
;jlrw: 5
;rwzb: 7
;zqcz: cjzz + rbqm
;zgzs: qsmn * jwdw
;zzcd: 2
;rjsj: fgqs + qtwf
;psbr: wsbl / hzhr
;hfth: mznc * jjld
;nqlz: srdv + hlsh
;wght: 17
;vnbv: 3
;tzbv: mrzv + pzzg
;bmlc: wjdr + hpqf
;qdcm: 3
;tfcj: lqsz * tlqj
;bvlt: gvth + hfvv
;gbdt: 3
;glnl: tzrr * bpnl
;pzzg: 14
;gvzz: 6
;ftqg: 5
;lvss: 2
;jpms: 2
;dtwg: mcvl + nftw
;sqvr: nvjc / vqjr
;rbsl: 3
;fblg: 19
;tvpt: vbdt + lszc
;ddfn: 15
;ztnb: 5
;rhwr: lwlm + mmth
;lthm: 4
;jhrc: pjdw + qphq
;dlbd: fwnq - jrcp
;dmrq: 4
;hhhj: 14
;zphb: rtbf * ssjb
;vvzh: jwch + qbpp
;fhth: lthm + tqgj
;fpgp: zzcc * rlds
;prcb: 2
;tmfq: rjqn / rjjg
;zbnf: cvzr + rlfj
;lgjz: 5
;flbd: tsgp * bzfh
;drsf: 11
;tdnj: blfb * hhfw
;dsww: 8
;sfnr: cmrl * mnrp
;rgvs: 8
;vdsw: 8
;gzdt: 3
;hndr: 2
;smnq: fmnq * thwn
;cltt: 2
;bccb: 10
;bjcz: hbnt + hclw
;srbb: 17
;hqdw: 3
;ntmq: mblh / mrbp
;fbcr: 6
;bjcj: 2
;pzst: rzsm * fqsh
;qnhl: pvth + vmzc
;fbgm: lnld + mszv
;sqhb: snct * mldp
;jcdn: 3
;qncq: 5
;pcdr: 3
;hdbd: 3
;srsm: 9
;mmdc: 3
;pzfg: mzlc * dwtg
;pchq: vsnl + bnnv
;cggm: 12
;dsnc: 2
;mghl: 5
;gtvn: vgdq + ftcm
;mrpf: jqbs * tpjh
;fplm: zpfz + mlvl
;grrs: 2
;dzdj: 4
;ztwz: nndq * chbr
;bzjw: 14
;dzjv: rbtv * tbfm
;tjfg: 2
;sdpp: hhwq / rhvj
;sbtd: 8
;bjmg: hjwg + dbwf
;dtcv: drmg * vttc
;tvnd: pjvb - cgjp
;dtfp: 5
;mgjt: 2
;sbgm: hjgv - wvzj
;dmcq: 2
;ljlg: 2
;rcml: 5
;jstr: 2
;lrrj: vlnv * fmcv
;mdqg: jrpq + sdhg
;qngb: zzpp * rqqs
;hbnt: 9
;smjl: wvgs * drrz
;nszz: 2
;rfrd: 3
;pdtn: gmcb + mqhg
;qqfr: 11
;hqpb: 7
;qcmm: 3
;qwqc: 2
;ftbq: ttdn * hgwh
;vznw: mmsc + svcb
;nwjr: 13
;lrgw: 3
;mnzr: 6
;mshr: qgfs + vwgf
;rvhr: rdtl - pprz
;csgl: 8
;mfvh: lhqm / bvwd
;fsjl: 3
;cvlc: jdzg / rgsm
;ztth: flbd + pscz
;ghdt: grvb * lsnw
;fqtj: 2
;vcwt: 3
;svvq: 2
;pjct: 2
;zvmv: 7
;sztg: pfjb + qgzz
;mvtz: 4
;bqvz: 2
;mjhs: 4
;ghpc: 7
;psrt: 4
;wsdt: rqsz * gnnj
;gfqn: 4
;cdrs: 5
;rgcm: svvq * cfdm
;rsdn: zdns + cprm
;ztjg: gjhn / tdpf
;vwmb: 2
;ffjs: 2
;rvhg: 3
;gmtz: 3
;fght: 7
;lftq: jzcm / srnt
;rbfm: gplw * ddbg
;bplf: 11
;vbcg: 2
;gldh: 19
;hjjw: 2
;gnbn: 2
;qdll: dpns * gpgq
;fcmg: pjpm + rvqv
;vwvp: 4
;hpwp: wbfd * gbwn
;gchq: mdrr + ppsj
;dtcf: 2
;drnn: gclt + tjvn
;pnnj: 11
;lhgf: 3
;wdsh: vcwt + sqht
;pnqg: rgbs + mlss
;ntjf: 3
;hqdq: 12
;wqmt: rctz * dlcf
;gfrl: 2
;shbj: nzng + jdnr
;jzpm: djlg / smpw
;qmhd: 12
;tdhl: 18
;rqsc: zhqp * mbfh
;mrqs: fjgs * bmwn
;ddjm: sjjq * blsp
;ljzj: hfnq + ldjw
;njbm: 3
;bgnr: ptgf * pnnj
;wsnq: 7
;sgzh: 3
;nwsd: gjlm * ngmf
;hltz: hlss * vmqn
;plrq: qrth + bwnt
;lbql: nqjs * vrst
;jcgc: 2
;frlb: qvwd + rsdg
;rqll: 3
;hjrv: 5
;pcwp: 4
;hwsh: 3
;zrrm: tjjt * znsz
;qspn: fplm * jwlz
;fmdh: 2
;gcqg: 2
;mlzt: 16
;rvqv: srbz * vdtj
;tvcj: qmmf * tvdp
;zdln: mwfv * rgdd
;tfsb: cfbj + rhjp
;jtjf: ztlh + fsns
;pssn: 13
;tdmn: zjvw + phwv
;wvvm: 7
;rmtw: 3
;jwgm: jcdh * jbbv
;sqpm: dzdg + mvhq
;rblr: bjdp * sbfd
;tljb: 12
;nfwq: 3
;smqh: 19
;bnfj: plcl + cbft
;vlfz: 3
;zbvh: ddlq + fdsj
;jwdd: vmvt + srqm
;wrrn: 2
;slmz: 14
;mvsc: dsnc + fjbv
;pwcm: 3
;bwvv: mvsc * jsrh
;grng: 10
;mlww: 13
;qsjg: wvvm * nbrp
;gfjg: 8
;rmgw: rrrf + jgtl
;pbvc: fzpc / srrm
;sfqz: lwhl + rwtm
;cmrl: 8
;vwrf: dwlm + ngff
;zrhq: 2
;ncvs: 5
;tgwg: 11
;lmdd: 10
;vjzv: ztgn + bjmg
;shnr: 9
;svdf: 3
;bbmw: 6
;wlnz: 4
;zpzt: 2
;njng: 19
;rtqp: phzs + ptbs
;hrtn: 7
;jpqg: zbcq + gzlc
;wdlv: wtqr * hccw
;vfjz: sslc + vrqn
;jvmh: smjl + zqcz
;mdnd: gfgv * rhwr
;wzbm: 2
;bbqm: 2
;qfwg: lcvl * wdmn
;pjdw: gqfb * wgzm
;lhfv: dbrg * mrlr
;jqlf: 11
;gglz: 17
;qbls: nflw * jbnz
;zlqq: 3
;ngll: vbqd * nqwn
;zmsv: gswz + qppd
;wjvz: 2
;qfwp: 2
;jzwj: 5
;tncw: czmz + vmnr
;pnpv: ppvz * drsf
;thcn: 3
;dgwv: 6
;lvln: cltt * phmh
;hqtc: nlmg + zbpn
;dwgd: 8
;mzjm: dbqd - gpls
;fjgs: llwq + qzcf
;jtbm: flbl * bdpq
;mvcs: 5
;gbvs: hvhq * ndvr
;cpvm: pcvr * jwpz
;vfng: bwcs * scmr
;bzcg: fsjl * bwhn
;httw: 11
;zbpn: jztf * rvmz
;jcmc: qvfn + pmpv
;tcqr: 2
;ppvz: 2
;qgqn: gwgc / mjhs
;dvbq: 4
;zmcq: fjcf - wbtq
;hzpb: qbld * vnlz
;tffw: vpbm / zbpq
;qmjw: 20
;qbwn: 3
;czmz: 5
;wjrw: 3
;nhgg: 3
;ztpz: 2
;wvft: fqtj + fnnt
;hwhr: 3
;jvbv: hhdp * vrzh
;tnth: 5
;qdqd: 2
;bpnl: 3
;vmlb: 17
;gmfg: 3
;zmnd: bnlh * jdgn
;ddvh: nwjr + mcph
;tqdf: 14
;fdrb: vspr + flvh
;wrtr: 16
;zqcn: 2
;lbvt: 2
;tqjf: trzd + mtsj
;wcmw: sjpr + zdjz
;lbgz: 4
;zmfh: 7
;wlpz: 4
;jrcp: 5
;hmpf: 2
;qqpt: 2
;rgsm: 6
;vzqj: nqlz + fbgm
;vzlw: 10
;gsjq: lrgw * ddhr
;nwcw: 5
;bghm: jrbz / wrhr
;rmms: rmgw * qvzl
;hgll: brfg - pnbp
;wmtn: 6
;nfht: 19
;dcpb: jstr * pthm
;wqbh: 4
;zrbq: 8
;nsjw: 5
;gpdw: 8
;rgph: nfnn + fhsp
;vjmm: 3
;nhjw: wbjt + dsll
;mzds: hppv * sptd
;mcrp: qsjg * jjqp
;qpjs: 2
;lbfm: tcqr + nwml
;wmfn: 2
;pfsc: 2
;mpsb: 2
;bwtr: cmbl - cmqd
;spdn: 5
;hcln: 17
;ggrr: 9
;rhvj: 2
;jhqw: 3
;zhnd: svfc - tddv
;rznj: fwsg * rglh
;rrtp: 5
;vbfm: 7
;tnwb: njnf + fqjd
;wzll: 17
;hcbg: dhbc / bszm
;vlhv: 2
;cnmc: cvmb * ftqg
;vwvr: ddfn + bbpp
;rtql: 11
;swcd: 4
;mwqp: 8
;vwlj: hghh * qdqj
;gqmd: 1
;mgfj: gmqz * bmlc
;nnfh: pwft + cpvm
;vwgf: ffsq * bsmz
;hpqf: 9
;zzrg: bblp * jdlb
;zzqt: 2
;fqsh: 11
;ccwj: qlsv + vsls
;wsph: 11
;sbfd: glpp + pcbd
;bzfh: 3
;hpjc: 10
;pqlm: hwlg * ftmn
;srgh: cfhl + dfht
;ttdn: 3
;hnqw: fqtq * znnh
;twdq: gssr / dgmh
;wdmv: cgzh * sbmt
;srnt: 2
;cqwj: jhqw * dsvn
;gqbs: 4
;jpcq: 9
;tzmf: jvzz + zqjc
;zwmv: dmrq * qcrr
;fztn: 2
;zshz: jzch * rqrz
;jwdw: 4
;mdcj: 4
;tdfl: shnr * ptgb
;hlsh: vzmm * qtjm
;fvdr: 3
;bdmh: zlbn + tnhh
;hwvq: 2
;zqcs: 3
;wlbv: dnsn * pmrr
;nbsf: hcvc + jzzg
;dssl: bjcj * gmfg
;nfft: 5
;pshs: 2
;njhz: 3
;wwbj: 4
;wdfr: bhlz * mvzs
;grrg: lfrw + hbdp
;jzns: lmtg + gnvg
;dnmf: jdfb + qtgr
;sjpr: hqvt + qqzq
;cbqd: 2
;sfcw: hnbh + cmfn
;spvr: 2
;tcfd: btpd / jchs
;pstv: tjjd * rmtw
;hvbd: dtfp * scsm
;zmwd: 8
;vmzc: dtcn + vhdl
;tztt: 2
;mccf: ntzd + mdnd
;ngzf: 2
;vtsf: 3
;gpls: jfcp * nrrl
;zwvp: 12
;qpqs: bscl + mrgm
;thcb: 2
;svfc: jzns + pqnz
;jrtt: ccmr * gwrw
;zsdg: fshp / vvtp
;tnnl: vzrj * tggm
;bsfq: nhjn + zshz
;qchr: wjhn + qnsp
;nsjv: spvg * hqdw
;mfnf: 2
;ccwf: tsjz + wjrt
;dgss: dwgd + cqlb
;nnfc: 2
;dtvb: 2
;rtvq: nvpp + lgzr
;hmgb: sbtd + pvww
;bzqs: czdz * vdnb
;gnml: vdcr * qmvc
;vlnv: tjvh + msqd
;mgqr: 2
;gfwv: sqbz * stvl
;wgtz: 7
;mpfj: 11
;tvvb: tdmn - ptbj
;tpjh: wrdf + vjrs
;hzbz: 1
;fvln: 4
;chbr: 5
;mjrr: 3
;tvmn: 2
;jhfl: 8
;wzht: 4
;rgmv: crzv + pngw
;pftv: mnlg - qbhz
;rtsv: 3
;nsgb: 2
;ljcq: sfgz * vbfv
;qzqz: 7
;sjmc: lnpp + ftbq
;qnsp: 4
;vlmn: 4
;fjhf: qpjs * gjsb
;mbfh: 5
;mcph: 18
;gspr: hwvq + sfqz
;rvqz: cslr * ffcj
;ngqn: rmtp + dtcf
;pzmg: zsdg + gpvg
;vspr: 15
;prpg: qnfz * qmhn
;zzlc: 3
;zfgq: 11
;zjmm: 4
;rlvl: 2
;wtvs: 7
;rctz: 2
;lvvj: 2
;npjd: wbln * zrjs
;wwwr: 3
;pdfr: 5
;njhb: 14
;wrsn: swhv + brrw
;vpbm: zqgr * cbsl
;gsdf: qqdp + lbrd
;bqgr: 8
;nzvs: mlrh + znth
;rnmn: 4
;wnnc: 12
;tvmq: lrfl * qlds
;nprm: fbjd + pmhw
;mvgh: 3
;shcr: vrvl * wwfq
;cfbj: 3
;hcvc: nbfv + bhhj
;vmzq: 10
;nmdq: 1
;lhll: 2
;wvjj: hndr + flbp
;gmqz: 7
;ffnf: njhz * vzlw
;gzsc: tcfd - qdrr
;cwbp: 7
;qphq: hlcp + ngqj
;lwhb: hlgn * qtbw
;mvff: 8
;nhnf: gsjq - csgw
;pqnc: 5
;fdfh: 4
;jhlr: 13
;bcnt: thhj * ndwp
;wnbp: 2
;bbbb: hjfq - clss
;lwhl: 7
;tbfm: dzqg + mnvz
;csrh: ftpp * nqmd
;pdtg: gpjw * dmcq
;bclm: 5
;cbft: jqhz + ltrl
;ltjq: rzpv * dmcm
;lngz: dnlr * dfnb
;mbhf: 2
;szfv: 4
;fmcv: 6
;jzps: 4
;hjfq: dcmj + btfc
;zwth: zmnd - jfdv
;rlds: vjzr * hjjw
;bvqq: pdtn * mlww
;wshl: dzjv / gqsq
;zjtl: 4
;spvg: btms * zqrh
;mptl: 5
;dcjb: 5
;mzvg: 3
;nsgq: 2
;mjdm: ltcm * mgqr
;qrgc: 3
;mnvz: 19
;blfb: 2
;gnnj: wjfv * crtd
;svrq: 2
;mrlr: gqmd + qljm
;frhf: dcjb + nprf
;wdhh: 2
;qjbw: jhrc + qfzh
;svps: lhfv * gvwd
;mcjz: 2
;nzqw: hvbl + glzp
;tmct: vhtm * hnqw
;phnj: qdll + nclb
;tdpf: sblg + tnjp
;qjlt: 2
;hclw: hqzz * jfqp
;bvnm: snvr - wmgj
;dnlr: 5
;rstl: 13
;ptjp: hhmv / hdqb
;fvdl: frtq * fwpt
;nggh: 2
;bwcs: bccb * qnbt
;chgr: qpfz * jtgm
;gfqv: zgfm * bzcm
;jwpz: hnzj + hmcs
;lqsz: frlg + fhth
;pvth: ccph + hbfl
;tjnj: 9
;shpj: dhbz + wmrb
;fgpz: 9
;frnc: 9
;sfhs: wjqc * bzjw
;nfms: 2
;dzvl: 10
;tsjz: 1
;sqfm: qqpp * jcgc
;dsll: 16
;lmpq: 4
;qhpl: 2
;zlnm: 4
;gvzc: bgtj + mcvd
;tlwf: qqpt * fdmz
;mfqm: rlgc + tjzj
;bpbw: 13
;szns: rmhb * mfpd
;hcgj: qjlw * qtds
;wbjj: 4
;jsdj: 6
;wzwt: hndt + ptsh
;drbt: 3
;flpt: 16
;tmzd: crnj + dqlt
;swzn: 15
;flbl: 6
;zlsd: 8
;stzw: nsrq + bdvb
;lndf: 3
;ldsm: brsj * vgnj
;sshh: 10
;mwzb: 8
;gdrg: 13
;ltwt: czht * vhrz
;wrhr: 2
;wnbw: dlqs + jvrp
;vzgg: jnbb + qdrj
;rwqn: 3
;fmzc: 4
;mjss: 3
;dszg: zzln + jtfn
;ndvr: hdbd * qdgr
;trsd: 5
;wjrt: 5
;gqjg: bvww * zcbq
;fgvz: 2
;vjqb: vlzz / csrl
;mddr: 1
;zzbb: fjqv - pvhf
;vhdf: smqh * qrgc
;bnvb: qwwp / ngzf
;cqpl: 2
;znts: nqcf - fcdp
;gdhc: 15
;hgpv: 3
;djvw: nnfb + dtcv
;frvn: 2
;vqjr: 2
;zjnn: 2
;zstj: 3
;vtzf: ptvt * jhlr
;bbzc: nqzw / qtzl
;ffpf: 5
;ghcq: htwh * mqpw
;zlms: 1
;zfrm: gglz * lfns
;tgwj: 2
;jjpn: 5
;hccw: 3
;qlgr: 3
;sjjl: 7
;vwss: nvzr * gmtz
;rvhn: 2
;qjfh: 2
;sgsj: 3
;sslc: dmws + hgpm
;jcfr: 3
;jsld: 14
;gbwn: 14
;qqdp: rvzd * nwnr
;lhdt: 5
;rgnn: lzzn * jpms
;ddlq: 6
;mqzt: swzn + cblh
;tnfg: 10
;clss: 2
;zrdl: 9
;jzch: 4
;qjsz: 5
;rrcr: llmd + qjtm
;dlcf: qspn - bsln
;bttm: 4
;mzvl: 3
;qjgl: fhhp / fphm
;mfpp: 2
;szqs: 5
;plnm: hlmd + nslp
;gvqg: pzqt * sbgj
;glpp: lrnq * rqsc
;jjdl: jdlz * zffq
;bdvb: 3
;tnwg: swcd * zcnf
;tnvf: 2
;srdv: 3
;ljbl: 4
;vlfq: zwmv + thcn
;cnll: 3
;hgwh: svzw + dgwv
;mszv: 19
;fwdq: bbqm * pgcf
;nqbg: 5
;mgqd: ctnd * gnqp
;gsbc: gtvn + whzg
;lcvl: 3
;pmll: fcwz * tzbv
;jjvn: zmwd + srfr
;gsnr: 10
;qfgt: 5
;wcpn: 2
;lpbn: 2
;tjzj: 5
;jzwh: 1
;ltvn: 5
;vphl: lgjz * tpts
;tgwn: wvlm * hqtc
;gltr: fjvr * qvdw
;qztw: czfw * gfrv
;mgmj: 6
;zvls: 2
;lnpp: bngp * sssj
;wvtj: ppcd * wllp
;cncv: 11
;vvtq: 2
;zsvh: jpcq * wcfq
;jcmn: fjhf + cftz
;czmw: mpfj * bzft
;jgtl: nfht + mvtz
;jdnr: 2
;ldtd: zwrp + wbfg
;vlvr: fgbd + hlnh
;rhnq: 7
;cgzh: 2
;zwbd: 17
;lfrw: 5
;wcmp: 2
;wmgj: tdng * tbph
;tfvm: rlvl * fdcj
;cwlj: rwdw + tvmq
;ffmb: 11
;rvfv: rqll * sfwf
;whlp: 2
;dcmj: 3
;vvrs: hrfp / gpvn
;mzhl: 1
;sqsz: wspv * jdjn
;dmlv: 3
;zwmt: rrtp + zqcn
;plsp: 4
;tclj: fvdr * jsrz
;qmhs: 2
;fgzz: fwdq - cdph
;vgnj: sglw + drnn
;tjtw: 2
;pdbd: lhzc / vghb
;bmqb: 1
;jnbd: 8
;gzlt: 3
;snhr: 1
;gnpm: rznj / szzr
;ltnd: zdwj * wgtz
;jddv: zbms - zsvh
;nwml: qwwj * lhgf
;tddv: 11
;psdp: nbqf * mzhb
;fmrf: jtvr * hggs
;pqqm: 4
;qbnm: 2
;fbvb: 4
;jnlb: 6
;dflw: fvln + djgh
;vdcr: cqgd + ngmh
;lwls: mnww + wggh
;hwqc: 2
;vbdt: qfwv / whht
;jdch: gnsr + qdqd
;hdqb: 3
;sbgj: 2
;qtbw: 2
;srzs: 1
;svbw: 5
;wtqr: hzbz + zbvh
;tqcc: ffnf + dvbq
;gvwd: 3
;gbsg: rcrb * hwhr
;nmms: nmmj + mvqv
;nqmd: fdrs * npcq
;nmdp: gcnm - zcmc
;cvmb: fblg + qmhd
;qmmf: 5
;sbvw: llfl + fvpl
;sbvq: mpfb + qtwg
;vhqv: 3
;sbdq: rpzr * wznw
;tlnc: rbtz / bmnt
;gntg: mlcg + stqm
;qzjn: 5
;cvzr: mzjm / lfqz
;sqht: rvdg * bpbw
;qwmp: hwsh + tttc
;hjsj: 3
;bcqm: cqfp * czmw
;mwgs: 2
;qcqp: qhnr / ddtt
;wwzg: dqlv / dlfp
;lrww: tlrn - wzrw
;wfwj: jhlp + jwhm
;pvvr: 3
;blvg: 3
;dhhc: 3
;ghdc: 2
;jvmb: rvwz / fhdz
;lwws: vfss * wcpn
;fvpl: 1
;glmm: nvvg + mgqd
;bdmp: 4
;znnh: 3
;gddz: 4
;jlcl: 5
;blsp: 2
;mnww: gpwj * lhcs
;jwch: ltlj + sqvr
;wbfd: 2
;fdmz: 17
;gfrm: 6
;wsvq: 2
;bhfg: 2
;tcdr: dqcj * qlgr
;dqvg: nmms + dfnt
;stnz: 2
;dgsr: 17
;zsjl: qfcf / mvcs
;nwnb: mjdm + jnfz
;crqr: gptr * jvqm
;sgrn: 14
;zlgp: 5
;cczp: 5
;qtnf: gwgv + lwhb
;gswv: jqpm + ppcq
;ftmn: 2
;tcqh: hzhp + mgfj
;tfmf: nqjd * cfjn
;fczw: wnvf * wfnw
;pthm: 3
;vlqv: 2
;mpfn: hbbj + tsqp
;hrfp: gnpm * zlwb
;ptsh: mjdz + cfqt
;pdvq: 8
;zqpz: 7
;gnvg: tfvm + wvft
;dqfd: tzps * nsnb
;vdtd: 7
;sfwf: bjhs + hsbb
;cslr: 3
;wcjj: rgnh * cntm
;smwb: bmqb + mlsl
;zzpp: 5
;qldw: jbll * dgss
;mlsl: vfqz * cczp
;gcpl: dhdh * zvmv
;gmcb: 14
;wmbw: 2
;llqd: 6
;dbrj: 4
;qtwm: gmsb * jwnm
;jghp: 5
;dgmh: 2
;btfc: 16
;ffsq: hvhc + psfp
;flvh: scqm - fmjb
;hqvt: bvzb * crrt
;pwqg: 8
;dsgf: vhnw + dlbf
;szrr: wbjs + bcqm
;gsmn: lhds + jlpt
;vbqd: vvhj + rnth
;hmvl: vwvp + srdb
;zptt: 7
;gpvn: 4
;cdmw: bhfg * bnvb
;rhtf: rrth * szrr
;brtp: hqdq + wfcn
;zdns: ljsl + wdlh
;qgsw: njhb * jgpd
;hjjs: 5
;mznc: 3
;ndwp: bsvp + bzpb
;tltv: 7
;wbjs: djzc * mcjz
;grzs: jvgp / pnqf
;bqnp: 2
;qtwg: mppd * trgw
;bsnm: prcb + vlmn
;mbwj: 5
;jwht: 4
;nwjm: qhcm + htfp
;znth: nvfs / vtsf
;tdwr: jlmr * fdrb
;sjdh: zpww * cjrp
;gwgc: wdhh * sqfm
;thhj: 2
;qrvc: 2
;mrzv: 15
;nnvc: 10
;qwmt: wjrw * hltq
;czst: 2
;rjsp: gpgh * mdcm
;ffmj: 3
;fvgq: zgqp / zlqq
;mtwt: 4
;lzzn: 3
;zdgr: sqng / qpjv
;gnhr: 13
;hgcv: 10
;dwtg: 5
;lgzr: 1
;fzff: wqbh * vjbg
;fhnv: qhgt + tprf
;wgzm: 7
;cdqg: 4
;ztjb: 4
;trvj: shdd + qcqp
;hhqq: nhqs + lcrd
;scsm: bhrv * zphb
;wnqb: ldzg + mddj
;wcmj: lrwj / vwrp
;nbvw: ncds * sffg
;mwwh: 2
;qrth: ghdt + bhtv
;cjrp: 2
;dsgs: 5
;gqsq: 2
;snvz: vsgm - rdqq
;ctlh: qrvc + lfhg
;qqzq: mbhf * mdqg
;hsbb: nmdj * sbtn
;zlwb: 4
;pmps: 3
;vmbv: 3
;svnm: vznw + tlnc
;mgqb: wsvq * fdfh
;vgfs: hfbv * ldtd
;tzrh: wdsh * blmg
;rwdz: 13
;hbdc: vtqq * rvqz
;hlpf: glws * nnlv
;gtqt: pbpn * frlb
;vfss: nmwz + cttl
;fnsb: qcmm * vwjf
;ttlr: bzlp * fdll
;jfnh: 4
;cgjp: jztd * mgjt
;hglc: 2
;rdsp: fmrf - tfgq
;pdcd: 4
;fjqs: qdjw * mwbf
;cpbm: 3
;qsmn: dtll + dclt
;crjc: 2
;bgfj: 3
;bjdp: 4
;tltm: czqz + stpz
;wfcn: 1
;bwnt: 18
;zmsj: zmrd + znts
;qjrv: 15
;jfsr: 5
;mdcm: cncv * gvbg
;vcqw: hclz + drld
;flbp: 5
;crnj: 6
;sngb: 5
;hfvv: sgsj * zzlc
;gnvh: 2
;jvrp: 7
;hfbv: 3
;lshv: 4
;cjsv: qpff * wdsp
;phwv: 5
;phzs: 9
;hvhq: 4
;vzrj: swql + wqwm
;lfns: 4
;slwd: 1
;ftbt: wsgm * dcqv
;sqwh: 5
;pfcw: 2
;lfhg: 9
;mlcg: dmhs * qvsg
;nzng: njbm + jnjb
;snvr: crqr * tdcr
;tqvq: tmct + fcmg
;lhlb: 4
;sqnb: jlwv * phbv
;btmv: 2
;sdgt: 9
;mswg: zgjr - qlhw
;ftmj: 2
;qghj: jnhr - mzds
;qtwf: vmlb * dprf
;zzln: 1
;nblb: 5
;zjll: 2
;lrzb: 2
;wvlm: 2
;gpgl: zlsd + fltn
;jdfh: 1
;dzqg: szfv * ftsj
;jvzz: sfpc * ggcc
;ptgb: wtdw * ndzz
;wsbl: qprz - cvlc
;gnfn: qvtf / tddp
;wlnv: 2
;qmqd: 4
;cflm: 3
;vhvf: jjwh + tgwn
;rpnq: 2
;zpfz: dtwg * qztw
;dcpj: 2
;hcml: 3
;rjqg: rtvq * jhfl
;qzjw: wqbq * twwb
;wpzp: 17
;mddj: ffmb + hhnw
;dpjg: 5
;zpww: gfph + nzwz
;srdb: 4
;cfvn: mbpf + bwvv
;vznb: 13
;ghbf: qphz * bjtt
;ngmh: vjcw / vhlz
;nqnq: 3
;dtzn: 2
;wppj: qjhb / qfwp
;jbtz: fwqf + hsdn
;sjtc: 2
;qhgt: fqnr - grng
;bssw: dnzv * fswb
;rnjh: qsrh * hrqh
;qfpz: 5
;fwnj: djcj + rwwr
;zshw: 1
;gfnm: lvwn + jjvn
;lsnw: 8
;sgqn: 5
;bjhs: dlbd + snhr
;nmwz: sqwh * frsz
;sfpc: 3
;blbl: 2
;rgdd: ctmf - bcjz
;mfqs: wsdt + gdrg
;zpvj: 1
;tdlf: 4
;dhbz: 2
;dbpv: 10
;ltzz: qtdn * hvgc
;dvmb: 8
;pngw: gwzn - gnfn
;nlzm: 3
;mrbp: 2
;wvzd: 5
;wvqr: gsdf * gwml
;nbfq: 8
;nvgj: hspq * jtrm
;qqlz: 5
;mnqc: 18
;nrfs: ghdc + sgqn
;nzqp: cmld + trwg
;nvrs: 5
;cfgt: 4
;ngff: 17
;hdfn: 5
;wbln: zjtl + dcpb
;wthh: 2
;nsrq: fvwl * zjll
;jqlg: sgjw + qzjh
;zdth: vjzv - dpwr
;fhsp: 9
;sbhf: 2
;vhvp: tmzd + qqqf
;qnmr: mswg * sjjl
;fvhw: psdp + ngll
;vggg: 4
;wdqd: bmzm * lpts
;ftbs: mggw / chvq
;shdd: nsbg / vdzs
;wqcl: sgnf * lvvj
;htdp: 16
;dpwr: 4
;rhmb: 4
;rlwn: 2
;rwth: sfpj - vnzp
;fqtq: 2
;nnlv: pbwb + zsjl
;nljf: zscd * ffbr
;ftcm: 6
;pqnz: mddr + mtgg
;htwh: 5
;zwmh: 2
;humn: 120
;nsqr: jvmh / vjmm
;djzc: wvhm * jzpm
;lhqm: gntg * rddr
;jwhm: 1
;wjfv: 3
;dqbg: 3
;bsdn: 3
;hhwq: 14
;hvgc: 2
;gmsb: 2
;pjpm: grrg * nsjw
;rhpf: nlzm + dltw
;tvvv: hpwp * stnw
;wdmn: 2
;sjsf: 2
;jlwv: jsdj + vcdp
;tsgp: 2
;bgtj: 18
;vmbp: jjdl + qgrs
;zzpb: mfcc * rmwv
;qrgl: 5
;htfq: 2
;jdgn: wthh * ppqb
;wznw: 3
;fsns: lznd * fvhw
;wbjb: lcdz * rnmn
;svpd: 3
;zznz: zbzf * sbrq
;dfgb: 15
;tcht: 5
;fdcj: 6
;nfzg: nfft + dvpb
;jhmc: stnz * qqfr
;ntrq: 7
;bbpp: 18
;vchh: 3
;bsgt: jqlf * blfg
;nvpp: 5
;nbfv: ltnd * vwmb
;drld: hpph + rrgj
;vwsv: fdht * rblr
;tggm: 4
;rrth: 2
;mtsj: mfnf * bltd
;hbsd: 2
;wbfg: 16
;bvrg: pzzs + qbcm
;nqjd: rhzt + zmwz
;sbjm: jhnd * zhlh
;vjcr: 11
;ggsv: 4
;gshr: 2
;gwml: 2
;zvfn: 5
;bctf: djtg * vwrf
;mwgj: 5
;vdtj: wwnz + bnvh
;rjpm: 2
;mlfn: 5
;gmtf: wgwc + frqd
;jthh: tnth + bfhp
;qprz: wrsn / zwmt
;pzzs: 9
;djgh: hqrp * npnp
;zzcc: 3
;zwfb: 5
;blfg: 3
;dlqs: 7
;znmm: 5
;cjzz: zwvp * vvrs
;pctz: mfqs + stzw
;jzql: fmzv * vhqv
;lvzj: tqfd * nbsj
;mmhs: 3
;lngh: 18
;jbnz: 3
;cmrz: 4
;tjvh: hbsd + wjwp
;bfnd: czmv * wpzp
;mvpv: 2
;wdtd: zpqq * rfcz
;gclt: 14
;lmwj: 1
;qfpf: ftmj * bvnm
;lnld: qmzq * drvg
;clhn: 2
;gpzb: cvjr * dbrj
;pcbd: hfrg * wngj
;sqbw: rdsp * ftvq
;sqzs: 11
;nfnn: 4
;gnqp: 10
;sgjw: 3
;nfpz: 2
;bfhp: 1
;tbhm: 7
;rlbw: hlcm * tdfl
;grhc: tzmd * hctq
;bsrr: 18
;nvjc: glmm + thcb
;ltll: tvcj + mbhm
;dlbf: trgg + ggcv
;stvl: crjc + tfgr
;nclj: 19
;cjcv: 3
;hctq: 7
;flnz: 5
;zppf: plzw + wmlq
;zwdg: 4
;cmjc: 4
;msmb: 2
;jchs: 2
;fshp: jrhf * msjq
;bzwh: pnfh * dhhc
;sgnf: 4
;fhtf: 3
;scmr: btzq + hqhd
;gqfb: cjmd + tpjs
;chfr: gfqv / pjct
;qrnl: 3
;wvgs: gshv + psbr
;plnb: 2
;lhzc: sqpm * chnw
;nclb: vwsv + mrsb
;dght: 10
;ffbr: vmfv * jltr
;qvwd: hmpf * wsgr
;vhnw: gldh * mqql
;zbdm: 3
;hhwb: humn - bwns
;wgct: gjvw * plnb
;mbpf: 1
;zhpw: 5
;qdvf: lqdg * rlwn
;jhgm: 5
;wzhb: 3
;czdz: shbj * dsgs
;rjqn: vhdf - rgcl
;wgwc: gppt * phpn
;vjzr: tbtl / vrvd
;fgjm: zjth * qrnl
;mgcb: nzll + pccp
;gtmp: mjrr * ljcr
;mlsg: hfhj + qvqm
;mllz: rlrr + djvm
;hvfz: gtmp * tqdf
;ffdv: 9
;dfnt: cflm * cnmc
;qnmp: ljzj * zlfh
;ggcq: 2
;qglg: 2
;fjqv: slhc * hpmp
;glws: 7
;hlgn: jzps * dncl
;rvzd: 3
;sntl: hpwf / mgsm
;cfdm: rgph * gnvh
;wvzj: srzs + prpg
;nhqs: 16
;mrdl: wgsn / llln
;nftw: 5
;dgbp: 3
;mhvv: sbdq + stpt
;qsdf: 3
;dfht: hcln * cwlj
;wdsp: bclm + wqcl
;ddtt: 4
;spqb: 8
;fmjb: pbvc * zvdn
;zbzf: vbpd + nldt
;hspq: gvzz * hmvl
;jrpq: pfcw * dzrj
;bngp: 2
;rnvt: jgjj + dsbs
;lscd: bjcz * nfpz
;hhmv: vlfz * wnqb
;hcqr: lvss * vwpt
;thzg: sgnn * dmmg
;nscj: 4
;sjst: fdfj - jjpn
;fgbd: pslv * gghb
;hvbl: 5
;frlg: 16
;qhnr: nzvs + wdfr
;bhbc: qwst * qfpz
;rsdg: bqqt + wsdw
;fvcj: 2
;nlsq: wdlv * nggh
;czqz: mnqc / nwwj
;rmhb: 9
;rqsz: 2
;bsln: cwwb * tfcj
;lnlt: 3
;ptgf: 5
;mppq: hhqq * fpts
;qqjm: 6
;wjmt: wwcj * vqmb
;zqfd: 12
;tlbq: zqfd * jfsr
;mfcc: llbc * ltfq
;jtrf: dqvj / nwbm
;hjlw: 3
;fjlh: vfng - zzrg
;ljsl: 1
;fphm: 2
;cjbq: bhsg - ztth
;wjwt: phqg * mwqp
;rzrr: wzhb * blvg
;cpsg: 3
;dfqq: 19
;czht: 4
;qmvc: 5
;vbcw: blsj * qdcm
;jfcp: 9
;lqmq: fhjg * hhmn
;ljcr: lwld + hstg
;gmfq: 2
;qtdn: zwbd + gbsg
;dtvd: 2
;wwnr: jqjq - rwth
;gzhc: frzv * mrlw
;vsdh: 2
;wzmd: 6
;gngm: vplv - cpnq
;rssc: 2
;mvqv: tzph + mfvh
;gwgv: 5
;djlg: rfth * fdlj
;tjpw: fgtb + shcr
;jcvq: 5
;rqjq: 2
;nfsw: 2
;rwwr: qqrp + tzbf
;zgvg: 2
;stpz: 4
;rfcz: 3
;hvhc: jcdn * bwtr
;rddr: 2
;fhjg: 3
;fnph: 16
;mblh: dvmb + nlsq
;trzd: nwsd * snvz
;cdph: 2
;tdjj: 5
;stqm: hjrv * pjhh
;svjp: dfqq * sqpz
;hpmp: cpsg + nhqh
;ctnd: 9
;swql: 16
;tgqv: 3
;vrpr: mngw + tqgh
;gjsb: 17
;tsqp: 2
;hbmr: pwbj * fzhr
;mppd: 2
;sbrq: 9
;vgdn: 5
;gpgq: qjsz * jpqg
;jllt: jwgm + dvfm
;cpnq: 20
;vbzl: 2
;rvwz: dnmf * jnbd
;tjzt: 5
;sjrf: 3
;hsnd: lfcg + bcfm
;hpph: 2
;nlwm: vbtj - bsbl
;dzrj: wfbn + mtwt
;gtrg: 4
;fbjd: sfnr - qrgl
;jnqq: 4
;bvzb: 5
;tbtl: mzgw * nhgg
;jmbd: bbbb * zrpb
;zzfb: jhnt * mcwj
;svcb: 18
;mrfp: llmb * ddsl
;rgfv: bwpn - ldsm
;pfjb: 10
;tfvf: 4
;fjtw: 3
;bzpb: 7
;fgtb: qjbw * drjf
;pddj: vbjq + zdln
;plcs: 3
;bscl: svjp + qtsb
;tqgh: gzhc + vfjz
;mlvl: qtwm * jvbv
;gpwj: 2
;bqqt: 2
;qzcf: dcpj * ngqn
;mzgw: ctmw + cbqd
;sbsv: 2
;lrfl: qfgt + qbnm
;ddrd: 2
;jtgm: 2
;llln: 2
;sgzf: fvdd * rcsd
;wspv: 4
;ftcz: fmsz + qngb
;schn: 3
;lfqp: rjqg + wwbj
;fvwp: 2
;hphn: 1
;dcfn: 4
;wqdn: smlg / lshv
;rbqm: 1
;btzq: pfwq * srrc
;pjvb: czvm * rnjv
;htrw: 5
;nvcj: lcgw + gfnm
;gqcp: wcmj + zgzs
;llmd: 12
;ctlg: 3
;dfdc: httw * pdtr
;mtpw: wmbw + ggrr
;mrqp: rgvs * trjl
;tljh: 2
;sgnn: trpv + phcg
;qtrc: dtvb * bcnt
;pprj: lvzj + vtvm
;wjhn: mmdc * wsph
;fpml: 5
;wfct: lrzb * zhnp
;njzz: 2
;ggcv: hrtn * lggz
;wsgr: 5
;ptbj: 1
;prlr: rqjq * rvhr
;qzcz: 3
;sppr: rjpm + jlcl
;gctq: tzmw * zmtv
;vcvg: vzqj + nsjv
;grgv: gzlt * htrw
;pgmr: jhgm * gpmm
;nldt: lnlt * crhz
;svsp: sghz * tljh
;nqwn: fdzp + slml
;fpnf: wjms * jllt
;qtvw: 3
;jdlz: 16
;bltd: ghbf - vrpr
;lggz: 3
;wqmw: 12
;vhdl: ltjq + mcrp
;tzbf: wvqr + nscj
;vhrz: 2
;fgqs: vvtb * fczw
;jjwh: 5
;sjjq: ntcg + qldw
;tlrn: mrfp - pzfg
;lfql: 8
;zjpm: zzpb + pgtz
;wqwm: wjlc * hqpb
;hggs: 8
;cqsd: 3
;fdlj: 19
;rqqs: 2
;qsrh: 2
;mcjf: nbpd * djsh
;nljc: 5
;nqcf: fnvn * zvzf
;rcwz: 3
;vgdq: 1
;zgqp: fwnj + rgmv
;cfqt: vlhv * fjlh
;bhlz: 3
;gzpt: sdlg + hphn
;wjtv: 17
;mqpw: 5
;fjns: 12
;bdbp: 4
;njzj: sdpp * lwrl
;bdft: mtjz * tmwz
;bflh: 4
;zzfz: 1
;mrlw: gwrz + wdtd
;cqgd: tqhn * hssr
;dqjg: 3
;vtqq: 2
;ldzg: shlg * rjnt
;bcnh: vgdn * wght
;vvtb: cwfh * gttq
;jsrh: 2
;grll: mttn - hcqr
;hqrp: 5
;bgqd: fnqf * nmdc
;hhnw: nppv * mpcg
;qpjv: 4
;bhrv: fsvt + sngb
;frtq: 19
;ntzd: plnm * nwnb
;pqpm: 2
;dmws: rlbw + fpnf
;hjzl: pssn + mssq
;mszt: vpdp * zwth
;wwts: 5
;htzb: gsln * zvls
;pccp: 6
;cfhl: wnbw * tbhm
;qppd: mjwr * rhtf
;lvhb: hsvq + fhmh
;dwlm: vgfs - ddvh
;qvzl: 2
;ccph: csnr * fght
;mwdg: sprd * spdn
;bhsg: mtjs + bwzd
;qvnp: cbbj * wqdn
;nnfb: rgdb - vlvr
;fdrs: 4
;gjhn: ghpc * llbf
;zbdl: 2
;rmlr: pdcd * qwmp
;vtjb: 5
;jzvc: scdj * rjwc
;vwrp: 3
;ppqb: wmfn * pdvq
;drjf: 2
;mtjz: qnmr + dfjb
;dfjb: wgbr * bsgt
;rzpv: 3
;gdwj: 17
;cfjn: 2
;qrcq: 2
;lpts: 4
;vrst: 19
;hfdb: 2
;zlqv: 2
;hbdp: 2
;dzvd: hcrr * bvlt
;gzgb: gltr / nqff
;bmnt: 2
;trgw: 10
;vdtp: 6
;nndq: 5
;zbpq: 3
;wrdf: sjsf * vjlh
;mldp: 3
;qbcm: pfsc * dclj
;qmhn: 2
;jfdv: vphl + hbmr
;fvdt: 8
;qlpf: 5
;ccmr: cqgs + lldc
;cmqd: 3
;vjgf: mrrc + rmlr
;msjq: 2
;czfw: 3
;znbv: 13
;snbd: 5
;qshf: 3
;lwlm: 1
;rhjp: 4
;drcl: 5
;jrhf: rgcm + dflw
;jdlb: 6
;dgpc: 3
;ttnp: 3
;frsz: vggg + srsm
;fnqf: 2
;nqff: 5
;phmh: zvmr - zrdl
;mpgz: tgwg * fbbr
;qqwq: 10
;nrrl: 20
;swvg: 3
;vrhn: pzst / hjjs
;hpnj: lftq + cbbh
;lvwn: vrhn * gjfd
;gwzn: fvgd * tnft
;ptzw: jggt + zznz
;cnzr: 5
;dlfr: drcl * dght
;ptvt: 8
;llbf: pddj + glqw
;gghb: 9
;gnsr: 5
;sqpz: rtjv + grcz
;tbnc: dcfn * htzb
;fcwz: gnqz + mbwj
;ccnc: pqnc * nblb
;wllp: 5
;bvww: 12
;gnqz: gshr * jwht
;bbjn: dbfn + lhlb
;dqfq: ttfs * fwwp
;cmld: ndrd * lndf
;pcvr: 5
;hnzj: tltm * zmpt
;rdng: 16
;ngqj: dmlv * bgfj
;mqbr: jddv + tcqh
;hstg: 16
;bvwd: 2
;brhv: 5
;wfnw: 3
;fmsz: 17
;ggvt: 1
;dzpr: lzdg + gsnr
;lzqd: qqjm * vdtp
;qdrr: rnjh * rtqp
;frzv: wdgw + pqlm
;czvm: zfrm + dqvg
;whzg: fjns + hcpl
;zhlh: 3
;rcrb: 2
;ptbs: 10
;lnrh: 5
;jsrz: nvgj + tvnd
;brfg: qbpq * wlnv
;svjl: rjft * hptl
;rjjg: 2
;fdll: 4
;hlnh: vlqv * ddjm
;glzp: 2
;bblp: bzwh * bfgb
;fbvn: 5
;ltlj: tgqv * fmzt
;vqpg: 3
;mmth: 8
;ctmf: plww * mwzb
;plzw: lmwj + jngh
;jqbs: 2
;hwqg: gtzb + wbzc
;qzjh: gvzc * grwv
;ltzs: 3
;dcqv: 2
;rpqj: 2
;zmpt: 2
;cdvh: 3
;qjhb: nclj * mfpp
;frqd: 4
;lszc: zrbb * fzff
;lhtl: 3
;tpjs: 2
;tjjd: 3
;nslp: svsp + gntq
;pvhf: 20
;qvqm: 4
;djsh: fnvb + nfwq
;vrvd: 3
;mlss: ltll * flnz
;nswp: fjqs + qtvw
;qvqg: cwbp * wngm
;pgqv: 2
;htng: lvhb + cdqg
;rfrp: 12
;nwnr: 3
;gbbc: phhr + bpbq
;wqqd: 4
;pmpv: cmrz + cnbc
;bdsr: cjsb + zrhq
;fqvv: 3
;znsz: wlbv + rdjg
;pzqt: ttlm * qjlt
;lmtg: 10
;jffs: sfhs + tdmf
;phpn: bsdn + dplv
;jcrs: 4
;dclt: jcmc + jllj
;jqtb: zdgr - phjs
;crhz: 7
;tgwb: 5
;fswb: 5
;rnjv: 17
;vmqn: 3
;njnf: 5
;bcvt: btmv * thzg
;llwq: tnnl / ztjb
;bwzd: rrhp + lngh
;sghz: 11
;tjjh: jthh * fcqm
;jbbv: rhbj + nbfq
;rglh: tlns + zjsm
;wsdw: vwgb * ttnp
;rdjg: 15
;lcrp: 15
;ppcq: tfvf * pfws
;fwmb: 6
;rwpf: dgsr * grrs
;vrlt: 3
;zvbv: 12
;dtcn: grgv * fgpz
;frmw: 17
;fdht: 5
;nzll: 3
;nqjs: 3
;gpvg: wlvs * tfsh
;jjqp: hmnn + fpml
;fqjd: 3
;rgbs: qwmt + csrt
;rrgj: gnhr * ztpz
;jfwt: 8
;bgfc: 4
;ggcc: 2
;bjvs: 18
;jpbg: sbdn / zpnz
;mrgm: vjgf * blzt
;fzvq: hbbc + pngv
;ntcg: bqnp * mnjh
;wvhm: cdsl - zbmn
;tpts: 3
;znvf: 6
;fnnq: smwb + jvmb
;vjbg: jrtt / mwwh
;ltfq: 3
;dzdg: lhtl * nprm
;sqbz: 6
;cbbj: 2
;mdqr: 3
;vhlz: 5
;zbmn: 8
;gfph: 8
;pfws: hfth - ddlg
;mjdz: rvfv + hfdj
;zgfs: 2
;sffg: 3
;sjhb: 5
;vmfv: 2
;zscd: 2
;mdrr: nfdd + snbd
;vrvl: sfzm + chfr
;hbbj: vqpg * sztg
;fvcn: jlwt * pcqg
;hjgv: jtrf * pqqm
;tlns: bwjd + zlms
;sldb: lfqp + jfwt
;gjfd: 2
;fwbm: gnml + dfdc
;hlcp: 2
;wwcj: 2
;phcg: vvgf - mjhq
;jfhl: ggcq * jnnh
;vrzh: 2
;wbtq: 4
;qsng: 2
;zrpb: 2
;rcsd: 10
;gpjw: tljb + mwdg
;cfbm: 2
;wzvt: 5
;pcqg: 3
;lqds: zjpm / qhpl
;lldc: 1
;qdcn: sbsv * qnhl
;mtjs: pdfr + vvzh
;qqrp: fwmb + hvbd
;nsbg: tlbq * ntmq
;pphp: dsgf * vjcr
;mtgg: wmtn * nfsw
;qjst: bfnd * swwr
;mmsc: qnqh + ltnm
;lvnr: 7
;jhlp: sjst + gfrm
;vbfv: 3
;ddbg: 2
;zjth: 2
;qwwj: 7
;rhbj: pbwr + pwqg
;zpwv: dgjn + pvvr
;llbc: vbcg * gfqn
;wmrb: 9
;lpff: 7
;wbjt: 13
;dsbs: 12
;jhlf: fzvq + zrbq
;frvr: 5
;sptd: 10
;nppv: 2
;bmrf: szns + fqmp
;ssjb: 5
;qfzh: tdjj * twdq
;rhzt: 5
;hbfl: 9
;hlss: bbmg * llbb
;wngm: cdqj / vsdh
;lrwj: rjsj * vnbv
;fmzt: 7
;gtrb: 2
;hsht: lnbw / wlnz
;dqlv: lshc + cmcl
;gbdp: 1
;vfsb: sjhb * bzjm
;hlcm: npmn + gswv
;pwbj: 3
;zzcv: 3
;jnvw: fvcj * vpbt
;cwfh: qjgl - vlfq
;gbst: 2
;fbwr: 3
;glss: rmms / gbst
;zhzz: nfbf * ctlh
;jqpm: zrwt * nhjw
;pscz: zrrm / pdtw
;lcdz: svrq * pmhz
;mbtq: bsrr + bhbc
;tgtq: lmpq * zjmm
;bqdh: 4
;zlzw: 8
;rbjs: rnbh - zhzz
;srrm: 2
;djrr: 3
;zpqq: mdqr + cqwj
;jdzg: lwws * tdhl
;vplv: qgqn - fcsw
;prcg: zqvn * vjqb
;csrt: bdft + srgh
;nzcm: 12
;srbz: 2
;qvsg: 3
;wddg: cswj + ptzw
;fctd: 5
;qjlw: 2
;rldc: 2
;ddlg: htfq * spqb
;hfdj: tgwj * wfwj
;ddst: 13
;tcjp: 4
;rnth: vhvp * ljbl
;wnvf: 2
;npql: 3
;qpfz: vmzq + tbnc
;qnwt: ljcq * njng
;zccs: 11
;mlcb: 4
;mpcg: hgcv + hbsz
;rqrz: 2
;rgjz: 1
;wdrc: 3
;dbvp: wstl * mpnt
;fwnq: 15
;hppv: wpnr + bcnh
;msvs: 8
;vjlh: gppd * msvs
;rqcz: 7
;grcz: 6
;hzhp: vwvr * pqpm
;gwnm: dgbp * cnll
;vwpt: lbgz + djrr
;sprd: 5
;jntd: 18
;nhqh: 10
;vttc: npht - jqcs
;zrwt: 12
;bmgv: 11
;wjwp: 4
;qmzq: 3
;cntm: 3
;zvzf: ldmr * qmjw
;mwfv: 7
;jtrm: wrqh + tjpw
;rsgv: 3
;vwjf: 2
;nbpd: 7
;zdfz: tnfg + jzwh
;ngsh: 3
;qlsv: brhl - dssl
;trgg: 12
;nwbm: 4
;qdjw: pdhv * zgfs
;tddp: 9
;jwnm: bfjs - sgcd
;slhc: 13
;wtjn: 5
;bbjs: srbb * rdng
;mzlc: jzvc / shzw
;svcq: 3
;lmqq: 4
;mcwj: 3
;vcdp: 13
;sszv: fvwp * rgnn
;jztd: nljf + ztjg
;hnpq: 2
;cblh: nzqw + vcqw
;rrrf: ghtc * gfjg
;rmwv: wqrw + rwpf
;ltcm: 3
;nmfv: 2
;wgbr: nfds + dzvd
;dbbq: lrrj + dnlg
;sgcd: jcvq * rnvt
;qdrj: mtpw * ctlg
;pfwq: 7
;wgsn: rfjn * gngm
;vnlz: 3
;tdcr: wwzg - nzqp
;ftsj: vwlj + nljc
;qtgr: rdfv + dwmg
;gwrz: mwgj * tmjz
;blzt: snlj + bdsr
;rzlh: 3
;stpt: wbjj * sbvw
;root: gqjg + rpjv
;hlfm: 14
;smpw: 3
;fbbr: 2
;tjjt: 2
;vbjq: mpgz + djmp
;ppcd: 7
;tmjz: gnbn * jqlg
;rchc: hffq / wvzd
;hclz: plsp * vbcw
;nflw: nsgb * tltv
;fsft: ggvt + tcfb
;fbqw: zhwb * wwts
;zrlz: mltq * lhll
;phqg: 7
;gvth: 1
;fdsj: 2
;fjcf: fvdt + jhlf
;rgcl: 3
;jlmr: mlgn + ftcz
;ddsl: grll + rbfm
;bsvp: 4
;jrws: 7
;rmtp: bzwm * qzjw
;fltn: fbcr + sqph
;lqdg: dsww + dpjg
;wlvs: 4
;tfgr: 4
;mcvl: spgv * ddrd
;bcjz: 3
;hjlh: fnsb * gtrg
;bqpn: fvdl + pchq
;czmv: 2
;qtzl: 2
;qlhw: sgzh * zlgp
;plww: 2
;djnj: rwdz + nqbg
;dqvj: gzmb + prlr
;szzr: 3
;wsgm: 4
;ddhr: 3
;lfqz: 2
;vcrv: bgqd / wnbp
;chct: vwss + dgbf
;bpnp: gsmn + bbmw
;dgjn: brqf + wrtr
;hwlg: vzgg / wsnq
;vdnb: 5
;hssr: 2
;svgg: vbfm * tdlf
;fwqf: 3
;dncl: pwcm + bflh
;llfl: stvb * wqqd
;ldhp: svnm + sbgm
;hghh: rzlh + wdqd
;lrnq: 3
;srrc: pdcz + pqpq
;vsls: 8
;vvhj: tnwg + ldhp
;jggt: wbjb / ftbt
;fqdd: 17
;zgjr: wzbm * mbtq
;bnnv: zzcv * rqcz
;jbll: 3
;zcdd: 3
;bwpn: ftbs * cplt
;lzvs: 3
;crtd: rcwz * fbmd
;fpts: 2
;dvfm: bvrg * rgdz
;cbbh: 1
;llbb: vcrv + mgmj
;gssr: jsld * hsds
;jftw: prqz + fflt
;jhnd: 2
;wdgw: cjcv * wshl
;fnvn: 5
;msbv: stsg * bqpn
;chwq: pftv * lcdw
;pmhw: 2
;bhhj: 3
;jnnh: tvpt - jnvw
;pbpn: 2
;lbrd: djtf + sjrf
;rdfv: 5
;csgw: 2
;bnvh: flpt + jrws
;cmfn: vpjc * mlcb
;zbms: djnj * jzql
;mzhb: gtqt + ggmn
;qnqh: 5
;dwmg: zlzw * zlnm
;vmvt: sqsz * jftw
;qvfn: vmbp / zstj
;zjvw: 2
;wrqh: rfmv * cdmw
;jbfl: jtbm + zptt
;sglw: sbvq * rpqj
;npht: hgpv * lbfm
;lznd: 2
;zlcl: 11
;fcdp: qqwq * ntjf
;bbmg: 3
;mfpd: 5
;nbqf: 5
;phbv: 3
;qwjg: ghcq * tmfq
;vdzs: 2
;ltrl: pprj + wvtj
;rbzv: gzpt - spng