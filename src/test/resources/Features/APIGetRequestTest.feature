@API
Feature: This is to get and validate all the list todo records

  Scenario Outline: Get the list of all 200 to-dos records
    Given I am able to access the API Endpoint
    When I call to get the list of all todos
    Then I get the status code of value <Test_Status_Code> and the number of records returned as <Number_of_Records_Returned>
    Examples:
      | Test_Status_Code | Number_of_Records_Returned |
      | 200              | 200                        |

  Scenario: Get the list of all 200 to-do records and check for any null values
    Given I am able to access the API Endpoint
    When I call to get the list of all todos
    Then I get the status code of value 200 and validates the body of the response data for any null values


  Scenario: Get a particular list by id
    Given I am able to access the API Endpoint
    When I call to get a particular todo list for id 25
    Then I get the response code of value 200 and one record of todo list