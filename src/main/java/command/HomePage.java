package command;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Arrays;
import java.util.List;

public class HomePage {

    private WebDriver driver;
    private WebDriverWait wait;

    public HomePage(final WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css=".button-box .btn-info")
    private WebElement infoBtn;

    @FindBy(css=".button-box .btn-warning")
    private WebElement warnBtn;

    @FindBy(css=".button-box .btn-success")
    private WebElement successBtn;

    @FindBy(css=".button-box .btn-danger")
    private WebElement dangerBtn;

    @FindBy(css=".jq-toast-wrap .jq-icon-info")
    private WebElement infoAlert;

    @FindBy(css=".jq-toast-wrap .jq-icon-warning")
    private WebElement warnAlert;

    @FindBy(css=".jq-toast-wrap .jq-icon-success")
    private WebElement successAlert;

    @FindBy(css=".jq-toast-wrap .jq-icon-error")
    private WebElement dangerAlert;

    //dismissal alert
    @FindBy(css = "#main-wrapper > div > div > div:nth-child(3) > div > div > div > div > div:nth-child(2) > div.alert-info")
    private WebElement dismissInfoAlert;

    @FindBy(css = "#main-wrapper > div > div > div:nth-child(3) > div > div > div > div > div:nth-child(2) > div.alert-success")
    private WebElement dismissSuccessAlert;

    @FindBy(css = "#main-wrapper > div > div > div:nth-child(3) > div > div > div > div > div:nth-child(2) > div.alert-danger")
    private WebElement dismissDangerAlert;

    @FindBy(css = "#main-wrapper > div > div > div:nth-child(3) > div > div > div > div > div:nth-child(2) > div.alert-warning")
    private WebElement dismissWarnAlert;

    public void goTo(){
        this.driver.get("https://wrappixel.com/demos/admin-templates/admin-pro/main/ui-notification.html");
        this.wait.until((d) -> this.infoBtn.isDisplayed());
    }

    public List<ElementValidator> getElementValidator(){
        return Arrays.asList(
                //notification
                new NotificationValidator(infoBtn, infoAlert),
                new NotificationValidator(successBtn, successAlert),
                new NotificationValidator(warnBtn, warnAlert),
                new NotificationValidator(dangerBtn, dangerAlert),

                //dismiss alert
                new DismissalAlertValidator(dismissInfoAlert),
                new DismissalAlertValidator(dismissWarnAlert),
                new DismissalAlertValidator(dismissDangerAlert),
                new DismissalAlertValidator(dismissSuccessAlert)
        );
    }
}
