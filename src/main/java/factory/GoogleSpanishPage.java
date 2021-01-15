package factory;

import org.openqa.selenium.WebDriver;

class GoogleSpanishPage extends GoogleEnglishPage {

    public GoogleSpanishPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void launchSite() {
        this.driver.get("https://www.google.es");
        this.searchLanguage.clickOnLanguageWithIndex(1);
    }
}
