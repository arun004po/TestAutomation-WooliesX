package pageobject;

import org.openqa.selenium.WebDriver;

public abstract class PageObjectBase {

    public static WebDriver edriver;

    public PageObjectBase(){

    }
    public static void setDriver(WebDriver driver)
    {
        edriver = driver;
    }

}
