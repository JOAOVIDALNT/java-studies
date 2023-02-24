package application;

import entities.Employee;

import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        Employee employee = new Employee();

        System.out.print("Enter employee name: ");
        employee.name = sc.nextLine();

        System.out.print("Enter the gross salary: ");
        employee.grossSalary = sc.nextDouble();

        System.out.print("Define the tax: ");
        employee.tax = sc.nextDouble();

        System.out.println(employee);

        System.out.print("Wich percentage to increase salary? ");
        double percentag = sc.nextDouble();
        employee.increaseSalary(percentag); /* não precisa ter o mesmo nome,
         basta a função receber um argumento do mesmo tipo*/

        System.out.println();
        System.out.println("Updated data: " + employee);




        sc.close();
    }
}
