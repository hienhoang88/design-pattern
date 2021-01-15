package srp.main;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import srp.common.SearchSuggestion;
import srp.common.SearchWidget;

public class GoogleMainPage {

    private WebDriver driver;
    private SearchWidget searchWidget;
    private SearchSuggestion searchSuggestion;

    public GoogleMainPage(WebDriver driver) {
        this.driver = driver;
        this.searchWidget = PageFactory.initElements(driver, SearchWidget.class);
        this.searchSuggestion = PageFactory.initElements(driver, SearchSuggestion.class);
    }

    public void goTo() {
        driver.get("https://www.google.com?hl=en");
    }

    public SearchWidget getSearchWidget() {
        return searchWidget;
    }

    public SearchSuggestion getSearchSuggestion() {
        return searchSuggestion;
    }

}
