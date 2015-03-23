(ns tinydd.metamodel-test
  (:require [clojure.test :refer :all]
            [utils.model  :refer :all]
            [tinydd.metamodel :refer :all]))

(deftest race-test
  (testing "Race API"
    (let [M0      (new-model)
          N       "race-1"
          [M1 R1] (add-race M0 N)
          M2      (remove-race M1 R1) ]
      (is (= []   (get-all-race M0)))
      (is (= [R1] (get-all-race M1)))
      (is (= N    (the-race-name M1 R1)))
      (is (= []   (get-all-race M2)))
      )))

; (run-tests)





