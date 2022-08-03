package application;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Program {
    public static void main(String[] args) {

        // PADRÔES
        LocalDate d01 = LocalDate.now(); // Instancia data padrão da maquina
        LocalDateTime d02 = LocalDateTime.now();
        Instant d03 = Instant.now(); // instancia data padrão gmt ou z (horário de londres)

        // PARSE - converte o texto através de função para date-time
        LocalDate d04 = LocalDate.parse("2022-07-20");
        LocalDateTime d05 = LocalDateTime.parse("2000-01-13T14:00:13");
        Instant d06 = Instant.parse("2022-08-03T12:00:00Z");
        Instant d07 = Instant.parse("2022-08-03T12:00:00-03:00");

        // Date time formatter possui varias propriedades para alterar o formato da data
        // https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/time/format/DateTimeFormatter.html
        DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate d08 = LocalDate.parse("13/01/2022", fmt1); // recebe o formater como segundo argumento

        DateTimeFormatter fmt2 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        LocalDateTime d09 = LocalDateTime.parse("04/09/2022 02:00", fmt2);
        /* o formater também pode ser utilizado direto como segundo argumento */

        LocalDate d10 = LocalDate.of(2022, 8, 02);
        LocalDateTime d11 = LocalDateTime.of(2022, 8, 03, 20, 18);


        System.out.println("d01 = "+ d01.toString());
        /* o print adiciona automáticamente a propriedade toString() para o objeto em questão */
        System.out.println("d02 = "+ d02);
        System.out.println("d03 = "+ d03);
        System.out.println("d04 = "+ d04);
        System.out.println("d05 = "+ d05);
        System.out.println("d06 = "+ d06);
        System.out.println("d07 = "+ d07);
        System.out.println("d08 = "+ d08);
        System.out.println("d09 = "+ d09);
        System.out.println("d10 = "+ d10);
        System.out.println("d11 = "+ d11);
    }
}
