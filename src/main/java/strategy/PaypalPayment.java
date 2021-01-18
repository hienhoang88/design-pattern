package strategy;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Map;

public class PaypalPayment implements PaymentOptions{

    @FindBy(id="paypal_username")
    private WebElement userName;

    @FindBy(id="paypal_password")
    private WebElement password;

    public void enterPaypalUsername(String userName){
        this.userName.sendKeys(userName);
    }

    public void enterPaypalPassword(String password){
        this.password.sendKeys(password);
    }

    @Override
    public void enterPaymentInformation(Map<String, String> paymentDetails) {
        enterPaypalUsername(paymentDetails.get("username"));
        enterPaypalPassword(paymentDetails.get("password"));
    }
}
