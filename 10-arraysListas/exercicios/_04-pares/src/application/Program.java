package application;


import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("How many numbers to type?: ");
        int n = input.nextInt();

        int[] vect = new int[n];


        for ( int i = 0; i < vect.length; i++ ) {
            System.out.print("Type a number: ");
            int num = input.nextInt();

            vect[i] = num;
        }

        System.out.println("Pair numbers:");
        for (int i=0; i< vect.length; i++) {
            if (vect[i] % 2 == 0) {
                System.out.printf("%d ", vect[i]);
            }
        }
        System.out.println();
        System.out.println("Pair numbers count: ");
        int pairnumbers = 0;
        for (int i=0; i< vect.length; i++) {
            if (vect[i] % 2 == 0) {
                pairnumbers++;
            }
        }
        System.out.printf("%d ", pairnumbers);


        input.close();
    }
}
