package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Triangle;

public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        Triangle x, y; // instead of all double xA, xB, xC
        x = new Triangle(); // alocação dinâmica de memória (heap) | x = (endereço) -> heap (class triangle)
        y = new Triangle();

        System.out.println("Enter measures for the triangle X:");
        x.a = sc.nextDouble();
        x.b = sc.nextDouble();
        x.c = sc.nextDouble();

        System.out.println("Enter measures for the triangle Y:");
        y.a = sc.nextDouble();
        y.b = sc.nextDouble();
        y.c = sc.nextDouble();

        double areaX = x.area();

        double areaY = y.area();


        System.out.printf("Triangle X area: %.4f%n", areaX);
        System.out.printf("Triangle Y area: %.4f%n", areaY);

        if (areaX > areaY) {
            System.out.println("Larger area: X");
        } else if (areaY > areaX) {
            System.out.println("Larger area: Y");
        } else {
            System.out.println("equal");
        }


        sc.close();
    }
}