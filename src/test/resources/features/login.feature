@login
Feature: Login Functionality

  As a user, I should be able to login

  Acceptance Criteria:
  1-Users should be able to login with valid credentials and should land on the home page after successful login.
  (We have 3 types of users such as HR user, Marketing user, and Helpdesk user).
  2-"Incorrect login or password" should be displayed for invalid (valid username-invalid password and invalid
  username-valid password) credentials
  3- "Please fill out this field" message should be displayed if the password or username is empty
  4-User can see "Remember Me" link exists and is clickable on the login page
  5-User should see the password in bullet signs by default

  Background:
    Given the user is on the login page


  Scenario Outline: Verify login with different user types
    When the user logged in as "<userType>"
    Then user should land on the activity stream page and see the "Activity Stream" title

    Examples:
      | userType  |
      | hr        |
      | helpdesk  |
      | marketing |


  Scenario Outline: Verify "Incorrect login or password" displayed for invalid credentials
    When the user logged in with "<userType>" and "<password>"
    Then user see the error message "Incorrect login or password"

    Examples:
      | userType            | password |
      | hr@cyde.com         | UserUser |
      | helpdesk3@cydeo.com | user     |
      | mrketing@cydeo.com  | Useruser |


  Scenario Outline: Verify "Please fill out this field" message displayed if the password or username is empty
    When the user enters only "<userType>" or "<password>"
    Then user see the message "Please fill out this field"

    Examples:
      | userType              | password |
      | hr22@cydeo.com        |          |
      |                       | UserUser |
      | marketing42@cydeo.com |          |


    Scenario: Verify "Remember Me" link exists and is clickable
      Then remember me link should be displayed
      When user clicks the remember me checkbox
      Then the checkbox should be selected



   Scenario: Verify password is in bullet signs by default
     When user enters a password
     Then password should be in bullet signs by default








