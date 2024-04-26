Feature: Multiple Item Added to the Cart

  @whole1
  Scenario: validate the GreenCart page for Multiple Items
    Given user is on GreenCart page have multiple Item
    When user should click on add to cart button for multiple product
      |  product1  |  product2  |  product3  |  product4     |  product5  |
      |  Tomato    |  Potato    |  Onion     |  Pomegranate  |  Almonds   |
    Then items present in GreenCart home page should be increased to 5

  #@whole2
  #Scenario: validate place order table
    When user click  on proceed to checkout button
    Then place order  page should open
    And verify multiple product is added to product table
      |  Tomato    |  Potato    |  Onion     |  Pomegranate  |  Almonds   |

  #@whole3
  #Scenario: validate code is applied
    When user enter the Code "rahulshettyacademy" in promoCode TextBox
    And click on apply Button
    Then text "Code applied ..!" is found

  #@whole4
  #Scenario: validate proceed page
    When user click  on place order button
    Then proceed page  is open
    And choose country  text is found

  #@whole5
  #Scenario: validate order should be placed
    When user click on select country  dropdown and select country from dropdown
    And check the term and  condition checkBox
    And click on  proceed button
    And thank you message is displayed
