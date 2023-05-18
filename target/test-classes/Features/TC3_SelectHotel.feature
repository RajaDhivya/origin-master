
Feature: Select Hotel in OMR Branch Hotel Page Automation

  Scenario Outline: Select Hotel and Verify navigate to Book Hotel Upon Accepting the Alert
    Given User is on the OMR branch hotel page
    When User login "<Username>","<Password>"
    Then User should verify success message after login "Welcome Dhivya"
    When User search the hotel "<Select State>","<Select City>","<Select Room Type>","<Check In>","<Check Out>","<No.of Rooms>","<No.of Adults>" and "<No.of Childrens>"
    Then User should verify the message after search hotel "Select Hotel"
    When User select first hotel name and save the hotel name
    And User accept the alert message
    Then User should verify the success message after select hotel "Book Hotel"

    Examples: 
      | Username               | Password  | Select State | Select City | Select Room Type | Check In   | Check Out  | No.of Rooms | No.of Adults | No.of Childrens |
      | dhivyaraja04@gmail.com | Dhivya@04 | Tamil Nadu   | Chennai     | Standard         | 2023-04-25 | 2023-04-29 | 1-One       | 2-Two        |               1 |

  Scenario Outline: Select Hotel and Verify navigate in the Same Page Upon dismiss the Alert
    Given User is on the OMR branch hotel page
    When User login "<Username>","<Password>"
    Then User should verify success message after login "Welcome Dhivya"
    And User search the hotel "<Select State>","<Select City>","<Select Room Type>","<Check In>","<Check Out>","<No.of Rooms>","<No.of Adults>" and "<No.of Childrens>"
    Then User should verify the message after search hotel "Select Hotel"
    And User clicks continue button then cancel the alert message
    Then User should verify the message after search hotel "Select Hotel"

    Examples: 
      | Username               | Password  | Select State | Select City | Select Room Type | Check In   | Check Out  | No.of Rooms | No.of Adults | No.of Childrens |
      | dhivyaraja04@gmail.com | Dhivya@04 | Tamil Nadu   | Chennai     | Standard         | 2023-04-25 | 2023-04-29 | 1-One       | 2-Two        |               1 |

  Scenario Outline: Select hotel and verify navigate to book hotel upon accepting the alert
    Given User is on the OMR branch hotel page
    When User login "<Username>","<Password>"
    Then User should verify success message after login "Welcome Dhivya"
    And User search the hotel "<Select State>","<Select City>","<Select Room Type>","<Check In>","<Check Out>","<No.of Rooms>","<No.of Adults>" and "<No.of Childrens>"
    Then User should verify the message after search hotel "Select Hotel"
    And User sort by hotel name in ascending order by click the ascending order
    Then User should verify after select hotel hotel names are in ascending order

    Examples: 
      | Username               | Password  | Select State | Select City | Select Room Type | Check In   | Check Out  | No.of Rooms | No.of Adults | No.of Childrens |
      | dhivyaraja04@gmail.com | Dhivya@04 | Tamil Nadu   | Chennai     | Standard         | 2023-04-25 | 2023-04-29 | 1-One       | 2-Two        |               1 |

  Scenario Outline: Unselecting room type and verify listing all hotels
    Given User is on the OMR branch hotel page
    When User login "<Username>","<Password>"
    Then User should verify success message after login "Welcome Dhivya"
    And User search the hotel "<Select State>","<Select City>","<Select Room Type>","<Check In>","<Check Out>","<No.of Rooms>","<No.of Adults>" and "<No.of Childrens>"
    Then User should verify the message after search hotel "Select Hotel"
    And User unselect room type by clicking room type check box
    Then User should verify after search hotel all hotels are listing

    Examples: 
      | Username               | Password  | Select State | Select City | Select Room Type | Check In   | Check Out  | No.of Rooms | No.of Adults | No.of Childrens |
      | dhivyaraja04@gmail.com | Dhivya@04 | Tamil Nadu   | Chennai     | Standard         | 2023-04-25 | 2023-04-29 | 1-One       | 2-Two        |               1 |
