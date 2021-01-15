package test.factory;

import factory.GoogleFactory;
import factory.GooglePage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import test.BaseFactoryTest;

public class ChromeFactoryTest extends BaseFactoryTest {

    private GooglePage googlePage;

    @Test(dataProvider = "getData")
    public void factoryTest(String language, String keyword) {
        googlePage = GoogleFactory.get(language, driver);
        googlePage.launchSite();
        googlePage.search(keyword);
        googlePage.clickSearchButton();
        System.out.println(googlePage.getTotalResult());
    }

    @DataProvider
    public Object[][] getData() {
        return new Object[][]{
                {"EN", "selenium"},
                {"FR", "docker"},
                {"AR", "design pattern"},
                {"ES", "jenkins"}
        };
    }
}
