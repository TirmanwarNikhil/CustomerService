Feature: Delete Customer

  Scenario: Delete Customer
    Given I have Customer Details in Database and MobileNumber
    When I try to delete Customer
    Then Respective customer record should be deactivated in Database
