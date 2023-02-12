package application;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

                Locale.setDefault(Locale.US);
                Scanner sc = new Scanner(System.in);


                System.out.println("Enter measures for the triangle X:");
                double xA = sc.nextDouble();
                double xB = sc.nextDouble();
                double xC = sc.nextDouble();

                System.out.println("Enter measures for the triangle Y:");
                double yA = sc.nextDouble();
                double yB = sc.nextDouble();
                double yC = sc.nextDouble();

                double p = (xA + xB + xC) / 2.0;
                double areaX = Math.sqrt(p * (p - xA) * (p - xB) * (p - xC));

                p = (yA + yB + yC) / 2.0;
                double areaY = Math.sqrt(p * (p - yA) * (p - yB) * (p - yC));


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