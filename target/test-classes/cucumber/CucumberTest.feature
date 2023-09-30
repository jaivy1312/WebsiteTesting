
@tag
Feature: Purchase the order from an Eccomerce website
  I want to use this template for my feature file
	Background: I landed on ecommerce loginPage
  @tag2
  Scenario Outline: Test for submitting the order
    Given I landed on ecommerce loginPage
    Given Logged in using username<username> and password<password>
    When I add product<productName> in the cart
    And checkoutPage verify order<productName> and submit order
    Then "Thankyou for the order." messege is displayed on confirmationPage

    Examples: 
      | username                    | password    | productName     |
      | jaibirsingh1312@gmail.com   |  123456     | adidas original |
      | jaibirsingh131213@gmail.com |  @Ks123456  | zara coat 3     |
