package srp.result;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import srp.common.AbstractComponent;

import java.util.List;

public class ResultStat extends AbstractComponent {

    @FindBy(id = "result-stats")
    private WebElement stat;

    @FindBy(css = "#search div.g")
    private List<WebElement> results;

    public ResultStat(WebDriver driver) {
        super(driver);
    }

    public String getStat() {
        return this.stat.getText();
    }

    public int getResultCount() {
        this.wait.until((d) -> this.results.size() > 0);
        return this.results.size();
    }

    @Override
    public boolean isDisplayed() {
        return wait.until((d) -> this.stat.isDisplayed());
    }
}
