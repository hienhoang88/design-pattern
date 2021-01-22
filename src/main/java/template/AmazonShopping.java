package template;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import template.pages.amazon.AmazonProductDescriptionPage;
import template.pages.amazon.AmazonResultsPage;
import template.pages.amazon.AmazonSearchPage;

public class AmazonShopping extends ShoppingTemplate{

    private WebDriver driver;
    private String product;
    private AmazonSearchPage amazonSearchPage;
    private AmazonResultsPage amazonResultsPage;
    private AmazonProductDescriptionPage productDescriptionPage;

    public AmazonShopping(WebDriver driver, String product){
        this.driver = driver;
        this.product = product;
        this.amazonSearchPage = PageFactory.initElements(driver, AmazonSearchPage.class);
        this.amazonResultsPage = PageFactory.initElements(driver, AmazonResultsPage.class);
        this.productDescriptionPage = PageFactory.initElements(driver, AmazonProductDescriptionPage.class);
    }

    @Override
    public void launchSite() {
        this.amazonSearchPage.goTo();
    }

    @Override
    public void searchForProduct() {
        this.amazonSearchPage.searchForProduct(product);
    }

    @Override
    public void selectProduct() {
        this.amazonResultsPage.selectProduct();
    }

    @Override
    public void buy() {
        this.productDescriptionPage.buy();
    }
}
