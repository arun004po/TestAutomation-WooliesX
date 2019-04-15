package stepdefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageobjectfactory.ItemPage;
import pageobjectfactory.bookingPage;
import runners.Hooks;

public class BookingStepDefinitions extends Helper {

    public BookingStepDefinitions() {
        driver = Hooks.driver;
    }


    @Given("^I am logged in to the application$")
    public void iAmLoggedInToTheApplication() {
        bookingPage = new bookingPage(driver);
        driver.navigate().to("https://www.ebay.com.au/");
    }

    @When("^I search hotel \"([^\"]*)\"$")
    public void iSearchHotel(String hotelName) throws Throwable {
        bookingPage.searchHotel(hotelName);
    }

    @And("^I enter checkindate \"([^\"]*)\" and checkoutdate\"([^\"]*)\" and click search$")
    public void iEnterCheckindateAndCheckoutdateAndClickSearch(String checkInDate, String checkOutDate) throws Throwable {
        bookingPage.checkInHotel(checkInDate, checkOutDate);
    }

    @And("^I confirm room booking and payment$")
    public void iConfirmRoomBookingAndPayment() {
        bookingPage.selectRoom();
        bookingPage.clickbookNowButton();
        bookingPage.setBtnConfirmThisBooking();
        bookingPage.selectPaymentOption();
        bookingPage.handleAlert();
    }

    @Then("^I verify hotel room is booked$")
    public void iVerifyHotelRoomIsBooked() {
        bookingPage.verifyHotelRoomBooking();
    }

    @When("^I enter city \"([^\"]*)\" to find flight$")
    public void iEnterCityToFindFlight(String cityName) throws Throwable {
        bookingPage.setEnterCityOrAirport(cityName);
    }

    @And("^I enter checkinDate \"([^\"]*)\" to find flight and click Search button$")
    public void iEnterCheckinDateToFindFlightAndClickSearchButton(String checkInDate) throws Throwable {
        bookingPage.enterDepartureDate(checkInDate);
        bookingPage.clickSearchButtonFlight();
    }

    @And("^I confirm flight booking and payment$")
    public void iConfirmFlightBookingAndPayment() {
        bookingPage.setBookFlight();
        bookingPage.confirmFlight();
    }

    @Then("^I verify flight is booked$")
    public void iVerifyFlightIsBooked() {
        bookingPage.verifyFlightBooking();
    }

    @When("^I enter trip \"([^\"]*)\" to find tour$")
    public void iEnterTripToFindTour(String tourName) throws Throwable {
        bookingPage.setEnterTourName(tourName);
    }

    @And("^I enter date \"([^\"]*)\" to find tour and click Search button$")
    public void iEnterDateToFindTourAndClickSearchButton(String date) throws Throwable {
        bookingPage.setTourBookingDate(date);
        bookingPage.clickSearchButton();
    }

    @And("^I confirm tour booking and payment$")
    public void iConfirmTourBookingAndPayment() {
        bookingPage.setClickDetails();
        bookingPage.clickbookNowButton();
        bookingPage.setBtnConfirmThisBooking();
    }

    @Then("^I verify tour is booked$")
    public void iVerifyTourIsBooked() {
        bookingPage.verifyTourBooking();
    }
}
