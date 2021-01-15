package srp.common;

import com.google.common.util.concurrent.Uninterruptibles;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

public class SearchWidget extends AbstractComponent {

    @FindBy(name = "q")
    private WebElement searchBox;

    @FindBy(name = "btnK")
    private WebElement searchButton;

    public SearchWidget(WebDriver driver) {
        super(driver);
    }

    public void enter(String keyword) {
        this.searchBox.clear();
        for (char ch : keyword.toCharArray()) {
            Uninterruptibles.sleepUninterruptibly(10, TimeUnit.MICROSECONDS);
            this.searchBox.sendKeys(ch + "");
        }
    }

    public void clickOnSearchButton() {
        this.wait.until((d) -> this.searchButton.isDisplayed());
        this.searchButton.click();
    }

    @Override
    public boolean isDisplayed() {
        return wait.until((d) -> this.searchBox.isDisplayed());
    }
}
