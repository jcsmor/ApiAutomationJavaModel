Feature: Browser - Basic Functionality

  Scenario: Do some generic browser test
    When I go to "https://www.amplemarket.com/"
    And I validate presence of '5' main menus
