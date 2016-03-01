package e2e.ui_elements;

import e2e.Browser;
import e2e.data.WebElementData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class XWindow {

    protected WebElement root;
    private WebElementData selectedItem = new WebElementData("div.template-item.x-view-selected");
    private WebElementData loups = new WebElementData("img.x-form-search-trigger",false);
    private WebElementData checkboxes = new WebElementData("input.x-form-checkbox",false);
    private WebElementData radioButtons = new WebElementData("input.x-form-radio",false);
    private WebElementData frames = new WebElementData("iframe",false);


    public XWindow(WebElement root){
        this.root = root;
    }

    public WebElement getRoot(){
        return this.root;
    }

    public String getSelectedItemTitle(){
        return selectedItem.getElement(root).getText();
    }

    public void inputSendKeys(String inputName, String text){
        new WebElementData("css","input[name='"+inputName+"']").getElement(root).sendKeys(text);
    }

    public void inputSendKeysByLabel(String label, String text){
        new WebElementData("xpath",".//label[text()='" + label + "']/following-sibling::div/input").getElement(root).sendKeys(text);
    }

    public void inputSendKeysByAnnotation(String annotation, String text){
        new WebElementData("xpath",".//div[text()='" + annotation + "']/preceding-sibling::div/input").getElement(root).sendKeys(text);
    }

    public void addIFrameDimensionsInFieldSet(Integer x, Integer y){
        WebElement labelX = new WebElementData("xpath",".//label[text()='X']").getElement(root);
        new WebElementData("xpath","./preceding-sibling::input").getElement(labelX).sendKeys(x.toString());
        new WebElementData("xpath","./following-sibling::input").getElement(labelX).sendKeys(y.toString());
    }

    public void clickOnLoup(int i){
        loups.getElement(root,i).click();
    }

    public void textareaSendKeys(String areaName, String text){
        new WebElementData("css","textarea[name='"+areaName+"']").getElement(root).sendKeys(text);

    }

    public void clickOnButton(String text){
        new WebElementData("xpath",".//button[text()='" + text + "']").getElement(root).click();
    }

    public void clickOnLink(String link){
        new WebElementData("xpath",".//*[text()='" + link + "']").getElement(root).click();
    }

    public void selectItem(String itemName){
        new WebElementData("xpath",".//*[contains(text(),'"+itemName+"')]").getElement(root).click();
    }

    public void clickOnCheckbox(int num){
        checkboxes.getElements(root).get(num - 1).click();
        if(!checkboxes.getElements(root).get(num - 1).isSelected()){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            checkboxes.getElements(root).get(num - 1).click();
        }
    }

    public void clickOnRadioButton(int num){
        radioButtons.getElements(root).get(num - 1).click();
        if(!radioButtons.getElements(root).get(num - 1).isSelected()){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            radioButtons.getElements(root).get(num - 1).click();
        }
    }

    public void addTextIntoFrame(int frameNum,String text) throws InterruptedException {
        Browser.driver.switchTo().frame(frames.getElements(root).get(frameNum - 1));
        WebElement body = Browser.driver.findElement(By.cssSelector("body"));
        body.sendKeys(text);
        Browser.driver.switchTo().defaultContent();
    }

    public boolean isLabelWithTextPresent(String label){
        return new WebElementData("xpath",".//label[text()='"+label+"']").getElement(root).isDisplayed();
    }

    public boolean isFieldsetInTabWithLabelChacked(int fieldsetNumber,String label) {
        WebElement fieldset = new WebElementData("xpath",".//label[text()='"+ label +"']/..//fieldset[contains(@class,'x-fieldset-noborder')]",false).getElements(root).get(fieldsetNumber);
        return new WebElementData("css","input.x-form-radio").getElement(fieldset).isSelected();
    }

    public String getTitle(){
        return new WebElementData("div.x-window-header").getElement(root).getText();
    }

    public int getFrameNumber(){
        return frames.getNumberWithoutWaiting(root);
    }

}
