package e2e;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;



public class Browser {

    public static WebDriver Driver;

    private static void InitDriver(){

        Chrome();

        //TSMGridFromEpamNetwork();

//        TSMGridFromTSMNetwork();

        Driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    public static void Start() {
        InitDriver();
    }

    public static void Close() {
        Driver.close();
        Driver.quit();
    }

    public static void Open(String url) {
        Driver.get(url);
    }

    public static void Chrome(){

        String os = System.getProperty("os.name").toLowerCase();
        if(os.contains("windows")){
            os = "windows";
        }
        if(os.contains("mac")){
            os = "mac";
        }
        if(os.contains("linux")){
            os = "linux";
        }
        switch (os) {
            case "windows":
                System.setProperty("webdriver.chrome.driver", "additional_libraries/chromedriver.exe");
                System.out.println("Properties for windows was setted !!!");
                break;
            case "mac":
                System.setProperty("webdriver.chrome.driver", "additional_libraries/chromedriver");
                System.out.println("Properties for mac was setted !!!");
                break;
            case "linux":
                System.setProperty("webdriver.chrome.driver", "additional_libraries/linux/chromedriver");
                System.out.println("Properties for linux was setted !!!");
                break;
            default:
                System.out.println("Unknown OS: " + os);
                System.out.println("Properties for this OS can not be setted !!!");
                break;
        }

        Driver = new ChromeDriver();
    }

    public static void TSMGridFromEpamNetwork(){

        // this address available from TSM infrastructure and Epam
        String gridHubUrl = "http://services.ci1-cms.gb.travelsupermarket.com/wd/hub";

        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        try {
            Driver = new RemoteWebDriver(new URL(gridHubUrl), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public static void TSMGridFromTSMNetwork(){

        // this address available only from TSM infrastructure
        String gridHubUrl = "http://selenium-hub1.inf1.gb.tsm.internal:4444/wd/hub";

        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        try {
            Driver = new RemoteWebDriver(new URL(gridHubUrl), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
