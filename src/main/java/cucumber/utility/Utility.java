package cucumber.utility;

import org.apache.commons.lang3.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

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

  public static String getDate(String dateFormat, int daysToAdd) {
    return dateBuilder(dateFormat, daysToAdd);
  }

  private static String generateRandom(String characters, int size) {

    StringBuilder builder = new StringBuilder();
    Random random = new Random();
    int count = size;

    while (count-- != 0) {
      int character = (random.nextInt() * characters.length());
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

  public static String toCamelCase(String string) {
    String[] lines = StringUtils.split(string, " ");
    lines[0] = lines[0].toLowerCase();
    return StringUtils.join(lines);
  }
}
