package app;

import entities.Employee;
import entities.OutsourcedEmployee;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of employees: ");
        int n = sc.nextInt();

        List<Employee> employeeList = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            System.out.printf("Employee #%d data \n", (i+1));

            System.out.print("Outsourced (y/n)?: ");
            char x = sc.next().charAt(0);

            System.out.print("Name: ");
            sc.nextLine();
            String name = sc.nextLine();

            System.out.print("Hours: ");
            int hours = sc.nextInt();

            System.out.print("Value per hour: ");
            double valuePerHour = sc.nextDouble();

            if (x == 'y') {
                System.out.print("Additional charge: ");
                double additionalCharge = sc.nextDouble();

                employeeList.add(new OutsourcedEmployee(name, hours, valuePerHour, additionalCharge));
            } else {
                employeeList.add(new Employee(name, hours, valuePerHour));
            }
        }

        for (Employee emp : employeeList) {
            System.out.println(emp.getName() + ", R$" + String.format("%.2f", emp.payment()));
        }

        sc.close();
    }
}
