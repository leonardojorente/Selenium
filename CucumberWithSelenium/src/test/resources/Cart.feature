Feature:  Cart functionality

  In order to purchase a product
  As a valid customer
  I want to insert products to the cart

Scenario: Add product to cart with data table

  Given a user is in the main page
  When he search for a product data table
  |Luva|
  And add the product to the cart
  Then the product appears correctly in the cart

Scenario Outline: Scenario: Add product to cart using scenario Outline

  Given a user is in the main page
  When he search for a product <products>
  And add the product to the cart
  Then the product appears correctly in the cart

  Examples:
  |products|
  |"Luva"  |
