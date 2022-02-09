Feature: Jqureyui Scenarios
         I want to practice with date picker

  @Jqureyuidatepicker
  Scenario: I should be able to pick a date
    Given I am on the Jqureyui date page
    When I enterd "02/07/2022" to date picker
    Then The Date entered should be selected
