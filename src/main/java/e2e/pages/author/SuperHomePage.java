package e2e.pages.author;

import e2e.Browser;
import e2e.data.*;
import e2e.exceptions.NoSuchKeyInMapException;
import e2e.pages.TSMPage;
import e2e.support.Helper;
import e2e.ui_elements.XWindow;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.Date;
import java.util.HashMap;

public class SuperHomePage extends TSMPage{

    private HashMap<String,WebElementData> pageData = new HashMap<String,WebElementData>(){{
        put("cookieNoticeIF",new WebElementData("css","cookie-notice div"));
        put("mainLogoIF",new WebElementData("css","div.site-logo"));
        put("heroIF",new WebElementData("css","div.hero"));
        put("searchGadgetIF",new WebElementData("css","search-gadget"));
        put("navigationMenuIF",new WebElementData("css","button.header-button--menu"));
        put("navigationSectionIF",new WebElementData("css","div.nav-sections"));
        put("carouselIF",new WebElementData("css","div.promotionNavigationCarousel"));
        put("descriptionIC",new WebElementData("css","div.promo-category-description--show"));
        put("promoCategoryIC",new WebElementData("css","nav ul.promo-category-nav"));
        put("arrowLeftIC",new WebElementData("css","button.slick-prev"));
        put("arrowRightIC",new WebElementData("css","button.slick-next"));
        put("trackIC",new WebElementData("css","div.slick-track"));
        put("directoryContainerIF",new WebElementData("css","div.merchandisingDirectoryContentContainer.destinationList"));
        put("destinationSectionIDC",new WebElementData("css","div.destination-section-container"));
        put("directionSignIDC",new WebElementData("css","div.directions-sign"));
        put("destinationListLinksIDC",new WebElementData("css","a.destination-list__link",false));
        put("superCompaignContainerIF",new WebElementData("css","div.superCampaign"));
    }};

    private SidekickData sidekickOOF = new SidekickData("css","div.cq-sidekick");
    private XWindowData cpXWindowsIF = new XWindowData("css","div.x-window",false);

    private WebElementData getElementData(String webElementName){
        System.out.println("SuperHomePage get: "+webElementName);
        if(this.pageData.get(webElementName) == null){
            throw new NoSuchKeyInMapException("No such key: '"+ webElementName +"' in pageData map on SuperHomePage");
        }else{
            return this.pageData.get(webElementName);
        }
    }

    public boolean isSidekickVisible(){
        sidekickOOF.waitForPresent(body);
        return sidekickOOF.waitForVisible(body);
    }

    public void switchToCFFrame(){
        new WebElementData("#cq-cf-frame").waitForPresent(body);
        Browser.driver.switchTo().frame("cq-cf-frame");
    }

    public void switchToDefaultContent(){
        Browser.driver.switchTo().defaultContent();
    }

    public void closeCookieNotice(){
        switchToCFFrame();
        Helper.closeNotice(getElementData("cookieNoticeIF"), body);
        switchToDefaultContent();
    }

    public String getLogoLink(){
        return getElementData("mainLogoIF").getElement(body).findElement(By.xpath(".//img")).getAttribute("src");
    }

    public String getWebElementText(String webElementName){
        return this.getElementData(webElementName).getElement(body).getText();
    }

    public String getWebElementText(String webElementName, String root){
        return this.getElementData(webElementName).getElement(this.getElementData(root).getElement(body)).getText();
    }

    public String getWebElementText(String webElementName,int position, String root){
        return this.getElementData(webElementName).getElement(this.getElementData(root).getElement(body),position).getText();
    }

    public String getWebElementAttribute(String webElementName,String attribute){
        return this.getElementData(webElementName).getElement(body).getAttribute(attribute);
    }

    public String getWebElementAttribute(String webElementName,String root,String attribute){
        return this.getElementData(webElementName).getElement(this.getElementData(root).getElement(body)).getAttribute(attribute);
    }

    public String getWebElementAttribute(String webElementName,int position, String root,String attribute){
        return this.getElementData(webElementName).getElement(this.getElementData(root).getElement(body),position).getAttribute(attribute);
    }

    public boolean isWebElementVisible(String webElementName){
        if(this.getElementData(webElementName).waitForPresent(body)){
            return this.getElementData(webElementName).waitForVisible(body);
        }
        return false;
    }

    public boolean isWebElementVisible(String webElementName,String root){
        if(this.getElementData(webElementName).waitForPresent(this.getElementData(root).getElement(body))){
            return this.getElementData(webElementName).waitForVisible(this.getElementData(root).getElement(body));
        }
        return false;
    }

    public boolean isWebElementVisible(String webElementName,int position,String root){
        if(this.getElementData(webElementName).waitForPresent(this.getElementData(root).getElement(body))){
            return this.getElementData(webElementName).waitForVisible(this.getElementData(root).getElement(body),position);
        }
        return false;
    }

    public void goToPageProperties(){
        int num = cpXWindowsIF.getNumberWithoutWaiting(body);
        sidekickOOF.getElement(body).switchTab(2);
        sidekickOOF.getElement(body).clickOnButton("Page Properties...");
        if(cpXWindowsIF.getNumber(body)==num){
            System.out.println("\nSomething wrong. XWindow doesn't appear. Click once more after timeout");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            sidekickOOF.getElement(body).clickOnButton("Page Properties...");
        }
    }

    public boolean checkPagePropertiesFromSidekick(){
        XWindow xWindow = cpXWindowsIF.getElementInsureDomAttach(body, cpXWindowsIF.getNumber(body) - 1);
        xWindow.clickOnLink("Search Gadget");
        if(xWindow.isLabelWithTextPresent("Select Page Gadget")){
            return xWindow.isFieldsetInTabWithLabelChacked(1, "Select Page Gadget");
        };
        return false;
    }

    public void switchToScreen(int screenNumber){
        getElementData("navigationSectionIF").getElement(body).findElements(By.cssSelector("li.nav-sections-bullet")).get(screenNumber).click();
        long time = new Date().getTime();
        long endTime = time+10000;
        int pooling = 300;
        while(!getElementData("navigationSectionIF").getElement(body).findElements(By.cssSelector("li.nav-sections-bullet")).get(screenNumber).getAttribute("class").contains("nav-sections-bullet-current") && time <= endTime){
            System.out.println("Wait for class changing");
            try {
                Thread.sleep(pooling);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            time = new Date().getTime();
        }
        if(time >= endTime){
            throw new AssertionError("SuperHomePage screen was not switched");
        }
    }

    public String getSuperCompaignDialogueTitle(){
        Actions action = new Actions(Browser.driver);
        WebElement container = new WebElementData("div.author-box").getElement(getElementData("superCompaignContainerIF").getElementInsureDomAttach(body));
        action.doubleClick(container).perform();
        XWindow xWindow = cpXWindowsIF.getElement(body, cpXWindowsIF.getNumber(body) - 1);
        return xWindow.getTitle();
    }


}
