package playground.java8;

import java.time.*;

public class DatesAndTimes {
    public static void main(String[] args) {
        LocalTime time = LocalTime.now();
        System.out.println(time);
        LocalDate date = LocalDate.now();
        System.out.println(date);
        LocalDateTime dateTime = LocalDateTime.now();
        System.out.println(dateTime);
        OffsetDateTime dateTime1 = OffsetDateTime.now();
        System.out.println(dateTime1);
        ZoneId zoneId = ZoneId.of("UTC");
        dateTime1 = OffsetDateTime.now(zoneId);
        System.out.println(dateTime1);
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        System.out.println(zonedDateTime);
    }
}
