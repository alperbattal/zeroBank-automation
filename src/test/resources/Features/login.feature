@login
Feature: Login
  # Only authorized	users should be	able to	login to the	application.
  # When user logs in with valid credentials, Account summary page should be

  Background:
    Given user is on the login page

  Scenario: user is able to login with valid credentials
    Then user is able to login with valid credentials
    And user verifies that the number "1" title is "Cash Accounts"

  Scenario: user is not able to login with wrong username and correct password
    Given user is not able to login with "username_123" and "password"
    Then error message "Login and/or password are wrong." should be displayed

  Scenario: user is not able to login with correct username and incorrect password
    Given user is not able to login with "username" and "password123"
    Then error message "Login and/or password are wrong." should be displayed


