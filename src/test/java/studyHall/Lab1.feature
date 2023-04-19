Feature: Lab 1 - Heroku app for Insurance

  Scenario: Verify that you are able to get a quote
    Given That user wants to navigate to the Website "https://renas-practice.herokuapp.com/projects/insurance"
    When The user clicks GET a Quote Button
    Then The user chooses vehicle year as "2023"
    And The user wants to choose Make of Vehicle as "Toyota"
    Then The user picks Model as "Camry"
    And The user wants wants to answer question in Driver's License History as "No"
    And The user wants to click on Submit Button
    Then The user wants to verify Let's Us call button is visible