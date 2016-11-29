import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static javax.swing.JOptionPane.showMessageDialog;

//submit card if 40 hours
public class SubmitCard {
    WebDriver driver;

    public SubmitCard(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "a_g_ctl00_c_repBillingSummary_ctl01_spTotalAmt")
    WebElement hours40;

    @FindBy(id = "a_SubmitButton")
    WebElement submit;

    public void check40HoursAndSubmit() {
        if (hours40.getText().contains("40")) {
            submit.click();
            //System.out.println("Submitted!");
            showMessageDialog(null, "Last week template used!");
        } else
            //System.out.print("Not 40 hours, not submitted!");
            showMessageDialog(null, "Not 40 hours, not used!");
    }
}
