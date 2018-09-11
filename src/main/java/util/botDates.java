package util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class botDates {
    private static DateFormat dateF = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    private static Date date = new Date();

    public static String getDate() {
        return "[" + dateF.format(date) + "]: ";
    }
}
