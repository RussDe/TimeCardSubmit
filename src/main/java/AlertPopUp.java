import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

//Show JavaScript alert on the browser
public class AlertPopUp {
    WebDriver driver;

    public AlertPopUp(WebDriver driver) {
        this.driver = driver;
    }

    public void show(String text) throws InterruptedException {
        //Generating Alert Using Javascript Executor
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("function showAlert() { alert('" + text + "'); }; showAlert()");
        Thread.sleep(5000);
        //driver.switchTo().alert().accept();
    }
}
