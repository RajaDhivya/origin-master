
Feature: Change the booking in OMR Branch Hotel Page Automation

  Scenario Outline: Verify change booking
    Given User is on the OMR branch hotel page
    When User login "<Username>","<Password>"
    Then User should verify success message after login "Welcome Dhivya"
    When User search the hotel "<Select State>","<Select City>","<Select Room Type>","<Check In>","<Check Out>","<No.of Rooms>","<No.of Adults>" and "<No.of Childrens>"
    Then User should verify the message after search hotel "Select Hotel"
    When User select first hotel name and save the hotel name
    Then User add guest details"<Salutation>","<Firstname>","<Lastname>","<Mobile no.>"and"<email id>"
    And User enter payment details,proceed with card type"<Card type>"
      | Card       | Card no.          | Card name | Month  | Year | cvv |
      | Visa       | 55555555555552223 | Dhivya    | May    | 2023 | 789 |
      | Amex       |  2835764835646745 | Raja      | August | 2028 | 456 |
      | Mastercard |  5656585898987895 | Raje      | July   | 2032 | 786 |
      | Discover   |  8564568756123455 | Deepa     | July   | 2046 | 231 |
    Then User should verify the success message after payment "Booking is Confirmed" and save the order ID
    And User should verify selected hotel is present
    When User navigate to my booking page and search order id
    Then User should verify the hotel name and same order id is present
    When User perform the edit order id "<Check in date>"
    Then User should verify the success message after editing "Booking updated successfully "

    Examples: 
      | Username               | Password  | Select State | Select City | Select Room Type | Check In   | Check Out  | No.of Rooms | No.of Adults | No.of Childrens | Salutation | Firstname | Lastname | Mobileno.  | email id               | Card Type   |
      | dhivyaraja04@gmail.com | Dhivya@04 | Tamil Nadu   | Chennai     | Standard         | 2023-04-25 | 2023-04-29 | 1-One       | 2-Two        |               1 | Ms.        | Dhivya    | Raja     | 9566776118 | dhivyaraja04@gmail.com | Credit Card |
