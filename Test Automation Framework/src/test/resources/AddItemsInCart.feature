Feature: In order to add items in cart and checkout


  Scenario: Adding items in cart

    Given I launch url of the application
    When  I search book "Rich Dad Poor Dad" and enter
    And   I add book to the cart
    And   I search book "Think and Grow Rich" and enter
    And   I add second book to the cart
    And   I checkout items
    Then  Verify items are added to checkout
