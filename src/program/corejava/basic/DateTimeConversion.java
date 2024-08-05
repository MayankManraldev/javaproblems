package program.corejava.basic;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

public class DateTimeConversion {
    public static void main(String[] args) {
        String format = LocalTime.parse("01:00:00PM", DateTimeFormatter.ofPattern("hh:mm:ssa", Locale.US))
                .format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        System.out.println(format);
        String dateTime = LocalDateTime.parse("04/08/24 11:18:21AM", DateTimeFormatter.ofPattern("dd/MM/yy hh:mm:ssa", Locale.US))
                .format(DateTimeFormatter.ofPattern("dd/MMM/yyyy HH:mm:ss"));
        System.out.println(dateTime);

        System.out.println(DateConversion("04/08/24 11:18:21AM"));

    }

    public static String timeConversion(String s) {
        SimpleDateFormat displayFormat = new SimpleDateFormat("HH:mm:ss");
        SimpleDateFormat parseFormat = new SimpleDateFormat("hh:mm:ssa");
        Date date = null;
        try {
            date = parseFormat.parse(s);

        } catch (Exception e) {

        }
        return displayFormat.format(date);
    }

    public static String DateConversion(String s) {
        SimpleDateFormat displayFormat = new SimpleDateFormat("dd/MMM/yyyy HH:mm:ss");
        SimpleDateFormat parseFormat = new SimpleDateFormat("dd/MM/yy hh:mm:ssa");
        Date date = null;
        try {
            date = parseFormat.parse(s);

        } catch (Exception e) {

        }
        return displayFormat.format(date);
    }
}
