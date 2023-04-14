Feature: Payment Gateway functional test

  Scenario: Verify that the User can buy an Elephant toy
    Given the User wants to go to the Payment Gateway website
    When the User wants to buy an elephant toy
    Then the User wants to provide requested payment information
    And the User wants to click on pay now
    Then the User wants to verify the order is successful