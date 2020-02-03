(ns assignments.lists-test
  (:require [clojure.test :refer :all]
            [assignments.lists :refer :all]))

(deftest lists
  (testing "map"
    (testing "identity with single coll"
      (is (= [1 2 3] (map' identity [1 2 3]))))))

(deftest filter-test
  (testing "filtering even numbers"
    (is (= [2 4] (filter' even? [1 2 3 4 5]))))
  (testing "filtering odd numbers"
    (is (= [1 3 5] (filter' odd? [1 2 3 4 5])))))

(deftest count-test
  (testing "counting non empty list"
    (is (= 5 (count' [1 2 3 4 5]))))
  (testing "counting empty list"
    (is (= 0 (count' [])))))

(deftest every-test
  (testing "list of all odd numbers"
    (is (true? (every?' odd? [1 3 5]))))
  (testing "list of numbers"
    (is (false? (every?' odd? [1 2 3 4 5])))))

(deftest some-test
  (testing "list which contain odd numbers"
    (is (true? (some?' odd? [1 3 5 4 6 7]))))
  (testing "list which doesn't contain odd numbers"
    (is (nil? (some?' odd? [2 4 6]))))
  (testing "empty list"
    (is (nil? (some?' odd? [])))))

(deftest sqr-of-the-first-test
  (testing "list which contain odd numbers"
    (is (= [16 16 16] (sqr-of-the-first [4 6 7])))))

(deftest map-test
  (testing "increment function"
    (is (= [2 3 4] (map' inc [1 2 3]))))
  (testing "identity function"
    (is (= [1 2 3] (map' identity [1 2 3])))))

(deftest ascending-test
  (testing "ascending list"
    (is (true? (ascending? [1 2 3]))))
  (testing "not ascending test"
    (is (false? (ascending? [1 2 3 1])))))

(deftest sum-of-adjacent-digits-test
  (testing "sum-of-adjacent-digits"
    (is (= [3 5] (sum-of-adjacent-digits [1 2 3])))))

(deftest difference-test
  (testing "difference"
    (is (= '(3) (difference [1 2] [1 2 3])))))

(deftest index-of-test
  (testing "valid index"
    (is (= 1 (index-of [1 2 3] 2))))
  (testing "invalid index"
    (is (= -1 (index-of [1 2 3 1] 4)))))

(deftest palindrome
  (testing "empty list"
    (is (true? (palindrome? []))))
  (testing "one element list"
    (is (true? (palindrome? [1]))))
  (testing "palindrome list"
    (is (true? (palindrome? [1 2 3 2 1]))))
  (testing "not palindrome list"
    (is (false? (palindrome? [1 2 3 1])))))

(deftest muted-thirds-test
  (testing "muted-thirds"
    (is (= [1 2 0 4 15 0 7] (muted-thirds [1 2 8 4 15 2 7])))))

(deftest third-or-fifth-test
  (testing "third-or-fifth"
    (is (= [1 4 2 7] (third-or-fifth [1 2 8 4 15 2 7])))))

(deftest reduce-test
  (testing "sum of an array"
    (is (= 10 (reduce' + [1 2 3 4]))))
  (testing "converting array into string"
    (is (= "1234" (reduce' str [1 2 3 4])))))