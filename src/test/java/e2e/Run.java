package e2e;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import e2e.support.Helper;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/e2e/features"
        ,glue="e2e/step_definitions"
        ,monochrome = true
        ,plugin = {"pretty", "json:reports/cucumber.json","html:reports/cucumber"}
//        ,format = {"pretty", "json:reports/cucumber.json","html:target/cucumber"}
//        ,tags = {"~@ignore","@AEM-SuperHomePage"}
//        ,tags = {"~@ignore","@AEM-Page-Creation-Journey"}
        ,tags = {"~@ignore"}
//        ,tags = {"@wip"}
)
public class Run {

    @BeforeClass
    public static void SetupTest() {
        Config.InitParams();
        Browser.start();
    }

    @AfterClass
    public static void TeardownTest() throws InterruptedException {
        Helper.environmentCleaner();
        Browser.close();
    }

}
