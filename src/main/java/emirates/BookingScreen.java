package emirates;

import emirates.searchOption.SearchOption;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BookingScreen {
    private WebDriver driver;
    private Passengers passengers;
    private PromoCode promoCode;
    private Search search;
    private SearchOption searchOption;
    private JavascriptExecutor js;

    public BookingScreen(final WebDriver driver) {
        this.driver = driver;
        this.passengers = PageFactory.initElements(driver, Passengers.class);
        this.promoCode = PageFactory.initElements(driver, PromoCode.class);
        this.search = PageFactory.initElements(driver, Search.class);
    }

    public Passengers getPassengers() {
        return this.passengers;
    }

    public PromoCode getPromoCode() {
        return this.promoCode;
    }

    public Search getSearch() {
        return this.search;
    }

    public SearchOption getSearchOption() {
        return this.searchOption;
    }

    public void setSearchOption(SearchOption searchOption) {
        this.searchOption = searchOption;
        PageFactory.initElements(driver, this.searchOption);
        this.js = (JavascriptExecutor) driver;
    }
}
