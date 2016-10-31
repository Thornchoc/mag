@web
Feature: Basic Browse and Checkout for one or two products, no bells and whistles.
  
  @wip
  Scenario: First long scenario, one product
    When I select category "Chocolates"
    And I select chocolate type "Chocolate Truffles"
    And I select product with name "Irresistible Belgian Chocolate Truffles"
    And I add it to the bag
    When I view my bag
    Then I should see the product in my bag
    When I go to Checkout

   
  Scenario: Add product to bag
    Given I have added a product to my shopping bag
    When I checkout as a guest
    And I pay with paypal
    Then my order should be complete