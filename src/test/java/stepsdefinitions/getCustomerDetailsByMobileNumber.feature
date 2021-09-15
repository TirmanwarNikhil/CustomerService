Feature: Customer Search By Mobile Number

  Scenario: Search Customer
    Given I have Customer Mobile Number
    When I search Customer detail with MobileNumber "9765922347"
    Then Customer with First Name "Nikhil" should be displayed
