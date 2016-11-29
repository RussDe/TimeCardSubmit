import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static javax.swing.JOptionPane.showMessageDialog;

public class TimeCardSubmit {

    public static void main(String[] args) throws ParseException, InterruptedException {
        //Define the date format
        DateFormat dateFormat = new SimpleDateFormat("M/d/yyyy");

        //Create a new instance of a Chrome driver
        WebDriver driver = new ChromeDriver();
        //Create an instance for alert messages
        AlertPopUp alert = new AlertPopUp(driver);

        //Navigate to the login page
        String URL = "https://timeandexpense.allegisgroup.com/Webtime/Login.aspx";
        driver.get(URL);

        //Setup username and password
        String username = "rustem75@mail.com";
        String password = "";

        //Login to the page
        LoginPage lp = new LoginPage(driver);
        lp.setUsername(username);
        lp.setPassword(password);
        lp.login();

        //create an instance of Navigation class
        Navigation nav = new Navigation(driver);

        //Find last time card date
        //Navigate to home menu
        nav.homeMenu();
        TimeCardsLast timeCard = new TimeCardsLast(driver);
        String lastTimeCard = timeCard.findLastTimeCard();
        //alert.show("Last time card was submitted on: " + lastTimeCard);
        showMessageDialog(null, "Last time card was submitted on: " + lastTimeCard);
        Date timeCardSubmitted = dateFormat.parse(lastTimeCard);

        //Compare time card date and current date
        CompareDates dateCompare = new CompareDates();
        if (dateCompare.needToSubmit(timeCardSubmitted, 6)) {
            //alert.show("You need to submit a new time card!");
            showMessageDialog(null, "You need to submit a new time card!");

            //Click on time card menu
            nav.timeCardsMenu();
            SubmitNewCard newSubmit = new SubmitNewCard(driver);
            Calendar cal = Calendar.getInstance();
            cal.setTime(timeCardSubmitted);
            cal.add(Calendar.DAY_OF_YEAR, 7);

            //Use last time card as a template
            if (newSubmit.selectDate(dateFormat.format(cal.getTime()))) {
                UseLastWeekTimeCard lastWeek = new UseLastWeekTimeCard(driver);
                lastWeek.clickUseLastWeek();

                //Check for 40 hours and submit the time card - "Submitted for approval"
                SubmitCard submit = new SubmitCard(driver);
                submit.check40HoursAndSubmit();

                //Final submission - "Submit"
                FinalSubmitCard fSubmit = new FinalSubmitCard(driver);
                fSubmit.finalSubmit();

                //Check if submission is done successfully
                TimeCardsLast newSubmitFinal = new TimeCardsLast(driver);
                String approved = "Final Manager Approved";
                String result = newSubmitFinal.lastTimeCardSubmittedSuccessful(dateFormat.format(timeCardSubmitted), approved) ? "Submission is successful" : "Submitting is NOT successful";
                showMessageDialog(null, result);
            } else {
                //alert.show("Date NOT found in drop down menu, not submitted!");
                showMessageDialog(null, "Date NOT found in drop down menu, not submitted!");
            }
        } else {
            //alert.show("You don't need to submit a time card!");
            showMessageDialog(null, "You don't need to submit a time card!");
        }
        //driver.quit();
    }
}