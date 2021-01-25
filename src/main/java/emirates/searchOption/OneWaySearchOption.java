package emirates.searchOption;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Map;

public class OneWaySearchOption implements SearchOption {

    @FindBy(id = "ctl00_c_CtWNW_ltOneway")
    private WebElement oneWayRadionButton;

    @FindBy(id = "ctl00_c_CtWNW_ddlFrom-suggest")
    private WebElement fromAirport;

    @FindBy(id = "ctl00_c_CtWNW_dvDepartDate")
    private WebElement departureDate;

    @FindBy(css = "#ctl00_c_CtWNW_flightClass_chosen a span")
    private WebElement flightClass;

    @FindBy(id = "ctl00_c_CtWNW_ddlTo-suggest")
    private WebElement toAirport;

    @FindBy(id = "ctl00_c_CtWNW_dvDepartDate")
    private WebElement departureDateSelect;

    @FindBy(css = "#ui-datepicker-div #calholder .ui-datepicker-group table tbody tr td a")
    private List<WebElement> departureDates;

    @FindBy(id = "chkFlexSearch")
    private WebElement flexibleFlight;

    public void clickOnOneWayRadioButton() {
        this.oneWayRadionButton.click();
    }

    public void enterFromAirport(String airport) {
        this.fromAirport.sendKeys(airport);
    }

    public void clickOnDepartureSelect() {
        this.departureDateSelect.click();
    }

    public void selectDepartureDate(String date) {
        this.departureDates.stream()
                .filter(el -> el.getText().contains(date))
                .findFirst().ifPresent(ele -> ele.click());
    }

    public void selectFlightClass(final WebDriver driver, String value) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].innerHTML = arguments[1]", this.flightClass, value);
    }

    public void enterToAirport(String airport) {
        this.toAirport.sendKeys(airport);
    }

    public void clickOnFlexibleFlightIfNeeded(boolean isChecked) {
        if (isChecked) {
            this.flexibleFlight.click();
        }
    }

    @Override
    public void searchWithCriteria(final WebDriver driver, Map<String, Object> criterias) {
        clickOnOneWayRadioButton();
        enterFromAirport(String.valueOf(criterias.get("fromAirport")));
        clickOnDepartureSelect();
        selectDepartureDate(String.valueOf(criterias.get("departureDate")));
        selectFlightClass(driver, String.valueOf(criterias.get("flightClass")));
        enterToAirport(String.valueOf(criterias.get("toAirport")));
        clickOnFlexibleFlightIfNeeded(Boolean.parseBoolean((String) criterias.get("flexibleFlight")));
    }
}
