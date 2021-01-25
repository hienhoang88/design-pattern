package emirates.searchOption;

import org.openqa.selenium.WebDriver;
import java.util.Map;

public interface SearchOption {
    public abstract void searchWithCriteria(WebDriver driver, Map<String, Object> criterias);
}
