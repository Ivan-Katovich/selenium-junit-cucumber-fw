Feature: AEM CMS SuperHomePage tests
    As an administrator of AEM CMS
    I should be able to to go to the SuperHomePage
    So following components should be present on the SuperHomePage

    Background:
        Given I am on the siteadmin page logged as administrator
        When I go to the 'SuperHomePage' in the 'GB Home' directory
        Then I should be taken on the SuperHomePage page in a new tab

    @AEM-SuperHomePage
    Scenario: AEM CMS Check SuperHomePage main screen elements
        Then SuperHomePage first screen components should displayed correctly
        And SuperHomePage properties should contains Search Gadget tab

    @AEM-SuperHomePage
    Scenario: AEM CMS Check SuperHomePage navigation section
        Then SuperHomePage navigation section should works correctly

    @AEM-SuperHomePage
    Scenario: AEM CMS Check SuperHomePage second screen components
        Then SuperHomePage second screen components should displayed correctly

    @AEM-SuperHomePage
    Scenario: AEM CMS Check SuperHomePage third screen components
        Then SuperHomePage third screen components should displayed correctly

    @AEM-SuperHomePage
    Scenario: AEM CMS Check SuperHomePage fourth screen components
        Then SuperHomePage fourth screen components should displayed correctly
