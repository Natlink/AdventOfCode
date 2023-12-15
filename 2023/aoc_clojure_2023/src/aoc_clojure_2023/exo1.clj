(ns aoc-clojure-2023.exo1
  (:require [clojure.string :as string]))

(defn get-number [line]
  (let [numbers (filter #(Character/isDigit %) (seq line))]
    (Integer/parseInt (str (first numbers) (last numbers)))))

 (reduce + (map get-number (string/split-lines  
                            (slurp "./resources/input_1.txt"))))

(def numbers-string-int {"one" 1
                         "two" 2
                         "three" 3
                         "four" 4
                         "five" 5
                         "six" 6
                         "seven" 7
                         "eight" 8
                         "nine" 9})

(defn string-to-number [line]
(-> line
     (string/replace "one" "o1e")
     (string/replace "two" "tw2o")
     (string/replace "three" "thr3ee")
     (string/replace "four" "fo4ur")
     (string/replace "five" "fi5ve")
     (string/replace "six" "s6x")
     (string/replace "seven" "se7ven")
     (string/replace "eight" "eig8ht")
     (string/replace "nine" "ni9ne")))

(reduce + 
        (map get-number 
             (map string-to-number 
                  (string/split-lines (slurp "./resources/input_1.txt")))))
