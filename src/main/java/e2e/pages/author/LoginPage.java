package e2e.pages.author;

import e2e.Browser;
import e2e.data.WebElementData;
import e2e.pages.TSMPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends TSMPage{

    private WebElementData userNameInput = new WebElementData("css", "input#username");
    private WebElementData passwordInput = new WebElementData("css", "input#password");
    private WebElementData signInButton = new WebElementData("css", "button.primary");

    public void login(String login, String password){
        userNameInput.getElement(body).sendKeys(login);
        passwordInput.getElement(body).sendKeys(password);
        signInButton.getElement(body).click();
    }
}
