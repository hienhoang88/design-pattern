package test.strategy;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.collections.Maps;
import paymentOptionFactory.PaymentOptionFactory;
import strategy.*;
import test.BaseTest;

import java.util.Map;

public class PaymentScreenTest extends BaseTest {

    private PaymentScreen paymentScreen;

    @BeforeTest
    public void setPaymentScreen() {
        this.paymentScreen = new PaymentScreen(driver);
    }

    @Test(dataProvider = "getData")
    public void paymentTest(String option, Map<String, String> paymentDetails) {
        this.paymentScreen.goTo();
        this.paymentScreen.getUserInformation().enterDetails("Hien", "Hoang",
                "hienhoangminh290788@gmail.com");
        this.paymentScreen.setPaymentOptions(PaymentOptionFactory.get(option));
        this.paymentScreen.pay(paymentDetails);
        this.paymentScreen.getCheckout().placeOrder();
        System.out.println(this.paymentScreen.getCheckout().getOrderNumber());
    }

    @DataProvider
    public Object[][] getData() {

        Map<String, String> cc = Maps.newHashMap();
        cc.put("cc", "4242424242424242");
        cc.put("year", "2003");
        cc.put("cvv", "237");

        Map<String, String> nb = Maps.newHashMap();
        nb.put("bank", "BOFA");
        nb.put("acc_number", "4003830171874018");
        nb.put("pin", "2485");

        Map<String, String> pp = Maps.newHashMap();
        pp.put("username", "hhoang88");
        pp.put("password", "1Xr5BCzd92");

        return new Object[][]{
                {"CC", cc},
                {"NB", nb},
                {"PP", pp}
        };
    }
}
