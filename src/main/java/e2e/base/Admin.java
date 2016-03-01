package e2e.base;

import com.github.webdriverextensions.WebDriverExtensionFieldDecorator;
import e2e.Browser;
import e2e.pages.author.CustomPage;
import e2e.pages.author.LoginPage;
import e2e.pages.author.SiteAdminPage;
import e2e.pages.author.SuperHomePage;
import e2e.pages.publish.PublishCustomPage;
import org.openqa.selenium.support.PageFactory;

public class Admin {

    public static SiteAdminPage siteAdminPage;

    public static CustomPage customPage;

    public static PublishCustomPage publishCustomPage;

    public static LoginPage loginPage;

    public static SuperHomePage superHomePage;


    public static void initLoginPage(){
        loginPage =  new LoginPage();
        PageFactory.initElements(new WebDriverExtensionFieldDecorator(Browser.driver), loginPage);
    }

    public static void initSiteAdminPage(){
        siteAdminPage =  new SiteAdminPage();
        PageFactory.initElements(new WebDriverExtensionFieldDecorator(Browser.driver), siteAdminPage);
    }

    public static void initCustomPage(){
        customPage =  new CustomPage();
        PageFactory.initElements(new WebDriverExtensionFieldDecorator(Browser.driver), customPage);
    }

    public static void initPublishCustomPage(){
        publishCustomPage =  new PublishCustomPage();
        PageFactory.initElements(new WebDriverExtensionFieldDecorator(Browser.driver), publishCustomPage);
    }

    public static void initSuperHomePage(){
        superHomePage =  new SuperHomePage();
        PageFactory.initElements(new WebDriverExtensionFieldDecorator(Browser.driver), superHomePage);
    }


}
