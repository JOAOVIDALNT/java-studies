package application;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class Program {
    public static void main(String[] args) {

        LocalDate d01 = LocalDate.parse("2022-08-03");
        LocalDateTime dt01 = LocalDateTime.parse("2022-08-03T20:36");
        Instant i01 = Instant.parse("2022-08-03T01:36:20Z");

        LocalDate r1 = LocalDate.ofInstant(i01, ZoneId.systemDefault());
        LocalDate r2 = LocalDate.ofInstant(i01, ZoneId.of("Portugal"));
        LocalDateTime r3 = LocalDateTime.ofInstant(i01, ZoneId.systemDefault());
        LocalDateTime r4 = LocalDateTime.ofInstant(i01, ZoneId.of("Portugal"));

        System.out.println("r1 = " + r1); /* vai imprimir o dia anterior, pois o fuso do systemDefault em relação
        ao gmt é de -03:00 */
        System.out.println("r2 = " + r2);

        System.out.println("r3 = " + r3);
        System.out.println("r4 = " + r4);

        System.out.println("d01 dia = " + d01.getDayOfMonth());
        System.out.println("d01 mês = " + d01.getMonthValue());
        System.out.println("d01 ano = " + d01.getYear());

        System.out.println("dt01 hora = " + dt01.getHour());
        System.out.println("dt01 minuto = " + dt01.getMinute());




//            for (String x : ZoneId.getAvailableZoneIds()) {
//            System.out.println(x); // imprime todos os zoneIds disponíveis ex:"America/Sao_Paulo" 600+ ids
//        }


    }
}
