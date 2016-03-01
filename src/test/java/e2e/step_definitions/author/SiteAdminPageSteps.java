package e2e.step_definitions.author;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import e2e.Browser;
import e2e.base.Admin;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SiteAdminPageSteps {

    @When("^I create custom home page and go there$")
    public void createCustomPage() throws Throwable {
        Admin.siteAdminPage.adminTreeLinkClick("TravelSupermarket");
        Admin.siteAdminPage.adminTreeLinkClick("GB Home");
        Admin.siteAdminPage.clickOnHeaderButton("New...");
        System.out.println("\nI have taken to the page creation form\n");
        int id = (int) Math.round(Math.random() * 899 + 100);
        Browser.options.homePageTitle = "e2e_test_id"+id+"_home_page_title";
        Browser.options.homePageName = "test_"+id+"_name";
        assertEquals("Travel Supermarket Home Page", Admin.siteAdminPage.getXWindowSelectedItemText());
        Admin.siteAdminPage.xWindowInputSendKeys("title", Browser.options.homePageTitle);
        Admin.siteAdminPage.xWindowInputSendKeys("label", Browser.options.homePageName);
        Admin.siteAdminPage.xWindowButtonClick("Create");
        assertTrue(Admin.siteAdminPage.isSiteTreeLinkExist(Browser.options.homePageTitle));
        System.out.println("\nPage with title " + Browser.options.homePageTitle + " was created\n");
        Admin.siteAdminPage.adminTreeLinkClick(Browser.options.homePageTitle);
        System.out.println("\nGo to the custom page\n");
        Admin.siteAdminPage.doubleClickOnSiteTreeElement(Browser.options.homePageTitle);
    }

    @When("^I create custom navigation page and go there$")
    public void createCustomNavigationPage() throws Throwable {
        Admin.siteAdminPage.adminTreeLinkClick("TravelSupermarket");
        Admin.siteAdminPage.adminTreeLinkClick("GB Home");
        Admin.siteAdminPage.clickOnHeaderButton("New...");
        System.out.println("\nI have taken to the page creation form\n");
        int id = (int) Math.round(Math.random() * 899 + 100);
        Browser.options.navigationPageTitle = "e2e_test_id"+id+"_navigation_page_title";
        Browser.options.navigationPageName = "test_"+id+"_name";
        Admin.siteAdminPage.xWindowInputSendKeys("title", Browser.options.navigationPageTitle);
        Admin.siteAdminPage.xWindowInputSendKeys("label", Browser.options.navigationPageName);
        Admin.siteAdminPage.xWindowSelectItem("TravelSuperMarket Navigation Page");
        Admin.siteAdminPage.xWindowButtonClick("Create");
        assertTrue(Admin.siteAdminPage.isSiteTreeLinkExist(Browser.options.navigationPageTitle));
        System.out.println("\nPage with title " + Browser.options.navigationPageTitle + " was created\n");
        Admin.siteAdminPage.adminTreeLinkClick(Browser.options.navigationPageTitle);
        System.out.println("\nGo to the custom page\n");
        Admin.siteAdminPage.doubleClickOnSiteTreeElement(Browser.options.navigationPageTitle);
    }

    @When("^I create custom list items page and go there$")
    public void createCustomListItemsPage() throws Throwable {
        Admin.siteAdminPage.adminTreeLinkClick("TravelSupermarket");
        Admin.siteAdminPage.adminTreeLinkClick("My Directories");
        Admin.siteAdminPage.clickOnHeaderButton("New...");
        System.out.println("\nI have taken to the page creation form\n");
        int id = (int) Math.round(Math.random() * 899 + 100);
        Browser.options.listItemsPageTitle = "e2e_test_id"+id+"_list_items_page_title";
        Browser.options.listItemsPageName = "test_"+id+"_name";
        assertEquals("Travel Supermarket Home Page", Admin.siteAdminPage.getXWindowSelectedItemText());
        Admin.siteAdminPage.xWindowInputSendKeys("title", Browser.options.listItemsPageTitle);
        Admin.siteAdminPage.xWindowInputSendKeys("label", Browser.options.listItemsPageName);
        Admin.siteAdminPage.xWindowSelectItem("Travel Supermarket Directory List Items Page");
        Admin.siteAdminPage.xWindowButtonClick("Create");
        assertTrue(Admin.siteAdminPage.isSiteTreeLinkExist(Browser.options.listItemsPageTitle));
        System.out.println("\nPage with title " + Browser.options.listItemsPageTitle + " was created\n");
        Admin.siteAdminPage.adminTreeLinkClick(Browser.options.listItemsPageTitle);
        System.out.println("\nGo to the custom page\n");
        Admin.siteAdminPage.doubleClickOnSiteTreeElement(Browser.options.listItemsPageTitle);
    }

    @When("^I go to the '(.+)' in the '(.+)' directory$")
    public void goToPage(String page, String directory) throws Throwable {
        Admin.siteAdminPage.adminTreeLinkClick("TravelSupermarket");
        Admin.siteAdminPage.adminTreeLinkClick(directory);
        Admin.siteAdminPage.doubleClickOnSiteTreeElement(page);
    }

}
