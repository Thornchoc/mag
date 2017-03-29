@thorntons

Feature: Checkout as new user with the different payment methods

  Background:
    Given I have added a product to my shopping bag

  Scenario: Checkout as new user with paypal
    When I checkout as a new user
    And I pay with paypal
    Then my order should be complete

  @complete
  Scenario: Checkout as new user with visa
    When I checkout as a new user
    And I pay with Visa
    Then my order should be complete

  @complete
  Scenario: Checkout as new user with Amex
    When I checkout as a new user
    And I pay with Amex
    Then my order should be complete

  @complete
  Scenario: Checkout as new user with MasterCard
    When I checkout as a new user
    And I pay with MasterCard
    Then my order should be complete