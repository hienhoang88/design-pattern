package proxy.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Map;

public class CreditCardPayment implements PaymentOptions {

    @FindBy(id = "cc")
    private WebElement cardNumber;

    @FindBy(id = "year")
    private WebElement year;

    @FindBy(id = "cvv")
    private WebElement cvv;

    public void enterCardNumber(String cc) {
        this.cardNumber.sendKeys(cc);
    }

    public void enterYear(String year) {
        this.year.sendKeys(year);
    }

    public void enterCVV(String cvv) {
        this.cvv.sendKeys(cvv);
    }


    @Override
    public void enterPaymentInformation(Map<String, String> paymentDetails) {
        enterCardNumber(paymentDetails.get("cc"));
        enterYear(paymentDetails.get("year"));
        enterCVV(paymentDetails.get("cvv"));
    }
}
