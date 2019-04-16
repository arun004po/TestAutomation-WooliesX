package pageobjectfactory;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobject.PageObjectBase;

import java.util.List;

public class bookingPage extends PageObjectBase {

    public static WebDriver edriver;

    public bookingPage(WebDriver driver) {
        edriver = driver;
        PageFactory.initElements(edriver, this);
        setDriver(edriver);
    }

    @FindBy(how = How.XPATH, using = "/html/body/nav/div/div[2]/ul[1]/li[2]/a")
    public WebElement myAccount;

    @FindBy(how = How.XPATH, using = "//a[text(),'Login']")
    public WebElement login;

    @FindBy(how = How.NAME, using = "username")
    public WebElement username;

    @FindBy(how = How.NAME, using = "password")
    public WebElement password;

    @FindBy(how = How.XPATH, using = "//button[contains(text(),'Login')]")
    public WebElement btnLogin;

    @FindBy(how = How.XPATH, using = "//span[contains(text(),'Hotels')]")
    public WebElement hotels;

    @FindBy(how = How.XPATH, using = "//span[contains(text(),'Flights')]")
    public WebElement flights;

    @FindBy(how = How.XPATH, using = "//span[contains(text(),'Tours')]")
    public WebElement tours;

    @FindBy(how = How.XPATH, using = "//span[contains(text(),'Search by Hotel or City Name')]")
    public WebElement searchByHotelOrCityName;

    @FindBy(how = How.XPATH, using = "//span[contains(text(),'Enter City Or Airport')]")
    public WebElement enterCityOrAirport;

    @FindBy(how = How.XPATH, using = "//*[@id='s2id_autogen5']/a/span[1]")
    public WebElement enterTourName;

    @FindBy(how = How.NAME, using = "checkin")
    public WebElement checkIn;

    @FindBy(how = How.NAME, using = "checkout")
    public WebElement checkOut;

    @FindBy(how = How.NAME, using = "departure")
    public WebElement departure;

    @FindBy(how = How.XPATH, using = "//*[@id=/'hotels/']/form/div[5]/button")
    public WebElement btnSearch;

    @FindBy(how = How.XPATH, using = "//button[contains(text(),'Search')]")
    public WebElement btnSearchFlights;

    @FindBy(how = How.XPATH, using = "//div[@class='control__indicator']")
    public WebElement chckBoxRoom;

    @FindBy(how = How.XPATH, using = "//button[contains(text(),'Book Now')]")
    public WebElement btnBookNow;

    @FindBy(how = How.ID, using = "bookbtn")
    public WebElement bookFlight;

    @FindBy(how = How.NAME, using = "logged")
    public WebElement btnConfirmThisBooking;

    @FindBy(how = How.XPATH, using = "//button[contains(text(),'CONFIRM THIS BOOKING']")
    public WebElement btnConfirmThisBookingFlight;

    @FindBy(how = How.XPATH, using = "//button[contains(text(),'Pay on Arrival')]")
    public WebElement btnPayOnArrival;

    @FindBy(how = How.XPATH, using = "//div[contains(text(),'Invoice')]")
    public WebElement txtInvoice;

    @FindBy(how = How.NAME, using = "date")
    public WebElement tourBookingDate;

    @FindBy(how = How.NAME, using = "//class[contains(text(),'Details'")
    public WebElement clickDetails;

    @FindBy(how = How.NAME, using = "//*[@id='tours']/form/div[5]/button")
    public WebElement btnSearchTour;


    public void clickMyAccount() {
        myAccount.click();
    }

    public void clickSearchButton() {
        btnSearchTour.click();
    }

    public void setEnterTourName(String tourName) {
        WebDriverWait wait = new WebDriverWait(edriver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(enterTourName));
        enterTourName.sendKeys(tourName);
    }

    public void setTourBookingDate(String date) {
        tourBookingDate.sendKeys(date);
    }

    public void setClickDetails() {
        clickDetails.click();
    }

    public void loginToTheApplication(String uname, String pwd) {
        username.sendKeys(uname);
        password.sendKeys(pwd);
        btnLogin.click();
    }

    public void clickHotels() {
        hotels.click();
    }

    public void clickFlights() {
        flights.click();
    }

    public void clickTours() {
        tours.click();
    }

    public void checkInHotel(String checkinDate, String checkOutDate) {
        checkIn.sendKeys(checkinDate);
        checkIn.sendKeys(Keys.TAB);
        checkOut.sendKeys(checkOutDate);
        checkOut.sendKeys(Keys.TAB);
        btnSearch.click();
    }

    public void setEnterCityOrAirport(String cityOrAirport) {
        enterCityOrAirport.sendKeys(cityOrAirport);
    }

    public void enterDepartureDate(String date) {
        departure.sendKeys(date);
        departure.sendKeys(Keys.TAB);
        departure.sendKeys(Keys.TAB);
    }

    public void setBookFlight() {
        bookFlight.click();
    }

    public void confirmFlight() {
        btnConfirmThisBookingFlight.click();
    }

    public void clickSearchButtonFlight() {
        btnSearchFlights.click();
    }

    public void enterflightDateAndSearch(String date) {
        enterDepartureDate(date);
        clickSearchButtonFlight();

    }

    public void searchHotel(String hotelName) {
        Actions actions = new Actions(edriver);
        actions.moveToElement(searchByHotelOrCityName);
        actions.click();
        searchByHotelOrCityName.sendKeys(hotelName);

    }

    public void selectRoom() {
        List<WebElement> rooms = edriver.findElements(By.xpath("//div[@class='control__indicator']"));
        rooms.get(0).click();
    }

    public void clickbookNowButton() {
        btnBookNow.click();
    }

    public void setBtnConfirmThisBooking() {
        btnConfirmThisBooking.click();
    }

    public void selectPaymentOption() {
        btnPayOnArrival.click();
    }

    public void handleAlert() {
        edriver.switchTo().alert().accept();
    }

    public void verifyHotelRoomBooking() {
        Assert.assertTrue(txtInvoice.isDisplayed());
    }

    public void verifyFlightBooking() {
        Assert.assertTrue(txtInvoice.isDisplayed());
    }

    public void verifyTourBooking() {
        Assert.assertTrue(txtInvoice.isDisplayed());
    }


}
