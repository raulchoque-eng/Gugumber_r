Feature: Event manage

  Background:
    Given I am logged in SalesForce with "username.admin" and "password.admin"
    And I navigate to the Home page

#  @deleteEvent
  Scenario: Create a new Event with required information
    When I open the New Event form
    And I add a new Event with the following information
#      | Assigned To | User To Event      |
#      | Assigned To | user one           |
      | Subject     | Call               |
      | Name        | Contact Event      |
      | Related To  | Account Event      |
      | Location    | Virginia           |
      | Start Date  | One hour from now  |
      | End Date    | Two hours from now |
      | Description | Description Text   |
      | Assigned To | user one           |
#    Then the Subject of new Event should be displayed on Calendar Section
#    When I open the Event Details page from Calendar Section
#    Then the information of new Event should be displayed in Event Detail page
#
#  @deleteEvent
#  Scenario Create a new Event with all data
#    When  I open the form Event from Home page
#    And   I add a new Event with the following data
#      |Assigned To|User To Event           |
#      |Subject    |Call	                |
#      |Name       |Contact To Event        |
#      |Related To |Account To Event        |
#      |Location   |Virginia                |
#      |Start Date |Today                   |
#      |Start Time |Within one hour         |
#      |End Date   |Today                   |
#      |End Time   |One hour later          |
#      |Description|Description Text        |
#    Then  the Subject of new Event should be displayed on Calendar Section
#    When  I open the new Event
#    Then  the data of new Event should be displayed from Event Detail page
#
#  @createEvent
#  Scenario Delete an Event
#    When  I open the "Other" Event
#    And   I delete the Event
#    Then  the Event should be clear from the list of Events