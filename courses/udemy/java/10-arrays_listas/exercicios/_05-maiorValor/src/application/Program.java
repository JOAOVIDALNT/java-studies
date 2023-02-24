package application;

import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner input = new Scanner(System.in);

        System.out.print("How much numbers to type?: ");
        int n = input.nextInt();

        double[] vect = new double[n];

        for (int i = 0; i < vect.length; i++) {
            System.out.print("Type a number: ");
            vect[i] = input.nextDouble();
        }

        double highest = vect[0];
        int highestpos = 0;

        for (int i = 0; i < vect.length; i++) {
            if (vect[i] > highest ) {
            highest = vect[i];
            highestpos = i + 1;
            }
        }

        System.out.printf("Highest value: %.2f%n", highest);
        System.out.printf("Highest value position: %d%n", highestpos);



        input.close();
    }
}
