package emirates.searchOption;

import com.google.common.util.concurrent.Uninterruptibles;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class ReturnSearchOption implements SearchOption {

    @FindBy(id="ctl00_c_CtWNW_ltReturn")
    private WebElement returnRadioButton;

    @FindBy(id="ctl00_c_CtWNW_ddlFrom-suggest")
    private WebElement fromAirport;

    @FindBy(id="ctl00_c_CtWNW_dvDepartDate")
    private WebElement departureDateSelect;

    @FindBy(css="#ui-datepicker-div #calholder .ui-datepicker-group table tbody tr td a")
    private List<WebElement> dates;

    @FindBy(id="ctl00_c_CtWNW_flightClass_chosen")
    private WebElement departureSeatClass;

    @FindBy(id="ctl00_c_CtWNW_ddlTo-suggest")
    private WebElement toAirport;

    @FindBy(id="dvReturnDate")
    private WebElement returnDateSelect;

    @FindBy(id="ctl00_c_CtWNW_flightClass1_chosen")
    private WebElement arrivalSeatClass;

    @FindBy(id="flexDateLabel")
    private WebElement flexibleFlight;

    public void enterFromAirport(String airport){
        for(char ch: airport.toCharArray()) {
            this.fromAirport.sendKeys(ch + "");
            Uninterruptibles.sleepUninterruptibly(50, TimeUnit.MILLISECONDS);
        }
        this.fromAirport.sendKeys(Keys.ENTER);
    }

    public void clickOnDepartureDate(){
        this.departureDateSelect.click();
    }

    public void selectDate(String date){
        this.dates.stream()
                .filter(el -> el.getText().contains(date))
                .findFirst().ifPresent(ele -> ele.click());
    }

    public void enterToAirport(String toAirport){
        for(char ch: toAirport.toCharArray()) {
            this.toAirport.sendKeys(ch + "");
            Uninterruptibles.sleepUninterruptibly(50, TimeUnit.MILLISECONDS);
        }
        this.toAirport.sendKeys(Keys.ENTER);
    }

    public void clickOnArrivalDate(){
        this.returnDateSelect.click();
    }

    public void clickOnFlexibleFlightIfNeeded(boolean isChecked){
        if(isChecked){
            this.flexibleFlight.click();
        }
    }

    @Override
    public void searchWithCriteria(Map<String, Object> criterias) {
        enterFromAirport(String.valueOf(criterias.get("fromAirport")));
        clickOnDepartureDate();
        selectDate(String.valueOf(criterias.get("departureDate")));
        enterToAirport(String.valueOf(criterias.get("toAirport")));
        clickOnArrivalDate();
        selectDate(String.valueOf(criterias.get("arrivalDate")));
        clickOnFlexibleFlightIfNeeded(Boolean.parseBoolean((String) criterias.get("flexibleFlight")));

    }
}
