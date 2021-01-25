package emirates;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import srp.common.AbstractComponent;

public class Search extends AbstractComponent {

    @FindBy(css = "div#ctl00_c_pnlFF a")
    private WebElement searchBtn;

    public Search(WebDriver driver) {
        super(driver);
    }

    public void clickOnSearchButton() {
        this.searchBtn.click();
    }

    @Override
    public boolean isDisplayed() {
        return this.wait.until((d) -> this.searchBtn.isDisplayed());
    }
}
