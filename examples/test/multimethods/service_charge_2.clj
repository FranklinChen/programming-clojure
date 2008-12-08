(ns examples.test.multimethods.service-charge-2
  (:use clojure.contrib.test-is)
  (:use examples.multimethods.service-charge-2)
  (:use examples.multimethods.account))

(alias 'acc 'examples.multimethods.account)

(deftest test-service-charge
  (are =
   (service-charge {:tag ::acc/Checking, :balance 4999}) 25
   (service-charge {:tag ::acc/Checking, :balance 5000}) 0
   (service-charge {:tag ::acc/Savings, :balance 999}) 10
   (service-charge {:tag ::acc/Savings, :balance 1000}) 0
))

  