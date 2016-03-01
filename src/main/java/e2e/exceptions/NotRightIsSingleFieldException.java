package e2e.exceptions;

import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.WebDriverException;

public class NotRightIsSingleFieldException extends InvalidElementStateException {

    public NotRightIsSingleFieldException(String errorMessage){
        super(errorMessage);
    }
}
