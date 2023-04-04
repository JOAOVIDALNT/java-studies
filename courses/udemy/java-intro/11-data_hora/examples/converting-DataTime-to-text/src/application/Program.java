package application;

import javax.swing.*;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Program {
    public static void main(String[] args) {

        LocalDate d01 = LocalDate.parse("2022-08-03");
        LocalDateTime dt01 = LocalDateTime.parse("2022-08-03T20:36");
        Instant i01 = Instant.parse("2022-08-03T20:36:20Z");

        // https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/time/format/DateTimeFormatter.html
        DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        DateTimeFormatter fmt2 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        /* fmt3 - usado para formatar o instant pois ele requer o fuso horário desejado*/
        DateTimeFormatter fmt3 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm").withZone(ZoneId.systemDefault());

        DateTimeFormatter fmt4 = DateTimeFormatter.ISO_DATE_TIME;
        DateTimeFormatter fmt5 =  DateTimeFormatter.ISO_INSTANT;

        System.out.println("d01 = " + d01.format(fmt1));
        System.out.println("d01 = " + fmt1.format(d01));
        System.out.println("d01 = " + d01.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));

        System.out.println("dt01 = " + dt01.format(fmt1));
        System.out.println("dt01 = " + dt01.format(fmt2));

        System.out.println("i01 = " + fmt3.format(i01)); // chama o formato através do fmt pois Instant não possui a função
        // o sistema vai imprimir -03:00 pois o local padrão Z era o gmt padrão (londres)

        System.out.println("fmt5 = " + fmt5.format(i01));

    }
}
