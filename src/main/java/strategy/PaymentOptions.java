package strategy;

import java.util.Map;

public interface PaymentOptions {
    void enterPaymentInformation(Map<String, String> paymentDetails);
}
