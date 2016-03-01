package e2e.support;

import e2e.Browser;
import e2e.Config;
import e2e.base.Admin;
import e2e.data.ElementData;
import e2e.data.WebElementData;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.*;
import java.util.NoSuchElementException;

public class Helper {

//    public static void waitForAjax(){
//        JavascriptExecutor executor = (JavascriptExecutor) Browser.driver;
//        long time = new Date().getTime();
//        long endTime = time+5000;
//        int pooling = 1000;
//        do{
//            try {
//                Thread.sleep(pooling);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            time = new Date().getTime();
//        }while(!executor.executeScript("return window.jQuery.active === 0").equals(true)&&time<endTime);
//        try{
//            Browser.driver.switchTo().alert();
//            Browser.driver.manage().addCookie(Browser.options.rememberedCookie);
//            Browser.driver.switchTo().alert().accept();
//        }catch(NoAlertPresentException e){
//            System.out.println("no alerts");
//        }
//        if(Browser.driver.getCurrentUrl().contains("login")){
//            System.out.println(" You are was logged out. Try to login once more !!!");
//            Admin.loginPage.login(Config.authorlogin, Config.authorPassword);
//        }
//    }

    public static void switchToHandle(int num){
        Set<String> handles = Browser.driver.getWindowHandles();
        List h = new ArrayList<String>(handles);
        Browser.driver.switchTo().window((String) h.get(num - 1));
    }

    public static void switchToHandle(String handle){
        Browser.driver.switchTo().window(handle);
    }


    public static void environmentCleaner() throws InterruptedException {
        System.out.println("\n environment cleaner starts\n");
        Browser.driver.manage().addCookie(Browser.options.rememberedCookie);
        Admin.siteAdminPage.adminTreeLinkClick("GB Home");
        Admin.siteAdminPage.adminTreeLinkClick("My Directories");
        while(Admin.siteAdminPage.isSiteTreeLinkContainsTextExist("e2e")){
            System.out.println("Custom element exists");
            Admin.siteAdminPage.adminTreeLinkContainsTextClick("e2e");
            Admin.siteAdminPage.clickOnHeaderButton("Delete");
            Admin.siteAdminPage.xWindowButtonClick("Yes");
            System.out.println("Custom element was deleted");
            Thread.sleep(200);
        }
        System.out.println("\n");
    }

//    public static void hideCookieNotice() throws InterruptedException {
//        if(Browser.driver.getCurrentUrl().contains("cf#")){
//            Browser.driver.switchTo().frame("cq-cf-frame");
//            if(Browser.driver.findElements(By.cssSelector("cookie-notice")).size()>0){
//                if(Browser.driver.findElement(By.cssSelector("cookie-notice")).isDisplayed()){
//                    System.out.println("notice visible on author page ");
//                    Cookie configKey = new Cookie("configKey", "suitcaseDisabled");
//                    Browser.driver.manage().addCookie(configKey);
//                    Thread.sleep(1000);
//                    Browser.driver.navigate().refresh();
//                }
//            }
//        }else{
//            if(Browser.driver.findElements(By.cssSelector("cookie-notice")).size()>0){
//                if(Browser.driver.findElement(By.cssSelector("cookie-notice")).isDisplayed()){
//                    System.out.println("notice visible on publish page ");
//                    Cookie configKey = new Cookie("configKey", "suitcaseDisabled");
//                    Browser.driver.manage().addCookie(configKey);
//                    Thread.sleep(1000);
//                    Browser.driver.navigate().refresh();
//                }
//            }
//        }
//
//        Cookie configKey = new Cookie("configKey", "suitcaseDisabled");
//        Browser.driver.manage().addCookie(configKey);
//        Thread.sleep(3000);
//        Browser.driver.navigate().refresh();
//    }

    public static void closeNotice(WebElementData cookieNotice, WebElement root){
        try {
            cookieNotice.waitForPresent(root);
            if (cookieNotice.waitForVisible(1500, root)) {
                try {
                    new WebElementData("button.btn--reset").getElement(cookieNotice.getElement(root)).click();
                } catch (Exception e) {
                    System.out.println("notice is not cickable");
                }
            } else {
                System.out.println("notice is not visible");
            }
        }catch(Exception e){
            System.out.println("notice is not present on the page");
        }
    }

    public static void waitForAccept(String text,WebElement root){
        try{
            new WebElementData("xpath",".//*[contains(text(),'" + text + "')]").getElement(root);
        }catch(Exception e){
            System.out.println("Exception: "+e.getClass());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
            new WebElementData("xpath",".//*[contains(text(),'" + text + "')]").getElement(root);
        }
    }

    public static void waitForLoading(int i){
        while(Browser.driver.findElements(By.xpath(".//div[text()='Loading...']")).size()>0){
            System.out.println("Loading...");
            try{
                Thread.sleep(i);
            }catch (Exception e){
                System.out.println("Can't sleep");
            }
        }
    }

    public static void waitForInsertingParagraph(int i){
        while(Browser.driver.findElements(By.xpath(".//div[text()='Inserting paragraph...']")).size()>0){
            System.out.println("Inserting paragraph...");
            try{
                Thread.sleep(i);
            }catch (Exception e){
                System.out.println("Can't sleep");
            }
        }
    }

    public static void waitForAdd(int count, ElementData elements, WebElement root){
        long time = new Date().getTime();
        long endTime = time+10000;
        int pooling = 300;
        while(elements.getNumber(root)== count && time <= endTime){
            System.out.println("Wait for element added to DOM");
            try {
                Thread.sleep(pooling);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            time = new Date().getTime();
        }
        if (time >= endTime) {
            throw new NoSuchElementException("Element was not added");
        }
    }

}
