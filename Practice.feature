Feature: E-commerce Checkout Workflow
  As a user
  I want to complete the checkout process successfully
  So that I can purchase items from the e-commerce platform
  Background:
    Given the user is on the login page

  Scenario: Complete checkout with valid details
    When the user logs in with valid credentials
      | username       | password      |
      | standard_user  | secret_sauce  |
    And the user adds the following items to the cart:
      | Item Name           |
      | Sauce Labs Backpack |
    When the user proceeds to checkout with the following details:
      | First Name | Last Name | Zip Code |
      | John       | Doe       | 12345    |
    And the order confirmation message should be "Thank you for your order!"
