Feature: Log in SalesForce
  Scenario: Login in SalesForce with valid user account
    Given I am logged in SalesForce with "username.admin" and "password.admin"
    When I navigate to the Home page