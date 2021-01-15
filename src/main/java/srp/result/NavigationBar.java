package srp.result;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import srp.common.AbstractComponent;

public class NavigationBar extends AbstractComponent {

    @FindBy(id = "hdtb")
    private WebElement navigationBar;
    @FindBy(linkText = "Videos")
    private WebElement videos;
    @FindBy(linkText = "News")
    private WebElement news;

    public NavigationBar(WebDriver driver) {
        super(driver);
    }

    public void goToVideos() {
        this.videos.click();
    }

    public void goToNews() {
        this.news.click();
    }

    @Override
    public boolean isDisplayed() {
        return wait.until((d) -> this.navigationBar.isDisplayed());
    }
}
