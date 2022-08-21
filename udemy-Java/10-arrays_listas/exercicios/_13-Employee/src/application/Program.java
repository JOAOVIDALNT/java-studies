package application;

import entities.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner input = new Scanner(System.in);

        System.out.print("How many employees will be registred?: ");
        int n = input.nextInt();

        List<Employee> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            System.out.printf("Employee #%d%n", i+1);
            System.out.print("ID: ");
            Integer id = input.nextInt();
            while (hasId(list, id)) {
                System.out.println("Id already taken! try again" );
                id = input.nextInt();
            }


            System.out.print("Name: ");
            input.nextLine();
            String name = input.nextLine();
            System.out.print("Salary: ");
            Double salary = input.nextDouble();

            Employee employee = new Employee(id, name, salary);

            list.add(employee);
        }

        System.out.println("Enter the employee id that will have salary increase: ");
        int idToIncrease = input.nextInt();


        Employee employee = list.stream().filter(x -> x.getId() == idToIncrease).findFirst().orElse(null);

//        Integer pos = position(list, idToIncrease);

        if (employee == null) {
            System.out.println("This id doesn't exist!");
        } else {
            System.out.print("Enter the percentage: ");
            double percent = input.nextDouble();
            employee.SalaryIncrease(percent);
//            list.get(pos).SalaryIncrease(percent);
        }

        System.out.println("List of employees: ");
        for (Employee emp : list) {
            System.out.println(emp);
        }

        input.close();
    }

    public static Integer position(List<Employee> list, int id) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == id) {
                return i;
            }
        }
            return null; // só é possivel pois a função é Integer, se for int return -1
    }

    public static boolean hasId(List<Employee> list, int id) {
        Employee employee = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
        return employee != null;
    }
}