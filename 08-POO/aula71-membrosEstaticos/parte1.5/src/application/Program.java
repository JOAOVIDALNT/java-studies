package application;
import util.Calculator;

import java.util.Locale;
import java.util.Scanner;

public class Program {


    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        Calculator calc = new Calculator();

        System.out.print("Enter radius: ");
        double radius = sc.nextDouble();

        double c = calc.circumference(radius); // calc.
        double v = calc.volume(radius); // calc.

        System.out.printf("Circumference: %.2f%n", c);
        System.out.printf("Volume: %.2f%n", v);
        System.out.printf("PI: %.2f%n", calc.PI); // calc.

        sc.close();
    }


}

