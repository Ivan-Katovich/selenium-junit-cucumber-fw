package e2e.exceptions;

import org.openqa.selenium.InvalidElementStateException;

public class ElementNotEnableException extends InvalidElementStateException {

    public ElementNotEnableException(String errorMessage){
        super(errorMessage);
    }
}
