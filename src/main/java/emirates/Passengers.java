package emirates;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import srp.common.AbstractComponent;

import java.util.List;

public class Passengers extends AbstractComponent {

    public Passengers(WebDriver driver) {
        super(driver);
    }

    @FindBy(id="ctl00_c_CtNoOfTr_numberAdults_chosen")
    private WebElement adultsDropdown;

    @FindBy(css="div#ctl00_c_CtNoOfTr_numberAdults_chosen .chosen-drop ul.chosen-results li span")
    private List<WebElement> aldultsNumberList;

    @FindBy(id="ctl00_c_CtNoOfTr_numberChildren_chosen")
    private WebElement childrenDropdown;

    @FindBy(css="div#ctl00_c_CtNoOfTr_numberChildren_chosen .chosen-drop ul.chosen-results li span")
    private List<WebElement> childrenNumberList;

    @FindBy(id="ctl00_c_CtNoOfTr_numberinfants_chosen")
    private WebElement infantsDropdown;

    @FindBy(css="div#ctl00_c_CtNoOfTr_numberinfants_chosen .chosen-drop ul.chosen-results li span")
    private List<WebElement> infantsNumberList;

    public void clickOnAdultsDropdown(){
        this.adultsDropdown.click();
    }

    public void selectAdultsNumber(String number){
        this.wait.until((d) -> this.aldultsNumberList.size() > 1);
        this.aldultsNumberList.stream()
                .filter(el -> el.getText().equals(number))
                .findFirst().ifPresent(ele -> ele.click());
    }

    public void clickOnChildrenDropdown(){
        this.childrenDropdown.click();
    }

    public void selectChildrenNumber(String number){
        this.wait.until((d) -> this.childrenNumberList.size() > 1);
        this.childrenNumberList.stream()
                .filter(el -> el.getText().equals(number))
                .findFirst().ifPresent(ele -> ele.click());
    }

    public void clickOnInfantsDropdown(){
        this.infantsDropdown.click();
    }

    public void selectInfantsNumber(String number){
        this.wait.until((d) -> this.infantsNumberList.size() > 1);
        this.infantsNumberList.stream()
                .filter(el -> el.getText().equals(number))
                .findFirst().ifPresent(ele -> ele.click());
    }

    @Override
    public boolean isDisplayed() {
        return this.wait.until((d) -> this.adultsDropdown.isDisplayed());
    }
}
