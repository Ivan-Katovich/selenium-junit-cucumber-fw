package e2e.exceptions;

import org.openqa.selenium.InvalidElementStateException;

public class NoSuchKeyInMapException extends InvalidElementStateException{

    public NoSuchKeyInMapException(String errorMessage){
        super(errorMessage);
    }

}
