package decoratorPayment.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import srp.common.AbstractComponent;

public class PromoCode extends AbstractComponent {

    public PromoCode(WebDriver driver) {
        super(driver);
    }

    @FindBy(id="coupon")
    private WebElement couponField;

    @FindBy(id="couponbtn")
    private WebElement applyButton;

    @FindBy(id="price")
    private WebElement price;

    public void enterCouponCode(String code){
        this.couponField.sendKeys(code);
    }

    public void clickApplyButton(){
        this.applyButton.click();
    }

    public String getPrice(){
        return this.price.getText();
    }


    @Override
    public boolean isDisplayed() {
        return this.wait.until((d) -> this.couponField.isDisplayed());
    }
}
