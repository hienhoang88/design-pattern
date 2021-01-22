package test.template;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import template.AmazonShopping;
import template.EbayShopping;
import template.ShoppingTemplate;
import test.BaseTest;

public class ShoppingTest extends BaseTest {

    @Test(dataProvider = "getData")
    private void shoppingTest(ShoppingTemplate shoppingTemplate){
        shoppingTemplate.shop();
    }

    @DataProvider
    public Object[] getData(){
        return new Object[]{
                new AmazonShopping(driver, "samsung"),
                new EbayShopping(driver, "iphone")
        };
    }
}
