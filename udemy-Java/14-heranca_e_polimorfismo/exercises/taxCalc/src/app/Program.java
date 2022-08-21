package app;

import entities.CompanyPerson;
import entities.IndividualPerson;
import entities.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of tax payers: ");
        int n = sc.nextInt();

        List<Person> personList = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            System.out.printf("Tax payer #%d data:\n", i);

            System.out.print("Individual or company (i/c)?: ");
            char x = sc.next().charAt(0);

            System.out.print("Name: ");
            sc.nextLine();
            String name = sc.nextLine();

            System.out.print("Anual income: ");
            double anualIncome = sc.nextDouble();

            if (x == 'i') {
                System.out.print("Health expenditures: ");
                double healthExpend = sc.nextDouble();
                personList.add(new IndividualPerson(name, anualIncome, healthExpend));
            } else if (x == 'c') {
                System.out.print("Number of employees: ");
                int employees = sc.nextInt();
                personList.add(new CompanyPerson(name, anualIncome, employees));
            } else {
                System.out.println("Invalid character");
            }
        }
        System.out.println();
        System.out.println("TAXES PAID:");

        for (Person person : personList) {
            System.out.println(person.getName() + ": R$" + String.format("%.2f", person.taxCalc()));
        }
        double sum = 0.0;
        for (Person person : personList) {
            sum += person.taxCalc();
        }
        System.out.println();
        System.out.printf("TOTAL TAXES = R$%.2f", sum);


        sc.close();
    }
}
