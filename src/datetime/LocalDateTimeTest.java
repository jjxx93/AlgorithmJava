package datetime;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by jiax on 2016/10/15.
 */
public class LocalDateTimeTest {
    public static void main (String[] args) {
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("LocalDateTime: " + localDateTime);
        System.out.println(localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")));
        System.out.println(localDateTime.getHour());
    }
}
