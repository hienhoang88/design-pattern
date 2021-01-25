package template.pages.ebay;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EbaySearchPage {

    private WebDriver driver;

    public EbaySearchPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id="gh-ac")
    private WebElement searchBox;

    @FindBy(id="gh-btn")
    private WebElement searchBtn;

    public void goTo(){
        this.driver.get("https://www.ebay.com/");
    }

    public void searchProduct(String product){
        this.searchBox.sendKeys(product);
        this.searchBtn.click();
    }
}
