Feature: Main page functionality

  @smoke
  Scenario: Validate main page and table content exist
  Given I navigate to main page
  Then Validate Main page title
  When Get products
  Then Validate product table length

  @sanity
  Scenario: Validate Laptops table content exist
    Given I navigate to main page
    Then Validate Main page title
    When I select category "Laptops"
    And Get products
    Then Validate product table length

  @sanity
  Scenario: Validate Laptops table content exist
    Given I navigate to main page
    Then Validate Main page title
    When I select category "Monitors"
    And Get products
    Then Validate product table length