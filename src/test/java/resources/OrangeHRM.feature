Feature: Functional Testing on OrangeHRM

  # Positive Test
  @LoginFunctionality
  Scenario: Login to OrangeHRM
    Given the User wants to go to OrangeHRM Website
    When the User wants to enter username and password
    Then the User wants to click on the Login Button
    And the User wants to verify that the browser landed on Dashboard

    @ParametrizedFunctionality @TC100
    Scenario: Login to OrangeHRM with parametrized message
      Given the User wants to go to OrangeHRM Website
      When the User wants to enter username and password
      Then the User wants to click on the Login Button
      # Parametrized the last step, this requires a new method
      And the User wants to verify that the browser landed on "Dashboard"

    @TC200
    Scenario: Adding a new Employee
      Given the User wants to go to OrangeHRM Website
      When the User wants to enter username and password
      Then the User wants to click on the Login Button
      And the User wants to verify that the browser landed on "Dashboard"
      Then the User wants to click on PIM Module
      And the User wants to add first name as "George"
      Then the User wants to add last name as "Washington"
      Then the User wants to save personal information
      Then the User should be able to see "Personal Details" Header