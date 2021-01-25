package decoratorPayment.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PaymentScreen {
    private WebDriver driver;
    private PromoCode promoCode;
    private CreditCard creditCard;
    private Order order;

    public PaymentScreen(WebDriver driver){
        this.driver = driver;
        this.promoCode = PageFactory.initElements(driver, PromoCode.class);
        this.creditCard = PageFactory.initElements(driver, CreditCard.class);
        this.order = PageFactory.initElements(driver, Order.class);
    }

    public void goTo(){
        this.driver.get("https://vins-udemy.s3.amazonaws.com/java/html/java8-payment-screen.html");
    }

    public Order getOrder(){
        return this.order;
    }

    public PromoCode getPromoCode(){
        return this.promoCode;
    }

    public CreditCard getCreditCard(){
        return this.creditCard;
    }

}
