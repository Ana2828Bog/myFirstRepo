Feature: Retail Application Account Feature

  Background: 
    Given User is on retail website
    Then User click on Sign in option
    And User enter email 'ana.bog2888@gmail.com' and password 'Ana_bOg2828'
    And User click on login button
    Then User should be logged in into Account

  Scenario: Verify User can update Profile Information
    When User click on Account option
    And User update Name 'John' and Phone '1012028855'
    And User click on Update button
    Then User profile information should be updated

  Scenario: Verify User can Update password
    When User click on Account option
    And User enter below information
      | previousPassword | newPassword | confirmPassword |
      | ana_bOg2828      | Ana_bOg2828 | Ana_bOg2828     |
    And User click on Change Password button
    Then a message should be displayed ‘Password Updated Successfully’

  Scenario: Verify User can add a payment method
    When User click on Account option
    And User click on Add a payment method link
    And User fill Debit or credit card information
      | cardNumber       | nameOnCard   | expirationMonth | expirationYear | securityCode |
      | 1234567890123456 | Alina Palina |               7 |           2034 |          567 |
    And User click on Add your card button
    Then a message should be displayed ‘Payment Method added successfully’

  Scenario: Verify User can edit Debit or Credit card
    When User click on Account option
    And User click on Card in the Wallet
    And User click on Edit option of card section
    And user edit information with below data
      | cardNumber       | nameOnCard | expirationMonth | expirationYear | securityCode |
      | 1234567892323456 | Olga Jytu  |               4 |           2038 |          877 |
    And user click on Update Your Card button
    Then a message should be displayed ‘Payment Method updated Successfully’

  Scenario: Verify User can remove Debit or Credit card
    When User click on Account option
    And User click on Card in the Wallet
    And User click on remove option of card section
    Then payment details should be removed
@TestRun
  Scenario: Verify User can add an Address
    When User click on Account option
    And User click on Add address option
    And user fill new address form with below information
      | country | fullName | phoneNumber | streetAddress | apt | city | state | zipCode |
    And User click Add Your Address button
    Then a message should be displayed 'Address Added Successfully'

  Scenario: Verify User can edit an Address added on account
    When User click on Account option
    And User click on edit address option
    And user fill new address form with below information
      | country | fullName | phoneNumber | streetAddress | apt   | city  | state | zipCode |
    And User click update Your Address button
    Then a message should be displayed ‘Address Updated Successfully’

  @dryRun
  Scenario: Verify User can remove Address from Account
    When User click on Account option
    And User click on remove option of Address section
    Then Address details should be removed
