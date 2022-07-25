package application;

import entities.Person;

import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner input = new Scanner(System.in);

        System.out.println("How much people to be typed?: ");
        int n = input.nextInt();

        Person[] vect = new Person[n];

        for (int i = 0; i < vect.length; i++) {
            System.out.println("Person data " + (i + 1));

            System.out.print("Name: ");
            String name = input.next();

            System.out.print("Age: ");
            int age = input.nextInt();

            System.out.print("Height: ");
            double height = input.nextDouble();

            vect[i] = new Person(name, age, height);
        }

        double heighttotal = 0.0;
        for (int i = 0; i < vect.length; i++) {
            heighttotal += vect[i].getHeight();
        }
        double avg = heighttotal / vect.length;

        int minorstotal = 0;
        for (int i = 0; i < vect.length; i++) {
            if (vect[i].getAge() < 16) {
                minorstotal++;
            }

        }
            double minorspercent;
            minorspercent = ((double)minorstotal / vect.length) * 100.0;

            System.out.printf("Average height: %.2f%n", avg);
            System.out.printf("Under 16 years old: %.2f%n", minorspercent);




            for (int i = 0; i < vect.length; i++) {
                if (vect[i].getAge() < 16) {
                    System.out.printf("%s", vect[i].getName());
                }
            }
        input.close();
    }
}
