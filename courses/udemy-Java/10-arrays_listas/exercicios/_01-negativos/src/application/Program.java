package application;

import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);


        System.out.print("How many numbers to write?: ");
        int n = input.nextInt();

        if (n > 10) {
            System.out.println("MAXIMUM OF 10 NUMBERS");
        } else {

            int[] vect = new int[n];

            for (int i = 0; i < vect.length; i++) {

                System.out.print("Type a number: ");
                int number = input.nextInt();

                vect[i] = number;

            }


            System.out.println("NEGATIVE NUMBERS:");
            for (int i = 0; i < vect.length; i++)
                if ((vect[i]) < 0) {

                    System.out.println(vect[i]);
                }
        }





        input.close();
    }
}
