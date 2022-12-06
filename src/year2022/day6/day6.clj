(ns year2022.day6.day6
  (:require [ysera.test :refer [is=]]))

(def day6-puzzle "hqhnqhqshhslswsffchfcfbblvlblqlggfwwqfwwqdddbbbhzhjjrqjqbjqjwqjwqwhwrrmcrrjqjjlllcvcrrnpptzpzmmswmmzrzjrrfcrfccpbpzzvrrdndllttwftwwgzzwhwggdvdnnlrnncscbcfcctchcdchdccztzgzjjtdtcdtcchrrgpgzgsgpsggvtvppdccfhcfclfcfdfnddlbbptbtdbtdtjdjgdjjzljlssgbgcgqcqzccfnftfjjsgstggsngsscvssjzjnjtntvnvssrqqhtqtvqtvvjbvvbnvvqvmvrmmdsdvdwwnbnvbnvvcgvcczcfzftfsfrfsfttldtdrrgrgmgbbdvvbqbhqbqlqsqbsbpbgbvgbgwwrswrwrwttvnnzdnzzwggrmrfmmvllzwlwzzlvlbvllgsllpnlnvncvcvqqrwwcmcczhchzczbccdwcwvwzwwvddlwlhljlqjqnncntnctczzmwmlmccpggljlssqswsmmpvmvwvrrcpcrprmprrtdrtdrrsjsmshmmdpdlppbnbvvmmflmmjvjhvhjvjsjbjwjvvblvbvlbbllwlslvljvlvdvdgvgcchnhpnhnvhhtfhhvssczztlzzgvvqqghqgqssdscsnsrsmrmmwgwmgmlmdmggbgzbgzgdzdzccghgfgddtntftddpdrdrmrjmmmzttqmttnwngggtgtqtqnqhnqqpnnntrntrnnshhjtjzzfqqblqqlblslflmlttcwtwzzrlrnrcrrrgtrrftfhthzhggwggvgvvfvddcnddfjddzqzrrvtrvrfrrgpgrgngsgddlmddzgzppdzzjzhjhjhqqbpbvvlrvrsvrvnrrsgsttndnbngnppmlppvgvfggvcvrvnnsnfnnfqfwwppnddrrfqqgbqqfmmlnlnngwgcgjgnjgjsgjgqjjnccdttpqttswwcgcmgmccrppmqmbbfwwvdwdfwfjwfjjblldsdrdvvgcvcwwllfpllcslsvssnvsnvvhnvnvwwcgwccslsbbnlbnbrrrtprptpdpdvdttgsgwswppcdchhqbqcbqbzbgbbstshthsttqgtqtpqqzhhwhghwwmbbdlbbtlltsllbvbnvvmqvqtvqvttlwtltmmrttwgtwwfdddwcchtchhbthbbclczzqbzzpvvwzwswggjddntnrnnwmnnbdbmbccqgqvvsnvvqbvbzvvzmvzzrfrlfrfhhdvddnmnnmhmqhhrhlrldljlbljjgqqvdvhhgmgvgddmmznndmmhssznsswvwdvdzdhhscssntnftfmmrggbmbmgmlltctbtbntnqqscqcscrcrhrlhhdchhzccvvbfvvpfffbwbsbjjmgmwgmgppjnpjphhlmhhpwwhwzhhhzbbzzcbchhpnnptpvphhsdsccffqbqllchlhlwlcljlppnccqsstzstswtwwljwjmmpttvqqspsjjclljqqlhqqtnnbrrsbrbjjllrmrjmjzmmclmclmmcvvbddhnnmhmbbwqqqhrqqtqmqbqdbdtdvvcscshccmffhqffdgdcgddljdjbdbjbdbrrtjjtnntpntpnpmnpmpgghffrnfrnnmdnmnhmmjcjffftrrttfwfvwvcwwrmwmpwmmnvntthmmgmbbcdclcppjhpjhjwwlppgsszqqwggmttfrfqflfsfmmmhchshmmjtjjgdjjnnsvsmsnwcgdfqljmnphlfdrhpggfqnhnszgpndhdqcgfhtdcgbsbtmhvnnrmqzqqcjdqndzbnrhwjvbvcldmnwltgpqbmstntnggtbqjzzqrfdsfttdfrcnsrpwrjrjqbgtjfmlwsrzdbdqvbtczgsjqhtgmctjfmdglfrsvqtgwpbqghzgzdfwzhbdhlmhdvhwjrdhhtjptvwpmjnmfcjdmdczmczvdqwvbgtvlwvwnvdlbqfshmlmvzzcmjbtpwpwgsqhfsgljzhbppcztfjdntzcvllqnzrqjwfjrlgvhmbpvbtqjrdzcsmcjzcdsmvcmhrbhgnscnfrfmscqsqpqplbrzhsrlsvvpmfdtdmtlrtvspmlljmfpshfmstjgnrrwmqlbnwbndcfdstrtqtnzpfqlcgrzmsnmhllljdgtmvftjttbwhqzcqwbwdbshgcqrptfjwbbfsjnvzztlbdchqrlbbrcnsswmhwphfwrbnvrncbrthprmltlwwlfpbqhdfqzwwcwjgqzdnvmhwpzpbtpwwvzcpfcsfqpwjljzzfwzmlfvhsccppzlzjlrvlpdtjpcptnvqjwtdbzrqwnfwmmjndflqqggczrfjlpdfjffctprnmhfdqvnzbfvhszzdmngnlmwzfdrbvlvjnmbllgrczssqcrhbmnpmqlrzgmqmhgsvcdlqnmlhlzvqzhnccbctslzlbcpdvqltqncpcrzwdchrqmwfwlcbcvfnnpjntfrznqdjsdtzqjjttddwvnfqmznhflblzvvtbwdzrrlqlmndzzzwnpbhhlvlbswfjtbnhlccscbnfgjtwbfdlwvzszwnwzhlbcdpvgqjcrpzsvvnfwqcqvrmhzhggvmzwggdpbfrdscjwhsdsbbjcnzldhzcvqtjrhsbfjlrlpvtcqhnnsvslfrdjvjhfhdcfzqchpvvhzbpqglqlrdttrdtndzhnzhtqndghtgmpsnhptprqzhbbdcrgmbvrvqmbptqgnmsccwmhrlpddvmhjntllwrzqwnsjchnblcgndjtmpswwgcstdftqcbhzgttrhnpvrhspjznhhvrlpdqbzzrvzjphcswhljdldvsrdhzltwgrcsvqwnhtqqjjrjgrplzmsnjhzrfbtqgdfgnbpvjrfzrrpdphgzrfbswdhzgbzswqtwwdtrvvswmjvwhqddfzjhgdqsfnwbmlcfwtmpldrdpwjwggbpmncvbghzjmpsqpvnmbhjfzzpsjdgmrtnndhzrphjzdbgrrnthtrfnspdngbdmwbnfjlsndqswfsvfqftqlgqjpfsfpmdbsjfrptvbpvflqgvlmmbchhghhrwmvdlrhlsdtvjjchwglcrwfsfnnbhjbtccbjsfwrbzrvgsbfnvzghhrqblqchjvdtrrbrwwwmfnczzmmrqdggsfrqbldbbfbbcthtsvpcnlbjjztwvhctbrjltqdwbzmrrfslbmjpnqwllbvjzgfsfqqtwbgwgclgdflshfhwggwdqlgbmdmdqglrtfwbddtsltmsvswhgjtqwtnrncpdzhnpfqcjnjzmtbjfzpjwgfbfggmsmfdhfbjctnhchpgfspthdbfpmvrmdbbspvwzqqwnmfwdnnblbcjszbccgflngnjjwsqshfbhjwgzrmvsgnrdbgwfhdvpmznpnvznfcqdclztcptjrrpbmpztwwbvlvtmngfhmfbfmrjbjzlrcvgllrlgthltstnwmffntqrwsrndlzqhztwpcwbdjjztgdzmgtthcvtvnjzzhvstfqhgddddgdsrbcqzqspjrncphhtbnslzphrtfqphffjrrlgwbrwqfzzqvzhnffcwvrncttgplshccglvchvlcbnlthhmzvcrfjvjqfsjjzzgqlpslfwngqnbgcwffpcqhlmlhvwssrpjbrcbftpzbbpptzrdqwpzpdjhtwbvwcqbfnwtflfgzgttglpcwdnzsmjffgfftdnpzlpszmzrrhvlzdfpgbzqlvvfslnndcmjvvpwzwcdzpcttfwbsdswmfqbbhbfbjvbvtspbbhmphzjsjcmmzpvvzhtvzlgwlqqvbnrgtszvghjfmchrwwhpmbsvfmgvqdtmvdtjppchbsgqrtgtnzczqmpgjdbmmflfpjbcdmhldwpgdtdvsbzhztjzfhcsbndfjntbldjnqwdffqspfnlplbtcdjtwdjhldtsdfrnmpfhzghnpcqlhhgblmqjvwhndqfbccvzzlbzbdprvcpwjjhrqnjptwssbjhgvpgtfzqwrzjvbdgwtnmptvdjrffcmbzmzcmrfbjv")

(defn day6-solver
  [text size]
  (->> text
       (partition size 1)
       (map-indexed (fn [idx characters] [idx characters]))
       (filter (fn [[_ characters]] (= size (count (into #{} characters)))))
       (first)
       (first)
       (+ size)))

(defn day6-part1
  {:test (fn []
           (is= (day6-part1 "mjqjpqmgbljsphdztnvjfqwrcgsmlb") 7)
           (is= (day6-part1 "bvwbjplbgvbhsrlpgdmjqwftvncz") 5)
           (is= (day6-part1 "nppdvjthqldpwncqszvftbrmjlhg") 6)
           (is= (day6-part1 "nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg") 10)
           (is= (day6-part1 "zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw") 11)
           (is= (day6-part1 day6-puzzle) 1760))}
  [text]
  (day6-solver text 4))

(defn day6-part2
  {:test (fn []
           (is= (day6-part2 "mjqjpqmgbljsphdztnvjfqwrcgsmlb") 19)
           (is= (day6-part2 "bvwbjplbgvbhsrlpgdmjqwftvncz") 23)
           (is= (day6-part2 "nppdvjthqldpwncqszvftbrmjlhg") 23)
           (is= (day6-part2 "nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg") 29)
           (is= (day6-part2 "zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw") 26)
           (is= (day6-part2 day6-puzzle) 2974))}
  [text]
  (day6-solver text 14))

(comment
  (time (day6-part1 day6-puzzle))
  ;"Elapsed time: 4.882642 msecs"
  ;=> 1760
  (time (day6-part2 day6-puzzle))
  ;"Elapsed time: 14.44654 msecs"
  ;=> 2974
  )
