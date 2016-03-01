package e2e.data;

import e2e.exceptions.ElementNotEnableException;
import e2e.exceptions.NotRightIsSingleFieldException;
import e2e.support.Helper;
import e2e.ui_elements.Sidekick;
import e2e.ui_elements.XMenu;
import e2e.ui_elements.XWindow;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class XMenuData extends ElementData{

    public XMenuData(String selectorType, String selector, boolean isSingle){
        super(selectorType,selector,isSingle);
    }

    public XMenuData(String selectorType, String selector){
        super(selectorType,selector);
    }

    public XMenuData(String selector, boolean isSingle){
        super(selector,isSingle);
    }

    public XMenuData(String selector){
        super(selector);
    }

    public XMenu getElement(WebElement root){
        if(!this.isSingle){
            throw new NotRightIsSingleFieldException("It is not correct method for this multi XMenuData with selector: "+this.selector);
        }
        Helper.waitForLoading(100);
        if(this.waitForPresent(root)){
            if(this.waitForVisible(root)){
                if(this.waitForEnabled(root)){
                    return new XMenu(root.findElement(this.getSelector()));
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

    public XMenu getElement(WebElement root,int i){
        if(this.isSingle){
            throw new NotRightIsSingleFieldException("It is not correct method for this single XMenuData with selector: "+this.selector);
        }
        if(this.waitForPresent(root)){
            if(this.waitForVisible(root,i)){
                if(this.waitForEnabled(root,i)){
                    return new XMenu(root.findElements(this.getSelector()).get(i));
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

    public List<XMenu> getElements(WebElement root){
        if(this.isSingle){
            throw new NotRightIsSingleFieldException("It is not correct method for this single XMenuData with selector: "+this.selector);
        }
        Helper.waitForLoading(100);
        if(this.waitForPresent(root)){
            List<XMenu> xMenus = new ArrayList<XMenu>();
            List<WebElement> elements = root.findElements(this.getSelector());
            System.out.println("XMenu elements number is:  "+elements.size());
            for(WebElement element:elements){
                xMenus.add(new XMenu(element));
            }
            return xMenus;
        }else{
            throw new NoSuchElementException("No elements with "+ this.getSelector() +" selector");
        }
    }

}
