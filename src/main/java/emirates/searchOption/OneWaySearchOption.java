package emirates.searchOption;

import com.google.common.util.concurrent.Uninterruptibles;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class OneWaySearchOption implements SearchOption{

    @FindBy(id="ctl00_c_CtWNW_ltOneway")
    private WebElement oneWayRadionButton;

    @FindBy(id="ctl00_c_CtWNW_ddlFrom-suggest")
    private WebElement fromAirport;

    @FindBy(id="ctl00_c_CtWNW_dvDepartDate")
    private WebElement departureDate;

    @FindBy(id="ctl00_c_CtWNW_flightClass")
    private WebElement flightClass;

    @FindBy(id="ctl00_c_CtWNW_ddlTo-suggest")
    private WebElement toAirport;

    @FindBy(id="ctl00_c_CtWNW_dvDepartDate")
    private WebElement departureDateSelect;

    @FindBy(css="#ui-datepicker-div #calholder .ui-datepicker-group table tbody tr td a")
    private List<WebElement> departureDates;

    @FindBy(id="chkFlexSearch")
    private WebElement flexibleFlight;

    public void clickOnOneWayRadioButton(){
        this.oneWayRadionButton.click();
    }

    public void enterFromAirport(String airport){
        for(char ch: airport.toCharArray()) {
            this.fromAirport.sendKeys(ch + "");
            Uninterruptibles.sleepUninterruptibly(50, TimeUnit.MILLISECONDS);
        }
        this.fromAirport.sendKeys(Keys.ENTER);
    }

    public void clickOnDepartureSelect(){
        this.departureDateSelect.click();
    }

    public void selectDepartureDate(String date){
        this.departureDates.stream()
                .filter(el -> el.getText().contains(date))
                .findFirst().ifPresent(ele -> ele.click());
    }

    public void selectFlightClass(String value){
        Select flightClass = new Select(this.flightClass);
        flightClass.selectByVisibleText(value);
    }

    public void enterToAirport(String airport){
        for(char ch: airport.toCharArray()) {
            this.toAirport.sendKeys(ch + "");
            Uninterruptibles.sleepUninterruptibly(50, TimeUnit.MILLISECONDS);
        }
        this.toAirport.sendKeys(Keys.ENTER);
    }

    public void clickOnFlexibleFlightIfNeeded(boolean isChecked){
        if(isChecked){
            this.flexibleFlight.click();
        }
    }

    @Override
    public void searchWithCriteria(Map<String, Object> criterias) {
        clickOnOneWayRadioButton();
        enterFromAirport(String.valueOf(criterias.get("fromAirport")));
        clickOnDepartureSelect();
        selectDepartureDate(String.valueOf(criterias.get("departureDate")));
//        selectFlightClass(String.valueOf(criterias.get("flightClass")));
        enterToAirport(String.valueOf(criterias.get("toAirport")));
        clickOnFlexibleFlightIfNeeded(Boolean.parseBoolean((String) criterias.get("flexibleFlight")));
    }
}
