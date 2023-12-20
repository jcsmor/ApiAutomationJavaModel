Feature: Browser - Basic Functionality

#  Scenario: Do some generic browser test
#    When I go to "https://www.amplemarket.com/"
#    And I validate presence of 5 main menus
#    When I select main menu "Product"
#    And I select sub menu "Email Validation"
#    When I enter a invalid email
#    Then I validate browser log status "403"
#    Then I see a error message
#    And I wait some time

  Scenario: Do some generic browser test
    When I go to "https://www.amplemarket.com/"
    And I validate presence of 5 main menus
    When I select main menu "Product"
    And I select sub menu "Email Validation"
    When I enter a invalid email
    Then I validate browser log status "403"
    Then I see a error message
    And I wait some time


