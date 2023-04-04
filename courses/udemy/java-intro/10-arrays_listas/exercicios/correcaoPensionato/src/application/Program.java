package application;

import entities.Rent;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Rent[] vect = new Rent[10];

        System.out.print("How many rooms will be rented?: ");
        int n = input.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.printf("Rent #%d %n", i+1);
            System.out.print("Name: ");
            input.nextLine();
            String name = input.nextLine();

            System.out.print("Email: ");
            String email = input.next();

            System.out.print("Room: ");
            int roomId = input.nextInt();

            Rent rent = new Rent(name, email);
            vect[roomId] = rent;
            //ou
            // vect[roomId] = new Rent(name,email);
        }

        System.out.println("Busy rooms: ");
        for (int i = 0; i < vect.length; i++) {
            if (vect[i] != null ) {
                System.out.println(i + ": " + vect[i]);

            }
        }




        input.close();
    }
}
