package proxy.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.Map;

public class NetBankingPayment implements PaymentOptions {

    @FindBy(id = "bank")
    private WebElement bank;

    @FindBy(id = "acc_number")
    private WebElement acc_number;

    @FindBy(id = "pin")
    private WebElement pin;


    public void selectBank(String bank) {
        Select bankDropdown = new Select(this.bank);
        bankDropdown.selectByVisibleText(bank);
    }

    public void enterAccountNumber(String number) {
        this.acc_number.sendKeys(number);
    }

    public void enterPin(String pin) {
        this.pin.sendKeys(pin);
    }

    @Override
    public void enterPaymentInformation(Map<String, String> paymentDetails) {
        selectBank(paymentDetails.get("bank"));
        enterAccountNumber(paymentDetails.get("acc_number"));
        enterPin(paymentDetails.get("pin"));
    }
}
