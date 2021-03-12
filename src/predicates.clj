(ns predicates)

(defn sum-f [f g x]
(+ (f x) (g x)))

(defn less-than [n]
  (fn [k] (< k n)))

(defn equal-to [n]
  (fn [k] (== k n)))

(defn key->predicate [a-key]
(fn [a-map] (contains? a-map a-key)))

(defn set->predicate [a-set]
  (fn [x] (contains? a-set x)))

(defn pred-and [pred1 pred2]

  (fn [x] (and (pred1 x) (pred2 x))) )


(defn pred-or [pred1 pred2]
 (fn [x] (or (pred1 x) (pred2 x))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
(or (nil? string) (empty? string) (every? whitespace? string)))

(defn has-award? [book award]
(contains? (:awards book) award))

(defn HAS-ALL-THE-AWARDS? [book awards]
(let [helper (fn [x] (has-award? book x))] (every? helper awards)))

(defn my-some [pred a-seq]
(let [filtered (filter pred a-seq)] 
(if (not (empty? filtered)) (pred (first filtered)) false)))

(defn my-every? [pred a-seq]
(let [count-seq (count a-seq)
      count-filtered (count (filter pred a-seq))]
  (== count-seq count-filtered)))

(defn prime? [n]
(let [pred (fn [x] (== (mod n x) 0))]
(not (some pred (range 2 n)))))
; if there are numbers in between the range 1+1 n-1 dividing n, then n is not a prime number
; because it needs to be divisible only by 1 and itself

;^^
