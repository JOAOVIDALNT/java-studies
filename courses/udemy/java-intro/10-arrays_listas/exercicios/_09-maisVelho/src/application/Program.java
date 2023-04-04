package application;


import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("How many persons to be typed?: ");
        int n = input.nextInt();

        String[] name = new String[n];
        int[] age = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.printf("Person %d data: ", i+1);

            System.out.print("Name: ");
            name[i] = input.next();

            System.out.print("Age: ");
            age[i] = input.nextInt();
        }
        int oldest = age[0];
        int highest = 0;

        for (int i = 0; i < n; i++) {
            if (age[i] > oldest) {
                oldest = age[i];
                highest = i;
            }
        }

        System.out.printf("OLDEST PERSON: %s%n", name[highest]);



        input.close();
    }
}
