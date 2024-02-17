Feature: This feature verify product serach functinality


Scenario: Verify when user seraches for Levis then all results should contains products from brand Levis
Given Enter Levis in search component
When User clicks on serach magnifier
Then All results populated must contain word Levis in it
 