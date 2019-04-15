package pageobjectfactory;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import pageobject.PageObjectBase;

public class ItemPage extends PageObjectBase {

    public static WebDriver edriver;

    public ItemPage(WebDriver driver) {
        edriver = driver;
        PageFactory.initElements(edriver, this);
        setDriver(edriver);
    }

    @FindBy(how = How.NAME, using = "_nkw")
    public WebElement txtBoxSearchForAnything;

    @FindBy(how = How.XPATH, using = ("//img[@alt='NEW Think and Grow Rich By Napoleon Hill Hardcover Free Shipping']"))
    public WebElement bookThinkAndGrowRich;

    @FindBy(how = How.ID, using = "atcRedesignId_btn")
    public WebElement btnAddToCart;

    @FindBy(how = How.XPATH, using = "//span[@class='offscreen'][contains(text(),'Close button']")
    public WebElement btnClose;

    @FindBy(how = How.XPATH, using = ("//*[@class='s-item__title s-item__title--has-tags'][text(),'Rich Dad Poor Dad (PDF) - By Robert T. Kiyosaki']"))
    public WebElement bookRichDadPoorDad;

    @FindBy(how = How.XPATH, using = ("//span[@text='Checkout 2 items']"))
    public WebElement checkout2Items;

    @FindBy(how = How.ID, using = ("GREET-SIGN-IN-TO-EBAY"))
    public WebElement msgSignInToEbay;


    public void addItemToCart() {
        btnAddToCart.click();
        setBtnClose();
    }

    public void searchAnyThing(String item) {
        txtBoxSearchForAnything.sendKeys();
        txtBoxSearchForAnything.sendKeys(Keys.RETURN);
    }

    /**
     * Verify user is on cart checkout
     */
    public void verifymsgSignInToEbay() {
        Assert.assertTrue(msgSignInToEbay.isDisplayed());
    }

    public void setBtnClose() {
        btnClose.click();
    }

    public void setCheckout2Items() {
         msgSignInToEbay.click();
    }

}
