@account_activity
Feature: Account Activity

  Background:
    Given user is on the login page
    Then user is able to login with valid credentials

  Scenario: user can navigate to other pages
    Given user navigates to the "Account Activity" page

