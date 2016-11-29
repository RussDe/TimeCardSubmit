import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

//check the last time card submitted
public class TimeCardsLast {
    WebDriver driver;

    public TimeCardsLast(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "tblTimeCard")
    WebElement table;

    By tr = By.tagName("tr");
    By td = By.tagName("td");

    public String findLastTimeCard() {
        List dates = new ArrayList();
        List<WebElement> rows = table.findElements(tr);
        for (WebElement row : rows) {
            List<WebElement> tds = row.findElements(td);
            for (WebElement td : tds) {
                if (td.getText().contains("/")) {
                    dates.add(td.getText());
                }
            }
        }
        return String.valueOf(dates.get(0));
    }

    public boolean lastTimeCardSubmittedSuccessful(String dateToBeSubmitted, String textToBeFound) {
        boolean dateFound = false;
        boolean textSubmitted = false;
        List<WebElement> trs = table.findElements(tr);
        List<WebElement> tds = trs.get(1).findElements(td);
        for (WebElement td : tds) {
            if (td.getText().contains(dateToBeSubmitted))
                dateFound = true;
            if (td.getText().contains("Final Manager Approved"))
                textSubmitted = true;
        }
        if (dateFound & textSubmitted)
            return true;
        else return false;

    }
}