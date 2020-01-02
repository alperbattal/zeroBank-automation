@account_summary
Feature: Account Summary

  Background:
    Given user is on the login page
    Then user is able to login with valid credentials

  Scenario: verify the title
    Given user verifies that the title is "Zero - Account Summary"

  Scenario: verify titles names
    And user verifies that the number "1" title is "Cash Accounts"
    Then user verifies that the number "2" title is "Investment Accounts"
    And user verifies that the number "3" title is "Credit Accounts"
    Then user verifies that the number "4" title is "Loan Accounts"

  Scenario: verify column names
    Given user verifies that the column names are displayed
      | Account     |
      | Credit Card |
      | Balance     |


