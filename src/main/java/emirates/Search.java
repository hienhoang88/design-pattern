package emirates;

import org.openqa.selenium.WebDriver;
import srp.common.AbstractComponent;

public class Search extends AbstractComponent {

    public Search(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isDisplayed() {
        return false;
    }
}
