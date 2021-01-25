package test.decoratorPayment;

import decoratorPayment.control.Decorators;
import decoratorPayment.pages.PaymentScreen;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import test.BaseTest;

import java.util.function.Consumer;

public class PaymentScreenTest extends BaseTest {

    private PaymentScreen paymentScreen;

    @BeforeTest
    public void setPaymentScreen(){
        this.paymentScreen = new PaymentScreen(driver);
    }

    @Test(dataProvider = "getData")
    public void paymentTest(Consumer<PaymentScreen> consumer){
        this.paymentScreen.goTo();
        consumer.accept(this.paymentScreen);
    }


    @DataProvider
    public Object[] getData(){
        return new Object[]{
                Decorators.FLOW_VALID_CC,
                Decorators.FLOW_DISCOUNT_WITH_VALID_CC,
                Decorators.FLOW_FREE_DISCOUNT,
                Decorators.FLOW_DISCOUNT_WITH_INVALID_CC,
                Decorators.FLOW_INVALID_CC,
                Decorators.FLOW_WITHOUT_CC
        };
    }


}
