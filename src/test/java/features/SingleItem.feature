Feature: Single Item Added to the Cart

  @Scenario1
  Scenario: validate the register page
    Given user is on Home page
    When user click on practice link
    Then user move towards register page
    And validate "Join now to Practice" text on register page

  @Scenario2
  Scenario: validate the automation page
    Given user is on Register page
    When user gives name as "Ravi aggarwal" and email as "ravdel216@gmail.com"
    Then validate automation project page is open
    And validate text
    When user click on automation practice link1
    Then GreenCart product page is open
    And logo is found "GREENKART"

  @Scenario3
  Scenario Outline: validate the GreenCart page
    Given user is on GreenCart page
    When user click on add to cart button for desired <product>
      Then <product> added to the cart and Receives Thank you Message
    Examples:
      |  product  |
      |  Carrot   |
      |  Corn     |
      |  Orange   |
