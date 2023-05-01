Feature: Data Driven Testing - Using Excel File

  @ExcelFile
  Scenario: Login to OrangeHRM Excel File(External File)
    Given The user wants to login to OrangeHRM using Excel File
    And the User wants to verify that the browser landed on "Dashboard"