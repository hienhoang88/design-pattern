package template;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import template.pages.ebay.EbayProductDescription;
import template.pages.ebay.EbayResultsPage;
import template.pages.ebay.EbaySearchPage;

public class EbayShopping extends ShoppingTemplate{

    private WebDriver driver;
    private String product;
    private EbaySearchPage ebaySearchPage;
    private EbayResultsPage ebayResultsPage;
    private EbayProductDescription ebayProductDescription;

    public EbayShopping(WebDriver driver, String product){
        this.driver = driver;
        this.product = product;
        this.ebaySearchPage = PageFactory.initElements(driver, EbaySearchPage.class);
        this.ebayResultsPage = PageFactory.initElements(driver, EbayResultsPage.class);
        this.ebayProductDescription = PageFactory.initElements(driver, EbayProductDescription.class);
    }

    @Override
    public void launchSite() {
        this.ebaySearchPage.goTo();
    }

    @Override
    public void searchForProduct() {
        this.ebaySearchPage.searchProduct(product);

    }

    @Override
    public void selectProduct() {
        this.ebayResultsPage.selectProduct();
    }

    @Override
    public void buy() {
        this.ebayProductDescription.buy();
    }
}
