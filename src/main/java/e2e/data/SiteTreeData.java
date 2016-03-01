package e2e.data;


import e2e.exceptions.ElementNotEnableException;
import e2e.exceptions.NotRightIsSingleFieldException;
import e2e.ui_elements.SiteTree;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class SiteTreeData extends ElementData {

    public SiteTreeData(String selectorType, String selector, boolean isSingle){
        super(selectorType,selector,isSingle);
    }

    public SiteTreeData(String selectorType, String selector){
        super(selectorType,selector);
    }

    public SiteTreeData(String selector, boolean isSingle){
        super(selector,isSingle);
    }

    public SiteTreeData(String selector){
        super(selector);
    }

    public SiteTree getElement(WebElement root){
        if(!this.isSingle){
            throw new NotRightIsSingleFieldException("It is not correct method for this multi SiteTreeData with selector: "+this.selector);
        }
        if(this.waitForPresent(root)){
            if(this.waitForVisible(root)){
                if(this.waitForEnabled(root)){
                    return new SiteTree(root.findElement(this.getSelector()));
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

    public SiteTree getElement(WebElement root,int i){
        if(this.isSingle){
            throw new NotRightIsSingleFieldException("It is not correct method for this single SiteTreeData with selector: "+this.selector);
        }
        if(this.waitForPresent(root)){
            if(this.waitForVisible(root,i)){
                if(this.waitForEnabled(root,i)){
                    return new SiteTree(root.findElements(this.getSelector()).get(i));
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

    public List<SiteTree> getElements(WebElement root){
        if(this.isSingle){
            throw new NotRightIsSingleFieldException("It is not correct method for this single SiteTreeData with selector: "+this.selector);
        }
//        Helper.waitForLoading(100);
        if(this.waitForPresent(root)){
            List<SiteTree> siteTrees = new ArrayList<SiteTree>();
            List<WebElement> elements = root.findElements(this.getSelector());
            System.out.println("SiteTree elements number is:  "+elements.size());
            for(WebElement element:elements){
                siteTrees.add(new SiteTree(element));
            }
            return siteTrees;
        }else{
            throw new NoSuchElementException("No elements with "+ this.getSelector() +" selector");
        }
    }

}
