import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static javax.swing.JOptionPane.showMessageDialog;

// Final submission
public class FinalSubmitCard {
    WebDriver driver;

    public FinalSubmitCard(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "lBtnSubmit")
    WebElement finalSubmitButton;

    public void finalSubmit() {
        finalSubmitButton.click();
        showMessageDialog(null, "Submitted!");
    }
}

