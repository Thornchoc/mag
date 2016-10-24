@web
Feature: Basic Browse and Checkout for one or two products, no bells and whistles.

  @wip
  Scenario: First long scenario, one product
    When I select category "Chocolates"
    And I select chocolate type "Truffles"
    And I select product with name "Marc De Champagne Chocolate Truffles"
    And I add it to the bag
    When I view my bag
    Then I should see the product in my bag
    When I go to Checkout


  #Scenario: Second long scenario, two products
