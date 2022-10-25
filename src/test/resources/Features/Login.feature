@FIDE-1415
Feature: As a user, I should be able to log in so that I can land on homepage.

  Background:
    Given User is on the login page

  @FIDE-1413
  Scenario: log in as posmanager
    When posmanager inputs username "username"
    And posmanager inputs password "password"
    And posmanager click log in button
    Then user is able to see menu

  @FIDE-1414
  Scenario: log in as salesmanager
    When salesmanager inputs username "username"
    And salesmanager inputs password "password"
    And salesmanager click log in button
    Then user is able to see menu

  @FIDE-1416
  Scenario: Negative login test case
    When posmanager enters invalid credentials
      | username | posmanager6@info.com |
      | password | posmanage            |
    When salesmanager enters invalid credentials
      | username | salesmanager6@info.com |
      | password | salesmanager           |
    Then users are able to see Wrong login/password


  @FIDE-1418
  Scenario:  "Please fill out this field" message should be displayed
  if the password or username is empty
    When posmanager blank username and input valid password
    And posmanager click log in button
    Then users are able to see required message

  @FIDE-1419
  Scenario:  "Please fill out this field" message should be displayed
  if the password or username is empty
    When salesmanager blank username and input valid password
    When salesmanager click log in button
    Then users are able to see required message

  @FIDE-1421
    Scenario: User should see the password in bullet signs by default
      When user input password
      Then user is able to see the password in bullet sign


    @FIDE-1422
    Scenario:‘Enter’ key of the keyboard is working correctly on the login page.
      When user press ENTER keyword after input valid credentials
        | username | posmanager6@info.com |
        | password | posmanager           |
      Then users is able to verify keyword is working correctly




