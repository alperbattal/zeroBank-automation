@find_transcations
Feature: Find Transactions in Account Activity

  Background:
    Given user is on the login page
    Then user is able to login with valid credentials
    Given user navigates to the "Account Activity" page
    Given the user accesses the "Find Transactions" tab

  Scenario: Search date range
    When the user enters date range from "2012-09-01" to "2012-09-06"
    And clicks search
    Then results table should only show transactions dates between "2012-08-30" to "2012-09-07"
    And the results should be sorted by most recent date