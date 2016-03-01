package e2e.ui_elements;

import com.github.webdriverextensions.WebComponent;
import e2e.Browser;
import e2e.data.WebElementData;
import e2e.support.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Sidekick extends XWindow{

    private WebElementData pageTab = new WebElementData("div.home-title");
    private WebElementData tabs = new WebElementData(".cq-sidekick-tab",false);


    public Sidekick(WebElement root){
        super(root);
    }

    public WebElement getRoot(){
        return this.root;
    }

    public void selectCategory(String name){
        new WebElementData("xpath",".//span[contains(text(),'" + name + "')]/preceding-sibling::div").getElement(root).click();
    }

    public void dragAndDropElementByName(String name){
        Actions action = new Actions(Browser.driver);
        WebElement element = new WebElementData("xpath",".//button[contains(text(),'" + name + "')]").getElement(root);
        action.dragAndDropBy(element, -300, -500).perform();
    }

    public void selectElement(String categoryName, String elementName){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(root.findElement(By.xpath(".//span[contains(text(),'" + categoryName + "')]")).getClass());
        WebElement category = new WebElementData("xpath",".//span[contains(text(),'" + categoryName + "')]").getElement(root);
        if(new WebElementData("xpath","./../..").getElement(category).getAttribute("class").contains("x-panel-collapsed")){
            category.click();
        }
        new WebElementData("xpath",".//button[contains(text(),'" + elementName + "')]").getElement(root).click();
    }

    public void switchTab(int number){
        tabs.getElements(root).get(number-1).click();
    }


}
