Feature: All Customer Search

  Scenario: Get All Customers
    Given I have Customer Details in Database
    When I search for All Customers details
    Then All Customers with their details should be displayed

