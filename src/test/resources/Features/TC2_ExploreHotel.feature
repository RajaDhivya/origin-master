
Feature: Exploring OMR Branch Hotel Page Automation

  Scenario Outline: Enter all field and verify select hotel
    Given User is on the OMR branch hotel page
    When User login "<Username>","<Password>"
    Then User should verify success message after login "Welcome Dhivya"
    And User search the hotel "<Select State>","<Select City>","<Select Room Type>","<Check In>","<Check Out>","<No.of Rooms>","<No.of Adults>" and "<No.of Childrens>"
    Then User should verify the message after search hotel "Select Hotel"

    Examples: 
      | Username               | Password  | Select State | Select City | Select Room Type | Check In   | Check Out  | No.of Rooms | No.of Adults | No.of Childrens |
      | dhivyaraja04@gmail.com | Dhivya@04 | Tamil Nadu   | Chennai     | Standard         | 2023-04-25 | 2023-04-29 | 1-One       | 2-Two        |               1 |

  Scenario Outline: Select multiple room type and verify same filter in header
    Given User is on the OMR branch hotel page
    When User login "<Username>","<Password>"
    Then User should verify success message after login "Welcome Dhivya"
    And User search the hotel "<Select State>","<Select City>","<Select Room Type>","<Check In>","<Check Out>","<No.of Rooms>","<No.of Adults>" and "<No.of Childrens>"
    Then User should verify selected room type filter in Header "<Select Room Type>"

    Examples: 
      | Username               | Password  | Select State | Select City | Select Room Type      | Check In   | Check Out  | No.of Rooms | No.of Adults | No.of Childrens |
      | dhivyaraja04@gmail.com | Dhivya@04 | Tamil Nadu   | Chennai     | Standard/Deluxe/Suite | 2023-04-25 | 2023-04-29 | 1-One       | 2-Two        |               1 |

  Scenario Outline: Passing room type and verify hotel name ends wih Same room type
    Given User is on the OMR branch hotel page
    When User login "<Username>","<Password>"
    Then User should verify success message after login "Welcome Dhivya"
    And User search the hotel "<Select State>","<Select City>","<Select Room Type>","<Check In>","<Check Out>","<No.of Rooms>","<No.of Adults>" and "<No.of Childrens>"
    Then User should verify hotel name ends with "<Select Room Type>"

    Examples: 
      | Username               | Password  | Select State | Select City | Select Room Type | Check In   | Check Out  | No.of Rooms | No.of Adults | No.of Childrens |
      | dhivyaraja04@gmail.com | Dhivya@04 | Tamil Nadu   | Chennai     | Standard         | 2023-04-25 | 2023-04-29 | 1-One       | 2-Two        |               1 |

  Scenario Outline: Without Entering Any Field Click Search and Verify All 6 Error Message
    Given User is on the OMR branch hotel page
    When User login "<Username>","<Password>"
    Then User should verify success message after login "Welcome Dhivya"
    And User click search button
    Then User should verify the 6 error message "Please select state","Please select city","Please select check-in date","Please select check-out date","Please select no. of rooms","Please select no. of adults"

    Examples: 
      | Username               | Password  |
      | dhivyaraja04@gmail.com | Dhivya@04 |
