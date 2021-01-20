package emirates.searchOption;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Map;

public class ReturnSearchOption implements SearchOption {

    @FindBy(id = "ctl00_c_CtWNW_ltReturn")
    private WebElement returnRadioButton;

    @FindBy(id = "ctl00_c_CtWNW_ddlFrom-suggest")
    private WebElement fromAirport;

    @FindBy(id = "ctl00_c_CtWNW_dvDepartDate")
    private WebElement departureDateSelect;

    @FindBy(css = "#ui-datepicker-div #calholder .ui-datepicker-group table tbody tr td a")
    private List<WebElement> dates;

    @FindBy(css = "#ctl00_c_CtWNW_flightClass_chosen a span")
    private WebElement departureSeatClass;

    @FindBy(id = "ctl00_c_CtWNW_ddlTo-suggest")
    private WebElement toAirport;

    @FindBy(id = "dvReturnDate")
    private WebElement returnDateSelect;

    @FindBy(css = "#ctl00_c_CtWNW_flightClass1_chosen a span")
    private WebElement arrivalSeatClass;

    @FindBy(id = "flexDateLabel")
    private WebElement flexibleFlight;

    public void enterFromAirport(String airport) {
        this.fromAirport.sendKeys(airport);
    }

    public void clickOnDepartureDate() {
        this.departureDateSelect.click();
    }

    public void selectDate(String date) {
        this.dates.stream()
                .filter(el -> el.getText().contains(date))
                .findFirst().ifPresent(ele -> ele.click());
    }

    public void enterToAirport(String toAirport) {
        this.toAirport.sendKeys(toAirport);
    }

    public void clickOnArrivalDate() {
        this.returnDateSelect.click();
    }

    public void clickOnFlexibleFlightIfNeeded(boolean isChecked) {
        if (isChecked) {
            this.flexibleFlight.click();
        }
    }

    public void selectFlightClass(final WebDriver driver, final WebElement element, String value) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].innerHTML = arguments[1]", element, value);
    }

    public void selectDepartureFlightClass(final WebDriver driver, String value) {
        selectFlightClass(driver, this.departureSeatClass, value);
    }

    public void selectArrivalFlightClass(final WebDriver driver, String value) {
        selectFlightClass(driver, this.arrivalSeatClass, value);
    }

    @Override
    public void searchWithCriteria(WebDriver driver, Map<String, Object> criterias) {
        enterFromAirport(String.valueOf(criterias.get("fromAirport")));
        clickOnDepartureDate();
        selectDate(String.valueOf(criterias.get("departureDate")));
        selectDepartureFlightClass(driver, String.valueOf(criterias.get("departureFlightClass")));
        enterToAirport(String.valueOf(criterias.get("toAirport")));
        clickOnArrivalDate();
        selectDate(String.valueOf(criterias.get("arrivalDate")));
        selectArrivalFlightClass(driver, String.valueOf(criterias.get("arrivalFlightClass")));
        clickOnFlexibleFlightIfNeeded(Boolean.parseBoolean((String) criterias.get("flexibleFlight")));
    }
}
