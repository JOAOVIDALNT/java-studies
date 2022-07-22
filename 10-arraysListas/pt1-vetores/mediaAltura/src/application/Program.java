package application;

import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double[] vect = new double[n]; /* Cria um vetor, o 'n' define a
        quantidade de elementos no vetor e double define o tipo. */

        for (int  i = 0; i < n; i++) {
            vect[i] = sc.nextDouble(); /* Váriavel i começa na posição zero,
            logo a posição no vect vai corresponder. */
        }

        double sum = 0.0;

        for (int i = 0; i < n; i++) {
            sum += vect[i];
        }

        double avg = sum / n;

        System.out.printf("AVARAGE HEIGHT = %.2f%n", avg);




        sc.close();
    }
}
