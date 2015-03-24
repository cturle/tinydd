(ns tinydd.metamodel-test
  (:require [clojure.test :refer :all]
            [utils.model  :refer :all]
            [tinydd.metamodel :refer :all]))

(deftest race-test
  (testing "Race API"
    (let [M0      (new-model)
          N1      "race-1"
          N2      "race-2"
          [M1 R1] (add-race M0 N1)
          M2      (update-race M1 R1 N2)
          M3      (remove-race M1 R1) ]
      (is (= []   (get-all-race M0)))
      (is (= [R1] (get-all-race M1)))
      (is (= N1   (the-race-name M1 R1)))
      (is (= N2   (the-race-name M2 R1)))
      (is (= []   (get-all-race M3)))
      )))

; (run-tests)





