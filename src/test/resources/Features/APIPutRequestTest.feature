@API
Feature: This is to test the API put request by updating an existing record

  Scenario: Update an existing todo list record by id
    Given I am able to access the API Endpoint
    When I make a call to update a todo list
    Then I am able to successfully update the record and get a response code of 200