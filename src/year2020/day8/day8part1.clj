(ns year2020.day8.day8part1
  (:require [ysera.test :refer [is is= is-not]]
            [clojure.string :as str]))

(defn string->ops
  {:test (fn []
           (is= (string->ops "nop +0\nacc +1\njmp +4\nacc +3\njmp -3\nacc -99\nacc +1\njmp -4\nacc +6")
                (list [:nop +0]
                      [:acc +1]
                      [:jmp +4]
                      [:acc +3]
                      [:jmp -3]
                      [:acc -99]
                      [:acc +1]
                      [:jmp -4]
                      [:acc +6])))}
  [string]
  (->> string
       (str/split-lines)
       (map (fn [line]
              (let [[op val] (str/split line #" ")]
                [(keyword op) (read-string val)])))))

(defn day8part1
  {:test (fn []
           (is= (day8part1 "nop +0\nacc +1\njmp +4\nacc +3\njmp -3\nacc -99\nacc +1\njmp -4\nacc +6")
                5))}
  [string]
  (let [ops (string->ops string)]
    (loop [acc 0
           idx 0
           visited #{}]
      (if (contains? visited idx)
        acc
        (let [visited (conj visited idx)
              [op val] (nth ops idx)]
          (condp = op
            :nop (recur acc (inc idx) visited)
            :acc (recur (+ acc val) (inc idx) visited)
            :jmp (recur acc (+ idx val) visited)
            acc))))))

(comment
  (def my-puzzle "acc +0\njmp +516\nacc -16\nnop +326\njmp +366\njmp +400\njmp +494\nacc -5\njmp +475\nacc +29\nnop +24\njmp +186\njmp -5\nacc +50\nacc +49\nacc +49\nnop +507\njmp +236\nacc -4\nacc +50\nacc +48\njmp +293\njmp +461\nacc +48\nacc +2\njmp +241\nacc +38\njmp +544\njmp +1\njmp +382\nacc -4\nacc -10\nacc +44\njmp +444\njmp +1\nacc +20\nacc -1\nacc +25\njmp +332\nacc +18\njmp +184\nacc +1\nacc +20\nacc -7\nacc -12\njmp +84\nacc +30\njmp -19\nnop +491\nacc +37\nacc +44\njmp +220\nacc +3\nacc +19\njmp +485\njmp +222\nnop +264\nacc +4\njmp +151\nnop -36\nacc +48\njmp +356\nacc +28\nacc +29\nnop +397\njmp +168\nnop +115\nacc -13\nacc -11\njmp +470\njmp +201\nacc +48\nacc -6\nacc -18\nacc -13\njmp +442\njmp +266\nacc +10\nacc +30\nacc -7\nacc -8\njmp +380\nacc +1\nnop +106\nacc +9\nacc -11\njmp -79\njmp +166\nacc -9\njmp +300\nacc +39\nacc +1\nacc +27\nacc +26\njmp +367\njmp +291\nacc +18\njmp +100\nacc +25\nacc +43\nacc -8\nacc -12\njmp +475\nacc +15\njmp +492\nacc -5\nacc -12\nacc +35\nacc +25\njmp +360\nnop +301\nacc +32\nacc -1\njmp +436\nacc +21\njmp +109\nacc +1\nnop +230\njmp -113\nacc +24\nacc +12\nacc +13\nacc +27\njmp -52\njmp +476\nacc +15\nacc -18\nacc -13\njmp +323\nacc -10\nacc +35\nacc -6\nnop +377\njmp +8\njmp +430\nnop +50\nacc +33\nacc -1\njmp -72\nacc -19\njmp -92\njmp +1\njmp -87\nnop -120\nnop -34\njmp +159\njmp +183\njmp +1\nacc -4\nacc +49\nacc -4\njmp +73\nacc -18\nacc +34\nacc -8\njmp +403\nacc +32\nacc +0\nacc +0\njmp +390\nacc +19\njmp +305\nacc -15\njmp +176\nacc +3\njmp +36\nacc +29\nacc +21\njmp +1\nacc -17\njmp +144\nacc +16\nacc +4\nacc +49\nacc -7\njmp -65\nacc +28\nacc +2\nacc +23\nacc +46\njmp +278\njmp +424\nacc +45\nacc +7\njmp -49\njmp -50\nacc -11\nnop -121\njmp -140\njmp +1\nacc -8\njmp +206\nacc -7\njmp +1\nacc +20\nacc +30\njmp +375\nnop +312\njmp +111\nacc +23\njmp -15\nacc +27\nacc +46\nacc +36\njmp +360\nacc +1\nacc +25\nacc +29\njmp -137\njmp +177\nacc +15\nacc -13\nacc +48\nacc +29\njmp +76\nnop -174\nacc +27\njmp +214\nacc +4\njmp +120\nnop -165\nacc -16\njmp +2\njmp +238\njmp +224\njmp -154\nacc +12\njmp +162\nacc +31\nacc +26\nacc -13\nacc +18\njmp +173\nacc +38\njmp +1\njmp +199\njmp -202\njmp +127\nacc -12\njmp -42\nacc -12\nacc +36\nacc -4\nacc +24\njmp +343\nacc -17\nnop +277\nacc +13\njmp +56\njmp +41\nnop +92\nacc +32\njmp +182\nnop +111\nacc +0\nacc +29\njmp +219\nnop -234\nacc +0\nacc +31\nacc +49\njmp +216\njmp +247\nacc +24\nacc -10\njmp +218\nacc +14\nacc -19\nacc +14\njmp +11\njmp +82\nacc +5\nacc +28\nacc +35\njmp -93\nacc +24\njmp -210\nacc +39\njmp -107\njmp -150\nacc -7\njmp -185\nacc +25\nacc -15\njmp +63\nacc +14\nacc +50\njmp -7\nacc +13\njmp +298\nnop +69\njmp -268\nacc -5\njmp +66\njmp +48\nnop -1\nacc +38\nacc +3\nacc +46\njmp +259\nnop +235\nacc +4\njmp -186\njmp +94\nacc -16\nacc +6\njmp +287\nacc -19\njmp -221\njmp -69\nacc +8\nnop -102\nacc +31\njmp +204\njmp -81\nacc +12\nacc +21\nacc -8\nnop +151\njmp -155\nacc +50\nnop +145\nacc -6\nacc +0\njmp -296\nacc +16\nacc +30\nacc +11\njmp +254\nacc +0\nacc -8\nnop +162\nacc -17\njmp -144\nacc +6\nacc +2\nacc +32\nacc -5\njmp +21\njmp -77\nacc +38\njmp +117\nacc +27\nacc -11\nnop -203\njmp +201\njmp -305\nacc +40\nnop -330\nacc -7\njmp -279\njmp +60\nnop -163\njmp -53\nnop +115\nacc +24\njmp +1\nacc +45\njmp -92\nacc +0\nacc +13\njmp -302\nacc +25\njmp +208\nnop -293\njmp +5\njmp +1\nacc -13\nnop -272\njmp +62\nacc -4\nacc +32\nacc +49\njmp -124\nacc -19\nnop -246\njmp -353\nnop -349\nacc +13\nacc +21\njmp -165\nacc +14\nacc +37\nnop +28\nacc +7\njmp -308\nacc +11\njmp +71\njmp -139\nnop -19\nacc -7\nacc -3\njmp -302\nacc -2\nacc +1\nnop -43\njmp -280\nacc +10\nacc +9\njmp -358\nacc +39\nacc +16\nacc -11\njmp +1\njmp +142\nacc -15\nacc -17\nacc +9\nacc +11\njmp -172\njmp -90\nnop +135\nacc -1\njmp -379\nacc +39\nacc -13\njmp -57\nacc -3\nacc -7\njmp +1\njmp +80\nacc +7\nacc +11\nacc +30\nnop +69\njmp -140\nacc +11\nacc +7\nacc +3\njmp -417\njmp -314\nacc -6\njmp -6\njmp -224\nacc +0\njmp -131\nacc +7\nacc +33\njmp +20\nacc +32\nacc -14\nnop -375\njmp -394\nacc +8\nacc +47\nacc +29\nacc -6\njmp -381\nacc -8\njmp -353\njmp -108\nacc -16\nacc +21\njmp -329\nacc +13\nacc +0\nacc +0\njmp -402\nacc -8\njmp -307\njmp -308\njmp -358\nacc +38\nacc -19\nacc +33\njmp -276\njmp -114\nacc -6\njmp +55\nacc +16\njmp -244\nnop +22\nacc -7\nacc +19\njmp -154\njmp +18\njmp -50\nacc +31\nacc +50\nacc +2\njmp -260\nacc -16\njmp -135\nacc +50\nacc -9\nacc +50\nacc +27\njmp -323\nacc +26\nnop -249\nacc +46\nacc +3\njmp -474\nacc +50\nacc -7\njmp -78\njmp +1\nacc -6\nacc +6\njmp +94\nacc +47\nacc -3\nacc +13\njmp -485\nnop -499\nacc +35\nacc +35\nacc -1\njmp -259\nnop -486\nacc +48\nacc -4\njmp +23\nacc +33\nacc +37\nacc +10\njmp +61\nacc -1\njmp +1\njmp +1\nacc -8\njmp +61\njmp -237\njmp -164\nacc +39\nacc +38\nnop -302\njmp -468\nacc -15\njmp -6\nacc -9\nacc +1\nacc +41\nacc +48\njmp -285\nacc +1\nacc +24\njmp -111\njmp -90\nacc +46\nacc +21\nacc +43\njmp -103\nacc -9\nnop -5\njmp -274\nacc -13\njmp -262\njmp -39\nacc +43\nnop -463\nacc +15\nacc +23\njmp -176\nnop -305\nacc +2\nacc +28\njmp -198\nacc +15\nacc -18\njmp -473\nacc -13\nacc +9\njmp -46\nacc +1\nacc +43\nacc +6\njmp +10\nacc +24\nacc -3\njmp -424\nacc -1\nacc +47\njmp +1\nacc +20\njmp -17\njmp -59\nnop -19\nacc +42\nacc +47\njmp -9\njmp -576\nnop -148\nacc +0\njmp +12\nacc -15\njmp -209\nacc +13\njmp -442\nnop -548\nnop -62\nacc +22\njmp -92\njmp -516\nacc +8\njmp -301\nacc +1\njmp -146\nacc -15\njmp -366\njmp -440\nacc +17\nacc +25\nacc +28\njmp -240\nacc -2\nacc +25\nnop -68\nacc +14\njmp +1"
    )
  (day8part1 my-puzzle)
  )