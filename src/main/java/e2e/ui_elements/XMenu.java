package e2e.ui_elements;

import com.github.webdriverextensions.WebComponent;
import e2e.Browser;
import e2e.data.WebElementData;
import e2e.support.Helper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class XMenu {

    private WebElement root;
    private WebElementData edit = new WebElementData("xpath",".//span[text()='Edit']");
    private WebElementData delete = new WebElementData("xpath",".//span[text()='Delete']");
    private WebElementData xNew = new WebElementData("xpath",".//span[text()='New...']");

    public XMenu(WebElement root){
        this.root = root;
    }

    public WebElement getRoot(){
        return this.root;
    }

    public void edit(){
        edit.getElement(root).click();
    }

    public void delete(){
        delete.getElement(root).click();
    }

    public void xNew(){
        xNew.getElement(root).click();
    }
}
