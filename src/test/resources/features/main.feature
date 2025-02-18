Feature: Main page functionality

  Scenario: Successful login with valid credentials
  Given I navigate to main page
  Then Validate Main page title
  When Get products
  Then Validate product table length