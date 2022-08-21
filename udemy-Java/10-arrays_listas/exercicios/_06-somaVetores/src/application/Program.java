package application;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("How much numbers each vect will receive?: ");
        int n = input.nextInt();

        int[] vectA = new int[n];
        int[] vectB = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.printf("Type the value %d of vect A: ", i + 1);
            vectA[i] = input.nextInt();
        }

        for (int i = 0; i < n; i++) {
            System.out.printf("Type the value %d of vect B: ", i + 1);
            vectB[i] = input.nextInt();
        }

        System.out.println("Result:");
        for (int i = 0; i < n; i++) {
            int sum = vectA[i] + vectB[i];
            System.out.printf("calc of %d: %d%n",i + 1, sum);
        }



        input.close();
    }
}
