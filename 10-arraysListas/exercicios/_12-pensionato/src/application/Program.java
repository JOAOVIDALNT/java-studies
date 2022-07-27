package application;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String name, email;
        int room;

        int[] rooms = new int[10];
        String[] names = new String[10];
        String[] emails = new String[10];


        System.out.println("How many rooms will be rented?: ");
        int n = input.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.printf("Rent #%d%n", i+1);
            System.out.print("Name: ");
            input.nextLine();
            name = input.nextLine();

            System.out.print("Email: ");
            email = input.nextLine();

            System.out.print("Room: ");
            room = input.nextInt();

            names[room] = name;
            emails[room] = email;
            rooms[room] = room;
        }

        System.out.println("Busy rooms: ");
        for (int i = 0; i < rooms.length; i++) {
            if (names[i] != null) {
                System.out.printf("%d: %s, %s \n", rooms[i], names[i], emails[i]);
            }
        }


        input.close();
    }
}
