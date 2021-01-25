package proxy.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import proxy.control.OrderComponent;
import proxy.control.OrderComponentProxy;

import java.util.Map;

public class PaymentScreen {

    private WebDriver driver;
    private UserInformation userInformation;
    private OrderComponent orderComponent;
    private PaymentOptions paymentOptions;

    public PaymentScreen(WebDriver driver) {
        this.driver = driver;
        this.userInformation = PageFactory.initElements(driver, UserInformation.class);
        this.orderComponent = new OrderComponentProxy(driver);
    }

    public void goTo() {
        driver.get("https://vins-udemy.s3.amazonaws.com/ds/strategy.html");
    }


    public UserInformation getUserInformation() {
        return this.userInformation;
    }

    public OrderComponent getCheckout() {
        return this.orderComponent;
    }

    public PaymentOptions getPaymentOptions() {
        return paymentOptions;
    }

    public void setPaymentOptions(PaymentOptions paymentOptions) {
        this.paymentOptions = paymentOptions;
        PageFactory.initElements(driver, this.paymentOptions);
    }

    public void pay(Map<String, String> paymentDetails) {
        this.paymentOptions.enterPaymentInformation(paymentDetails);
    }
}
