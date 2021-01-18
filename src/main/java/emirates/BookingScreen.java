package emirates;

import org.openqa.selenium.WebDriver;

public class BookingScreen {
    private WebDriver driver;


    public BookingScreen(final WebDriver driver){
        this.driver = driver;
    }

    public void goTo(){
        this.driver.get("https://fly10.emirates.com/CAB/IBE/SearchAvailability.aspx");
    }
}
