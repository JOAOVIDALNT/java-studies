package application;

import java.util.Locale;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner input = new Scanner(System.in);

        System.out.println("How many numbers to write?: ");
        int n = input.nextInt();

        double[] vect = new double[n];

        for (int i = 0; i < vect.length; i++) {
            System.out.print("Type a number: ");
            double number = input.nextDouble();

            vect[i] = number;
        }

            double sum = 0.0;

            System.out.print("VALUES: ");
        for (int i = 0; i < vect.length; i++) {
            System.out.printf("%.2f%n ", vect[i]);
            sum += vect[i];
        }

        double avg = sum / vect.length;

        System.out.printf("SUM: %.2f%n", sum);
        System.out.printf("AVERAGE: %.2f%n", avg);






        input.close();
    }
}
