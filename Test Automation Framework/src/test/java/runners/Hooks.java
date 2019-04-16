package runners;


import Utilities.Browser;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.*;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;



public class Hooks {

    public static WebDriver driver;
    public static Properties configProperties = null;
    Browser browser = new Browser();
    public static Scenario scenario;

    @Before
    /**
     * Delete all cookies at the start of each scenario to avoid
     * shared state between tests
     */
    public void openBrowser(Scenario scenario) throws Exception {
        configProperties = new Properties();
        configProperties.load(new FileInputStream("//Users//poplia//Documents//wooliesX//Test Automation Framework//config.properties"));
        String browserName = configProperties.getProperty("browser");
        driver = browser.setLocalDriver(browserName);
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        //driver.navigate().to(configProperties.getProperty("URL"));
        this.scenario = scenario;
    }

    @After
    /**
     * Embed a screenshot in test report if test is marked as failed
     */
    public void embedScreenshot(Scenario scenario) {
        if (scenario.isFailed()) {
            try {
                scenario.write("Current Page URL is " + driver.getCurrentUrl());
                byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                scenario.embed(screenshot, "image/png");
                //Reporter.addsc
            } catch (WebDriverException somePlatformsDontSupportScreenshots) {
                System.err.println(somePlatformsDontSupportScreenshots.getMessage());
            }

        }
        driver.quit();
    }

}
