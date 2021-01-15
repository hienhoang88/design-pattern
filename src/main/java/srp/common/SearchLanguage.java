package srp.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchLanguage extends AbstractComponent {

    @FindBy(id = "gws-output-pages-elements-homepage_additional_languages__als")
    private WebElement languageBar;
    @FindBy(css = "#SIvCob > a")
    private List<WebElement> languages;
    @FindBy(css = "span.hOoLGe")
    private WebElement keyboardBtn;
    @FindBy(id = "kbd")
    private WebElement keyboard;

    public SearchLanguage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isDisplayed() {
        return wait.until((d) -> languageBar.isDisplayed());
    }

    public void clickOnLanguageWithIndex(int index) {
        this.languages.get(index - 1).click();
    }

    public void clickOnKeyboardButton() {
        this.wait.until((d) -> this.keyboardBtn.isDisplayed());
        this.keyboardBtn.click();
        this.wait.until((d) -> this.keyboard.isDisplayed());
    }
}
