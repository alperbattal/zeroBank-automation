@foreign_currency
Feature: PurchaseForeignCurrency

  Background:
    Given user is on the login page
    Then user is able to login with valid credentials
    Given user navigates to the "Pay Bills" page
    Given the user accesses the "Purchase Foreign Currency" tab

  Scenario:    Available currencies
    Then  following currencies should be available
      | Australia (dollar)    |
      | Canada (dollar)       |
      | Switzerland (franc)   |
      | China (yuan)          |
      | Denmark (krone)       |
      | Eurozone (euro)       |
      | Great Britain (pound) |
      | Hong Kong (dollar)    |
      | Japan (yen)           |
      | Mexico (peso)         |
      | Norway (krone)        |
      | New Zealand (dollar)  |
      | Sweden (krona)        |
      | Singapore (dollar)    |
      | Thailand (baht)       |

  Scenario:    Error message for not selecting	currency
    When    user tries to calculate cost without selecting a currency
    #Then  error message "Login and/or password are wrong." should be displayed
    #Then    error message "Please, ensure that you have filled all the required fields with valid values." should be displayed

