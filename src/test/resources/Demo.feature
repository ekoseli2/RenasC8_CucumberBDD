Feature: Payment Gateway functional test

  @BuyingProduct_TC1 @Regression
  Scenario: Verify that the User can buy an Elephant toy
    Given the User wants to go to the Payment Gateway website
    When the User wants to buy an elephant toy
    Then the User wants to provide requested payment information
    And the User wants to click on pay now
    Then the User wants to verify the order is successful

  @BuyingProduct_TC2 @Smoke
  Scenario: Verify that the User can buy multiple products
    Given the User wants to go to the Payment Gateway website
    When the User wants to buy an elephant toy as "9"
    Then the User wants to provide their credit card number as "1111111221111111"
    And the User wants to provide their expiration month as "12"
    And the User wants to provide their expiration year as "2024"
    And the User wants to provide their CVV Code as "787"
    And the User wants to click on pay now
    Then the User wants to verify a message as "Payment successfull!"

    @BuyingProduct_TC3
  Scenario: Verify that the User can buy multiple products - Using Map
    Given the User wants to go to the Payment Gateway website
    When the User wants to buy an elephant toy as "9"
    Then the User wants to provide requested payment information as follows
      # | Key | Value |
      | CNumber | 5454545454545454 |
      | EMonth  | 11               |
      | EYear   | 2026             |
      | CvvCode | 189 |
      And the User wants to click on pay now
      Then the User wants to verify a message as "Payment successfull!"