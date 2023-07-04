@regression
Feature: Testing the Functionality of Order Process in Blaze
#  only for ONE mock test run. If validating only ONE item or category you can use this scenario
#  Background: Navigation
#    Given User navigates to the Blaze website
#
#    Scenario: Happy Path for Order Process
#      When User clicks the 'Laptops' and choose the item 'MacBook air'
#      And User validates the 'MacBook air' and 'Product added' from alert pop-up after clicking Add to Cart button
#      And User clicks Cart button and validates the 'MacBook air' and '700' then click Place Order Button
#      And User proves the information 'Akram', 'USA', 'Chicago', '1234567', '12', '2023' and click Purchase Button
#      Then User validates the message 'Thank you for your purchase!' and url 'https://demoblaze.com/cart.html'

#  only for MORE then ONE mock test run. If validating only MORE then ONE item or category you can use this scenario
#  commend D to clone the line
#  Background: Navigation
#    Given User navigates to the Blaze website
#
#  Scenario Outline: Happy Path for Order Process
#    When User clicks the '<category>' and choose the item '<item>'
#    And User validates the '<header>' and '<alertMessage>' from alert pop-up after clicking Add to Cart button
#    And User clicks Cart button and validates the '<titleOfProduct>' and '<price>' then click Place Order Button
#    And User proves the information '<name>', '<country>', '<city>', '<creditCard>', '<month>', '<year>' and click Purchase Button
#    Then User validates the message '<finalMessage>' and url '<url>'
#    Examples:
#      | category | item         | header       | alertMessage  | titleOfProduct | price | name  | country | city    | creditCard | month | year | finalMessage                 | url                             |
#      | Laptops  | MacBook air  | MacBook air  | Product added | MacBook air    | 700   | Akram | USA     | Chicago | 1234567    | 12    | 2023 | Thank you for your purchase! | https://demoblaze.com/cart.html |
#      | Monitors | ASUS Full HD | ASUS Full HD | Product added | ASUS Full HD   | 230   | Ahmet | Turkey  | Ankara  | 7654321    | 11    | 2022 | Thank you for your purchase! | https://demoblaze.com/cart.html |


#  If you want to create scenario with DATA table you ca use this and LIST table
  Background: Navigation
    Given User navigates to the Blaze website

  Scenario: Happy Path for Order Process
    When User clicks the and choose the item
      | category | Laptops     |
      | item     | MacBook air |

    And User validates the 'MacBook air' and 'Product added' from alert pop-up after clicking Add to Cart button
    And User clicks Cart button and validates the 'MacBook air' and '700' then click Place Order Button
    And User proves the information 'Akram', 'USA', 'Chicago', '1234567', '12', '2023' and click Purchase Button
    Then User validates the message and url
      | Thank you for your purchase!    |
      | https://demoblaze.com/cart.html |