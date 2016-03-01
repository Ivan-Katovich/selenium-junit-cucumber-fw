package e2e.data;

import org.apache.xpath.SourceTree;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Date;

public abstract class ElementData {

    protected String selectorType;
    protected String selector;
    protected boolean isSingle;

    public ElementData(String selectorType, String selector, boolean isSingle){
        this.selectorType=selectorType;
        this.selector=selector;
        this.isSingle=isSingle;
    }

    public ElementData(String selectorType, String selector){
        this.selectorType=selectorType;
        this.selector=selector;
        this.isSingle=true;
    }

    public ElementData(String selector, boolean isSingle){
        this.selectorType="css";
        this.selector=selector;
        this.isSingle=isSingle;
    }

    public ElementData(String selector){
        this.selectorType="css";
        this.selector=selector;
        this.isSingle=true;
    }

    public By getSelector(){
        switch(this.selectorType){
            case "css":
                return By.cssSelector(this.selector);
            case "xpath":
                return By.xpath(this.selector);
            default:
                System.out.println("Wromg selector type");
                return null;
        }
    }

    public boolean waitForPresent(WebElement root){
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long time = new Date().getTime();
        long endTime = time+10000;
        int pooling = 300;
        System.out.println("Is element with { "+ this.selector+" } selector present on page?");
        while(root.findElements(this.getSelector()).size()<1 && time <= endTime){
            System.out.println("time: "+time);
            try {
                Thread.sleep(pooling);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            time = new Date().getTime();
        }
        if (time >= endTime) {
            System.out.println("Element is not present ");
            return false;
        }else{
            System.out.println(root.findElements(this.getSelector()).size()+" element(s) is present");
            return true;
        }
    }

    public boolean waitForPresent(int timeout,WebElement root){
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long time = new Date().getTime();
        long endTime = time+timeout;
        int pooling = 300;
        System.out.println("Is element with { "+ this.selector+" } selector present on page?");
        while(root.findElements(this.getSelector()).size()<1 && time <= endTime){
            System.out.println("time: "+time);
            try {
                Thread.sleep(pooling);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            time = new Date().getTime();
        }
        if (time >= endTime) {
            System.out.println("Element is not present ");
            return false;
        }else{
            System.out.println(root.findElements(this.getSelector()).size()+" element(s) is present");
            return true;
        }
    }

    public boolean waitForPresent(WebDriver driver){
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long time = new Date().getTime();
        long endTime = time+10000;
        int pooling = 300;
        System.out.println("Is element with { "+ this.selector+" } selector present on page?");
        while(driver.findElements(this.getSelector()).size()<1 && time <= endTime){
            System.out.println("time: "+time);
            try {
                Thread.sleep(pooling);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            time = new Date().getTime();
        }
        if (time >= endTime) {
            System.out.println("Element is not present ");
            return false;
        }else{
            System.out.println("element is present");
            return true;
        }
    }

    public boolean waitForVisible(WebElement root){
        long time = new Date().getTime();
        long endTime = time+10000;
        int pooling = 300;
        System.out.println("Is element with { "+ this.selector+" } selector visible?");
        while(!root.findElement(this.getSelector()).isDisplayed() && time <= endTime){
            System.out.println("time: "+time);
            try {
                Thread.sleep(pooling);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            time = new Date().getTime();
        }
        if (time >= endTime) {
            System.out.println("Element is not visible ");
            return false;
        }else{
            System.out.println("element is visible");
            return true;
        }
    }

    public boolean waitForVisible(int timeout,WebElement root){
        long time = new Date().getTime();
        long endTime = time+timeout;
        int pooling = 300;
        System.out.println("Is element with { "+ this.selector+" } selector visible?");
        while(!root.findElement(this.getSelector()).isDisplayed() && time <= endTime){
            System.out.println("time: "+time);
            try {
                Thread.sleep(pooling);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            time = new Date().getTime();
        }
        if (time >= endTime) {
            System.out.println("Element is not visible ");
            return false;
        }else{
            System.out.println("element is visible");
            return true;
        }
    }

    public boolean waitForVisible(WebElement root,int i){
        long time = new Date().getTime();
        long endTime = time+10000;
        int pooling = 300;
        System.out.println("Is "+i+" element with { "+ this.selector+" } selector visible?");
        while(!root.findElements(this.getSelector()).get(i).isDisplayed() && time <= endTime){
            System.out.println("time: "+time);
            try {
                Thread.sleep(pooling);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            time = new Date().getTime();
        }
        if (time >= endTime) {
            System.out.println("Element is not visible ");
            return false;
        }else{
            System.out.println("element is visible");
            return true;
        }
    }

    public boolean waitForVisible(int timeout,WebElement root,int i){
        long time = new Date().getTime();
        long endTime = time+timeout;
        int pooling = 300;
        System.out.println("Is "+i+" element with { "+ this.selector+" } selector visible?");
        while(!root.findElements(this.getSelector()).get(i).isDisplayed() && time <= endTime){
            System.out.println("time: "+time);
            try {
                Thread.sleep(pooling);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            time = new Date().getTime();
        }
        if (time >= endTime) {
            System.out.println("Element is not visible ");
            return false;
        }else{
            System.out.println("element is visible");
            return true;
        }
    }


    public boolean waitForVisible(WebDriver driver){
        long time = new Date().getTime();
        long endTime = time+10000;
        int pooling = 300;
        System.out.println("Is element with { " + this.selector + " } selector visible?");
        while(!driver.findElement(this.getSelector()).isDisplayed() && time <= endTime){
            System.out.println("time: "+time);
            try {
                Thread.sleep(pooling);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            time = new Date().getTime();
        }
        if (time >= endTime) {
            System.out.println("Element is not visible ");
            return false;
        }else{
            System.out.println("element is visible");
            return true;
        }
    }

    public int getNumber(WebElement root){
        try{
            if(this.waitForPresent(root)){
                return root.findElements(this.getSelector()).size();
            }else{
                return 0;
            }
        }catch(Exception e){
            System.out.println("Element is not attached to DOM. Will try again after timeout");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
            if(this.waitForPresent(root)){
                return root.findElements(this.getSelector()).size();
            }else{
                return 0;
            }
        }
    }

    public int getNumberWithoutWaiting(WebElement root){
        try{
            return root.findElements(this.getSelector()).size();
        }catch(Exception e){
            System.out.println("Have Exception. Will wait timeout and try again");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
            return root.findElements(this.getSelector()).size();
        }
    }

    public boolean waitForEnabled(WebElement root){
        long time = new Date().getTime();
        long endTime = time+10000;
        int pooling = 300;
        System.out.println("Is element with { " + this.selector + " } selector enabled?");
        while(!root.findElement(this.getSelector()).isEnabled() && time <= endTime){
            System.out.println("time: "+time);
            try {
                Thread.sleep(pooling);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            time = new Date().getTime();
        }
        if (time >= endTime) {
            System.out.println("Element is not enabled ");
            return false;
        }else{
            System.out.println("element is enabled");
            return true;
        }
    }

    public boolean waitForEnabled(WebDriver driver){
        long time = new Date().getTime();
        long endTime = time+10000;
        int pooling = 300;
        System.out.println("Is element with { " + this.selector + " } selector enabled?");
        while(!driver.findElement(this.getSelector()).isEnabled() && time <= endTime){
            System.out.println("time: "+time);
            try {
                Thread.sleep(pooling);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            time = new Date().getTime();
        }
        if (time >= endTime) {
            System.out.println("Element is not enabled ");
            return false;
        }else{
            System.out.println("element is enabled");
            return true;
        }
    }

    public boolean waitForEnabled(WebElement root,int i){
        long time = new Date().getTime();
        long endTime = time+10000;
        int pooling = 300;
        System.out.println("Is "+i+" element with { "+ this.selector+" } selector enabled?");
        while(!root.findElements(this.getSelector()).get(i).isEnabled() && time <= endTime){
            System.out.println("time: "+time);
            try {
                Thread.sleep(pooling);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            time = new Date().getTime();
        }
        if (time >= endTime) {
            System.out.println("Element is not enabled ");
            return false;
        }else{
            System.out.println("element is enabled");
            return true;
        }
    }


}
