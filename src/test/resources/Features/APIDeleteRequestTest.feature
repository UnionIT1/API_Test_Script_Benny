@API
Feature: This is to test the API Delete Request by deleting an existing record

  Scenario: Delete an existing todo list record by id
    Given I am able to access the API Endpoint
    When I make a API call to delete a record
    Then I am able to successfully delete the record and get a response code of 200