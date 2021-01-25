package decoratorPayment.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import srp.common.AbstractComponent;

public class Order extends AbstractComponent {
    public Order(WebDriver driver) {
        super(driver);
    }

    @FindBy(id="buy")
    private WebElement buyButton;

    @FindBy(id="status")
    private WebElement status;

    public void clickOnBuyButton(){
        this.buyButton.click();
    }

    public String getStatus(){
        return this.status.getText();
    }

    @Override
    public boolean isDisplayed() {
        return this.wait.until((d) -> this.buyButton.isDisplayed());
    }
}
