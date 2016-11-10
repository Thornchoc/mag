@thorntons

Feature: Checkout as guest with the different payment methods

  #having trouble with paypal page
  Scenario: Checkout as Guest with paypal
    Given I have added a product to my shopping bag
    When I checkout as a guest
    And I pay with paypal
    Then my order should be complete

  @complete
  Scenario: Checkout as Guest with visa
    Given I have added a product to my shopping bag
    When I checkout as a guest
    And I pay with Visa
    Then my order should be complete

  @complete
  Scenario: Checkout as guest with Amex
    Given I have added a product to my shopping bag
    When I checkout as a guest
    And I pay with Amex
    Then my order should be complete