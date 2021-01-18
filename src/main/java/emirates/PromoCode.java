package emirates;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import srp.common.AbstractComponent;

public class PromoCode extends AbstractComponent {

    public PromoCode(WebDriver driver) {
        super(driver);
    }

    @FindBy(id="ctl00_c_CtPrOffer_txtEnterCode")
    private WebElement promoCode;

    public void inputPromoCode(String code){
        this.promoCode.sendKeys(code);
    }

    @Override
    public boolean isDisplayed() {
        return this.wait.until((d) -> this.promoCode.isDisplayed());
    }
}
