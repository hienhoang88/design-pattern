package strategy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Checkout {

    @FindBy(id="buy")
    private WebElement buyNow;

    @FindBy(id="ordernumber")
    private WebElement orderNumber;

    public Checkout(final WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    public void placeOrder(){
        this.buyNow.click();
    }

    public String getOrderNumber(){
        return this.orderNumber.getText();
    }
}
