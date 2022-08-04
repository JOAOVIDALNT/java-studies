package app;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Program {
    public static void main(String[] args) {

        LocalDate d01 = LocalDate.parse("2022-08-03");
        LocalDateTime dt01 = LocalDateTime.parse("2022-08-03T20:36");
        Instant i01 = Instant.parse("2022-08-03T01:36:20Z");

        LocalDate pastWeekLocalDate = d01.minusWeeks(1);
        LocalDate nextWeekLocalDate = d01.plusWeeks(1);
        //                               .plusDays / .minusDays / Months, Years...
//        System.out.println(pastWeekLocalDate);
//        System.out.println(nextWeekLocalDate);


        LocalDateTime nextHourLocalDateTime = dt01.plusHours(1);
        // we also have plusMinutes, plusSeconds, plusNanos (for nano seconds)
        // as well we have day, weeks, month, years...

        Instant pastMinutesInstant = i01.minus(7, ChronoUnit.MINUTES);
        // ChronoUnit also have measures like decades, eras, centuries, miles, days, halfDays etc..


        System.out.println(pastMinutesInstant);






    }
}
