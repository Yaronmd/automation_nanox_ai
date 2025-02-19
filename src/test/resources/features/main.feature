Feature: Product Catalog and Shopping Cart Functionality

  @smoke
  Scenario: Verify main page and product table visibility
  Given I navigate to main page
  Then Validate Main page title
  When Get products
  Then Validate product table length

  @sanity
  Scenario: Verify Phones category product listing
    Given I navigate to main page
    Then Validate Main page title
    When I select category "Phones"
    And Get products
    Then Validate product table length
    And Validate products content (name,price,description)

  @sanity
  Scenario: Verify Laptops category product listing
    Given I navigate to main page
    Then Validate Main page title
    When I select category "Laptops"
    And Get products
    Then Validate product table length
    And Validate products content (name,price,description)

  @sanity
  Scenario: Verify Monitors category product listing
    Given I navigate to main page
    Then Validate Main page title
    When I select category "Monitors"
    And Get products
    Then Validate product table length
    And Validate products content (name,price,description)

  @regression
  Scenario: Validate adding a random product from Phones category to the cart
    Given I navigate to main page
    Then Validate Main page title
    When I select category "Phones"
    And Get products
    Then Validate product table length
    And Validate products content (name,price,description)
    When Select random product
    Then Validate product content after selecting
    When Click 'Add to cart'
    And Click 'OK' in popup message
    When Click 'Cart'
    Then Validate product added to cart

