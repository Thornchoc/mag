@thorntons

Feature: Checkout as existing user with the different payment methods


  Scenario: Checkout as existing user with paypal
    Given I have added a product to my shopping bag
    When I checkout as a existing user
    And I pay with paypal
    Then my order should be complete

  @complete
  Scenario: Checkout as existing user with visa
    Given I have added a product to my shopping bag
    When I checkout as a existing user
    And I pay with Visa
    Then my order should be complete

  @complete
  Scenario: Checkout as existing user with Amex
    Given I have added a product to my shopping bag
    When I checkout as a existing user
    And I pay with Amex
    Then my order should be complete