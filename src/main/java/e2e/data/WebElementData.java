package e2e.data;

import com.github.webdriverextensions.WebComponent;
import e2e.Browser;
import e2e.exceptions.ElementNotEnableException;
import e2e.exceptions.NotRightIsSingleFieldException;
import e2e.ui_elements.XWindow;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;


public class WebElementData extends ElementData{

    public WebElementData(String selectorType, String selector, boolean isSingle){
        super(selectorType,selector,isSingle);
    }

    public WebElementData(String selectorType, String selector){
        super(selectorType,selector);
    }

    public WebElementData(String selector, boolean isSingle){
        super(selector,isSingle);
    }

    public WebElementData(String selector){
        super(selector);
    }

    public WebElement getElement(WebElement root){
        if(!this.isSingle){
            throw new NotRightIsSingleFieldException("It is not correct method for this multi WebElementData with selector: "+this.selector);
        }
        if(this.waitForPresent(root)){
            if(this.waitForVisible(root)){
                if(this.waitForEnabled(root)){
                    return root.findElement(this.getSelector());
                }else{
                    throw new ElementNotEnableException("Element "+ this.getSelector() +" is not clickable");
                }
            }else{
                throw new ElementNotVisibleException("Element "+ this.getSelector() +" is not visible");
            }
        }else{
            throw new NoSuchElementException("Element "+ this.getSelector() +" is not present");
        }
    }

    public WebElement getElement(WebDriver driver){
        if(!this.isSingle){
            throw new NotRightIsSingleFieldException("It is not correct method for this multi WebElementData with selector: "+this.selector);
        }
        if(this.waitForPresent(driver)){
            if(this.waitForVisible(driver)){
                if(this.waitForEnabled(driver)){
                    return driver.findElement(this.getSelector());
                }else{
                    throw new ElementNotEnableException("Element "+ this.getSelector() +" is not clickable");
                }
            }else{
                throw new ElementNotVisibleException("Element "+ this.getSelector() +" is not visible");
            }
        }else{
            throw new NoSuchElementException("Element "+ this.getSelector() +" is not present");
        }
    }

    public WebElement getElement(WebElement root,int i){
        if(this.isSingle){
            throw new NotRightIsSingleFieldException("It is not correct method for this single WebElementData with selector: "+this.selector);
        }
        if(this.waitForPresent(root)){
            if(this.waitForVisible(root,i)){
                if(this.waitForEnabled(root,i)){
                    return root.findElements(this.getSelector()).get(i);
                }else{
                    throw new ElementNotEnableException("Element "+i+" with "+ this.getSelector() +" is not clickable");
                }
            }else{
                throw new ElementNotVisibleException("Element "+i+" with "+ this.getSelector() +" is not visible");
            }
        }else{
            throw new NoSuchElementException("No elements with "+ this.getSelector() +" selector");
        }
    }

    public List<WebElement> getElements(WebElement root){
        if(this.isSingle){
            throw new NotRightIsSingleFieldException("It is not correct method for this single WebElementData with selector: "+this.selector);
        }
        if(this.waitForPresent(root)){
            System.out.println("Web elements number is: "+root.findElements(this.getSelector()).size());
            return root.findElements(this.getSelector());
        }else{
            throw new NoSuchElementException("No elements with "+ this.getSelector() +" selector");
        }
    }

    public WebElement getElementInsureDomAttach(WebElement root){
        try{
            return this.getElement(root);
        }catch(Exception e){
            System.out.println("Wait for element will be attached to DOM");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
            return this.getElement(root);
        }
    }

    public WebElement getElementInsureDomAttach(WebElement root,int i){
        try{
            return this.getElement(root,i);
        }catch(Exception e){
            System.out.println("Wait for element will be attached to DOM");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
            return this.getElement(root,i);
        }
    }

    public static void clickAlongTime(long endTime,int pooling, WebElement element){
        try{
            element.click();
        }catch(Exception e){
            try {
                Thread.sleep(pooling);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
            if(endTime>=new Date().getTime()){
                clickAlongTime(endTime,pooling,element);
            }
        }
    }

    public void clickOnElementUntilDone(WebElement root){
        long time = new Date().getTime();
        long endTime = time+10000;
        int pooling = 300;
        clickAlongTime(endTime,pooling,this.getElement(root));
    }

    public void clickOnElementUntilDone(WebElement root,int i){
        long time = new Date().getTime();
        long endTime = time+10000;
        int pooling = 300;
        clickAlongTime(endTime,pooling,this.getElement(root,i));
        WebElement element = (new WebDriverWait(Browser.driver, 10)).until(ExpectedConditions.visibilityOf(root.findElement(By.cssSelector("textarea[name='']"))));
    }








}
