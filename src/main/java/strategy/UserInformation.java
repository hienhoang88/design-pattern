package strategy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserInformation {

    @FindBy(id = "fn")
    private WebElement firstName;

    @FindBy(id = "ln")
    private WebElement lastName;

    @FindBy(id = "email")
    private WebElement email;

    public UserInformation(final WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void enterFirstName(String firstName) {
        this.firstName.sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        this.lastName.sendKeys(lastName);
    }

    public void enterEmail(String email) {
        this.email.sendKeys(email);
    }

    public void enterDetails(String firstName, String lastName, String email) {
        enterFirstName(firstName);
        enterLastName(lastName);
        enterEmail(email);
    }
}
