Feature: Study Parameterization In Cucumber


Scenario: Passing parameter from Step
Given I have 7 and 9
When I add them
Then Verify if the result is prime

Scenario: Passing data table as parameter
 Given I have <RTO_Codes> and <State_Name>
       |MH||Maharashtra|
        