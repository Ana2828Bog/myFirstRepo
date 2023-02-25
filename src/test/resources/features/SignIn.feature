Feature: TEK Retail Application SignIn feature

  Background: 
    Given User is on retail website
    Then User click on Sign in option

  Scenario: Verify user can sign in into Retail Application
    And User enter email 'ana.bog2888@gmail.com' and password 'Ana_bOg2828'
    And User click on login button
    Then User should be logged in  into Account


  Scenario Outline: Verify user can sign in into Retail Application
    And User enter email '<email>' and password '<password>'
    And User click on login button
    Then User should be logged in into Account

    Examples: 
      | email                     | password  |
      | transforms@tekschool.us | Tek@12345 |
      | phtom.test@gmail.com    | Tek@12345 |

  Scenario: Verify user can create an account into Retail Website
    And User click on Create New Account button
    And User fill the signUp information with bellow data
      | name | email          | password  | confirmPassword |
      | John | john23@tek.com | John12345 | John12345       |
      | Ana  | ana654@tek.com | Ana69647  | Ana69647        |
    And User click on SignUp button
    Then User should be logged into account page
