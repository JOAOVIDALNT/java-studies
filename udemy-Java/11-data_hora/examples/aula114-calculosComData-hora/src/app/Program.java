package app;

import java.time.Duration;
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

        LocalDateTime pastMonthLocalDateTime = dt01.minusMonths(1);
        LocalDateTime nextHourLocalDateTime = dt01.plusHours(1);
        // we also have plusMinutes, plusSeconds, plusNanos (for nano seconds)
        // as well we have day, weeks, month, years...

        Instant pastMinutesInstant = i01.minus(7, ChronoUnit.MINUTES);
        // ChronoUnit also have measures like decades, eras, centuries, miles, days, halfDays etc..


        System.out.println(pastMinutesInstant);

        Duration t1 = Duration.between(nextHourLocalDateTime, dt01);
        Duration t2 = Duration.between(pastMonthLocalDateTime, dt01);

        Duration t3 = Duration.between(pastWeekLocalDate.atTime(0, 0), d01.atTime(0,0));
        Duration t4 = Duration.between(pastWeekLocalDate.atStartOfDay(), d01.atStartOfDay()); // same thing
        // use .atTime or another at function to set LocalDate variables since they're not accepted w/ time

        Duration t5 = Duration.between(pastMinutesInstant, i01);

        System.out.println(t1);
        System.out.println(t2);

        System.out.println(t3);
        System.out.println(t4);
        System.out.println(t5);





    }
}
