package factory;

import org.openqa.selenium.WebDriver;

class GoogleFrenchPage extends GoogleEnglishPage {

    public GoogleFrenchPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void launchSite() {
        this.driver.get("https://www.google.fr");
        this.searchLanguage.clickOnLanguageWithIndex(1);
    }
}
