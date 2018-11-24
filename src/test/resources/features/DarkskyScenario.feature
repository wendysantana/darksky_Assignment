@darksky-regression @darksky-search
Feature: Darksky Search Feature

  Background:
    Given I am on Darksky home page

  @darksky-search-1
  Scenario: Verify timeline is displayed in correct format
    Then I verify timeline is displayed with two hours incremented

  @darksky-search-2
  Scenario: Verify individual day temp timeline
    When I expand todays timeline
    Then I verify lowest and highest temp is displayed correctly