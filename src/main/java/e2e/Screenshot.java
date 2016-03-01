package e2e;

import cucumber.api.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class Screenshot {

    public static void ScreenshotForCucumberJenkinsReport(Scenario scenario){
        final byte[] screenshot = ((TakesScreenshot) Browser.driver)
                .getScreenshotAs(OutputType.BYTES);
        scenario.embed(screenshot, "image/png");
    }

    public static void ScreenshotLocal(Scenario scenario) throws IOException {
        File scrFile = ((TakesScreenshot)Browser.driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("reports/screenshots/" + scenario.getName() + ".png"));
    }
}
