Feature: Account manage
  Background:
    Given I am logged in SalesForce with "username.admin" and "password.admin"
    And I navigate home page

  @deleteContact
  Scenario: Create a new contact for an user with required data
    Given I log in with a valid username and password
    When I navigate to salesforce lightning page
    And  I create a new Contact the following data
    |First Name|Cxristian|
    |Last Name |Lujan    |
    |Account   |Cxriss   |
    |Phone     |12345678 |
    |Email     |Cxriss@email.com|
    Then The contact should be displayed on contact page
