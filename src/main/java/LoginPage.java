import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//Navigate to login page
public class LoginPage {
    WebDriver driver;
    int tets;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "txtUserName")
    WebElement username;

    @FindBy(name = "txtPassword")
    WebElement password;

    @FindBy(name = "lBtnLogin")
    WebElement loginButton;

    //Set user name in input field
    public void setUsername(String user) {
        username.sendKeys(user);
    }

    //Set password in input field
    public void setPassword(String pass) {
        password.sendKeys(pass);
    }

    //Login as a user clicking on button
    public void login() {
        loginButton.click();
    }
}
