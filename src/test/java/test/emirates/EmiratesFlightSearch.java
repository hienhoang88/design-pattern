package test.emirates;

import emirates.BookingScreen;
import emirates.LandingScreen;
import emirates.searchOption.OneWaySearchOption;
import emirates.searchOption.ReturnSearchOption;
import emirates.searchOption.SearchOption;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import test.BaseTest;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class EmiratesFlightSearch extends BaseTest {

    private BookingScreen bookingScreen;
    private LandingScreen landingScreen;

    @BeforeTest
    public void pageSetup(){
        this.bookingScreen = new BookingScreen(driver);
        this.landingScreen = PageFactory.initElements(driver, LandingScreen.class);
    }

    @Test(dataProvider = "getData")
    public void searchTest(SearchOption option, Map<String, Map<String, Object>> criteria){
        this.landingScreen.goTo();
        this.landingScreen.clickOnAcceptButtonIfPresent();
        this.landingScreen.clickOnNewSearch();
        Assert.assertTrue(this.bookingScreen.getPassengers().isDisplayed());
        this.bookingScreen.setSearchOption(option);
        this.bookingScreen.getSearchOption().searchWithCriteria(criteria.get("search"));
        this.bookingScreen.getPassengers().fillPassengerFilter(criteria.get("passenger"));
        this.bookingScreen.getPromoCode().inputPromoCode(criteria.get("promotion"));
        this.bookingScreen.getSearch().clickOnSearchButton();
        Assert.assertTrue(true);
    }

    @DataProvider
    public Object[][] getData(){
        Map<String, Map<String, Object>> oneWaySearch = new HashMap<>();
        Map<String, Map<String, Object>> returnSearch = new HashMap<>();

        Map<String, Object> oneWay = new HashMap<>();
        oneWay.put("fromAirport", "Bahrain");
        oneWay.put("departureDate", LocalDateTime.now().plusDays(3).getDayOfMonth());
        oneWay.put("flightClass", "Business Class");
        oneWay.put("toAirport", "Hanoi");
        oneWay.put("flexibleFlight", "false");

        Map<String, Object> twoWay = new HashMap<>();
        twoWay.put("fromAirport", "Paris (CDG)");
        twoWay.put("departureDate", LocalDateTime.now().plusDays(3).getDayOfMonth());
        twoWay.put("arrivalDate", LocalDateTime.now().plusDays(5).getDayOfMonth());
        twoWay.put("flightClass", "Business Class");
        twoWay.put("toAirport", "Leipzig Airport (LEJ)");
        twoWay.put("flexibleFlight", "true");

        Map<String, Object> passenger = new HashMap<>();
        passenger.put("adultNo", "3");
        passenger.put("childrenNo", "0");
        passenger.put("infantsNo", "0");

        Map<String, Object> promotion = new HashMap<>();
        promotion.put("isPromoted","true");
        promotion.put("promoCode", "ABC123def");

        oneWaySearch.put("search", oneWay);
        oneWaySearch.put("passenger", passenger);
        oneWaySearch.put("promotion", promotion);

        returnSearch.put("search", twoWay);
        returnSearch.put("passenger", passenger);
        returnSearch.put("promotion", promotion);

        return new Object[][]{
//                {new OneWaySearchOption(), oneWaySearch},
                {new ReturnSearchOption(), returnSearch}
        };
    }
}
