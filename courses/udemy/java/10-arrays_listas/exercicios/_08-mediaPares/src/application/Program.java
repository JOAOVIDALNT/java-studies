package application;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("How much elements to be typed?: ");
        int n = input.nextInt();

        int[] vect = new int[n];

        for (int i = 0; i < vect.length; i++) {
            System.out.print("Type a number: ");
            vect[i] = input.nextInt();
        }
        int paircount = 0;
        int initavg = 0;

        for (int i = 0; i < vect.length; i++) {
            if (vect[i] % 2 == 0) {
                initavg += vect[i];
                paircount++;
            }
        }
        double avg;


        if (paircount == 0) {
            System.out.println("NO PAIR NUMBERS");
        } else {
            avg = (double)initavg / paircount;
            System.out.printf("PAIR AVERAGE: %.2f", avg);
        }

        input.close();
    }
}
