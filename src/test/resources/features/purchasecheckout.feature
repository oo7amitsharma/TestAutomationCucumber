Feature: As a random user I should be able to add and delete the laptop device from the cart
         and proceed to purchase successfully


  @Regression
  Scenario: Add Sony vaio i5 and Dell i7 8gb laptop in my cart, then delete the dell device from cart and purchase sucessfully
    Given I navigate to "STORE" site
    When I click on Laptops under category
    Then I click on Sony vaio i5 laptop from the list
    And I click on Add to cart
    And I click on ok button to accept the alert
    Then I navigate back to homepage of store
    When I click on Laptops under category
    Then I click on Add Dell i7 eight gb laptop from the list
    And I click on Add to cart
    And I click on ok button to accept the alert
    When I navigate to cart
    When I click on delete button to delete "Dell i7 8gb" laptops
    Then I validate "Dell i7 8gb" laptop deleted from cart
    Then I click on place order
    And I enter name "Amit"
    And I enter city "Delhi"
    And I enter country "India"
    And I enter credit card "12453658759624566"
    And I enter month "Octuber"
    And I enter year "2020"
    Then I click on purchase
    And I save the purchase amount and id
    And I validate purchase amount with expected amount "790 USD"
    Then I click on OK


