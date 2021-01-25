package emirates;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import srp.common.AbstractComponent;

import java.util.Map;

public class PromoCode extends AbstractComponent {

    @FindBy(id = "ctl00_c_CtPrOffer_txtEnterCode")
    private WebElement promoCode;

    public PromoCode(WebDriver driver) {
        super(driver);
    }

    public void inputPromoCode(Map<String, Object> map) {
        if (Boolean.parseBoolean((String) map.get("isPromoted"))) {
            this.promoCode.sendKeys(String.valueOf(map.get("promoCode")));
        }
    }

    @Override
    public boolean isDisplayed() {
        return this.wait.until((d) -> this.promoCode.isDisplayed());
    }
}
