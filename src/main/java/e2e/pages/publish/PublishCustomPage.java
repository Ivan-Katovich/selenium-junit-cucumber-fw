package e2e.pages.publish;

import e2e.data.WebElementData;
import e2e.exceptions.NoSuchKeyInMapException;
import e2e.pages.TSMPage;
import e2e.support.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;

public class PublishCustomPage extends TSMPage{

//    private HashMap<String,WebElementData> pageData = new HashMap<String,WebElementData>(){{
//        put("cookieNotice", new WebElementData("css","cookie-notice div"));
//        put("globalError", new WebElementData("css","global-error div"));
//        put("homeTitle", new WebElementData("css","div.home-title"));
//        put("homeContentText", new WebElementData("css","div.home-content"));
//        put("staticText", new WebElementData("css","div.staticText",false));
//        put("seoDirectoryContentContainer", new WebElementData("css","div.seoDirectoryContentContainer"));
//        put("merchDirectoryContentContainer", new WebElementData("css","div.merchandisingDirectoryContentContainer"));
//        put("breadcrumbTrailItem", new WebElementData("css","div.breadcrumbTrail"));
//        put("disclaimerText", new WebElementData("css","div.disclaimer"));
//        put("footerNavigation", new WebElementData("css","div.footerNavigation"));
//        put("concertinaText", new WebElementData("css","div.concertinaText"));
//        put("richText", new WebElementData("css","div.richText"));
//        put("tickList", new WebElementData("css","div.tickList"));
//        put("navigationTopicList", new WebElementData("css","div.topicList"));
//        put("sitemapTopicList", new WebElementData("css","div.sitemapTopicList"));
//        put("logo", new WebElementData("css","img.logo-list__item-img"));
//    }};

    private WebElementData cookieNotice = new WebElementData("css","cookie-notice div");
    private WebElementData globalError = new WebElementData("css","global-error div");
    private WebElementData homeTitle = new WebElementData("css","div.home-title");
    private WebElementData homeContentText = new WebElementData("css","div.home-content");
    private WebElementData staticText = new WebElementData("css","div.staticText",false);
    private WebElementData containerLinkName = new WebElementData("css","a.destination-list__link");
    private WebElementData containerTitle = new WebElementData("css",".accordion-panel__heading");
    private WebElementData seoDirectoryContentContainer = new WebElementData("css","div.seoDirectoryContentContainer");
    private WebElementData merchDirectoryContentContainer = new WebElementData("css","div.merchandisingDirectoryContentContainer");
    private WebElementData breadcrumbTrailItem = new WebElementData("css","div.breadcrumbTrail");
    private WebElementData disclaimerText = new WebElementData("css","div.disclaimer");
    private WebElementData footerNavigation = new WebElementData("css","div.footerNavigation");
    private WebElementData concertinaText = new WebElementData("css","div.concertinaText");
    private WebElementData richText = new WebElementData("css","div.richText");
    private WebElementData tickList = new WebElementData("css","div.tickList");
    private WebElementData thirdPartyControlers = new WebElementData("css","div.thirdPartyWidgetController",false);
    private WebElementData navigationTopicList = new WebElementData("css","div.topicList");
    private WebElementData sitemapTopicList = new WebElementData("css","div.sitemapTopicList");
    private WebElementData logo = new WebElementData("css","img.logo-list__item-img");


//    private WebElementData getElementData(String webElementName){
//        System.out.println("SuperHomePage get: "+webElementName);
//        if(this.pageData.get(webElementName) == null){
//            throw new NoSuchKeyInMapException("No such key: '"+ webElementName +"' in pageData map on SuperHomePage");
//        }else{
//            return this.pageData.get(webElementName);
//        }
//    }

    public void closeCookieNotice(){
        Helper.closeNotice(cookieNotice, body);
    }

    public void closeGlobalError(){
        Helper.closeNotice(globalError, body);
    }


//    public String getWebElementText(String webElementName){
//        return this.getElementData(webElementName).getElement(body).getText();
//    }
//
//    public String getWebElementText(String webElementName, String root){
//        return this.getElementData(webElementName).getElement(this.getElementData(root).getElement(body)).getText();
//    }
//
//    public String getWebElementAttribute(String webElementName,String attribute){
//        return this.getElementData(webElementName).getElement(body).getAttribute(attribute);
//    }
//
//    public String getWebElementAttribute(String webElementName,String root,String attribute){
//        return this.getElementData(webElementName).getElement(this.getElementData(root).getElement(body)).getAttribute(attribute);
//    }
//
//    public boolean isWebElementVisible(String webElementName){
//        if(this.getElementData(webElementName).waitForPresent(body)){
//            return this.getElementData(webElementName).waitForVisible(body);
//        }
//        return false;
//    }
//
//    public boolean isWebElementVisible(String webElementName,String root){
//        if(this.getElementData(webElementName).waitForPresent(this.getElementData(root).getElement(body))){
//            return this.getElementData(webElementName).waitForVisible(this.getElementData(root).getElement(body));
//        }
//        return false;
//    }


    public String getHomeTitle(){
        return homeTitle.getElement(body).getText();
    }

    public String getHomeContentText(){
        return homeContentText.getElement(body).getText();
    }

    public String getStaticText(int i){
        return staticText.getElement(body,i).getText();
    }

    public String getSEODirContLinkText(){
        return seoDirectoryContentContainer.getElement(body).findElement(By.cssSelector("a.destination-list__link")).getText();
    }

    public String getSEODirContLinkUri(){
        return seoDirectoryContentContainer.getElement(body).findElement(By.cssSelector("a.destination-list__link")).getAttribute("href");
    }

    public String getSEODirContHeader(){
        return seoDirectoryContentContainer.getElement(body).findElement(By.cssSelector("header")).getText();
    }

    public String getMerchDirContHeader(){
        return merchDirectoryContentContainer.getElement(body).findElement(By.cssSelector("h2.heading--secondary")).getText();
    }

    public String getMerchDirContImageSrc(){
        return merchDirectoryContentContainer.getElement(body).findElement(By.cssSelector("img")).getAttribute("src");
    }

    public String getMerchDirContLinkUri(){
        return merchDirectoryContentContainer.getElement(body).findElement(By.cssSelector("a.directory-list-item")).getAttribute("href");
    }

    public String getMerchDirContBodyTitle(){
        return merchDirectoryContentContainer.getElement(body).findElement(By.cssSelector("h2.directory-list-item__heading")).getText();
    }

    public String getMerchDirContBodyText(){
        return merchDirectoryContentContainer.getElement(body).findElement(By.cssSelector("p")).getText();
    }

    public String getBreadcrumbLogoItemLink(){
        return breadcrumbTrailItem.getElement(body).findElement(By.xpath(".//li[@class='breadcrumbs__item'][1]/a")).getAttribute("href");
    }

    public String getBreadcrumbFirstItemLink(){
        return breadcrumbTrailItem.getElement(body).findElement(By.xpath(".//li[@class='breadcrumbs__item'][2]/a")).getAttribute("href");
    }

    public String getBreadcrumbFirstItemText(){
        return breadcrumbTrailItem.getElement(body).findElement(By.xpath(".//li[@class='breadcrumbs__item'][2]/a/span")).getText();
    }

    public String getBreadcrumbSecondItemLink(){
        return breadcrumbTrailItem.getElement(body).findElement(By.xpath(".//li[@class='breadcrumbs__item'][3]/a")).getAttribute("href");
    }

    public String getBreadcrumbSecondItemText(){
        return breadcrumbTrailItem.getElement(body).findElement(By.xpath(".//li[@class='breadcrumbs__item'][3]/a/span")).getText();
    }

    public String getDisclaimerText(){
        return disclaimerText.getElement(body).getText();
    }

    public String getFooterNavigationLinkText(int num){
        return footerNavigation.getElement(body).findElement(By.xpath(".//li[" + num + "]/a")).getText();
    }

    public String getFooterNavigationLink(int num){
        return footerNavigation.getElement(body).findElement(By.xpath(".//li[" + num + "]/a")).getAttribute("href");
    }

    public String getConcertinaItemTitle(){
        return concertinaText.getElement(body).findElement(By.cssSelector("h2.accordion-panel__header-title")).getText();
    }

    public String getConcertinaItemSubTitle(){
        return concertinaText.getElement(body).findElement(By.cssSelector("div.accordion-panel__optional-content.responsive-block-text p")).getText();
    }

    public String getConcertinaItemText(){
        concertinaText.getElement(body).findElement(By.cssSelector("span.accordion-panel__action-toggle")).click();
        return concertinaText.getElement(body).findElement(By.cssSelector("div.accordion-panel__content.text-wrapper p")).getText();
    }

    public String getRichText(){
        return richText.getElement(body).getText();
    }

    public String getTickListText(){
        return tickList.getElement(body).getText();
    }

    public String getLogoSrc(){
        return logo.getElement(body).getAttribute("src");
    }

    public String getNavigationTopicListTitleText(){
        return navigationTopicList.getElement(body).findElement(By.cssSelector("a.navigation__heading span")).getText();
    }

    public String getNavigationTopicListTitleLink(){
        return navigationTopicList.getElement(body).findElement(By.cssSelector("a.navigation__heading")).getAttribute("href");
    }

    public String getNavigationTopicListItemText(){
        return navigationTopicList.getElement(body).findElement(By.cssSelector("ul>li>a")).getText();
    }

    public String getNavigationTopicListItemLink(){
        return navigationTopicList.getElement(body).findElement(By.cssSelector("ul>li>a")).getAttribute("href");
    }

    public String getSitemapTopicListTitleText(){
        return sitemapTopicList.getElement(body).findElement(By.cssSelector("a.navigation__heading span")).getText();
    }

    public String getSitemapTopicListTitleLink(){
        return sitemapTopicList.getElement(body).findElement(By.cssSelector("a.navigation__heading")).getAttribute("href");
    }

    public String getSitemapTopicListItemText(){
        return sitemapTopicList.getElement(body).findElement(By.cssSelector("ul>li>a")).getText();
    }

    public String getSitemapTopicListItemLink(){
        return sitemapTopicList.getElement(body).findElement(By.cssSelector("ul>li>a")).getAttribute("href");
    }

    public String getThirdPartyControlerIFrameSrc(int i){
        return thirdPartyControlers.getElement(body,i).findElement(By.cssSelector("iframe")).getAttribute("src");
    }



}
