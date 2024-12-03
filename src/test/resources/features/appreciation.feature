@wip
Feature: Appreciation Functionality

  As a user, I should be able to send appreciation by clicking on Appreciation tab under Active Stream

  Acceptance Criteria :

  1. User should be able to send an appreciation by filling the mandatory fields.
    Mandatory fields: 'Message content & 'Recipient'.
      - Error messages for mandatory fields:
       "The message title is not specified"
       "Please specify at least one person."
  2. The delivery should be to 'All employees' by default.
  3. User should be able to cancel sending appreciation at any time before sending.
  4. The appreciation message should be at least 500 characters long.


  Background:
    Given the user is on the login page


  Scenario Outline: Verify user can send an appreciation by filling the mandatory fields
    When the user logged in as "<userType>"
    When user navigates to Appreciation tab
    And user enters a message "Good job!"
    And user clicks send
    Then user sees the appreciation that is sent

    Examples:
      | userType  |
      | hr        |
      | helpdesk  |
      | marketing |


  Scenario Outline: Verify user see error message if message is not written
    When the user logged in as "<userType>"
    When user navigates to Appreciation tab
    And user clicks send
    Then user sees the error message for the message field "The message title is not specified"

    Examples:
      | userType  |
      | hr        |
      | helpdesk  |
      | marketing |

  Scenario Outline: Verify user see error message if there is no recipient
    When the user logged in as "<userType>"
    When user navigates to Appreciation tab
    And user deselects All employees
    When user clicks send
    Then user sees the error message for the recipient field "Please specify at least one person."

    Examples:
      | userType  |
      | hr        |
      | helpdesk  |
      | marketing |


  Scenario Outline: Verify delivery is 'All employees' by default.
    When the user logged in as "<userType>"
    When user navigates to Appreciation tab
    Then user sees the delivery is 'All employees' by default.

    Examples:
      | userType  |
      | hr        |
      | helpdesk  |
      | marketing |


  Scenario Outline: Verify user can cancel anytime
    When the user logged in as "<userType>"
    When user navigates to Appreciation tab
    And user cancels appreciation
    Then users see the "Send message …" text in the activity stream

    Examples:
      | userType  |
      | hr        |
      | helpdesk  |
      | marketing |


    Scenario Outline: Verify appreciation message should be at least 500 characters long.
      When the user logged in as "<userType>"
      When user navigates to Appreciation tab
      And user enters the message "Well Done!" which fewer than 500 characters
      And user clicks send
      Then user sees the appreciation is not sent

      Examples:
        | userType  |
        | hr        |
        | helpdesk  |
        | marketing |