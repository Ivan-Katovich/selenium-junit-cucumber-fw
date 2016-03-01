package e2e.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public abstract class TSMPage {

    @FindBy(css="body")
    protected WebElement body;

}
