package factory;

import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class GoogleFactory {

    private static final Function<WebDriver, GooglePage> EN = (d) -> new GoogleEnglishPage(d);
    private static final Function<WebDriver, GooglePage> FR = (d) -> new GoogleFrenchPage(d);
    private static final Function<WebDriver, GooglePage> AR = (d) -> new GoogleArabicPage(d);
    private static final Function<WebDriver, GooglePage> ES = (d) -> new GoogleSpanishPage(d);
    private static final Map<String, Function<WebDriver, GooglePage>> MAP = new HashMap<>();

    static {
        MAP.put("EN", EN);
        MAP.put("FR", FR);
        MAP.put("AR", AR);
        MAP.put("ES", ES);
    }

    public static GooglePage get(String language, WebDriver driver) {
        return MAP.get(language).apply(driver);
    }
}
