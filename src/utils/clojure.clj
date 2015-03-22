(ns utils.clojure)


(defn throw-if-not
  "return a function that return FN applied to args if not nil, else throw an Exception with message MSG"
  [FN MSG]
  (fn [& args]
    (let [R (apply FN args)]
      (if (nil? R) (throw (Exception. MSG)) R) )))
