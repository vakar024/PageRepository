
Feature: End to End scenerio for TestMeApp
  Login with an account and purchase and complete the payment process

  @CompleteProcess
  Scenario:  Sucessful purchase
    Given User is on home page 
    When User enters username and password and clicks on the login button
     Then Navigate to all categories -electronics and headphone
    And Add product into shopping cart and checkout
    And Select bank and add credentials
    Then Redirected to thank you page

   