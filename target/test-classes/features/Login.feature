Feature: Login Functionality

  Scenario: Invalid user logs in
    Given the user enters username "wrong" and password "wrong"
    When the user logs in
    Then the user should not be logged in

  Scenario: Valid user logs in
    Given the user enters username "demouser" and password "testingisfun99"
    When the user logs in
    Then the user should be logged in successfully
