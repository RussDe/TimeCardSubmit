import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//Navigate through menu
public class Navigation {
    WebDriver driver;

    public Navigation(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "Left1_SecuredHyperLink01")
    WebElement home;

    @FindBy(id = "Left1_SecuredHyperLink02")
    WebElement timeCards;

    //click on home menu item
    public void homeMenu() {
        home.click();
    }

    //click on time card menu
    public void timeCardsMenu() {
        timeCards.click();
    }
}
