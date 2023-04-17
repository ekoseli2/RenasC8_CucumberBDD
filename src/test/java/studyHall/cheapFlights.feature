#Create Test Scenarios for Flight Search
  Feature: Cheap Flights - Flight Search Feature

    #Positive Scenario 1
    Scenario: Flight search From LAS to LAX
      Given The user wants to go to cheapflights.ca
      When The user wants to provide origin as LAS
      Then The user wants to provide destionation as LAX
      And The user wants to provide departure date as July 18, 2023
      And The user wants to provide return date as July 25, 2023
      Then The user wants to click on search button

   #Negative Scenario 1
    Scenario: Flight Search with Invalid Airport Codes
      Given The user wants to go to cheapflights.ca
      When The user wants to provide origin as ABC
      Then The user wants to provide destionation as ACD
      And The user wants to provide departure date as July 18, 2023
      And The user wants to provide return date as July 25, 2023
      Then The user wants to click on search button
      Then The user wants to verify error message is An error occurred while trying to perform your search