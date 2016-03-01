package e2e.data;

import e2e.exceptions.ElementNotEnableException;
import e2e.exceptions.NotRightIsSingleFieldException;
import e2e.ui_elements.XWindow;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class XWindowData extends ElementData {

    public XWindowData(String selectorType, String selector, boolean isSingle){
        super(selectorType,selector,isSingle);
    }

    public XWindowData(String selectorType, String selector){
        super(selectorType,selector);
    }

    public XWindowData(String selector, boolean isSingle){
        super(selector,isSingle);
    }

    public XWindowData(String selector){
        super(selector);
    }

    public XWindow getElement(WebElement root){
        if(!this.isSingle){
            throw new NotRightIsSingleFieldException("It is not correct method for this multi XWindowData with selector: "+this.selector);
        }
        if(this.waitForPresent(root)){
            if(this.waitForVisible(root)){
                if(this.waitForEnabled(root)){
                    return new XWindow(root.findElement(this.getSelector()));
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

    public XWindow getElement(WebElement root,int i){
        if(this.isSingle){
            throw new NotRightIsSingleFieldException("It is not correct method for this single XWindowData with selector: "+this.selector);
        }
        if(this.waitForPresent(root)){
            if(this.waitForVisible(root,i)){
                if(this.waitForEnabled(root,i)){
                    return new XWindow(root.findElements(this.getSelector()).get(i));
                }else{
                    throw new ElementNotEnableException("Element "+i+" with "+ this.getSelector() +" is not clickable");
                }
            }else{
                throw new ElementNotVisibleException("Element "+i+" with"+ this.getSelector() +" is not visible");
            }
        }else{
            throw new NoSuchElementException("No elements with "+ this.getSelector() +" selector");
        }
    }

    public List<XWindow> getElements(WebElement root){
        if(this.isSingle){
            throw new NotRightIsSingleFieldException("It is not correct method for this single XWindowData with selector: "+this.selector);
        }
        if(this.waitForPresent(root)){
            List<WebElement> elements = root.findElements(this.getSelector());
            List<XWindow> xWindows = new ArrayList<XWindow>();
            System.out.println("Xwindow elements number is:  "+elements.size());
            for(WebElement element:elements){
                xWindows.add(new XWindow(element));
            }
            return xWindows;
        }else{
            throw new NoSuchElementException("No elements with "+ this.getSelector() +" selector");
        }
    }

    public XWindow getElementInsureDomAttach(WebElement root){
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

    public XWindow getElementInsureDomAttach(WebElement root,int i){
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
}
