package e2e.step_definitions;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import e2e.Browser;
import e2e.Config;
import e2e.Screenshot;
import e2e.base.Admin;
import e2e.support.Helper;
import org.openqa.selenium.Cookie;

import java.io.IOException;
import java.util.Set;

public class Hooks {

//    @After
//    public void deleteAllCookies() {
//        Browser.driver.manage().deleteAllCookies();
//    }

//    @After
//    public void takeScreenshotIsScenarioFailed(Scenario scenario) throws IOException {
//        if (scenario.isFailed()) {
//            Screenshot.ScreenshotForCucumberJenkinsReport(scenario);
////            Screenshot.ScreenshotLocal(scenario);
//        }
//
//    }

    @After
    public void closePage(Scenario scenario) throws Throwable {
        if (scenario.isFailed()) {
            Screenshot.ScreenshotForCucumberJenkinsReport(scenario);
//            Screenshot.ScreenshotLocal(scenario);
        }
        Set<String> handles = Browser.driver.getWindowHandles();
        if(handles.size()>1){
            Browser.driver.close();
        }
        Helper.switchToHandle(Browser.options.firstHandle);
    }

}
