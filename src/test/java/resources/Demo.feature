Feature: Payment Gateway functional test

  Scenario: Verify that the User can buy an Elephant toy
    Given the User wants to go to the Payment Gateway website
    When the User wants to buy an elephant toy
    Then the User wants to provide requested payment information
    And the User wants to click on pay now
    Then the User wants to verify the order is successful

  Scenario: Verify that the User can buy multiple products
    Given the User wants to go to the Payment Gateway website
    When the User wants to buy an elephant toy as "9"
    Then the User wants to provide their credit card number as "1111111221111111"
    And the User wants to provide their expiration month as "12"
    And the User wants to provide their expiration year as "2024"
    And the User wants to provide their CVV Code as "787"
    And the User wants to click on pay now
    Then the User wants to verify a message as "Payment successfull!"