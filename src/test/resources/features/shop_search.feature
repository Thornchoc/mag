@store_search @thorntons 
Feature: Store Search 

Background: 
	Given I want to find a shop near me 
	
Scenario: Search for a Store by Postcode 
	When I enter my postcode 
	Then I can see a shop near me 
	
	
#Scenario: Search for a Store by County 
#	When I select my County 
#	Then I can see all the shops in my county