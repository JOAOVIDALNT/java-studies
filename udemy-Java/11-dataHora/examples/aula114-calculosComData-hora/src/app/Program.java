package app;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Program {
    public static void main(String[] args) {

        LocalDate d01 = LocalDate.parse("2022-08-03");
        LocalDateTime dt01 = LocalDateTime.parse("2022-08-03T20:36");
        Instant i01 = Instant.parse("2022-08-03T01:36:20Z");

        LocalDate pastWeekLocalDate = d01.minusWeeks(1);

        System.out.println(pastWeekLocalDate);



    }
}
