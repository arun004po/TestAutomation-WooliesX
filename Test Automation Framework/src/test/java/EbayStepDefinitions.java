import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.Keys;
import pageobjectfactory.ItemPage;
import runners.Hooks;
import stepdefinitions.Helper;

public class EbayStepDefinitions extends Helper {

    public EbayStepDefinitions() {
        driver = Hooks.driver;
    }

    @And("^I add book to the cart$")
    public void iAddBookToTheCart() {

        itemPage.btnClose.click();
    }

    @Given("^I launch url of the application$")
    public void iLaunchUrlOfTheApplication() {
        itemPage = new ItemPage(driver);
        driver.navigate().to("https://www.ebay.com.au/");
    }

    @When("^I search book \"([^\"]*)\" and enter$")
    public void iSearchBookAndEnter(String bookName) throws Throwable {
        itemPage.searchAnyThing(bookName);
    }

    @And("^I checkout items$")
    public void iCheckoutItems() {
        itemPage.setCheckout2Items();
    }

    @Then("^Verify items are added to checkout$")
    public void verifyItemsAreAddedToCheckout() {
        itemPage.verifymsgSignInToEbay();
    }

    @And("^I add second book to the cart$")
    public void iAddSecondBookToTheCart() {
        itemPage.addItemToCart();
    }


}
