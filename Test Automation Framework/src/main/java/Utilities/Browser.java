package Utilities;

import org.apache.bcel.classfile.Constant;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public class Browser {

    private static DesiredCapabilities dr = null;
    private static String IE_BROWSER_NAME = "internet explorer";
    private static String FIREFOX_BROWSER_NAME = "firefox";
    private static String CHROME_BROWSER_NAME = "chrome";
    private static String EDGE_BROWSER_NAME = "";

    String CurrentDirectory;

    // Remove static to support parallel test
    public WebDriver setLocalDriver(String browserName) throws Exception {
        CurrentDirectory = System.getProperty("user.dir");
        if (browserName.equalsIgnoreCase(FIREFOX_BROWSER_NAME)) {
            System.setProperty("webdriver.gecko.driver", CurrentDirectory + "\\drivers\\geckodriver.exe");
            return new FirefoxDriver();
        }else if (browserName.equalsIgnoreCase(EDGE_BROWSER_NAME)) {
            System.setProperty("webdriver.chrome.driver", CurrentDirectory + "\\Drivers\\MicrosoftWebDriver.exe");
            return new ChromeDriver();
        }else if (browserName.equalsIgnoreCase(IE_BROWSER_NAME)) {
            System.setProperty("webdriver.ie.driver", CurrentDirectory + "\\Drivers\\IEDriverServer.exe");
            DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
            caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
            caps.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS, true);
            caps.setCapability(InternetExplorerDriver.NATIVE_EVENTS, false);
            caps.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
            caps.setCapability(InternetExplorerDriver.ENABLE_ELEMENT_CACHE_CLEANUP, true);
            return new InternetExplorerDriver(caps);
        }else {
            System.setProperty("webdriver.chrome.driver", "//Users//poplia//Documents//wooliesX//Test Automation Framework//Drivers//chromedriver 4");
            return new ChromeDriver();




        }
    }


}
