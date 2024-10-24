Feature: AdactinHotel Application

  Scenario Outline: Validate the loginpage with multiple data using valid and invalid data
    Given User should be navigate to LoginPage
    When User enter username "<username>" and password "<password>"
    And User click the login button
    Then User should validate the message "<message>"

    Examples: 
      | username  | password | message                                                                                      |
      | Ragul2002 | E5205Y   | Welcome to Adactin Group of Hotels                                                           |
      | Ragul2002 | Abcd@01  | Invalid Login details or Your Password might have expired. Click here to reset your password |
      | Prem      | E5205Y   | Invalid Login details or Your Password might have expired. Click here to reset your password |
      |           | E5205Y   | Enter Username                                                                               |
      | Ragul2002 |          | Enter Password                                                                               |
      |           |          | Enter Username                                                                               |