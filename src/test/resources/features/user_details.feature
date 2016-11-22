@thorntons
Feature: User details

  Background:
    Given a registered user

  @complete
  Scenario: Registered user can change email address
    When I change my email address
    Then my new email address should be saved

  @complete
  Scenario: user can add address
    When I add an address
    Then I should see the address in my addresses