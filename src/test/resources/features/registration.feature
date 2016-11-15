@thorntons

  Feature: Registration

    @complete
    Scenario: New user can register 
      When I register with my details
      Then my account should be created