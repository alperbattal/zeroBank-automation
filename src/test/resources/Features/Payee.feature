@add_payee
Feature: Add new payee under pay bills Scenario: Add a new payee

  Background:
    Given user is on the login page
    Then user is able to login with valid credentials
    Given user navigates to the "Pay Bills" page
    Given the user accesses the "Add New Payee" tab

  Scenario: Add a new payee
    And creates new payee using following information
      | Payee Name                               | Payee Address                    | Account  | Payee Details |
      | The Law Offices of Hyde, Price & Scharks | 100 Same st, Anytown, USA, 10001 | Checking | XYZ account   |


    Then message "The new payee The Law Offices of Hyde, Price & Scharks was successfully created." should be displayed.