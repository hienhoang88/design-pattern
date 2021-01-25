package decoratorPayment.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import srp.common.AbstractComponent;

public class CreditCard extends AbstractComponent {

    public CreditCard(WebDriver driver) {
        super(driver);
    }

    @FindBy(id="cc")
    private WebElement cardNumber;

    @FindBy(id="year")
    private WebElement year;

    @FindBy(id="cvv")
    private WebElement cvv;

    public void enterCardNumber(String cardNumber){
        this.cardNumber.sendKeys(cardNumber);
    }

    public void enterYear(String year){
        this.year.sendKeys(year);
    }

    public void enterCVV(String cvv){
        this.cvv.sendKeys(cvv);
    }

    public void enterCardDetails(String cardNumber, String year, String cvv){
        enterCardNumber(cardNumber);
        enterYear(year);
        enterCVV(cvv);
    }


    @Override
    public boolean isDisplayed() {
        return this.wait.until((d) -> this.cardNumber.isDisplayed());
    }
}
