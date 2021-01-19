package emirates;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LandingScreen {

    private WebDriver driver;
    private WebDriverWait wait;

    public LandingScreen(final WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id="onetrust-accept-btn-handler")
    private WebElement acceptButton;

    @FindBy(linkText = "New search")
    private WebElement newSearchButton;

    public void goTo(){
        driver.get("https://fly10.emirates.com/CAB/InvalidProcess.aspx?mod=err&typ=nocookie&req=/CAB/IBE/SearchAvailability.aspx");
    }

    public void clickOnAcceptButtonIfPresent(){
        try{
            acceptButton.click();
        }catch (Exception e){
        }
    }

    public void clickOnNewSearch(){
        wait.until((d) -> this.newSearchButton.isDisplayed());
        newSearchButton.click();

    }

}
