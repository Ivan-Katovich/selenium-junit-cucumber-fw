package e2e;

import java.net.MalformedURLException;
import java.net.URL;

import e2e.support.SessionOptions;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;


public class Browser {

    public static WebDriver driver;

    public static SessionOptions options = new SessionOptions();

    private static void initDriver(){

        switch (Config.browser) {
            case "Chrome":
                chrome();
                break;
            case "Firefox":
                firefox();
                break;
            case "TSMGridFromEpam":
                tsmGridFromEpamNetwork();
                break;
            case "TSMGridFromTSM":
                tsmGridFromTSMNetwork();
                break;
            case "TSMGridFromEpamFirefox":
                tsmGridFromEpamNetworkFirefox();
                break;
            case "TSMGridFromTSMFirefox":
                tsmGridFromTSMNetworkFirefox();
                break;
            case "TSMGridFromEpamIE11":
                tsmGridFromEpamNetworkIE11();
                break;
            case "TSMGridFromTSMIE11":
                tsmGridFromTSMNetworkIE11();
                break;
            default:
                System.out.println("Wrong Browser !!! check you params, please !");
                break;
        }

//        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);

    }

    public static void start() {
        initDriver();
    }

    public static void close() {
        {
            try
            {
//                Browser.driver.close();
                Browser.driver.quit();
                if(Browser.driver != null) {
                    Browser.driver.close();
                }
            }
            catch (Exception anException)
            {
                try{
                    String os = System.getProperty("os.name").toLowerCase();
                    if(os.contains("windows")){
                        Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe");
                        System.out.println("driver was killed");
                    }
                }catch(Exception e){
                    System.out.println("driver is not exists");
                }
            }
        }
    }

    public static void chrome(){

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
                System.setProperty("webdriver.chrome.driver", "additional_libraries/drivers/windows/chromedriver.exe");
                System.out.println("Properties for windows has been set!");
                break;
            case "mac":
                System.setProperty("webdriver.chrome.driver", "additional_libraries/drivers/mac/chromedriver");
                System.out.println("Properties for mac has been set!");
                break;
            case "linux":
                System.setProperty("webdriver.chrome.driver", "additional_libraries/drivers/linux/chromedriver");
                System.out.println("Properties for linux has been set!");
                break;
            default:
                System.out.println("Unknown OS: " + os);
                System.out.println("Properties for this OS can not be set!");
                break;
        }

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--window-size=1900,1000");
        driver = new ChromeDriver(options);

        System.out.println("\n Started tests on Localhost \n ");
    }

    public static void firefox(){
        FirefoxProfile profile = new FirefoxProfile();
        profile.setPreference("browser.startup.page",0);
        profile.setPreference("startup.homepage_welcome_url.additional","about:blank");
//        profile.setPreference("browser.link.open_newwindow",3);

        driver = new FirefoxDriver(profile);
        driver.manage().window().setSize(new Dimension(1900,1000));

    }

    public static void tsmGridFromEpamNetwork(){
        // this address available from TSM infrastructure and Epam
        String gridHubUrl = "http://services.ci1-cms.gb.travelsupermarket.com/wd/hub";

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--window-size=1900,1000");
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        try {
            driver = new RemoteWebDriver(new URL(gridHubUrl), capabilities);
            System.out.println("\n Connected to TSM grid host from EPAM network successfully \n Grid URL: "+gridHubUrl+"\n");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public static void tsmGridFromTSMNetwork(){
        // this address available only from TSM infrastructure
        String gridHubUrl = "http://selenium-hub1.inf1.gb.tsm.internal:4444/wd/hub";

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--window-size=1900,1000");
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        try {
            driver = new RemoteWebDriver(new URL(gridHubUrl), capabilities);
            System.out.println("\n Connected to TSM grid host from TSM Jenkins successfully \n Grid URL: "+gridHubUrl+"\n");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public static void tsmGridFromEpamNetworkFirefox(){
        FirefoxProfile profile = new FirefoxProfile();
        profile.setPreference("browser.startup.page",0);
        profile.setPreference("startup.homepage_welcome_url.additional","about:blank");
        try {
            URL gridFirefoxHost = new URL("http://services.ci1-cms.gb.travelsupermarket.com/wd/hub");
            DesiredCapabilities firefoxCapability = DesiredCapabilities.firefox();
            firefoxCapability.setJavascriptEnabled(true);
            firefoxCapability.setCapability(FirefoxDriver.PROFILE, profile);
            driver = new RemoteWebDriver(gridFirefoxHost, firefoxCapability);
            driver.manage().window().setSize(new Dimension(1900,1000));
            System.out.println("\n Connected to TSM grid host from Epam network successfully \n Grid URL: \"http://services.ci1-cms.gb.travelsupermarket.com/wd/hub\"\n");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public static void tsmGridFromTSMNetworkFirefox(){
        FirefoxProfile profile = new FirefoxProfile();
        profile.setPreference("browser.startup.page",0);
        profile.setPreference("startup.homepage_welcome_url.additional","about:blank");
        try {
            URL gridFirefoxHost = new URL("http://selenium-hub1.inf1.gb.tsm.internal:4444/wd/hub");
            DesiredCapabilities firefoxCapability = DesiredCapabilities.firefox();
            firefoxCapability.setJavascriptEnabled(true);
            firefoxCapability.setCapability(FirefoxDriver.PROFILE, profile);
            driver = new RemoteWebDriver(gridFirefoxHost, firefoxCapability);
            driver.manage().window().setSize(new Dimension(1900,1000));
            System.out.println("\n Connected to TSM grid host from TSM Jenkins successfully \n Grid URL: \"http://selenium-hub1.inf1.gb.tsm.internal:4444/wd/hub\"\n");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public static void tsmGridFromEpamNetworkIE11() {
        try {
            URL gridFirefoxHost = new URL("http://services.ci1-cms.gb.travelsupermarket.com/wd/hub");
            DesiredCapabilities ieCapability = DesiredCapabilities.internetExplorer();
            ieCapability.setVersion("11");
            driver = new RemoteWebDriver(gridFirefoxHost, ieCapability);
            driver.manage().window().setSize(new Dimension(1900, 1000));
            System.out.println("\n Connected to TSM grid host from Epam network successfully \n Grid URL: \"http://services.ci1-cms.gb.travelsupermarket.com/wd/hub\"\n");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public static void tsmGridFromTSMNetworkIE11() {
        try {
            URL gridFirefoxHost = new URL("http://selenium-hub1.inf1.gb.tsm.internal:4444/wd/hub");
            DesiredCapabilities ieCapability = DesiredCapabilities.internetExplorer();
            ieCapability.setVersion("11");
            driver = new RemoteWebDriver(gridFirefoxHost, ieCapability);
            driver.manage().window().setSize(new Dimension(1900, 1000));
            System.out.println("\n Connected to TSM grid host from TSM Jenkins successfully \n Grid URL: \"http://selenium-hub1.inf1.gb.tsm.internal:4444/wd/hub\"\n");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
