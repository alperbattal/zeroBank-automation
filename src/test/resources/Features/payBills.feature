@pay_bills
Feature: Pay Bills

  Background:
    Given user is on the login page
    Then user is able to login with valid credentials
    Given user navigates to the "Pay Bills" page

  Scenario: page should	have the correct title
    Given user verifies that the title is "Zero - Pay Bills"

  Scenario: verify the message
    Given user verifies the message "The payment was successfully submitted." is displayed.

  Scenario: verify the alert
    Then user verifies that the alert "Please fill out this field." is displayed without entering the amount.
    Then user verifies that the alert "Please fill out this field." is displayed without entering the date.
