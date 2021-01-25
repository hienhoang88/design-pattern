package executeAround;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.function.Consumer;

public class MainPage {
    private WebDriver driver;
    private FrameA frameA;
    private FrameB frameB;
    private FrameC frameC;

    public MainPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.frameA = PageFactory.initElements(driver, FrameA.class);
        this.frameB = PageFactory.initElements(driver, FrameB.class);
        this.frameC = PageFactory.initElements(driver, FrameC.class);
    }

    @FindBy(id="a")
    private WebElement firstFrame;

    @FindBy(id="b")
    private WebElement secondFrame;

    @FindBy(id="c")
    private WebElement lastFrame;

    public void goTo(){
        this.driver.get("https://vins-udemy.s3.amazonaws.com/ds/main.html");
    }

    public FrameA getFrameA(){
        this.driver.switchTo().defaultContent();
        this.driver.switchTo().frame(this.firstFrame);
        return this.frameA;
    }

    public FrameB getFrameB(){
        this.driver.switchTo().defaultContent();
        this.driver.switchTo().frame(this.secondFrame);
        return this.frameB;
    }

    public FrameC getFrameC(){
        this.driver.switchTo().defaultContent();
        this.driver.switchTo().frame(this.lastFrame);
        return this.frameC;
    }

    public void onFrameA(Consumer<FrameA> consumer){
        this.driver.switchTo().frame(firstFrame);
        consumer.accept(frameA);
        this.driver.switchTo().defaultContent();
    }

    public void onFrameB(Consumer<FrameB> consumer){
        this.driver.switchTo().frame(secondFrame);
        consumer.accept(frameB);
        this.driver.switchTo().defaultContent();
    }

    public void onFrameC(Consumer<FrameC> consumer){
        this.driver.switchTo().frame(lastFrame);
        consumer.accept(frameC);
        this.driver.switchTo().defaultContent();
    }
}
