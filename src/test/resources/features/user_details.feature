@thorntons
  Feature: User details

    @wip
    Scenario: Registered user can change email address
      Given a registered user
      When I change my email address
      Then my new email address should be saved