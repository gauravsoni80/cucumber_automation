@tag
Feature: Amazon SignIn Features

  @tag1
  Scenario: Amazon SignIn Successfully
  	Given Amazon Click Account List
    And Amazon Get UserName
    And Amazon Click Continue Btn
    When Amazon Get Password
    And Amazon Remember Me
    And Amazon Login Btn Click
    And Amazon Otp Verification
    Then Amazon Logout
    Then Close Browser