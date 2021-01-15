package test;

import com.google.common.util.concurrent.Uninterruptibles;
import driverFactory.DriverFactory;
import driverFactory.DriverType;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

public abstract class BaseFactoryTest {
    protected WebDriver driver;

    @BeforeTest
    public void setUp() {
        this.driver = DriverFactory.get(DriverType.CHROME);
        driver.manage().window().maximize();
    }

    @AfterTest
    public void tearDown() {
        Uninterruptibles.sleepUninterruptibly(5, TimeUnit.SECONDS);
        this.driver.quit();
    }
}
