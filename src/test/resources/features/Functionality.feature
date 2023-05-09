Feature: ABP Chromium - Basic Functionality

  Scenario Outline: Verify ads are blocked when ABP is ON and AA is OFF
    Given I go to AdBlocking Settings
    And I wait until extensions are installed
    And I verify ABP is enabled
    When I go to "<url>" and get browser extension logs

    Examples:
      | url                                                                                     |
      | https://www.google.com/search?q=iphone&source=hp&ei=TnIIZMD1CIvagQb8z5mwBA&iflsig=AK50M_UAAAAAZAiAXuaTRudOg_erHsyrE8w6v6roM3OB&ved=0ahUKEwjA1KORnsz9AhULbcAKHfxnBkYQ4dUDCAs&uact=5&oq=iphone&gs_lcp=Cgdnd3Mtd2l6EAMyBQgAEIAEMgUIABCABDIFCAAQgAQyBQgAEIAEMgUIABCABDIFCAAQgAQyBQgAEIAEMgUIABCABDIFCAAQgAQyBQgAEIAEOgsILhCABBDHARDRAzoFCC4QgARQAFj0BmDlB2gAcAB4AIABV4gBvQOSAQE2mAEAoAEB&sclient=gws-wiz |