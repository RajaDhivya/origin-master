
Feature: Book Hotel in OMR Branch Hotel Page Automation

  Scenario Outline: Book hotel without including GST and special request
    Given User is on the OMR branch hotel page
    When User login "<Username>","<Password>"
    Then User should verify success message after login "Welcome Dhivya"
    When User search the hotel "<Select State>","<Select City>","<Select Room Type>","<Check In>","<Check Out>","<No.of Rooms>","<No.of Adults>" and "<No.of Childrens>"
    Then User should verify the message after search hotel "Select Hotel"
    When User select first hotel name and save the hotel name
    When User add guest details"<Salutation>","<Firstname>","<Lastname>","<Mobile no.>"and"<email id>"
    And User enter payment details,proceed with card type"<Card type>"
      | Card       | Card no.          | Card name | Month  | Year | cvv |
      | Visa       | 55555555555552223 | Dhivya    | May    | 2023 | 789 |
      | Amex       |  2835764835646745 | Raja      | August | 2028 | 456 |
      | Mastercard |  5656585898987895 | Raje      | July   | 2032 | 786 |
      | Discover   |  8564568756123455 | Deepa     | July   | 2046 | 231 |
    Then User should verify the success message after payment "Booking is Confirmed" and save the order ID
    And User should verify selected hotel is present

    Examples: 
      | Username               | Password  | Select State | Select City | Select Room Type | Check In   | Check Out  | No.of Rooms | No.of Adults | No.of Childrens | Salutation | Firstname | Lastname | Mobileno.  | email id               | Card type   |
      | dhivyaraja04@gmail.com | Dhivya@04 | Tamil Nadu   | Chennai     | Standard         | 2023-04-25 | 2023-04-29 | 1-One       | 2-Two        |               1 | Ms.        | Dhivya    | Raja     | 9566776118 | dhivyaraja04@gmail.com | Cerdit Card |

  Scenario Outline: Enter invalid UPI id and verify error message
    Given User is on the OMR branch hotel page
    When User login "<Username>","<Password>"
    Then User should verify success message after login "Welcome Dhivya"
    When User search the hotel "<Select State>","<Select City>","<Select Room Type>","<Check In>","<Check Out>","<No.of Rooms>","<No.of Adults>" and "<No.of Childrens>"
    Then User should verify the message after search hotel "Select Hotel"
    When User select first hotel name and save the hotel name
    When User add guest details"<Salutation>","<Firstname>","<Lastname>","<Mobile no.>"and"<email id>"
    And User enter the payment details by UPI id "<Enter UPI id>"
    Then User should verify the error message after payment details "Invalid UPI ID"

    Examples: 
      | Username               | Password  | Select State | Select City | Select Room Type | Check In   | Check Out  | No.of Rooms | No.of Adults | No.of Childrens | Salutation | Firstname | Lastname | Mobileno.  | email id               | Enter UPI id |
      | dhivyaraja04@gmail.com | Dhivya@04 | Tamil Nadu   | Chennai     | Standard         | 2023-04-25 | 2023-04-29 | 1-One       | 2-Two        |               1 | Ms.        | Dhivya    | Raja     | 9566776118 | dhivyaraja04@gmail.com | Dhivya@sbi   |

  Scenario Outline: Enter invalid Card details and verify error message
    Given User is on the OMR branch hotel page
    When User login "<Username>","<Password>"
    Then User should verify success message after login "Welcome Dhivya"
    When User search the hotel "<Select State>","<Select City>","<Select Room Type>","<Check In>","<Check Out>","<No.of Rooms>","<No.of Adults>" and "<No.of Childrens>"
    Then User should verify the message after search hotel "Select Hotel"
    When User select first hotel name and save the hotel name
    When User add guest details"<Salutation>","<Firstname>","<Lastname>","<Mobile no.>"and"<email id>"
    And User enter payment details,proceed with card type"<Card type>"
      | Card       | Card no.         | Card name | Month  | Year | cvv |
      | Visa       | 6565656565654515 | Dhivya    | May    | 2023 | 789 |
      | Amex       |  283576483564674 | Raja      | August | 2028 | 456 |
      | Mastercard | 5656585898987895 | Deepa     | July   | 2032 | 786 |
      | Discover   |  856456875612345 | Raje      | July   | 2046 | 231 |
    Then User should verify the error message after entering card details "Invalid Card number"

    Examples: 
      | Username               | Password  | Select State | Select City | Select Room Type | Check In   | Check Out  | No.of Rooms | No.of Adults | No.of Childrens | Salutation | Firstname | Lastname | Mobileno.  | email id               | Card Type   |
      | dhivyaraja04@gmail.com | Dhivya@04 | Tamil Nadu   | Chennai     | Standard         | 2023-04-25 | 2023-04-29 | 1-One       | 2-Two        |               1 | Ms.        | Dhivya    | Raja     | 9566776118 | dhivyaraja04@gmail.com | Credit Card |
