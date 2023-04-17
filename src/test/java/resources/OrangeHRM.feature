Feature: Functional Testing on OrangeHRM

  # Positive Test
  @LoginFunctionality
  Scenario: Login to OrangeHRM
    Given the User wants to go to OrangeHRM Website
    When the User wants to enter username and password
    Then the User wants to click on the Login Button
    And the User wants to verify that the browser landed on Dashboard