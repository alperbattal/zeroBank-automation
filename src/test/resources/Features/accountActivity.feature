@account_activity
Feature: Account Activity

  Background:
    Given user is on the login page
    Then user is able to login with valid credentials
    Given user navigates to the "Account Activity" page

  Scenario: page should	have the correct title
    Given user verifies that the title is "Zero - Account Activity"

  Scenario: Savings should be the default option
    Given user verifies that the default option in the dropdown is "Savings"

  Scenario: available dropdown options
    Then user verifies that the dropdown has following options
      | Savings     |
      | Checking    |
      | Savings     |
      | Loan        |
      | Credit Card |
      | Brokerage   |

  Scenario: verify column names
    Given user verifies that the column names are displayed
      | Date        |
      | Description |
      | Deposit     |
      | Withdrawal  |


