@heroku-regression @heroku-search
Feature: Heroku Search Feature

  Background:
    Given I am on Heroku home page

  @heroku-search-1
  Scenario: Verify ios title
    When I search on top search bar with text ios
    Then I verify Title: I will teach you IOS as displayed result

  @heroku-search-2
    Scenario: Verify total posts displayed
    Then I verify 56 total post is displayed
    And I verify all post has price tag
    And I verify all post has title
    And  I verify all post has displayed image

  @heroku-search-3
  Scenario: Verify invalid email on registration
    Given I am on Registration page
    When I enter name as testuser email as testuser and password as test12345
    And I click submit button
    Then  I verify invalid email address

#  Examples:
#  | email |
#  | test.com |
#  | test@test@test.com |

  @heroku-search-4
  Scenario: Verify a new user can register with a valid email address
    Given I am on Registration page
    When I enter name as testuser email as random email password as test12345 for new user
    And I click submit button
    Then  I am signed-in as a new user

  @heroku-search-5
  Scenario: Verify valid login
    Given User is on the Threely login page
    When I enter username as n12345@test.com and password as 123456
    And I click on submit button
    Then I verify logout button is displayed







