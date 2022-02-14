Feature: As a user , I am able to perfrom Trade app functions
         I want to add ,delete and update trades

@AddTrade
Scenario: As a user ,I want to add a trade
Given I am on the Trade App Log in page
When I enter username "Salam" password "SuperSalam123!"
And I click on Trade login button 
Then I shoud be on Trade homepage 
When I click on add Trade button 
Then I shoud be on Save Trade page 
When I select "Buy to Open" and I enter symbol "EXPR" entryDate "04/04/2021" entryPrice "10.0" exitDate "01/11/2022" exitPrice "18"
And I click Save button
Then The trade is displayed on the trade table