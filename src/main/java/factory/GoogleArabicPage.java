package factory;

import org.openqa.selenium.WebDriver;

class GoogleArabicPage extends GoogleEnglishPage {

    public GoogleArabicPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void launchSite() {
        this.driver.get("https://www.google.com.sa");
        this.searchLanguage.clickOnLanguageWithIndex(1);
    }

    @Override
    public void search(String keyword) {
        this.searchLanguage.clickOnKeyboardButton();
        this.searchWidget.enter(keyword);
    }
}
