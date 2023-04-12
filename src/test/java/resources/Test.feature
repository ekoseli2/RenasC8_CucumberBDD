Feature: This feature is about login functionality of Amazon
  # This is how you write comments on feature files
  # Gherkins language is being used
  # Given, When, Then, And, But
  # Testrail and Zephyr scale are two test management tools
  # Cucumber BDD
  # BDD = Behavior Driven Development
  # Reusability and Readability

  # Positive test scenario
  Scenario: Log into Amazon with: Correct Username & Correct Password
    Given the User goes to Amazon's website
    When the User Wants to Enter a Correct Username
    Then the User wants to enter a Correct Password
    And the User wants to click the 'Login' button

  # Negative test scenario 1
  Scenario: Log into Amazon with: Correct Username & Incorrect Password
    Given the User goes to Amazon's website
    When the User Wants to Enter a Correct Username
    Then the User wants to enter a Incorrect Password
    And the User wants to click the 'Login' button
    And the User wants to Verify that login was unsuccessful

  # Negative test scenario 2
  Scenario: Log into Amazon with: Incorrect Username & Correct Password
    Given the User goes to Amazon's website
    When the User wants to enter an Incorrect Username
    Then the User wants to enter a Correct Password
    Then the User wants to click the 'Login' button
    And the User wants to Verify that login was unsuccessful