import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static javax.swing.JOptionPane.showMessageDialog;

//Use last week time card
public class UseLastWeekTimeCard {
    WebDriver driver;

    public UseLastWeekTimeCard(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "actionbutton")
    WebElement useLastWeek;

    public void clickUseLastWeek() {
        useLastWeek.click();
        showMessageDialog(null, "Used the last week template!");
    }
}
