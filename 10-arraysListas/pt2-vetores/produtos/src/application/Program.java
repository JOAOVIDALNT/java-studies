package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Product;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Product[] vect = new Product[n];
        /* TIPO REFERÊNCIA RETORNA PRINCIPIO NULO */

        for (int i=0; i < vect.length; i++) {  // no lugar de 'n' pode-se usar vect.length
           sc.nextLine(); // consumir o scanner anterior
           String name = sc.nextLine();
           double price = sc.nextDouble();

           vect[i] = new Product(name, price);
        }

        double sum = 0.0;

        for (int i=0; i < vect.length; i++) {
            sum += vect[i].getPrice();
        }

        double avg = sum / vect.length;

        System.out.printf("AVARAGE PRICE = %.2f%n", avg);

        sc.close();
    }
}
