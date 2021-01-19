package test;

import com.google.common.util.concurrent.Uninterruptibles;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

public abstract class BaseTest {

    protected WebDriver driver;

    @BeforeTest
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        this.driver = new ChromeDriver();
    }

    @AfterTest
    public void tearDown() {
        Uninterruptibles.sleepUninterruptibly(5, TimeUnit.SECONDS);
        this.driver.quit();
    }

}
