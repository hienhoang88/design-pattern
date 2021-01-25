package strategy.paymentOptionFactory;

import strategy.CreditCardPayment;
import strategy.NetBankingPayment;
import strategy.PaymentOptions;
import strategy.PaypalPayment;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class PaymentOptionFactory {

    private static final Supplier<PaymentOptions> CC = () -> new CreditCardPayment();
    private static final Supplier<PaymentOptions> NB = () -> new NetBankingPayment();
    private static final Supplier<PaymentOptions> PP = () -> new PaypalPayment();

    private static final Map<String, Supplier<PaymentOptions>> MAP = new HashMap<>();

    static {
        MAP.put("CC", CC);
        MAP.put("NB", NB);
        MAP.put("PP", PP);
    }

    public static PaymentOptions get(String option) {
        return MAP.get(option).get();
    }

}
