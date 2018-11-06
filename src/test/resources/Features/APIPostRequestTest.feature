@API
Feature: This is to test the API post request by creating a new record

  Scenario: Create a new todo list by sending a Post Request
    Given I am able to access the API Endpoint
    When I make a call to post new todo list
    Then I am able to successfully create a record and get a response code of 201