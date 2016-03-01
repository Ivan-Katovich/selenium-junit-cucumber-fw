package e2e.pages.author;

import e2e.Browser;
import e2e.data.*;
import e2e.pages.TSMPage;
import e2e.support.Helper;
import e2e.ui_elements.Sidekick;
import e2e.ui_elements.SiteTree;
import e2e.ui_elements.XWindow;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import static e2e.support.TestConstants.*;

public class CustomPage extends TSMPage {

    private WebElementData cookieNoticeIF = new WebElementData("css","cookie-notice div");
    private WebElementData globalErrorIF = new WebElementData("css","global-error div");
    private SidekickData sidekickOOF = new SidekickData("css","div.cq-sidekick");
    private WebElementData homeTitleIF = new WebElementData("css","div.home-title");
    private WebElementData homeContentTextIF = new WebElementData("css","div.home-content");
    private SiteTreeData localSiteTreeIF = new SiteTreeData("css","#cq-paragraphreference-tree");
    private SiteTreeData xWindowSiteTreesIF = new SiteTreeData("css",".cq-browsedialog",false);
    private WebElementData seoDirectoryContentContainerIF = new WebElementData("css","div.seoDirectoryContentContainer");
    private WebElementData merchDirectoryContentContainerIF = new WebElementData("css","div.merchandisingDirectoryContentContainer");
    private WebElementData destinationListItemIF = new WebElementData("css","div.seoDestinationListItem");
    private WebElementData callToActionPanelIF = new WebElementData("css","div.callToActionPanel");
    private WebElementData promotionPanelIF = new WebElementData("css","div.promotionPanel");
    private WebElementData crossSellItemIF = new WebElementData("css","div.crossSellItem");
    private WebElementData topDealsPanelIF = new WebElementData("css","div.topDealsPanel");
    private WebElementData blogPostArtIF = new WebElementData("css","div.seoRelatedBlogPostArticle");
    private WebElementData richTextArtIF = new WebElementData("css","div.seoRichTextArticle");
    private WebElementData thirdPartyControlersIF = new WebElementData("css","div.thirdPartyWidgetController",false);
    private WebElementData breadcrumbTrailItemIF = new WebElementData("css","div.breadcrumbTrail");
    private WebElementData disclaimerTextIF = new WebElementData("css","div.disclaimer");
    private WebElementData footerNavigationIF = new WebElementData("css","div.footerNavigation");
    private WebElementData richTextIF = new WebElementData("css","div.richText");
    private WebElementData tickListIF = new WebElementData("css","div.tickList");
    private WebElementData navigationTopicListIF = new WebElementData("css","div.topicList");
    private WebElementData sitemapTopicListIF = new WebElementData("css","div.sitemapTopicList");
    private WebElementData concertinaTextIF = new WebElementData("css","div.concertinaText");
    private WebElementData directoryListItemIF = new WebElementData("css","div.directoryListItem");
    private WebElementData providerLogosContainerIF = new WebElementData("css","div.providerLogos");
    private WebElementData staticTextContainersIF = new WebElementData("css","div.staticText",false);
    private WebElementData selectButtonIF = new WebElementData("xpath",".//button[text()='Select']");
    private WebElementData activateNotification = new WebElementData("css",".cq-notification-msg-content");
    private WebElementData logoIF = new WebElementData("css","img.logo-list__item-img");
    private XWindowData cpXWindowsIF = new XWindowData("css","div.x-window",false);
    private WebElementData containersIF = new WebElementData("xpath",".//div[@class='cq-editrollover-insert-container']",false);
    private SidekickData localSidekicksIF = new SidekickData("css","div.cq-insertdialog",false);
    private WebElementData paragraphsIF = new WebElementData("css",".cq-paragraphreference-paragraph",false);
    private WebElementData paragraphsDataIF = new WebElementData("css","#cq-paragraphreference-data");
    private XMenuData xMenusIF = new XMenuData("css","div.x-menu",false);
    private WebElementData parbasesIF = new WebElementData("css","div.parbase",false);


    public void closeCookieNotice(){
        switchToCFFrame();
        Helper.closeNotice(cookieNoticeIF, body);
        switchToDefaultContent();
    }

    public void closeGlobalError(){
        switchToCFFrame();
        Helper.closeNotice(globalErrorIF, body);
        switchToDefaultContent();
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

    public void addStaticText(int i,String text) throws InterruptedException {
        Actions action = new Actions(Browser.driver);
        WebElement container = new WebElementData("div.author-box p").getElement(staticTextContainersIF.getElementInsureDomAttach(body, i));
        action.doubleClick(container).perform();
        XWindow xWindow = cpXWindowsIF.getElement(body, cpXWindowsIF.getNumber(body) - 1);
        Thread.sleep(200);
        xWindow.textareaSendKeys("./text", text);
        xWindow.clickOnButton("Save");
        Helper.waitForAccept(text, body);
    }

    public void addNewContainer(String name){
        sidekickOOF.getElement(body).dragAndDropElementByName(name);
    }

    public void selectSidekickCategory(String name){
        sidekickOOF.getElement(body).selectCategory(name);
    }

    public void addContainerIntoField(int containerNumber, String categoryName, String elementName){
        int count = parbasesIF.getNumberWithoutWaiting(body);
        Actions action = new Actions(Browser.driver);
        WebElement element = containersIF.getElement(body, containerNumber - 1);
        action.doubleClick(element).perform();
        Sidekick sidekick = localSidekicksIF.getElements(body).get(localSidekicksIF.getElements(body).size() - 1);
        sidekick.selectElement(categoryName, elementName);
        sidekick.clickOnButton("OK");
        try{
            if(sidekick.getRoot().isDisplayed()){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            };
        }catch(Exception e){
            //ignore
        }
//        localSidekicksIF.getElements(body).get(localSidekicksIF.getElements(body).size() - 1).selectElement(categoryName, elementName);
//        localSidekicksIF.getElements(body).get(localSidekicksIF.getElements(body).size() - 1).clickOnButton("OK");
        Helper.waitForInsertingParagraph(300);
        Helper.waitForAdd(count,parbasesIF,body);
    }

    public void fillSEODirectoryContentContainer(String containerTitle, int paragraphNumber) throws InterruptedException {
        Actions action = new Actions(Browser.driver);
        WebElement container = new WebElementData("div.author-box p").getElement(seoDirectoryContentContainerIF.getElementInsureDomAttach(body));
        action.doubleClick(container).perform();
        XWindow xWindow = cpXWindowsIF.getElement(body, cpXWindowsIF.getNumber(body) - 1);
        xWindow.inputSendKeys("./blockTitle", containerTitle);
        xWindow.clickOnButton("Edit");
        localSiteTreeIF.getElement(body).doubleClickOnElement("TravelSupermarket");
        localSiteTreeIF.getElement(body).doubleClickOnElement("My Directories");
        localSiteTreeIF.getElement(body).selectSiteElementByName(Browser.options.listItemsPageTitle);
        paragraphsDataIF.waitForPresent(body);
        paragraphsDataIF.waitForVisible(body);
        paragraphsIF.getElements(body).get(paragraphNumber).click();
        selectButtonIF.getElement(body).click();
        xWindow.clickOnButton("Save");
        Helper.waitForAccept(containerTitle, body);
    }

    public void fillMerchDirectoryContentContainer(String containerTitle, int paragraphNumber) throws InterruptedException {
        Actions action = new Actions(Browser.driver);
        WebElement container = new WebElementData("div.author-box p").getElement(merchDirectoryContentContainerIF.getElementInsureDomAttach(body));
        action.doubleClick(container).perform();
        XWindow xWindow = cpXWindowsIF.getElement(body, cpXWindowsIF.getNumber(body) - 1);
        xWindow.inputSendKeys("./blockTitle", containerTitle);
        xWindow.clickOnButton("Edit");
        try{
            try{
                paragraphsIF.getElement(body, paragraphNumber).click();
            }catch(Exception e){
                System.out.println("Exception: " + e.getClass());
            }
            try{
                if(!paragraphsIF.getElement(body, paragraphNumber).getAttribute("class").contains("selected")) {
                    Thread.sleep(1000);
                    paragraphsIF.getElement(body, paragraphNumber).click();
                }
            }catch(Exception e){
                System.out.println("Exception: "+e.getClass());
                Thread.sleep(1000);
                paragraphsIF.getElement(body, paragraphNumber).click();
            }
        }catch(Exception e){
            localSiteTreeIF.getElement(body).doubleClickOnElement("TravelSupermarket");
            localSiteTreeIF.getElement(body).doubleClickOnElement("My Directories");
            localSiteTreeIF.getElement(body).selectSiteElementByName(Browser.options.listItemsPageTitle);
            paragraphsDataIF.waitForPresent(body);
            paragraphsDataIF.waitForVisible(body);
            paragraphsIF.getElement(body, paragraphNumber).click();
        }
        selectButtonIF.getElement(body).click();
        xWindow.clickOnButton("Save");
        Helper.waitForAccept(containerTitle, body);
    }

    public String getSEODirectoryContainerText(){
        String text = seoDirectoryContentContainerIF.getElementInsureDomAttach(body).getText();
        return text;
    }

    public String getMerchDirectoryContainerText(){
        String text = merchDirectoryContentContainerIF.getElementInsureDomAttach(body).getText();
        return text;
    }

    public String activatePageFromSidekick(){
        sidekickOOF.getElement(body).switchTab(2);
        sidekickOOF.getElement(body).clickOnButton("Activate Page");
        if(activateNotification.waitForPresent(2000,body)){
            return activateNotification.getElement(body).getText();
        }else{
            cpXWindowsIF.getElement(body, cpXWindowsIF.getNumber(body) - 1).clickOnButton("Activate");
            System.out.println("Activation popup appears");
            return activateNotification.getElement(body).getText();
        }

    }

    public void addLogo() throws InterruptedException {
        Actions action = new Actions(Browser.driver);
        WebElement container = new WebElementData("div.author-box p").getElement(providerLogosContainerIF.getElementInsureDomAttach(body));
        action.doubleClick(container).perform();
        XWindow xWindow = cpXWindowsIF.getElement(body, cpXWindowsIF.getNumber(body) - 1);
        xWindow.clickOnLink("Add Item");
        xWindow.clickOnLoup(0);
        SiteTree xWindowSiteTreeIF = xWindowSiteTreesIF.getElement(body, xWindowSiteTreesIF.getNumber(body) - 1);
        xWindowSiteTreeIF.selectSiteElementByName("background");
        xWindowSiteTreeIF.selectSiteElementByName("hero-images");
        xWindowSiteTreeIF.selectSiteElementByName("d");
        xWindowSiteTreeIF.selectSiteElementByName("Dalaman");
        xWindowSiteTreeIF.selectSiteElementContains(PROVIDER_HOLIDAY_LOGO);
        xWindowSiteTreeIF.clickOnButton("OK");
        xWindow.clickOnButton("Save");
    }

    public void addMerchandisingDirListItem() throws InterruptedException {
        Actions action = new Actions(Browser.driver);
        WebElement container = new WebElementData("div.author-box p").getElement(directoryListItemIF.getElementInsureDomAttach(body));
        action.doubleClick(container).perform();
        XWindow xWindow = cpXWindowsIF.getElement(body, cpXWindowsIF.getNumber(body) - 1);
        xWindow.clickOnLoup(0);
        SiteTree xWindowSiteTreeIF = xWindowSiteTreesIF.getElement(body,xWindowSiteTreesIF.getNumber(body)-1);
        xWindowSiteTreeIF.selectSiteElementByName("background");
        xWindowSiteTreeIF.selectSiteElementByName("hero-images");
        xWindowSiteTreeIF.selectSiteElementByName("l");
        xWindowSiteTreeIF.selectSiteElementByName("Lanzarote");
        xWindowSiteTreeIF.selectSiteElementContains(DIR_LIST_ITEM_LOGO);
        xWindowSiteTreeIF.clickOnButton("OK");
        xWindow.inputSendKeys("./altText", DIR_LIST_ITEM_ALT_LOGO_TEXT);
        xWindow.inputSendKeys("./callToActionText", DIR_LIST_ITEM_CALL_TO_ACTION);
        xWindow.inputSendKeys("./urlAddress", URI_FOR_CHECK);
        xWindow.inputSendKeys("./bodyTitle", DIR_LIST_ITEM_BODY_TITLE);
        xWindow.textareaSendKeys("./bodyContent", DIR_LIST_ITEM_BODY_CONTENT);
        xWindow.clickOnButton("Save");
        Helper.waitForAccept(DIR_LIST_ITEM_CALL_TO_ACTION, body);
    }

    public void addDestinationListItem() throws InterruptedException {
        Actions action = new Actions(Browser.driver);
        WebElement container = new WebElementData("div.author-box p").getElement(destinationListItemIF.getElementInsureDomAttach(body));
        action.doubleClick(container).perform();
        XWindow xWindow = cpXWindowsIF.getElement(body, cpXWindowsIF.getNumber(body) - 1);
        xWindow.inputSendKeys("./itemTitle", DEST_LIST_ITEM_TITLE);
        xWindow.inputSendKeys("./displayTitle", DEST_LIST_ITEM_DISPLAYED_TITLE);
        xWindow.inputSendKeys("./urlAddress", URI_FOR_CHECK);
        xWindow.clickOnButton("Save");
        Helper.waitForAccept(DEST_LIST_ITEM_DISPLAYED_TITLE, body);
    }

    public void addCallToActionPannel() throws InterruptedException {
        Actions action = new Actions(Browser.driver);
        WebElement container = new WebElementData("div.author-box p").getElement(callToActionPanelIF.getElementInsureDomAttach(body));
        action.doubleClick(container).perform();
        XWindow xWindow = cpXWindowsIF.getElement(body, cpXWindowsIF.getNumber(body) - 1);
        xWindow.clickOnRadioButton(3);
        xWindow.inputSendKeys("./title", CALL_TO_ACTION_TITLE);
        xWindow.inputSendKeys("./panelTitle", CALL_TO_ACTION_PANEL_TITLE);
        xWindow.inputSendKeys("./altText", CALL_TO_ACTION_ALT_TEXT);
        xWindow.inputSendKeys("./buttonText", CALL_TO_ACTION_BUTTON);
        xWindow.inputSendKeys("./urlAddress", URI_FOR_CHECK);
        xWindow.clickOnLoup(0);
        SiteTree xWindowSiteTreeIF = xWindowSiteTreesIF.getElement(body, xWindowSiteTreesIF.getNumber(body) - 1);
        xWindowSiteTreeIF.selectSiteElementByName("background");
        xWindowSiteTreeIF.selectSiteElementByName("hero-images");
        xWindowSiteTreeIF.selectSiteElementByName("s");
        xWindowSiteTreeIF.selectSiteElementByName("Santorini");
        xWindowSiteTreeIF.selectSiteElementContains(CALL_TO_ACTION_IMG);
        xWindowSiteTreeIF.clickOnButton("OK");
        xWindow.clickOnButton("Save");
        Helper.waitForAccept(CALL_TO_ACTION_PANEL_TITLE, body);
    }

    public void addCrossSellItem() throws InterruptedException {
        Actions action = new Actions(Browser.driver);
        WebElement container = new WebElementData("div.author-box p").getElement(crossSellItemIF.getElementInsureDomAttach(body));
        action.doubleClick(container).perform();
        XWindow xWindow = cpXWindowsIF.getElement(body, cpXWindowsIF.getNumber(body) - 1);
        xWindow.inputSendKeys("./title", CROSS_SELL_TITLE);
        xWindow.inputSendKeys("./subTitle", CROSS_SELL_SUBTITLE);
        xWindow.inputSendKeys("./urlAddress", URI_FOR_CHECK);
        xWindow.inputSendKeys("./textToDisplay", CROSS_SELL_TEXT);
        xWindow.clickOnLoup(0);
        SiteTree xWindowSiteTreeIF = xWindowSiteTreesIF.getElement(body, xWindowSiteTreesIF.getNumber(body) - 1);
        xWindowSiteTreeIF.selectSiteElementByName("background");
        xWindowSiteTreeIF.selectSiteElementByName("hero-images");
        xWindowSiteTreeIF.selectSiteElementByName("g");
        xWindowSiteTreeIF.selectSiteElementByName("Gran Canaria");
        xWindowSiteTreeIF.selectSiteElementContains(CROSS_SELL_IMG);
        xWindowSiteTreeIF.clickOnButton("OK");
        xWindow.clickOnButton("Save");
        Helper.waitForAccept(CROSS_SELL_TITLE, body);
    }

    public void addPromotionPanel() throws InterruptedException {
        Actions action = new Actions(Browser.driver);
        WebElement container = promotionPanelIF.getElement(body);
        Thread.sleep(1000);
        action.moveToElement(container, 20, 20).doubleClick().perform();
        XWindow xWindow = cpXWindowsIF.getElement(body, cpXWindowsIF.getNumber(body) - 1);
        xWindow.inputSendKeys("./title", PROMOTION_TITLE);
        xWindow.inputSendKeys("./panelTitle", PROMOTION_PANEL_TITLE);
        xWindow.inputSendKeys("./panelText", PROMOTION_PANEL_TEXT);
        xWindow.inputSendKeys("./altText", PROMOTION_ALT_TEXT);
        xWindow.inputSendKeys("./urlAddress", URI_FOR_CHECK);
        xWindow.clickOnLoup(0);
        SiteTree xWindowSiteTreeIF = xWindowSiteTreesIF.getElement(body, xWindowSiteTreesIF.getNumber(body) - 1);
        xWindowSiteTreeIF.selectSiteElementByName("background");
        xWindowSiteTreeIF.selectSiteElementByName("hero-images");
        xWindowSiteTreeIF.selectSiteElementByName("t");
        xWindowSiteTreeIF.selectSiteElementByName("Tenerife");
        xWindowSiteTreeIF.selectSiteElementContains(PROMOTION_IMG);
        xWindowSiteTreeIF.clickOnButton("OK");
        xWindow.clickOnButton("Save");
        Helper.waitForAccept(PROMOTION_PANEL_TITLE, body);
    }

    public void addTopDealsPanel() throws InterruptedException {
        Actions action = new Actions(Browser.driver);
        WebElement container = new WebElementData("div.author-box p").getElement(topDealsPanelIF.getElementInsureDomAttach(body));
        action.doubleClick(container).perform();
        XWindow xWindow = cpXWindowsIF.getElement(body, cpXWindowsIF.getNumber(body) - 1);
        xWindow.inputSendKeys("./title", TOP_DEALS_TITLE);
        xWindow.inputSendKeys("./panelTitle", TOP_DEALS_PANEL_TITLE);
        xWindow.inputSendKeys("./panelText", TOP_DEALS_PANEL_TEXT);
        xWindow.inputSendKeys("./priceOfferText", TOP_DEALS_PRICE_OFFER);
        xWindow.inputSendKeys("./buttonText", TOP_DEALS_BUTTON);
        xWindow.inputSendKeys("./urlAddress", URI_FOR_CHECK);
        xWindow.clickOnLoup(0);
        SiteTree xWindowSiteTreeIF = xWindowSiteTreesIF.getElement(body, xWindowSiteTreesIF.getNumber(body) - 1);
        xWindowSiteTreeIF.selectSiteElementByName("background");
        xWindowSiteTreeIF.selectSiteElementByName("hero-images");
        xWindowSiteTreeIF.selectSiteElementByName("i");
        xWindowSiteTreeIF.selectSiteElementByName("Istanbul");
        xWindowSiteTreeIF.selectSiteElementContains(TOP_DEALS_BACKGROUND_IMG);
        xWindowSiteTreeIF.clickOnButton("OK");
        xWindow.clickOnLoup(1);
        SiteTree xWindowSiteTreeIFSec = xWindowSiteTreesIF.getElement(body, xWindowSiteTreesIF.getNumber(body) - 1);
        xWindowSiteTreeIFSec.selectSiteElementByName("background");
        xWindowSiteTreeIFSec.selectSiteElementByName("hero-images");
        xWindowSiteTreeIFSec.selectSiteElementByName("l");
        xWindowSiteTreeIFSec.selectSiteElementByName("Lanzarote");
        xWindowSiteTreeIFSec.selectSiteElementContains(TOP_DEALS_IMG);
        xWindowSiteTreeIFSec.clickOnButton("OK");
        xWindow.clickOnButton("Save");
        Helper.waitForAccept(TOP_DEALS_PANEL_TITLE, body);
    }

    public void addBlogPostArticle() throws InterruptedException {
        Actions action = new Actions(Browser.driver);
        WebElement container = new WebElementData("div.author-box p").getElement(blogPostArtIF.getElementInsureDomAttach(body));
        action.doubleClick(container).perform();
        XWindow xWindow = cpXWindowsIF.getElement(body, cpXWindowsIF.getNumber(body) - 1);
        xWindow.inputSendKeys("./articleTitle", BLOG_POST_ARTICLE_TITLE);
        xWindow.inputSendKeys("./urlAddress", URI_FOR_CHECK);
        xWindow.addTextIntoFrame(1,BLOG_POST_ARTICLE_CONTENT);
        switchToCFFrame();
        xWindow.clickOnLoup(0);
        SiteTree xWindowSiteTreeIF = xWindowSiteTreesIF.getElement(body, xWindowSiteTreesIF.getNumber(body) - 1);
        xWindowSiteTreeIF.selectSiteElementByName("background");
        xWindowSiteTreeIF.selectSiteElementByName("hero-images");
        xWindowSiteTreeIF.selectSiteElementByName("t");
        xWindowSiteTreeIF.selectSiteElementByName("Tenerife");
        xWindowSiteTreeIF.selectSiteElementContains(BLOG_POST_ARTICLE_IMG);
        xWindowSiteTreeIF.clickOnButton("OK");
        xWindow.clickOnButton("Save");
        Helper.waitForAccept(BLOG_POST_ARTICLE_TITLE, body);
    }

    public void addRichTextArticle() throws InterruptedException {
        Actions action = new Actions(Browser.driver);
        WebElement container = new WebElementData("div.author-box p").getElement(richTextArtIF.getElementInsureDomAttach(body));
        action.doubleClick(container).perform();
        XWindow xWindow = cpXWindowsIF.getElement(body, cpXWindowsIF.getNumber(body) - 1);
        xWindow.inputSendKeys("./articleTitle", RICH_TEXT_ARTICLE_TITLE);
        xWindow.inputSendKeys("./urlAddress", URI_FOR_CHECK);
        xWindow.addTextIntoFrame(1,RICH_TEXT_ARTICLE_CONTENT);
        switchToCFFrame();
        xWindow.clickOnButton("Save");
        Helper.waitForAccept(RICH_TEXT_ARTICLE_TITLE, body);
    }

    public void addThirdPartyControlerPicture(){
        Actions action = new Actions(Browser.driver);
        WebElement container = new WebElementData("div.author-box p").getElement(thirdPartyControlersIF.getElementInsureDomAttach(body,0));
        action.doubleClick(container).perform();
        XWindow xWindow = cpXWindowsIF.getElement(body, cpXWindowsIF.getNumber(body) - 1);
        xWindow.inputSendKeys("./thirdPartyName", ADVERTISING_THIRD_PARTY_PICTURE_NAME);
        xWindow.inputSendKeysByLabel("3rd Party Content URL Address:",ADVERTISING_THIRD_PARTY_PICTURE_URL);
        xWindow.addIFrameDimensionsInFieldSet(400,300);
        xWindow.clickOnButton("Save");
        try{
            new WebElementData("css","iframe",false).waitForPresent(thirdPartyControlersIF.getElementInsureDomAttach(body,0));
        }catch(Exception e){
            System.out.println("Picture still not attached to DOM");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
            new WebElementData("css","iframe",false).waitForPresent(thirdPartyControlersIF.getElementInsureDomAttach(body,0));
        }
    }

    public void addThirdPartyControlerVideo(){
        Actions action = new Actions(Browser.driver);
        WebElement container = new WebElementData("div.author-box p").getElement(thirdPartyControlersIF.getElementInsureDomAttach(body,1));
        action.doubleClick(container).perform();
        XWindow xWindow = cpXWindowsIF.getElement(body, cpXWindowsIF.getNumber(body) - 1);
        xWindow.inputSendKeys("./thirdPartyName", ADVERTISING_THIRD_PARTY_VIDEO_NAME);
        xWindow.clickOnCheckbox(2);
        xWindow.inputSendKeysByLabel("Embed Code:",ADVERTISING_THIRD_PARTY_VIDEO_CODE);
        xWindow.clickOnButton("Save");
        try{
            new WebElementData("css","iframe",false).waitForPresent(thirdPartyControlersIF.getElementInsureDomAttach(body,1));
        }catch(Exception e){
            System.out.println("Video still not attached to DOM");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
            new WebElementData("css","iframe",false).waitForPresent(thirdPartyControlersIF.getElementInsureDomAttach(body,1));
        }

    }

    public void addPageBreadcrumbTrail() throws InterruptedException {
        Actions action = new Actions(Browser.driver);
        WebElement container = new WebElementData("div.author-box p").getElement(breadcrumbTrailItemIF.getElementInsureDomAttach(body));
//        action.moveToElement(container, 3, 3).doubleClick().perform();
        Thread.sleep(500);
        action.doubleClick(container).perform();
        XWindow xWindow = cpXWindowsIF.getElement(body, cpXWindowsIF.getNumber(body) - 1);
        xWindow.clickOnLoup(0);
        SiteTree xWindowSiteTreeIF = xWindowSiteTreesIF.getElement(body, xWindowSiteTreesIF.getNumber(body) - 1);
        xWindowSiteTreeIF.selectSiteElementByName(PAGE_BREADCRUMB_LOUP_ITEM);
        xWindowSiteTreeIF.clickOnButton("OK");
        xWindow.clickOnButton("Save");
        Helper.waitForAccept("GB Home", body);
    }

    public void addPageDisclaimerText() throws InterruptedException {
        Actions action = new Actions(Browser.driver);
        WebElement container = new WebElementData("div.author-box p").getElement(disclaimerTextIF.getElementInsureDomAttach(body));
//        action.moveToElement(container, 3, 3).doubleClick().perform();
        action.doubleClick(container).perform();
        XWindow xWindow = cpXWindowsIF.getElement(body, cpXWindowsIF.getNumber(body) - 1);
        xWindow.inputSendKeys("./disclaimer", PAGE_DISCLAIMBER_TEXT);
        xWindow.clickOnButton("Save");
        Helper.waitForAccept(PAGE_DISCLAIMBER_TEXT, body);
    }

    public void addConcertinaText() throws InterruptedException {
        Actions action = new Actions(Browser.driver);
        WebElement container = new WebElementData("div.author-box p").getElement(concertinaTextIF.getElementInsureDomAttach(body));
//        action.moveToElement(container, 3, 3).doubleClick().perform();
        action.doubleClick(container).perform();
        XWindow xWindow = cpXWindowsIF.getElement(body, cpXWindowsIF.getNumber(body) - 1);
        xWindow.inputSendKeys("./blockTitle", CONCERTINA_TITLE);
        xWindow.clickOnLink("Add Item");
        xWindow.inputSendKeysByLabel("Title:", CONCERTINA_ITEM_TITLE);
        xWindow.inputSendKeysByLabel("SubTitle(Optional):", CONCERTINA_ITEM_SUB_TITLE);
        xWindow.addTextIntoFrame(1, CONCERTINA_ITEM_BODY_TEXT);
        switchToCFFrame();
        xWindow.clickOnButton("Save");
        Helper.waitForAccept(CONCERTINA_ITEM_TITLE, body);
    }

    public void addRichText() throws InterruptedException {
        Actions action = new Actions(Browser.driver);
        WebElement container = new WebElementData("div.author-box p").getElement(richTextIF.getElementInsureDomAttach(body));
//        action.moveToElement(container, 3, 3).doubleClick().perform();
        action.doubleClick(container).perform();
        XWindow xWindow = cpXWindowsIF.getElement(body, cpXWindowsIF.getNumber(body) - 1);
        xWindow.addTextIntoFrame(1, RICH_BODY_TEXT);
        switchToCFFrame();
        xWindow.clickOnButton("Save");
        Helper.waitForAccept(RICH_BODY_TEXT, body);
    }

    public void addTickList() throws InterruptedException {
        Actions action = new Actions(Browser.driver);
        WebElement container = new WebElementData("div.author-box p").getElement(tickListIF.getElementInsureDomAttach(body));
//        action.moveToElement(container, 3, 3).doubleClick().perform();
        action.doubleClick(container).perform();
        XWindow xWindow = cpXWindowsIF.getElement(body, cpXWindowsIF.getNumber(body) - 1);
        xWindow.clickOnLink("Add Item");
        xWindow.inputSendKeys("./tickItems", TICK_ITEM);
        xWindow.clickOnButton("Save");
        Helper.waitForAccept(TICK_ITEM, body);
    }

    public void addNavigationTopicList()throws InterruptedException {
        Actions action = new Actions(Browser.driver);
        WebElement container = new WebElementData("div.author-box p").getElement(navigationTopicListIF.getElementInsureDomAttach(body));
        action.doubleClick(container).perform();
        XWindow xWindow = cpXWindowsIF.getElement(body, cpXWindowsIF.getNumber(body) - 1);
        xWindow.inputSendKeys("./title",AUXILIARY_NAVIGATION_TITLE);
        xWindow.inputSendKeys("./urlAddress", "/en-gb/superhomepage/");
        xWindow.clickOnLink("Add Item");
        xWindow.inputSendKeysByLabel("Item Title:", AUXILIARY_NAVIGATION_FIRST_ITEM);
        xWindow.inputSendKeysByAnnotation("Enter  Destination URL for the List Item ", "/en-gb/superhomepage/");
        xWindow.clickOnButton("Save");
        Helper.waitForAccept(AUXILIARY_NAVIGATION_TITLE, body);
    }

    public void addSitemapTopicList()throws InterruptedException {
        Actions action = new Actions(Browser.driver);
        WebElement container = new WebElementData("div.author-box p").getElement(sitemapTopicListIF.getElementInsureDomAttach(body));
        action.doubleClick(container).perform();
        XWindow xWindow = cpXWindowsIF.getElement(body, cpXWindowsIF.getNumber(body) - 1);
        xWindow.inputSendKeys("./title",AUXILIARY_SITEMAP_TITLE);
        xWindow.inputSendKeys("./urlAddress", "/en-gb/superhomepage/");
        xWindow.clickOnLink("Add Item");
        xWindow.inputSendKeysByLabel("Item Title:", AUXILIARY_SITEMAP_FIRST_ITEM);
        xWindow.inputSendKeysByAnnotation("Enter  Destination URL for the List Item ", "/en-gb/superhomepage/");
        xWindow.clickOnLoup(0);
        SiteTree xWindowSiteTreeIF = xWindowSiteTreesIF.getElement(body,xWindowSiteTreesIF.getNumber(body)-1);
        xWindowSiteTreeIF.selectSiteElementByName("GB Home");
        xWindowSiteTreeIF.selectSiteElementByName("SuperHomePage");
        xWindowSiteTreeIF.clickOnButton("OK");
        xWindow.clickOnButton("Save");
        Helper.waitForAccept(AUXILIARY_SITEMAP_TITLE, body);
    }

    public String getNavigationTopicListText(){
        return navigationTopicListIF.getElementInsureDomAttach(body).getText();
    }

    public String getSitemapTopicListText(){
        return sitemapTopicListIF.getElementInsureDomAttach(body).getText();
    }

    public String getTickListText(){
        return tickListIF.getElementInsureDomAttach(body).getText();
    }

    public String getRichText(){
        return richTextIF.getElementInsureDomAttach(body).getText();
    }

    public String getConcertinaText(){
        return concertinaTextIF.getElementInsureDomAttach(body).getText();
    }

    public String getFooterLinksText(){
        return footerNavigationIF.getElementInsureDomAttach(body).getText();
    }

    public String getDisclaimerText(){
        return disclaimerTextIF.getElementInsureDomAttach(body).getText();
    }

    public String getCallToActionPanelText(){
        return callToActionPanelIF.getElementInsureDomAttach(body).getText();
    }

    public String getCrossSellItemText(){
        return crossSellItemIF.getElementInsureDomAttach(body).getText();
    }

    public String getPromotionPanelText(){
        return promotionPanelIF.getElementInsureDomAttach(body).getText();
    }

    public String getTopDealsPanelText(){
        return topDealsPanelIF.getElementInsureDomAttach(body).getText();
    }

    public String getBlogPostArticleText(){
        return blogPostArtIF.getElementInsureDomAttach(body).getText();
    }

    public String getRichTextArticleText(){
        return richTextArtIF.getElementInsureDomAttach(body).getText();
    }

    public String getBreadcumbTrailItemText(){
        return breadcrumbTrailItemIF.getElementInsureDomAttach(body).getText();
    }

    public String getMerchandisingDirListItemText(){
        return directoryListItemIF.getElementInsureDomAttach(body).getText();
    }

    public String getDestinationListItemText(){
        return destinationListItemIF.getElementInsureDomAttach(body).getText();
    }

    public boolean isLogoVisible(){
        return logoIF.getElementInsureDomAttach(body).isDisplayed();
    }

    public String getStaticText(int i) throws InterruptedException {
        return staticTextContainersIF.getElementInsureDomAttach(body, i).getText();
    }

    public String getHomeTitleText() throws InterruptedException {
        return homeTitleIF.getElementInsureDomAttach(body).getText();
    }

    public String getHomeContentText(){
        return homeContentTextIF.getElementInsureDomAttach(body).getText();
    }


}
