import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

//compare current date and last time card date
public class CompareDates {
    public boolean needToSubmit(Date timeCardDate, int daysToCompare) throws ParseException {

        Date date = new Date();
        if (getDiffDays(timeCardDate, date) >= daysToCompare) {
            return true;
        } else return false;
    }

    public static long getDiffDays(Date d1, Date d2) {
        long diff = d2.getTime() - d1.getTime();
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    }
}
