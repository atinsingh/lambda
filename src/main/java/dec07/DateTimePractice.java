package dec07;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class DateTimePractice {
    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(date);
        Instant instant = Instant.now();
        System.out.println(instant);
        System.out.println("instant.atZone(ZoneId.of(\"America/New York\")) = " + instant.atZone(ZoneId.of("America/New_York")));

        LocalDate date1 = LocalDate.now();

        System.out.println(date1);
        System.out.println(date1.atTime(23, 0));

    }
}
