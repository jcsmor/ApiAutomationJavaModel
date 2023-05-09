Feature: ABP Chromium - Basic Functionality

  Scenario Outline: Verify ads are blocked when ABP is ON and AA is OFF
    Given I go to AdBlocking Settings
    And I wait until extensions are installed
    And I verify ABP is enabled
    When I go to "<url>" and get browser extension logs

    Examples:
      | url                                                                                     |
      | https://eyeo.com/                                                                       |
      | https://www.portent.com/blog/seo/createxxx-a-great-404-page.htm                         |