Feature: Update/Modify Customer

  Scenario: Update Customer
    Given I have Customer Details tobe update
    When I try to update Customer detail
    Then Customer details record should be updated in Database
