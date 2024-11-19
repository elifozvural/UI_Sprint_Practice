Feature: Activity Stream Page Functionality

  As a user, I should be able to see all the options on the Activity stream page

  Acceptance Criteria:
  1. Verify that user view the following options on Activity stream page
  MESSAGE
  TASK
  EVENT
  POLL
  MORE

  2. Verify the users view the following 4 options under the MORE tab
  File
  Appreciation
  Announcement
  Workflow

  Background:
    Given the user is on the login page


  Scenario Outline: Verify user see the options on activity stream page and under the more tab
    When the user logged in as "<userType>"
    And user navigates to activity stream page
    Then user views the following options on the activity stream page
      | MESSAGE |
      | TASK    |
      | EVENT   |
      | POLL    |
      | MORE    |
    When user clicks MORE button
    Then user views the following options under the MORE tab
      | File         |
      | Appreciation |
      | Announcement |
      | Workflow     |

    Examples:
      | userType  |
      | hr        |
      | helpdesk  |
      | marketing |



