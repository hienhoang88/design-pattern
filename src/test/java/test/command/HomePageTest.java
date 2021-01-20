package test.command;

import command.ElementValidator;
import command.HomePage;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import test.BaseTest;

public class HomePageTest extends BaseTest {

    private HomePage homePage;

    @BeforeTest
    public void setHomePage(){
        this.homePage = new HomePage(driver);
    }

    @Test
    public void goTo(){
        this.homePage.goTo();
    }

    @Test(dataProvider = "getData", dependsOnMethods = "goTo")
    public void homePageTest(ElementValidator elementValidator){
        Assert.assertTrue(elementValidator.validate());
    }

    @DataProvider
    public Object[] getData(){
        return this.homePage.getElementValidator()
                .toArray();
    }
}
