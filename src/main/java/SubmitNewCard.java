import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import sun.jvm.hotspot.debugger.Page;

import java.util.Date;
import java.util.List;

//submit new time card
public class SubmitNewCard {
    WebDriver driver;

    public SubmitNewCard(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    By weekEndindDateID = By.id("WeekEnding1");


    public boolean selectDate(String dateToSubmit) {
        boolean flag = false;
        List<WebElement> allOptions = driver.findElements(weekEndindDateID);
        for (WebElement el : allOptions) {
            if (el.getText().contains(dateToSubmit))
                flag = true;
        }
        if (flag) {
            Select selectDateID = new Select(driver.findElement(weekEndindDateID));
            selectDateID.selectByValue(String.valueOf(dateToSubmit));
        }
        return flag;
    }
}
