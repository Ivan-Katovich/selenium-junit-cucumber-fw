package e2e.data;


import e2e.exceptions.ElementNotEnableException;
import e2e.exceptions.NotRightIsSingleFieldException;
import e2e.ui_elements.Sidekick;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class SidekickData extends ElementData{

    public SidekickData(String selectorType, String selector, boolean isSingle){
        super(selectorType,selector,isSingle);
    }

    public SidekickData(String selectorType, String selector){
        super(selectorType,selector);
    }

    public SidekickData(String selector, boolean isSingle){
        super(selector,isSingle);
    }

    public SidekickData(String selector){
        super(selector);
    }

    public Sidekick getElement(WebElement root){
        if(!this.isSingle){
            throw new NotRightIsSingleFieldException("It is not correct method for this multi SidekickData with selector: "+this.selector);
        }
        if(this.waitForPresent(root)){
            if(this.waitForVisible(root)){
                if(this.waitForEnabled(root)){
                    return new Sidekick(root.findElement(this.getSelector()));
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

    public Sidekick getElement(WebElement root,int i){
        if(this.isSingle){
            throw new NotRightIsSingleFieldException("It is not correct method for this single SidekickData with selector: "+this.selector);
        }
        if(this.waitForPresent(root)){
            if(this.waitForVisible(root,i)){
                if(this.waitForEnabled(root,i)){
                    return new Sidekick(root.findElements(this.getSelector()).get(i));
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

    public List<Sidekick> getElements(WebElement root){
        if(this.isSingle){
            throw new NotRightIsSingleFieldException("It is not correct method for this single SidekickData with selector: "+this.selector);
        }
        if(this.waitForPresent(root)){
            List<Sidekick> sidekicks = new ArrayList<Sidekick>();
            List<WebElement> elements = root.findElements(this.getSelector());
            System.out.println("Sidekick elements number is:  "+elements.size());
            for(WebElement element:elements){
                sidekicks.add(new Sidekick(element));
            }
            return sidekicks;
        }else{
            throw new NoSuchElementException("No elements with "+ this.getSelector() +" selector");
        }
    }


}
