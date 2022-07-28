package application;

import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner input = new Scanner(System.in);

        System.out.println("How many people to be typed?: ");
        int n = input.nextInt();

        char[] gender = new char[n];
        double[] height = new double[n];

        double small = 0, tall = 0, wavg = 0;
        int mancount = 0, womancount = 0;

        for (int i = 0; i < n; i++) {
            System.out.printf("Person %d height: ", i+1);
            height[i] = input.nextDouble();

            System.out.printf("Person %d gender: ", i+1);
            gender[i] = input.next().charAt(0);

            if (gender[i] == 'm') {
                mancount++;
            } else {
                womancount++;
                wavg += height[i];
            }
        }

        double wfavg = wavg / womancount;

        tall = height[0];
        small = height[0];

        for (int i = 0; i < n; i++) {
            if (height[i] > tall) {
                tall = height[i];
            }
            else if (height[i] < small) {
                small = height[i];
            }
        }

        System.out.printf("Smaller: %.2f%n", small);
        System.out.printf("Taller: %.2f%n", tall);

        System.out.printf("Woman average height: %.2f%n", wfavg);

        System.out.printf("Quanity of mens: %d", mancount);


        input.close();
    }
}
