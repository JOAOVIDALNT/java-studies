package application;

import util.CurrencyConverter;

import java.util.Locale;
import java.util.Scanner;



public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("What is the dollar price? ");
        CurrencyConverter.price = sc.nextDouble();

        System.out.print("How many dollar will be bought? ");
        CurrencyConverter.dollar = sc.nextDouble();

        System.out.printf("Amount to be paid in reais = %.2f%n", CurrencyConverter.increase());




        sc.close();
    }
}
