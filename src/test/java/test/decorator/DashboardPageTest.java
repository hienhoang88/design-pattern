package test.decorator;

import decorator.DashboardPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import test.BaseTest;
import java.util.function.Consumer;

public class DashboardPageTest extends BaseTest {

    private DashboardPage dashboardPage;

    @BeforeTest
    public void setDashboardPage(){
        this.dashboardPage = new DashboardPage(driver);
    }

    @Test(dataProvider = "getData")
    public void roleTest(Consumer<DashboardPage> consumer){
        this.dashboardPage.goTo();
        consumer.accept(this.dashboardPage);
    }

    @DataProvider
    public Object[] getData(){
        return new Object[]{
                Decorators.guestPage,
                Decorators.superUserPage,
                Decorators.adminPage
        };
    }

}
