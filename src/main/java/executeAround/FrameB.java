package executeAround;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FrameB {

    @FindBy(css="input[name='fn']")
    private WebElement firstName;

    @FindBy(css="input[name='ln']")
    private WebElement lastName;

    @FindBy(css="input[name='addr']")
    private WebElement address;

    @FindBy(id="area")
    private WebElement textArea;

    public void enterFirstName(String firstName){
        this.firstName.sendKeys(firstName);
    }

    public void enterLastName(String lastName){
        this.lastName.sendKeys(lastName);
    }

    public void enterAddress(String address){
        this.address.sendKeys(address);
    }

    public void enterMessage(String message){
        this.textArea.sendKeys(message);
    }
}
