@thorntons
Feature: Store Search 

Background: 
	Given I want to find a shop near me 
	
Scenario: Search for a Store by Postcode 
	When I enter my postcode 
	Then I can see a shop near me 
	
Scenario: Search for a Store by County 
	When I select my County 
	Then I can see all the shops in my county
	
Scenario: Search for a Store in a large radius 
	When I enter my postcode
	And I select a radius of 50 miles 
	Then I can see all the shops in that 50 miles radius

@store_search	
Scenario: View store details
	When I enter my postcode 
	And I can see a shop near me
	When I select a shop from the list
	Then I can see a map location 
	And information about that store	