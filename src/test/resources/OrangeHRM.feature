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
      And the User wants to go to Add Employee Page
      And the User wants to add first name as "George"
      Then the User wants to add last name as "Washington"
      Then the User wants to save personal information
      Then the User should be able to see "Personal Details" Header

  @TC300 @Regression
    # This scenario will implement a Map data type to make various inputs for tests
Scenario: Adding a new Employee - Using Map
  Given the User wants to go to OrangeHRM Website
  When the User wants to enter username and password
  Then the User wants to click on the Login Button
  And the User wants to verify that the browser landed on "Dashboard"
  Then the User wants to click on PIM Module
  And the User wants to go to Add Employee Page
  Then the User wants to add employee's first name and last name
  # | Key | Value |
  | FirstName | Abraham |
  | LastName | Lincoln |
  Then the User wants to add login details as follows
    | UserName | Abraham16      |
    | Password | Renastech!123@ |
    | Status   | Disabled       |
  Then the User wants to save personal information
  Then the User should be able to see "Personal Details" Header


    @TC400 @Regression
    Scenario: Adding a new Employee - Using List
      Given the User wants to go to OrangeHRM Website
      When the User wants to enter username and password
      Then the User wants to click on the Login Button
      And the User wants to verify that the browser landed on "Dashboard"
      Then the User wants to click on PIM Module
      And the User wants to go to Add Employee Page
      Then the User wants to add employees' first name and last name using a List
      # | First name | Last Name |
      | Benjamin | Renastech23 |
      | Abdul    | Renastech23 |
      | MIchael  | Jordan      |
      Then the User wants to add Login details using a List
      # | Username | Password | Status |
        | renastech23454564654! | Renastech!@@@2123123123 |  Disabled |
        |abcRenastechh45645!| RenasRenas!@!123123123123123| Enabled |
        |abc123Renas54454!  |Renastech123@!123123123123123|Enabled  |
      Then the User wants to save personal information
      Then the User should be able to see "Personal Details" Header


      #Scenario outline is the place where we implement DDT(DataDrivenTesting)
      @Scenario_Outline_TC1
      Scenario Outline: Adding a new Employee - Using a Scenario Outline
        Given the User wants to go to OrangeHRM Website
        When the User wants to enter username and password
        Then the User wants to click on the Login Button
        And the User wants to verify that the browser landed on "Dashboard"
        Then the User wants to click on PIM Module
        And the User wants to go to Add Employee Page
        Then the User wants to add employees' first name and last name using a List
      # | First name | Last Name |
          | Benjamin | Renastech23 |
          | Abdul    | Renastech23 |
          | MIchael  | Jordan      |
        Then the User wants to add login information "<username>" "<password>" "<status>"
        Then the User wants to save personal information
        Then the User should be able to see "Personal Details" Header

        Examples:
          | username                    | password                      | status   |
          | renastech54545423454564654! | Renastech!@@@2123123123       | Disabled |
          | abcRenastech44545h45645!    | RenasRenas!@!123123123123123  | Enabled  |
          | abc123Renas5445454544!      | Renastech123@!123123123123123 | Enabled  |
          | Sand14545423                | RenaseTes123.@                | Disabled |



  @Scenario_Outline_TC2
  Scenario Outline: Adding a new Employee - Using a Scenario Outline with one data table
    Given the User wants to go to OrangeHRM Website
    When the User wants to enter username and password
    Then the User wants to click on the Login Button
    And the User wants to verify that the browser landed on "Dashboard"
    Then the User wants to click on PIM Module
    And the User wants to go to Add Employee Page
    Then the User wants to add employee first name as "<firstname>" and the last name as "<lastname>"
    Then the User wants to add login information "<username>" "<password>" "<status>"
    Then the User wants to save personal information
    Then the User should be able to see "Personal Details" Header

    Examples:
      | firstname | lastname    | username                           | password                      | status   |
      | Benjamin  | Renastech23 | renasteasdfasdch54545423454564654! | Renastech!@@@2123123123       | Disabled |
      | Abdul     | Renastech23 | abcRenasdfasfstech44545h45645!     | RenasRenas!@!123123123123123  | Enabled  |
      | MIchael   | Jordan      | abc123Renas5445454544!             | Renastech123@!123123123123123 | Enabled  |
      | Sandy     | Mandy       | Sand1asdfas4545423                      | RenaseTes123.@                | Disabled |