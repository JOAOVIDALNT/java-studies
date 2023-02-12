
package application;

import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner input = new Scanner(System.in);

        System.out.println("How many students will be typed?: ");
        int n = input.nextInt();

        String[] name = new String[n];
        double[] grade1 = new double[n];
        double[] grade2 = new double[n];

        for (int i = 0; i < n; i++) {
            System.out.printf("Type: name, first and second grade of student %d%n", i + 1);

            System.out.print("Name: ");
            input.nextLine();
            name[i] = input.nextLine();

            System.out.print("First grade: ");
            grade1[i] = input.nextDouble();

            System.out.print("Second grade: ");
            grade2[i] = input.nextDouble();
        }

        double avg = 0.0;
        int position = 0;

        System.out.println("APPROVED STUDENTS:");
        for (int i = 0; i < n; i++) {
            avg = (grade1[i] + grade2[i]) / 2;

            if (avg >= 6.0) {
                System.out.printf("%s%n", name[i]);
            }
        }


        input.close();
    }
}
