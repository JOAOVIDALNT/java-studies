package application;
import util.Calculator;

import java.util.Locale;
import java.util.Scanner;

public class Program {


    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        /* Calculator calc = new Calculator(); -> Membros estáticos não precisam ser instanciados basta usar o nome da classe*/

        System.out.print("Enter radius: ");
        double radius = sc.nextDouble();

        double c = Calculator.circumference(radius); // Calculator
        double v = Calculator.volume(radius); // Calculator

        System.out.printf("Circumference: %.2f%n", c);
        System.out.printf("Volume: %.2f%n", v);
        System.out.printf("PI: %.2f%n", Calculator.PI); // Calculator

        sc.close();
    }


}

