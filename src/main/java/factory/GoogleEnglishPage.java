package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import srp.common.SearchLanguage;
import srp.common.SearchWidget;
import srp.result.ResultStat;

class GoogleEnglishPage extends GooglePage {

    protected WebDriver driver;
    protected SearchWidget searchWidget;
    protected ResultStat resultStat;
    protected SearchLanguage searchLanguage;

    public GoogleEnglishPage(final WebDriver driver) {
        this.driver = driver;
        this.searchWidget = PageFactory.initElements(driver, SearchWidget.class);
        this.resultStat = PageFactory.initElements(driver, ResultStat.class);
        this.searchLanguage = PageFactory.initElements(driver, SearchLanguage.class);
    }

    @Override
    public void launchSite() {
        this.driver.get("https://www.google.com");
    }

    @Override
    public void search(String keyword) {
        this.searchWidget.enter(keyword);
    }

    @Override
    public void clickSearchButton() {
        this.searchWidget.clickOnSearchButton();
    }

    @Override
    public int getResultCount() {
        return this.resultStat.getResultCount();
    }

    @Override
    public String getTotalResult() {
        return this.resultStat.getStat();
    }
}
