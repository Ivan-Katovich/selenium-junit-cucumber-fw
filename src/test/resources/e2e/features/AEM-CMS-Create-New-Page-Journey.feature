Feature: AEM CMS Creation New Page Journey
    As an administrator of AEM CMS
    I should be able to have access to aem cms
    So I can create a new page and check it on the publish

    Background:
        Given I am on the siteadmin page logged as administrator

    @AEM-Page-Creation-Journey
    Scenario: AEM CMS Creation New List Items Page
        When I create custom list items page and go there
        Then I should be taken on the 'list items' page in a new tab
        When I add Merchandising and SEO items to the custom list items page


    @AEM-Page-Creation-Journey
    Scenario: AEM CMS Creation New Home Page with Directory containers
        When I create custom home page and go there
        Then I should be taken on the 'home' page in a new tab
        When I add custom Merchandising and SEO directory containers to the custom home page
        And I open custom 'home' page on publish
        Then Publish custom page should contains correct directory containers


    @AEM-Page-Creation-Journey
    Scenario: AEM CMS Creation New Home Page with Text and Image Containers
        When I create custom home page and go there
        Then I should be taken on the 'home' page in a new tab
        When I add text items to the custom Home page
        And I open custom 'home' page on publish
        Then Publish custom page should contains correct text content


    @AEM-Page-Creation-Journey
    Scenario: AEM CMS Creation New Home Page with Page containers
        When I create custom home page and go there
        Then I should be taken on the 'home' page in a new tab
        When I add Page items to the custom Home page
        And I open custom 'home' page on publish
        Then Publish custom page should contains correct Page Items

    @AEM-Page-Creation-Journey
    Scenario: AEM CMS Creation New Home Page with Auxiliary containers
        When I create custom navigation page and go there
        Then I should be taken on the 'navigation' page in a new tab
        When I add Auxiliary items to the custom navigation page
        And I open custom 'navigation' page on publish
        Then Publish custom page should contains correct auxiliary content

    @AEM-Page-Creation-Journey
    Scenario: AEM CMS Creation New Home Page with Advertising containers
        When I create custom home page and go there
        Then I should be taken on the 'home' page in a new tab
        When I add Advertising containers to the custom Home page
        And I open custom 'home' page on publish
        Then Publish custom page should contains correct Third Party controllers











