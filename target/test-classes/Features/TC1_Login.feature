@Login
Feature: Verifying OMR branch hotel login automation

  Scenario Outline: Verifying login with valid credentials
    Given User is on the OMR branch hotel page
    When User login "<Username>","<Password>"
    Then User should verify success message after login "Welcome Dhivya"

    Examples: 
      | Username               | Password  |
      | dhivyaraja04@gmail.com | Dhivya@04 |

  Scenario Outline: Login with robot -with help of keyboard actions
    Given User is on the OMR branch hotel page
    When User login "<Username>","<Password>"
    Then User should verify success message after login "Welcome Dhivya"

    Examples: 
      | Username               | Password  |
      | dhivyaraja04@gmail.com | Dhivya@04 |

  Scenario Outline: Verifying login with invalid credentials
    Given User is on the OMR branch hotel page
    When User login "<Username>","<Password>"
    Then User should verify error message after login "Invalid Login details or your password might have expired"

    Examples: 
      | Username               | Password  |
      | dhivyaraja04@gmail.com | Naveen$04 |
