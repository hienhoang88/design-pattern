package decoratorPayment.control;

import decoratorPayment.pages.PaymentScreen;
import org.testng.Assert;
import java.util.function.Consumer;

public class Decorators {

    public static final Consumer<PaymentScreen> ENTER_FREE_DISCOUNT = (p) -> {
        p.getPromoCode().enterCouponCode("FREEUDEMY");
        p.getPromoCode().clickApplyButton();
    };

    public static final Consumer<PaymentScreen> ENTER_PARTIAL_DISCOUNT = (p) -> {
        p.getPromoCode().enterCouponCode("PARTIALUDEMY");
        p.getPromoCode().clickApplyButton();

    };

    public static final Consumer<PaymentScreen> ENTER_VALID_CC = (p) -> {
        p.getCreditCard().enterCardNumber("4111111111111111");
        p.getCreditCard().enterYear("2023");
        p.getCreditCard().enterCVV("123");
    };

    public static final Consumer<PaymentScreen> ENTER_INVALID_CC = (p) -> {
        p.getCreditCard().enterCardNumber("41000000000000000");
        p.getCreditCard().enterYear("2020");
        p.getCreditCard().enterCVV("111");
    };

    public static final Consumer<PaymentScreen> BUY = (p) -> {
        p.getOrder().clickOnBuyButton();
    };

    public static final Consumer<PaymentScreen> IS_PASSED = (p) -> {
        Assert.assertTrue(p.getOrder().getStatus().equals("PASS"));
    };

    public static final Consumer<PaymentScreen> IS_FAILED = (p) -> {
        Assert.assertTrue(p.getOrder().getStatus().equals("FAIL"));
    };

    public static final Consumer<PaymentScreen> FLOW_VALID_CC = ENTER_VALID_CC.andThen(BUY).andThen(IS_PASSED);
    public static final Consumer<PaymentScreen> FLOW_DISCOUNT_WITH_VALID_CC = ENTER_PARTIAL_DISCOUNT.andThen(ENTER_VALID_CC).andThen(BUY).andThen(IS_PASSED);
    public static final Consumer<PaymentScreen> FLOW_FREE_DISCOUNT = ENTER_FREE_DISCOUNT.andThen(BUY).andThen(IS_PASSED);
    public static final Consumer<PaymentScreen> FLOW_DISCOUNT_WITH_INVALID_CC = ENTER_PARTIAL_DISCOUNT.andThen(ENTER_INVALID_CC).andThen(BUY).andThen(IS_FAILED);
    public static final Consumer<PaymentScreen> FLOW_INVALID_CC = ENTER_INVALID_CC.andThen(BUY).andThen(IS_FAILED);
    public static final Consumer<PaymentScreen> FLOW_WITHOUT_CC = BUY.andThen(IS_FAILED);


}
