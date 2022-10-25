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

