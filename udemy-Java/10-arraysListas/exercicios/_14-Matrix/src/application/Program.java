package application;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("How many lines and columns?: ");
        int n = sc.nextInt();

        int[][] matrix = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        System.out.print("Main Diagonal: ");
        for (int i = 0; i<n; i++) {
            System.out.printf("%d ", matrix[i][i]);
        }

        int count = 0;
        for (int i = 0; i<n; i++) {
            for (int j = 0; j<n; j++) {
                if(matrix[i][j] < 0) {
                    count++;
                }
            }
        }
        System.out.println();
            System.out.printf("Negative numbers: %d%n", count);



        sc.close();
    }
}
