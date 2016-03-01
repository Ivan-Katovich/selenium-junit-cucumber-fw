package e2e.step_definitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import e2e.Browser;
import e2e.Config;
import e2e.base.Admin;
import e2e.data.WebElementData;
import e2e.support.Helper;
import org.openqa.selenium.Dimension;

import static org.junit.Assert.*;

public class BrowserSteps {

    @Given("^I am on the siteadmin page logged as administrator$")
    public void goToSiteadminPageAsAdmin() throws Throwable {
        if(!Browser.driver.getCurrentUrl().contains("/siteadmin")){
            try{
                Browser.driver.get(Config.author + "/siteadmin");
                if (Admin.loginPage == null){
                    Admin.initLoginPage();
                }
                Admin.loginPage.login(Config.authorLogin, Config.authorPassword);
            }catch(Exception e){
                System.out.println("Can't join author page. Will try once more after timeout");
                Thread.sleep(2000);
                Browser.driver.get(Config.author + "/siteadmin");
                if (Admin.loginPage == null){
                    Admin.initLoginPage();
                }
                Admin.loginPage.login(Config.authorLogin, Config.authorPassword);
            }
            if(Admin.siteAdminPage == null){
                Admin.initSiteAdminPage();
            }
            String admin = Admin.siteAdminPage.getUserName();
            admin = admin.replaceAll("\\s+", "");
            assertEquals(admin,"Administrator");
            System.out.println("\n Logged siteadmin page as administrator \n");
            Browser.options.firstHandle = Browser.driver.getWindowHandle();
            new WebElementData("body").waitForPresent(Browser.driver);
        }else{
            Thread.sleep(1000);
        }
    }

    @When("^I open custom '(.+)' page on publish$")
    public void openPublishCustomPage(String pageType) throws Throwable {
        System.out.println("\n Go to the custom page on publish \n");
        String item;
        switch(pageType){
            case "home":
                item = "en-gb/" + Browser.options.homePageName + "/";
                break;
            case "list items":
                item = "my-directories/" + Browser.options.listItemsPageName + "/";
                break;
            case "navigation":
                item = "en-gb/" + Browser.options.navigationPageName + "/";
                break;
            default:
                throw new AssertionError("Wrong page type");
        }
        Browser.driver.get(Config.publish + item);
        if(Admin.publishCustomPage == null){
            Admin.initPublishCustomPage();
        }
        Admin.publishCustomPage.closeCookieNotice();
        Admin.publishCustomPage.closeGlobalError();
        new WebElementData("body").waitForPresent(Browser.driver);
    }

    @Then("^I should be taken on the '(.+)' page in a new tab$")
    public void isTakenOnTheNamedCustomPge(String page) throws Throwable {
        Helper.switchToHandle(2);
        String url = Browser.driver.getCurrentUrl();
        String item;
        switch(page){
            case "home":
                item = Browser.options.homePageName;
                break;
            case "list items":
                item = Browser.options.listItemsPageName;
                break;
            case "navigation":
                item = Browser.options.navigationPageName;
                break;
            case "SuperHome":
                item = "superhomepage";
                break;
            default:
                throw new AssertionError("Wromg page type");
        }
        assertTrue(url.contains(item));
        Browser.driver.manage().window().setSize(new Dimension(1900,1000));
        new WebElementData("body").waitForPresent(Browser.driver);
        if(Admin.customPage == null){
            Admin.initCustomPage();
        }
        Admin.customPage.closeCookieNotice();
        Admin.customPage.closeGlobalError();
        System.out.println("\nCustom page appears\n");
    }

    @Then("^I should be taken on the SuperHomePage page in a new tab$")
    public void isTakenOnSuperHomePage() throws Throwable {
        Helper.switchToHandle(2);
        String url = Browser.driver.getCurrentUrl();
        assertTrue(url.contains("superhomepage"));
        Browser.driver.manage().window().setSize(new Dimension(1900,1000));
        new WebElementData("body").waitForPresent(Browser.driver);
        if(Admin.superHomePage == null){
            Admin.initSuperHomePage();
        }
        Admin.superHomePage.closeCookieNotice();
        System.out.println("\nSuperHomePage appears\n");
    }


}
