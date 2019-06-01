Feature: Create a new account
  As an administrator
  I want to create a new account

  Background:
    Given I am logged in SalesForce with "username.admin" and "password.admin"
      And I navigate to the Home page

  Scenario: Create a new account from accounts page
    When I open the Accounts page
      And I open the Account form from Accounts page
      And I create a new Account with the following information
        | Account Name | Account Test |
    Then the information account should be displayed in the Account Profile page
    When I open the Accounts page
    Then the account should be displayed on Accounts page
