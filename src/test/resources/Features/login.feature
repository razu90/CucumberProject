Feature: Test login functionality
  @positive_test
  Scenario: Check login is successful with valid credentials
    Given a user is on the login page
    When user enters username "Razu" and password "12345"
    And click on login button
    Then user is navigated to home page

  @negative_test
  Scenario: Check login is unsuccessful with invalid credentials
    Given a user is on the login page
    When user enters username "Razu" and password "44444"
    And click on login button
    Then user is failed to login

@dataDriven_test
  Scenario Outline: Check login is successful with valid credentials
    Given a user is on the login page
    When user enters username "<username>" and password "<password>"
    And click on login button
    Then user is navigated to home page

    Examples:
      |username|password|
      |Razu    |12345 |
      |Parvez  |12345 |
      |Asif    |12345 |

  Scenario: Check login is successful using data table
    Given a user is on the login page
    When user click on login button upon entering credentials
      |username|password|
      |Razu    |12345   |
    Then user is navigated to home page


