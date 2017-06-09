package cucumber.utility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class Utility {

    private Utility() {
        throw new IllegalStateException();
    }

    public static String getRandomString(int size) {
        return generateRandom("QWERTYUIOPASDFGHJKLZXCVBNM", size);
    }
    public static String getRandomInt(int size) {
        return generateRandom("123456789", size);
    }
    public static String getDate(String dateFormat, int daysToAdd) { return dateBuilder(dateFormat, daysToAdd); }

    private static String generateRandom(String characters, int count) {

        StringBuilder builder = new StringBuilder();

        while (count-- != 0) {
            int character = (int)(Math.random() * characters.length());
            builder.append(characters.charAt(character));
        }

        return builder.toString();
    }

    private static String dateBuilder(String dateFormat, int daysToAdd) {

        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, daysToAdd);

        return formatter.format(calendar.getTime());
    }
}