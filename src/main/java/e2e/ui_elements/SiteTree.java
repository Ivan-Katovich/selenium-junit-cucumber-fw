package e2e.ui_elements;

import com.github.webdriverextensions.WebComponent;
import e2e.Browser;
import e2e.data.WebElementData;
import e2e.support.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SiteTree {

    private WebElement root;
    public SiteTree(WebElement root){
        this.root = root;
    }
    public WebElement getRoot(){
        return this.root;
    }

    public void selectSiteElementByName(String name){
        Helper.waitForLoading(100);
        WebElement element = new WebElementData("xpath",".//a/span[text()='" + name + "']").getElement(root);
        element.click();
        if(!element.findElement(By.xpath("./../..")).getAttribute("class").contains("x-tree-selected")){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            element.click();
        }
    }

    public void selectSiteElementContains(String name) throws InterruptedException {
        Helper.waitForLoading(100);
//        new WebElementData("xpath",".//a/span[contains(text(),'" + name + "')]").getElement(root).click();
        WebElement element = new WebElementData("xpath",".//a/span[contains(text(),'" + name + "')]").getElement(root);
        element.click();
        if(!element.findElement(By.xpath("./../..")).getAttribute("class").contains("x-tree-selected")){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            element.click();
        }
    }

    public void doubleClickOnElement(String name) throws InterruptedException {
        Helper.waitForLoading(100);
        Actions action = new Actions(Browser.driver);
        WebElement element = new WebElementData("xpath",".//a/span[text()='"+name+"']").getElement(root);
        action.doubleClick(element).perform();
        if(!element.findElement(By.xpath("./../..")).getAttribute("class").contains("x-tree-selected")){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            action.doubleClick(element).perform();
        }
    }

    public boolean isLinkExist(String name){
        Helper.waitForLoading(100);
        return new WebElementData("xpath",".//a/span[text()='" + name + "']").waitForPresent(root);
    }

    public boolean isLinkContainsTextExist(String name){
        Helper.waitForLoading(100);
        return new WebElementData("xpath",".//a/span[contains(text(),'" + name + "')]").waitForPresent(1500,root);
    }

    public void clickOnButton(String text){
        Helper.waitForLoading(100);
        new WebElementData("xpath",".//button[text()='" + text + "']").getElement(root).click();
    }

}
