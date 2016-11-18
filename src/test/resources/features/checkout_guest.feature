@thorntons

Feature: Checkout as guest with the different payment methods

  Background:
    Given I have added a product to my shopping bag

  #having trouble with paypal page
  Scenario: Checkout as Guest with paypal
    When I checkout as a guest
    And I pay with paypal
    Then my order should be complete

  @complete @wip
  Scenario: Checkout as Guest with visa
    When I checkout as a guest
    And I pay with Visa
    Then my order should be complete

  @complete
  Scenario: Checkout as guest with Amex
    When I checkout as a guest
    And I pay with Amex
    Then my order should be complete

  @complete
  Scenario: Checkout as guest with MasterCard
    When I checkout as a guest
    And I pay with MasterCard
    Then my order should be complete