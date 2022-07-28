package application;

import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner input = new Scanner(System.in);

        System.out.println("How much elements will be typed?: ");
        int n = input.nextInt();

        double[] vect = new double[n];


        double media = 0.0;

        for (int i = 0; i < vect.length; i++ ) {
            System.out.print("Type a number: ");
            vect[i] = input.nextDouble();

            media += vect[i];
        }

        double avg = media / n;

        System.out.printf("VECTOR AVERAGE: %.3f%n", avg);

        System.out.println("ELEMENTS BELOW AVERAGE: ");
        for (int i = 0; i < vect.length; i++) {

            if (vect[i] < avg) {
                System.out.printf("%.1f%n", vect[i]);

            }

        }



        input.close();
    }
}
