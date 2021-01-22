package template.pages.ebay;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EbayResultsPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public EbayResultsPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css="div.s-item__info a")
    private WebElement item;

    public void selectProduct(){
        this.wait.until((d) -> this.item.isDisplayed());
        this.item.click();
    }
}
