package test.executeAround;

import executeAround.MainPage;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import test.BaseTest;

public class FrameTest extends BaseTest {

    private MainPage mainPage;

    @BeforeTest
    public void setMainPage() {
        this.mainPage = new MainPage(driver);
    }

    @Test
    public void frameTest() {
        this.mainPage.goTo();
        this.mainPage.onFrameA((a) -> {
            a.enterFirstName("fn1");
            a.enterLastName("ln1");
            a.enterAddress("address 1");
            a.enterMessage("message 1");
        });
        this.mainPage.onFrameC((c) -> c.enterFirstName("fn3"));
        this.mainPage.onFrameB((b) -> {
            b.enterFirstName("fn2");
            b.enterLastName("ln2");
            b.enterAddress("address 2");
            b.enterMessage("message 2");
        }
        );

    }
}
