@Test
Feature: TradeJournal Login
       I want to be able to login with valid credentials.

  @TradeJournalValidLogin
  Scenario: User should be directed to sign in page
    Given I am on tradeJournal sign in page
    And The Sign in button displays
    When I enter valid username "Salam" and valid password "SuperSalam123!"
    And I click the sign in button
    Then I should be directed to home page

  @TradeJournalInvalidLogin
  Scenario Outline: User is not able to log in with invalid credent
    Given I am on tradeJournal sign in page
    And The Sign in button displays
    When I enter invalid username "<username>" and Invalid password "<password>"
    Then I should not be sign in
    And Error message will display "Bad Credentials"

    Examples: Credentions
      | username    | password       |
      | Salam       | secret_invalid |
      | salam22     | SuperSalam123! |
      | standard123 | standard652    |
      
      @TradeJournalLogOut
      Scenario: User should be able to LogOut 
      Given I am on tradeJournal hame page 
      When  I am click on the Logout buttom 
      Then I should directed to logout page following a message "Are you sure you want to log out?"  
      And I clicked on click on log out button 
      And I should directed to sign in page following a message placed "You have been signed out"

      
      
      
