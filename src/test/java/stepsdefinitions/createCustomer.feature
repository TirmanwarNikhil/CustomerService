Feature: Create Customer

  Scenario: Create Customers
    Given I have Customer Details
    When I Receive Customer Details
    Then I should insert record in Database

