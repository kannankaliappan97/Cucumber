Feature: Sample url test

  Background: Launch Browser
    Given I launch "chrome" Browser
  @pass @all
  Scenario Outline: Test url
    Given url link "<URL>" in "<browser>"
    When I enter username as "<Username>" and password as "<Password>"
   And I log out
    Examples:
    |browser| URL|Username|Password|

    |chrome |https://www.saucedemo.com/    |standard_user |secret_sauce|
  @e2e @all
  Scenario Outline: Test url
    Given url link "<URL>" in "<browser>"
    When I enter username as "<Username>" and password as "<Password>"
    And goto cart for checkout
    And I fill the "<Fname>" and "<Lname>" and "<Zcode>"
    Then I validate Checkout
    And I log out

    Examples:
      |browser| URL|Username|Password|Fname|Lname|Zcode|
      |chrome |https://www.saucedemo.com/|standard_user| secret_sauce |SK  |Kannan|626189|
@Api @all
    Scenario Outline: Hit My Api
      Given i hit the "<Post>" request
      And I log out
  Examples:
    | Post |
    |   Get|
    |  Post|

