@thorntons

Feature: Checkout as new user with the different payment methods

  @wip
  Scenario: Checkout as new user with paypal
    Given I have added a product to my shopping bag
    When I checkout as a new user
    And I pay with paypal
    Then my order should be complete

  Scenario: Checkout as new user with visa
    Given I have added a product to my shopping bag
    When I checkout as a new user
    And I pay with visa
    Then my order should be complete

  Scenario: Checkout as new user with Amex
    Given I have added a product to my shopping bag
    When I checkout as a new user
    And I pay with Amex
    Then my order should be complete