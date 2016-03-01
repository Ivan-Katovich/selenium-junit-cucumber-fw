package e2e.pages.author;

import e2e.Browser;
import e2e.data.SiteTreeData;
import e2e.data.WebElementData;
import e2e.data.XWindowData;
import e2e.pages.TSMPage;
import e2e.support.Helper;
import e2e.ui_elements.SiteTree;
import e2e.ui_elements.XWindow;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.LinkedHashMap;

public class SiteAdminPage extends TSMPage{

    private SiteTreeData siteTree = new SiteTreeData("css","#cq-siteadmin-tree",true);
    private WebElementData userInfoToolbar = new WebElementData("css", "div#cq-userinfo", true);
    private WebElementData headerGrid = new WebElementData("xpath", ".//div[@id='cq-siteadmin-grid']", true);
    private XWindowData xWindows = new XWindowData("css","div.x-window",false);

    public String getUserName(){
        String text = userInfoToolbar.getElement(body).getText();
        try{
            Browser.options.rememberedCookie = Browser.driver.manage().getCookieNamed("login-token");
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("  No cookies =================== ");
        }
        return text;
    }

    public void adminTreeLinkClick(String name) throws InterruptedException {
        siteTree.getElement(body).selectSiteElementByName(name);
    }

    public void adminTreeLinkContainsTextClick(String name) throws InterruptedException {
        siteTree.getElement(body).selectSiteElementContains(name);
    }

    public boolean isSiteTreeLinkExist(String name){

        return siteTree.getElement(body).isLinkExist(name);
    }

    public boolean isSiteTreeLinkContainsTextExist(String name){
        return siteTree.getElement(body).isLinkContainsTextExist(name);
    }

    public void clickOnHeaderButton(String button) throws InterruptedException {
        Helper.waitForLoading(100);
        headerGrid.getElement(body).findElement(By.xpath(".//button[text()='" + button + "']")).click();
    }

    public String getXWindowSelectedItemText(){
        return xWindows.getElement(body, xWindows.getNumber(body) - 1).getSelectedItemTitle();
    }

    public void xWindowInputSendKeys(String inputName, String text){
        xWindows.getElement(body, xWindows.getNumber(body) - 1).inputSendKeys(inputName, text);
    }

    public void xWindowButtonClick(String buttonText) throws InterruptedException {
        xWindows.getElement(body, xWindows.getNumber(body) - 1).clickOnButton(buttonText);
    }

    public void doubleClickOnSiteTreeElement(String name) throws InterruptedException {
        siteTree.getElement(body).doubleClickOnElement(name);
    }

    public void xWindowSelectItem(String itemName){
        xWindows.getElement(body, xWindows.getNumber(body)-1).selectItem(itemName);
    }

}
