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
#
#  Scenario: Do some generic browser test
#    When I go to "https://www.amplemarket.com/"
#    And I validate presence of 5 main menus
#    When I select main menu "Product"
#    And I select sub menu "Email Validation"
#    When I enter a invalid email
#    Then I validate browser log status "403"
#    Then I see a error message
#    And I wait some time


  Scenario: Validate extension file size formats
    When I go to "https://github.com/harshjv/github-repo-size"
    #Then I wait some time
    And I validate presence of plugin file size elements
    Then I validate all file sizes show correct file size format
    #When I go to "https://www.amplemarket.com/"
    #And I clear browser cache
    #Then I go to "https://github.com/harshjv/github-repo-size"
    #And I validate all file sizes show same file size

#  Scenario: Validate extension file size present inside sub folders
#    When I go to "https://github.com/harshjv/github-repo-size"
#    And I enter a folder on the repo
#    Then I validate presence of plugin file size elements
#    And I validate all file sizes show correct file size format
#    Then I wait some time
#
#  Scenario: Validate file size is constant
#    When I go to "https://github.com/harshjv/github-repo-size"
#    Then I get all file size data
#    When I go to "https://www.amplemarket.com/"
#    And I clear browser cache
#    Then I go to "https://github.com/harshjv/github-repo-size"
#    And I validate all file size data is the same
#    Then I wait some time




