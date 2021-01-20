package driverFactory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class DriverFactory {

    private static final Map<DriverType, Supplier<WebDriver>> MAP = new HashMap<>();

    private static final Supplier<WebDriver> CHROME = () -> {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    };

    private static final Supplier<WebDriver> FIREFOX = () -> {
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    };

    static {
        MAP.put(DriverType.CHROME, CHROME);
        MAP.put(DriverType.FIREFOX, FIREFOX);
    }

    public static final WebDriver get(DriverType type) {
        return MAP.get(type).get();
    }
}
