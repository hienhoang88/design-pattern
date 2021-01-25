package decorator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DashboardPage {
    private WebDriver driver;

    @FindBy(id="role")
    private WebElement roles;

    @FindBy(css="div.guest")
    private List<WebElement> guestComponent;

    @FindBy(css="div.superuser")
    private List<WebElement> superUserComponent;

    @FindBy(css="div.admin")
    private List<WebElement> adminComponent;

    public DashboardPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void goTo(){
        this.driver.get("https://vins-udemy.s3.amazonaws.com/ds/decorator.html");
    }

    public void selectRole(String role){
        Select select = new Select(this.roles);
        select.selectByVisibleText(role);
    }

    public List<WebElement> getGuestComponent(){
        return this.guestComponent;
    }

    public List<WebElement> getSuperUserComponent(){
        return this.superUserComponent;
    }

    public List<WebElement> getAdminComponent(){
        return this.adminComponent;
    }
}
