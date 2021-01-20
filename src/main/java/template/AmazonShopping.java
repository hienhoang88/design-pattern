package template;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AmazonShopping extends ShoppingTemplate{

    private WebDriver driver;
    private WebDriverWait wait;
    private String product;

    public AmazonShopping(WebDriver driver, String product){
        this.driver = driver;
        this.product = product;
        this.wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id="twotabsearchtextbox")
    private WebElement searchBox;

    @FindBy(id="nav-search-submit-button")
    private WebElement searchBtn;

    @FindBy(css = "span.a-size-medium")
    private WebElement item;

    @Override
    public void launchSite() {
        this.driver.get("https://www.google.com");

    }

    @Override
    public void searchForProduct() {
        this.searchBox.sendKeys(this.product);
        this.searchBtn.click();
    }

    @Override
    public void selectProduct() {

    }

    @Override
    public void buy() {

    }
}
