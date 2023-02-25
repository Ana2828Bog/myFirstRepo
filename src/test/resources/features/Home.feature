Feature: Retail Home Page

  Scenario: Verify user can search a product
    Given user is on retail website
    When User search for "pokemon" product
    Then The product should be displayed

  Scenario: Verify Shop by Department sidebar
    Given User is on retail website
    When User click on All section
    Then below option are present in shop by department sidebar
      | Electronics | Computers | Smart Home | Sports | Automative |

  Scenario Outline: Verify Department sidebar options
    Given User is on retail website
    When User click on All section
    And User on '<Electronics>'
    Then below options are present in department
      | <optionOne> | <optionTwo> |

    Examples: 
      | department  | optionOne                      | optionTwo                |
      | Electronics | TV & Video                     | Video Games              |
      | Computers   | Accessories                    | Networking               |
      | Smart Home  | Smart Home Lightning           | Plugs and Outlets        |
      | Sports      | Athletic Clothing              | Exercise & Fitness       |
      | Automative  | Automative Parts & Accessories | MotorCycle & Powersports |

  Scenario: Verify User can add an item to cart
    Given User is on retail website
    When User click on Sign in option
    And User enter email 'ana.bog2888@gmail.com' and password 'Ana_bOg2828'
    And User click on login button
    And User should be logged in into Account
    And User change the category to 'Smart Home'
    And User search for an item 'kasa outdoor smart plug'
    And User click on Search icon
    And User click on item
    And User select quantity '2'
    And User click add to Cart button
    Then the cart icon quantity should change to '2'

  
  Scenario: Verify User can place an order without Shipping address and payment Method on file
    Given User is on retail website
    When User click on Sign in option
    And User enter email 'ana.bog2888@gmail.com' and password 'Ana_bOg2828'
    And User click on login button
    And User change the category to 'Smart Home'
    And User search for an item 'kasa outdoor smart plug'
    And User click on Search icon
    And User click on item
    And User select quantity '2'
    And User click add to Cart button
    Then the cart icon quantity should change to '2'
    And User click on Cart option
    And User click on Proceed to Checkout button
    And User click Add a new address link for shipping address
    And User fill new address form with below information
      | country | fullName | phoneNumber | streetAddress | apt | city | state | zipCode |
      | Ukraine | Ana Boh  |  4678665675 | Kombinatna    |  65 | Kyiv | Kyiv  |   22202 |
    And User click Add Your Address button
    And User click Add a credit card or Debit Card for Payment method
    And User fill Debit or credit card information
      | cardNumber       | nameOnCard | expirationMonth | expirationYear | securityCode |
      | 1234567890123456 | Ana boh    |               5 |           2038 |          665 |
    And User click on Add your card button
    And User click on Place Your Order
    Then a message should be displayed Order Placed, Thanks’
    
    @smokeTest
    Scenario: Verify User can place an order with Shipping address and payment Method on file
    Given User is on retail website
    When User click on Sign in option
    And User enter email 'ana.bog2888@gmail.com' and password 'Ana_bOg2828'
    And User click on login button
    And User should be logged in into Account
    And User change the category to 'Electronics'
    And User search for an item 'Apex Legends '
    And User click on Search icon
    And User click on item 
    And User select quantity '5'
    And User click add to Cart button 
    Then the cart icon quantity should change to '5'
    And User click on Cart option 
    And User click on Proceed to Checkout button
    And User click on Place Your Order
    Then a message should be displayed ‘Order Placed, Thanks’
