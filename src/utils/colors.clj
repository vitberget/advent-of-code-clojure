(ns utils.colors)

;; Ansi shell 16 colors

(def reset        "\033[0m")
(def clear-screen "\033[H\033[J\033[3J]")

(def black        "\033[0;30m")
(def red          "\033[0;31m")
(def green        "\033[0;32m")
(def orange       "\033[0;33m")
(def brown        "\033[0;33m")
(def blue         "\033[0;34m")
(def purple       "\033[0;35m")
(def cyan         "\033[0;36m")
(def light-gray   "\033[0;37m")
(def light-grey   "\033[0;37m")
(def dark-gray    "\033[1;30m")
(def dark-grey    "\033[1;30m")
(def light-red    "\033[1;31m")
(def light-green  "\033[1;32m")
(def yellow       "\033[1;33m")
(def light-blue   "\033[1;34m")
(def light-purple "\033[1;35m")
(def light-cyan   "\033[1;36m")
(def white        "\033[1;37m")

(defn rgb [r g b]
  (str "\033[38;2;" r ";" g ";" b "m"))

(defn goto [x y]
  (str "\033[" y ";" x "H"))


(comment 
  )
