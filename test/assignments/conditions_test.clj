(ns assignments.conditions-test
  (:require [clojure.test :refer :all]
            [assignments.conditions :refer :all]))

(deftest safe-division
  (testing "non zero denominator"
    (is (= 2 (safe-divide 4 2))))
  (testing "zero denominator"
    (is (nil? (safe-divide 3 0)))))

(deftest informative-division
  (testing "non zero denominator"
    (is (= 2 (informative-divide 4 2))))
  (testing "zero denominator"
    (is (= :infinite (informative-divide 3 0)))))

(deftest harishchandra-test
  (testing "any truthy value"
    (is (= 4 (harishchandra 4))))
  (testing "falsy value"
    (is (nil? (harishchandra false))))
  (testing "falsy value"
    (is (nil? (harishchandra nil)))))

(deftest yudishtira-test
  (testing "any truthy value"
    (is (= 4 (yudishtira 4))))
  (testing "falsy value"
    (is (= :ashwathama (yudishtira false))))
  (testing "falsy value"
    (is (= :ashwathama (yudishtira nil)))))

(deftest duplicate-first-test
  (testing "non empty list"
    (is (= `(1 1 2 3 4) (duplicate-first '(1 2 3 4)))))
  (testing "non empty array"
    (is (= [1 1 2 3 4] (duplicate-first [1 2 3 4]))))
  (testing "empty list"
    (is (nil? (duplicate-first '()))))
  (testing "empty array"
    (is (nil? (duplicate-first [])))))

(deftest five-point-someone-test
  (testing "for value 5 for y"
    (is (= ":chetan-bhagat" (five-point-someone 4 5))))
  (testing "for value 5 for x"
    (is (= ":satan-bhagat" (five-point-someone 5 0))))
  (testing "for x is greater than y"
    (is (= ":greece" (five-point-someone 6 3))))
  (testing "returns universe"
    (is (= ":universe" (five-point-someone 4 6)))))

(deftest repeat-and-truncate-test
  (testing "repeat and truncate"
    (is (= '(0 1 2 3 0 1) (repeat-and-truncate (range 4) true true 6)))))

(deftest order-in-words-test
  (testing "x>y>z"
    (is (= [:x-greater-than-y :y-greater-than-z] (order-in-words 4 3 2))))
  (testing "z>x>y"
    (is (= [:x-greater-than-y :z-greater-than-x] (order-in-words 4 3 5))))
  (testing "z>x"
    (is (= [:z-greater-than-x] (order-in-words 2 3 4)))))